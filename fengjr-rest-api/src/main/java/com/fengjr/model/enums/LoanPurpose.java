package com.fengjr.model.enums;

/**
 * 
 * @author suetming (suetming.ma@fengjr.com)
 * 
 *         创建时间：2014-3-17 上午10:27:55
 * 
 */
public enum LoanPurpose implements BaseEnum {

	SHORTTERM("短期周转"), PERSONAL("个人消费"), INVESTMENT("投资创业"), CAR("购车借款"), HOUSE(
			"购房借款"), OTHER("其它借款"), FENG_CX("凤呈祥"), FENG_RT("凤锐通");

	private final String key;

	private LoanPurpose(String key) {
		this.key = key;
	}

	@Override
	public String getKey() {
		return key;
	}
}
