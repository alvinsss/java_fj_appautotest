package com.fengjr.event.response;

import com.fengjr.event.Response;



public class UserStockDataEvent extends Response {

	public String stockData;

	public UserStockDataEvent(String stockData, String error) {
		super(error);
		this.stockData = stockData;
		
	}
}
