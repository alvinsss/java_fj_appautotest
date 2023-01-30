package com.fengjr.model.enums;

/**
 * @author suetming ( suetming.ma@gmail.com )
 * 
 *         2014-10-10 上午10:57:41
 * 
 */
public enum ProjectStatus implements BaseEnum {

	INITIATED("初始"), SCHEDULED("已安排"), OPENED("众筹中"), FINISHED("项目成功"), FAILED(
			"项目失败"), LOAN("放款中"), SETTLED("全部放款"), DELIVERED(
			"奖励回报已发送"), CANCELED("取消"),ARCHIVED("存档");

	private final String key;

	private ProjectStatus(String key) {
		this.key = key;
	}

	@Override
	public String getKey() {
		return key;
	}

}
