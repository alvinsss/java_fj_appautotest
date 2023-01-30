package com.fengjr.model;

import java.io.Serializable;

public class CorporationUserNew implements Serializable {

	private static final long serialVersionUID = -1624082346167974471L;

	public String legalPersonId;
	// 企业全称
	public String name;
	// 企业简称
	public String shortName;
	// 组织结构代码
	public String orgCode;
	//营业执照编号
	public String busiCode;
	//税务登记号
	public String taxCode;
	//企业合同章特征码
	public String contractSealCode;
	
	public String type;
    //营业执照上的公司类型
	public String category;
	
	public boolean rtpo;
	//注册时间
	public long registerDate;
	
	public long lastLoginDate;
	
	public String loginName;
	
	public String userId;
	
	public String userMobile;
	public String userEmail;
	public String userIdNumber;
	public String id;
	public String userName;
	public User user;
	public String getLegalPersonId() {
		return legalPersonId;
	}
	public void setLegalPersonId(String legalPersonId) {
		this.legalPersonId = legalPersonId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public String getOrgCode() {
		return orgCode;
	}
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}
	public String getBusiCode() {
		return busiCode;
	}
	public void setBusiCode(String busiCode) {
		this.busiCode = busiCode;
	}
	public String getTaxCode() {
		return taxCode;
	}
	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}
	public String getContractSealCode() {
		return contractSealCode;
	}
	public void setContractSealCode(String contractSealCode) {
		this.contractSealCode = contractSealCode;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public boolean isRtpo() {
		return rtpo;
	}
	public void setRtpo(boolean rtpo) {
		this.rtpo = rtpo;
	}
	public long getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(long registerDate) {
		this.registerDate = registerDate;
	}
	public long getLastLoginDate() {
		return lastLoginDate;
	}
	public void setLastLoginDate(long lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserMobile() {
		return userMobile;
	}
	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserIdNumber() {
		return userIdNumber;
	}
	public void setUserIdNumber(String userIdNumber) {
		this.userIdNumber = userIdNumber;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
