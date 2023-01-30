package com.fengjr.event.request;

import android.content.Context;

import com.fengjr.api.R;
import com.fengjr.event.Request;

public class FeedbackRequest extends Request {
	
	public FeedbackRequest(Context ctx, String content, String contact) {
		super(ctx, ctx.getString(R.string.api_v2_feedback));
		
		add("contact",contact);
		add("feedback",content);
	}
}
