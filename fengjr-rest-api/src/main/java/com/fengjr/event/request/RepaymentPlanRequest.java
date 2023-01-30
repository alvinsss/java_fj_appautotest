package com.fengjr.event.request;

import android.content.Context;

import com.fengjr.api.R;
import com.fengjr.event.Request;

public class RepaymentPlanRequest extends Request {

	public RepaymentPlanRequest(Context ctx,String loanId,String investId) {
		super(ctx, ctx.getString(R.string.api_v2_repayment_plan,loanId,investId));
	}

}
