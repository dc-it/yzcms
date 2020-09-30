package com.mapc.yzcms.dto;

import cn.hutool.core.collection.CollectionUtil;
import com.mapc.yzcms.common.config.secure.UrlGrantedAuthority;
import com.mapc.yzcms.entity.SysPermission;
import com.mapc.yzcms.entity.SysUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * SpringSecurity需要的用户详情
 *
 * @author duchao
 */
public class SysUserDetails implements UserDetails {

	private SysUser sysUser;
	private List<SysPermission> permissionList;

	public SysUserDetails(SysUser sysUser, List<SysPermission> permissionList) {
		this.sysUser = sysUser;
		this.permissionList = permissionList;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		//返回当前用户的权限
//		return CollectionUtil.isNotEmpty(permissionList) ? permissionList.stream()
//				.filter(permission -> permission.getUrl() != null)
//				.map(permission -> new SimpleGrantedAuthority(permission.getUrl()))
//				.collect(Collectors.toList()) : null;
		if (CollectionUtil.isNotEmpty(permissionList)) {
			return permissionList.stream().filter(sysPermission -> sysPermission.getUrl() != null)
					.map(sysPermission -> new UrlGrantedAuthority(sysPermission.getUrl(), sysPermission.getMethod()))
					.collect(Collectors.toList());
		}
		return null;
	}

	@Override
	public String getPassword() {
		return sysUser.getPassword();
	}

	@Override
	public String getUsername() {
		return sysUser.getAccount();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
