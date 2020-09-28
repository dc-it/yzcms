package com.mapc.yzcms.controller;

import com.mapc.yzcms.common.api.Result;
import com.mapc.yzcms.dto.SysUserLoginDto;
import com.mapc.yzcms.dto.SysUserRegisterDto;
import com.mapc.yzcms.service.IAccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;

/**
 * 系统控制器
 *
 * @author duchao
 */
@Api(tags = "系统账户")
@RestController
@RequestMapping("/account")
public class AccountController {

	private final IAccountService accountService;

	@Autowired
	public AccountController(IAccountService accountService) {
		this.accountService = accountService;
	}

	@ApiOperation("登录")
	@PostMapping("/login")
	public Result<Object> login(@Validated @RequestBody SysUserLoginDto sysUserLoginDto) {
		String token = accountService.login(sysUserLoginDto);
		return Result.success(token);
	}

	@ApiOperation("注册")
	@PostMapping("/register")
	public Result<Object> register(@Validated @RequestBody SysUserRegisterDto sysUserRegisterDto) {
		accountService.register(sysUserRegisterDto);
		return Result.success();
	}

	@ApiOperation("获取验证码")
	@ApiImplicitParam(name = "account",value = "验证码",required = true)
	@GetMapping("/captcha")
	public Result<Object> getCaptcha(@NotBlank(message = "账户不能为空") String account) {
		accountService.getCaptcha(account);
		return Result.success();
	}
}
