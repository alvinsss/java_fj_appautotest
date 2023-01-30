package com.fengjr.mobile.test;

import io.appium.java_client.AppiumDriver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Map;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import android.content.Context;

import com.fengjr.mobile.setting.Configurator;

public class TestCaseBase {
	
	private Configurator config;

	@BeforeTest
	@Parameters({
		Configurator.SELENIUM_URL,
		Configurator.APP_URL, Configurator.APP_PACKAGE, Configurator.APP_ACTIVITY,
		Configurator.DEVICE_NAME, Configurator.PLATFORM_NAME, Configurator.PLATFORM_VERSION,
		Configurator.LOGIN_MOBILE_NUMBER, Configurator.LOGIN_PASSWORD})
	public void beforeTest(String seleniumUrl, 
			String app, String appPackage, String appActivity,
			String deviceName, String platformName, String platformVersion,
			String mobile, String password) throws IOException {

		Configurator config = Configurator.instance();
		config.beforeTest(seleniumUrl, app, appPackage, appActivity, deviceName, platformName, platformVersion, mobile, password);		
		try {
			Thread.sleep(10*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@BeforeClass
	public void beforeClass() {
		config = Configurator.instance();
	}

	public AppiumDriver getAppiumDriver() {
		return config.getAppiumDriver();
	}

	public Map<String, String> getParamters() {
		return config.getParamters();
	}
	
	public Context getContext() {
		return config.getContext();
	}
	
	public String getLoginAccount() {
		return config.getParamters().get(Configurator.LOGIN_MOBILE_NUMBER);
	}
	
	public String getLoginPassword() {
		return config.getParamters().get(Configurator.LOGIN_PASSWORD);
	}
}
