package com.fengjr.event;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Log;


public class AppPreferences {
	private static final String APP_SHARED_PREFS = AppPreferences.class
			.getSimpleName();
	
	//最后提示软件更新时间
	public static final String LAST_POPUP_UPDATE_TIME = "last_popup_update_time";
	
	private SharedPreferences sharedPrefs;
	private Editor prefsEditor;
	private String key = "fengjr";
	
	public AppPreferences(Context context) {
		this.sharedPrefs = context.getSharedPreferences(
				APP_SHARED_PREFS, Activity.MODE_PRIVATE);
		this.prefsEditor = sharedPrefs.edit();
	}

	public String getString(String key) {
		String encrypt = sharedPrefs.getString(String.valueOf(key), "");
		String plain = "";
		if (!TextUtils.isEmpty(encrypt)) {
			try {
				plain = AES.decrypt(key, encrypt);
			} catch (Exception e) {
				error("解码失败");
				e.printStackTrace();
				return plain;
			}
		}
		return plain;
	}

	public boolean getBoolean(String key, boolean defaultValue) {
		String encrypt = sharedPrefs.getString(String.valueOf(key), "");
		String plain = String.valueOf(defaultValue);
		if (!TextUtils.isEmpty(encrypt)) {
			try {
				plain = AES.decrypt(key, encrypt);
			} catch (Exception e) {
				error("解码失败");
				e.printStackTrace();
				return defaultValue;
			}
		}
		return Boolean.valueOf(plain);
	}
	
	public long getLong(String key) {
		String encrypt = sharedPrefs.getString(String.valueOf(key), "0");
		long plain = -1;
		if (!TextUtils.isEmpty(encrypt)) {
			try {
				String decrypt = AES.decrypt(key, encrypt);
				plain = Long.valueOf(decrypt);
			} catch (Exception e) {
				error("解码失败");
				e.printStackTrace();
				return plain;
			}
		}
		return plain;
	}
	
	public void save(String key, String text) {
		try {
			String encrypt = AES.encrypt(key, text);
			prefsEditor.putString(String.valueOf(key), encrypt);
			prefsEditor.commit();
		} catch (Exception e) {
			error("编码失败");
			e.printStackTrace();
		}
	}
	
	public void save(String key, boolean value) {
		try {
			String encrypt = AES.encrypt(key, String.valueOf(value));
			prefsEditor.putString(String.valueOf(key), encrypt);
			prefsEditor.commit();
		} catch (Exception e) {
			error("编码失败");
			e.printStackTrace();
		}
	}
	
	public void save(String key, long value) {
		try {
			String encrypt = AES.encrypt(key, String.valueOf(value));
			prefsEditor.putString(String.valueOf(key), encrypt);
			prefsEditor.commit();
		} catch (Exception e) {
			error("编码失败");
			e.printStackTrace();
		}
	}
	
	public static void debug(String debug) {
		Log.d(APP_SHARED_PREFS, debug);
	}

	public void info(String info) {
		Log.i(APP_SHARED_PREFS, info);
	}

	public void error(String error) {
		Log.i(APP_SHARED_PREFS, error);
	}

	public void warning(String warning) {
		Log.w(APP_SHARED_PREFS, warning);
	}
}

