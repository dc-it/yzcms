package com.mapc.yzcms.service;

import com.mapc.yzcms.dto.SysUserLoginDto;

/**
 * 系统
 *
 * @author duchao
 */
public interface ISystemService {

	/**
	 * 系统
	 *
	 * @param sysUserLoginDto 登陆参数
	 * @return token
	 */
	String login(SysUserLoginDto sysUserLoginDto);
}
