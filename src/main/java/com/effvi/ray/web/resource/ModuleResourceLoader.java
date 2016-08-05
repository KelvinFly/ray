package com.effvi.ray.web.resource;

import java.util.List;
/**
 * 
 * <p>Title: Ray模块资源加载器</p>
 * <p>Description: 勇于加载Ray框架模块</p>
 * @author <a href="mailto:ducter@163.com">Kelvin.Zhang</a>
 * @date 2016年8月3日 下午2:27:45
 *
 */
public interface ModuleResourceLoader {
	
	List<ModuleResource> loadModuleResource();
}
