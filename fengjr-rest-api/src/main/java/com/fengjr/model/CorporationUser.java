package com.fengjr.model;

import java.io.Serializable;

/**
 * @author suetming ( suetming.ma@gmail.com )
 * 
 *         2014-10-20 下午4:59:15
 * 
 */

public class CorporationUser implements Serializable {

	/**
	 * 
	 */
	public static final long serialVersionUID = -7815098181359773155L;

	public String userId;

	public User user;

	public String name;

	public String shortName;

	public String orgCode;

	public String busiCode;

	public String taxCode;

	public String type;

	/**
	 * 可以額外指定一个用户为企业法人
	 */
	public String legalPersonId;

	// 营业执照上的公司类型
	public String category;

}
