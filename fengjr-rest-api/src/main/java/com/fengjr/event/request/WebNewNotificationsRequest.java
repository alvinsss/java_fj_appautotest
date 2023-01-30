package com.fengjr.event.request;

import android.content.Context;

import com.fengjr.api.R;
import com.fengjr.event.Request;


public class WebNewNotificationsRequest extends Request {
	
	public WebNewNotificationsRequest(Context ctx) {
		super(ctx, ctx.getString(R.string.api_v2_new_webnotification));
		add("page", "1");
		add("pageSize", "20");
	}
	
	public String buildApi() {
		String baseUrl = getBaseDomain();
		this.api = baseUrl + "mc/api/" + requestApiVersion() + subPathApi;
		return api;
	}
}
