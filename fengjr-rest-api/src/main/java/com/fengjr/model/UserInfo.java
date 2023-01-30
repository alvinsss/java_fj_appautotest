package com.fengjr.model;

import java.io.Serializable;

public class UserInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7370113152294461415L;
	public String userId;
	public User user;
	// 个人信息
	public PersonInfo personal;
	// 个人房车资产信息
	public UserFinance finance;
	// 个人工作信息
	public CareerInfo career;
	// 联系人信息
	public ContactInfo contact;
	public String priv;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public PersonInfo getPersonal() {
		return personal;
	}
	public void setPersonal(PersonInfo personal) {
		this.personal = personal;
	}
	public UserFinance getFinance() {
		return finance;
	}
	public void setFinance(UserFinance finance) {
		this.finance = finance;
	}
	public CareerInfo getCareer() {
		return career;
	}
	public void setCareer(CareerInfo career) {
		this.career = career;
	}
	public ContactInfo getContact() {
		return contact;
	}
	public void setContact(ContactInfo contact) {
		this.contact = contact;
	}
	public String getPriv() {
		return priv;
	}
	public void setPriv(String priv) {
		this.priv = priv;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
