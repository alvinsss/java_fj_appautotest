package com.fengjr.model;

import java.io.Serializable;

public class CompanyInfo implements Serializable {

	private static final long serialVersionUID = 2662705357745955462L;
	// 公司名称
	public String name;
	// 企业类型（EDUCATION_RESEARCH_INSTITUTION表示教育。。。）
	public String type;

	// 所属行业（金融：FINANCE_LAW）
	public String industry;

	// 公司电话
	public String phone;
	// 公司地址
	public String address;
	// 公司规模（SIZE_101_500表示101到500人）
	public String size;
	// 所属行业（中文显示）
	public String industryName;
}
