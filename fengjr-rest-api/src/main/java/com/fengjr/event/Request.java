package com.fengjr.event;

import org.springframework.util.LinkedMultiValueMap;

import android.content.Context;
import android.text.TextUtils;

import com.fengjr.api.R;
import com.fengjr.model.UserLoginExt;

public class Request {
	public final static String TAG = "RequestEvent";

	public final static String API_VERSION_V2 = "v2";
	public final static String API_VERSION_V3 = "v3";

	public String api;
	public LinkedMultiValueMap<String, String> request;

	public UserLoginExt ext;

	public int key;

	public boolean noCache = false;

	public boolean noDiskCache = true;

	protected String subPathApi;

	private Context context;

	public static AppPreferences mPreference;

	public Request(String api) {
		this.api = api;
		request = new LinkedMultiValueMap<String, String>();
	}

	/**
	 * @param ctx
	 * @param subPathApi
	 *            api subpath 不包含域名
	 */
	public Request(Context ctx, String subPathApi) {
		this.subPathApi = subPathApi;
		context = ctx.getApplicationContext();
		request = new LinkedMultiValueMap<String, String>();
		this.api = buildApi();

	}

	protected String buildApi() {

		String baseUrl = getBaseDomain();
		this.api = baseUrl + "api/" + requestApiVersion() + subPathApi;
		return api;
	}

	final protected String getBaseDomain() {
		if (null == mPreference) {
			mPreference = new AppPreferences(context);
		}
		String baseUrl = mPreference.getString("base_domain");
		if (TextUtils.isEmpty(baseUrl)) {
			baseUrl = context.getString(R.string.base);
			mPreference.save("base", baseUrl);
		}
		return baseUrl;
	}

	protected String requestApiVersion() {
		return API_VERSION_V2;

	}

	public Request add(String key, String value) {
		request.add(key, value);
		return this;
	}

	public Request add(String key, int value) {
		request.add(key, String.valueOf(value));
		return this;
	}

	public Request add(String key, long value) {
		request.add(key, String.valueOf(value));
		return this;
	}

	public Request add(String key, boolean value) {
		request.add(key, String.valueOf(value));
		return this;
	}

	public Request add(String key, double value) {
		request.add(key, String.valueOf(value));
		return this;
	}

	public Request ext(UserLoginExt ext) {
		this.ext = ext;
		return this;
	}

	public enum URLType {
		URL_CC, URL_TEST, URL_BETA, URL_PRODUCTION
	}

	public static void switchBaseUrl(URLType type, Context ctx) {
		AppPreferences pre = new AppPreferences(ctx);

		switch (type) {
		case URL_CC:
			pre.save("base_domain", ctx.getString(R.string.base_cc));
			break;
		case URL_TEST:
			pre.save("base_domain", ctx.getString(R.string.base_test));
			break;
		case URL_BETA:
			pre.save("base_domain", ctx.getString(R.string.base_beta));
			break;
		case URL_PRODUCTION:
			pre.save("base_domain", ctx.getString(R.string.base_prod));
			break;
		}
	}
}
