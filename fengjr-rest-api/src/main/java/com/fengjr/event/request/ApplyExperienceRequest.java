package com.fengjr.event.request;

import android.content.Context;

import com.fengjr.api.R;
import com.fengjr.event.Request;

public class ApplyExperienceRequest extends Request {

	public ApplyExperienceRequest(Context ctx) {
		super(ctx, ctx.getString(R.string.api_apply_experience));
	}
}
