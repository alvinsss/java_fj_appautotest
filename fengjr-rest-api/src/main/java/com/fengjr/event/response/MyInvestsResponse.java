package com.fengjr.event.response;

import com.fengjr.event.Response;
import com.fengjr.event.request.MyInvestsRequest;
import com.fengjr.model.ApiResult;

public class MyInvestsResponse extends Response {

	public MyInvestsRequest request;

	public MyInvestsResponse(ApiResult apiResult, MyInvestsRequest request) {
		super(apiResult);
		this.request = request;
	}
	
}
