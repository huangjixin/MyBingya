/**
 * 一句话描述该类：用户实现类<br/>
 * @author 黄记新
 * @date 2015-4-26,下午6:56:55
 *
 */
package com.jcin.cms.modules.syst.service.impl;

import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jcin.cms.modules.syst.dao.RoleMapper;
import com.jcin.cms.modules.syst.dao.RoleResourceMapper;
import com.jcin.cms.modules.syst.dao.UserRoleMapper;
import com.jcin.cms.modules.syst.domain.Role;
import com.jcin.cms.modules.syst.domain.RoleCriteria;
import com.jcin.cms.modules.syst.domain.RoleResource;
import com.jcin.cms.modules.syst.domain.RoleResourceCriteria;
import com.jcin.cms.modules.syst.domain.UserRole;
import com.jcin.cms.modules.syst.domain.UserRoleCriteria;
import com.jcin.cms.modules.syst.service.IRoleService;
import com.jcin.cms.service.impl.BaseServiceImpl;
import com.jcin.cms.utils.Page;

/**
 * @author 黄记新
 * @date 2014-12-18,下午6:56:55
 * 
 */
@Service(value="roleService")
public class RoleServiceImpl extends BaseServiceImpl<Role, String> implements
		IRoleService {
	private static Logger logger = Logger.getLogger(RoleServiceImpl.class
			.getName());

	@javax.annotation.Resource
	private RoleMapper roleMapper;
	@javax.annotation.Resource
	private UserRoleMapper userRoleMapper;
	@javax.annotation.Resource
	private RoleResourceMapper roleResourceMapper;
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.system.IRoleService#deleteByPrimaryKey((java.lang
	 * .String ))
	 */
	@Override
	@Transactional(readOnly = false)
	public int deleteByPrimaryKey(String id) {
		// super.deleteByPrimaryKey(id);

		int result = roleMapper.deleteByPrimaryKey(id);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.system.IRoleService#insert(com.jcin.cms.service.
	 * system. Role)
	 */
	@Override
	@Transactional(readOnly = false)
	public String insert(Role record) {
		super.insert(record);

//		record.setCreateDate(new Date());
		int result = roleMapper.insert(record);
		String id = record.getId();
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.system.IRoleService#select(com.jcin.cms.utils.Page)
	 */
	@Override
	public Page select(Page page) {
		super.select(page);
		// setOrderByClause("SER_NO  asc , ORG_ID desc");
		RoleCriteria roleCriteria = new RoleCriteria();
		roleCriteria.setOrderByClause("id desc");
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
	 * com.jcin.cms.service.system.IRoleService#select(com.jcin.cms.service.
	 * system.RoleCriteria)
	 */
	// @Override
	public Page select(RoleCriteria criteria) {
		Page page = new Page();
		if(null != criteria){
			if(null != criteria.getPage()){
				page = criteria.getPage();
			}
		}
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
	 * @see com.jcin.cms.service.system.IRoleService#selectAll()
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
	 * com.jcin.cms.service.system.IRoleService#selectByPrimaryKey(java.lang
	 * .String)
	 */
	@Override
	public Role selectByPrimaryKey(String id) {
		super.selectByPrimaryKey(id);

		Role article = roleMapper.selectByPrimaryKey(id);
		return article;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.system.IRoleService#update(com.jcin.cms.service.
	 * system. Role)
	 */
	@Override
	@Transactional(readOnly = false)
	public String update(Role record) {
		// super.update(record);
//		record.setUpdateDate(new Date());
		int result = roleMapper.updateByPrimaryKeySelective(record);
		return record.getId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jcin.cms.service.system.IRoleService#insertBatch(List)
	 */
	@Override
	@Transactional(readOnly = false)
	public int insertBatch(List<Role> list) {
		int result = roleMapper.insertBatch(list);
		super.insertBatch(list);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jcin.cms.service.system.IRoleService#deleteBatch(List)
	 */
	@Override
	@Transactional(readOnly = false)
	public int deleteBatch(List<String> list) {
		RoleCriteria roleCriteria = new RoleCriteria();
		roleCriteria.createCriteria().andIdIn(list);
		int result = roleMapper.deleteByExample(roleCriteria);
		super.deleteBatch(list);
		return result;
	}

	@Override
	public List<Role> selectByUsername(String username) {
		List<Role> roles = roleMapper.selectByUsername(username);
		return roles;
	}

	@Override
	@Transactional(readOnly = false)
	public void updateUserRole(String roleId, String oldUserId, String newUserId) {
		UserRoleCriteria userRoleCriteria = new UserRoleCriteria();
		userRoleCriteria.createCriteria().andUserIdEqualTo(oldUserId).andTbRoleIdEqualTo(roleId);
		List<UserRole>userRoles = userRoleMapper.selectByExample(userRoleCriteria);
		if(null != userRoles && userRoles.size()>0){
			UserRole userRole  = userRoles.get(0);
			userRole.setUserId(newUserId);
			userRoleMapper.updateByPrimaryKey(userRole);
		}
	}

	@Override
	@Transactional(readOnly = false)
	public void connectRoleResource(String roleId, List<String> resourceIds) {
		RoleResourceCriteria roleResourceCriteria = new RoleResourceCriteria();
		roleResourceCriteria.createCriteria().andRoleIdEqualTo(roleId);
		roleResourceMapper.deleteByExample(roleResourceCriteria);
		
		for (int i = 0; i < resourceIds.size(); i++) {
			String resourceId = resourceIds.get(i);
			RoleResource roleResource2 = new RoleResource();
			roleResource2.setId(UUID.randomUUID().toString());
			roleResource2.setResourceId(resourceId);
			roleResource2.setRoleId(roleId);
			roleResourceMapper.insert(roleResource2);
		}
	}
}
