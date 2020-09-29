package com.mapc.yzcms.dao;

import com.mapc.yzcms.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


/**
 * 用户数据处理
 *
 * @author duchao
 */
public interface SysUserRepository extends JpaRepository<SysUser, Integer> {

	/**
	 * 查找用户
	 *
	 * @param username 账号名
	 * @param phone    手机号
	 * @param email    邮箱
	 * @return
	 */
	List<SysUser> findByUsernameOrPhoneOrEmail(String username, String phone, String email);

	/**
	 * 通过账户更新系统用户
	 *
	 * @param id      用户id
	 * @param account username、email、phone
	 */
	@Modifying
	@Query(value = "update sys_user u set u.login_time=now() where  u.id=:id or u.username=:account or u.email=:account or u.phone=:account", nativeQuery = true)
	void updateLoginTimeByIdOrAccount(@Param("id") Integer id, @Param("account") String account);
}
