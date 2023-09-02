package com.textitout.chat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;

import java.time.Duration;

@EnableCaching
@SpringBootApplication
public class ChatApplication {

	@Bean
	public RedisCacheManager cacheManager(RedisConnectionFactory connectionFactory) {
		RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig() //
				.prefixCacheNameWith(this.getClass().getPackageName() + ".") //com.textitout.chat. prefix
				.entryTtl(Duration.ofHours(1)) // time to live of 1 hour
				.disableCachingNullValues(); // dont cache null values

		return RedisCacheManager.builder(connectionFactory)
				.cacheDefaults(config)
				.build();
	}
	public static void main(String[] args) {
		SpringApplication.run(ChatApplication.class, args);
	}

}
