/**
 * 
 */
package com.bingya.service.system;

import java.util.List;

import com.bingya.domain.system.Role;
import com.bingya.service.IGenericService;

/**
 * @author huangjixin
 *
 */
public interface IRoleService extends IGenericService<Role, String> {
	/**
	 * 根据id查询角色。
	 * @param id
	 * @return
	 */
	List getMenusById(String id);
	
	/**
	 * 查询xml字符串。
	 * @param id
	 * @return
	 */
	String getMenusXMLById(String id);
	
	/**
	 * 根据用户id查询角色。
	 * @param userId
	 * @return
	 */
	Role getRoleByUserid(String userId);
	
	/**
	 * 绑定角色和菜单
	 * @param roleid
	 * @param menuIds
	 */
	void connectRoleMenus(String roleid,List<String>menuIds);
	
	/**
	 * 断开角色和菜单的关联
	 * @param roleid
	 * @param menuIds
	 * @return
	 */
	void disconnectRoleMenu(String roleid,List<String>menuIds);
}
