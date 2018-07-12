package com.zzw.demo.common;

import org.springframework.stereotype.Component;

/**
 * Description:
 * 系统常量
 * @version 1.0
 * @Author zzw
 * @Date: 2018/7/12 13:38
 */
@Component
public class SystemConstant {
	/**
	 * jwt过期时间
	 */
	public static final long DEFAULT_JWT_EXPIRE_TIME = 7200L;

	/**
	 * token获取
	 */
	public static final String HTTP_HEADER_JWT_KEY = "x-access-token";

	/**
	 * 缓存的用户信息
	 */
	public static final String CACHED_USER_INFO = "cached_user_info";
	public SystemConstant(){

	}
}
