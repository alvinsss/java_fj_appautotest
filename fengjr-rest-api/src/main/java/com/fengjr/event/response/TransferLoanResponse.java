package com.fengjr.event.response;

import com.fengjr.event.Response;
import com.fengjr.event.request.TransferLoanRequest;
import com.fengjr.model.ApiResult;

public class TransferLoanResponse extends Response {
	public TransferLoanRequest mRequest;

	public TransferLoanResponse(ApiResult apiResult, TransferLoanRequest request) {
		super(apiResult);
		mRequest = request;
	}

}
