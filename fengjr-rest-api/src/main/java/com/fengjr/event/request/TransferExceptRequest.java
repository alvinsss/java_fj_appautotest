package com.fengjr.event.request;

import android.content.Context;

import com.fengjr.api.R;
import com.fengjr.event.Request;

public class TransferExceptRequest extends Request {

	public TransferExceptRequest(Context ctx, String creditAssignId,
			String dealAmount) {
		super(ctx, ctx.getString(R.string.api_transfer_buy_expect,
				creditAssignId,dealAmount));
		
	}

}
