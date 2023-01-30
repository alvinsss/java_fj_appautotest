package com.fengjr.event.response;

import com.fengjr.event.Response;
import com.fengjr.event.request.TransferBuyRequest;
import com.fengjr.model.ApiResult;

public class TransferBuyResponse extends Response {
	public TransferBuyRequest mRequest;

	public TransferBuyResponse(ApiResult apiResult, TransferBuyRequest request) {
		super(apiResult);
		mRequest = request;
	}
}
