package me.hoen.geofencing;

import java.util.ArrayList;

import android.text.format.DateUtils;

import com.google.android.gms.location.Geofence;

public class SimpleGeofenceDataStore {
	private static final long GEOFENCE_EXPIRATION_IN_HOURS = 12;
	public static final long GEOFENCE_EXPIRATION_IN_MILLISECONDS = GEOFENCE_EXPIRATION_IN_HOURS
			* DateUtils.HOUR_IN_MILLIS;
	
	protected ArrayList<SimpleGeofence> geofences = new ArrayList<>();

	private static SimpleGeofenceDataStore instance = new SimpleGeofenceDataStore();

	public static SimpleGeofenceDataStore getInstance() {
		return instance;
	}

	public SimpleGeofenceDataStore() {
		
		geofences.add(new SimpleGeofence("Sqala", 33.603199005127, -7.61911010742188, 50,
				GEOFENCE_EXPIRATION_IN_MILLISECONDS,
				Geofence.GEOFENCE_TRANSITION_ENTER
						| Geofence.GEOFENCE_TRANSITION_DWELL
						| Geofence.GEOFENCE_TRANSITION_EXIT));

		geofences.add(new SimpleGeofence("RicksCafe", 33.605079, -7.620328, 50,
				GEOFENCE_EXPIRATION_IN_MILLISECONDS,
				Geofence.GEOFENCE_TRANSITION_ENTER
						| Geofence.GEOFENCE_TRANSITION_DWELL
						| Geofence.GEOFENCE_TRANSITION_EXIT));

	}

	public ArrayList<SimpleGeofence> getSimpleGeofences() {
		return this.geofences;
	}
}
