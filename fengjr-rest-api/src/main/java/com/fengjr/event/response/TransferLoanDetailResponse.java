package com.fengjr.event.response;

import com.fengjr.event.Response;
import com.fengjr.event.request.TransferLoanDetailRequest;
import com.fengjr.model.ApiResult;

public class TransferLoanDetailResponse extends Response {
	public TransferLoanDetailRequest mRequest;

	public TransferLoanDetailResponse(ApiResult apiResult,
			TransferLoanDetailRequest request) {
		super(apiResult);
		mRequest = request;
	}

}
