package com.kuchipudi.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@SpringBootApplication
public class RedisApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(RedisApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RedisApplication.class, args);
		
		LettuceConnectionFactory connectionFactory = new LettuceConnectionFactory();
		connectionFactory.afterPropertiesSet();
		
		RedisTemplate<String,String> template = new RedisTemplate<>();
		template.setConnectionFactory(connectionFactory);
		template.setDefaultSerializer(StringRedisSerializer.UTF_8);
		template.afterPropertiesSet();
		
		template.opsForValue().set("foo", "bar");
		logger.info("Value at foo:" + template.opsForValue().get("foo"));

	}

}
