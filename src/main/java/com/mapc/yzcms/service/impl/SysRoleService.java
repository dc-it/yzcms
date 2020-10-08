package com.mapc.yzcms.service.impl;

import com.mapc.yzcms.common.api.ListOrPage;
import com.mapc.yzcms.dao.SysRoleRepository;
import com.mapc.yzcms.dto.SysRoleDto;
import com.mapc.yzcms.entity.CmsWebsite;
import com.mapc.yzcms.entity.SysRole;
import com.mapc.yzcms.service.ISysRoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 角色
 *
 * @author duchao
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class SysRoleService extends BaseService<SysRole, Integer> implements ISysRoleService {

    private final SysRoleRepository sysRoleRepository;

    @Autowired
    public SysRoleService(SysRoleRepository sysRoleRepository) {
        this.sysRoleRepository = sysRoleRepository;
    }

    /**
     * 获取系统角色列表/分页
     *
     * @param sysRoleDto 查询参数
     * @return
     */
    @Override
    public ListOrPage getSysRoleListOrPage(SysRoleDto sysRoleDto) {
        SysRole sysRole = new SysRole();
        BeanUtils.copyProperties(sysRoleDto, sysRole);
        Pageable pageable = sysRoleDto.getPageNumber() != null ? PageRequest.of(sysRoleDto.getPageNumber(), sysRoleDto.getPageSize()) : null;
        return this.getListOrPage(sysRole, pageable);
    }
}
