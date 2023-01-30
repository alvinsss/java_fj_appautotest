package com.fengjr.event.request;

import android.content.Context;

import com.fengjr.api.R;
import com.fengjr.event.Request;

public class CreateCreditAssignRequest extends Request {

	public CreateCreditAssignRequest(Context context) {
		super(context, context.getString(R.string.api_create_credit_assign));
		add("needValidate", true);
		add("acceptAgreement", true);

	}

	@Override
	protected String requestApiVersion() {

		return API_VERSION_V3;
	}

}
