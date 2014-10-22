package me.hoen.geofencing.display;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import me.hoen.geofencing.GeofenceUtils;
import me.hoen.geofencing.R;
import me.hoen.geofencing.db.Event;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class EventListAdapter extends ArrayAdapter<Event> {
	protected Activity activity;
	protected ArrayList<Event> list;
	protected int textViewResourceId;

	public EventListAdapter(Activity activity, int textViewResourceId,
			ArrayList<Event> list) {
		super(activity, textViewResourceId, list);

		this.activity = activity;
		this.textViewResourceId = textViewResourceId;
		this.list = list;

	}

	public int getCount() {
		return list.size();
	}

	public Event getItem(Event position) {
		return position;
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(final int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) activity
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(textViewResourceId, parent, false);

		Event e = list.get(position);

		TextView typeTv = (TextView) rowView.findViewById(R.id.type);
		typeTv.setText(e.getType());

		TextView placenameTv = (TextView) rowView.findViewById(R.id.placename);
		placenameTv.setText(e.getPlaceName());

		try{
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",
				Locale.getDefault());
		calendar.setTime(sdf.parse(e.getDate()));
		
		TextView dateTv = (TextView) rowView.findViewById(R.id.date);
		dateTv.setText(GeofenceUtils.getDisplayDate(calendar));
		}
		catch(Exception exception){
			exception.printStackTrace();
		}

		return rowView;
	}

}
