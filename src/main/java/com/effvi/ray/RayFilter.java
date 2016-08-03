package com.effvi.ray;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.GenericFilterBean;

/**
 * 
 * <p>
 * Title:Ray框架致力于解决80%的Java Web开发场景遇到的问题
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author <a href="mailto:ducter@163.com">Kelvin</a>
 * @date 2016年7月21日 下午7:12:27
 * 
 */
public class RayFilter extends GenericFilterBean {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		final HttpServletRequest req = (HttpServletRequest) request;
		final HttpServletResponse rsp = (HttpServletResponse) response;

		// Ray BigPipe实现
		rayBigPipe(req);//

	}

	/*
	 * Ray BigPipe实现
	 */
	private void rayBigPipe(HttpServletRequest req) {

	}

	/**
	 * 实现 {@link GenericFilterBean#initFilterBean()} 对RayFilter的初始化
	 */
	@Override
	protected void initFilterBean() throws ServletException {

		if (logger.isInfoEnabled()) {
			logger.info("[Ray Init] call 'init/rootContext'");
		}

		if (logger.isDebugEnabled()) {
			StringBuilder sb = new StringBuilder();
			@SuppressWarnings("unchecked")
			Enumeration<String> iter = getFilterConfig()
					.getInitParameterNames();
			while (iter.hasMoreElements()) {
				String name = (String) iter.nextElement();
				sb.append(name).append("=")
						.append(getFilterConfig().getInitParameter(name))
						.append("\n");
			}
			logger.debug("[Ray Init] init pramater " + sb);
		}
		
		WebApplicationContext rootContext = initWebApplicationContext();
		
		super.initFilterBean();
	}
	
	private WebApplicationContext initWebApplicationContext() {
		if(logger.isInfoEnabled()){
			logger.info("[Ray Init] call 'init/rootContext' starting...");
		}
		
		return null;
	}
}
