package com.fengjr.event.request;

import android.content.Context;

import com.fengjr.api.R;
import com.fengjr.event.Request;

public class ProofsRequest extends Request {

	public ProofsRequest(Context ctx, int resId, String id) {
		super(ctx, ctx.getString(resId, id));
	}
	
}
