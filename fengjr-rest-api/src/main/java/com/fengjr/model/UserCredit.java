package com.fengjr.model;

import java.io.Serializable;

public class UserCredit implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6445731851328682678L;

	public String userId;
//	信用等级（返回如：AA）
	public String creditRank;
//	信用评分
	public Assessment assessment;
//	信用额度
	public double creditLimit;
//	可用额度
	public double creditAvailable;
//	
	public String lastModifiedBy;
	
	public long timeCreated;
	
	public long timeLastUpdated;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCreditRank() {
		return creditRank;
	}

	public void setCreditRank(String creditRank) {
		this.creditRank = creditRank;
	}

	public Assessment getAssessment() {
		return assessment;
	}

	public void setAssessment(Assessment assessment) {
		this.assessment = assessment;
	}

	public double getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(double creditLimit) {
		this.creditLimit = creditLimit;
	}

	public double getCreditAvailable() {
		return creditAvailable;
	}

	public void setCreditAvailable(double creditAvailable) {
		this.creditAvailable = creditAvailable;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public long getTimeCreated() {
		return timeCreated;
	}

	public void setTimeCreated(long timeCreated) {
		this.timeCreated = timeCreated;
	}

	public long getTimeLastUpdated() {
		return timeLastUpdated;
	}

	public void setTimeLastUpdated(long timeLastUpdated) {
		this.timeLastUpdated = timeLastUpdated;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
