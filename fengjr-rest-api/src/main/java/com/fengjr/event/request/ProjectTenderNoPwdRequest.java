package com.fengjr.event.request;

import android.content.Context;

import com.fengjr.api.R;
import com.fengjr.event.Request;

public class ProjectTenderNoPwdRequest extends Request {
	public ProjectTenderNoPwdRequest(Context ctx, String projectId, String investId) {
		super(ctx,  ctx.getString(R.string.api_v2_project_tender_nopwd, projectId, investId));
	}
}
