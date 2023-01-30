package com.fengjr.model.enums;

/**
 * 
 * @author suetming (suetming.ma@fengjr.com)
 *
 * 创建时间：2014-3-17 下午3:53:22
 *
 */
/**
 * 资金记录操作类型
 * 
 * @author rooseek
 */
public enum FundRecordOperation implements BaseEnum {

	FREEZE("冻结"), RELEASE("解冻"), IN("资金转入"), OUT("资金转出");

	private final String key;

	private FundRecordOperation(String key) {
		this.key = key;
	}

	@Override
	public String getKey() {
		return key;
	}
}
