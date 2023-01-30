package com.fengjr.model;

import java.io.Serializable;

/**
 * @author suetming ( suetming.ma@gmail.com )
 * 
 *         2014-10-20 下午6:44:48
 * 
 */

public class Order implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8413763192163591257L;

	
	public String projectTitle;
	
	public FundingInvestInfo order;
	
	public FundingReward reward;
	
}
