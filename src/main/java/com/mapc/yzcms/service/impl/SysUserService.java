package com.mapc.yzcms.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.collection.CollectionUtil;
import com.mapc.yzcms.common.util.AssertUtil;
import com.mapc.yzcms.common.util.DataUtil;
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
public class SysUserService extends BaseService<SysUser, Integer> implements ISysUserService {

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
		AssertUtil.notBlank(account, "账户不能为空");
		List<SysUser> sysUserList = sysUserRepository.findByUsernameOrPhoneOrEmail(account,account,account);
		return CollectionUtil.isNotEmpty(sysUserList)?sysUserList.get(0):null;
	}

	/**
	 * 更新账户登陆时间
	 *
	 * @param sysUserId      用户id
	 * @param sysUserAccount 用户账户
	 */
	@Override
	public void updateLoginTimeByIdOrAccount(Integer sysUserId, String sysUserAccount) {
		sysUserRepository.updateLoginTimeByIdOrAccount(sysUserId,sysUserAccount);
	}

	/**
	 * 通过账户更新系统用户信息
	 *
	 * @param account 账户
	 * @param sysUser 系统用户
	 */
	@Override
	public void updateByAccount(String account, SysUser sysUser) {
		SysUser dbSysUser = this.getSysUser(account);
		DataUtil.converterBlank2Null(sysUser,SysUser.class);
		BeanUtil.copyProperties(sysUser,dbSysUser,new CopyOptions(){{
			setIgnoreNullValue(true);
		}});
		this.update(dbSysUser.getId(),dbSysUser);
	}
}
