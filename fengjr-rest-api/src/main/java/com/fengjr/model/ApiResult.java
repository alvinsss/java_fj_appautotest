package com.fengjr.model;

import java.util.ArrayList;
import java.util.List;

import android.text.TextUtils;
import android.util.Log;

import com.fengjr.event.Response;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class ApiResult {

	public Object data;
	
	public boolean success;
	
	public List<ApiError> error;
	
	public boolean needToLogin = false;
	
	public int error_code  = Response.SUCCESS;
	
	public ApiResult() {
		error = new ArrayList<ApiError>();
		success = false;
	}
	
	public boolean hasError() {
		return !error.isEmpty();
	}
	
	public ApiResult add(ApiError error) {
		this.error.add(error);
		return this;
	}
	
	public ApiResult add(String json) {
		if(TextUtils.isEmpty(json)) return this;
		 
		try {
			String description = new JsonParser().parse(json).getAsJsonObject().get("error_description").getAsString();
			this.error.add(new ApiError(description));
		} catch(JsonSyntaxException e) {
			Log.e("APIResult", json);
		}
		return this;
	}
	
	public static ApiResult build() {
		String default_ = "网络连接错误，请检查网络连接";
		ApiError error = new ApiError();
		error.message = default_;
		return new ApiResult().add(error);
	}

	public void copy(ApiResult result) {
		this.data = result.data;
		this.success = result.success;
		this.error = result.error;
	}

	public void needToLogin(int failedAttempts) {
		success = false;
		needToLogin = true;
		ApiError error = new ApiError();
		
		if (failedAttempts == -2) {
			error.message = "用户被禁用，请拨打客服电话：400-076-1166";
		}
		else if(failedAttempts < 0) {
			error.message = "授权失效，请重新登录";
		} else {
			error.message = "用户名或者密码错误";
		}
		add(error);
	}
}
