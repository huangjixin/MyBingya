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

import com.jcin.cms.dao.UserMapper;
import com.jcin.cms.domain.User;
import com.jcin.cms.domain.UserCriteria;
import com.jcin.cms.service.IUserService;
import com.jcin.cms.utils.Page;

/**
 * @author 黄记新
 * @date 2014-12-18,下午6:56:55
 * 
 */
@Service(value = "userService")
public class UserServiceImpl implements IUserService {
	private static Logger logger = Logger.getLogger(UserServiceImpl.class.getName());
	
	@Resource
	private UserMapper userMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.IUserService#deleteByPrimaryKey((java.lang.String))
	 */
	@Override
	public int deleteByPrimaryKey(String id) {
		int result = userMapper.deleteByPrimaryKey(id);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jcin.cms.service.IUserService#insert(com.jcin.cms.domain.User)
	 */
	@Override
	@Transactional
	public int insert(User record) {
		int result = userMapper.insert(record);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jcin.cms.service.IUserService#select(com.jcin.cms.utils.Page)
	 */
	@Override
	public Page select(Page page) {
		UserCriteria userCriteria = new UserCriteria();
		userCriteria.setPage(page);
		@SuppressWarnings("rawtypes")
		List list = userMapper.selectByExample(userCriteria);
		page.setRows(list);
		return page;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.IUserService#selectByPrimaryKey(java.lang.String)
	 */
	@Override
	public User selectByPrimaryKey(String id) {
		User user = userMapper.selectByPrimaryKey(id);
		return user;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jcin.cms.service.IUserService#update(com.jcin.cms.domain.User)
	 */
	@Override
	@Transactional
	public int update(User record) {
		int result = userMapper.updateByPrimaryKeySelective(record);
		return result;
	}

}
