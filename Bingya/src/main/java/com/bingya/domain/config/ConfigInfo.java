/**
 * 
 */
package com.bingya.domain.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 * 
 */
@Component("configInfo")
public class ConfigInfo {
	@Value("${database.username}")
	private String dbUsername;

	@Value("${database.password}")
	private String dbPassword;

	public String getDbUsername() {
		return dbUsername;
	}

	public void setDbUsername(String dbUsername) {
		this.dbUsername = dbUsername;
	}

	public String getDbPassword() {
		return dbPassword;
	}

	public void setDbPassword(String dbPassword) {
		this.dbPassword = dbPassword;
	}

}
