package com.effvi.ray;

/**
 * 
 * <p>Title: Ray版本信息</p>
 * <p>Description:</p>
 * @author <a href="mailto:ducter@163.com">Kelvin</a>
 * @date 2016年7月22日 上午8:42:33
 *
 */
public class RayVersion {
	public static String getVersion() {
		Package pkg = RayVersion.class.getPackage();
		return (pkg != null ? pkg.getImplementationVersion() : null);
	}
}
