package com.mapc.yzcms.service;

import com.mapc.yzcms.dto.SysUserLoginDto;
import com.mapc.yzcms.dto.SysUserRegisterDto;

/**
 * 系统
 *
 * @author duchao
 */
public interface IAccountService {

	/**
	 * 登陆
	 *
	 * @param sysUserLoginDto 登陆参数
	 * @return token
	 */
	String login(SysUserLoginDto sysUserLoginDto);

	/**
	 * 注册
	 *
	 * @param sysUserRegisterDto 注册参数
	 * @return
	 */
	void register(SysUserRegisterDto sysUserRegisterDto);

	/**
	 * 获取验证码
	 *
	 * @param account 账户
	 *
	 * @return
	 */
	void getCaptcha(String account);
}
