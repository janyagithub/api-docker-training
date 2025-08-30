package com.dockrdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Protocol;

@Configuration
public class RedisConfiguration {

	@Bean
	JedisPool jedisPool(@Value("${spring.data.redis.host}") String host, @Value("${spring.data.redis.port}") int port,
			@Value("${spring.data.redis.password}") String password,
			@Value("${spring.data.redis.database}") String database) {

		JedisPoolConfig poolConfig = new JedisPoolConfig();

		return new JedisPool(poolConfig, host, port, Protocol.DEFAULT_TIMEOUT, password, Integer.parseInt(database));
	}
}