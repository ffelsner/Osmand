package net.osmand.osm;

import gnu.trove.list.array.TIntArrayList;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import net.osmand.data.AmenityType;
import net.osmand.osm.OSMSettings.OSMTagKey;
import net.osmand.LogUtil;

import org.apache.commons.logging.Log;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


/**
 * SOURCE : http://wiki.openstreetmap.org/wiki/Map_Features
 * 
 * Describing types of polygons :
 * 1. Last 2 bits define type of element : polygon, polyline, point 
 */
public class MapRenderingTypes {

	private static final Log log = LogUtil.getLog(MapRenderingTypes.class);
	
	/** standard schema :	 
	 	polygon : ll aaaaa ttttt 11 : 14 bits
	 	multi   : ll aaaaa ttttt 00 : 14 bits  
				    t - object type, a - area subtype,l - layer
		polyline :   ll ppppp ttttt 10 : 14 bits  
				   t - object type, p - polyline object type, l - layer 
		point :   ssss ssss ttttt 10 : 15 bits  
				   t - object type, s - subtype
	 */

	// keep sync ! not change values
	public final static int MULTY_POLYGON_TYPE = 0;
	public final static int POLYGON_TYPE = 3;
	public final static int POLYLINE_TYPE = 2;
	public final static int POINT_TYPE = 1;
	
	private static char TAG_DELIMETER = '/'; //$NON-NLS-1$
	
	private String resourceName = null;

	// stored information to convert from osm tags to int type
	private Map<String, MapRulType> types = null;
	
	private Map<AmenityType, Map<String, String>> amenityTypeNameToTagVal = null;
	private Map<String, AmenityType> amenityNameToType = null;
	
	public MapRenderingTypes(String fileName){
		this.resourceName = fileName;
	}
	
	
	private static MapRenderingTypes DEFAULT_INSTANCE = null;
	
	public static MapRenderingTypes getDefault() {
		if(DEFAULT_INSTANCE == null){
			DEFAULT_INSTANCE = new MapRenderingTypes(null);
		}
		return DEFAULT_INSTANCE;
	}

	public Map<String, MapRulType> getEncodingRuleTypes(){
		if (types == null) {
			types = new LinkedHashMap<String, MapRulType>();
			init();
		}
		return types;
	}
	
	
	// if type equals 0 no need to save that point
	public int encodeEntityWithType(Entity e, int zoom, boolean multipolygon, TIntArrayList types) {
		Map<String, MapRulType> rules = getEncodingRuleTypes();
		types.clear();
		if ("coastline".equals(e.getTag(OSMTagKey.NATURAL))) { //$NON-NLS-1$
			multipolygon = false;
		}

		boolean point = e instanceof Node;
		boolean polygon = multipolygon || "yes".equals(e.getTag("area"));
		if (!point && !polygon) {
			// determining area or path
			boolean highway = e.getTag("highway") != null; //$NON-NLS-1$
			if (!highway) {
				List<Long> ids = ((Way) e).getNodeIds();
				if (ids.size() > 1) {
					polygon = ((long) ids.get(0) == (long) ids.get(ids.size() - 1));
				}
			}
		}

		Collection<String> tagKeySet = e.getTagKeySet();
		int type = -1;
		for (String tag : tagKeySet) {
			String val = e.getTag(tag);
			MapRulType rType = rules.get(constructRuleKey(tag, val));
			if (rType == null) {
				rType = rules.get(constructRuleKey(tag, null));
			}
			if (rType != null) {
				if (rType.minzoom > zoom) {
					continue;
				}
				boolean accept;
				if (point) {
					accept = rType.point;
				} else if (polygon) {
					accept = rType.point || rType.polygon;
				} else {
					accept = rType.polyline;
				}
				if (accept) {
					rType.freq++;
					types.add(rType.id);
					type = point ? POINT_TYPE : (polygon ? POLYGON_TYPE : POLYLINE_TYPE);
				}

			}
		}
		return type;
	}
	
	
	public String getNullName(Entity e) {
		Map<String, MapRulType> rules = getEncodingRuleTypes();
		for (int i = 0; i < 2; i++) {
			for (String tag : e.getTagKeySet()) {
				String val = i == 0 ? e.getTag(tag) : null;
				MapRulType rt = rules.get(constructRuleKey(tag, val));
				if(rt != null && rt.nameNullTag != null && e.getTag(rt.nameNullTag) != null) {
					return e.getTag(rt.nameNullTag);
				}
			}
		}
		return null;
	}
	
