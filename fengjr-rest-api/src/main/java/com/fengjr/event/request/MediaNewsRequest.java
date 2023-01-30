package com.fengjr.event.request;

import android.content.Context;

import com.fengjr.api.R;
import com.fengjr.event.Request;

public class MediaNewsRequest extends Request {

	public MediaNewsRequest(Context ctx) {
		super(ctx,  ctx.getString(R.string.api_v2_media));
	}	
}
