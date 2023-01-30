package com.fengjr.model;

import java.io.Serializable;

public class CareerInfo implements Serializable {

	private static final long serialVersionUID = -1648150883914103556L;
	// 雇佣关系（雇员：EMPLOYEE）
	public String careerStatus;
	// 工作省份
	public String province;
	// 工作城市
	public String city;
	// 职位
	public String position;
	// 月收入(SALARY_ABOVE_50001表示五万以上，以此判断)
	public String salary;
	// 工作时间（YEAR_10_20代表工作10到20年）
	public String yearOfService;
	// 工作邮箱
	public String workMail;
	
	public CompanyInfo company;
}
