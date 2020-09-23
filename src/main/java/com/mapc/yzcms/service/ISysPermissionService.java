package com.mapc.yzcms.service;

import com.mapc.yzcms.entity.SysPermission;

import java.util.List;

/**
 * 接口
 *
 * @author duchao
 */
public interface ISysPermissionService extends IBaseService<SysPermission, Long> {

	/**
	 * 获取用户权限
	 *
	 * @param sysUserId 用户id
	 * @return
	 */
	List<SysPermission> getSysPermissionList(Integer sysUserId);
}
