package com.fengjr.event.request;

import android.content.Context;

import com.fengjr.api.R;
import com.fengjr.event.Request;


public class SmsCaptchaRequest extends Request {

	public SmsCaptchaRequest(Context ctx) {
		super(ctx, ctx.getString(R.string.api_sms_captcha));
	}
	
}
