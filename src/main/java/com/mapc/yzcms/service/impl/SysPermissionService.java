package com.mapc.yzcms.service.impl;

import com.mapc.yzcms.dao.SysPermissionRepository;
import com.mapc.yzcms.entity.SysPermission;
import com.mapc.yzcms.service.ISysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 菜单
 *
 * @author duchao
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class SysPermissionService extends BaseService<SysPermission, Long> implements ISysPermissionService {

	private final SysPermissionRepository sysPermissionRepository;

	@Autowired
	public SysPermissionService(SysPermissionRepository sysPermissionRepository) {
		this.sysPermissionRepository = sysPermissionRepository;
	}

	/**
	 * 获取用户权限
	 *
	 * @param sysUserId 用户id
	 * @return
	 */
	@Override
	public List<SysPermission> getSysPermissionList(Long sysUserId) {
		return null;
	}
}
