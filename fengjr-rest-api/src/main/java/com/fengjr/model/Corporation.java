package com.fengjr.model;

import java.io.Serializable;

/** 
 * @author suetming ( suetming.ma@gmail.com )
 * 
 * 2014-10-20 下午4:42:52 
 * 
 */

public class Corporation implements Serializable {

	/**
     * corporation对应的user不一定是企业法人,所以可以额外指定某个人用户为企业法人
     */
	private static final long serialVersionUID = -4875463750292095156L;

	public User user;
	
	public String legalPersonId;
	//企业全称
	public String name;
	//企业简称
	public String shortName;
	//组织结构代码
	public String orgCode;
	//营业执照编号
	public String busiCode;
	//税务登记号
	public String taxCode;
	
	public String type;
	//营业执照上的公司类型
	public String category;
	//注册时间
	public long registerDate;
	
	public String loginName;
	
}
