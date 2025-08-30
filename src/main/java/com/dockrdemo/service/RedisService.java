package com.dockrdemo.service;

import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Service
public class RedisService {

	private final JedisPool jedisPool;

	public RedisService(JedisPool jedisPool) {
		super();
		this.jedisPool = jedisPool;
	}

	public void setValue(String key, String value) {
		try (Jedis jedis = jedisPool.getResource()) {
			jedis.set(key, value);
		}
	}

	public void setValueWithExpiry(String key, String value, long seconds) {
		try (Jedis jedis = jedisPool.getResource()) {
			jedis.set(key, value);
			jedis.expire(key, seconds);
		}
	}

	public String getValue(String key) {
		try (Jedis jedis = jedisPool.getResource()) {
			return jedis.get(key);
		}
	}
	
	public Long removeOne(String key) {
		try (Jedis jedis = jedisPool.getResource()) {
			return jedis.del(key);
		}
	}
	
	public String removeAll() {
		try (Jedis jedis = jedisPool.getResource()) {
			return jedis.flushAll();
		}
	}

	public boolean exists(String key) {
		try (Jedis jedis = jedisPool.getResource()) {
			return jedis.exists(key);
		}
	}
}
