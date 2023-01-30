package com.fengjr.event.request;

import android.content.Context;

import com.fengjr.api.R;
import com.fengjr.event.Request;

/**
 * 检查用户与联动已经签署哪些协议
 */
public class UpaymentAgreementRequest extends Request {
	public UpaymentAgreementRequest(Context ctx) {
		super(ctx, ctx.getString(R.string.api_v2_agreement));
	}
}
