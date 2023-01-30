package com.fengjr.model;

import java.io.Serializable;

public class CreditAssignExpectedResult implements Serializable {

	private static final long serialVersionUID = -492178421659895463L;
	// 剩余本金
	public String unpayedPrincipal ="0";
	// 当期应记利息
	public String currentPeriodInterest = "0";
	// 转让手续费率
	public String rate = "0";

}
