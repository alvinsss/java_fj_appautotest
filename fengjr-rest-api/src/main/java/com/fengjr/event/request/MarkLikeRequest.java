package com.fengjr.event.request;

import android.content.Context;

import com.fengjr.api.R;
import com.fengjr.event.Request;

public class MarkLikeRequest extends Request {

	public MarkLikeRequest(Context ctx, String projectId) {
		super(ctx, ctx.getString(R.string.api_v2_marklike, projectId));
	}
}
