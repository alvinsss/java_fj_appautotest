package com.fengjr.event.request;

import android.content.Context;

import com.fengjr.api.R;
import com.fengjr.event.Request;
import com.fengjr.model.enums.LoanPurpose;

public class LoansSummaryRequest extends Request {

	public LoanPurpose purpose;
	
	public LoansSummaryRequest(Context ctx) {
		super(ctx, ctx.getString(R.string.api_loans_summary));
	}
	
	public LoansSummaryRequest(Context ctx, LoanPurpose purpose) {
		super(ctx, ctx.getString(R.string.api_loans_summary_purpose, purpose.name()));
		this.purpose = purpose;
	}
}

