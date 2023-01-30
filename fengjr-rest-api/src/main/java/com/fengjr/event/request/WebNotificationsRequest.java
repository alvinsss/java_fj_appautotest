package com.fengjr.event.request;

import android.content.Context;

import com.fengjr.api.R;
import com.fengjr.event.Request;


public class WebNotificationsRequest extends Request {
	
	public WebNotificationsRequest(Context ctx, int page, int pagesize) {
		super(ctx, ctx.getString(R.string.api_v2_webnotification));
		add("page", String.valueOf(page) );
		add("pageSize", String.valueOf(pagesize) );
	}
	
	public String buildApi() {
		String baseUrl = getBaseDomain();
		this.api = baseUrl + "mc/api/" + requestApiVersion() + subPathApi;
		return api;
	}
}
