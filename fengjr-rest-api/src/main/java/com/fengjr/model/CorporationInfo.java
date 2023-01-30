package com.fengjr.model;

import java.io.Serializable;

/**
 * @author suetming ( suetming.ma@gmail.com )
 * 
 *         2014-10-20 下午4:59:15
 * 
 */

public class CorporationInfo implements Serializable {

	    /**
	 * 
	 */
	private static final long serialVersionUID = -8163584596626164940L;

	public String userId;

	    public String url;

	    /**
	     * 联系地址
	     */
	    public String address;

	    /**
	     * 联系人姓名
	     */
	    public String contactPersion;

	    /**
	     * 联系电话,手机或者座机
	     */
	    public String contactPhone;

	    /**
	     * 联系邮箱
	     */
	    public String contactEmail;

	    /**
	     * 注册资本
	     */
	    public double registeredCapital;

	    /**
	     * 注册地址
	     */
	    public String registeredLocation;

	    /**
	     * 成立时间
	     */
//	    public long timeEstablished;

	    /**
	     * 经营范围
	     */
	    public String businessScope;

	    /**
	     * 企业描述
	     */
	    public String description;
	    /**
	     * 企业成立时间等信息
	     */
	    
	    public CorporationTime timeEstablished;
}
