package com.fengjr.model;

import java.io.Serializable;

public class UserFund implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6978791854089292253L;
	
	public String userId;
//	可用余额
	public double availableAmount;
//	冻结金额
	public double frozenAmount;
//	代收总额
	public double dueInAmount;
//	待还总额
	public double dueOutAmount;
//	充值总额
	public double depositAmount;
//	体现总额
	public double withdrawAmount;
//	商户给用户的转账收入或者用户给商户的转账支出 可能小于零
	public double transferAmount;
//	
	public double rechargeAmount;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public double getAvailableAmount() {
		return availableAmount;
	}
	public void setAvailableAmount(double availableAmount) {
		this.availableAmount = availableAmount;
	}
	public double getFrozenAmount() {
		return frozenAmount;
	}
	public void setFrozenAmount(double frozenAmount) {
		this.frozenAmount = frozenAmount;
	}
	public double getDueInAmount() {
		return dueInAmount;
	}
	public void setDueInAmount(double dueInAmount) {
		this.dueInAmount = dueInAmount;
	}
	public double getDueOutAmount() {
		return dueOutAmount;
	}
	public void setDueOutAmount(double dueOutAmount) {
		this.dueOutAmount = dueOutAmount;
	}
	public double getDepositAmount() {
		return depositAmount;
	}
	public void setDepositAmount(double depositAmount) {
		this.depositAmount = depositAmount;
	}
	public double getWithdrawAmount() {
		return withdrawAmount;
	}
	public void setWithdrawAmount(double withdrawAmount) {
		this.withdrawAmount = withdrawAmount;
	}
	public double getTransferAmount() {
		return transferAmount;
	}
	public void setTransferAmount(double transferAmount) {
		this.transferAmount = transferAmount;
	}
	public double getRechargeAmount() {
		return rechargeAmount;
	}
	public void setRechargeAmount(double rechargeAmount) {
		this.rechargeAmount = rechargeAmount;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
