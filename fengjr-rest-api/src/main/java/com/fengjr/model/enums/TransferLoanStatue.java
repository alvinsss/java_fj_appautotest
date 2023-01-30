package com.fengjr.model.enums;

public enum TransferLoanStatue implements BaseEnum {
	FINISHED("已结束"),
	/**
	 * 达到发布时间，可以投标
	 */
	OPEN("开放投标");

	private final String key;

	private TransferLoanStatue(final String key) {
		this.key = key;
	}

	@Override
	public String getKey() {
		return key;
	}

}
