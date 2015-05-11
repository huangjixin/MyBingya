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

import com.jcin.cms.dao.system.UserMapper;
import com.jcin.cms.domain.system.User;
import com.jcin.cms.domain.system.UserCriteria;
import com.jcin.cms.service.system.IUserService;
import com.jcin.cms.service.impl.BaseServiceImpl;
import com.jcin.cms.utils.Page;

/**
 * @author 黄记新
 * @date 2014-12-18,下午6:56:55
 * 
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User, String>
		implements IUserService {
	private static Logger logger = Logger.getLogger(UserServiceImpl.class
			.getName());

	@Resource
	private UserMapper userMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.system.IUserService#deleteByPrimaryKey((java.lang
	 * .String ))
	 */
	@Override
	@Transactional
	public int deleteByPrimaryKey(String id) {
		// super.deleteByPrimaryKey(id);

		int result = userMapper.deleteByPrimaryKey(id);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.system.IUserService#insert(com.jcin.cms.service.system.
	 * User)
	 */
	@Override
	@Transactional
	public String insert(User record) {
		 super.insert(record);

//		record.setCreatedate(new Date()+"");
		int result = userMapper.insert(record);
		String id = record.getId();
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.system.IUserService#select(com.jcin.cms.utils.Page)
	 */
	@Override
	public Page select(Page page) {
		super.select(page);
		//setOrderByClause("SER_NO  asc , ORG_ID desc");  
		UserCriteria userCriteria = new UserCriteria();
		userCriteria.setOrderByClause("id desc");
		userCriteria.setPage(page);
		@SuppressWarnings("rawtypes")
		List list = userMapper.selectByExample(userCriteria);
		page.setRows(list);
		int total = userMapper.countByExample(userCriteria);
		page.setTotal(total);
		return page;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.system.IUserService#select(com.jcin.cms.service.system.UserCriteria)
	 */
	//@Override
	public Page select(UserCriteria criteria) {
		Page page = new Page();
		@SuppressWarnings("rawtypes")
		List list = userMapper.selectByExample(criteria);
		page.setRows(list);
		int total = userMapper.countByExample(criteria);
		page.setTotal(total);
		return page;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.system.IUserService#selectAll()
	 */
	@Override
	public List<User> selectAll() {
		List<User> list = userMapper.selectByExample(null);
		return list;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.system.IUserService#selectByPrimaryKey(java.lang
	 * .String)
	 */
	@Override
	public User selectByPrimaryKey(String id) {
		super.selectByPrimaryKey(id);

		User article = userMapper.selectByPrimaryKey(id);
		return article;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.system.IUserService#update(com.jcin.cms.service.system.
	 * User)
	 */
	@Override
	@Transactional
	public String update(User record) {
		// super.update(record);

		int result = userMapper.updateByPrimaryKeySelective(record);
		return record.getId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.system.IUserService#insertBatch(List)
	 */
	@Override
	@Transactional
	public int insertBatch(List<User> list) {
		int result = userMapper.insertBatch(list);
		super.insertBatch(list);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.system.IUserService#deleteBatch(List)
	 */
	@Override
	@Transactional
	public int deleteBatch(List<String> list) {
		UserCriteria userCriteria = new UserCriteria();
		userCriteria.createCriteria().andIdIn(list);
		int result = userMapper.deleteByExample(userCriteria);
		super.deleteBatch(list);
		return result;
	}

}
