package com.fengjr.event.request;

import android.content.Context;

import com.fengjr.api.R;
import com.fengjr.event.Request;

public class RewardRelateRequest extends Request {

	public RewardRelateRequest(Context ctx, String rewardId) {
		super(ctx, ctx.getString(R.string.api_reward_relate));
		add("rewardId", rewardId);
	}
	
}

