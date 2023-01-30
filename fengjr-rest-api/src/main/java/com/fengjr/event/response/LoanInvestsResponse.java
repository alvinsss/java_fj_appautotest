package com.fengjr.event.response;

import com.fengjr.event.Response;
import com.fengjr.model.ApiResult;

public class LoanInvestsResponse extends Response {
	public String mLoanid;
	
	public LoanInvestsResponse(ApiResult apiResult, String loanid) {
		super(apiResult);
		mLoanid = loanid;
	}
}

