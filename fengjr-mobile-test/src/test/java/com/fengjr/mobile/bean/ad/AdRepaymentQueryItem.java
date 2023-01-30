package com.fengjr.mobile.bean.ad;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.fengjr.mobile.bean.RepaymentQueryItem;

/**
 * 回款查询列表项
 * @author crest
 *
 */
public class AdRepaymentQueryItem implements RepaymentQueryItem{
	
	// 回款标题
	private String repementTitle;
	private By REPEMENT_TITLE = By.id("com.fengjr.mobile:id/title");
	
	// 回款日期
	private String repementDate;
	private By REPEMENT_DATE = By.id("com.fengjr.mobile:id/date");
	
	// 回款金额
	private String repementAmmount;
	private By REPEMENT_AMMOUNT = By.id("com.fengjr.mobile:id/return_money_value");
	
	public AdRepaymentQueryItem(WebElement uio) {
		
		try {
			WebElement titlElm = uio.findElement(REPEMENT_TITLE);
			repementTitle = titlElm.getText();
			
			WebElement dateElm = uio.findElement(REPEMENT_DATE);
			repementDate = dateElm.getText();
			
			WebElement ammountElm = uio.findElement(REPEMENT_AMMOUNT);
			repementAmmount = ammountElm.getText();
			
		} catch (Exception e) {
			throw new RuntimeException("Failed to create RepementListItem");
		}
	}

	public String getRepementTitle() {
		return repementTitle;
	}

	public String getRepementDate() {
		return repementDate;
	}

	public String getRepementAmmount() {
		return repementAmmount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((repementAmmount == null) ? 0 : repementAmmount.hashCode());
		result = prime * result
				+ ((repementDate == null) ? 0 : repementDate.hashCode());
		result = prime * result
				+ ((repementTitle == null) ? 0 : repementTitle.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AdRepaymentQueryItem other = (AdRepaymentQueryItem) obj;
		if (repementAmmount == null) {
			if (other.repementAmmount != null)
				return false;
		} else if (!repementAmmount.equals(other.repementAmmount))
			return false;
		if (repementDate == null) {
			if (other.repementDate != null)
				return false;
		} else if (!repementDate.equals(other.repementDate))
			return false;
		if (repementTitle == null) {
			if (other.repementTitle != null)
				return false;
		} else if (!repementTitle.equals(other.repementTitle))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RepaymentQueryItem [repementTitle=" + repementTitle
				+ ", repementDate=" + repementDate + ", repementAmmount="
				+ repementAmmount + "]";
	}
	
	
}