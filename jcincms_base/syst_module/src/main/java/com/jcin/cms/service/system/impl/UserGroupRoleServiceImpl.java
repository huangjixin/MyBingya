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

import com.jcin.cms.dao.system.UserGroupRoleMapper;
import com.jcin.cms.domain.system.UserGroupRole;
import com.jcin.cms.domain.system.UserGroupRoleCriteria;
import com.jcin.cms.service.system.IUserGroupRoleService;
import com.jcin.cms.service.impl.BaseServiceImpl;
import com.jcin.cms.utils.Page;

/**
 * @author 黄记新
 * @date 2014-12-18,下午6:56:55
 * 
 */
@Service
public class UserGroupRoleServiceImpl extends BaseServiceImpl<UserGroupRole, String>
		implements IUserGroupRoleService {
	private static Logger logger = Logger.getLogger(UserGroupRoleServiceImpl.class
			.getName());

	@Resource
	private UserGroupRoleMapper userGroupRoleMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.system.IUserGroupRoleService#deleteByPrimaryKey((java.lang
	 * .String ))
	 */
	@Override
	@Transactional
	public int deleteByPrimaryKey(String id) {
		// super.deleteByPrimaryKey(id);

		int result = userGroupRoleMapper.deleteByPrimaryKey(id);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.system.IUserGroupRoleService#insert(com.jcin.cms.service.system.
	 * UserGroupRole)
	 */
	@Override
	@Transactional
	public String insert(UserGroupRole record) {
		 super.insert(record);

		int result = userGroupRoleMapper.insert(record);
		String id = record.getId();
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.system.IUserGroupRoleService#select(com.jcin.cms.utils.Page)
	 */
	@Override
	public Page select(Page page) {
		super.select(page);
		//setOrderByClause("SER_NO  asc , ORG_ID desc");  
		UserGroupRoleCriteria userGroupRoleCriteria = new UserGroupRoleCriteria();
		userGroupRoleCriteria.setOrderByClause("id desc");
		userGroupRoleCriteria.setPage(page);
		@SuppressWarnings("rawtypes")
		List list = userGroupRoleMapper.selectByExample(userGroupRoleCriteria);
		page.setRows(list);
		int total = userGroupRoleMapper.countByExample(userGroupRoleCriteria);
		page.setTotal(total);
		return page;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.system.IUserGroupRoleService#select(com.jcin.cms.service.system.UserGroupRoleCriteria)
	 */
	//@Override
	public Page select(UserGroupRoleCriteria criteria) {
		Page page = new Page();
		@SuppressWarnings("rawtypes")
		List list = userGroupRoleMapper.selectByExample(criteria);
		page.setRows(list);
		int total = userGroupRoleMapper.countByExample(criteria);
		page.setTotal(total);
		return page;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.system.IUserGroupRoleService#selectAll()
	 */
	@Override
	public List<UserGroupRole> selectAll() {
		List<UserGroupRole> list = userGroupRoleMapper.selectByExample(null);
		return list;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.system.IUserGroupRoleService#selectByPrimaryKey(java.lang
	 * .String)
	 */
	@Override
	public UserGroupRole selectByPrimaryKey(String id) {
		super.selectByPrimaryKey(id);

		UserGroupRole article = userGroupRoleMapper.selectByPrimaryKey(id);
		return article;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.system.IUserGroupRoleService#update(com.jcin.cms.service.system.
	 * UserGroupRole)
	 */
	@Override
	@Transactional
	public String update(UserGroupRole record) {
		// super.update(record);
		int result = userGroupRoleMapper.updateByPrimaryKeySelective(record);
		return record.getId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.system.IUserGroupRoleService#insertBatch(List)
	 */
	@Override
	@Transactional
	public int insertBatch(List<UserGroupRole> list) {
		int result = userGroupRoleMapper.insertBatch(list);
		super.insertBatch(list);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.system.IUserGroupRoleService#deleteBatch(List)
	 */
	@Override
	@Transactional
	public int deleteBatch(List<String> list) {
		UserGroupRoleCriteria userGroupRoleCriteria = new UserGroupRoleCriteria();
		userGroupRoleCriteria.createCriteria().andIdIn(list);
		int result = userGroupRoleMapper.deleteByExample(userGroupRoleCriteria);
		super.deleteBatch(list);
		return result;
	}

}
