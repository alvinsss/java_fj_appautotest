package com.fengjr.model;

import java.io.Serializable;
import java.util.List;

public class LoanDetailNew implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3338462016420418111L;
	public String id;
	// 借款信息
	public Loan loan;
	// 企业信息
	public CorporationNew corporation;
	public List<Proof> proofs;
//	// 借款人信息
	public LoanDetailUser user;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Loan getLoan() {
		return loan;
	}
	public void setLoan(Loan loan) {
		this.loan = loan;
	}
	public CorporationNew getCorporation() {
		return corporation;
	}
	public void setCorporation(CorporationNew corporation) {
		this.corporation = corporation;
	}
	public List<Proof> getProofs() {
		return proofs;
	}
	public void setProofs(List<Proof> proofs) {
		this.proofs = proofs;
	}
	public LoanDetailUser getUser() {
		return user;
	}
	public void setUser(LoanDetailUser user) {
		this.user = user;
	}
	

}
