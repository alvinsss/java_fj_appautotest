package com.fengjr.event.response;

import com.fengjr.event.Response;
import com.fengjr.model.ApiResult;

public class RewardConfirmResponse extends Response {
	public RewardConfirmResponse(ApiResult result) {
		super(result);
	}

	// 回报确认按钮的状态：
	// NONEED 没有回报确认
	// WAITING 待确认
	// CONFIRMED 已确认
	// CONFIRM_FAILD 确认失败
	// FORBIDDEN 禁止操作
	// OVERDUE 逾期不可确认
	public  String RewardConfirmStatus = "";
}
