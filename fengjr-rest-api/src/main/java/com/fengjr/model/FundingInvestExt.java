package com.fengjr.model;

import java.io.Serializable;

/**
 * @author suetming ( suetming.ma@gmail.com )
 * 
 *         2014-10-11 下午2:55:22
 * 
 */

public class FundingInvestExt implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1023756572894197523L;

	
	public FundingInvestDetail invest;
	
	public FundingProject project;
	
	public FundingReward reward;
}
