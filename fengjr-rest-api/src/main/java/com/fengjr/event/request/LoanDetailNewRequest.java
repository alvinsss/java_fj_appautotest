package com.fengjr.event.request;

import android.content.Context;

import com.fengjr.api.R;
import com.fengjr.event.Request;

public class LoanDetailNewRequest extends Request {
	public String mLoanid;

	public LoanDetailNewRequest(Context ctx, String loanRequestId) {
		super(ctx, ctx.getString(R.string.api_loan_detail, loanRequestId));
	}

	@Override
	protected String requestApiVersion() {
		return API_VERSION_V3;
	}

}
