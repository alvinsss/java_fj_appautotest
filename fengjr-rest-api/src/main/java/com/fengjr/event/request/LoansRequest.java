package com.fengjr.event.request;

import android.content.Context;

import com.fengjr.api.R;
import com.fengjr.event.Request;
import com.fengjr.model.enums.LoanPurpose;
import com.fengjr.model.enums.LoanStatus;

public class LoansRequest extends Request {

	public LoansRequest(Context ctx, String lastLoanId, int pageSize, LoanStatus status) {
		super(ctx, ctx.getString(R.string.api_loans));
		
		add("lastLoanId", lastLoanId)
		.add("pageSize", String.valueOf(pageSize))
		.add("status", status.name());
		
	}
	
	public LoansRequest(Context ctx, LoanPurpose purpose) {
		super(ctx, ctx.getString(R.string.api_loans_purpose, purpose.name()));
	}
	
	
}

