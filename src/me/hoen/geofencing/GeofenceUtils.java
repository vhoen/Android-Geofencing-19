/*
 * Copyright (C) 2013 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package me.hoen.geofencing;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import com.google.android.gms.location.Geofence;

/**
 * This class defines constants used by location sample apps.
 */
public final class GeofenceUtils {

	// Used to track what type of geofence removal request was made.
	public enum REMOVE_TYPE {
		INTENT, LIST
	}

	// Used to track what type of request is in process
	public enum REQUEST_TYPE {
		ADD, REMOVE
	}

	/*
	 * A log tag for the application
	 */
	public static final String APPTAG = "me.example";

	// Intent actions
	public static final String ACTION_CONNECTION_ERROR = "me.hoen.geofencing.ACTION_CONNECTION_ERROR";

	public static final String ACTION_CONNECTION_SUCCESS = "me.hoen.geofencing.ACTION_CONNECTION_SUCCESS";

	public static final String ACTION_GEOFENCES_ADDED = "me.hoen.geofencing.ACTION_GEOFENCES_ADDED";

	public static final String ACTION_GEOFENCES_REMOVED = "me.hoen.geofencing.ACTION_GEOFENCES_DELETED";

	public static final String ACTION_GEOFENCE_ERROR = "me.hoen.geofencing.ACTION_GEOFENCES_ERROR";

	public static final String ACTION_GEOFENCE_TRANSITION = "me.hoen.geofencing.ACTION_GEOFENCE_TRANSITION";

	public static final String ACTION_GEOFENCE_TRANSITION_ERROR = "me.hoen.geofencing.ACTION_GEOFENCE_TRANSITION_ERROR";

	public static final String ACTION_RECEIVE_GEOFENCE = "me.hoen.geofencing.ACTION_RECEIVE_GEOFENCE";

	// The Intent category used by all Location Services sample apps
	public static final String CATEGORY_LOCATION_SERVICES = "me.hoen.geofencing.CATEGORY_LOCATION_SERVICES";

	// Keys for extended data in Intents
	public static final String EXTRA_CONNECTION_CODE = "com.example.android.EXTRA_CONNECTION_CODE";

	public static final String EXTRA_CONNECTION_ERROR_CODE = "me.hoen.geofencing.EXTRA_CONNECTION_ERROR_CODE";

	public static final String EXTRA_CONNECTION_ERROR_MESSAGE = "me.hoen.geofencing.EXTRA_CONNECTION_ERROR_MESSAGE";

	public static final String EXTRA_GEOFENCE_STATUS = "me.hoen.geofencing.EXTRA_GEOFENCE_STATUS";

	/*
	 * Keys for flattened geofences stored in SharedPreferences
	 */
	public static final String KEY_LATITUDE = "me.hoen.geofencing.KEY_LATITUDE";

	public static final String KEY_LONGITUDE = "me.hoen.geofencing.KEY_LONGITUDE";

	public static final String KEY_RADIUS = "me.hoen.geofencing.KEY_RADIUS";

	public static final String KEY_EXPIRATION_DURATION = "me.hoen.geofencing.KEY_EXPIRATION_DURATION";

	public static final String KEY_TRANSITION_TYPE = "me.hoen.geofencing.KEY_TRANSITION_TYPE";

	// The prefix for flattened geofence keys
	public static final String KEY_PREFIX = "me.hoen.geofencing.KEY";

	// Invalid values, used to test geofence storage when retrieving geofences
	public static final long INVALID_LONG_VALUE = -999l;

	public static final float INVALID_FLOAT_VALUE = -999.0f;

	public static final int INVALID_INT_VALUE = -999;

	/*
	 * Constants used in verifying the correctness of input values
	 */
	public static final double MAX_LATITUDE = 90.d;

	public static final double MIN_LATITUDE = -90.d;

	public static final double MAX_LONGITUDE = 180.d;

	public static final double MIN_LONGITUDE = -180.d;

	public static final float MIN_RADIUS = 1f;

	/*
	 * Define a request code to send to Google Play services This code is
	 * returned in Activity.onActivityResult
	 */
	public final static int CONNECTION_FAILURE_RESOLUTION_REQUEST = 9000;

	// A string of length 0, used to clear out input fields
	public static final String EMPTY_STRING = new String();

	public static final CharSequence GEOFENCE_ID_DELIMITER = ",";

	public static final String EXTRA_GEOFENCE_ID = "geofence_id";

	public static final String EXTRA_GEOFENCE_TRANSITION_TYPE = "geofence_transition_type";

	public static String getTransitionString(int transition) {
		if (transition == Geofence.GEOFENCE_TRANSITION_ENTER) {
			return "IN";
		}

		if (transition == Geofence.GEOFENCE_TRANSITION_EXIT) {
			return "OUT";
		}

		if (transition == Geofence.GEOFENCE_TRANSITION_DWELL) {
			return "DWELL";
		}

		return null;
	}
	
	static public String getDisplayDate(Calendar date) {
		String displayDate = "";
		Calendar startDate = Calendar.getInstance();
		startDate.set(Calendar.HOUR_OF_DAY, 0);
		startDate.set(Calendar.MINUTE, 0);
		startDate.set(Calendar.SECOND, 0);

		Calendar endDate = Calendar.getInstance();
		endDate.set(Calendar.HOUR_OF_DAY, 23);
		endDate.set(Calendar.MINUTE, 59);
		endDate.set(Calendar.SECOND, 59);

		if (date.after(startDate) && date.before(endDate)) {
			SimpleDateFormat format = new SimpleDateFormat("HH:mm",
					Locale.getDefault());
			displayDate = format.format(date.getTime());
		} else {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd",
					Locale.getDefault());
			displayDate = format.format(date.getTime());
		}

		return displayDate;
	}

}
