package com.fengjr.mobile.setting;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.remote.DesiredCapabilities;

import android.content.Context;

public class Configurator {
	
	public final static String SELENIUM_URL = "selenium-url";
	public final static String APP_URL = "app-url";
	public final static String APP_PACKAGE = "app-package";
	public final static String APP_ACTIVITY = "app-activity";
	public final static String DEVICE_NAME = "device-name";
	public final static String PLATFORM_NAME = "platform-name";
	public final static String PLATFORM_VERSION = "platform-version";

	public final static String LOGIN_MOBILE_NUMBER = "mobile-number";
	public final static String LOGIN_PASSWORD = "password";
	
	public final static int TIMEOUT_LONG = 10;
	public final static int TIMEOUT_SHORT = 5;


	// appium parameters
	private DesiredCapabilities capabilities;
	private AppiumDriver appium;
	private Context context;
	
	private Map<String, String> para;
	
	private static Configurator configurator;
	
	public static Configurator instance() {
		if (configurator == null) {
			return configurator = new Configurator();
		} else {
			return configurator;
		}
	}

	private Configurator() {
		para = new HashMap<String,String>();
		context = new Context();
	}
	
	public void beforeTest(String seleniumUrl, 
			String app, String appPackage, String appActivity,
			String deviceName, String platformName, String platformVersion,
			String mobile, String password) throws IOException {
		
		para.put(Configurator.SELENIUM_URL, seleniumUrl);
		para.put(Configurator.APP_URL, app);
		para.put(Configurator.APP_PACKAGE, appPackage);
		para.put(Configurator.APP_ACTIVITY, appActivity);
		para.put(Configurator.DEVICE_NAME, deviceName);
		para.put(Configurator.PLATFORM_NAME, platformName);
		para.put(Configurator.PLATFORM_VERSION, platformVersion);
		para.put(Configurator.LOGIN_MOBILE_NUMBER, mobile);
		para.put(Configurator.LOGIN_PASSWORD, password);
		
		
		if (platformName.equalsIgnoreCase("ios")) {
			//Runtime rt = Runtime.getRuntime();
			//rt.exec("/usr/local/bin/mobiledevice uninstall_app -u 1af8d257a3aadbf67ba34371d0c348d36df7abdc com.fengjr.mobile");
		}

	    capabilities = new DesiredCapabilities();
	    capabilities.setCapability("deviceName", para.get(DEVICE_NAME));
	    capabilities.setCapability("platformName", para.get(PLATFORM_NAME));
	    capabilities.setCapability("platformVersion",  para.get(PLATFORM_VERSION));
	    capabilities.setCapability("app", para.get(APP_URL));
	    capabilities.setCapability("appPackage", para.get(APP_PACKAGE));
	    capabilities.setCapability("appActivity", para.get(APP_ACTIVITY));
	    
		System.out.println(capabilities.toString());
		
		if ("Android".equalsIgnoreCase(para.get(PLATFORM_NAME))) {
			appium = new AndroidDriver(new URL(seleniumUrl), capabilities);
		} else if ("iOS".equalsIgnoreCase(para.get(PLATFORM_NAME))) {
			appium = new IOSDriver(new URL(seleniumUrl), capabilities);
		} else {
			throw new RuntimeException("unspported platform: " + para.get(PLATFORM_NAME));
		}
	}
	
	public AppiumDriver getAppiumDriver() {
		return appium;
	}
	
	public Map<String,String> getParamters() {
		System.out.println(para.toString());
		return para;
	}
	
	public String get(String key) {
		return para.get(key);
	}
	
	public Context getContext() {
		return context;
	}
}
