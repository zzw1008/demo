package com.zzw.demo.exception;

/**
 * Description:
 *
 * @version 1.0
 * @Author zzw
 * @Date: 2018/5/30 16:44
 */
public enum ResultEnum {

	/**
	 * 未知错误
	 */
	UNKONW_ERROR(-1,"未知错误"),
	/**
	 * 成功访问
	 */
	SUCCESS(200,"成功"),
	/**
	 * 参数错误
	 */
	PARAMETER_ERROR(1,"参数错误"),
	/**
	 * 登陆错误
	 */
	Login_ERROR(2,"账号或密码不对"),
	/**
	 * 插入语句执行错误
	 */
	INSERT_ERROR(3,"插入语句执行错误"),
	/**
	 * 未授权
	 */
	UNAUTHORIZED(401,"未授权")
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
