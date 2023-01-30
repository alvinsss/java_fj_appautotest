package com.fengjr.event.response;

import com.fengjr.event.Response;
import com.fengjr.event.request.LoansFilterRequest;
import com.fengjr.model.ApiResult;

public class LoansFilterResponse extends Response {
	public LoansFilterRequest mRequest;
	
	public LoansFilterResponse(ApiResult apiResult, LoansFilterRequest request) {
		super(apiResult);
		mRequest = request;
	}
}

