package com.fengjr.event.response;

import com.fengjr.event.Response;
import com.fengjr.model.ApiResult;


public class LoanDetailEvent extends Response {

	public LoanDetailEvent(ApiResult apiResult) {
		super(apiResult);
	}
}
