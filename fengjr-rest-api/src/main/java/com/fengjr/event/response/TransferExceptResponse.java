package com.fengjr.event.response;

import com.fengjr.event.Response;
import com.fengjr.event.request.TransferExceptRequest;
import com.fengjr.model.ApiResult;

public class TransferExceptResponse extends Response {
	public TransferExceptRequest mRequest;

	public TransferExceptResponse(ApiResult apiResult,
			TransferExceptRequest request) {
		super(apiResult);
		mRequest = request;
	}
}
