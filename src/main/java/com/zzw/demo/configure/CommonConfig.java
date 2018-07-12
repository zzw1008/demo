package com.zzw.demo.configure;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Description:
 * json
 * @version 1.0
 * @Author zzw
 * @Date: 2018/7/11 9:58
 */
@Configuration
public class CommonConfig {
	public CommonConfig() {
	}

	@Bean
	public FastJsonHttpMessageConverter fastJsonHttpMessageConverter() {
		return new FastJsonHttpMessageConverter();
	}
}
