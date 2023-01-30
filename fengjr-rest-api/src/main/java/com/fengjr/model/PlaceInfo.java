package com.fengjr.model;

import java.io.Serializable;

public class PlaceInfo implements Serializable{

	private static final long serialVersionUID = 2246197443562427898L;
	//户籍省份
	public String nativeProvince;
//	户籍城市
	public String nativeCity;
	//户口省份
	public String hukouProvince;
	//户口所在城市
	public String hukouCity;
	//当前居住地址
	public String currentAddress;
	//先用电话号码
	public String currentPhone;
}
