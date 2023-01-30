package com.fengjr.event.response;

import com.fengjr.event.Response;
import com.fengjr.model.ApiResult;

public class CorporationResponse extends Response {
	public String mLoanid;
	
	public CorporationResponse(ApiResult apiResult, String loanid) {
		super(apiResult);
		mLoanid = loanid;
	}
}

