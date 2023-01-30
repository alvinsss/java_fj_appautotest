package com.fengjr.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * 
 * @author gaoge
 *该类和Repayment类的区别是该类的dueDate字段是String类型，long 类型的dueDate在获取“用户还款计划”接口的时，在json转的时候报异常
 */

public class RepaymentDetail implements Serializable {

	private static final long serialVersionUID = 6149652723679320799L;

	public double amountPrincipal;

	public double amountInterest;

	public double amountOutstanding;
	
	public double amount;

	public String dueDate;
	

	public RepaymentDetail() {
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
