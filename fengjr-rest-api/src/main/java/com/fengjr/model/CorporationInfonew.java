package com.fengjr.model;

import java.io.Serializable;
import java.util.Date;

public class CorporationInfonew implements Serializable{

	private static final long serialVersionUID = -896848831998285040L;
	public String userId;
	//企业url
	public String url;
	//企业地址
	public String address;
	//联系人姓名
	public String contactPersion;
	//联系电话，手机或座机
	public String contactPhone;
	//联系邮箱
	public String contactEmail;
	//注册资本
	public double registeredCapital;
	//注册地址
	public String registeredLocation;
	//经营范围
	public String businessScope;
	//企业描述
	public String description;
	//股东背景
	public String background;
	//资本市场评级
	public String creditRank;
	//成立时间
//	public Date timeEstablished;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContactPersion() {
		return contactPersion;
	}
	public void setContactPersion(String contactPersion) {
		this.contactPersion = contactPersion;
	}
	public String getContactPhone() {
		return contactPhone;
	}
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
	public String getContactEmail() {
		return contactEmail;
	}
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
	public double getRegisteredCapital() {
		return registeredCapital;
	}
	public void setRegisteredCapital(double registeredCapital) {
		this.registeredCapital = registeredCapital;
	}
	public String getRegisteredLocation() {
		return registeredLocation;
	}
	public void setRegisteredLocation(String registeredLocation) {
		this.registeredLocation = registeredLocation;
	}
	public String getBusinessScope() {
		return businessScope;
	}
	public void setBusinessScope(String businessScope) {
		this.businessScope = businessScope;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBackground() {
		return background;
	}
	public void setBackground(String background) {
		this.background = background;
	}
	public String getCreditRank() {
		return creditRank;
	}
	public void setCreditRank(String creditRank) {
		this.creditRank = creditRank;
	}
//	public Date getTimeEstablished() {
//		return timeEstablished;
//	}
//	public void setTimeEstablished(Date timeEstablished) {
//		this.timeEstablished = timeEstablished;
//	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
