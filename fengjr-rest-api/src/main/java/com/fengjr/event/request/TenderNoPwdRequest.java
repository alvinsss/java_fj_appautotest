package com.fengjr.event.request;

import android.content.Context;

import com.fengjr.api.R;
import com.fengjr.event.Request;

public class TenderNoPwdRequest extends Request {
	public TenderNoPwdRequest(Context ctx, String loanId, double amount) {
		super(ctx, ctx.getString(R.string.api_v2_tender_nopwd, loanId, amount));
	}
}
