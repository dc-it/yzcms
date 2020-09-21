package com.mapc.yzcms.service;

import com.mapc.yzcms.dto.SysUserLoginDto;

/**
 * todo(描述)
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
