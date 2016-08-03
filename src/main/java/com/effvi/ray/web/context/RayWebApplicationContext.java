package com.effvi.ray.web.context;

import javax.servlet.ServletContext;

import org.springframework.web.context.support.XmlWebApplicationContext;

public class RayWebApplicationContext extends XmlWebApplicationContext {
	/** Default config location for the root context */
	public static final String DEFAULT_CONFIG_LOCATION = "/WEB-INF/applicationContext*.xml";
	
	public ContextScope scope;
	
	public RayWebApplicationContext(ServletContext servletContext,ContextScope scope,boolean autoScan) {
		this.scope = scope;
		this.setServletContext(servletContext);
		if(autoScan){
			autoScan();
		}
	}
	
	private void autoScan(){
		
	}
	
}
