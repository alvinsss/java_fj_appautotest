package com.fengjr.event.response;

import com.fengjr.event.Response;
import com.fengjr.model.ApiResult;

public class LoanDetailNewResponse extends Response {
	public String mLoanid;
	
	public LoanDetailNewResponse(ApiResult apiResult, String loanid) {
		super(apiResult);
		mLoanid = loanid;
	}
}