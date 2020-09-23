package com.mapc.yzcms.dao;

import com.mapc.yzcms.entity.SysUserPermissionRelation;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * 用户权限数据处理
 *
 * @author duchao
 */
public interface SysUserPermissionRelationRepository extends JpaRepository<SysUserPermissionRelation, Integer> {


}
