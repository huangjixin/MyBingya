/**
 * 一句话描述该类：用户拓展类<br/>
 * @author 黄记新
 * @date 2015-3-8,下午7:03:47
 *
 */
package com.jcin.cms.service.system.impl.vo;

import com.jcin.cms.domain.system.User;

public class UserExtention extends User {
	private static final long serialVersionUID = 1L;

	private String roleId;

	private String role;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
}
