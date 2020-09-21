package com.mapc.yzcms.service.impl;

import com.mapc.yzcms.dao.SysUserRepository;
import com.mapc.yzcms.entity.SysUser;
import com.mapc.yzcms.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

/**
 * 菜单
 *
 * @author duchao
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class SysUserService extends BaseService<SysUser, Long> implements ISysUserService {

	private final SysUserRepository sysUserRepository;

	@Autowired
	public SysUserService(SysUserRepository sysUserRepository) {
		this.sysUserRepository = sysUserRepository;
	}

	/**
	 * 查找用户
	 *
	 * @param account 账号名
	 * @return
	 */
	@Override
	public SysUser getSysUser(String account) {
		Assert.notNull(account, "账户不能为空");
		List<SysUser> sysUserList = sysUserRepository.findByUsernameOrPhoneOrEmail(account,account,account);
		Assert.notEmpty(sysUserList, "账户不存在");
		return sysUserList.get(0);
	}
}
