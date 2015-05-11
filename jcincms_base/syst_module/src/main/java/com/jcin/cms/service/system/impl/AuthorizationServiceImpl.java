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

import com.jcin.cms.dao.system.AuthorizationMapper;
import com.jcin.cms.domain.system.Authorization;
import com.jcin.cms.domain.system.AuthorizationCriteria;
import com.jcin.cms.service.system.IAuthorizationService;
import com.jcin.cms.service.impl.BaseServiceImpl;
import com.jcin.cms.utils.Page;

/**
 * @author 黄记新
 * @date 2014-12-18,下午6:56:55
 * 
 */
@Service
public class AuthorizationServiceImpl extends BaseServiceImpl<Authorization, String>
		implements IAuthorizationService {
	private static Logger logger = Logger.getLogger(AuthorizationServiceImpl.class
			.getName());

	@Resource
	private AuthorizationMapper authorizationMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.system.IAuthorizationService#deleteByPrimaryKey((java.lang
	 * .String ))
	 */
	@Override
	@Transactional
	public int deleteByPrimaryKey(String id) {
		// super.deleteByPrimaryKey(id);

		int result = authorizationMapper.deleteByPrimaryKey(id);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.system.IAuthorizationService#insert(com.jcin.cms.service.system.
	 * Authorization)
	 */
	@Override
	@Transactional
	public String insert(Authorization record) {
		 super.insert(record);

//		record.setCreatedate(new Date()+"");
		int result = authorizationMapper.insert(record);
		String id = record.getId();
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.system.IAuthorizationService#select(com.jcin.cms.utils.Page)
	 */
	@Override
	public Page select(Page page) {
		super.select(page);
		//setOrderByClause("SER_NO  asc , ORG_ID desc");  
		AuthorizationCriteria authorizationCriteria = new AuthorizationCriteria();
		authorizationCriteria.setOrderByClause("id desc");
		authorizationCriteria.setPage(page);
		@SuppressWarnings("rawtypes")
		List list = authorizationMapper.selectByExample(authorizationCriteria);
		page.setRows(list);
		int total = authorizationMapper.countByExample(authorizationCriteria);
		page.setTotal(total);
		return page;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.system.IAuthorizationService#select(com.jcin.cms.service.system.AuthorizationCriteria)
	 */
	//@Override
	public Page select(AuthorizationCriteria criteria) {
		Page page = new Page();
		@SuppressWarnings("rawtypes")
		List list = authorizationMapper.selectByExample(criteria);
		page.setRows(list);
		int total = authorizationMapper.countByExample(criteria);
		page.setTotal(total);
		return page;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.system.IAuthorizationService#selectAll()
	 */
	@Override
	public List<Authorization> selectAll() {
		List<Authorization> list = authorizationMapper.selectByExample(null);
		return list;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.system.IAuthorizationService#selectByPrimaryKey(java.lang
	 * .String)
	 */
	@Override
	public Authorization selectByPrimaryKey(String id) {
		super.selectByPrimaryKey(id);

		Authorization article = authorizationMapper.selectByPrimaryKey(id);
		return article;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.system.IAuthorizationService#update(com.jcin.cms.service.system.
	 * Authorization)
	 */
	@Override
	@Transactional
	public String update(Authorization record) {
		// super.update(record);

		int result = authorizationMapper.updateByPrimaryKeySelective(record);
		return record.getId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.system.IAuthorizationService#insertBatch(List)
	 */
	@Override
	@Transactional
	public int insertBatch(List<Authorization> list) {
		int result = authorizationMapper.insertBatch(list);
		super.insertBatch(list);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.system.IAuthorizationService#deleteBatch(List)
	 */
	@Override
	@Transactional
	public int deleteBatch(List<String> list) {
		AuthorizationCriteria authorizationCriteria = new AuthorizationCriteria();
		authorizationCriteria.createCriteria().andIdIn(list);
		int result = authorizationMapper.deleteByExample(authorizationCriteria);
		super.deleteBatch(list);
		return result;
	}

}