	public String getEntityName(Entity e) {
		String name = e.getTag(OSMTagKey.NAME);
		if (name == null) {
			name = e.getTag(OSMTagKey.NAME_EN);
			if(name == null) {
				name = getNullName(e);
			}
		}
		return name;
	}
	
	public Map<AmenityType, Map<String, String>> getAmenityTypeNameToTagVal() {
		if (amenityTypeNameToTagVal == null) {
			Map<String, MapRulType> types = getEncodingRuleTypes();
			amenityTypeNameToTagVal = new LinkedHashMap<AmenityType, Map<String, String>>();
			for(MapRulType type : types.values()){
				if(type.poiCategory != null && type.targetTagValue == null) {
					if(!amenityTypeNameToTagVal.containsKey(type.poiCategory)) {
						amenityTypeNameToTagVal.put(type.poiCategory, new LinkedHashMap<String, String>());
					}
					String name = type.value;
					if (name != null) {
						if (type.poiPrefix != null) {
							name = type.poiPrefix + name;
							amenityTypeNameToTagVal.get(type.poiCategory).put(name, type.tag + " " + type.value);
						} else {
							amenityTypeNameToTagVal.get(type.poiCategory).put(name, type.tag);
						}
					}
				}
			}
		}
		return amenityTypeNameToTagVal;
	}
	
	public Map<String, AmenityType> getAmenityNameToType(){
		if(amenityNameToType == null){
			amenityNameToType = new LinkedHashMap<String, AmenityType>();
			Map<AmenityType, Map<String, String>> map = getAmenityTypeNameToTagVal();
			Iterator<Entry<AmenityType, Map<String, String>>> iter = map.entrySet().iterator();
			while(iter.hasNext()){
				Entry<AmenityType, Map<String, String>> e = iter.next();
				for(String t : e.getValue().keySet()){
					if (t != null) {
						if (amenityNameToType.containsKey(t)) {
							System.err.println("Conflict " + t + " " + amenityNameToType.get(t) + " <> " + e.getKey());
						}
						amenityNameToType.put(t, e.getKey());
					}
				}
			}
		}
		return amenityNameToType; 
	}
	
