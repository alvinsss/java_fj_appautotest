package com.fengjr.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author suetming ( suetming.ma@gmail.com )
 * 
 *         2014-10-13 下午2:09:56
 * 
 */

public class Repayment implements Serializable {

	private static final long serialVersionUID = 6149652723679320799L;

	public double amountPrincipal;

	public double amountInterest;

	public double amountOutstanding;

	public long dueDate;
	
	public double amount;

	public Repayment() {
	}

	public Repayment(BigDecimal amountPrincipal, BigDecimal amountInterest,
			BigDecimal amountOutstanding, Date dueDate) {
		this.amountPrincipal = amountPrincipal.doubleValue();
		this.amountInterest = amountInterest.doubleValue();
		this.amountOutstanding = amountOutstanding.doubleValue();
		this.dueDate = dueDate.getTime();
	}

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
