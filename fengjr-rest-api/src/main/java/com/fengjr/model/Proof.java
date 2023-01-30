package com.fengjr.model;

import java.io.Serializable;

public class Proof implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1762150136639196690L;
	
	public String id;
	public String userId;
	public String proofType;
	public String contentType;
	public String content;
	public String description;

	public String source;
	public long submitTime;
	public String employee;
	public boolean mosaic;
	public boolean cover;
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
	public String getProofType() {
		return proofType;
	}
	public void setProofType(String proofType) {
		this.proofType = proofType;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public long getSubmitTime() {
		return submitTime;
	}
	public void setSubmitTime(long submitTime) {
		this.submitTime = submitTime;
	}
	public String getEmployee() {
		return employee;
	}
	public void setEmployee(String employee) {
		this.employee = employee;
	}
	public boolean isMosaic() {
		return mosaic;
	}
	public void setMosaic(boolean mosaic) {
		this.mosaic = mosaic;
	}
	public boolean isCover() {
		return cover;
	}
	public void setCover(boolean cover) {
		this.cover = cover;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
