package com.fengjr.android.lexicon.imp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.fengjr.android.uiobj.UiObject;

public class MyFollowItem {
	
	// 众筹项目 com.fengjr.mobile:id/tvDes
	private By TITLE = By.id("com.fengjr.mobile:id/tvDes");
	
	// 众筹进度 com.fengjr.mobile:id/project_progress_tv
	private By PROGRESS = By.id("com.fengjr.mobile:id/project_progress_tv");
	
	// 支持人数 com.fengjr.mobile:id/project_item_person_num
	private By PERSON_NUM = By.id("com.fengjr.mobile:id/project_item_person_num");
	
	// 已筹金额 com.fengjr.mobile:id/project_item_amount
	private By AMOUNT = By.id("com.fengjr.mobile:id/project_item_amount");
	
	// 距离结束时间 com.fengjr.mobile:id/project_item_day
	private By DAY = By.id("com.fengjr.mobile:id/project_item_day");
	
	private String title;
	private String progress;
	private String personNum;
	private String amount;
	private String day;
	
	public MyFollowItem(WebElement elm) {
		if (UiObject.searchFor(TITLE)) {
			WebElement uio = elm.findElement(TITLE);
			title = uio.getText();
		}
		
		if (UiObject.searchFor(PROGRESS)) {
			WebElement uio = elm.findElement(PROGRESS);
			progress = uio.getText();
		}
		
		if (UiObject.searchFor(PERSON_NUM)) {
			WebElement uio = elm.findElement(PERSON_NUM);
			personNum = uio.getText();
		}
		
		if (UiObject.searchFor(AMOUNT)) {
			WebElement uio = elm.findElement(AMOUNT);
			amount = uio.getText();
		}
		
		if (UiObject.searchFor(DAY)) {
			WebElement uio = elm.findElement(DAY);
			day = uio.getText();
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((day == null) ? 0 : day.hashCode());
		result = prime * result
				+ ((personNum == null) ? 0 : personNum.hashCode());
		result = prime * result
				+ ((progress == null) ? 0 : progress.hashCode());
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
		MyFollowItem other = (MyFollowItem) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (day == null) {
			if (other.day != null)
				return false;
		} else if (!day.equals(other.day))
			return false;
		if (personNum == null) {
			if (other.personNum != null)
				return false;
		} else if (!personNum.equals(other.personNum))
			return false;
		if (progress == null) {
			if (other.progress != null)
				return false;
		} else if (!progress.equals(other.progress))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MyFollowItem [title=" + title + ", progress=" + progress
				+ ", personNum=" + personNum + ", amount=" + amount + ", day="
				+ day + "]";
	}
}
