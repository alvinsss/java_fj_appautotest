package com.fengjr.event.request;

import android.content.Context;

import com.fengjr.api.R;
import com.fengjr.event.Request;

public class UnmarkFavoriteRequest extends Request {

	public UnmarkFavoriteRequest(Context ctx, String projectId) {
		super(ctx, ctx.getString(R.string.api_unmark_favorite, projectId));
	}
}
