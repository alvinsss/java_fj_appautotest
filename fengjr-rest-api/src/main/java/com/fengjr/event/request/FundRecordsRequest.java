package com.fengjr.event.request;

import android.content.Context;

import com.fengjr.api.R;
import com.fengjr.event.Request;
import com.fengjr.model.enums.FundRecordType;

public class FundRecordsRequest extends Request {

	public FundRecordsRequest(Context ctx, int page, int pageSize,
			FundRecordType type) {
		
		super(ctx, ctx.getString(R.string.api_my_fund_records));

		add("page", page).add("pageSize", pageSize)
				.add("type", type.name())
				.add("allStatus", false)
				.add("allOperation", false)
				.add("startDate", 1369843200000L)
				.add("endDate", System.currentTimeMillis());
	}

	public FundRecordsRequest enableDiskCache() {
		this.noDiskCache = false;
		return this;
	}

}
