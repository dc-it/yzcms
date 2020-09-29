package com.mapc.yzcms.dao;

import com.mapc.yzcms.entity.SysPermission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


/**
 * 用户权限数据处理
 *
 * @author duchao
 */
public interface SysPermissionRepository extends JpaRepository<SysPermission, Integer> {

	/**
	 * 获取权限
	 *
	 * @param idList 权限id集合
	 * @return
	 */
	List<SysPermission> findByIdIn(List<Integer> idList);
}
