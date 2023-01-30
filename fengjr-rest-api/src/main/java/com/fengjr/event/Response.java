package com.fengjr.event;

import com.fengjr.model.ApiResult;

public class Response {

	public ApiResult result;
	public String errorMsg;
	
	public static final int SUCCESS 			= 100;
	public static final int ERROR_UNKNOWN 		= -1;
	public static final int ERROR_BAD_REQUEST 	= -100;
	public static final int ERROR_UNAUTHORIZED	= -101;
	public static final int ERROR_FORBIDDEN		= -102;
	public static final int ERROR_NOCONTENT		= -103;
	public static final int ERROR_NOT_FOUND		= -104;
	public static final int ERROR_CERTIFICATE	= -105;

	public Response() {
		
	}
	
	public Response(ApiResult result) {
		this.result = result;
	}
	
	public Response(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
}
