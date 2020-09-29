package com.mapc.yzcms.common.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * redis工具类
 *
 * @author duchao
 */
@Slf4j
@Component
public class RedisUtil {

	private final StringRedisTemplate redisTemplate;

	@Autowired
	public RedisUtil(StringRedisTemplate redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	/**
	 * 缓存
	 *
	 * @param key   键
	 * @param value 值
	 */
	public void set(final String key, String value) {
		redisTemplate.opsForValue().set(key, value);
	}

	/**
	 * 缓存
	 *
	 * @param key   键
	 * @param value 值
	 */
	public void set(final String key, String value, Long expireTime, TimeUnit timeUnit) {
		redisTemplate.opsForValue().set(key, value);
		redisTemplate.expire(key, expireTime, timeUnit);
	}

	/**
	 * 获取缓存
	 *
	 * @param key 键
	 */
	public String get(final String key) {
		return redisTemplate.opsForValue().get(key);
	}

	/**
	 * 删除缓存
	 *
	 * @param keys 键
	 */
	public void remove(final String... keys) {
		for (String key : keys) {
			if (redisTemplate.hasKey(key)) {
				redisTemplate.delete(key);
			}
		}
	}

	/**
	 * 是否存在某缓存
	 *
	 * @param key 键
	 * @return
	 */
	public boolean exist(final String key) {
		return redisTemplate.hasKey(key);
	}

	/**
	 * hash添加
	 *
	 * @param key     redis 键
	 * @param hmKey   map 键
	 * @param hmValue map值
	 */
	public void hPut(final String key, final String hmKey, Object hmValue) {
		redisTemplate.opsForHash().put(key, hmKey, hmValue);
	}

	/**
	 * hash获取
	 *
	 * @param key     redis 键
	 * @param hmKey   map 键
	 * @param hmValue map值
	 */
	public Object hGet(final String key, final String hmKey, Object hmValue) {
		return redisTemplate.hasKey(key) ? redisTemplate.opsForHash().get(key, hmKey) : null;
	}

	/**
	 * list添加
	 *
	 * @param key   redis 键
	 * @param value list值
	 */
	public void lPush(final String key, String value) {
		redisTemplate.opsForList().rightPush(key, value);
	}

	/**
	 * list获取
	 *
	 * @param key redis 键
	 */
	public List<String> lGet(final String key) {
		return redisTemplate.hasKey(key) ? redisTemplate.opsForList().range(key, 0, redisTemplate.opsForList().size(key)) : null;
	}

	/**
	 * set添加
	 *
	 * @param key    redis 键
	 * @param values list值
	 */
	public void sPush(final String key, String... values) {
		redisTemplate.opsForSet().add(key, values);
	}

	/**
	 * set获取
	 *
	 * @param key redis 键
	 */
	public Set<String> sGet(final String key) {
		return redisTemplate.hasKey(key) ? redisTemplate.opsForSet().members(key) : null;
	}
}
