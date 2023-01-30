package com.fengjr.android.test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SampleTest {

	// appium parameters
	private DesiredCapabilities capabilities;
	private AndroidDriver appium;
	
	// device parameters
	private String deviceName;
	private String platformName;
	private String platformVersion;
	
	// android parameters
	private String app;
	private String appPackage;
	private String appActivity;
	
	// selenium grid parameter
	private String seleniumUrl;
	
	// account parameters
	private String account;
	private String password;
	
	// wait for 10 seconds
	private WebDriverWait wait10s;
	
	// wait for 5 minutes
	private WebDriverWait wait5m;
	
	@BeforeTest
	@Parameters({
		"selenium-url",
		"app-url", "app-package", "app-activity",
		"device-name", "platform-name", "platform-version",
		"account", "password"})
	public void beforeTest(String seleniumUrl, 
			String app, String appPackage, String appActivity,
			String deviceName, String platformName, String platformVersion,
			String account, String password) {
		
		this.seleniumUrl = seleniumUrl;
		
		this.app = app;
		this.appPackage = appPackage;
		this.appActivity = appActivity;
		
		this.deviceName = deviceName;
		this.platformName = platformName;
		this.platformVersion = platformVersion;
		
		this.account = account;
		this.password = password;
	}

	@BeforeClass
	public void beforeClass() throws MalformedURLException {
	    capabilities = new DesiredCapabilities();
	    capabilities.setCapability("deviceName", deviceName);
	    capabilities.setCapability("platformName", platformName);
	    capabilities.setCapability("platformVersion", platformVersion);
	    capabilities.setCapability("app", app);
	    capabilities.setCapability("appPackage", appPackage);
	    capabilities.setCapability("appActivity", appActivity);
	    
		System.out.println(capabilities.toString());
		
	    appium = new AndroidDriver(new URL(seleniumUrl), capabilities);
	    wait10s = new WebDriverWait(appium, 10);
	    wait5m = new WebDriverWait(appium, 5 * 60 * 1000);
	}
	
	@Test
	public void testMethod() throws InterruptedException {
		
		long id = Thread.currentThread().getId();
		System.out.println("login test:" + deviceName + ", Thread id is " + id) ;
		String activity = appium.currentActivity();
		System.out.println(activity);
		
		By locator = By.id("com.fengjr.mobile:id/mobile");
		WebElement usernameEditText = wait10s.until(ExpectedConditions.visibilityOfElementLocated(locator));
		usernameEditText.click();
		usernameEditText.clear();
		usernameEditText.sendKeys(account);
		appium.hideKeyboard();
		
		locator = By.id("com.fengjr.mobile:id/password");
		WebElement passwordEditText = wait10s.until(ExpectedConditions.visibilityOfElementLocated(locator));
		passwordEditText.click();
		passwordEditText.clear();
		passwordEditText.sendKeys(password);
		appium.hideKeyboard();
		
		locator = By.id("com.fengjr.mobile:id/login");
		WebElement loginButtion = wait10s.until(ExpectedConditions.visibilityOfElementLocated(locator));
		loginButtion.click();
		
	 	locator = By.id("com.fengjr.mobile:id/bt_agreement");
	 	WebElement agreement = wait10s.until(ExpectedConditions.visibilityOfElementLocated(locator));
	 	if (agreement != null) {
	 		locator = By.id("com.fengjr.mobile:id/left");
	 		WebElement backLeft = wait10s.until(ExpectedConditions.visibilityOfElementLocated(locator));
	 		backLeft.click();
	 	}
	 	
		locator = By.id("com.fengjr.mobile:id/gesture");
		WebElement patternPanel = wait10s.until(ExpectedConditions.visibilityOfElementLocated(locator));
		takeGestrue(patternPanel);
		patternPanel = wait10s.until(ExpectedConditions.visibilityOfElementLocated(locator));
	 	takeGestrue(patternPanel);
	 	
	 	locator = By.id("com.fengjr.mobile:id/ivMoney");
	 	WebElement ivMoney = wait10s.until(ExpectedConditions.visibilityOfElementLocated(locator));
	 	ivMoney.click();
	 	
	 	locator = By.id("com.fengjr.mobile:id/ivMoneyB");
	 	WebElement ivMoneyB = wait10s.until(ExpectedConditions.visibilityOfElementLocated(locator));
	 	ivMoneyB.click();
	 	
	 	locator = By.id("com.fengjr.mobile:id/viewPager");
	 	WebElement viewPager = wait10s.until(ExpectedConditions.visibilityOfElementLocated(locator));
		Point point = viewPager.getLocation();
	 	Dimension dimension = viewPager.getSize();
	 	System.out.println(point.toString());
	 	System.out.println(dimension.toString());
	 	int startx = point.x + dimension.width / 2;
	 	int starty = point.y + dimension.height / 5;
	 	int endx = point.x + dimension.width / 2;
	 	int endy = point.y + dimension.height - dimension.height / 5;
	 	while (appium.findElements(By.name("风锐通ZDSD-20141123-001")).size() == 0) {
		 	appium.swipe(endx, endy, startx, starty, 500);
	 	}
	 	appium.findElement(By.name("风锐通ZDSD-20141123-001")).click();
	 	
	 	locator = By.id("com.fengjr.mobile:id/confirmInvest");
	 	WebElement confirmInvest = wait10s.until(ExpectedConditions.visibilityOfElementLocated(locator));
	 	confirmInvest.click();
	 	
	 	for (int i = 0; i < 10; i++) {
			locator = By.id("com.fengjr.mobile:id/etAmount");
			WebElement etAmout = wait10s.until(ExpectedConditions.visibilityOfElementLocated(locator));
			etAmout.click();
			etAmout.clear();
			etAmout.sendKeys("1");
			appium.hideKeyboard();
		 	Thread.sleep(500);
		 	
		 	locator = By.id("com.fengjr.mobile:id/confirmInvest");
		 	confirmInvest = wait10s.until(ExpectedConditions.visibilityOfElementLocated(locator));
		 	confirmInvest.click();
		 	Thread.sleep(500);
		 	
		 	locator = By.id("com.fengjr.mobile:id/ok");
		 	WebElement ok = wait10s.until(ExpectedConditions.visibilityOfElementLocated(locator));
		 	ok.click();
	 	}

	}
	
	
//	@Test
//	public void testZhongcou() throws InterruptedException {
//		
//		long id = Thread.currentThread().getId();
//		System.out.println("login test:" + deviceName + ", Thread id is " + id) ;
//		String activity = appium.currentActivity();
//		System.out.println(activity);
//		
//		By locator = By.id("com.fengjr.mobile:id/mobile");
//		WebElement usernameEditText = wait10s.until(ExpectedConditions.visibilityOfElementLocated(locator));
//		usernameEditText.click();
//		usernameEditText.clear();
//		usernameEditText.sendKeys(account);
//		appium.hideKeyboard();
//		
//		locator = By.id("com.fengjr.mobile:id/password");
//		WebElement passwordEditText = wait10s.until(ExpectedConditions.visibilityOfElementLocated(locator));
//		passwordEditText.click();
//		passwordEditText.clear();
//		passwordEditText.sendKeys(password);
//		appium.hideKeyboard();
//		
//		locator = By.id("com.fengjr.mobile:id/login");
//		WebElement loginButtion = wait10s.until(ExpectedConditions.visibilityOfElementLocated(locator));
//		loginButtion.click();
//		
//	 	locator = By.id("com.fengjr.mobile:id/bt_agreement");
//	 	WebElement agreement = wait10s.until(ExpectedConditions.visibilityOfElementLocated(locator));
//	 	if (agreement != null) {
//	 		locator = By.id("com.fengjr.mobile:id/left");
//	 		WebElement backLeft = wait10s.until(ExpectedConditions.visibilityOfElementLocated(locator));
//	 		backLeft.click();
//	 	}
//	 	
//		locator = By.id("com.fengjr.mobile:id/ivFunding");
//		WebElement patternPanel = wait10s.until(ExpectedConditions.visibilityOfElementLocated(locator));
//		takeGestrue(patternPanel);
//		patternPanel = wait10s.until(ExpectedConditions.visibilityOfElementLocated(locator));
//	 	takeGestrue(patternPanel);
//	 	
//	 	locator = By.id("com.fengjr.mobile:id/ivMoney");
//	 	WebElement ivMoney = wait10s.until(ExpectedConditions.visibilityOfElementLocated(locator));
//	 	ivMoney.click();
//	 	
//	 	locator = By.id("com.fengjr.mobile:id/viewPager");
//	 	WebElement viewPager = wait10s.until(ExpectedConditions.visibilityOfElementLocated(locator));
//		Point point = viewPager.getLocation();
//	 	Dimension dimension = viewPager.getSize();
//	 	System.out.println(point.toString());
//	 	System.out.println(dimension.toString());
//	 	int startx = point.x + dimension.width / 2;
//	 	int starty = point.y + dimension.height / 5;
//	 	int endx = point.x + dimension.width / 2;
//	 	int endy = point.y + dimension.height - dimension.height / 5;
//	 	while (appium.findElements(By.name("凤保宝YDCE-20141119-XXX")).size() == 0) {
//		 	appium.swipe(endx, endy, startx, starty, 500);
//	 	}
//	 	appium.findElement(By.name("凤保宝YDCE-20141119-XXX")).click();
//	 	
//	 	locator = By.id("com.fengjr.mobile:id/confirmInvest");
//	 	WebElement confirmInvest = wait10s.until(ExpectedConditions.visibilityOfElementLocated(locator));
//	 	confirmInvest.click();
//	 	
//	 	for (int i = 0; i < 10; i++) {
//			locator = By.id("com.fengjr.mobile:id/etAmount");
//			WebElement etAmout = wait10s.until(ExpectedConditions.visibilityOfElementLocated(locator));
//			etAmout.click();
//			etAmout.clear();
//			etAmout.sendKeys("1");
//			appium.hideKeyboard();
//		 	Thread.sleep(500);
//		 	
//		 	locator = By.id("com.fengjr.mobile:id/confirmInvest");
//		 	confirmInvest = wait10s.until(ExpectedConditions.visibilityOfElementLocated(locator));
//		 	confirmInvest.click();
//		 	Thread.sleep(500);
//		 	
//		 	locator = By.id("com.fengjr.mobile:id/ok");
//		 	WebElement ok = wait10s.until(ExpectedConditions.visibilityOfElementLocated(locator));
//		 	ok.click();
//	 	}
//
//	}

	
	private void takeGestrue(WebElement patternPanel) {
	 	TouchAction touchAction = new TouchAction(appium);
	 	
		Point point = patternPanel.getLocation();
	 	Dimension dimension = patternPanel.getSize();
	 	System.out.println(point.toString());
	 	System.out.println(dimension.toString());
	 	
	 	int width = dimension.getWidth() / 6;
	 	int height = dimension.getHeight() / 6;
	 	
	 	int x1 = point.x + width;
	 	int y1 = point.y + height;
	 	System.out.println("[" + x1 + "," + y1 + "]");
	 	
	 	int x15 = point.x + width * 3;
	 	int y15 = point.y + height;
	 	
	 	int x2 = point.x + width * 5;
	 	int y2 = point.y + height;
	 	System.out.println("[" + x2 + "," + y2 + "]");
	 	
	 	int x3 = point.x + width * 5;
	 	int y3 = point.y + height * 5;
	 	System.out.println("[" + x3 + "," + y3 + "]");
	 	
	 	// touchAction.tap(x1, y1).tap(x2, y2).tap(x3, y3);
	 	touchAction.press(x1, y1).moveTo(x15, y15).waitAction(1000).
	 		moveTo(x2, y2).waitAction(1000).moveTo(x3, y3).release();
	 	touchAction.perform();
	}
	
	@AfterClass
	public void afterClass() {
		
	}
	
	@AfterTest
	public void afterTest() {
		
	}
	
	
}
