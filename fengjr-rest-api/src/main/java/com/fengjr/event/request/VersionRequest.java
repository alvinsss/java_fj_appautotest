package com.fengjr.event.request;

import android.content.Context;

import com.fengjr.api.R;
import com.fengjr.event.Request;

public class VersionRequest extends Request {

	public VersionRequest(Context ctx, String channel) {
		super(ctx.getString(R.string.api_version));
		add("type","android");
		add("channel",channel);
	}
	
}
