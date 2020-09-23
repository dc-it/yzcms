package com.mapc.yzcms.dao;

import com.mapc.yzcms.entity.SysUserRoleRelation;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * 用户角色
 *
 * @author duchao
 */
public interface SysUserRoleRelationRepository extends JpaRepository<SysUserRoleRelation, Integer> {

}
