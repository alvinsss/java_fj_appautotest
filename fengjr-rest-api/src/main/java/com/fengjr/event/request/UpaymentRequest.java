package com.fengjr.event.request;

import android.content.Context;

import com.fengjr.api.R;
import com.fengjr.event.Request;

public class UpaymentRequest extends Request {

	public UpaymentRequest(Context ctx, String loanId, int amount) {
		super(ctx, ctx.getString(R.string.api_payment));
		add("loanId", loanId).add("amount", amount);
	}

}
