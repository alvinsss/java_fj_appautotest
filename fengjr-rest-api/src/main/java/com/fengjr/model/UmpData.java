package com.fengjr.model;

import org.springframework.util.LinkedMultiValueMap;


public class UmpData {
	public String mer_date;
	public String partic_account_id;
	public String sign_type;
	public String notify_url;
	public String charset;
	public String order_id;
	public String version;
	public String amount;
	public String sign;
	public String partic_type;
	public String serv_type;
	public String partic_user_id;
	public String mer_id;
	public String partic_acc_type;
	public String project_id;
	public String service;
	public String project_account_id;
	public String trans_action;
	public String res_format;
	public String ret_url;

	public LinkedMultiValueMap<String, String> toMap() {
		LinkedMultiValueMap<String, String> request = new LinkedMultiValueMap<String, String>();
		request.add("mer_date", mer_date);
		request.add("partic_account_id", partic_account_id);
		request.add("sign_type", sign_type);
		request.add("notify_url", notify_url);
		request.add("charset", charset);
		request.add("order_id", order_id);
		request.add("version", version);
		request.add("amount", amount);

		request.add("sign", sign);
		request.add("partic_type", partic_type);
		request.add("serv_type", serv_type);
		request.add("partic_user_id", partic_user_id);
		request.add("partic_acc_type", partic_acc_type);
		request.add("project_id", project_id);
		request.add("service", service);

		request.add("project_account_id", project_account_id);
		request.add("trans_action", trans_action);
		request.add("res_format", res_format);
		request.add("ret_url", ret_url);

		return request;
	}
}
