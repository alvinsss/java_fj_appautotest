package com.fengjr.event.request;

import android.content.Context;

import com.fengjr.api.R;
import com.fengjr.event.Request;

public class MyInvestRecordAssignedAlreadyRequest extends Request {

	public MyInvestRecordAssignedAlreadyRequest(int page,int pageSize,Context ctx) {
		super(ctx, ctx.getString(R.string.api_v2_invest_record_assigned_already));
		
		
		addToForm("pageSize", pageSize).addToForm("page", page);
	}
	
	public MyInvestRecordAssignedAlreadyRequest addToForm(String key, int value) {
		request.add(key, String.valueOf(value));
		return this;
	}

}
