package com.mapc.yzcms.dao;

import com.mapc.yzcms.entity.SysUserPermissionRelation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


/**
 * 用户权限数据处理
 *
 * @author duchao
 */
public interface SysUserPermissionRelationRepository extends JpaRepository<SysUserPermissionRelation, Integer> {

	/**
	 * 获取用户权限
	 *
	 * @param sysUserId 用户id
	 * @return
	 */
	List<SysUserPermissionRelation> findBySysUserId(Integer sysUserId);

}
