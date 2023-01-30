package com.fengjr.model;

import java.util.List;

import android.text.TextUtils;

public class Version {

	private String version;

	public String url;

	public String name;

	public String description;

	public boolean forceupdate;

	public List<Channel> channel;

	public int getVersionCode() {
		int versionCode = -1;
		if (!TextUtils.isEmpty(version) && TextUtils.isDigitsOnly(version)) {
			versionCode = Integer.parseInt(version);
		}

		return versionCode;

	}

	public class Channel {
		public String name;
		public String type;
		public String url;
	}
}
