/**
 * 中兴软创<br/>
 * 一句话描述该类：<br/>
 * @author 黄记新
 * @date 2014-12-22,下午6:24:11
 *
 */
package com.jcin.cms.web.vo;

import com.jcin.cms.domain.system.Role;
import com.jcin.cms.domain.system.User;

public class LoginResponse {
	private static LoginResponse loginResponse;
	public static User user;
	public static Role role;
	public static boolean isLogin;

	public static LoginResponse getInstance() {
		if (loginResponse == null) {
			loginResponse = new LoginResponse();
		}

		return loginResponse;
	}

}
