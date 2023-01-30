package com.fengjr.model;


public class TransferRepayment {


	private static final long serialVersionUID = 6149652723679320799L;

	public double amountPrincipal;

	public double amountInterest;

	public double amountOutstanding;

	public String dueDate;
	
	public double amount;

	/**
	 * 当期的应还款总额.
	 * 
	 * amountPrincipal + amountInterest
	 * 
	 * @return
	 */
	public double getAmount() {
		return amountInterest + amountPrincipal;
	}

}
