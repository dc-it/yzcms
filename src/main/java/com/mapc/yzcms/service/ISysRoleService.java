package com.mapc.yzcms.service;

import com.mapc.yzcms.common.api.ListOrPage;
import com.mapc.yzcms.dto.SysRoleDto;
import com.mapc.yzcms.entity.SysRole;

/**
 * 接口
 *
 * @author duchao
 */
public interface ISysRoleService extends IBaseService<SysRole, Integer> {

	/**
	 * 获取系统角色列表/分页
	 *
	 * @param sysRoleDto 查询参数
	 * @return
	 */
	ListOrPage getSysRoleListOrPage(SysRoleDto sysRoleDto);

	/**
	 * 添加系统角色
	 *
	 * @param sysRoleDto
	 */
	void addSysRole(SysRoleDto sysRoleDto);
}
