package com.fengjr.event.request;

import android.content.Context;

import com.fengjr.api.R;
import com.fengjr.event.Request;

public class RewardConfirmRequest extends Request {

	public RewardConfirmRequest(Context ctx, String value) {
		super(ctx, ctx.getString(R.string.api_reward_confirm, value));
	 
	}

}
