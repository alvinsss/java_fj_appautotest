package com.fengjr.model;

import java.io.Serializable;

public class PersonInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5060837359537199052L;
	//性别（女：false 男：true）
	public boolean male;
	//出生日期
	public long dateOfBirth;
	//有无子女（有：true 无：true）
	public boolean children;
	//婚姻状况（已婚：MARRIED 未婚：？）
	public String maritalStatus;
	//教育信息
	public EducationInfo education;
	//所在地信息
	public PlaceInfo place;
	//个人头像图片名称
	public String avatar;
	//民族
	public String ethnic;
	
	
}
