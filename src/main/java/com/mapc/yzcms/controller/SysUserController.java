package com.mapc.yzcms.controller;

import com.mapc.yzcms.common.api.ListOrPage;
import com.mapc.yzcms.common.api.Result;
import com.mapc.yzcms.dto.CmsWebsiteDto;
import com.mapc.yzcms.dto.SysPermissionDto;
import com.mapc.yzcms.dto.SysUserDto;
import com.mapc.yzcms.entity.SysUser;
import com.mapc.yzcms.service.ISysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "SYS-系统用户")
@RestController
@RequestMapping("/sys/users")
public class SysUserController {

    private ISysUserService sysUserService;

    @Autowired
    public SysUserController(ISysUserService sysUserService) {
        this.sysUserService = sysUserService;
    }

    @ApiOperation("获取用户列表/分页")
    @GetMapping
    public Result<ListOrPage> getSysUserListOrPage(SysUserDto sysUserDto) {
        return Result.success(sysUserService.getSysUserListOrPage(sysUserDto));
    }

    @ApiOperation("更新用户")
    @PutMapping("{id}")
    public Result<Object> updateSysUser(@PathVariable("id") Integer sysUserId, @RequestBody SysUser sysUser) {
        sysUser.setId(sysUserId);
        sysUserService.update(sysUserId, sysUser);
        return Result.success();
    }

    @ApiOperation(value = "获取用户权限")
    @GetMapping("{id}/permissions")
    public Result<List<SysPermissionDto>> getSysUserPermissionTree(@PathVariable("id") Integer sysUserId) {
        return Result.success();
    }
}
