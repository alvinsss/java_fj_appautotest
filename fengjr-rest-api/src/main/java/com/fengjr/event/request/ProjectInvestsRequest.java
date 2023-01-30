package com.fengjr.event.request;

import android.content.Context;

import com.fengjr.api.R;
import com.fengjr.event.Request;

public class ProjectInvestsRequest extends Request {

	public ProjectInvestsRequest(Context ctx) {
		super(ctx,  ctx.getString(R.string.api_my_project_invests));
		add("status", "FROZEN&status=FINISHED&status=SETTLED&status=CLEARED&");
		//add("page", 1).add("pageSize", 10);
	}
	
}

