package com.fengjr.event.request;

import android.content.Context;

import com.fengjr.api.R;
import com.fengjr.event.Request;

public class MarkAllRequest extends Request {
	
	
	public MarkAllRequest(Context ctx) {
		super(ctx, ctx.getString(R.string.api_v2_markall));
	}

	public String buildApi() {
		String baseUrl = getBaseDomain();
		this.api = baseUrl + "mc/api/" + requestApiVersion() + subPathApi;
		return api;
	}
}
