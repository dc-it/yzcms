package com.mapc.yzcms.service;

import com.mapc.yzcms.common.api.ListOrPage;
import com.mapc.yzcms.dto.SysUserDto;
import com.mapc.yzcms.entity.SysUser;

/**
 * 接口
 *
 * @author duchao
 */
public interface ISysUserService extends IBaseService<SysUser, Integer> {

    /**
     * 查找用户
     *
     * @param account 账号名
     * @return
     */
    SysUser getSysUser(String account);

    /**
     * 更新账户登陆时间
     *
     * @param sysUserId      用户id
     * @param sysUserAccount 用户账户
     */
    void updateLoginTimeByIdOrAccount(Integer sysUserId, String sysUserAccount);

    /**
     * 通过账户更新系统用户信息
     *
     * @param account 账户
     * @param sysUser 系统用户
     */
    void updateByAccount(String account, SysUser sysUser);

    /**
     * 获取用户列表/分页
     *
     * @param sysUserDto 查询参数
     * @return
     */
    ListOrPage getSysUserListOrPage(SysUserDto sysUserDto);
}
