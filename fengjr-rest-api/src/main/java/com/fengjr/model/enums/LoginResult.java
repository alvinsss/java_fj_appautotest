package com.fengjr.model.enums;

public enum LoginResult implements BaseEnum {

	SUCCESSFUL("登录名密码验证正确,登录成功"), NEED_CHANGE_PASSWORD("登录成功,需要修改密码"), FAILED(
			"账号不存在或密码错误"),
	/**
	 * 需要返回具体的User/Employee，用于前端控制
	 */
	TOO_MANY_ATTEMPT("登陆失败次数过多，暂停使用"),
	/**
	 * 用户因被禁用而不能登录
	 */
	USER_DISABLED("您的账号已被锁定，请联系网站客服！"),
	/**
	 * 员工因被禁用而不能登录
	 */
	EMPLOYEE_DISABLED("员工禁用，请联系管理员");

	private final String key;

	private LoginResult(String key) {
		this.key = key;
	}

	@Override
	public String getKey() {
		return key;
	}
}
