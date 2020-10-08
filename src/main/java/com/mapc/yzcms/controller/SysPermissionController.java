package com.mapc.yzcms.controller;

import com.mapc.yzcms.common.api.Result;
import com.mapc.yzcms.dto.SysPermissionDto;
import com.mapc.yzcms.service.ISysPermissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "SYS-系统权限")
@RestController
@RequestMapping("/sys/permissions")
public class SysPermissionController {

    private final ISysPermissionService sysPermissionService;

    @Autowired
    public SysPermissionController(ISysPermissionService sysPermissionService) {
        this.sysPermissionService = sysPermissionService;
    }

    @ApiOperation(value = "系统权限")
    @GetMapping
    public Result<List<SysPermissionDto>> getSysPermissionTree() {
        return Result.success(sysPermissionService.getSysPermissionTree());
    }


}
