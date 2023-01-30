package com.fengjr.event.request;

import android.content.Context;

import com.fengjr.api.R;
import com.fengjr.event.Request;

public class AuthenticatesRequest extends Request {

	public AuthenticatesRequest(Context ctx) {
		super(ctx, ctx.getString(R.string.api_my_authenticates));
	}
	
	
}
