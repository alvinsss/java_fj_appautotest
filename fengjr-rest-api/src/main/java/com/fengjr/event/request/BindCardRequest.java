package com.fengjr.event.request;

import android.content.Context;

import com.fengjr.api.R;
import com.fengjr.event.Request;

public class BindCardRequest extends Request {

	public BindCardRequest(Context ctx, String cardId) {
		super(ctx, ctx.getString(R.string.api_bindcard));
		
		add("cardId", cardId);
	}
	
}

