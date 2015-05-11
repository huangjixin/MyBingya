/**
 * 一句话描述该类：<br/>
 * @author 黄记新
 * @date 2015-4-26,下午6:56:55
 *
 */
package com.jcin.cms.service.system.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jcin.cms.dao.system.RoleMapper;
import com.jcin.cms.domain.system.Role;
import com.jcin.cms.domain.system.RoleCriteria;
import com.jcin.cms.service.system.IRoleService;
import com.jcin.cms.service.impl.BaseServiceImpl;
import com.jcin.cms.utils.Page;

/**
 * @author 黄记新
 * @date 2014-12-18,下午6:56:55
 * 
 */
@Service
public class RoleServiceImpl extends BaseServiceImpl<Role, String>
		implements IRoleService {
	private static Logger logger = Logger.getLogger(RoleServiceImpl.class
			.getName());

	@Resource
	private RoleMapper roleMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.system.IRoleService#deleteByPrimaryKey((java.lang
	 * .String ))
	 */
	@Override
	@Transactional
	public int deleteByPrimaryKey(String id) {
		// super.deleteByPrimaryKey(id);

		int result = roleMapper.deleteByPrimaryKey(id);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.system.IRoleService#insert(com.jcin.cms.service.system.
	 * Role)
	 */
	@Override
	@Transactional
	public String insert(Role record) {
		 super.insert(record);

//		record.setCreatedate(new Date()+"");
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
		//setOrderByClause("SER_NO  asc , ORG_ID desc");  
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
	 * com.jcin.cms.service.system.IRoleService#select(com.jcin.cms.service.system.RoleCriteria)
	 */
	//@Override
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
	 * com.jcin.cms.service.system.IRoleService#selectAll()
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
	 * com.jcin.cms.service.system.IRoleService#update(com.jcin.cms.service.system.
	 * Role)
	 */
	@Override
	@Transactional
	public String update(Role record) {
		// super.update(record);

		int result = roleMapper.updateByPrimaryKeySelective(record);
		return record.getId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.system.IRoleService#insertBatch(List)
	 */
	@Override
	@Transactional
	public int insertBatch(List<Role> list) {
		int result = roleMapper.insertBatch(list);
		super.insertBatch(list);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.system.IRoleService#deleteBatch(List)
	 */
	@Override
	@Transactional
	public int deleteBatch(List<String> list) {
		RoleCriteria roleCriteria = new RoleCriteria();
		roleCriteria.createCriteria().andIdIn(list);
		int result = roleMapper.deleteByExample(roleCriteria);
		super.deleteBatch(list);
		return result;
	}

}
