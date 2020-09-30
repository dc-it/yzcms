package com.mapc.yzcms.common.config.secure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * 安全拦截器
 *
 * @author duchao
 */
//@Component
public class UrlFilterSecurityInterceptor extends FilterSecurityInterceptor {

	@Override
	public void setAccessDecisionManager(AccessDecisionManager accessDecisionManager) {
		super.setAccessDecisionManager(accessDecisionManager);
	}

	public UrlFilterSecurityInterceptor() {
		super();
	}

	@Override
	public void init(FilterConfig filterConfig) {
		super.init(filterConfig);
	}

	@Override
	public void destroy() {
		super.destroy();
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		super.doFilter(request, response, chain);
	}

	@Override
	public FilterInvocationSecurityMetadataSource getSecurityMetadataSource() {
		return super.getSecurityMetadataSource();
	}

	@Override
	public SecurityMetadataSource obtainSecurityMetadataSource() {
		return super.obtainSecurityMetadataSource();
	}

	@Override
	public void setSecurityMetadataSource(FilterInvocationSecurityMetadataSource newSource) {
		super.setSecurityMetadataSource(newSource);
	}

	@Override
	public Class<?> getSecureObjectClass() {
		return super.getSecureObjectClass();
	}

	@Override
	public void invoke(FilterInvocation fi) throws IOException, ServletException {
		super.invoke(fi);
	}

	@Override
	public boolean isObserveOncePerRequest() {
		return super.isObserveOncePerRequest();
	}

	@Override
	public void setObserveOncePerRequest(boolean observeOncePerRequest) {
		super.setObserveOncePerRequest(observeOncePerRequest);
	}
}
