package com.fengjr.model;

import java.io.Serializable;

public class UserFinance implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4222963670378630772L;
	//是否有房（是：true 否：false）
	public boolean house;
	//住房数量
	public long houseNumber;
	//有无房贷（有：true 无：false）
	public boolean houseLoan;
//	是否有车（有：true 无：false）
	public boolean car;
//	用车数量
	public long carNumber;
//	有无车贷（有：true 无：false）
	public boolean carLoan;
	
}
