package com.fengjr.model;

import java.io.Serializable;


public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4848617417493351617L;
	
	public String id;
	public String clientCode;
	public String name;
	public String loginName;
	public String idNumber;
	public String mobile;
	public String email;
	public String source;
	public String employeeId;
	public String lastModifiedBy;
	public String lastLoginDate;
	public String registerDate;
	public boolean enabled;
	public boolean enterprise;
	
	// native
	public String gestureCode;
	public boolean gestureEable=false;
	public String token;
	public long now;
	
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getClientCode() {
		return clientCode;
	}


	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLoginName() {
		return loginName;
	}


	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}


	public String getIdNumber() {
		return idNumber;
	}


	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getSource() {
		return source;
	}


	public void setSource(String source) {
		this.source = source;
	}


	public String getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}


	public String getLastModifiedBy() {
		return lastModifiedBy;
	}


	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}


	public String getLastLoginDate() {
		return lastLoginDate;
	}


	public void setLastLoginDate(String lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}


	public String getRegisterDate() {
		return registerDate;
	}


	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}


	public boolean isEnabled() {
		return enabled;
	}


	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}


	public boolean isEnterprise() {
		return enterprise;
	}


	public void setEnterprise(boolean enterprise) {
		this.enterprise = enterprise;
	}


	public String getGestureCode() {
		return gestureCode;
	}


	public void setGestureCode(String gestureCode) {
		this.gestureCode = gestureCode;
	}


	public boolean isGestureEable() {
		return gestureEable;
	}


	public void setGestureEable(boolean gestureEable) {
		this.gestureEable = gestureEable;
	}


	public String getToken() {
		return token;
	}


	public void setToken(String token) {
		this.token = token;
	}


	public long getNow() {
		return now;
	}


	public void setNow(long now) {
		this.now = now;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public void reset() {
		this.id = "";
		this.clientCode = "";
		this.name = "";
		this.loginName = "";
		this.idNumber = "";
		this.mobile = "";
		this.email = "";
		this.source = "";
		this.employeeId = "";
		this.lastModifiedBy = null;
		this.lastLoginDate = null;
		this.enabled = true;
		this.gestureCode = "";
		this.gestureEable = false;
		this.token = "";
		this.now = 0;
		this.enterprise=false;
	}

}
