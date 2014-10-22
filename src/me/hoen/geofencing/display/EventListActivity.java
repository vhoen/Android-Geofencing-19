package me.hoen.geofencing.display;

import java.util.ArrayList;

import me.hoen.geofencing.GeofenceUtils;
import me.hoen.geofencing.R;
import me.hoen.geofencing.db.Event;
import me.hoen.geofencing.db.EventDataSource;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

public class EventListActivity extends Activity {
	protected EventListAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_event_list);

		ArrayList<Event> list = new ArrayList<Event>();
		ListView listLv = (ListView) findViewById(R.id.list);
		adapter = new EventListAdapter(this, R.layout.item_event, list);
		listLv.setAdapter(adapter);
	}

	@Override
	protected void onResume() {
		loadData();
		super.onResume();
	}

	protected void loadData() {
		EventDataSource eds = new EventDataSource(getApplicationContext());
		ArrayList<Event> list = eds.getEvents();
		eds.close();
		
		Log.d(GeofenceUtils.APPTAG, "Events Nb : " + list.size());

		adapter.clear();
		adapter.addAll(list);
		adapter.notifyDataSetChanged();
	}
}
