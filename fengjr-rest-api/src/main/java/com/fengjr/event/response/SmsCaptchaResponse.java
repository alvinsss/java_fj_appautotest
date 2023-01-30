package com.fengjr.event.response;

import com.fengjr.event.Response;
import com.fengjr.model.ApiResult;

/** 
 * @author suetming ( suetming.ma@gmail.com )
 * 
 * 2014-10-4 下午5:28:15 
 * 
 */

public class SmsCaptchaResponse extends Response {

	public SmsCaptchaResponse(ApiResult result) {
		super(result);
	}
	
	public SmsCaptchaResponse(String error) {
		super(error);
	}
}
