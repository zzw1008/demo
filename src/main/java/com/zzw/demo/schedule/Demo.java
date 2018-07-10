package com.zzw.demo.schedule;

import com.zzw.demo.configure.TaskExecutorConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Description:
 * 测试类
 * @version 1.0
 * @Author zzw
 * @Date: 2018/7/5 15:02
 */
public class Demo {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		/**
		 * 测试异步执行方法
		 */
		AnnotationConfigApplicationContext applicationContext = new
				AnnotationConfigApplicationContext (TaskExecutorConfig.class);
		AsyncTask asyncTask = applicationContext.getBean (AsyncTask.class);
		Future<Long> future = asyncTask.timeSpan();
		while(true){
			if(future.isDone ()){
				System.out.println ("间隔"+future.get ());
				break;
			}
		}

		for (int i = 0; i < 10; i++) {
			asyncTask.executeAsyncTask (i);
			asyncTask.executeAsyncTaskPlus (i);
		}

	}
}
