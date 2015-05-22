/**
 * 一句话描述该类：<br/>
 * @author 黄记新
 * @date 2015-4-26,下午6:56:55
 *
 */
package com.jcin.cms.service.system.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jcin.cms.dao.system.UserRoleMapper;
import com.jcin.cms.domain.system.UserRole;
import com.jcin.cms.domain.system.UserRoleCriteria;
import com.jcin.cms.service.system.IUserRoleService;
import com.jcin.cms.service.impl.BaseServiceImpl;
import com.jcin.cms.utils.Page;

/**
 * @author 黄记新
 * @date 2014-12-18,下午6:56:55
 * 
 */
@Service
public class UserRoleServiceImpl extends BaseServiceImpl<UserRole, String>
		implements IUserRoleService {
	private static Logger logger = Logger.getLogger(UserRoleServiceImpl.class
			.getName());

	@Resource
	private UserRoleMapper userRoleMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.system.IUserRoleService#deleteByPrimaryKey((java.lang
	 * .String ))
	 */
	@Override
	@Transactional
	public int deleteByPrimaryKey(String id) {
		// super.deleteByPrimaryKey(id);

		int result = userRoleMapper.deleteByPrimaryKey(id);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.system.IUserRoleService#insert(com.jcin.cms.service.system.
	 * UserRole)
	 */
	@Override
	@Transactional
	public String insert(UserRole record) {
		 super.insert(record);

		int result = userRoleMapper.insert(record);
		String id = record.getId();
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.system.IUserRoleService#select(com.jcin.cms.utils.Page)
	 */
	@Override
	public Page select(Page page) {
		super.select(page);
		//setOrderByClause("SER_NO  asc , ORG_ID desc");  
		UserRoleCriteria userRoleCriteria = new UserRoleCriteria();
		userRoleCriteria.setOrderByClause("id desc");
		userRoleCriteria.setPage(page);
		@SuppressWarnings("rawtypes")
		List list = userRoleMapper.selectByExample(userRoleCriteria);
		page.setRows(list);
		int total = userRoleMapper.countByExample(userRoleCriteria);
		page.setTotal(total);
		return page;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.system.IUserRoleService#select(com.jcin.cms.service.system.UserRoleCriteria)
	 */
	//@Override
	public Page select(UserRoleCriteria criteria) {
		Page page = new Page();
		@SuppressWarnings("rawtypes")
		List list = userRoleMapper.selectByExample(criteria);
		page.setRows(list);
		int total = userRoleMapper.countByExample(criteria);
		page.setTotal(total);
		return page;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.system.IUserRoleService#selectAll()
	 */
	@Override
	public List<UserRole> selectAll() {
		List<UserRole> list = userRoleMapper.selectByExample(null);
		return list;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.system.IUserRoleService#selectByPrimaryKey(java.lang
	 * .String)
	 */
	@Override
	public UserRole selectByPrimaryKey(String id) {
		super.selectByPrimaryKey(id);

		UserRole article = userRoleMapper.selectByPrimaryKey(id);
		return article;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.system.IUserRoleService#update(com.jcin.cms.service.system.
	 * UserRole)
	 */
	@Override
	@Transactional
	public String update(UserRole record) {
		// super.update(record);
		int result = userRoleMapper.updateByPrimaryKeySelective(record);
		return record.getId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.system.IUserRoleService#insertBatch(List)
	 */
	@Override
	@Transactional
	public int insertBatch(List<UserRole> list) {
		int result = userRoleMapper.insertBatch(list);
		super.insertBatch(list);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.system.IUserRoleService#deleteBatch(List)
	 */
	@Override
	@Transactional
	public int deleteBatch(List<String> list) {
		UserRoleCriteria userRoleCriteria = new UserRoleCriteria();
		userRoleCriteria.createCriteria().andIdIn(list);
		int result = userRoleMapper.deleteByExample(userRoleCriteria);
		super.deleteBatch(list);
		return result;
	}

}
