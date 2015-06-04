/**
 * 一句话描述该类：shiro用户接口类,不写在IUserService里面的原因是生成模板还没有完全好，这是一个妥协<br/>
 * @author 黄记新
 * @date 2015-5-23,上午10:17:04
 *
 */
/**
 * 
 */
package com.jcin.cms.service.system;

import java.util.Set;

import com.jcin.cms.domain.system.User;

/**
 * @author 黄记新
 *
 */
public interface IUserServiceShiro {
	/**
	 * 根据用户名查询查角色。
	 * @param username
	 * @return
	 */
	Set<String> findRoles(String username);
	/**
	 * 根据用户名查权限。
	 * @param username
	 * @return
	 */
	Set<String> findPermissions(String username);
	
	/**
	 * 根据用户名查询用户，用户名也应该是唯一的。
	 * @param username
	 * @return
	 */
	User findByUsername(String username);
}
