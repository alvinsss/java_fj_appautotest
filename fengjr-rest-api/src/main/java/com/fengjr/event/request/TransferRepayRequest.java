package com.fengjr.event.request;

import android.content.Context;

import com.fengjr.api.R;
import com.fengjr.event.Request;

public class TransferRepayRequest extends Request {

	public TransferRepayRequest(Context ctx, String creditAssignId) {
		super(ctx, ctx.getString(R.string.api_transfer_repay_list,creditAssignId));
	}

}
