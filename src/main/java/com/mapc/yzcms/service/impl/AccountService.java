package com.mapc.yzcms.service.impl;

import com.mapc.yzcms.common.constant.RedisConstant;
import com.mapc.yzcms.common.util.*;
import com.mapc.yzcms.dto.SysUserLoginDto;
import com.mapc.yzcms.dto.SysUserRegisterDto;
import com.mapc.yzcms.service.IAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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

	@Autowired
	public AccountService(UserDetailsService userDetailsService,
	                      PasswordEncoder passwordEncoder,
	                      JwtTokenUtil jwtTokenUtil,
	                      RedisUtil redisUtil,
	                      MailUtil mailUtil) {
		this.userDetailsService = userDetailsService;
		this.passwordEncoder = passwordEncoder;
		this.jwtTokenUtil = jwtTokenUtil;
		this.redisUtil = redisUtil;
		this.mailUtil = mailUtil;
	}

	/**
	 * 系统
	 *
	 * @param sysUserLoginDto 登陆参数
	 * @return token
	 */
	@Override
	public String login(SysUserLoginDto sysUserLoginDto) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(sysUserLoginDto.getAccount());
		if (!passwordEncoder.matches(sysUserLoginDto.getPassword(), userDetails.getPassword())) {
			throw new BadCredentialsException("密码不正确");
		}
		return jwtTokenUtil.generateToken(userDetails);
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
		AssertUtil.isTrue(password.length() >= 6, "密码长度要大于6位");
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

		//发邮件
		mailUtil.sendEmail(account,"验证码获取成功",String.format("YZCMS发送给你的注册验证码为：%s，请在%s分钟内完成注册",captcha,RedisConstant.ACCOUNT_REGISTER_CAPTCHA_EXPIRE_TIME/60));

		//缓存redis
		redisUtil.set(RedisConstant.ACCOUNT_REGISTER+account,captcha,RedisConstant.ACCOUNT_REGISTER_CAPTCHA_EXPIRE_TIME, TimeUnit.SECONDS);
	}
}
