package com.zzw.demo.exception;

/**
 * Description:
 *
 * @version 1.0
 * @Author zzw
 * @Date: 2018/5/30 16:44
 */
public enum ResultEnum {
	
	UNKONW_ERROR(-1,"未知错误"),
	SUCCESS(200,"成功"),
	PARAMETER_ERROR(1,"参数错误")
	;
	private Integer code;

	private String msg;

	ResultEnum(Integer code, String msg){
		this.code = code;
		this.msg = msg;
	}

	public Integer getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}
}
