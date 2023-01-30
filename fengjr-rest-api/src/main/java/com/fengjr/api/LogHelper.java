package com.fengjr.api;

import android.util.Log;

public class LogHelper {
	public static final boolean LOG_ENABLED = true;
	public static void d(String tag,String msg){
		if(LOG_ENABLED){
			Log.d(tag,msg);
		}
	}

}
