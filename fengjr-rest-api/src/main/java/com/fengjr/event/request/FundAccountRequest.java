package com.fengjr.event.request;

import android.content.Context;

import com.fengjr.api.R;
import com.fengjr.event.Request;

public class FundAccountRequest extends Request {

	public FundAccountRequest(Context ctx) {
		super(ctx,  ctx.getString(R.string.api_my_fund_account));
	}
	
}
