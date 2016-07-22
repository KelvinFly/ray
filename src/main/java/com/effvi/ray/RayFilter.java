package com.effvi.ray;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.GenericFilterBean;

/**
 * 
 * <p>Title:Ray框架致力于解决80%的Java Web开发场景遇到的问题</p>
 * <p>Description:</p>
 * @author <a href="mailto:ducter@163.com">Kelvin</a>
 * @date 2016年7月21日 下午7:12:27
 *
 */
public class RayFilter extends GenericFilterBean {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		final HttpServletRequest req = (HttpServletRequest)request;
		final HttpServletResponse rsp = (HttpServletResponse)response;
		
		//Ray BigPipe实现
		rayBigPipe(req);
		
		
		
		
	}
	
	/*
	 * Ray BigPipe实现
	 */
	private void rayBigPipe(HttpServletRequest req) {
		
	}
	
}
