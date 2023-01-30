package com.fengjr.model;

import java.io.Serializable;

public class Agreement implements Serializable{

	private static final long serialVersionUID = 6405444632042186423L;
	
	public String accountName;
	public String userId;
	/**
     * 无密快捷协议
     */
	public boolean instant;
    /**
     * 无密投资协议
     */
	public boolean invest;
    /**
     * 无密还款协议
     */	
	public boolean repay;
    /**
     * 借记卡快捷协议
     */	
	public boolean debit;
    /**
     * 卡号暂存，UMP绑卡结果只包含经过遮挡的卡号
     */	
	public boolean cardNo;
}
