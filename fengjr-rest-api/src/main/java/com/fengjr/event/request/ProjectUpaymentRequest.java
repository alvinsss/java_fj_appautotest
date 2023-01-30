package com.fengjr.event.request;

import android.content.Context;
import android.util.Log;

import com.fengjr.api.R;
import com.fengjr.event.Request;

public class ProjectUpaymentRequest extends Request {

	public ProjectUpaymentRequest(Context ctx, String projectId, String orderId) {
		super(ctx, ctx.getString(R.string.api_payment_project));
		
		Log.e("project", api);
		add("projectId", projectId).add("investId", orderId);
	}

}
