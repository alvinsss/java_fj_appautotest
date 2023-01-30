package com.fengjr.event.request;

import android.content.Context;

import com.fengjr.api.R;
import com.fengjr.event.Request;

public class PublicKeyRequest extends Request {

	public PublicKeyRequest(Context ctx) {

		super(ctx, ctx.getString(R.string.api_public_key));
		add("ttl", "1800");
	}

}
