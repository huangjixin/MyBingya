/**
 * 一句话描述该类：<br/>
 * @author 黄记新
 * @date 2014-12-18,下午6:53:59
 *
 */
package com.jcin.cms.service;

import java.util.List;

import com.jcin.cms.domain.Menu;
import com.jcin.cms.domain.MenuCriteria;
import com.jcin.cms.utils.Page;

public interface IMenuService extends IBaseService<Menu, String> {
	/**
	 * 根据角色id查询菜单，参数为null查询全部菜单。
	 * 
	 * @param roleId
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	List getMenuTree(String roleId);

	/**
	 * 根据ParentId列查询记录数。
	 * @param id
	 * @return
	 */
	List<Menu> getByParentId(String id);

	/**
	 * 封装查询条件，返回Page对象。
	 * 
	 * @param criteria
	 * @return
	 */
	Page select(MenuCriteria criteria);
}
