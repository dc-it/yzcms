package com.mapc.yzcms.common.config.secure;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

/**
 * api接口映射权限
 *
 * @author duchao
 */
@Data
public class UrlGrantedAuthority implements GrantedAuthority {

	/**
	 * api映射路径
	 */
	private final String url;

	/**
	 * api请求方法
	 */
	private final String method;


	public UrlGrantedAuthority(String url, String method) {
		this.url = url;
		this.method = method;
	}

	@Override
	public String getAuthority() {
		return url;
	}
}
