package net.osmand.plus.audionotes;

import java.util.ArrayList;
import java.util.List;

import net.osmand.plus.ContextMenuAdapter;
import net.osmand.plus.OsmandApplication;
import net.osmand.plus.OsmandPlugin;
import net.osmand.plus.R;
import net.osmand.plus.activities.OsmandActionBarActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Denis
 * on 23.12.2014.
 */
public class DashAudioVideoNotesActivity extends OsmandActionBarActivity {
	AudioVideoNotesPlugin plugin;
	List<AudioVideoNotesPlugin.Recording> items;
	NotesAdapter listAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		((OsmandApplication)getApplication()).applyTheme(this);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.editing_poi_filter);

		plugin = OsmandPlugin.getEnabledPlugin(AudioVideoNotesPlugin.class);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
			Window window = getWindow();
			window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
			window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
		}
		ActionBar actionBar = getSupportActionBar();
		actionBar.setTitle(R.string.audionotes_plugin_name);
		actionBar.setIcon(android.R.color.transparent);
	}

	@Override
	protected void onResume() {
		super.onResume();
		items = new ArrayList<AudioVideoNotesPlugin.Recording>(plugin.getAllRecordings());
		listAdapter = new NotesAdapter(items);
		((ListView)findViewById(android.R.id.list)).setAdapter(listAdapter);
	}

	private void showContextMenu(final AudioVideoNotesPlugin.Recording recording){
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		final ContextMenuAdapter adapter = new ContextMenuAdapter(this);
		ContextMenuAdapter.OnContextMenuClick listener = new ContextMenuAdapter.OnContextMenuClick() {
			@Override
			public boolean onContextMenuClick(final ArrayAdapter<?> adapter, int resId, int pos, boolean isChecked) {
				if (resId == R.string.local_index_mi_delete) {
					AlertDialog.Builder confirm = new AlertDialog.Builder(DashAudioVideoNotesActivity.this);
					confirm.setPositiveButton(R.string.default_buttons_yes, new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							plugin.deleteRecording(recording);
							items.remove(recording);
							listAdapter.notifyDataSetChanged();
						}
					});
					confirm.setNegativeButton(R.string.default_buttons_no, null);
					confirm.setMessage(getString(R.string.delete_confirmation_msg, recording.file.getName()));
					confirm.show();
				}
				return true;
			}
		};
		adapter.item(R.string.local_index_mi_delete).listen(listener).position(0).reg();

		builder.setItems(adapter.getItemNames(), new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				ContextMenuAdapter.OnContextMenuClick clk = adapter.getClickAdapter(which);
				if (clk != null){
					clk.onContextMenuClick(null, adapter.getElementId(which), which, false);
				}
			}
		});
		builder.show();
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case android.R.id.home:
				this.finish();
			default:
				return super.onOptionsItemSelected(item);
		}
	}



	class NotesAdapter extends ArrayAdapter<AudioVideoNotesPlugin.Recording> {
		NotesAdapter(List<AudioVideoNotesPlugin.Recording> recordingList) {
			super(DashAudioVideoNotesActivity.this, R.layout.dash_audio_video_notes_item, recordingList);
		}

		@Override
		public View getView(final int position, View convertView, ViewGroup parent) {
			LayoutInflater inflater = getLayoutInflater();
			View row = convertView;
			if (row == null){
				row = inflater.inflate(R.layout.dash_audio_video_notes_item, parent, false);
				row.findViewById(R.id.divider).setVisibility(View.GONE);
			}
			boolean light = ((OsmandApplication)getApplication()).getSettings().isLightContent();
			if (light) {
				row.setBackgroundColor(getResources().getColor(R.color.expandable_list_item_light));
			} else {
				row.setBackgroundColor(getResources().getColor(R.color.expandable_list_item_dark));
			}
			final AudioVideoNotesPlugin.Recording recording = getItem(position);
			DashAudioVideoNotesFragment.getNoteView(recording, row, DashAudioVideoNotesActivity.this, plugin);
			row.setOnLongClickListener(new View.OnLongClickListener() {
				@Override
				public boolean onLongClick(View v) {
					showContextMenu(recording);
					return true;
				}
			});
			return row;
		}
	}
}
