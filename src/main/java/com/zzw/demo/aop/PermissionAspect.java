package com.zzw.demo.aop;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.zzw.demo.exception.Result;
import com.zzw.demo.exception.ResultEnum;
import com.zzw.demo.util.JwtUtil;
import com.zzw.demo.util.RedisUtil;
import com.zzw.demo.util.TokenUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Description:
 *
 * @version 1.0
 * @Author zzw
 * @Date: 2018/7/11 9:27
 */
@Aspect
@Component
public class PermissionAspect {
	private static final Logger log = LoggerFactory.getLogger(PermissionAspect.class);
	@Value("#{'${permission.ingnore}'.split(',')}")
	private List<String> ignorePerm;
	@Autowired
	private RedisUtil redisUtil;

	public PermissionAspect() {
	}

	@Pointcut("execution(* com.zzw..*.controller.*.*(..)) && @annotation(com.zzw.demo.aop.Permission)")
	public void addAdvice() {
	}

	@Around("addAdvice()")
	public Object Interceptor(ProceedingJoinPoint pjp) throws Throwable {
		Permission permission = (Permission)((MethodSignature)pjp.getSignature()).getMethod().getAnnotation(Permission.class);
		String perm = permission.value();
		return !ignorePerm.contains(perm) && !validPermission(perm) ? Result.fail ( ResultEnum.UNAUTHORIZED
				,"没有访问权限") : pjp
				.proceed();
	}

	private boolean validPermission(String perm) {
		HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		String token = TokenUtil.getToken(req);

		try {
			if (StringUtils.isEmpty(token)) {
				return false;
			}

			JwtUtil.verify(token);
		} catch (JWTVerificationException e) {
			log.error("jwt", e.getMessage(), e);
			return false;
		}

		Object obj = this.redisUtil.get(token);
		if (obj == null) {
			return false;
		} else {
			req.setAttribute("cached_user_info", obj);
			return true;
		}
	}
}
