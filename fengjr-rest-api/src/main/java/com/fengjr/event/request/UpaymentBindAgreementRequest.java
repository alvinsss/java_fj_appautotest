package com.fengjr.event.request;

import java.util.List;

import android.content.Context;
import android.net.Uri;

import com.fengjr.api.R;
import com.fengjr.event.AppPreferences;
import com.fengjr.event.Request;

/**
 * 绑定联动的相关协议接口
 */
public class UpaymentBindAgreementRequest extends Request {

	public UpaymentBindAgreementRequest(Context ctx, List<String> Agreements) {
		super(ctx, ctx.getString(R.string.api_v2_bind_agreement));

		for (String s : Agreements) {
			add("agreementList", s);
		}
		if (null == mPreference) {
			mPreference = new AppPreferences(ctx);
		}

		String baseUrl = mPreference.getString("base");
		Uri baseUri = Uri.parse(baseUrl);
		String host = baseUri.getHost();
		String schema = baseUri.getScheme();
		add("retUrl", schema+":"+host+"/");
	}

	public UpaymentBindAgreementRequest(Context ctx, String agreement) {
		super(ctx, ctx.getString(R.string.api_v2_bind_agreement));
		add("agreementList", agreement);

		if (null == mPreference) {
			mPreference = new AppPreferences(ctx);
		}
		String baseUrl = mPreference.getString("base");
		Uri baseUri = Uri.parse(baseUrl);
		String host = baseUri.getHost();
		String schema = baseUri.getScheme();
		add("retUrl", schema+":"+host+"/");
	}
}
