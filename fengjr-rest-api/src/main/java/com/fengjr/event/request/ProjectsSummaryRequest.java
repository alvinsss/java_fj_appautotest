package com.fengjr.event.request;

import android.content.Context;

import com.fengjr.api.R;
import com.fengjr.event.Request;

public class ProjectsSummaryRequest extends Request {

	public ProjectsSummaryRequest(Context ctx) {
		super(ctx, ctx.getString(R.string.api_projects_summary));
	}
	
}

