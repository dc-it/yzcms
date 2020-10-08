package com.mapc.yzcms.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.mapc.yzcms.dao.SysPermissionRepository;
import com.mapc.yzcms.dao.SysRolePermissionRelationRepository;
import com.mapc.yzcms.dao.SysUserPermissionRelationRepository;
import com.mapc.yzcms.dao.SysUserRoleRelationRepository;
import com.mapc.yzcms.dto.SysPermissionDto;
import com.mapc.yzcms.entity.SysPermission;
import com.mapc.yzcms.entity.SysRolePermissionRelation;
import com.mapc.yzcms.entity.SysUserPermissionRelation;
import com.mapc.yzcms.entity.SysUserRoleRelation;
import com.mapc.yzcms.service.ISysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 菜单
 *
 * @author duchao
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class SysPermissionService extends BaseService<SysPermission, Integer> implements ISysPermissionService {

	private final SysPermissionRepository sysPermissionRepository;
	private final SysUserRoleRelationRepository sysUserRoleRelationRepository;
	private final SysRolePermissionRelationRepository sysRolePermissionRelationRepository;
	private final SysUserPermissionRelationRepository sysUserPermissionRelationRepository;

	@Autowired
	public SysPermissionService(SysPermissionRepository sysPermissionRepository,
	                            SysUserRoleRelationRepository sysUserRoleRelationRepository,
	                            SysRolePermissionRelationRepository sysRolePermissionRelationRepository,
	                            SysUserPermissionRelationRepository sysUserPermissionRelationRepository) {
		this.sysPermissionRepository = sysPermissionRepository;
		this.sysUserRoleRelationRepository = sysUserRoleRelationRepository;
		this.sysRolePermissionRelationRepository = sysRolePermissionRelationRepository;
		this.sysUserPermissionRelationRepository = sysUserPermissionRelationRepository;
	}

	/**
	 * 获取用户权限
	 *
	 * @param sysUserId 用户id
	 * @return
	 */
	@Override
	public List<SysPermission> getSysPermissionList(Integer sysUserId) {

		List<SysPermission> sysPermissionList=null;
		List<Integer> ownPermissionIdList=new ArrayList<>();

		//获取用户角色对应的权限
		List<SysUserRoleRelation> sysUserRoleRelationList = sysUserRoleRelationRepository.findBySysUserId(sysUserId);
		if(CollectionUtil.isNotEmpty(sysUserRoleRelationList)){
			List<Integer> roleIdList = sysUserRoleRelationList.stream().map(SysUserRoleRelation::getSysRoleId).collect(Collectors.toList());
			List<SysRolePermissionRelation> sysRolePermissionRelationList = sysRolePermissionRelationRepository.findBySysRoleIdIn(roleIdList);
			if(CollectionUtil.isNotEmpty(sysRolePermissionRelationList)) {
				ownPermissionIdList.addAll(sysRolePermissionRelationList.stream().map(SysRolePermissionRelation::getSysPermissionId).collect(Collectors.toList()));
			}
		}

		//获取用户权限
		List<SysUserPermissionRelation> sysUserPermissionRelationList = sysUserPermissionRelationRepository.findBySysUserId(sysUserId);
		if(CollectionUtil.isNotEmpty(sysUserPermissionRelationList)){
			ownPermissionIdList.addAll(sysUserPermissionRelationList.stream().filter(relation -> relation.getOwn()).map(SysUserPermissionRelation::getSysPermissionId).collect(Collectors.toList()));
			List<Integer> noOwnPermissionIdList = sysUserPermissionRelationList.stream().filter(relation -> !relation.getOwn()).map(SysUserPermissionRelation::getSysPermissionId).collect(Collectors.toList());

			//过滤掉一些权限
			if(CollectionUtil.isNotEmpty(ownPermissionIdList) && CollectionUtil.isNotEmpty(noOwnPermissionIdList)){
				ownPermissionIdList=ownPermissionIdList.stream().filter(permissionId->Objects.nonNull(permissionId) && !noOwnPermissionIdList.contains(permissionId)).collect(Collectors.toList());
			}
		}

		if(CollectionUtil.isNotEmpty(ownPermissionIdList)) {
			sysPermissionList = sysPermissionRepository.findByIdIn(ownPermissionIdList);
		}

		return sysPermissionList;
	}

	/**
	 * 获取系统权限树
	 *
	 * @return
	 */
	@Override
	public List<SysPermissionDto> getSysPermissionTree() {
		return null;
	}
}
