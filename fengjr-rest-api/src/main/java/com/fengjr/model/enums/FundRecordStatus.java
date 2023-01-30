package com.fengjr.model.enums;
/**
 * 
 * @author suetming (suetming.ma@fengjr.com)
 *
 * 创建时间：2014-3-17 下午3:53:54
 *
 */
public enum FundRecordStatus implements BaseEnum {

	    INITIALIZED("初始"),
	    PROCESSING("处理中"),
	    AUDITING("审核中"),//目前主要用于取现申请复核
	    SUCCESSFUL("成功"),
	    FAILED("失败"),
	    REJECTED("拒绝"),
	    CANCELED("取消");

	    private final String key;

	    private FundRecordStatus(String key) {
	        this.key = key;
	    }

	    @Override
	    public String getKey() {
	        return key;
	    }
	}
