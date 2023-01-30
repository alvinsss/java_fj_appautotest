package com.fengjr.event.request;

import android.content.Context;

import com.fengjr.api.R;
import com.fengjr.event.Request;

public class ProjectFavoritesRequest extends Request {
	public ProjectFavoritesRequest(Context ctx) {
		super(ctx, ctx.getString(R.string.api_my_project_favorites));
		//add("page", 1).add("pageSize", 10);
	}
}
