package com.fengjr.event.request;

import android.content.Context;

import com.fengjr.api.R;
import com.fengjr.event.Request;

public class TransferBuyRequest extends Request {

	public TransferBuyRequest(Context ctx, String creditAssignId,String buyCreditDealAmount) {
		super(ctx, ctx.getString(R.string.api_transfer_buy,creditAssignId));
		add("buyCreditDealAmount", buyCreditDealAmount);
	}
	
	@Override
	protected String requestApiVersion() {
		return API_VERSION_V3;
	}

}
