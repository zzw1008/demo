package com.zzw.demo.exception;

import lombok.Data;

/**
 * Description:
 * 自定义异常
 * @version 1.0
 * @Author zzw
 * @Date: 2018/5/30 15:32
 */
@Data
public class ProjectException extends RuntimeException{

	private Integer code;

	public ProjectException(ResultEnum resultEnum){
		super(resultEnum.getMsg ());
		this.code = resultEnum.getCode ();
	}
}
