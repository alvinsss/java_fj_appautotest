package com.fengjr.model;

import java.io.Serializable;

public class LoanDetailUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6314323153386936671L;
	//借款人贷款信息
	public UserCredit userCredit;
	//借款人基金信息
	public UserFund userFund;
	//借款人详细信息
	public UserInfo userInfo;
//	借款人信息
	public User user;
	//审核信息
//	public Certificates certificates;
	
	public CertificatesNew certificates;
//	贷款信息
	public Statistics statistics;
	public UserCredit getUserCredit() {
		return userCredit;
	}
	public void setUserCredit(UserCredit userCredit) {
		this.userCredit = userCredit;
	}
	public UserFund getUserFund() {
		return userFund;
	}
	public void setUserFund(UserFund userFund) {
		this.userFund = userFund;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public CertificatesNew getCertificates() {
		return certificates;
	}
	public void setCertificates(CertificatesNew certificates) {
		this.certificates = certificates;
	}
	public Statistics getStatistics() {
		return statistics;
	}
	public void setStatistics(Statistics statistics) {
		this.statistics = statistics;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
