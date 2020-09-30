package com.mapc.yzcms.common.config.secure;

import com.mapc.yzcms.common.util.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * JWT登录授权过滤器
 */
@Slf4j
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	@Value("${jwt.tokenHeader}")
	private String tokenHeader;
	@Value("${jwt.tokenHead}")
	private String tokenHead;

	@Override
	protected void doFilterInternal(HttpServletRequest request,
	                                HttpServletResponse response,
	                                FilterChain chain) throws ServletException, IOException {
		String authHeader = request.getHeader(this.tokenHeader);
		if (authHeader != null && authHeader.startsWith(this.tokenHead)) {
			String authToken = authHeader.substring(this.tokenHead.length() + 1);
			String account = jwtTokenUtil.getAccountFromToken(authToken);
			log.info("checking username:{}", account);
			if (account != null && SecurityContextHolder.getContext().getAuthentication() == null) {
				if (jwtTokenUtil.validateToken(authToken)) {
					UserDetails userDetails = this.userDetailsService.loadUserByUsername(account);
					UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
					authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					log.info("authenticated user:{}", account);
					SecurityContextHolder.getContext().setAuthentication(authentication);
				}
				//允许过期时间内刷新token
				else if (jwtTokenUtil.canRefresh(authToken)) {
					authToken = jwtTokenUtil.refreshToken(authToken);
					response.setHeader(this.tokenHeader, this.tokenHead + " " + authToken);

					UserDetails userDetails = this.userDetailsService.loadUserByUsername(account);
					UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
					authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					log.info("authenticated user:{}", account);
					SecurityContextHolder.getContext().setAuthentication(authentication);
				}
			}
		}
		chain.doFilter(request, response);
	}
}
