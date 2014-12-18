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
package com.jcin.cms.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jcin.cms.domain.User;
import com.jcin.cms.utils.Page;

/**
 * @author 黄记新
 * @date 2014-12-18,下午6:56:55
 * 
 */
@Service
public class UserServiceImpl implements IUserService {
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.IUserService#deleteByPrimaryKey((java.lang.String))
	 */
	@Override
	public int deleteByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jcin.cms.service.IUserService#insert(com.jcin.cms.domain.User)
	 */
	@Override
	@Transactional
	public int insert(User record) {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jcin.cms.service.IUserService#select(com.jcin.cms.utils.Page)
	 */
	@Override
	public Page select(Page page) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.IUserService#selectByPrimaryKey(java.lang.String)
	 */
	@Override
	public User selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jcin.cms.service.IUserService#update(com.jcin.cms.domain.User)
	 */
	@Override
	@Transactional
	public int update(User record) {
		// TODO Auto-generated method stub
		return 0;
	}

}
