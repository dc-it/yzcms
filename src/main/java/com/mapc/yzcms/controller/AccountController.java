package com.mapc.yzcms.controller;

import com.mapc.yzcms.common.api.Result;
import com.mapc.yzcms.dto.SysUserLoginDto;
import com.mapc.yzcms.dto.SysUserPasswordDto;
import com.mapc.yzcms.dto.SysUserRegisterDto;
import com.mapc.yzcms.service.IAccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

/**
 * 系统控制器
 *
 * @author duchao
 */
@Validated
@Api(tags = "系统账户")
@RestController
@RequestMapping("/account")
public class AccountController {

	@Value("${jwt.tokenHeader}")
	private String tokenHeader;
	@Value("${jwt.tokenHead}")
	private String tokenHead;
	private final IAccountService accountService;

	@Autowired
	public AccountController(IAccountService accountService) {
		this.accountService = accountService;
	}

	@ApiOperation("登录")
	@PostMapping("/login")
	public Result<String> login(@Validated @RequestBody SysUserLoginDto sysUserLoginDto,HttpServletResponse response) {
		String token = accountService.login(sysUserLoginDto);
		response.setHeader(this.tokenHeader, this.tokenHead + " " + token);
		return Result.success();
	}

	@ApiOperation("注册")
	@PostMapping("/register")
	public Result<Object> register(@Validated @RequestBody SysUserRegisterDto sysUserRegisterDto) {
		accountService.register(sysUserRegisterDto);
		return Result.success();
	}

	@ApiOperation("获取验证码")
	@ApiImplicitParam(name = "account",value = "账户",required = true)
	@GetMapping("/captcha")
	public Result<Object> getCaptcha(@NotBlank(message = "账户不能为空") String account) {
		accountService.getCaptcha(account);
		return Result.success();
	}

	@ApiOperation("修改密码")
	@PutMapping("/password")
	public Result<Object> updateAccountPassword(@Validated @RequestBody SysUserPasswordDto sysUserPasswordDto) {
		accountService.updatePassword(sysUserPasswordDto);
		return Result.success();
	}
}
