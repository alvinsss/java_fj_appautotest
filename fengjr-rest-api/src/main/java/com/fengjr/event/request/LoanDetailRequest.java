package com.fengjr.event.request;

import android.content.Context;

import com.fengjr.api.R;
import com.fengjr.event.Request;

public class LoanDetailRequest extends Request {

	public LoanDetailRequest(Context ctx,String loanRequestId) {
		super(ctx, ctx.getString(R.string.api_loan_detail, loanRequestId));
	}
}
