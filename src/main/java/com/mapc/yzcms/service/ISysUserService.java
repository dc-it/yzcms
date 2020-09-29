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

	/**
	 * 更新账户登陆时间
	 *
	 * @param sysUserId      用户id
	 * @param sysUserAccount 用户账户
	 */
	void updateLoginTimeByIdOrAccount(Integer sysUserId, String sysUserAccount);
}