	private void init(){
		InputStream is;
		try {
			if(resourceName == null){
				is = MapRenderingTypes.class.getResourceAsStream("rendering_types.xml"); //$NON-NLS-1$
			} else {
				is = new FileInputStream(resourceName);
			}
			long time = System.currentTimeMillis();
			final SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
			types = new LinkedHashMap<String, MapRenderingTypes.MapRulType>();
			parser.parse(is, new DefaultHandler(){
				
				String poiParentCategory = null;
				String poiParentPrefix  = null;
				@Override
				public void startElement(String uri, String localName, String name, Attributes attributes) throws SAXException {
					name = parser.isNamespaceAware() ? localName : name;
					if(name.equals("category")){ //$NON-NLS-1$
						poiParentCategory = attributes.getValue("poi:category");
						poiParentPrefix = attributes.getValue("poi:prefix");
						String tag = attributes.getValue("poi:tag");
						if (tag != null) {
							MapRulType rtype = new MapRulType(types.size());
							rtype.poiCategory = AmenityType.valueOf(poiParentCategory.toUpperCase());
							rtype.poiSpecified = true;
							rtype.poiPrefix = poiParentPrefix;
							rtype.tag = tag;
							types.put(constructRuleKey(tag, null), rtype);
						}
					} else if (name.equals("type")) { //$NON-NLS-1$
						MapRulType rtype = new MapRulType(types.size());
						String val = attributes.getValue("minzoom"); //$NON-NLS-1$
						rtype.minzoom = 15;
						if (val != null) {
							rtype.minzoom = Integer.parseInt(val);
						}
						rtype.tag = attributes.getValue("tag"); //$NON-NLS-1$
						rtype.value = attributes.getValue("value"); //$NON-NLS-1$
						if (rtype.value != null && rtype.value.length() == 0) { //$NON-NLS-1$
							rtype.value = null;
						}
						String keyVal = constructRuleKey(rtype.tag, rtype.value);
						if(types.containsKey(keyVal)){
							throw new RuntimeException("Duplicate " + keyVal);
						}
						types.put(keyVal, rtype);
						
						rtype.polygon = Boolean.parseBoolean(attributes.getValue("polygon")); //$NON-NLS-1$
						rtype.polyline= Boolean.parseBoolean(attributes.getValue("polyline")); //$NON-NLS-1$
						rtype.point = Boolean.parseBoolean(attributes.getValue("point")); //$NON-NLS-1$
						rtype.additional = Boolean.parseBoolean(attributes.getValue("additional")); //$NON-NLS-1$
						rtype.nameNullTag = attributes.getValue("nameNullTag");
						String targetTag = attributes.getValue("target:tag");
						String targetValue = attributes.getValue("target:value");
						if (targetTag != null || targetValue != null) {
							if(targetTag == null){
								targetTag = rtype.tag;
							}
							if(targetValue == null){
								targetValue = rtype.value;
							}
							rtype.targetTagValue = types.get(constructRuleKey(targetTag, targetValue));
							if(rtype.targetTagValue == null){
								throw new RuntimeException("Illegal target tag/value " + targetTag + " " + targetValue);
							}
						}
						if(poiParentCategory != null){
							rtype.poiCategory = AmenityType.valueOf(poiParentCategory.toUpperCase());
							rtype.poiSpecified = true;
						}
						if(poiParentPrefix != null){
							rtype.poiPrefix = poiParentPrefix;
						}
						
						String poiCategory = attributes.getValue("poi:category");
						if(poiCategory != null){
							rtype.poiSpecified = true;
							if(poiCategory.length() == 0) {
								rtype.poiCategory = null;
							} else {
								rtype.poiCategory = AmenityType.valueOf(poiCategory.toUpperCase());
							}
						}
						String poiPrefix = attributes.getValue("poi:prefix");
						if(poiPrefix != null){
							rtype.poiPrefix = poiPrefix;
						}
					}
				}
			});
			log.info("Time to init " + (System.currentTimeMillis() - time)); //$NON-NLS-1$
			is.close();
		} catch (IOException e) {
			log.error("Unexpected error", e); //$NON-NLS-1$
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (RuntimeException e) {
			log.error("Unexpected error", e); //$NON-NLS-1$
			e.printStackTrace();
			throw e;
		} catch (ParserConfigurationException e) {
			log.error("Unexpected error", e); //$NON-NLS-1$
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (SAXException e) {
			log.error("Unexpected error", e); //$NON-NLS-1$
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public static String constructRuleKey(String tag, String val) {
		if(val == null || val.length() == 0){
			return tag;
		}
		return tag + TAG_DELIMETER + val;
	}
	
	protected static String getTagKey(String tagValue) {
		int i = tagValue.indexOf(TAG_DELIMETER);
		if(i >= 0){
			return tagValue.substring(0, i);
		}
		return tagValue;
	}
	
	protected static String getValueKey(String tagValue) {
		int i = tagValue.indexOf(TAG_DELIMETER);
		if(i >= 0){
			return tagValue.substring(i + 1);
		}
		return null;
	}
	
	public String getAmenitySubtypePrefix(String tag, String val){
		Map<String, MapRulType> rules = getEncodingRuleTypes();
		MapRulType rt = rules.get(constructRuleKey(tag, val));
		if(rt != null && rt.poiPrefix != null) {
			return rt.poiPrefix;
		}
		rt = rules.get(constructRuleKey(tag, null));
		if(rt != null && rt.poiPrefix != null) {
			return rt.poiPrefix;
		}
		return null;
	}
	
	public String getAmenitySubtype(String tag, String val){
		String prefix = getAmenitySubtypePrefix(tag, val);
		if(prefix != null){
			return prefix + val;
		}
		return val;
	}
	
	public AmenityType getAmenityType(String tag, String val){
		// register amenity types
		Map<String, MapRulType> rules = getEncodingRuleTypes();
		MapRulType rt = rules.get(constructRuleKey(tag, val));
		if(rt != null && rt.poiSpecified) {
			return rt.poiCategory;
		}
		rt = rules.get(constructRuleKey(tag, null));
		if(rt != null && rt.poiSpecified) {
			return rt.poiCategory;
		}
		return null;
	}
	
	public static class MapRulType {
		String nameNullTag;
		String tag;
		String value;
		int minzoom;
		boolean additional;
		MapRulType targetTagValue;
		
		int id;
		int freq;
		
		String poiPrefix;
		AmenityType poiCategory;
		boolean poiSpecified;
		
		boolean polyline;
		boolean point;
		boolean polygon;
		
		public MapRulType(int id){
			this.id = id;
		}
		
		public String getNameNullTag() {
			return nameNullTag;
		}
		
		public boolean isMapIndexed(){
			return polygon || polyline || polygon;
		}
		
		public String poiPrefix(){
			return poiPrefix;
		}
		
		public AmenityType getPoiCategory() {
			return poiCategory;
		}
		
		public String getTag() {
			return tag;
		}
		
		public String getValue() {
			return value;
		}
		
		public int getMinzoom() {
			return minzoom;
		}
		
	}
	
	// TODO Move to Routing Attributes and finalize 
	// HIGHWAY special attributes :
	// o/oneway			1 bit
	// f/free toll 		1 bit
	// r/roundabout  	2 bit (+ 1 bit direction)
	// s/max speed   	3 bit [0 - 30km/h, 1 - 50km/h, 2 - 70km/h, 3 - 90km/h, 4 - 110km/h, 5 - 130 km/h, 6 >, 7 - 0/not specified]
	// a/vehicle access 4 bit   (height, weight?) - one bit bicycle
	// p/parking      	1 bit
	// c/cycle oneway 	1 bit
	// ci/inside city   1 bit
	// ENCODING :  ci|c|p|aaaa|sss|rr|f|o - 14 bit
	
	public final static byte RESTRICTION_NO_RIGHT_TURN = 1;
	public final static byte RESTRICTION_NO_LEFT_TURN = 2;
	public final static byte RESTRICTION_NO_U_TURN = 3;
	public final static byte RESTRICTION_NO_STRAIGHT_ON = 4;
	public final static byte RESTRICTION_ONLY_RIGHT_TURN = 5;
	public final static byte RESTRICTION_ONLY_LEFT_TURN = 6;
	public final static byte RESTRICTION_ONLY_STRAIGHT_ON = 7;
	

	public static boolean isOneWayWay(int highwayAttributes){
		return (highwayAttributes & 1) > 0;
	}
	
	public static boolean isRoundabout(int highwayAttributes){
		return ((highwayAttributes >> 2) & 1) > 0;
	}
	
	// return 0 if not defined
	public static int getMaxSpeedIfDefined(int highwayAttributes){
		switch((highwayAttributes >> 4) & 7) {
		case 0:
			return 20;
		case 1:
			return 40;
		case 2:
			return 60;
		case 3:
			return 80;
		case 4:
			return 100;
		case 5:
			return 120;
		case 6:
			return 140;
		case 7:
			return 0;
		
		}
		return 0;
	}
	

	public static int getHighwayAttributes(Entity e){
		int attr = 0;
		// cycle oneway
		attr <<= 1;
		String c = e.getTag("cycleway"); //$NON-NLS-1$
		if(c != null && ("opposite_lane".equals(c) || "opposite_track".equals(c) || "opposite".equals(c))){ //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			attr |= 1;
		}
		// parking
		attr <<= 1;
		String park = e.getTag("service"); //$NON-NLS-1$
		if("parking_aisle".equals(park)){ //$NON-NLS-1$
			attr |= 1;
		}

		// ACCESS not complete (should be redesigned)
		// vehicle access (not implement yet) 
		attr <<= 3;
		boolean hgv = "yes".equals(e.getTag("hgv")); //$NON-NLS-1$ //$NON-NLS-2$
		if(hgv){
			attr |= 3;
		} else {
			boolean goods = "yes".equals(e.getTag("goods")); //$NON-NLS-1$ //$NON-NLS-2$
			if(goods){
				attr |= 2;
			} else {
				attr |= 1;
			}
		}
		// bicycle access
		attr <<= 1;
		
		
		// speed
		// very simple algorithm doesn't consider city rules (country rules) and miles per hour
		attr <<= 3;
		String maxspeed = e.getTag("maxspeed"); //$NON-NLS-1$
		if(maxspeed != null){
			int kmh = 0;
			try {
				kmh = Integer.parseInt(maxspeed);
			} catch (NumberFormatException es) {
			}
			if(kmh <= 0){
				attr |= 7;
			} else if(kmh <= 30){
				attr |= 0;
			} else if(kmh <= 50){
				attr |= 1;
			} else if(kmh <= 70){
				attr |= 2;
			} else if(kmh <= 90){
				attr |= 3;
			} else if(kmh <= 110){
				attr |= 4;
			} else if(kmh <= 130){
				attr |= 5;
			} else {
				attr |= 6;
			}
		} else {
			attr |= 7;
		}
		
		
		// roundabout
		attr <<= 2;
		String jun = e.getTag(OSMTagKey.JUNCTION);
		if(jun != null){
			if("roundabout".equals(jun)){ //$NON-NLS-1$
				attr |= 1;
				if("clockwise".equals(e.getTag("direction"))){ //$NON-NLS-1$ //$NON-NLS-2$
					attr |= 2;
				}
			} 
		}
		
		// toll
		String toll = e.getTag(OSMTagKey.TOLL);
		attr <<= 1;
		if(toll != null){
			if("yes".equals(toll)){ //$NON-NLS-1$
				attr |= 1;
			}
		}
		
		// oneway
		String one = e.getTag(OSMTagKey.ONEWAY);
		attr <<= 1;
		if(one != null && (one.equals("yes") || one.equals("1") || one.equals("-1"))){  //$NON-NLS-1$ //$NON-NLS-2$//$NON-NLS-3$
 			attr |= 1;
 		}
		return attr;
	}
	
	
	
	public static void main(String[] args) {
//		MapRenderingTypes def = MapRenderingTypes.getDefault();
//		long ts = System.currentTimeMillis();
//		Map<String, Map<String, AmenityType>> amenityMap = def.getAmenityTagValToTypeMap();
//		for(String s : amenityMap.keySet()){
//			System.out.println(s + " - " + amenityMap.get(s));
//		}
//		Map<AmenityType, Map<String, String>> amenityType = def.getAmenityTypeNameToTagVal();
//		for(AmenityType s : amenityType.keySet()){
//			Map<String, String> map = amenityType.get(s);
//			for(String t : map.keySet()){
//				System.out.println(s + " - " + t + " " + map.get(t));
//			}
//		}
//		System.out.println(def.getAmenityNameToType());

		
//		def.initAmenityMap();
	}

}

