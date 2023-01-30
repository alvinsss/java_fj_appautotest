package com.fengjr.model;

import java.io.Serializable;

public class FundingReward implements Serializable {

	private static final long serialVersionUID = 4418090736755828697L;

	public static final int APPLY_EXPRIENCE_NONE = 1;
	public static final int APPLY_EXPRIENCE_DISABLE = 2;
	public static final int APPLY_EXPRIENCE_ENABLE_TO_SPECIAL_TOPIC = 3;
	public static final int APPLY_EXPRIENCE_ENABLE_TO_TIPS_CONFIRM = 4;

	public static final int SUPPORT_STATE_DISABLE = 5;
	public static final int SUPPORT_SATATE_ENABLE_TO_SPECIAL_TOPIC = 6;
	public static final int SUPPORT_SATATE_ENABLE_TO_TO_TIPS_CONFIRM = 7;
	public static final int SUPPORT_SATATE_ENABLE_NORMAL = 8;
	public static final int SUPPORT_STATE_ENABLE_SHOW_CANNOT_SUPPORT_TIP = 9;

 

	public String id;

	public String projectId;

	/**
	 * donate/invest/pledge amount
	 */
	public double amount;

	/**
	 * reward number limit
	 */
	public int limitNumber;

	/**
	 * number raised
	 */
	public int raiseNumber;

	/**
	 * return description
	 */
	public String description;

	/**
	 * delivery cost, area, time ...</p> can be json
	 */
	public String deliveryDetail;

	/**
	 * hard limit
	 */
	public boolean hardLimit;

	/**
	 * amount actual raised
	 */
	public double raiseAmount;

	public int leftNumber;

	// 配送时间
	public String deliveryTime;

	// 点击支持时 是否弹出提示框，默认false
	private boolean supportPopNotice = false;

	// 众筹回报支持 对用户 类型的条件
	// NORMAL 为正常类型
	// SATISFYRISTRICTION 满足相关添加的用户
	// UNSATISFYRISTRICTION 不满足此回报的用户，这时点击支持可以可以进入专题页
	private String restrictionResult = "NORMAL";

	// 申请体验 按钮进入的方向
	// POPNOTICE 弹出提示框
	// SPECIALLINK 进入专题页
	private String applyAction = "POPNOTICE";

	// 用户支持了互斥的众筹 USER_SUPPORTED_EXCLUSIVESCROWDFUNDING 弹出消息提示用户
	// 其他类型下显示专题页
	private String restrictionMsg;

	// 申请体验按钮 是否可点击 配合 applyAction 使用
	private boolean applyClickable = false;
	// 是否显示 申请体验 按钮
	private boolean needExperienceApply = false;

	// 申请体验 按钮点击提示的内容
	private String experienceApplyContent = "";
	// 专题页地址 为/specialTopic/mobileyhgj
	private String mobileSpecialTopic = "";

	

	public FundingReward(String id, String projectId, double amount,
			int limitNumber, String description, String deliveryDetail) {
		this.id = id;
		this.projectId = projectId;
		this.amount = amount;
		this.limitNumber = limitNumber;
		this.description = description;
		this.deliveryDetail = deliveryDetail;
	}

	/**
	 * left number
	 * 
	 * @return
	 */
	public int getLeftNumber() {
		int result = limitNumber - raiseNumber;
		return result < 0 ? 0 : result;
	}

	/**
	 * 获取对应众筹 支持体验 功能的状态
	 * 
	 * @return
	 */
	public int getRewardApplyExperienceState() {
		// TODO 等待服务器 具体格式

		int state = APPLY_EXPRIENCE_NONE;
		if (needExperienceApply) {

			if (applyClickable) {
				if ("POPNOTICE".equals(applyAction)) {
					state = APPLY_EXPRIENCE_ENABLE_TO_TIPS_CONFIRM;
				} else if ("UNPOPNOTICE".equals(applyAction)) {

					state = APPLY_EXPRIENCE_DISABLE;
				} else if ("SPECIALLINK".equals(applyAction)) {
					state = APPLY_EXPRIENCE_ENABLE_TO_SPECIAL_TOPIC;
				}
			} else {
				state = APPLY_EXPRIENCE_DISABLE;
			}

		}

		return state;
	}

	/**
	 * 服务器根据 相关条件 返回用户是否可以申请体验
	 * 
	 * @return
	 */
	public boolean isUserCanApplyExperience() {
		return applyClickable;
	}

	public int getSupportRewardState() {
		int state = SUPPORT_STATE_DISABLE;

		if ("NORMAL".equals(restrictionResult)) {
			state = SUPPORT_SATATE_ENABLE_NORMAL;
		} else if ("SATISFYRISTRICTION".equals(restrictionResult)) {
			state = SUPPORT_SATATE_ENABLE_TO_TO_TIPS_CONFIRM;
		} else if ("UNSATISFYRISTRICTION".equals(restrictionResult)) {

			if ("USER_SUPPORTED_EXCLUSIVESCROWDFUNDING".equals(restrictionMsg)) {
				state = SUPPORT_STATE_ENABLE_SHOW_CANNOT_SUPPORT_TIP;
			} else {
				state = SUPPORT_SATATE_ENABLE_TO_SPECIAL_TOPIC;
			}

		}

		return state;

	}

	/**
	 * 获取 众筹支持时 提示用户内容
	 * 
	 * @return
	 */
	public String getRewardSupportTipContent() {

		return "/mobile/pop/" + id;
	}

	/**
	 * 判断是否 显示 支持众筹时 的提示。
	 * 
	 * @return
	 */
	public boolean isShowRewardSupportTip() {
		return supportPopNotice;
	}

	public boolean isShowSpecialTopicPageForRewardConfirm() {
		int state = getSupportRewardState();
		if (state == SUPPORT_SATATE_ENABLE_TO_SPECIAL_TOPIC) {
			return true;
		}

		return false;
	}

	public boolean isShowCannotSupportTips() {
		int state = getSupportRewardState();
		if (state == SUPPORT_STATE_ENABLE_SHOW_CANNOT_SUPPORT_TIP) {
			return true;
		}

		return false;
	}

	public String getSpecialTopicPageUrl() {
		// sub path
		return mobileSpecialTopic;
	}

	 

	public String getApplyExperienceTips() {
		return experienceApplyContent;
	}

	 
}
