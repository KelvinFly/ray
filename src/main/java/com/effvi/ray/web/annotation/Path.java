package com.effvi.ray.web.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * <p>Title:URL路径注解</p>
 * <p>Description:URL路径注解标识，支持传入多个路径</p>
 * @author <a href="mailto:ducter@163.com">Kelvin</a>
 * @date 2016年8月3日 上午9:34:37
 *
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Path {
	
	String[] value();
}
