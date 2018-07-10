package com.zzw.demo.configure;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * Description:
 * 异步任务配置
 * @version 1.0
 * @Author zzw
 * @Date: 2018/7/5 14:55
 */
@Configuration
@ComponentScan("com.zzw.demo.schedule")
@EnableAsync
public class TaskExecutorConfig implements AsyncConfigurer {
	@Override
	public Executor getAsyncExecutor() {
		ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor ();
		threadPoolTaskExecutor.setCorePoolSize (5);
		threadPoolTaskExecutor.setMaxPoolSize (10);
		threadPoolTaskExecutor.setQueueCapacity (25);
		threadPoolTaskExecutor.initialize ();
		return threadPoolTaskExecutor;
	}

	@Override
	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
		return null;
	}
}
