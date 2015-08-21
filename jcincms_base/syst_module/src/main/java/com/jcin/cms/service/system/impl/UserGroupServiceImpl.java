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

import com.jcin.cms.dao.system.RoleMapper;
import com.jcin.cms.dao.system.UserGroupMapper;
import com.jcin.cms.domain.system.Role;
import com.jcin.cms.domain.system.UserGroup;
import com.jcin.cms.domain.system.UserGroupCriteria;
import com.jcin.cms.service.system.IUserGroupService;
import com.jcin.cms.service.impl.BaseServiceImpl;
import com.jcin.cms.utils.Page;

/**
 * @author 黄记新
 * @date 2014-12-18,下午6:56:55
 * 
 */
@Service
public class UserGroupServiceImpl extends BaseServiceImpl<UserGroup, String>
		implements IUserGroupService {
	private static Logger logger = Logger.getLogger(UserGroupServiceImpl.class
			.getName());

	@Resource
	private UserGroupMapper userGroupMapper;
	
	@Resource
	private RoleMapper roleMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.system.IUserGroupService#deleteByPrimaryKey((java.lang
	 * .String ))
	 */
	@Override
	@Transactional
	public int deleteByPrimaryKey(String id) {
		// super.deleteByPrimaryKey(id);

		int result = userGroupMapper.deleteByPrimaryKey(id);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.system.IUserGroupService#insert(com.jcin.cms.service.system.
	 * UserGroup)
	 */
	@Override
	@Transactional
	public String insert(UserGroup record) {
		 super.insert(record);

		record.setCreateDate(new Date());
		int result = userGroupMapper.insert(record);
		String id = record.getId();
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.system.IUserGroupService#select(com.jcin.cms.utils.Page)
	 */
	@Override
	public Page select(Page page) {
		super.select(page);
		//setOrderByClause("SER_NO  asc , ORG_ID desc");  
		UserGroupCriteria userGroupCriteria = new UserGroupCriteria();
		userGroupCriteria.setOrderByClause("id desc");
		userGroupCriteria.setPage(page);
		@SuppressWarnings("rawtypes")
		List list = userGroupMapper.selectByExample(userGroupCriteria);
		page.setRows(list);
		int total = userGroupMapper.countByExample(userGroupCriteria);
		page.setTotal(total);
		return page;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.system.IUserGroupService#select(com.jcin.cms.service.system.UserGroupCriteria)
	 */
	//@Override
	public Page select(UserGroupCriteria criteria) {
		Page page = new Page();
		@SuppressWarnings("rawtypes")
		List list = userGroupMapper.selectByExample(criteria);
		page.setRows(list);
		int total = userGroupMapper.countByExample(criteria);
		page.setTotal(total);
		return page;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.system.IUserGroupService#selectAll()
	 */
	@Override
	public List<UserGroup> selectAll() {
		List<UserGroup> list = userGroupMapper.selectByExample(null);
		return list;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.system.IUserGroupService#selectByPrimaryKey(java.lang
	 * .String)
	 */
	@Override
	public UserGroup selectByPrimaryKey(String id) {
		super.selectByPrimaryKey(id);

		UserGroup article = userGroupMapper.selectByPrimaryKey(id);
		return article;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.system.IUserGroupService#update(com.jcin.cms.service.system.
	 * UserGroup)
	 */
	@Override
	@Transactional
	public String update(UserGroup record) {
		// super.update(record);
		record.setUpdateDate(new Date());
		int result = userGroupMapper.updateByPrimaryKeySelective(record);
		return record.getId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.system.IUserGroupService#insertBatch(List)
	 */
	@Override
	@Transactional
	public int insertBatch(List<UserGroup> list) {
		int result = userGroupMapper.insertBatch(list);
		super.insertBatch(list);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.system.IUserGroupService#deleteBatch(List)
	 */
	@Override
	@Transactional
	public int deleteBatch(List<String> list) {
		UserGroupCriteria userGroupCriteria = new UserGroupCriteria();
		userGroupCriteria.createCriteria().andIdIn(list);
		int result = userGroupMapper.deleteByExample(userGroupCriteria);
		super.deleteBatch(list);
		return result;
	}

	@Override
	public List<Role> getRoleByUserGroupID(String userGroupID) {
		List<Role> list = roleMapper.getRoleByUserGroupID(userGroupID);
		return list;
	}

}
