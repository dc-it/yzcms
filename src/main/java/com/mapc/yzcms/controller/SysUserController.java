package com.mapc.yzcms.controller;

import com.mapc.yzcms.common.api.Result;
import com.mapc.yzcms.entity.SysUser;
import com.mapc.yzcms.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sys/users")
public class SysUserController {

    private ISysUserService sysUserService;

    @Autowired
    public SysUserController(ISysUserService sysUserService) {
        this.sysUserService = sysUserService;
    }

    @PutMapping("{id}")
    public Result<Object> updateSysUser(@PathVariable("id") Integer sysUserId, @RequestBody SysUser sysUser){
        sysUser.setId(sysUserId);
        sysUserService.update(sysUserId,sysUser);
        return Result.success();
    }
}
