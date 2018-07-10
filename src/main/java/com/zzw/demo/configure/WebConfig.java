package com.zzw.demo.configure;

import com.zzw.demo.interceptor.LogHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * Description:
 * 注册拦截器
 * @version 1.0
 * @Author zzw
 * @Date: 2018/7/9 10:34
 */
@Configuration
public class WebConfig extends WebMvcConfigurationSupport {
	@Override
	protected void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor (new LogHandlerInterceptor ()).addPathPatterns ("/**");
		super.addInterceptors (registry);
	}
}
