package com.mapc.yzcms.common.constant;

/**
 * redis常量：缓存key、配置时间
 *
 * @author duchao
 */
public interface RedisConstant {

	/**
	 * 账户注册
	 * key+account账户
	 */
	String ACCOUNT_REGISTER="yzcms:account:register:";

	/**
	 * 账户注册验证码过期时间（秒）
	 */
	long ACCOUNT_REGISTER_CAPTCHA_EXPIRE_TIME=1800;
}
