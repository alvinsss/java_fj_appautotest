package com.fengjr.event.request;

import android.content.Context;

import com.fengjr.api.R;
import com.fengjr.event.Request;

public class MyInvestRecordHoldRequest extends Request {

	public MyInvestRecordHoldRequest(int page,int pageSize,Context ctx) {
		super(ctx, ctx.getString(R.string.api_v2_invest_record_hold));
		
//		this.api = "http://10.255.2.64:8080" + ctx.getString(R.string.api_v2_invest_record_hold);
		
		addToForm("pageSize", pageSize).addToForm("page", page);
	}
	
	public MyInvestRecordHoldRequest addToForm(String key, int value) {
		request.add(key, String.valueOf(value));
		return this;
	}

}
