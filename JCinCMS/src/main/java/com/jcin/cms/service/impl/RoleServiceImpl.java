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

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jcin.cms.dao.RoleMapper;
import com.jcin.cms.dao.UserMapper;
import com.jcin.cms.dao.UserRoleMapper;
import com.jcin.cms.domain.Role;
import com.jcin.cms.domain.RoleCriteria;
import com.jcin.cms.domain.User;
import com.jcin.cms.domain.UserCriteria;
import com.jcin.cms.domain.UserRole;
import com.jcin.cms.domain.UserRoleCriteria;
import com.jcin.cms.service.IRoleService;
import com.jcin.cms.utils.Page;

/**
 * @author 黄记新
 * @date 2014-12-18,下午6:56:55
 * 
 */
@Service(value = "roleService")
public class RoleServiceImpl extends BaseServiceImpl<Role, String> implements
		IRoleService {
	private static Logger logger = Logger.getLogger(RoleServiceImpl.class
			.getName());

	@Resource
	private UserMapper userMapper;

	@Resource
	private UserRoleMapper userRoleMapper;

	@Resource
	private RoleMapper roleMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.IRoleService#deleteByPrimaryKey((java.lang.String))
	 */
	@Override
	@Transactional
	public int deleteByPrimaryKey(String id) {
		super.deleteByPrimaryKey(id);

		int result = roleMapper.deleteByPrimaryKey(id);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jcin.cms.service.IRoleService#insert(com.jcin.cms.domain.Role)
	 */
	@Override
	@Transactional
	public int insert(Role record) {
		super.insert(record);

		// record.setCreatedate(new Date());
		// record.setId(new Date().getTime() + "");
		int result = roleMapper.insert(record);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jcin.cms.service.IRoleService#select(com.jcin.cms.utils.Page)
	 */
	@Override
	public Page select(Page page) {
		super.select(page);

		RoleCriteria roleCriteria = new RoleCriteria();
		roleCriteria.setPage(page);
		@SuppressWarnings("rawtypes")
		List list = roleMapper.selectByExample(roleCriteria);
		page.setRows(list);
		int total = roleMapper.countByExample(roleCriteria);
		page.setTotal(total);
		return page;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.IRoleService#select(com.jcin.cms.domain.RoleCriteria
	 * )
	 */
	@Override
	public Page select(RoleCriteria criteria) {
		Page page = new Page();
		@SuppressWarnings("rawtypes")
		List list = roleMapper.selectByExample(criteria);
		page.setRows(list);
		int total = roleMapper.countByExample(criteria);
		page.setTotal(total);
		return page;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.IRoleService#selectByPrimaryKey(java.lang.String)
	 */
	@Override
	public Role selectByPrimaryKey(String id) {
		super.selectByPrimaryKey(id);

		Role role = roleMapper.selectByPrimaryKey(id);
		return role;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jcin.cms.service.IRoleService#update(com.jcin.cms.domain.Role)
	 */
	@Override
	@Transactional
	public int update(Role record) {
		super.update(record);

		int result = roleMapper.updateByPrimaryKeySelective(record);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jcin.cms.service.IRoleService#getUsesByRoleId(String)
	 */
	@Override
	public List<User> getUsesByRoleId(String id) {
		UserRoleCriteria userRoleCriteria = new UserRoleCriteria();
		userRoleCriteria.createCriteria().andRoleIdEqualTo(id);
		List<UserRole> userRoles = userRoleMapper
				.selectByExample(userRoleCriteria);
		List<User> users = null;

		for (UserRole userRole : userRoles) {
			UserCriteria userCriteria = new UserCriteria();
			userCriteria.createCriteria().andIdEqualTo(userRole.getUserId());
			if (users == null) {
				users = userMapper.selectByExample(userCriteria);
			} else {
				users.addAll(userMapper.selectByExample(userCriteria));
			}
		}

		return users;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.IRoleService#insertBatch(List)
	 */
	@Override
	public int insertBatch(List<Role> list) {
		int result = roleMapper.insertBatch(list);
		super.insertBatch(list);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.IRoleService#deleteBatch(List)
	 */
	@Override
	public int deleteBatch(List<String> list) {
		int result = roleMapper.deleteBatch(list);
		super.deleteBatch(list);
		return result;
	}
}
