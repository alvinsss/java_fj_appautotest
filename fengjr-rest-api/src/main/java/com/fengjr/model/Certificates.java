package com.fengjr.model;

import java.io.Serializable;

public class Certificates implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -373714286110764271L;
//居住地认证
	public Certificate LOCATION;
//	购车认证
	public Certificate VEHICLE;
//	学历认证
	public Certificate EDUCATION;
//	身份认证
	public Certificate ID;
//	家庭情况认证
	public Certificate FAMILY;
	
	public Certificate LOANPURPOSE;
//	信用认证
	public Certificate CREDITREPORT;
//	众筹相关认证
	public Certificate CROWDFUNDING;
// 保理认证
	public Certificate GUARANTEE;
//	其他认证
	public Certificate OTHERS;
	
	public Certificate FACTORING;
//	企业认证
	public Certificate CAREER;
//	收入认证
	public Certificate INCOME;
//	房产认证
	public Certificate REALESTATE;
	public Certificate ORIGINALAGREEMENT;
	public Certificate BANKTRADE;
	public Certificate OWNERSHIPREGIST;
	public Certificate FINANCIERIDENTITY;
	public Certificate GRANTERIDENTITY;
	
	public Certificate getLOCATION() {
		return LOCATION;
	}
	public void setLOCATION(Certificate lOCATION) {
		LOCATION = lOCATION;
	}
	public Certificate getVEHICLE() {
		return VEHICLE;
	}
	public void setVEHICLE(Certificate vEHICLE) {
		VEHICLE = vEHICLE;
	}
	public Certificate getEDUCATION() {
		return EDUCATION;
	}
	public void setEDUCATION(Certificate eDUCATION) {
		EDUCATION = eDUCATION;
	}
	public Certificate getID() {
		return ID;
	}
	public void setID(Certificate iD) {
		ID = iD;
	}
	public Certificate getFAMILY() {
		return FAMILY;
	}
	public void setFAMILY(Certificate fAMILY) {
		FAMILY = fAMILY;
	}
	public Certificate getLOANPURPOSE() {
		return LOANPURPOSE;
	}
	public void setLOANPURPOSE(Certificate lOANPURPOSE) {
		LOANPURPOSE = lOANPURPOSE;
	}
	public Certificate getCREDITREPORT() {
		return CREDITREPORT;
	}
	public void setCREDITREPORT(Certificate cREDITREPORT) {
		CREDITREPORT = cREDITREPORT;
	}
	public Certificate getCROWDFUNDING() {
		return CROWDFUNDING;
	}
	public void setCROWDFUNDING(Certificate cROWDFUNDING) {
		CROWDFUNDING = cROWDFUNDING;
	}
	public Certificate getGUARANTEE() {
		return GUARANTEE;
	}
	public void setGUARANTEE(Certificate gUARANTEE) {
		GUARANTEE = gUARANTEE;
	}
	public Certificate getOTHERS() {
		return OTHERS;
	}
	public void setOTHERS(Certificate oTHERS) {
		OTHERS = oTHERS;
	}
	public Certificate getFACTORING() {
		return FACTORING;
	}
	public void setFACTORING(Certificate fACTORING) {
		FACTORING = fACTORING;
	}
	public Certificate getCAREER() {
		return CAREER;
	}
	public void setCAREER(Certificate cAREER) {
		CAREER = cAREER;
	}
	public Certificate getINCOME() {
		return INCOME;
	}
	public void setINCOME(Certificate iNCOME) {
		INCOME = iNCOME;
	}
	public Certificate getREALESTATE() {
		return REALESTATE;
	}
	public void setREALESTATE(Certificate rEALESTATE) {
		REALESTATE = rEALESTATE;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
