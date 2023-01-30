package com.fengjr.event.request;

import android.content.Context;

import com.fengjr.api.R;
import com.fengjr.event.Request;

public class LoanUserRequest extends Request {
	public String mLoanid;	
	
	public LoanUserRequest(Context ctx,String loanId) {
		super(ctx, ctx.getString(R.string.api_loan_user, loanId));
		mLoanid = loanId;
	}
}
