package com.fengjr.event.request;

import android.content.Context;

import com.fengjr.api.R;
import com.fengjr.event.Request;

public class CorporationRequest extends Request {
	public String mLoanid;
	
	public CorporationRequest(Context ctx,String corpationId, String loanid) {
		super(ctx, ctx.getString(R.string.api_corporation, corpationId));
		mLoanid = loanid;
	}
}
