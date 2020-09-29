package com.mapc.yzcms.dao;

import com.mapc.yzcms.entity.SysUserRoleRelation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


/**
 * 用户角色
 *
 * @author duchao
 */
public interface SysUserRoleRelationRepository extends JpaRepository<SysUserRoleRelation, Integer> {

	/**
	 * 查询用户角色关联
	 *
	 * @param sysUserId 系统用户id
	 * @return
	 */
	List<SysUserRoleRelation> findBySysUserId(Integer sysUserId);
}
