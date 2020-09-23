package com.mapc.yzcms.dao;

import com.mapc.yzcms.entity.SysRolePermissionRelation;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * 角色权限数据处理
 *
 * @author duchao
 */
public interface SysRolePermissionRelationRepository extends JpaRepository<SysRolePermissionRelation, Integer> {


}
