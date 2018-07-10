package com.zzw.demo.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Description:
 * 自定义拦截器
 * @version 1.0
 * @Author zzw
 * @Date: 2018/7/9 10:30
 */
@Component
public class LogHandlerInterceptor implements HandlerInterceptor {

	/**
	 * controller 执行之前调用
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws
			Exception {
		System.out.println("------preHandle-----");
		return true;
	}

	/**
	 * controller 执行之后，且页面渲染之前调用
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView
			modelAndView) throws Exception {
		System.out.println("------postHandle-----");
	}

	/**
	 * 页面渲染之后调用，一般用于资源清理操作
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception
			ex) throws Exception {
		System.out.println("------afterCompletion-----");
	}
}
