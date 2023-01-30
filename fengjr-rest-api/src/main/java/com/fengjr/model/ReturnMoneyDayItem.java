package com.fengjr.model;

import java.util.List;

/**
 * 
 * @author gaoge
 * 
 * 回款查询中，每天要还款操作的封装类
 * 比如2015-1-2就是一个ReturnMoneyDayItem，每一天可以包含多个还款操作，
 *
 */
public class ReturnMoneyDayItem {
	
	public long date;
	public List<ReturnMoneyDayItemEvent> events;
	
}
