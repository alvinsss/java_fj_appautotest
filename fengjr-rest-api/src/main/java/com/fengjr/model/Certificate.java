package com.fengjr.model;

import java.io.Serializable;

public class Certificate implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8801908557349683071L;

	public String id;
	
	public String userId;
//	认证类型
	public String type;
//	认证状态
	public String status;
//	认证对应的评估
	public Assessment assessment;
//	审核人
	public String auditor;
//	审核信息
	public String auditInfo;
	
	public long timeCreated;
	
	public long timeLastModified;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Assessment getAssessment() {
		return assessment;
	}

	public void setAssessment(Assessment assessment) {
		this.assessment = assessment;
	}

	public String getAuditor() {
		return auditor;
	}

	public void setAuditor(String auditor) {
		this.auditor = auditor;
	}

	public String getAuditInfo() {
		return auditInfo;
	}

	public void setAuditInfo(String auditInfo) {
		this.auditInfo = auditInfo;
	}

	public long getTimeCreated() {
		return timeCreated;
	}

	public void setTimeCreated(long timeCreated) {
		this.timeCreated = timeCreated;
	}

	public long getTimeLastModified() {
		return timeLastModified;
	}

	public void setTimeLastModified(long timeLastModified) {
		this.timeLastModified = timeLastModified;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
