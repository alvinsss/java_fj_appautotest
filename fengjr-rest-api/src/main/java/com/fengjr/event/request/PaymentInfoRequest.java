package com.fengjr.event.request;

import android.content.Context;

import com.fengjr.api.R;
import com.fengjr.event.Request;

public class PaymentInfoRequest extends Request {
	public PaymentInfoRequest(Context ctx) {
		super(ctx, ctx.getString(R.string.api_v2_payment_info));
	}
}
