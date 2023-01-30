package com.fengjr.event.request;

import android.content.Context;

import com.fengjr.api.R;
import com.fengjr.event.Request;

public class PublicationRequest extends Request {

	public PublicationRequest(Context ctx) {
		super(ctx,  ctx.getString(R.string.api_v2_publications));
	}	
}
