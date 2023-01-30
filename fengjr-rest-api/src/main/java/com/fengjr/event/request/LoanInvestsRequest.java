package com.fengjr.event.request;

import android.content.Context;

import com.fengjr.api.R;
import com.fengjr.event.Request;

public class LoanInvestsRequest extends Request {
	public String mLoanid;
	
	public LoanInvestsRequest(Context ctx, String loanId) {
		super(ctx, ctx.getString(R.string.api_loan_invests, loanId));
		mLoanid = loanId;
	}
	
}



