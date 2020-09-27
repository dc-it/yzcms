package com.mapc.yzcms.controller;

import com.mapc.yzcms.common.api.Result;
import com.mapc.yzcms.dto.SysUserLoginDto;
import com.mapc.yzcms.service.ISysUserService;
import com.mapc.yzcms.service.ISystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 系统控制器
 *
 * @author duchao
 */
@RestController
@RequestMapping("/system")
public class SystemController {

	private final ISystemService systemService;

	@Autowired
	public SystemController(ISystemService systemService) {
		this.systemService = systemService;
	}

	@PostMapping("/login")
	public Result<Object> login(@Validated @RequestBody SysUserLoginDto sysUserLoginDto) {
		String token = systemService.login(sysUserLoginDto);
		return Result.success(token);
	}

	@PostMapping("/register")
	public Result<Object> register(@Validated @RequestBody SysUserLoginDto sysUserLoginDto) {

		return Result.success();
	}
}
