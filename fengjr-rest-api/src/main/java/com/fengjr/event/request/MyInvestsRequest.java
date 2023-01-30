package com.fengjr.event.request;

import android.content.Context;

import com.fengjr.api.R;
import com.fengjr.event.Request;
import com.fengjr.model.enums.LoanPurpose;

public class MyInvestsRequest extends Request {

	public LoanPurpose purpose;

	public MyInvestsRequest(int page, int pageSize, Context ctx) {
		super(ctx, ctx.getString(R.string.api_my_invests));
		
		addToForm("pageSize", pageSize).addToForm("page", page);
	}
	
	public MyInvestsRequest(int page, int pageSize, LoanPurpose purpose, Context ctx) {
		super(ctx, ctx.getString(R.string.api_my_invests_purpose, purpose.name()));
		
		addToForm("pageSize", pageSize).addToForm("page", page);
		
		this.purpose = purpose;
	}
	
	public MyInvestsRequest addToForm(String key, int value) {
		request.add(key, String.valueOf(value));
		return this;
	}
}
