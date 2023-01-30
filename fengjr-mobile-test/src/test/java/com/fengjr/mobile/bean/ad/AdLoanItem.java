package com.fengjr.mobile.bean.ad;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.fengjr.mobile.bean.LoanItem;
import com.fengjr.mobile.utils.Formater;
import com.fengjr.mobile.utils.UiObject;
import com.fengjr.model.Loan;
import com.fengjr.model.enums.LoanStatus;

public class AdLoanItem implements LoanItem{
	
	public final static By TITLE = By.id("com.fengjr.mobile:id/title");
	public final static By RATE = By.id("com.fengjr.mobile:id/rate");
	public final static By DURATION = By.id("com.fengjr.mobile:id/duration");
	public final static By AMOUNT = By.id("com.fengjr.mobile:id/amount");
	public final static By STATE = By.id("com.fengjr.mobile:id/invest");
	
	private WebElement parentElement;

	// 借款项目编号
	private String title;
	// 年利率
	private String rate;
	// 借款期限
	private String duration;
	// 借款总额
	private String amount;
	// 项目状态
	private String status;
	// 项目详情
//	private LoanDetails details;
	
	public AdLoanItem(Loan loan) {
		title = loan.title;
		status = convertStatus(loan);
		rate = convertRate(loan);
		duration = convertDuration(loan);
		amount = convertAmount(loan);
	}
	
	public AdLoanItem(WebElement uio) {
		
		parentElement = uio;
		int positionY = uio.getLocation().getY();

		WebElement titleElm = uio.findElement(TITLE);
		WebElement rateElm = uio.findElement(RATE);
		WebElement durationElm = uio.findElement(DURATION);
		WebElement amountElm = uio.findElement(AMOUNT);
		WebElement stateElm = uio.findElement(STATE);
		
		if (titleElm.getLocation().getY() > positionY &&
			rateElm.getLocation().getY() > positionY &&
			durationElm.getLocation().getY() > positionY &&
			amountElm.getLocation().getY() > positionY &&
			stateElm.getLocation().getY() > positionY) {
			
			if (titleElm != null) {
				title = titleElm.getText();
			}
			
			if (rateElm != null) {
				rate = rateElm.getText();
			}
			
			if (durationElm != null) {
				duration = durationElm.getText();
			}
			
			if (amountElm != null) {
				amount = amountElm.getText();
			}
			
			if (stateElm != null) {
				status = stateElm.getText();
			}
			
		} else {
			throw new RuntimeException("create loan item failed");
		}
	
	}
	
	/**
	 * 进入项目详情
	 */
	public boolean enterLoanDetails() {
		if (UiObject.searchFor(TITLE)) {
			WebElement elm = parentElement.findElement(TITLE);
			elm.click();
			return true;
		}
		return false;
	}
	
//	/**
//	 * 加载项目详情信息，并且返回
//	 */
//	public boolean loadLoanDetails() {
//		if (enterLoanDetails()) {
//			//Logger.getLogger(getClass()).info("Loading " + getTitle() + " details.");
//			details = new LoanDetails();
//			//Logger.getLogger(getClass()).info(details.toString());
//			details.clickBack();
//			return true;
//		}
//		return false;
//	}
//	
//	public LoanDetails getLoanDetails() {
//		return details;
//	}
	
	public String getTitle() {
		return title;
	}

	public String getRate() {
		return rate;
	}

	public String getDuration() {
		return duration;
	}

	public String getAmount() {
		return amount;
	}

	public String getStatus() {
		return status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		AdLoanItem other = (AdLoanItem) obj;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	

	public String convertAmount(Loan loan) {
		return Formater.getCurrencyCommontFormat(loan.amount);
	}
	
	private String convertDuration(Loan loan) {
		String duration = null;
		if (loan.loanRequest.duration != null) {
			if (loan.loanRequest.duration.totalMonths > 0) {
				duration = String.format("%1$2d个月",
						loan.loanRequest.duration.totalMonths);
			} else if (loan.loanRequest.duration.totalDays > 0) {
				duration = String.format("%1$2d天",
						loan.loanRequest.duration.totalDays);
			}
		}
		
		return duration;
	}
	
	private String convertRate(Loan loan) {
		String num=String.format((loan.rate % 100.0f) > 0 ? "%1$.2f%%"
				: "%1$.0f%%", loan.rate / 100.0f);
		if(num.contains(".")){
			if(num.endsWith("0%")){
				num=num.substring(0, num.lastIndexOf("0"))+"%";
			}
		}
		return num;
	}
	
	private String convertStatus(Loan loan) {
		String status = null;
		if (loan.status.contentEquals(LoanStatus.FINISHED.name())) {
			status = "已满标";
		} else if (loan.status.contentEquals(LoanStatus.SETTLED.name())) {
			status = "还款中";
		} else if (loan.status.contentEquals(LoanStatus.CLEARED.name())) {
			status = "还款完成";
		} else if (loan.status.contentEquals(LoanStatus.OPENED.name())) {
			status = "投标";
		} else if (loan.status.contentEquals(LoanStatus.SCHEDULED.name())) {
			status = "即将开始";
		}else if (loan.status.contentEquals(LoanStatus.OVERDUE.name())) {
			status = "逾期";
		}else if (loan.status.contentEquals(LoanStatus.CANCELED.name())) {
			status = "已取消";
		}else if (loan.status.contentEquals(LoanStatus.FAILED.name())) {
			status = "流标";
		}
		
		return status;
	}

	@Override
	public String toString() {
		return "InvestItem [title=" + title + ", rate=" + rate + ", duration="
				+ duration + ", amount=" + amount + ", state=" + status + "]";
	}
}
