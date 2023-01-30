package com.fengjr.event.request;

import android.content.Context;

import com.fengjr.api.R;
import com.fengjr.event.Request;
import com.fengjr.model.FilterParam;
import com.fengjr.model.enums.TransferLoanStatue;

public class TransferLoanRequest extends Request {
	public TransferLoanRequest(Context ctx, String lastLoanId, int pageSize,
			TransferLoanStatue status,int pageNum) {
		super(ctx, ctx.getString(R.string.api_loan_tranfer_filter));
		add("lastCreditAssignId", lastLoanId)
				.add("pageSize", String.valueOf(pageSize))
				.add("status", status.name()).add("minLeftMonths", 0)
				.add("maxLeftMonths", 50).add("minRate", 0)
				.add("maxRate", 5000).add("repayMethod", "all").add("pageNum", pageNum);
	}
	
	public TransferLoanRequest(Context ctx, FilterParam param){
		super(ctx, ctx.getString(R.string.api_loan_tranfer_filter));
		add("lastCreditAssignId", param.lastLoanId)
		.add("pageSize", String.valueOf( param.pageSize))
		.add("status", param.status).add("minLeftMonths", 0)
		.add("maxLeftMonths", 50).add("minRate", 0)
		.add("maxRate", 5000).add("repayMethod", "all").add("pageNum", param.pageNum);
	}

}
