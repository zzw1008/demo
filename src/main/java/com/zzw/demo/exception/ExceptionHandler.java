package com.zzw.demo.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Description:
 *
 * @version 1.0
 * @Author zzw
 * @Date: 2018/6/13 20:29
 */
@ControllerAdvice
public class ExceptionHandler {

	/**
	 * 捕获异常
	 * @return
	 */
	@org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
	@ResponseBody
	public  Result handle(Exception e){
		if(e instanceof ProjectException){
			ProjectException projectException = (ProjectException) e;
			return Result.fail (ResultEnum.UNKONW_ERROR,projectException.getMessage ());
		}else{
			return Result.fail (ResultEnum.UNKONW_ERROR,e);
		}
	}
}
