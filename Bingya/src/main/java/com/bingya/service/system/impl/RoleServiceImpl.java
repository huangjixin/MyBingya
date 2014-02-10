/**
 * 
 */
package com.bingya.service.system.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.json.JSONObject;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bingya.dao.system.MenuMapper;
import com.bingya.dao.system.RoleMapper;
import com.bingya.dao.system.RoleMenuMapper;
import com.bingya.dao.system.UserRoleMapper;
import com.bingya.domain.system.Menu;
import com.bingya.domain.system.MenuExample;
import com.bingya.domain.system.Role;
import com.bingya.domain.system.RoleExample;
import com.bingya.domain.system.RoleMenu;
import com.bingya.domain.system.RoleMenuExample;
import com.bingya.domain.system.UserRole;
import com.bingya.domain.system.UserRoleExample;
import com.bingya.service.system.IMenuService;
import com.bingya.service.system.IRoleService;
import com.bingya.util.Page;

/**
 * @author huangjixin
 * 
 */
@Transactional
@Service
@RemotingDestination(value = "roleServiceImpl", channels = { "my-amf" })
public class RoleServiceImpl implements IRoleService {
	@Resource
	private RoleMapper roleMapper;
	@Resource
	private UserRoleMapper userRoleMapper;
	@Resource
	private RoleMenuMapper roleMenuMapper;
	@Resource
	private MenuMapper menuMapper;
	@Resource
	private IMenuService menuService;

	/*
	 * 删除角色。
	 * 
	 * @see
	 * com.bingya.service.system.IGenericService#deleteByPrimaryKey(java.lang
	 * .Integer)
	 */
	@Override
	public int deleteByPrimaryKey(String id) {
		// --先删除子表数据。
		// --角色用户。
		UserRoleExample userRoleExample = new UserRoleExample();
		userRoleExample.createCriteria().andRoleIdEqualTo(id);
		List<UserRole> userRoles = userRoleMapper
				.selectByExample(userRoleExample);
		for (UserRole userRole : userRoles) {
			userRoleMapper.deleteByPrimaryKey(userRole.getId());
		}

		// --角色
		RoleMenuExample roleMenuExample = new RoleMenuExample();
		roleMenuExample.createCriteria().andRoleIdEqualTo(id);
		List<RoleMenu> roleMenus = roleMenuMapper
				.selectByExample(roleMenuExample);
		for (RoleMenu roleMenu : roleMenus) {
			roleMenuMapper.deleteByPrimaryKey(roleMenu.getId());
		}

		int i = roleMapper.deleteByPrimaryKey(id);
		return i;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bingya.service.system.IGenericService#insert(java.io.Serializable)
	 */
	@Override
	public String insert(Role entity) {
		int i = roleMapper.insertSelective(entity);
		return entity.getId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bingya.service.system.IGenericService#selectAll()
	 */
	@Override
	public List<Role> selectAll() {
		List<Role> list = roleMapper.selectByExample(null);
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bingya.service.system.IGenericService#selectByPrimaryKey(java.lang
	 * .Integer)
	 */
	@Override
	public Role selectByPrimaryKey(String id) {
		Role role = roleMapper.selectByPrimaryKey(id);
		return role;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bingya.service.system.IGenericService#update(java.io.Serializable)
	 */
	@Override
	public String update(Role entity) {
		int i = roleMapper.updateByPrimaryKey(entity);
		return i + "";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bingya.service.system.IGenericService#query(com.bingya.util.Page,
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public Page query(Page page, String key, String orderCondition) {
		key = "%" + key + "%";
		RoleExample roleExample = new RoleExample();
		// roleExample.createCriteria().andDescriptionLike(key);
		roleExample.setPage(page);
		int total = roleMapper.countByExample(roleExample);
		page.setTotal(total);
		List<Role> list = roleMapper.selectByExample(roleExample);
		page.setRows(list);
		return page;
	}

	// ---------------------------------------------------
	// 常量（全部大写，用下划线分割），变量 （先常后私）
	// ---------------------------------------------------

	@Override
	public List getMenusById(String id) {
		List list = menuService.getMenuTreeByRoleId(id);
		return list;
	}

	@Override
	public String getMenusXMLById(String id) {
		String str = menuService.serializMenuToXml(id);
		return str;
	}

	@Override
	public Role getRoleByUserid(String userId) {
		UserRoleExample userRoleExample = new UserRoleExample();
		userRoleExample.createCriteria().andUserIdEqualTo(userId);
		List<UserRole> userRoles = userRoleMapper
				.selectByExample(userRoleExample);
		if (null == userRoles || userRoles.size() == 0) {
			return null;
		} else {
			UserRole userRole = userRoles.get(0);
			Role role = roleMapper.selectByPrimaryKey(userRole.getRoleId());
			return role;
		}
	}

	// ---------------------------------------------------
	// public 公有方法
	// ---------------------------------------------------

	// ---------------------------------------------------
	// protected 方法
	// ---------------------------------------------------

	// ---------------------------------------------------
	// private 私有方法
	// ---------------------------------------------------
}
