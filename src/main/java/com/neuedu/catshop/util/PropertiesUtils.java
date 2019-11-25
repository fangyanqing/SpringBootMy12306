package com.neuedu.catshop.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 配置文件读取类，默认读取:application.properties
 * 
 * @author netboy
 *
 */
public class PropertiesUtils {
	private Properties properties;
	private static PropertiesUtils propertiesUtils = new PropertiesUtils();

	/**
	 * 私有构造，禁止直接创建
	 */
	private PropertiesUtils() {
		properties = new Properties();
		InputStream in = PropertiesUtils.class.getClassLoader().getResourceAsStream("application.properties");
		try {
			properties.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取单例
	 *
	 * @return PropertiesUtils
	 */
	public static PropertiesUtils getInstance() {
		if (propertiesUtils == null) {
			propertiesUtils = new PropertiesUtils();
		}
		return propertiesUtils;
	}

	/**
	 * 根据属性名读取值
	 *
	 * @param name 名称
	 */
	public String getProperty(String name) {
		return properties.getProperty(name);
	}
}
