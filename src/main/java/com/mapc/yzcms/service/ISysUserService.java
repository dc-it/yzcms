package com.mapc.yzcms.service;

import com.mapc.yzcms.entity.SysUser;

/**
 * 接口
 *
 * @author duchao
 */
public interface ISysUserService extends IBaseService<SysUser, Long> {

	/**
	 * 查找用户
	 *
	 * @param username 账号名
	 * @return
	 */
	SysUser getSysUser(String username);
}
