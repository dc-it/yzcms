package com.mapc.yzcms.controller;

import com.mapc.yzcms.common.api.Result;
import com.mapc.yzcms.entity.SysSettings;
import com.mapc.yzcms.service.ISysSettingsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "SYS-系统设置")
@RestController
@RequestMapping("/sys/settings")
public class SysSettingsController {

    private final ISysSettingsService sysSettingsService;

    @Autowired
    public SysSettingsController(ISysSettingsService sysSettingsService) {
        this.sysSettingsService = sysSettingsService;
    }

    @ApiOperation(value = "获取系统设置")
    @GetMapping
    public Result<SysSettings> getSysSettings(){
         return Result.success(sysSettingsService.getSysSettings());
    }

}
