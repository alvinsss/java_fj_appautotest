package com.fengjr.event.request;

import android.content.Context;

import com.fengjr.api.R;
import com.fengjr.event.Request;

public class UnmarkLikeRequest extends Request {

	public UnmarkLikeRequest(Context ctx, String projectId) {
		super(ctx, ctx.getString(R.string.api_v2_unmarklike, projectId));
	}
}
