package com.mapc.yzcms.service.impl;

import com.mapc.yzcms.common.api.ListOrPage;
import com.mapc.yzcms.dao.SysRoleRepository;
import com.mapc.yzcms.dto.SysPermissionDto;
import com.mapc.yzcms.dto.SysRoleDto;
import com.mapc.yzcms.entity.SysRole;
import com.mapc.yzcms.entity.SysRolePermissionRelation;
import com.mapc.yzcms.service.ISysRolePermissionRelationService;
import com.mapc.yzcms.service.ISysRoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 角色
 *
 * @author duchao
 */
@Service
public class SysRoleService extends BaseService<SysRole, Integer> implements ISysRoleService {

	private final SysRoleRepository sysRoleRepository;
	private final ISysRolePermissionRelationService sysRolePermissionRelationService;

	@Autowired
	public SysRoleService(SysRoleRepository sysRoleRepository,
	                      ISysRolePermissionRelationService sysRolePermissionRelationService) {
		this.sysRoleRepository = sysRoleRepository;
		this.sysRolePermissionRelationService = sysRolePermissionRelationService;
	}

	/**
	 * 获取系统角色列表/分页
	 *
	 * @param sysRoleDto 查询参数
	 * @return
	 */
	@Override
	public ListOrPage getSysRoleListOrPage(SysRoleDto sysRoleDto) {
		SysRole sysRole = new SysRole();
		BeanUtils.copyProperties(sysRoleDto, sysRole);
		Pageable pageable = sysRoleDto.getPageNumber() != null ? PageRequest.of(sysRoleDto.getPageNumber(), sysRoleDto.getPageSize()) : null;
		return this.getListOrPage(sysRole, pageable);
	}

	/**
	 * 添加系统角色
	 *
	 * @param sysRoleDto 系统角色
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public void addSysRole(SysRoleDto sysRoleDto) {

		//添加角色
		SysRole sysRole = new SysRole();
		BeanUtils.copyProperties(sysRoleDto, sysRole);
		this.add(sysRole);

		//关联权限
		List<SysPermissionDto> sysPermissionList = sysRoleDto.getSysPermissionList();
		List<SysRolePermissionRelation> sysRolePermissionRelationList = sysPermissionList.stream()
				.map(sysPermissionDto -> SysRolePermissionRelation.builder().sysRoleId(sysRole.getId()).sysPermissionId(sysPermissionDto.getId()).build())
				.collect(Collectors.toList());
		sysRolePermissionRelationService.batchAdd(sysRolePermissionRelationList);
	}
}
