package com.fengjr.event.request;

import android.content.Context;

import com.fengjr.api.R;
import com.fengjr.event.Request;
import com.fengjr.model.FilterParam;
import com.fengjr.model.enums.LoanPurpose;
import com.fengjr.model.enums.LoanStatus;

public class LoansFilterRequest extends Request {
	public LoanPurpose mPurpose;
	
	public LoansFilterRequest(Context ctx, String lastLoanId, int pageSize, LoanStatus status, int minDuration, int maxDuration, int minRate, int maxRate, LoanPurpose purpose) {
		super(ctx, ctx.getString(R.string.api_loan_filter));
		
		add("lastLoanId", lastLoanId)
		.add("pageSize", String.valueOf(pageSize))
		.add("status", status.name())
		.add("minDuration", minDuration)
		.add("maxDuration", maxDuration)
		.add("minRate", minRate)
		.add("maxRate", maxRate)
		.add("purpose", purpose.name());
	}
	
	public LoansFilterRequest(Context ctx, LoanPurpose purpose, String lastLoanId) {
		super(ctx, ctx.getString(R.string.api_loan_filter));
		mPurpose = purpose;
		add("lastLoanId", lastLoanId);
		add("purpose", purpose.name());
		add("pageSize", "10");
		add("status", "SCHEDULED");
		add("minDuration", "0");
		add("maxDuration", "60");
		add("minRate", "0");
		add("maxRate", "100");
	}
	
	public LoansFilterRequest(Context ctx, FilterParam param){
		super(ctx, ctx.getString(R.string.api_loan_filter));
		mPurpose = param.purpose;
		
		add("lastLoanId", param.lastLoanId);
		add("purpose", mPurpose.name());
		add("pageSize", param.pageSize);
		add("status", param.status);
		add("minDuration", param.minDuration);
		add("maxDuration", param.maxDuration);
		add("minRate", param.minRate);
		add("maxRate", param.maxRate);
		
	}
}

