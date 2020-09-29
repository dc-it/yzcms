package com.mapc.yzcms.dao;

import com.mapc.yzcms.entity.SysRolePermissionRelation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


/**
 * 角色权限数据处理
 *
 * @author duchao
 */
public interface SysRolePermissionRelationRepository extends JpaRepository<SysRolePermissionRelation, Integer> {

	/**
	 * 获取角色权限关联
	 *
	 * @param sysRoleIdList 角色id集合
	 * @return
	 */
	List<SysRolePermissionRelation> findBySysRoleIdIn(List<Integer> sysRoleIdList);
}
