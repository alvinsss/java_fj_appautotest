package com.fengjr.android.log4j;

import org.apache.log4j.or.ObjectRenderer;

import com.fengjr.android.lexicon.imp.LoanItem;
import com.fengjr.model.Loan;

public class LoanRenderer implements ObjectRenderer{

	@Override
	public String doRender(Object o) {

		StringBuffer buffer = new StringBuffer(50);
		if (o instanceof LoanItem) {
			buffer.append(((LoanItem) o).getTitle()).append('\t');
			buffer.append(((LoanItem) o).getStatus()).append('\t');
			buffer.append(((LoanItem) o).getRate()).append('\t');
			buffer.append(((LoanItem) o).getDuration()).append('\t');
			buffer.append(((LoanItem) o).getAmount()).append('\t');
		} else if (o instanceof Loan) {
			buffer.append(((Loan) o).getTitle()).append('\t');
			buffer.append(((Loan) o).getStatus()).append('\t');
			buffer.append(((Loan) o).getRate()).append('\t');
			buffer.append(((Loan) o).getDuration()).append('\t');
			buffer.append(((Loan) o).getAmount()).append('\t');
		}
		
		return buffer.toString();
	}

}
