package com.effvi.ray;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.GenericFilterBean;

import com.effvi.ray.web.context.ContextScope;
import com.effvi.ray.web.context.RayWebApplicationContext;

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

	private static final String ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE = WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE;

	private String contextConfigLocation; // applicationContext路径

	private ContextScope scope; // 上下文环境范围
	
//	private List<RayModule> modules; //Ray模块
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
		// 初始化Ray上下文环境
		WebApplicationContext rootContext = initWebApplicationContext();
		
		if(logger.isInfoEnabled()){
			logger.info("[Ray Init] exit from 'init/rootCotnext'");
			logger.info("[Ray Init] exit from 'init/loadModule'");
		}
		
//		this.modules = loadModule(rootContext);

		super.initFilterBean();
	}
	
	/**
	 * 初始化Ray上下文环境
	 * @return
	 */
	private WebApplicationContext initWebApplicationContext() {
		if (logger.isInfoEnabled()) {
			logger.info("[Ray Init] 'init/rootContext' starting...");
		}
		RayWebApplicationContext rootContext = new RayWebApplicationContext(
				getServletContext(), scope, false);

		String cotextConfigLocation = this.contextConfigLocation;
		if (StringUtils.isBlank(cotextConfigLocation)) { // 优先使用contextConfigLocation的配置
			String webxmlContextConfigLocation = getServletContext()
					.getInitParameter("contextConfigLocation");
			if (StringUtils.isBlank(webxmlContextConfigLocation)) {
				contextConfigLocation = RayWebApplicationContext.DEFAULT_CONFIG_LOCATION;
			} else {
				cotextConfigLocation = webxmlContextConfigLocation;
			}
		}

		rootContext.setConfigLocation(cotextConfigLocation);
		rootContext.setId("ray.web.root");
		rootContext.refresh();

		if (logger.isInfoEnabled()) {
			logger.info("[Ray Init] 'init/rootContext' exit");
		}

		getServletContext().setAttribute(
				ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE, rootContext);

		if (logger.isInfoEnabled()) {
			StringBuilder sb = new StringBuilder();
			sb.append(
					"[Ray Init] 'init/rootContext'  Start ray.web.root WebApplicationContext [")
					.append(rootContext)
					.append("] as ServletContext attribute with name [")
					.append(ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE).append("]");
			logger.info("[Ray Init] 'init/rootContext'  Start ray.web.root WebApplicationContext");
		}
		return rootContext;
	}
	 
	private void loadModule(WebApplicationContext rootContext){
		if(logger.isInfoEnabled()){
			logger.info("[Ray Init] 'init/loadModule' starting...");
		}
		
		
	}
	
}
