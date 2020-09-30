package com.mapc.yzcms.common.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * JwtToken生成的工具类
 * <p>
 * JWT token的格式：header.payload.signature
 * header的格式（算法、token的类型）：
 * {"alg": "HS512","typ": "JWT"}
 * payload的格式（用户名、创建时间、生成时间）：
 * {"sub":"wang","created":1489079981393,"exp":1489684781}
 * signature的生成算法：
 * HMACSHA512(base64UrlEncode(header) + "." +base64UrlEncode(payload),secret)
 *
 * @author duchao
 */
@Slf4j
@Component
public class JwtTokenUtil {

	private static final String CLAIM_KEY_USERNAME = "sub";
	private static final String CLAIM_KEY_CREATED = "created";
	@Value("${jwt.secret}")
	private String secret;
	@Value("${jwt.expireTime}")
	private Long expireTime;
	@Value("${jwt.allowExpireTime}")
	private Long allowExpireTime;

	/**
	 * 根据用户信息生成token
	 */
	public String generateToken(String account) {
		Map<String, Object> claims = new HashMap<>(2);
		claims.put(CLAIM_KEY_USERNAME, account);
		claims.put(CLAIM_KEY_CREATED, new Date());
		return generateToken(claims);
	}

	/**
	 * 根据负责生成JWT的token
	 */
	private String generateToken(Map<String, Object> claims) {
		return Jwts.builder()
				.setClaims(claims)
				.setExpiration(generateExpireDate())
				.signWith(SignatureAlgorithm.HS512, secret)
				.compact();
	}

	/**
	 * 从token中获取登录用户名
	 */
	public String getAccountFromToken(String token) {
		String account;
		try {
			Claims claims = getClaimsFromToken(token);
			account = claims.getSubject();
		} catch (Exception e) {
			account = null;
		}
		return account;
	}

	/**
	 * 从token中获取过期时间
	 */
	private Date getExpireDateFromToken(String token) {
		Claims claims = getClaimsFromToken(token);
		return claims.getExpiration();
	}

	/**
	 * 从token中获取JWT中的负载payload
	 */
	private Claims getClaimsFromToken(String token) {
		try {
			return Jwts.parser()
					.setSigningKey(secret)
					.parseClaimsJws(token)
					.getBody();
		} catch (ExpiredJwtException e) {
			log.error("JWT-token过期:{}", token);
			return e.getClaims();
		}
	}

	/**
	 * 验证token是否还有效
	 * <p>
	 * 可能：
	 * 1、没过期
	 * 2、过期，但是在允许过期时间范围内
	 *
	 * @param token 客户端传入的token
	 */
	public boolean validateToken(String token) {
		Date expireDate = getExpireDateFromToken(token);
		return new Date().before(expireDate) || isAllowExpireTime(expireDate);
	}

	/**
	 * 刷新token
	 * <p>
	 * 在允许过期时间内刷新token，否则返回老的token
	 */
	public String refreshTokenIfCanRefresh(String token) {
		Claims claims = getClaimsFromToken(token);
		Date expireDate = claims.getExpiration();
		if (isAllowExpireTime(expireDate)) {
			claims.put(CLAIM_KEY_CREATED, new Date());
			token = generateToken(claims);
		}
		return token;
	}

	/**
	 * 是否是过期允许时间范围内
	 *
	 * @param expireDate 过期时间
	 * @return
	 */
	private boolean isAllowExpireTime(Date expireDate) {
		return System.currentTimeMillis() - expireDate.getTime() <= allowExpireTime * 1000;
	}

	/**
	 * 生成token的过期时间
	 */
	private Date generateExpireDate() {
		return new Date(System.currentTimeMillis() + expireTime * 1000);
	}
}
