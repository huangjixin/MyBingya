/**
 * 一句话描述该类：数据库连接域模型<br/>
 * @author 黄记新
 * @date 2015-6-3,下午6:28:09
 *
 */
package com.jcin.cms.web.domain;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class Hostsetting {

	@NotBlank
	@NotNull
	@NotEmpty(message = "数据库必填")
	private String dbname;
	@NotBlank
	@NotNull
	@NotEmpty(message = "主机地址必填")
	private String host;
	@NotBlank
	@NotNull
	@NotEmpty(message = "端口必填")
	private int port;
	@NotBlank
	@NotNull
	@NotEmpty(message = "用户必填")
	private String username;
	@NotBlank
	@NotNull
	@NotEmpty(message = "密码必填")
	private String password;

	public String getDbname() {
		return dbname;
	}

	public void setDbname(String dbname) {
		this.dbname = dbname;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
}
