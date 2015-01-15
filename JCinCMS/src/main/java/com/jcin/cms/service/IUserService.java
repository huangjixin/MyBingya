/**
 * 中兴软创<br/>
 * 一句话描述该类：<br/>
 * @author 黄记新
 * @date 2014-12-18,下午6:53:59
 *
 */
package com.jcin.cms.service;

import java.util.List;

import com.jcin.cms.domain.Role;
import com.jcin.cms.domain.User;
import com.jcin.cms.domain.UserCriteria;
import com.jcin.cms.utils.Page;

public interface IUserService extends IBaseService<User, String> {
	
	/**
	 * 封装查询条件，返回Page对象。
	 * 
	 * @param criteria
	 * @return
	 */
	Page select(UserCriteria criteria);

	/**
	 * 验证登录。
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	List<User> validateLogin(String username, String password);

	/**
	 * 根据用户ID获取关联角色。
	 * @param id
	 * @return
	 */
	List<Role> getRolesByUserId(String id);
}
