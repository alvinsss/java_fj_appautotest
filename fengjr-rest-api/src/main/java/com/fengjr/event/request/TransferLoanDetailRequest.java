package com.fengjr.event.request;

import android.content.Context;

import com.fengjr.api.R;
import com.fengjr.event.Request;

public class TransferLoanDetailRequest extends Request {

	public TransferLoanDetailRequest(Context ctx, String creditAssignId) {
		super(ctx, ctx.getString(R.string.api_transfer_loan_detail,creditAssignId));
	}

}
