package com.fengjr.android.test;

import io.appium.java_client.AppiumDriver;

import java.net.MalformedURLException;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import android.content.Context;

import com.fengjr.android.uiobj.Configurator;
import com.fengjr.android.utils.Navigator;

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
			String mobile, String password) throws MalformedURLException {

		Configurator config = Configurator.instance();
		config.beforeTest(seleniumUrl, app, appPackage, appActivity, deviceName, platformName, platformVersion, mobile, password);		
	}
	
	@BeforeClass
	public void beforeClass() {
		config = Configurator.instance();
	}

	public AppiumDriver getAppiumDriver() {
		return config.getAppiumDriver();
	}

	public Navigator getNavigator() {
		return config.getNavigator();
	}

	public Map<String, String> getParamters() {
		return config.getParamters();
	}
	
	public Context getContext() {
		return config.getContext();
	}
}
