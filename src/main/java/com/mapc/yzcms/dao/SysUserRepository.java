package com.mapc.yzcms.dao;

import com.mapc.yzcms.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


/**
 * 用户数据处理
 *
 * @author duchao
 */
public interface SysUserRepository extends JpaRepository<SysUser, Long> {

	/**
	 * 查找用户
	 *
	 * @param username 账号名
	 * @return
	 */
	List<SysUser> findByUsername(String username);

}
