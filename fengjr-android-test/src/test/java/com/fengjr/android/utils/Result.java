package com.fengjr.android.utils;

import org.testng.Assert;
import org.testng.Reporter;

public class Result {

	private ResultState result;
	private String message;

	public Result(String msg, boolean rst) {
		message = msg;
		if (rst == true) {
			result = ResultState.PASSED;
		} else {
			result = ResultState.FAILED;
		}
	}
	
	public void assertResult() {
		if (result == ResultState.PASSED) {
			Reporter.log(message, true);
			Assert.assertTrue(true, message);
		} else {
			Reporter.log(message, true);
			Assert.assertTrue(false, message);
		}
	}

	public enum ResultState {
		PASSED, FAILED
	}
}
