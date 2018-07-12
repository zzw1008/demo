package com.zzw.demo.configure;

import com.zzw.demo.util.RedisOperator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * Description:
 * Redis配置
 * @version 1.0
 * @Author zzw
 * @Date: 2018/7/11 9:39
 */
@Configuration
public class RedisConfig {
	public RedisConfig() {
	}

	@Bean(
			name = {"redisOperator"}
	)
	public RedisOperator redisUtil(RedisTemplate<Object, Object> redisTemplate) {
		RedisOperator redisOperator = new RedisOperator();
		redisOperator.setRedisTemplate (redisTemplate);
		return redisOperator;
	}
}
