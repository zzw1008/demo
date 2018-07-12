package com.zzw.demo.util;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Description:
 * 获取token，从自定义 Headers 中获取
 * @version 1.0
 * @Author zzw
 * @Date: 2018/7/11 10:00
 */
@Component
public class TokenUtil {
	public TokenUtil() {
	}

	public static String getToken(HttpServletRequest req) {
		return req.getHeader("x-access-token");
	}
}
