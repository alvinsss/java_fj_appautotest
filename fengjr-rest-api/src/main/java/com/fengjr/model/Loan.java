package com.fengjr.model;

import java.io.Serializable;

public class Loan implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 725673078345496633L;

	public String id;

	public String title;
	public String method;
	public String ordinal;
	public double amount;
	public int rate;
	public Duration duration;

	public LoanRequest loanRequest;

	public String corporationName;
	public long timeOpen;

	public long timeFinished;

	public long timeCleared;

	public long timeSettled;

	public boolean mortgaged;

	public long bidNumber;

	public double bidAmount;

	public double available;

	public String status;

	public boolean rewarded;

	public boolean hidden;

	public boolean autoSplitted;

	public int investAmount;

	public double investPercent;

	public long timeLoss = -1;

	public long tickLoss = 0;

	public double balance;

	public long leftBidTime = 0;

	public long timeLeft = 0;

	public long timeElapsed;

	public long countDownTime = 0;

	public long deviation = 0;

	public long timeout;

	public long serverDate;
	
	public String loanType; //标地类型，NORMAL/普通标的, BENEFITEASSIGN/收益权转让标的

	public long getServerDate() {
		return serverDate;
	}

	public void setServerDate(long serverDate) {
		this.serverDate = serverDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getOrdinal() {
		return ordinal;
	}

	public void setOrdinal(String ordinal) {
		this.ordinal = ordinal;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public Duration getDuration() {
		return duration;
	}

	public void setDuration(Duration duration) {
		this.duration = duration;
	}

	public LoanRequest getLoanRequest() {
		return loanRequest;
	}

	public void setLoanRequest(LoanRequest loanRequest) {
		this.loanRequest = loanRequest;
	}

	public long getTimeOpen() {
		return timeOpen;
	}

	public void setTimeOpen(long timeOpen) {
		this.timeOpen = timeOpen;
	}

	public long getTimeFinished() {
		return timeFinished;
	}

	public void setTimeFinished(long timeFinished) {
		this.timeFinished = timeFinished;
	}

	public long getTimeCleared() {
		return timeCleared;
	}

	public void setTimeCleared(long timeCleared) {
		this.timeCleared = timeCleared;
	}

	public long getTimeSettled() {
		return timeSettled;
	}

	public void setTimeSettled(long timeSettled) {
		this.timeSettled = timeSettled;
	}

	public boolean isMortgaged() {
		return mortgaged;
	}

	public void setMortgaged(boolean mortgaged) {
		this.mortgaged = mortgaged;
	}

	public long getBidNumber() {
		return bidNumber;
	}

	public void setBidNumber(long bidNumber) {
		this.bidNumber = bidNumber;
	}

	public double getBidAmount() {
		return bidAmount;
	}

	public void setBidAmount(double bidAmount) {
		this.bidAmount = bidAmount;
	}

	public double getAvailable() {
		return available;
	}

	public void setAvailable(double available) {
		this.available = available;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isRewarded() {
		return rewarded;
	}

	public void setRewarded(boolean rewarded) {
		this.rewarded = rewarded;
	}

	public boolean isHidden() {
		return hidden;
	}

	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}

	public boolean isAutoSplitted() {
		return autoSplitted;
	}

	public void setAutoSplitted(boolean autoSplitted) {
		this.autoSplitted = autoSplitted;
	}

	public int getInvestAmount() {
		return investAmount;
	}

	public void setInvestAmount(int investAmount) {
		this.investAmount = investAmount;
	}

	public double getInvestPercent() {
		return investPercent;
	}

	public void setInvestPercent(double investPercent) {
		this.investPercent = investPercent;
	}

	public long getTimeLoss() {
		return timeLoss;
	}

	public void setTimeLoss(long timeLoss) {
		this.timeLoss = timeLoss;
	}

	public long getTickLoss() {
		return tickLoss;
	}

	public void setTickLoss(long tickLoss) {
		this.tickLoss = tickLoss;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public long getLeftBidTime() {
		return leftBidTime;
	}

	public void setLeftBidTime(long leftBidTime) {
		this.leftBidTime = leftBidTime;
	}

	public long getTimeLeft() {
		return timeLeft;
	}

	public void setTimeLeft(long timeLeft) {
		this.timeLeft = timeLeft;
	}

	public long getTimeElapsed() {
		return timeElapsed;
	}

	public void setTimeElapsed(long timeElapsed) {
		this.timeElapsed = timeElapsed;
	}

	public long getCountDownTime() {
		return countDownTime;
	}

	public void setCountDownTime(long countDownTime) {
		this.countDownTime = countDownTime;
	}

	public long getDeviation() {
		return deviation;
	}

	public void setDeviation(long deviation) {
		this.deviation = deviation;
	}

	public long getTimeout() {
		return timeout;
	}

	public void setTimeout(long timeout) {
		this.timeout = timeout;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void update(Loan otherObj) {
		this.title = otherObj.title;
		this.method = otherObj.method;
		this.ordinal = otherObj.ordinal;
		this.amount = otherObj.amount;
		this.rate = otherObj.rate;
		this.duration = otherObj.duration;
		this.loanRequest = otherObj.loanRequest;
		this.timeOpen = otherObj.timeOpen;
		this.timeFinished = otherObj.timeFinished;
		this.timeCleared = otherObj.timeCleared;
		this.timeSettled = otherObj.timeSettled;
		this.mortgaged = otherObj.mortgaged;
		this.bidNumber = otherObj.bidNumber;
		this.bidAmount = otherObj.bidAmount;
		this.available = otherObj.available;
		this.status = otherObj.status;
		this.rewarded = otherObj.rewarded;
		this.hidden = otherObj.hidden;
		this.autoSplitted = otherObj.autoSplitted;
		this.investAmount = otherObj.investAmount;
		this.investPercent = otherObj.investPercent;
		this.timeLoss = otherObj.timeLoss;
		this.tickLoss = otherObj.tickLoss;
		this.balance = otherObj.balance;
		this.leftBidTime = otherObj.leftBidTime;
		this.timeLeft = otherObj.timeLeft;
		this.timeElapsed = otherObj.timeElapsed;
		this.countDownTime = otherObj.countDownTime;
		this.deviation = otherObj.deviation;
		this.timeout = otherObj.timeout;
		this.serverDate = otherObj.serverDate;
	}
}
