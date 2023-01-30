package com.fengjr.event.request;

import android.content.Context;

import com.fengjr.api.R;
import com.fengjr.event.Request;


/**
 * 注册为联动用户
 */
public class UpaymentRegisterRequest extends Request {
	
	public UpaymentRegisterRequest(Context ctx, String userName, String idCode, String userid) {
		super(ctx, ctx.getString(R.string.api_v2_upayment_register));
		
		add("userId",userid);
		add("userName",userName);
		add("idCode",idCode);
	}
	
}
