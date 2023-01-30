package com.fengjr.event.response;

import com.fengjr.event.Response;
import com.fengjr.event.request.LoansSummaryRequest;
import com.fengjr.model.ApiResult;

public class LoansSummaryResponse extends Response {
	
	public LoansSummaryRequest request;

	public LoansSummaryResponse(ApiResult apiResult, LoansSummaryRequest request) {
		super(apiResult);
		
		this.request = request;
	}
}

