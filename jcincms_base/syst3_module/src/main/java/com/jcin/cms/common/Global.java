/**
 * 一句话描述该类：全局配置类<br/>
 * @author 黄记新
 * @date 2015-9-29,上午11:54:18
 *
 */
package com.jcin.cms.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Global {
	/**
	 * 属性文件加载对象
	 */
	private static Properties properties;

	/**
	 * 获取配置
	 */
	private static String getConfig(String key) {
		if (properties == null) {
			String resources = "/spring/web.properties";
			properties = loadProperties(resources);
		}
		return properties.getProperty(key);
	}

	public static String getAdminPath(){
		return getConfig("adminPath");
	}
	
	public static String getUploadpath(){
		return getConfig("uploadPath");
	}
	
	private static Properties loadProperties(String resources) {
		// 使用InputStream得到一个资源文件
		InputStream inputstream = Global.class.getResourceAsStream(resources);
		// new 一个Properties
		Properties properties = new Properties();
		try {
			// 加载配置文件
			properties.load(inputstream);
			return properties;
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				inputstream.close();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}
}
