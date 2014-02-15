package com.bingya.service.system;

import java.io.IOException;

public interface IMySqlService {
	/**
	 * 备份数据库
	 * @throws IOException 
	 */
	String backup(String path) throws IOException;
	/**
	 * 还原数据库
	 */
	Boolean restore(String filPath,Boolean isPath);
}
