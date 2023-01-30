package com.fengjr.event.request;

import android.content.Context;

import com.fengjr.api.R;
import com.fengjr.event.Request;

public class LoanRequest extends Request {

	public LoanRequest(Context ctx,String loanId) {
		super(ctx, ctx.getString(R.string.api_loan, loanId));
	}
}
