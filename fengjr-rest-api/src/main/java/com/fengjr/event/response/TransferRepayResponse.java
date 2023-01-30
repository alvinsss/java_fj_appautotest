package com.fengjr.event.response;

import com.fengjr.event.Response;
import com.fengjr.event.request.TransferRepayRequest;
import com.fengjr.model.ApiResult;

public class TransferRepayResponse extends Response {
	TransferRepayRequest mRequest;

	public TransferRepayResponse(ApiResult apiResult,
			TransferRepayRequest request) {
		super(apiResult);
		mRequest = request;
	}

}
