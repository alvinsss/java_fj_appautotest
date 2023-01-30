package com.fengjr.mobile.factory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.reflections.Reflections;
import org.reflections.scanners.ResourcesScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;

import com.fengjr.mobile.base.Page;
import com.fengjr.mobile.base.PageContext;
import com.fengjr.mobile.page.UnknowPage;
import com.fengjr.mobile.setting.Configurator;
import com.fengjr.mobile.utils.UiObject;

public abstract class PageFactory {

	/**
	 * 创建页对象
	 * 
	 * @param clazz
	 * @return
	 */
	public static Page createPage(Class<?> clazz) {

		Constructor<?> ctor;

		try {

			String clazzName = clazz.getName();
			String[] nameSplit = clazzName.split("\\.");

			if (nameSplit.length > 0) {
				String lastSplit = nameSplit[nameSplit.length - 1];
				
				if (type().equals(Platform.ANDROID)) {
					if (!lastSplit.startsWith("Ad"))
						clazzName = clazzName.replace(lastSplit, "ad.Ad" + lastSplit);
				} else if (type().equals(Platform.MAC)) {
					if (!lastSplit.startsWith("Os"))
						clazzName = clazzName.replace(lastSplit, "os.Os" + lastSplit);
				} else {
					throw new RuntimeException("unsupport platform: " + type());
				}
				clazz = Class.forName(clazzName);

				ctor = clazz.getConstructor();
				Page pageObj = (Page) ctor.newInstance();

				return pageObj;
			}

		} catch (NoSuchMethodException e) {
			//e.printStackTrace();
		} catch (SecurityException e) {
			//e.printStackTrace();
		} catch (InstantiationException e) {
			//e.printStackTrace();
		} catch (IllegalAccessException e) {
			//e.printStackTrace();
		} catch (IllegalArgumentException e) {
			//e.printStackTrace();
		} catch (InvocationTargetException e) {
			//e.printStackTrace();
		} catch (ClassNotFoundException e) {
			//e.printStackTrace();
		}

		return null;
	}

	/**
	 * 获取当前平台类型
	 * 
	 * @return
	 */
	public static Platform type() {

		String platform = Configurator.instance().getParamters()
				.get(Configurator.PLATFORM_NAME);
		if ("android".equalsIgnoreCase(platform)) {
			return Platform.ANDROID;
		} else if ("ios".equalsIgnoreCase(platform)) {
			return Platform.MAC;
		} else {
			throw new RuntimeException("unsupport platform: " + platform);
		}
	}

	/**
	 * 给定界面是否出现
	 * 
	 * @param clazz
	 * @return
	 */
	public static boolean isLoaded(Class<?> clazz) {
		Page pageObj = createPage(clazz);
		if (pageObj != null) {
			By[] id = pageObj.getIdentification();
			if (id == null) return false;
			for (By by : id) {
 				if (!UiObject.searchFor(by))
					return false;
			}
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 获取页对象的指纹
	 * 
	 * @param clazz
	 * @return
	 */
	public static String getPageFingerprint(Class<?> clazz) {

		Page pageObj = createPage(clazz);
		if (pageObj != null) {
			By[] id = pageObj.getIdentification();
			StringBuilder builder = new StringBuilder();
			for (By by : id) {
				builder.append(by.toString());
			}
			return DigestUtils.md5Hex(builder.toString());
		} else {
			return null;
		}
	}

	/**
	 * 获取当前界面信息
	 * 
	 * @return
	 */
	public static Page getCurrentPage(Class<?> intent) {
		
		if (intent != null && isLoaded(intent)) return createPage(intent);

		String packagename = "com.fengjr.mobile.page";

		if (type().equals(Platform.ANDROID)) {
			packagename = "com.fengjr.mobile.page.ad";
		} else if (type().equals(Platform.MAC)) {
			packagename = "com.fengjr.mobile.page.os";
		} else {
			throw new RuntimeException("unsupport platform: " + type());
		}

		List<ClassLoader> classLoadersList = new LinkedList<ClassLoader>();
		classLoadersList.add(ClasspathHelper.contextClassLoader());
		classLoadersList.add(ClasspathHelper.staticClassLoader());

		Reflections reflections = new Reflections(
				new ConfigurationBuilder().setScanners(new SubTypesScanner(false),
				new ResourcesScanner()).setUrls(ClasspathHelper.forPackage(packagename))
				.filterInputsBy(new FilterBuilder().includePackage(packagename)));
		
		Set<Class<? extends Object>> allClasses = reflections.getSubTypesOf(Object.class);

		Logger.getRootLogger().info(allClasses.size() +  " class has been found.");
		for (Class<? extends Object> clazz : allClasses) {
			Logger.getRootLogger().info("check the current page is " + clazz.getName() + " or not.");
			if (clazz.getName().contains("UnknowPage")) continue;
			if (isLoaded(clazz)) {
				Logger.getRootLogger().info("The current page is " + clazz.getName());
				return createPage(clazz);
			} else {
				Logger.getRootLogger().info("The current page is not " + clazz.getName());
			}
		}

		return createPage(UnknowPage.class);
	}

	public static void updateContext(PageContext pageContext, Class<?> intent) {
		pageContext.setCurrentPage(getCurrentPage(intent));
	}

}
