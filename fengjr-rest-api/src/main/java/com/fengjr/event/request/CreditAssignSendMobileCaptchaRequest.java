package com.fengjr.event.request;

import android.content.Context;

import com.fengjr.api.R;
import com.fengjr.event.Request;

public class CreditAssignSendMobileCaptchaRequest extends Request {

	public CreditAssignSendMobileCaptchaRequest(Context context) {
		super(context, context
				.getString(R.string.api_credit_assign_send_captcha));

	}

}
