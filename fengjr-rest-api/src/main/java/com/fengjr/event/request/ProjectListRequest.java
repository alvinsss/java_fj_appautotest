package com.fengjr.event.request;

import android.content.Context;

import com.fengjr.api.R;
import com.fengjr.event.Request;

public class ProjectListRequest extends Request {

	public ProjectListRequest(Context ctx) {
		super(ctx,  ctx.getString(R.string.api_projects_list));
		
	}
	
}
