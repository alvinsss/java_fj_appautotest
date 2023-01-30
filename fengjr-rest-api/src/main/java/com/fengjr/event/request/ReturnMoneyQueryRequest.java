package com.fengjr.event.request;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.content.Context;

import com.fengjr.api.R;
import com.fengjr.event.Request;

public class ReturnMoneyQueryRequest extends Request {

	public ReturnMoneyQueryRequest(Context ctx, String userId) {
		super(ctx, ctx.getString(R.string.api_v2_return_money_query));
		this.add("t", System.currentTimeMillis());
		this.add("startDate", getFirstDayOfMonth());
		this.add("endDate", getLastDayOfMonth());
	}

	public static long getFirstDayOfMonth() {

		Calendar cal = Calendar.getInstance();
//		cal.set(Calendar.DATE, 1);// 设为当前月的1号
		return cal.getTimeInMillis();

	}

	public static long getLastDayOfMonth() {

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, 30);
//		cal.set(Calendar.DATE, 1);// 设为当前月的1号
//		cal.add(Calendar.MONTH, 1);// 加一个月，变为下月的1号
//		cal.add(Calendar.DATE, -1);// 减去一天，变为当月最后一天

		return cal.getTimeInMillis();
	}
}
