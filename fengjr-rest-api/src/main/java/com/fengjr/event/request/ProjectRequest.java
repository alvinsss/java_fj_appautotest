package com.fengjr.event.request;

import android.content.Context;

import com.fengjr.api.R;
import com.fengjr.event.Request;

public class ProjectRequest extends Request {

	public ProjectRequest(Context ctx, String projectId) {
		super(ctx, ctx.getString(R.string.api_project, projectId));
	}
	
}

