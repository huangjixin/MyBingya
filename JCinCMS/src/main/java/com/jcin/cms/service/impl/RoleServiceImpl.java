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

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jcin.cms.dao.RoleMapper;
import com.jcin.cms.domain.Role;
import com.jcin.cms.domain.RoleCriteria;
import com.jcin.cms.service.IRoleService;
import com.jcin.cms.utils.Page;

/**
 * @author 黄记新
 * @date 2014-12-18,下午6:56:55
 * 
 */
@Service(value = "roleService")
public class RoleServiceImpl implements IRoleService {
	@Resource
	private RoleMapper roleMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.IRoleService#deleteByPrimaryKey((java.lang.String))
	 */
	@Override
	public int deleteByPrimaryKey(String id) {
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
		RoleCriteria roleCriteria = new RoleCriteria();
		roleCriteria.setPage(page);
		@SuppressWarnings("rawtypes")
		List list = roleMapper.selectByExample(roleCriteria);
		page.setRows(list);
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
		int result = roleMapper.updateByPrimaryKeySelective(record);
		return result;
	}

}