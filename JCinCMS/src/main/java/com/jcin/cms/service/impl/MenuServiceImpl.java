/**
 * 中兴软创<br/>
 * 一句话描述该类：<br/>
 * @author 黄记新
 * @date 2014-12-18,下午6:56:55
 *
 */
/**
 * 
 */
package com.jcin.cms.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jcin.cms.dao.MenuMapper;
import com.jcin.cms.dao.RoleMenuMapper;
import com.jcin.cms.domain.Menu;
import com.jcin.cms.domain.MenuCriteria;
import com.jcin.cms.domain.RoleMenu;
import com.jcin.cms.domain.RoleMenuCriteria;
import com.jcin.cms.service.IMenuService;
import com.jcin.cms.utils.Page;

/**
 * @author 黄记新
 * @date 2014-12-18,下午6:56:55
 * 
 */
@Service(value = "menuService")
public class MenuServiceImpl extends BaseServiceImpl<Menu, String> implements
		IMenuService {
	private static Logger logger = Logger.getLogger(MenuServiceImpl.class
			.getName());

	@Resource
	private MenuMapper menuMapper;

	@Resource
	private RoleMenuMapper roleMenuMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.IMenuService#deleteByPrimaryKey((java.lang.String))
	 */
	@Override
	@Transactional
	public int deleteByPrimaryKey(String id) {
		super.deleteByPrimaryKey(id);
		int result = menuMapper.deleteByPrimaryKey(id);

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jcin.cms.service.IMenuService#insert(com.jcin.cms.domain.Menu)
	 */
	@Override
	@Transactional
	public int insert(Menu record) {
		super.insert(record);

		int result = menuMapper.insert(record);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jcin.cms.service.IMenuService#select(com.jcin.cms.utils.Page)
	 */
	@Override
	public Page select(Page page) {
		super.select(page);

		MenuCriteria menuCriteria = new MenuCriteria();
		menuCriteria.setPage(page);
		@SuppressWarnings("rawtypes")
		List list = menuMapper.selectByExample(menuCriteria);
		page.setRows(list);
		int total = menuMapper.countByExample(menuCriteria);
		page.setTotal(total);
		return page;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.IMenuService#select(com.jcin.cms.domain.MenuCriteria
	 * )
	 */
	@Override
	public Page select(MenuCriteria criteria) {
		Page page = new Page();
		@SuppressWarnings("rawtypes")
		List list = menuMapper.selectByExample(criteria);
		page.setRows(list);
		int total = menuMapper.countByExample(criteria);
		page.setTotal(total);
		return page;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.IMenuService#selectByPrimaryKey(java.lang.String)
	 */
	@Override
	public Menu selectByPrimaryKey(String id) {
		super.selectByPrimaryKey(id);

		Menu menu = menuMapper.selectByPrimaryKey(id);
		return menu;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jcin.cms.service.IMenuService#update(com.jcin.cms.domain.Menu)
	 */
	@Override
	@Transactional
	public int update(Menu record) {
		super.update(record);

		int result = menuMapper.updateByPrimaryKeySelective(record);
		return result;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List getMenuTree(String roleId) {
		List<RoleMenu> roleMenus = null;
		if (roleId != null || "".equals(roleId)) {
			RoleMenuCriteria roleMenuCriteria = new RoleMenuCriteria();
			roleMenuCriteria.createCriteria().andRoleIdEqualTo(roleId);
			roleMenus = roleMenuMapper.selectByExample(roleMenuCriteria);
		}

		MenuCriteria menuExample = new MenuCriteria();
		menuExample.createCriteria().andParentidIsNull();

		List<Menu> list = menuMapper.selectByExample(menuExample);
		List children = new ArrayList();
		for (Menu object : list) {
			boolean flag = false;
			if(roleMenus != null){
				for (RoleMenu roleMenu : roleMenus) {
					if (roleMenu.getMenuId().equals(object.getId())) {
						flag = true;
						break;
					}
				}
			}
			
			if (!flag && roleMenus != null) {
				continue;
			}

			JSONObject jsonObject;

			jsonObject = searialMenu(object, roleMenus);
			children.add(jsonObject);
		}
		return children;
	}

	@Override
	public List<Menu> getByParentId(String id) {
		MenuCriteria menuExample = new MenuCriteria();
		menuExample.createCriteria().andParentidEqualTo(id);
		List<Menu> list = menuMapper.selectByExample(menuExample);

		return list;
	}

	@SuppressWarnings("rawtypes")
	public JSONObject searialMenu(Menu menu, List<RoleMenu> roleMenus) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("id", menu.getId());
		jsonObject.put("parentid", menu.getParentid());
		jsonObject.put("name", menu.getName());
		jsonObject.put("url", menu.getUrl());
		jsonObject.put("createdate", menu.getCreatedate());
		jsonObject.put("description", menu.getDescription());
		jsonObject.put("updatedate", menu.getUpdatedate());

		List list = searialChild(menu, roleMenus);
		if (null != list) {
			jsonObject.put("children", list);
		}

		return jsonObject;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List searialChild(Menu menu, List<RoleMenu> roleMenus) {
		List children = null;
		List<Menu> list = getByParentId(menu.getId());
		if (list != null && list.size() > 0) {
			children = new ArrayList();
		}
		for (Menu object : list) {
			boolean flag = false;
			if(roleMenus != null){
				for (RoleMenu roleMenu : roleMenus) {
					if (roleMenu.getMenuId().equals(object.getId())) {
						flag = true;
						break;
					}
				}
			}
			if (!flag && roleMenus != null) {
				continue;
			}

			JSONObject jsonObject = searialMenu(object, roleMenus);
			children.add(jsonObject);
		}
		return children;
	}

}
