package com.fengjr.android.uiobj;

import io.appium.java_client.AppiumDriver;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fengjr.android.listener.TraversalListener;

public class UiScroller<T> extends UiObject {

	private AppiumDriver appium;
	private Configurator config;
	private By selector;
	private By subSelector;
	private By xpathSelector;
	private List<T> obserevedElems;
	private WebElement listElm;
	
	public UiScroller(By by, String xpath) {
		super(by);
		config = Configurator.instance();
		appium = config.getAppiumDriver();
		selector = by;
		xpathSelector = By.xpath(xpath);
		obserevedElems = new ArrayList<T>();
	}
	
	public UiScroller(By by, By subBy) {
		super(by);
		config = Configurator.instance();
		appium = config.getAppiumDriver();
		selector = by;
		subSelector = subBy;
		obserevedElems = new ArrayList<T>();
	}
	
	/**
	 * 返回当前界面看见的列表项
	 * @return
	 */	
	public List<T> currentItems(Class<T> clazz) {
		List<T> items = new ArrayList<T>();
		
		WebDriverWait wait = new WebDriverWait(appium, Configurator.TIMEOUT_LONG);
		WebElement listElm = wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
		
		//查看是否处于正在加载的状态中
		UiObject uio = new UiObject(By.id("com.fengjr.mobile:id/hint"));
		if (uio.waitGone(Configurator.TIMEOUT_LONG)) {
			
			List<WebElement> elements = null;
			if (xpathSelector == null) {
				elements = listElm.findElements(subSelector);
			} else {
				elements = appium.findElements(xpathSelector);
			}
			Iterator<WebElement> itor = elements.iterator();
			while (itor.hasNext()) {
				WebElement elm = itor.next();
				T item = createItem(clazz, elm);
				if (item != null && !items.contains(item)) {
					items.add(item);
				}
			}
		}
		
		return items;
	}
	
	/**
	 * 返回所有已观测到的列表项
	 * @return
	 */
	public List<T> allObservedItems() {
		return obserevedElems;
	}
	
	/**
	 * 从当前位置遍历List, 获取List中所有元素
	 * @return 获取List中元素的数目
	 */
	public int traversal(Class<T> clazz, TraversalListener<T> listener) {
		obserevedElems.clear();
		
		WebDriverWait wait = new WebDriverWait(appium, Configurator.TIMEOUT_LONG);
		listElm = wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
		
		if (listener != null) listener.start();
		
		UiObject uio = new UiObject(By.id("com.fengjr.mobile:id/hint"));
		while (uio.waitGone(Configurator.TIMEOUT_LONG)) { 

			int preSize = obserevedElems.size();
				
			List<WebElement> elements = null;
			if (xpathSelector == null) {
				elements = listElm.findElements(subSelector);
			} else {
				elements = appium.findElements(xpathSelector);
			}

			addElement2List(elements, clazz, listener);
			
			if (obserevedElems.size() == preSize) {
				break;
			} else {
				scrollDown();
			}
		}
		
		if (listener != null) listener.end(obserevedElems);
		
		return obserevedElems.size();
	}
	
	/**
	 * 将找到的界面元素添加到观测列表中
	 * @param elems
	 * @param clazz 
	 */
	private void addElement2List(List<WebElement> elems, Class<T> clazz, TraversalListener<T> listener) {
		Iterator<WebElement> itor = elems.iterator();
		while (itor.hasNext()) {
			WebElement elm = itor.next();
//			Dimension listSize = listElm.getSize();
//			Dimension elemSize = elm.getSize();
//			Point listLocation = listElm.getLocation();
//			Point elemLocation = elm.getLocation();
//			
//			int elemh = elemLocation.y + elemSize.getHeight();
//			int listh = listLocation.y + listSize.getHeight();
			
//			if (elemh < listh) {
				T item = createItem(clazz, elm);
				if (item != null && !obserevedElems.contains(item)) {
					listener.findItem(item);
					obserevedElems.add(item);
				}
//			} 
		}
	}
	
	/**
	 * 提取List中Item的信息
	 * @param clazz
	 * @param elm
	 * @return
	 */
	private T createItem(Class<T> clazz, WebElement elm) {
		
		T listItem = null;
		
		try {
			Constructor<T> ctor = clazz.getConstructor(WebElement.class);
			listItem = ctor.newInstance(elm);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			//e.printStackTrace();
		}
		
		return listItem;
	}
	
	@Override
	public String toString() {
		Iterator<T> iter = obserevedElems.iterator();
		StringBuilder sb = new StringBuilder();
		while (iter.hasNext()) {
			try {
				T item = iter.next();
				if (item == null) {
					sb.append("null,");
					continue;
				}
				Method method = item.getClass().getMethod("toString", (Class<?>[]) null);
				String rst = (String) method.invoke(item, (Object[]) null);
				sb.append(rst + ",");
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}
}
