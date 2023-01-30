package com.fengjr.event.request;

import android.content.Context;

import com.fengjr.api.R;
import com.fengjr.event.Request;

public class RepaymentPlanCreditAssignRequest extends Request {

	public RepaymentPlanCreditAssignRequest(Context ctx,String creditAssignId) {
		super(ctx, ctx.getString(R.string.api_repayment_plan_creditassign,creditAssignId));
	}

}
