package com.fengjr.model;

import java.io.Serializable;
import java.util.List;

public class TransferRepayInfo implements Serializable {

	private static final long serialVersionUID = -1133327509385490352L;
	public double totalPrincipal;
	public double totalAmount;
	public double totaInterest;
	public boolean creditAssignTurnOut=true;
	public String status;
	public List<InvestRepayment> investRepayments;

}
