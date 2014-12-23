/**
 * 中兴软创<br/>
 * 一句话描述该类：<br/>
 * @author 黄记新
 * @date 2014-12-18,下午6:53:59
 *
 */
package com.jcin.cms.service;

import java.util.List;

import com.jcin.cms.domain.User;
import com.jcin.cms.utils.Page;

public interface IUserService  {
	int deleteByPrimaryKey(String id);

	int insert(User record);

	Page select(Page page);

	User selectByPrimaryKey(String id);

	int update(User record);
	/**
	 * 验证登录。
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	List<User> validateLogin(String username, String password);
}
