package com.fengjr.model.enums;

/**
 * 
 * @author gaoge
 * 在众筹详细信息页面，点击图片要根据众筹项目网址信息显示不同的页面，该类是网址信息第一个页面的枚举类，
 * 网址信息格式如：
 * http://beta.fengjr.com/loan/rt/1
 *
 */
public enum ProjectFirstPathSegmentType implements BaseEnum {
	LOAN("loan"),
	INVESTMENT("investment"),
	SPECIALTOPIC("specialTopic");
	
	String key;
	private ProjectFirstPathSegmentType(String key){
		this.key = key;
	}
	
	@Override
	public String getKey() {
		return key;
	}
}
