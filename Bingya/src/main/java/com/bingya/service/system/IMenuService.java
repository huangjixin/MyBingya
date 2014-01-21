package com.bingya.service.system;

import java.util.List;

import com.bingya.domain.system.Menu;
import com.bingya.domain.system.RoleMenu;
import com.bingya.service.IGenericService;

public interface IMenuService extends IGenericService<Menu, String> {
	/**
	 * 根据角色id查询菜单，参数为null查询全部菜单。
	 * @param roleId
	 * @return
	 */
	List getMenuTreeByRoleId(String roleId);

	List<Menu> getByParentId(String id,List<RoleMenu>roleMenus);
	
	String getMenuXmlStr(String basePath);
}
