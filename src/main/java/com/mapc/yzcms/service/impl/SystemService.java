package com.mapc.yzcms.service.impl;

import com.mapc.yzcms.common.util.JwtTokenUtil;
import com.mapc.yzcms.dto.SysUserLoginDto;
import com.mapc.yzcms.service.ISystemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * 系统业务逻辑
 *
 * @author duchao
 */
@Slf4j
@Service
public class SystemService implements ISystemService {

	private final UserDetailsService userDetailsService;
	private final PasswordEncoder passwordEncoder;
	private final JwtTokenUtil jwtTokenUtil;

	@Autowired
	public SystemService(UserDetailsService userDetailsService,PasswordEncoder passwordEncoder,JwtTokenUtil jwtTokenUtil) {
		this.userDetailsService = userDetailsService;
		this.passwordEncoder = passwordEncoder;
		this.jwtTokenUtil = jwtTokenUtil;
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
}
