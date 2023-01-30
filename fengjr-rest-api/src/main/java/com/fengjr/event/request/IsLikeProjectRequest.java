package com.fengjr.event.request;

import android.content.Context;

import com.fengjr.api.R;
import com.fengjr.event.Request;

public class IsLikeProjectRequest extends Request {

	public IsLikeProjectRequest(Context ctx, String projectId) {
		super(ctx, ctx.getString(R.string.api_v2_islike, projectId));
	}	
}
