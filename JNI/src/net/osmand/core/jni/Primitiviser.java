/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.3
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package net.osmand.core.jni;

public class Primitiviser {
  private long swigCPtr;
  private boolean swigCMemOwn;

  protected Primitiviser(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(Primitiviser obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        OsmAndCoreJNI.delete_Primitiviser(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  static public class PrimitivesGroup {
    private long swigCPtr;
    private boolean swigCMemOwn;
  
    protected PrimitivesGroup(long cPtr, boolean cMemoryOwn) {
      swigCMemOwn = cMemoryOwn;
      swigCPtr = cPtr;
    }
  
    protected static long getCPtr(PrimitivesGroup obj) {
      return (obj == null) ? 0 : obj.swigCPtr;
    }
  
    protected void finalize() {
      delete();
    }
  
    public synchronized void delete() {
      if (swigCPtr != 0) {
        if (swigCMemOwn) {
          swigCMemOwn = false;
          OsmAndCoreJNI.delete_Primitiviser_PrimitivesGroup(swigCPtr);
        }
        swigCPtr = 0;
      }
    }
  
    public SWIGTYPE_p_std__shared_ptrT_OsmAnd__Model__BinaryMapObject_const_t getSourceObject() {
      long cPtr = OsmAndCoreJNI.Primitiviser_PrimitivesGroup_sourceObject_get(swigCPtr, this);
      return (cPtr == 0) ? null : new SWIGTYPE_p_std__shared_ptrT_OsmAnd__Model__BinaryMapObject_const_t(cPtr, false);
    }
  
    public void setPolygons(SWIGTYPE_p_QListT_std__shared_ptrT_OsmAnd__Primitiviser__Primitive_const_t_t value) {
      OsmAndCoreJNI.Primitiviser_PrimitivesGroup_polygons_set(swigCPtr, this, SWIGTYPE_p_QListT_std__shared_ptrT_OsmAnd__Primitiviser__Primitive_const_t_t.getCPtr(value));
    }
  
    public SWIGTYPE_p_QListT_std__shared_ptrT_OsmAnd__Primitiviser__Primitive_const_t_t getPolygons() {
      long cPtr = OsmAndCoreJNI.Primitiviser_PrimitivesGroup_polygons_get(swigCPtr, this);
      return (cPtr == 0) ? null : new SWIGTYPE_p_QListT_std__shared_ptrT_OsmAnd__Primitiviser__Primitive_const_t_t(cPtr, false);
    }
  
    public void setPolylines(SWIGTYPE_p_QListT_std__shared_ptrT_OsmAnd__Primitiviser__Primitive_const_t_t value) {
      OsmAndCoreJNI.Primitiviser_PrimitivesGroup_polylines_set(swigCPtr, this, SWIGTYPE_p_QListT_std__shared_ptrT_OsmAnd__Primitiviser__Primitive_const_t_t.getCPtr(value));
    }
  
    public SWIGTYPE_p_QListT_std__shared_ptrT_OsmAnd__Primitiviser__Primitive_const_t_t getPolylines() {
      long cPtr = OsmAndCoreJNI.Primitiviser_PrimitivesGroup_polylines_get(swigCPtr, this);
      return (cPtr == 0) ? null : new SWIGTYPE_p_QListT_std__shared_ptrT_OsmAnd__Primitiviser__Primitive_const_t_t(cPtr, false);
    }
  
    public void setPoints(SWIGTYPE_p_QListT_std__shared_ptrT_OsmAnd__Primitiviser__Primitive_const_t_t value) {
      OsmAndCoreJNI.Primitiviser_PrimitivesGroup_points_set(swigCPtr, this, SWIGTYPE_p_QListT_std__shared_ptrT_OsmAnd__Primitiviser__Primitive_const_t_t.getCPtr(value));
    }
  
    public SWIGTYPE_p_QListT_std__shared_ptrT_OsmAnd__Primitiviser__Primitive_const_t_t getPoints() {
      long cPtr = OsmAndCoreJNI.Primitiviser_PrimitivesGroup_points_get(swigCPtr, this);
      return (cPtr == 0) ? null : new SWIGTYPE_p_QListT_std__shared_ptrT_OsmAnd__Primitiviser__Primitive_const_t_t(cPtr, false);
    }
  
  }

  static public class Primitive {
    private long swigCPtr;
    private boolean swigCMemOwn;
  
    protected Primitive(long cPtr, boolean cMemoryOwn) {
      swigCMemOwn = cMemoryOwn;
      swigCPtr = cPtr;
    }
  
    protected static long getCPtr(Primitive obj) {
      return (obj == null) ? 0 : obj.swigCPtr;
    }
  
    protected void finalize() {
      delete();
    }
  
    public synchronized void delete() {
      if (swigCPtr != 0) {
        if (swigCMemOwn) {
          swigCMemOwn = false;
          OsmAndCoreJNI.delete_Primitiviser_Primitive(swigCPtr);
        }
        swigCPtr = 0;
      }
    }
  
    public SWIGTYPE_p_std__weak_ptrT_OsmAnd__Primitiviser__PrimitivesGroup_const_t getGroup() {
      long cPtr = OsmAndCoreJNI.Primitiviser_Primitive_group_get(swigCPtr, this);
      return (cPtr == 0) ? null : new SWIGTYPE_p_std__weak_ptrT_OsmAnd__Primitiviser__PrimitivesGroup_const_t(cPtr, false);
    }
  
    public SWIGTYPE_p_std__shared_ptrT_OsmAnd__Model__BinaryMapObject_const_t getSourceObject() {
      long cPtr = OsmAndCoreJNI.Primitiviser_Primitive_sourceObject_get(swigCPtr, this);
      return (cPtr == 0) ? null : new SWIGTYPE_p_std__shared_ptrT_OsmAnd__Model__BinaryMapObject_const_t(cPtr, false);
    }
  
    public Primitiviser.PrimitiveType getType() {
      return Primitiviser.PrimitiveType.swigToEnum(OsmAndCoreJNI.Primitiviser_Primitive_type_get(swigCPtr, this));
    }
  
    public long getTypeRuleIdIndex() {
      return OsmAndCoreJNI.Primitiviser_Primitive_typeRuleIdIndex_get(swigCPtr, this);
    }
  
    public SWIGTYPE_p_MapStyleEvaluationResult getEvaluationResult() {
      return new SWIGTYPE_p_MapStyleEvaluationResult(OsmAndCoreJNI.Primitiviser_Primitive_evaluationResult_get(swigCPtr, this), true);
    }
  
    public void setZOrder(int value) {
      OsmAndCoreJNI.Primitiviser_Primitive_zOrder_set(swigCPtr, this, value);
    }
  
    public int getZOrder() {
      return OsmAndCoreJNI.Primitiviser_Primitive_zOrder_get(swigCPtr, this);
    }
  
    public void setDoubledArea(long value) {
      OsmAndCoreJNI.Primitiviser_Primitive_doubledArea_set(swigCPtr, this, value);
    }
  
    public long getDoubledArea() {
      return OsmAndCoreJNI.Primitiviser_Primitive_doubledArea_get(swigCPtr, this);
    }
  
  }

  static public class SymbolsGroup {
    private long swigCPtr;
    private boolean swigCMemOwn;
  
    protected SymbolsGroup(long cPtr, boolean cMemoryOwn) {
      swigCMemOwn = cMemoryOwn;
      swigCPtr = cPtr;
    }
  
    protected static long getCPtr(SymbolsGroup obj) {
      return (obj == null) ? 0 : obj.swigCPtr;
    }
  
    protected void finalize() {
      delete();
    }
  
    public synchronized void delete() {
      if (swigCPtr != 0) {
        if (swigCMemOwn) {
          swigCMemOwn = false;
          OsmAndCoreJNI.delete_Primitiviser_SymbolsGroup(swigCPtr);
        }
        swigCPtr = 0;
      }
    }
  
    public SWIGTYPE_p_std__shared_ptrT_OsmAnd__Model__BinaryMapObject_const_t getSourceObject() {
      long cPtr = OsmAndCoreJNI.Primitiviser_SymbolsGroup_sourceObject_get(swigCPtr, this);
      return (cPtr == 0) ? null : new SWIGTYPE_p_std__shared_ptrT_OsmAnd__Model__BinaryMapObject_const_t(cPtr, false);
    }
  
    public void setSymbols(SWIGTYPE_p_QListT_std__shared_ptrT_OsmAnd__Primitiviser__Symbol_const_t_t value) {
      OsmAndCoreJNI.Primitiviser_SymbolsGroup_symbols_set(swigCPtr, this, SWIGTYPE_p_QListT_std__shared_ptrT_OsmAnd__Primitiviser__Symbol_const_t_t.getCPtr(value));
    }
  
    public SWIGTYPE_p_QListT_std__shared_ptrT_OsmAnd__Primitiviser__Symbol_const_t_t getSymbols() {
      long cPtr = OsmAndCoreJNI.Primitiviser_SymbolsGroup_symbols_get(swigCPtr, this);
      return (cPtr == 0) ? null : new SWIGTYPE_p_QListT_std__shared_ptrT_OsmAnd__Primitiviser__Symbol_const_t_t(cPtr, false);
    }
  
  }

  static public class Symbol {
    private long swigCPtr;
    private boolean swigCMemOwn;
  
    protected Symbol(long cPtr, boolean cMemoryOwn) {
      swigCMemOwn = cMemoryOwn;
      swigCPtr = cPtr;
    }
  
    protected static long getCPtr(Symbol obj) {
      return (obj == null) ? 0 : obj.swigCPtr;
    }
  
    protected void finalize() {
      delete();
    }
  
    public synchronized void delete() {
      if (swigCPtr != 0) {
        if (swigCMemOwn) {
          swigCMemOwn = false;
          OsmAndCoreJNI.delete_Primitiviser_Symbol(swigCPtr);
        }
        swigCPtr = 0;
      }
    }
  
    public Primitiviser.Primitive getPrimitive() {
      long cPtr = OsmAndCoreJNI.Primitiviser_Symbol_primitive_get(swigCPtr, this);
      return (cPtr == 0) ? null : new Primitiviser.Primitive(cPtr, true);
    }
  
    public void setLocation31(PointI value) {
      OsmAndCoreJNI.Primitiviser_Symbol_location31_set(swigCPtr, this, PointI.getCPtr(value), value);
    }
  
    public PointI getLocation31() {
      long cPtr = OsmAndCoreJNI.Primitiviser_Symbol_location31_get(swigCPtr, this);
      return (cPtr == 0) ? null : new PointI(cPtr, false);
    }
  
    public void setOrder(int value) {
      OsmAndCoreJNI.Primitiviser_Symbol_order_set(swigCPtr, this, value);
    }
  
    public int getOrder() {
      return OsmAndCoreJNI.Primitiviser_Symbol_order_get(swigCPtr, this);
    }
  
    public void setDrawAlongPath(boolean value) {
      OsmAndCoreJNI.Primitiviser_Symbol_drawAlongPath_set(swigCPtr, this, value);
    }
  
    public boolean getDrawAlongPath() {
      return OsmAndCoreJNI.Primitiviser_Symbol_drawAlongPath_get(swigCPtr, this);
    }
  
    public void setIntersectsWith(SWIGTYPE_p_QSetT_QString_t value) {
      OsmAndCoreJNI.Primitiviser_Symbol_intersectsWith_set(swigCPtr, this, SWIGTYPE_p_QSetT_QString_t.getCPtr(value));
    }
  
    public SWIGTYPE_p_QSetT_QString_t getIntersectsWith() {
      long cPtr = OsmAndCoreJNI.Primitiviser_Symbol_intersectsWith_get(swigCPtr, this);
      return (cPtr == 0) ? null : new SWIGTYPE_p_QSetT_QString_t(cPtr, false);
    }
  
  }

  static public class TextSymbol extends Primitiviser.Symbol {
    private long swigCPtr;
    private boolean swigCMemOwnDerived;
  
    protected TextSymbol(long cPtr, boolean cMemoryOwn) {
      super(OsmAndCoreJNI.Primitiviser_TextSymbol_SWIGSmartPtrUpcast(cPtr), true);
      swigCMemOwnDerived = cMemoryOwn;
      swigCPtr = cPtr;
    }
  
    protected static long getCPtr(TextSymbol obj) {
      return (obj == null) ? 0 : obj.swigCPtr;
    }
  
    protected void finalize() {
      delete();
    }
  
    public synchronized void delete() {
      if (swigCPtr != 0) {
        if (swigCMemOwnDerived) {
          swigCMemOwnDerived = false;
          OsmAndCoreJNI.delete_Primitiviser_TextSymbol(swigCPtr);
        }
        swigCPtr = 0;
      }
      super.delete();
    }
  
    public void setValue(String value) {
      OsmAndCoreJNI.Primitiviser_TextSymbol_value_set(swigCPtr, this, value);
    }
  
    public String getValue() {
      return OsmAndCoreJNI.Primitiviser_TextSymbol_value_get(swigCPtr, this);
    }
  
    public void setLanguageId(LanguageId value) {
      OsmAndCoreJNI.Primitiviser_TextSymbol_languageId_set(swigCPtr, this, value.swigValue());
    }
  
    public LanguageId getLanguageId() {
      return LanguageId.swigToEnum(OsmAndCoreJNI.Primitiviser_TextSymbol_languageId_get(swigCPtr, this));
    }
  
    public void setDrawOnPath(boolean value) {
      OsmAndCoreJNI.Primitiviser_TextSymbol_drawOnPath_set(swigCPtr, this, value);
    }
  
    public boolean getDrawOnPath() {
      return OsmAndCoreJNI.Primitiviser_TextSymbol_drawOnPath_get(swigCPtr, this);
    }
  
    public void setVerticalOffset(int value) {
      OsmAndCoreJNI.Primitiviser_TextSymbol_verticalOffset_set(swigCPtr, this, value);
    }
  
    public int getVerticalOffset() {
      return OsmAndCoreJNI.Primitiviser_TextSymbol_verticalOffset_get(swigCPtr, this);
    }
  
    public void setColor(ColorARGB value) {
      OsmAndCoreJNI.Primitiviser_TextSymbol_color_set(swigCPtr, this, ColorARGB.getCPtr(value), value);
    }
  
    public ColorARGB getColor() {
      long cPtr = OsmAndCoreJNI.Primitiviser_TextSymbol_color_get(swigCPtr, this);
      return (cPtr == 0) ? null : new ColorARGB(cPtr, false);
    }
  
    public void setSize(int value) {
      OsmAndCoreJNI.Primitiviser_TextSymbol_size_set(swigCPtr, this, value);
    }
  
    public int getSize() {
      return OsmAndCoreJNI.Primitiviser_TextSymbol_size_get(swigCPtr, this);
    }
  
    public void setShadowRadius(int value) {
      OsmAndCoreJNI.Primitiviser_TextSymbol_shadowRadius_set(swigCPtr, this, value);
    }
  
    public int getShadowRadius() {
      return OsmAndCoreJNI.Primitiviser_TextSymbol_shadowRadius_get(swigCPtr, this);
    }
  
    public void setShadowColor(ColorARGB value) {
      OsmAndCoreJNI.Primitiviser_TextSymbol_shadowColor_set(swigCPtr, this, ColorARGB.getCPtr(value), value);
    }
  
    public ColorARGB getShadowColor() {
      long cPtr = OsmAndCoreJNI.Primitiviser_TextSymbol_shadowColor_get(swigCPtr, this);
      return (cPtr == 0) ? null : new ColorARGB(cPtr, false);
    }
  
    public void setWrapWidth(int value) {
      OsmAndCoreJNI.Primitiviser_TextSymbol_wrapWidth_set(swigCPtr, this, value);
    }
  
    public int getWrapWidth() {
      return OsmAndCoreJNI.Primitiviser_TextSymbol_wrapWidth_get(swigCPtr, this);
    }
  
    public void setIsBold(boolean value) {
      OsmAndCoreJNI.Primitiviser_TextSymbol_isBold_set(swigCPtr, this, value);
    }
  
    public boolean getIsBold() {
      return OsmAndCoreJNI.Primitiviser_TextSymbol_isBold_get(swigCPtr, this);
    }
  
    public void setMinDistance(PointI value) {
      OsmAndCoreJNI.Primitiviser_TextSymbol_minDistance_set(swigCPtr, this, PointI.getCPtr(value), value);
    }
  
    public PointI getMinDistance() {
      long cPtr = OsmAndCoreJNI.Primitiviser_TextSymbol_minDistance_get(swigCPtr, this);
      return (cPtr == 0) ? null : new PointI(cPtr, false);
    }
  
    public void setShieldResourceName(String value) {
      OsmAndCoreJNI.Primitiviser_TextSymbol_shieldResourceName_set(swigCPtr, this, value);
    }
  
    public String getShieldResourceName() {
      return OsmAndCoreJNI.Primitiviser_TextSymbol_shieldResourceName_get(swigCPtr, this);
    }
  
  }

  static public class IconSymbol extends Primitiviser.Symbol {
    private long swigCPtr;
    private boolean swigCMemOwnDerived;
  
    protected IconSymbol(long cPtr, boolean cMemoryOwn) {
      super(OsmAndCoreJNI.Primitiviser_IconSymbol_SWIGSmartPtrUpcast(cPtr), true);
      swigCMemOwnDerived = cMemoryOwn;
      swigCPtr = cPtr;
    }
  
    protected static long getCPtr(IconSymbol obj) {
      return (obj == null) ? 0 : obj.swigCPtr;
    }
  
    protected void finalize() {
      delete();
    }
  
    public synchronized void delete() {
      if (swigCPtr != 0) {
        if (swigCMemOwnDerived) {
          swigCMemOwnDerived = false;
          OsmAndCoreJNI.delete_Primitiviser_IconSymbol(swigCPtr);
        }
        swigCPtr = 0;
      }
      super.delete();
    }
  
    public void setResourceName(String value) {
      OsmAndCoreJNI.Primitiviser_IconSymbol_resourceName_set(swigCPtr, this, value);
    }
  
    public String getResourceName() {
      return OsmAndCoreJNI.Primitiviser_IconSymbol_resourceName_get(swigCPtr, this);
    }
  
    public void setShieldResourceName(String value) {
      OsmAndCoreJNI.Primitiviser_IconSymbol_shieldResourceName_set(swigCPtr, this, value);
    }
  
    public String getShieldResourceName() {
      return OsmAndCoreJNI.Primitiviser_IconSymbol_shieldResourceName_get(swigCPtr, this);
    }
  
    public void setIntersectionSize(float value) {
      OsmAndCoreJNI.Primitiviser_IconSymbol_intersectionSize_set(swigCPtr, this, value);
    }
  
    public float getIntersectionSize() {
      return OsmAndCoreJNI.Primitiviser_IconSymbol_intersectionSize_get(swigCPtr, this);
    }
  
  }

  static public class Cache {
    private long swigCPtr;
    private boolean swigCMemOwn;
  
    protected Cache(long cPtr, boolean cMemoryOwn) {
      swigCMemOwn = cMemoryOwn;
      swigCPtr = cPtr;
    }
  
    protected static long getCPtr(Cache obj) {
      return (obj == null) ? 0 : obj.swigCPtr;
    }
  
    protected void finalize() {
      delete();
    }
  
    public synchronized void delete() {
      if (swigCPtr != 0) {
        if (swigCMemOwn) {
          swigCMemOwn = false;
          OsmAndCoreJNI.delete_Primitiviser_Cache(swigCPtr);
        }
        swigCPtr = 0;
      }
    }
  
    public Cache() {
      this(OsmAndCoreJNI.new_Primitiviser_Cache(), true);
    }
  
    public SWIGTYPE_p_SharedResourcesContainerT_unsigned_long_long_OsmAnd__Primitiviser__PrimitivesGroup_const_t getPrimitivesGroups(ZoomLevel zoom) {
      return new SWIGTYPE_p_SharedResourcesContainerT_unsigned_long_long_OsmAnd__Primitiviser__PrimitivesGroup_const_t(OsmAndCoreJNI.Primitiviser_Cache_getPrimitivesGroups__SWIG_0(swigCPtr, this, zoom.swigValue()), false);
    }
  
    public SWIGTYPE_p_SharedResourcesContainerT_unsigned_long_long_OsmAnd__Primitiviser__SymbolsGroup_const_t getSymbolsGroups(ZoomLevel zoom) {
      return new SWIGTYPE_p_SharedResourcesContainerT_unsigned_long_long_OsmAnd__Primitiviser__SymbolsGroup_const_t(OsmAndCoreJNI.Primitiviser_Cache_getSymbolsGroups__SWIG_0(swigCPtr, this, zoom.swigValue()), false);
    }
  
    public SWIGTYPE_p_SharedResourcesContainerT_unsigned_long_long_OsmAnd__Primitiviser__PrimitivesGroup_const_t getPrimitivesGroupsPtr(ZoomLevel zoom) {
      long cPtr = OsmAndCoreJNI.Primitiviser_Cache_getPrimitivesGroupsPtr__SWIG_0(swigCPtr, this, zoom.swigValue());
      return (cPtr == 0) ? null : new SWIGTYPE_p_SharedResourcesContainerT_unsigned_long_long_OsmAnd__Primitiviser__PrimitivesGroup_const_t(cPtr, false);
    }
  
    public SWIGTYPE_p_SharedResourcesContainerT_unsigned_long_long_OsmAnd__Primitiviser__SymbolsGroup_const_t getSymbolsGroupsPtr(ZoomLevel zoom) {
      long cPtr = OsmAndCoreJNI.Primitiviser_Cache_getSymbolsGroupsPtr__SWIG_0(swigCPtr, this, zoom.swigValue());
      return (cPtr == 0) ? null : new SWIGTYPE_p_SharedResourcesContainerT_unsigned_long_long_OsmAnd__Primitiviser__SymbolsGroup_const_t(cPtr, false);
    }
  
  }

  static public class PrimitivisedArea {
    private long swigCPtr;
    private boolean swigCMemOwn;
  
    protected PrimitivisedArea(long cPtr, boolean cMemoryOwn) {
      swigCMemOwn = cMemoryOwn;
      swigCPtr = cPtr;
    }
  
    protected static long getCPtr(PrimitivisedArea obj) {
      return (obj == null) ? 0 : obj.swigCPtr;
    }
  
    protected void finalize() {
      delete();
    }
  
    public synchronized void delete() {
      if (swigCPtr != 0) {
        if (swigCMemOwn) {
          swigCMemOwn = false;
          OsmAndCoreJNI.delete_Primitiviser_PrimitivisedArea(swigCPtr);
        }
        swigCPtr = 0;
      }
    }
  
    public AreaI getArea31() {
      long cPtr = OsmAndCoreJNI.Primitiviser_PrimitivisedArea_area31_get(swigCPtr, this);
      return (cPtr == 0) ? null : new AreaI(cPtr, false);
    }
  
    public PointI getSizeInPixels() {
      long cPtr = OsmAndCoreJNI.Primitiviser_PrimitivisedArea_sizeInPixels_get(swigCPtr, this);
      return (cPtr == 0) ? null : new PointI(cPtr, false);
    }
  
    public ZoomLevel getZoom() {
      return ZoomLevel.swigToEnum(OsmAndCoreJNI.Primitiviser_PrimitivisedArea_zoom_get(swigCPtr, this));
    }
  
    public MapPresentationEnvironment getMapPresentationEnvironment() {
      long cPtr = OsmAndCoreJNI.Primitiviser_PrimitivisedArea_mapPresentationEnvironment_get(swigCPtr, this);
      return (cPtr == 0) ? null : new MapPresentationEnvironment(cPtr, true);
    }
  
    public void setDefaultBackgroundColor(ColorARGB value) {
      OsmAndCoreJNI.Primitiviser_PrimitivisedArea_defaultBackgroundColor_set(swigCPtr, this, ColorARGB.getCPtr(value), value);
    }
  
    public ColorARGB getDefaultBackgroundColor() {
      long cPtr = OsmAndCoreJNI.Primitiviser_PrimitivisedArea_defaultBackgroundColor_get(swigCPtr, this);
      return (cPtr == 0) ? null : new ColorARGB(cPtr, false);
    }
  
    public void setShadowRenderingMode(int value) {
      OsmAndCoreJNI.Primitiviser_PrimitivisedArea_shadowRenderingMode_set(swigCPtr, this, value);
    }
  
    public int getShadowRenderingMode() {
      return OsmAndCoreJNI.Primitiviser_PrimitivisedArea_shadowRenderingMode_get(swigCPtr, this);
    }
  
    public void setShadowRenderingColor(ColorARGB value) {
      OsmAndCoreJNI.Primitiviser_PrimitivisedArea_shadowRenderingColor_set(swigCPtr, this, ColorARGB.getCPtr(value), value);
    }
  
    public ColorARGB getShadowRenderingColor() {
      long cPtr = OsmAndCoreJNI.Primitiviser_PrimitivisedArea_shadowRenderingColor_get(swigCPtr, this);
      return (cPtr == 0) ? null : new ColorARGB(cPtr, false);
    }
  
    public void setPolygonAreaMinimalThreshold(double value) {
      OsmAndCoreJNI.Primitiviser_PrimitivisedArea_polygonAreaMinimalThreshold_set(swigCPtr, this, value);
    }
  
    public double getPolygonAreaMinimalThreshold() {
      return OsmAndCoreJNI.Primitiviser_PrimitivisedArea_polygonAreaMinimalThreshold_get(swigCPtr, this);
    }
  
    public void setRoadDensityZoomTile(long value) {
      OsmAndCoreJNI.Primitiviser_PrimitivisedArea_roadDensityZoomTile_set(swigCPtr, this, value);
    }
  
    public long getRoadDensityZoomTile() {
      return OsmAndCoreJNI.Primitiviser_PrimitivisedArea_roadDensityZoomTile_get(swigCPtr, this);
    }
  
    public void setRoadsDensityLimitPerTile(long value) {
      OsmAndCoreJNI.Primitiviser_PrimitivisedArea_roadsDensityLimitPerTile_set(swigCPtr, this, value);
    }
  
    public long getRoadsDensityLimitPerTile() {
      return OsmAndCoreJNI.Primitiviser_PrimitivisedArea_roadsDensityLimitPerTile_get(swigCPtr, this);
    }
  
    public void setShadowLevelMin(int value) {
      OsmAndCoreJNI.Primitiviser_PrimitivisedArea_shadowLevelMin_set(swigCPtr, this, value);
    }
  
    public int getShadowLevelMin() {
      return OsmAndCoreJNI.Primitiviser_PrimitivisedArea_shadowLevelMin_get(swigCPtr, this);
    }
  
    public void setShadowLevelMax(int value) {
      OsmAndCoreJNI.Primitiviser_PrimitivisedArea_shadowLevelMax_set(swigCPtr, this, value);
    }
  
    public int getShadowLevelMax() {
      return OsmAndCoreJNI.Primitiviser_PrimitivisedArea_shadowLevelMax_get(swigCPtr, this);
    }
  
    public void setScale31ToPixelDivisor(PointD value) {
      OsmAndCoreJNI.Primitiviser_PrimitivisedArea_scale31ToPixelDivisor_set(swigCPtr, this, PointD.getCPtr(value), value);
    }
  
    public PointD getScale31ToPixelDivisor() {
      long cPtr = OsmAndCoreJNI.Primitiviser_PrimitivisedArea_scale31ToPixelDivisor_get(swigCPtr, this);
      return (cPtr == 0) ? null : new PointD(cPtr, false);
    }
  
    public void setPrimitivesGroups(SWIGTYPE_p_QListT_std__shared_ptrT_OsmAnd__Primitiviser__PrimitivesGroup_const_t_t value) {
      OsmAndCoreJNI.Primitiviser_PrimitivisedArea_primitivesGroups_set(swigCPtr, this, SWIGTYPE_p_QListT_std__shared_ptrT_OsmAnd__Primitiviser__PrimitivesGroup_const_t_t.getCPtr(value));
    }
  
    public SWIGTYPE_p_QListT_std__shared_ptrT_OsmAnd__Primitiviser__PrimitivesGroup_const_t_t getPrimitivesGroups() {
      long cPtr = OsmAndCoreJNI.Primitiviser_PrimitivisedArea_primitivesGroups_get(swigCPtr, this);
      return (cPtr == 0) ? null : new SWIGTYPE_p_QListT_std__shared_ptrT_OsmAnd__Primitiviser__PrimitivesGroup_const_t_t(cPtr, false);
    }
  
    public void setPolygons(SWIGTYPE_p_QListT_std__shared_ptrT_OsmAnd__Primitiviser__Primitive_const_t_t value) {
      OsmAndCoreJNI.Primitiviser_PrimitivisedArea_polygons_set(swigCPtr, this, SWIGTYPE_p_QListT_std__shared_ptrT_OsmAnd__Primitiviser__Primitive_const_t_t.getCPtr(value));
    }
  
    public SWIGTYPE_p_QListT_std__shared_ptrT_OsmAnd__Primitiviser__Primitive_const_t_t getPolygons() {
      long cPtr = OsmAndCoreJNI.Primitiviser_PrimitivisedArea_polygons_get(swigCPtr, this);
      return (cPtr == 0) ? null : new SWIGTYPE_p_QListT_std__shared_ptrT_OsmAnd__Primitiviser__Primitive_const_t_t(cPtr, false);
    }
  
    public void setPolylines(SWIGTYPE_p_QListT_std__shared_ptrT_OsmAnd__Primitiviser__Primitive_const_t_t value) {
      OsmAndCoreJNI.Primitiviser_PrimitivisedArea_polylines_set(swigCPtr, this, SWIGTYPE_p_QListT_std__shared_ptrT_OsmAnd__Primitiviser__Primitive_const_t_t.getCPtr(value));
    }
  
    public SWIGTYPE_p_QListT_std__shared_ptrT_OsmAnd__Primitiviser__Primitive_const_t_t getPolylines() {
      long cPtr = OsmAndCoreJNI.Primitiviser_PrimitivisedArea_polylines_get(swigCPtr, this);
      return (cPtr == 0) ? null : new SWIGTYPE_p_QListT_std__shared_ptrT_OsmAnd__Primitiviser__Primitive_const_t_t(cPtr, false);
    }
  
    public void setPoints(SWIGTYPE_p_QListT_std__shared_ptrT_OsmAnd__Primitiviser__Primitive_const_t_t value) {
      OsmAndCoreJNI.Primitiviser_PrimitivisedArea_points_set(swigCPtr, this, SWIGTYPE_p_QListT_std__shared_ptrT_OsmAnd__Primitiviser__Primitive_const_t_t.getCPtr(value));
    }
  
    public SWIGTYPE_p_QListT_std__shared_ptrT_OsmAnd__Primitiviser__Primitive_const_t_t getPoints() {
      long cPtr = OsmAndCoreJNI.Primitiviser_PrimitivisedArea_points_get(swigCPtr, this);
      return (cPtr == 0) ? null : new SWIGTYPE_p_QListT_std__shared_ptrT_OsmAnd__Primitiviser__Primitive_const_t_t(cPtr, false);
    }
  
    public void setSymbolsGroups(SWIGTYPE_p_QHashT_std__shared_ptrT_OsmAnd__Model__BinaryMapObject_const_t_std__shared_ptrT_OsmAnd__Primitiviser__SymbolsGroup_const_t_t value) {
      OsmAndCoreJNI.Primitiviser_PrimitivisedArea_symbolsGroups_set(swigCPtr, this, SWIGTYPE_p_QHashT_std__shared_ptrT_OsmAnd__Model__BinaryMapObject_const_t_std__shared_ptrT_OsmAnd__Primitiviser__SymbolsGroup_const_t_t.getCPtr(value));
    }
  
    public SWIGTYPE_p_QHashT_std__shared_ptrT_OsmAnd__Model__BinaryMapObject_const_t_std__shared_ptrT_OsmAnd__Primitiviser__SymbolsGroup_const_t_t getSymbolsGroups() {
      long cPtr = OsmAndCoreJNI.Primitiviser_PrimitivisedArea_symbolsGroups_get(swigCPtr, this);
      return (cPtr == 0) ? null : new SWIGTYPE_p_QHashT_std__shared_ptrT_OsmAnd__Model__BinaryMapObject_const_t_std__shared_ptrT_OsmAnd__Primitiviser__SymbolsGroup_const_t_t(cPtr, false);
    }
  
    public boolean isEmpty() {
      return OsmAndCoreJNI.Primitiviser_PrimitivisedArea_isEmpty(swigCPtr, this);
    }
  
  }

  public Primitiviser(MapPresentationEnvironment environment) {
    this(OsmAndCoreJNI.new_Primitiviser(MapPresentationEnvironment.getCPtr(environment), environment), true);
  }

  public MapPresentationEnvironment getEnvironment() {
    long cPtr = OsmAndCoreJNI.Primitiviser_environment_get(swigCPtr, this);
    return (cPtr == 0) ? null : new MapPresentationEnvironment(cPtr, true);
  }

  public Primitiviser.PrimitivisedArea primitivise(AreaI area31, PointI sizeInPixels, ZoomLevel zoom, MapFoundationType foundation, SWIGTYPE_p_QListT_std__shared_ptrT_OsmAnd__Model__BinaryMapObject_const_t_t objects, Primitiviser.Cache cache, SWIGTYPE_p_OsmAnd__IQueryController controller, SWIGTYPE_p_Primitiviser_Metrics__Metric_primitivise metric) {
    long cPtr = OsmAndCoreJNI.Primitiviser_primitivise__SWIG_0(swigCPtr, this, AreaI.getCPtr(area31), area31, PointI.getCPtr(sizeInPixels), sizeInPixels, zoom.swigValue(), foundation.swigValue(), SWIGTYPE_p_QListT_std__shared_ptrT_OsmAnd__Model__BinaryMapObject_const_t_t.getCPtr(objects), Primitiviser.Cache.getCPtr(cache), SWIGTYPE_p_OsmAnd__IQueryController.getCPtr(controller), SWIGTYPE_p_Primitiviser_Metrics__Metric_primitivise.getCPtr(metric));
    return (cPtr == 0) ? null : new Primitiviser.PrimitivisedArea(cPtr, true);
  }

  public Primitiviser.PrimitivisedArea primitivise(AreaI area31, PointI sizeInPixels, ZoomLevel zoom, MapFoundationType foundation, SWIGTYPE_p_QListT_std__shared_ptrT_OsmAnd__Model__BinaryMapObject_const_t_t objects, Primitiviser.Cache cache, SWIGTYPE_p_OsmAnd__IQueryController controller) {
    long cPtr = OsmAndCoreJNI.Primitiviser_primitivise__SWIG_1(swigCPtr, this, AreaI.getCPtr(area31), area31, PointI.getCPtr(sizeInPixels), sizeInPixels, zoom.swigValue(), foundation.swigValue(), SWIGTYPE_p_QListT_std__shared_ptrT_OsmAnd__Model__BinaryMapObject_const_t_t.getCPtr(objects), Primitiviser.Cache.getCPtr(cache), SWIGTYPE_p_OsmAnd__IQueryController.getCPtr(controller));
    return (cPtr == 0) ? null : new Primitiviser.PrimitivisedArea(cPtr, true);
  }

  public Primitiviser.PrimitivisedArea primitivise(AreaI area31, PointI sizeInPixels, ZoomLevel zoom, MapFoundationType foundation, SWIGTYPE_p_QListT_std__shared_ptrT_OsmAnd__Model__BinaryMapObject_const_t_t objects, Primitiviser.Cache cache) {
    long cPtr = OsmAndCoreJNI.Primitiviser_primitivise__SWIG_2(swigCPtr, this, AreaI.getCPtr(area31), area31, PointI.getCPtr(sizeInPixels), sizeInPixels, zoom.swigValue(), foundation.swigValue(), SWIGTYPE_p_QListT_std__shared_ptrT_OsmAnd__Model__BinaryMapObject_const_t_t.getCPtr(objects), Primitiviser.Cache.getCPtr(cache));
    return (cPtr == 0) ? null : new Primitiviser.PrimitivisedArea(cPtr, true);
  }

  public Primitiviser.PrimitivisedArea primitivise(AreaI area31, PointI sizeInPixels, ZoomLevel zoom, MapFoundationType foundation, SWIGTYPE_p_QListT_std__shared_ptrT_OsmAnd__Model__BinaryMapObject_const_t_t objects) {
    long cPtr = OsmAndCoreJNI.Primitiviser_primitivise__SWIG_3(swigCPtr, this, AreaI.getCPtr(area31), area31, PointI.getCPtr(sizeInPixels), sizeInPixels, zoom.swigValue(), foundation.swigValue(), SWIGTYPE_p_QListT_std__shared_ptrT_OsmAnd__Model__BinaryMapObject_const_t_t.getCPtr(objects));
    return (cPtr == 0) ? null : new Primitiviser.PrimitivisedArea(cPtr, true);
  }

  public enum PrimitiveType {
    Point(OsmAndCoreJNI.Primitiviser_PrimitiveType_Point_get()),
    Polyline(OsmAndCoreJNI.Primitiviser_PrimitiveType_Polyline_get()),
    Polygon(OsmAndCoreJNI.Primitiviser_PrimitiveType_Polygon_get());

    public final int swigValue() {
      return swigValue;
    }

    public static PrimitiveType swigToEnum(int swigValue) {
      PrimitiveType[] swigValues = PrimitiveType.class.getEnumConstants();
      if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
        return swigValues[swigValue];
      for (PrimitiveType swigEnum : swigValues)
        if (swigEnum.swigValue == swigValue)
          return swigEnum;
      throw new IllegalArgumentException("No enum " + PrimitiveType.class + " with value " + swigValue);
    }

    @SuppressWarnings("unused")
    private PrimitiveType() {
      this.swigValue = SwigNext.next++;
    }

    @SuppressWarnings("unused")
    private PrimitiveType(int swigValue) {
      this.swigValue = swigValue;
      SwigNext.next = swigValue+1;
    }

    @SuppressWarnings("unused")
    private PrimitiveType(PrimitiveType swigEnum) {
      this.swigValue = swigEnum.swigValue;
      SwigNext.next = this.swigValue+1;
    }

    private final int swigValue;

    private static class SwigNext {
      private static int next = 0;
    }
  }

}