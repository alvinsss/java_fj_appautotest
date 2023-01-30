package com.fengjr.mobile.bean.os;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.fengjr.mobile.bean.FundsRecordItem;
import com.fengjr.mobile.utils.UiObject;

/**
 * 资金流水列表项
 * 
 * @author crest
 *
 */
public class OsFundsRecordItem implements FundsRecordItem {

	// 流水状态
	private String status = "";
	private By STATUS = By.id("flowOffundsStatus");

	// 流水时间
	private String time = "";
	private By TIME = By.id("timeOfFlow");

	// 流水金额
	private String ammount = "";
	private By AMMOUNT = By.id("amountOfFlow");

	// 订单号
	private String orderId = "";
	private By ORDER_ID = By.id("numberOfOrder");

	public OsFundsRecordItem(WebElement uio) {

		int height = UiObject.getAppiumDriver().manage().window().getSize().getHeight();
		if (uio.getLocation().getY() <= height && uio.getLocation().getY() >= 0) {
			WebElement statusElm = uio.findElement(STATUS);
			status = statusElm.getText();

			WebElement timeElm = uio.findElement(TIME);
			time = timeElm.getText();

			WebElement ammountElm = uio.findElement(AMMOUNT);
			ammount = ammountElm.getText();

			WebElement orderElm = uio.findElement(ORDER_ID);
			int uioY0 = uio.getLocation().getY();
			int uioY1 = uio.getLocation().getY() + uio.getSize().getHeight();
			int y0 = orderElm.getLocation().getY();
			int y1 = orderElm.getLocation().getY() + orderElm.getSize().getHeight();
			if (y0 >= uioY0 && y1 <= uioY1)
				orderId = orderElm.getText();
		} else {
			throw new RuntimeException("Failed to create FundsRecordItem");
		}
	}

	public String getStatus() {
		return status;
	}

	public String getTime() {
		return time;
	}

	public String getAmmount() {
		return ammount;
	}

	public String getOrderId() {
		return orderId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ammount == null) ? 0 : ammount.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((time == null) ? 0 : time.hashCode());
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
		OsFundsRecordItem other = (OsFundsRecordItem) obj;
		if (ammount == null) {
			if (other.ammount != null)
				return false;
		} else if (!ammount.equals(other.ammount))
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FundsRecordItem [status=" + status + ", time=" + time
				+ ", ammount=" + ammount + ", orderId=" + orderId + "]";
	}

}