package com.fengjr.event.request;

import android.content.Context;

import com.fengjr.api.R;
import com.fengjr.event.Request;


public class MarkFavoriteRequest extends Request {

	public MarkFavoriteRequest(Context ctx, String projectId) {
		super(ctx, ctx.getString(R.string.api_mark_favorite, projectId));
	}
	
}

