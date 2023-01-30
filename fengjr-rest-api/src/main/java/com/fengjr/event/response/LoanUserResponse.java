package com.fengjr.event.response;

import com.fengjr.event.Response;
import com.fengjr.model.ApiResult;

public class LoanUserResponse extends Response {
	public String mLoanid;
	
	public LoanUserResponse(ApiResult apiResult, String loanid) {
		super(apiResult);
		mLoanid = loanid;
	}
}

