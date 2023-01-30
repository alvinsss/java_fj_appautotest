package com.fengjr.api;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * 
 * @author suetming (suetming.ma@fengjr.com)
 * 
 *         创建时间：2013-10-15 下午5:35:31
 * 
 */
public class Network {

	public static boolean isNetworkConnected(Context context) {
		ConnectivityManager cm = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);

		NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
		boolean isConnected = activeNetwork != null
				&& activeNetwork.isConnectedOrConnecting();
		return isConnected;
	}
}
