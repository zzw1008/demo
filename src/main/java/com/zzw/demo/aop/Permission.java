package com.zzw.demo.aop;

import java.lang.annotation.*;

/**
 * Description:
 * 注解，注释权限
 * @version 1.0
 * @Author zzw
 * @Date: 2018/7/11 9:25
 */
@Documented
@Retention ( RetentionPolicy.RUNTIME )
@Target ( {ElementType.METHOD} )
public @interface Permission {
	String value();
}
