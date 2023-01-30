package com.fengjr.event.request;

import android.content.Context;

import com.fengjr.api.R;
import com.fengjr.event.Request;

public class CreditAssignExpectedRequest extends Request {

	public CreditAssignExpectedRequest(Context context, String investId) {

		super(context, context.getString(R.string.api_credit_assign_expect,
				investId));
	}

}
