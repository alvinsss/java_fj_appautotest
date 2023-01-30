package com.fengjr.model;

import java.io.Serializable;
import java.util.List;

/** 
 * @author suetming ( suetming.ma@gmail.com )
 * 
 * 2014-10-20 下午6:41:33 
 * 
 */

public class TenderPrepare implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8047119459704748759L;

	public String projectTitle;
	
	public List<ShippingAddress> addresses;
	
	public FundingReward reward;
}
