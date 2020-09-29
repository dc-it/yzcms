package com.mapc.yzcms.service.impl;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;
import com.mapc.yzcms.common.constant.RedisConstant;
import com.mapc.yzcms.common.exception.BaseException;
import com.mapc.yzcms.common.util.*;
import com.mapc.yzcms.dto.SysUserDetails;
import com.mapc.yzcms.dto.SysUserLoginDto;
import com.mapc.yzcms.dto.SysUserPasswordDto;
import com.mapc.yzcms.dto.SysUserRegisterDto;
import com.mapc.yzcms.entity.SysUser;
import com.mapc.yzcms.service.IAccountService;
import com.mapc.yzcms.service.ISysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 系统业务逻辑
 *
 * @author duchao
 */
@Slf4j
@Service
public class AccountService implements IAccountService {

	private final UserDetailsService userDetailsService;
	private final PasswordEncoder passwordEncoder;
	private final JwtTokenUtil jwtTokenUtil;
	private final RedisUtil redisUtil;
	private final MailUtil mailUtil;
	private final ISysUserService sysUserService;

	@Autowired
	public AccountService(UserDetailsService userDetailsService,
	                      PasswordEncoder passwordEncoder,
	                      JwtTokenUtil jwtTokenUtil,
	                      RedisUtil redisUtil,
	                      MailUtil mailUtil,
	                      ISysUserService sysUserService) {
		this.userDetailsService = userDetailsService;
		this.passwordEncoder = passwordEncoder;
		this.jwtTokenUtil = jwtTokenUtil;
		this.redisUtil = redisUtil;
		this.mailUtil = mailUtil;
		this.sysUserService = sysUserService;
	}

	/**
	 * 系统
	 *
	 * @param sysUserLoginDto 登陆参数
	 * @return token
	 */
	@Override
	public String login(SysUserLoginDto sysUserLoginDto) {
		String sysUserAccount=sysUserLoginDto.getAccount();
		UserDetails userDetails = userDetailsService.loadUserByUsername(sysUserAccount);
		if (!passwordEncoder.matches(sysUserLoginDto.getPassword(), userDetails.getPassword())) {
			throw new BadCredentialsException("密码不正确");
		}

		//更新登陆时间
		sysUserService.updateLoginTimeByIdOrAccount(null,sysUserAccount);

		return jwtTokenUtil.generateToken(sysUserAccount);
	}

	/**
	 * 注册
	 *
	 * @param sysUserRegisterDto 注册参数
	 * @return
	 */
	@Override
	public void register(SysUserRegisterDto sysUserRegisterDto) {
		String account = sysUserRegisterDto.getAccount();
		String password = sysUserRegisterDto.getPassword();
		String captcha = sysUserRegisterDto.getCaptcha();
		AssertUtil.isTrue(ValidateUtil.isPhone(account) || ValidateUtil.isEmail(account), "账户不合法");
		AssertUtil.isNull(sysUserService.getSysUser(account),"账户已存在");
		AssertUtil.isTrue(password.length() >= 6, "密码长度要大于6位");

		//验证码验证
		String redisKey = RedisConstant.ACCOUNT_REGISTER+account;
		AssertUtil.isTrue(redisUtil.exist(redisKey),"请先获取验证码");
		String serverCaptcha = redisUtil.get(RedisConstant.ACCOUNT_REGISTER+account);
		AssertUtil.notBlank(serverCaptcha,"验证码失效");
		AssertUtil.isTrue(captcha.equals(serverCaptcha),"验证码不正确");

		//注册用户
		SysUser sysUser = new SysUser();
		if(ValidateUtil.isEmail(account)) {
			sysUser.setEmail(account);
		}else if(ValidateUtil.isPhone(account)){
			sysUser.setPhone(account);
		}else{
			sysUser.setUsername(account);
		}
		sysUser.setPassword(passwordEncoder.encode(password));
		sysUser.setStatus(true);
		sysUserService.add(sysUser);

		//redis移除注册验证码
		redisUtil.remove(redisKey);
	}

	/**
	 * 获取验证码(发往邮箱/手机)
	 *
	 * @param account 账户
	 * @return
	 */
	@Override
	public void getCaptcha(String account) {
		String captcha = CaptchaUtil.generateCaptcha();

		//发邮件/短信验证码
		if(ValidateUtil.isEmail(account)) {
			mailUtil.sendEmail(account, "验证码获取成功", String.format("YZCMS发送给你的注册验证码为：%s，请在%s分钟内完成注册", captcha, RedisConstant.ACCOUNT_REGISTER_CAPTCHA_EXPIRE_TIME / 60));
		}else if(ValidateUtil.isPhone(account)){
			throw new BaseException("手机号注册功能暂未开通");
		}

		//缓存redis
		redisUtil.set(RedisConstant.ACCOUNT_REGISTER+account,captcha,RedisConstant.ACCOUNT_REGISTER_CAPTCHA_EXPIRE_TIME, TimeUnit.SECONDS);
	}

	@Override
	public void updatePassword(SysUserPasswordDto sysUserPasswordDto) {
		String account = sysUserPasswordDto.getAccount();
		String password = sysUserPasswordDto.getPassword();
		String rePassword = sysUserPasswordDto.getRePassword();
		AssertUtil.isTrue(password.equals(rePassword),"确认密码不正确");

		SysUser sysUser = new SysUser();
		sysUser.setPassword(passwordEncoder.encode(password));
		sysUserService.updateByAccount(account,sysUser);
	}
}
