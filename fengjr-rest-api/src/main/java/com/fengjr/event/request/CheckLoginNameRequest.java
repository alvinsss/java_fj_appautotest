package com.fengjr.event.request;

import android.content.Context;

import com.fengjr.api.R;
import com.fengjr.event.Request;

public class CheckLoginNameRequest extends Request {
	public CheckLoginNameRequest(Context ctx, String loginName) {
		super(ctx, ctx.getString(R.string.api_v2_check_login_name));
		add("loginName",loginName);
	}
}
