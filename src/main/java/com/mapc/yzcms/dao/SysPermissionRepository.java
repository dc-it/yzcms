package com.mapc.yzcms.dao;

import com.mapc.yzcms.entity.SysPermission;
import com.mapc.yzcms.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


/**
 * 用户权限数据处理
 *
 * @author duchao
 */
public interface SysPermissionRepository extends JpaRepository<SysPermission, Integer> {


}
