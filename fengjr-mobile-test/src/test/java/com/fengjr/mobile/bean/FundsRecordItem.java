package com.fengjr.mobile.bean;


/**
 * 资金流水列表项
 * @author crest
 *
 */
public interface FundsRecordItem {

	/**
	 * 流水状态
	 * @return
	 */
	String getStatus();

	/**
	 * 流水时间
	 * @return
	 */
	String getTime();
	
	/**
	 * 流水金额
	 * @return
	 */
	String getAmmount();

	/**
	 * 订单号
	 * @return
	 */
	String getOrderId();

}