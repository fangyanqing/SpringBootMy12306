package com.neuedu.catshop.util;

/**
 * @author netboy
 * @explain 常量类
 */
public class Const {

	public static final String SUCCESS = "SUCCESS";
	public static final String ERROR = "ERROR";
	public static final String FIALL = "FIALL";

	/********************** 对象和个体 ****************************/
	/**
	 * 登陆用户对象
	 */
	public static final String SESSION_USER = "SESSION_USER";
	/**
	 * 登录页验证码
	 */
	public static final String SESSION_SECURITY_CODE = "SESSION_SECURITY_CODE";
	/**
	 * 登陆失败尝试次数
	 */
	public static final String LOGIN_FAIL_COUNT = "LOGIN_FAIL_COUNT";
	/**
	 * 错误提示信息
	 */
	public static final String ERROR_MSG = "ERROR_MSG";

	// 不验证URL anon：不验证/authc：受控制的
	public static final String NO_INTERCEPTOR_PATH = ".*/((.css)|(.js)|(images)|(error)|(jquery-easyui-1.8.8)|(login)|(logout)|(anon)).*";
}
