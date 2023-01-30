package com.fengjr.model;

import java.io.Serializable;

/**
 * @author suetming ( suetming.ma@gmail.com )
 * 
 *         2014-10-11 下午2:55:22
 * 
 */

public class FundingInvest implements Serializable {

	public static final int REWARD_CONFIRM_NONE = 1;
	public static final int REWARD_CONFIRM_WAITING = 2;
	public static final int REWARD_CONFIRM_CONFIRMED = 3;
	public static final int REWARD_CONFIRM_OVERDUE = 4;
	public static final long serialVersionUID = 6057438575397939134L;

	public String id;

	public String projectId;

	public String status;

	public double amount;

	public String rewardId;

	public String userId;

	public String message;

	public long submitTime;

	public String deliveryDetail;

	public double deliveryFee;
	public String orderId;
	public double totalAmount;
	// 回报确认按钮的状态：
		// NONEED 没有回报确认
		// WAITING 待确认
		// CONFIRMED 已确认
		// CONFIRM_FAILD 确认失败
		// FORBIDDEN 禁止操作
		// OVERDUE 逾期不可确认
		private String rewardConfirmStatus = "NONEED";
		 			   
		private boolean hasContract;

		public int getRecowardConfirmState() {
			int state = REWARD_CONFIRM_NONE;
			if ("WAITING".equals(rewardConfirmStatus)) {
				state = REWARD_CONFIRM_WAITING;
			} else if ("CONFIRMED".equals(rewardConfirmStatus)) {
				state = REWARD_CONFIRM_CONFIRMED;
			} else if ("OVERDUE".equals(rewardConfirmStatus)) {
				state = REWARD_CONFIRM_OVERDUE;
			}

			return state;

		}

		public boolean hasContractCanRead() {
			return hasContract;
		}
}
