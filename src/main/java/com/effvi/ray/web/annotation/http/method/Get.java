package com.effvi.ray.web.annotation.http.method;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * <p>Title:Http协议的Get注解</p>
 * <p>Description:注解所标记的方法可以处理Htpp Get请求</p>
 * @author <a href="mailto:ducter@163.com">Kelvin</a>
 * @date 2016年8月2日 下午5:48:47
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Get {
	
	String[] value() default "";
}
