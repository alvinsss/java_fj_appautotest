package com.fengjr.event.request;

import android.content.Context;

import com.fengjr.api.R;
import com.fengjr.event.Request;

public class ProjectInvestInfosRequest extends Request {

	public ProjectInvestInfosRequest(Context ctx) {
		super(ctx,  ctx.getString(R.string.api_my_project_investinfos));
		
		//add("page", 1).add("pageSize", 20);
	}
	
}
