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

import com.jcin.cms.dao.system.RoleAuthorizationMapper;
import com.jcin.cms.domain.system.RoleAuthorization;
import com.jcin.cms.domain.system.RoleAuthorizationCriteria;
import com.jcin.cms.service.system.IRoleAuthorizationService;
import com.jcin.cms.service.impl.BaseServiceImpl;
import com.jcin.cms.utils.Page;

/**
 * @author 黄记新
 * @date 2014-12-18,下午6:56:55
 * 
 */
@Service
public class RoleAuthorizationServiceImpl extends BaseServiceImpl<RoleAuthorization, String>
		implements IRoleAuthorizationService {
	private static Logger logger = Logger.getLogger(RoleAuthorizationServiceImpl.class
			.getName());

	@Resource
	private RoleAuthorizationMapper roleAuthorizationMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.system.IRoleAuthorizationService#deleteByPrimaryKey((java.lang
	 * .String ))
	 */
	@Override
	@Transactional
	public int deleteByPrimaryKey(String id) {
		// super.deleteByPrimaryKey(id);

		int result = roleAuthorizationMapper.deleteByPrimaryKey(id);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.system.IRoleAuthorizationService#insert(com.jcin.cms.service.system.
	 * RoleAuthorization)
	 */
	@Override
	@Transactional
	public String insert(RoleAuthorization record) {
		 super.insert(record);

//		record.setCreatedate(new Date()+"");
		int result = roleAuthorizationMapper.insert(record);
		String id = record.getId();
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.system.IRoleAuthorizationService#select(com.jcin.cms.utils.Page)
	 */
	@Override
	public Page select(Page page) {
		super.select(page);
		//setOrderByClause("SER_NO  asc , ORG_ID desc");  
		RoleAuthorizationCriteria roleAuthorizationCriteria = new RoleAuthorizationCriteria();
		roleAuthorizationCriteria.setOrderByClause("id desc");
		roleAuthorizationCriteria.setPage(page);
		@SuppressWarnings("rawtypes")
		List list = roleAuthorizationMapper.selectByExample(roleAuthorizationCriteria);
		page.setRows(list);
		int total = roleAuthorizationMapper.countByExample(roleAuthorizationCriteria);
		page.setTotal(total);
		return page;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.system.IRoleAuthorizationService#select(com.jcin.cms.service.system.RoleAuthorizationCriteria)
	 */
	//@Override
	public Page select(RoleAuthorizationCriteria criteria) {
		Page page = new Page();
		@SuppressWarnings("rawtypes")
		List list = roleAuthorizationMapper.selectByExample(criteria);
		page.setRows(list);
		int total = roleAuthorizationMapper.countByExample(criteria);
		page.setTotal(total);
		return page;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.system.IRoleAuthorizationService#selectAll()
	 */
	@Override
	public List<RoleAuthorization> selectAll() {
		List<RoleAuthorization> list = roleAuthorizationMapper.selectByExample(null);
		return list;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.system.IRoleAuthorizationService#selectByPrimaryKey(java.lang
	 * .String)
	 */
	@Override
	public RoleAuthorization selectByPrimaryKey(String id) {
		super.selectByPrimaryKey(id);

		RoleAuthorization article = roleAuthorizationMapper.selectByPrimaryKey(id);
		return article;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.system.IRoleAuthorizationService#update(com.jcin.cms.service.system.
	 * RoleAuthorization)
	 */
	@Override
	@Transactional
	public String update(RoleAuthorization record) {
		// super.update(record);

		int result = roleAuthorizationMapper.updateByPrimaryKeySelective(record);
		return record.getId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.system.IRoleAuthorizationService#insertBatch(List)
	 */
	@Override
	@Transactional
	public int insertBatch(List<RoleAuthorization> list) {
		int result = roleAuthorizationMapper.insertBatch(list);
		super.insertBatch(list);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.system.IRoleAuthorizationService#deleteBatch(List)
	 */
	@Override
	@Transactional
	public int deleteBatch(List<String> list) {
		RoleAuthorizationCriteria roleAuthorizationCriteria = new RoleAuthorizationCriteria();
		roleAuthorizationCriteria.createCriteria().andIdIn(list);
		int result = roleAuthorizationMapper.deleteByExample(roleAuthorizationCriteria);
		super.deleteBatch(list);
		return result;
	}

}
