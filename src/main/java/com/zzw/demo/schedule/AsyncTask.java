package com.zzw.demo.schedule;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * Description:
 * 异步任务执行类
 * @version 1.0
 * @Author zzw
 * @Date: 2018/7/5 14:59
 */
@Component
public class AsyncTask {
	@Async
	public void executeAsyncTask(Integer i){
		System.out.println ("执行异步任务："+i);
	}

	@Async
	public void executeAsyncTaskPlus(Integer i){
		System.out.println ("执行异步任务+1："+(i+1));
	}

	@Async
	public Future<Long> timeSpan() throws InterruptedException {
		long start = System.currentTimeMillis ();
		Thread.sleep (1000);
		long end = System.currentTimeMillis ();
		return new AsyncResult<Long> (end-start);
	}
}
