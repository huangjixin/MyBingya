/**
 * 一句话描述该类：<br/>
 * @author 黄记新
 * @date 2014-12-18,下午6:53:59
 *
 */
package com.jcin.cms.service.system;

import java.util.List;
import java.util.Set;

import com.jcin.cms.domain.system.Authorization;
import com.jcin.cms.domain.system.Role;
import com.jcin.cms.domain.system.User;
import com.jcin.cms.domain.system.UserCriteria;
import com.jcin.cms.service.IBaseService;
import com.jcin.cms.service.system.impl.vo.UserExtention;
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
	
	/**
	 * 根据用户ID获取权限列表。
	 * @param id
	 * @return
	 */
	List<Authorization> getAuthoByUserId(String id);
	
	/**
	 * 插入一条记录
	 * @param record
	 * @return
	 * @throws Exception 
	 */
	String insert(User record,String roleId) throws Exception;
	/**
	 * 更新一条记录
	 * @param record
	 * @return
	 */
	String update(User record,String roleId);

	/**
	 * 根据用户名查询对象。
	 * @param username
	 * @return
	 */
	User findByUsername(String username);

	/**
	 * 
	 * @param username
	 * @return
	 */
	Set<String> findRoles(String username);

	/**
	 * @param username
	 * @return
	 */
	Set<String> findPermissions(String username);
}
