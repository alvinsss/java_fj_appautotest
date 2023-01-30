package com.fengjr.event.request;

import android.content.Context;

import com.fengjr.api.R;
import com.fengjr.event.Request;


public class LoginRequest extends Request {

	public final static String client_id = "bddc1dbb-0fe9-44ef-a3dc-6bdce55bd95e";
	public final static String client_secret = "118b58a26b5759bc68db33f196430d567ec4fd03e38a105cf8e6c8b75964a950";
	public final static String grant_type = "password";
	
	public LoginRequest(Context ctx) {
		super(ctx, ctx.getString(R.string.api_login));
		
		add("client_id", client_id)
		.add("client_secret", client_secret)
		.add("grant_type", grant_type);
	}
	
}
