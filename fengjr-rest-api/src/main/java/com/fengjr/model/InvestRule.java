package com.fengjr.model;

import java.io.Serializable;

/**
 * Created by suetming on 14-3-4.
 */
public class InvestRule implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8565358422216590335L;
	public int minAmount;
	public int maxAmount;
	public int stepAmount;
}
