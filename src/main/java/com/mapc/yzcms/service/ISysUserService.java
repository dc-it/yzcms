package com.mapc.yzcms.service;

import com.mapc.yzcms.entity.SysUser;

/**
 * 接口
 *
 * @author duchao
 */
public interface ISysUserService extends IBaseService<SysUser, Integer> {

	/**
	 * 查找用户
	 *
	 * @param account 账号名
	 * @return
	 */
	SysUser getSysUser(String account);
}
