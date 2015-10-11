/**
 * 一句话描述该类：<br/>
 * @author 黄记新
 * @date 2015-4-26,下午6:56:55
 *
 */
package com.jcin.cms.modules.syst.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jcin.cms.modules.syst.dao.RoleResourceMapper;
import com.jcin.cms.modules.syst.domain.RoleResource;
import com.jcin.cms.modules.syst.domain.RoleResourceCriteria;
import com.jcin.cms.modules.syst.service.IRoleResourceService;
import com.jcin.cms.service.impl.BaseServiceImpl;
import com.jcin.cms.utils.Page;

/**
 * @author 黄记新
 * @date 2014-12-18,下午6:56:55
 * 
 */
@Service
public class RoleResourceServiceImpl extends BaseServiceImpl<RoleResource, String>
		implements IRoleResourceService {
	private static Logger logger = Logger.getLogger(RoleResourceServiceImpl.class
			.getName());

	@Resource
	private RoleResourceMapper roleResourceMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.syst.IRoleResourceService#deleteByPrimaryKey((java.lang
	 * .String ))
	 */
	@Override
	@Transactional
	public int deleteByPrimaryKey(String id) {
		// super.deleteByPrimaryKey(id);

		int result = roleResourceMapper.deleteByPrimaryKey(id);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.syst.IRoleResourceService#insert(com.jcin.cms.service.syst.
	 * RoleResource)
	 */
	@Override
	@Transactional
	public String insert(RoleResource record) {
		 super.insert(record);

//		record.setCreateDate(new Date());
		int result = roleResourceMapper.insert(record);
		String id = record.getId();
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.syst.IRoleResourceService#select(com.jcin.cms.utils.Page)
	 */
	@Override
	public Page select(Page page) {
		super.select(page);
		//setOrderByClause("SER_NO  asc , ORG_ID desc");  
		RoleResourceCriteria roleResourceCriteria = new RoleResourceCriteria();
		roleResourceCriteria.setOrderByClause("id desc");
		roleResourceCriteria.setPage(page);
		@SuppressWarnings("rawtypes")
		List list = roleResourceMapper.selectByExample(roleResourceCriteria);
		page.setRows(list);
		int total = roleResourceMapper.countByExample(roleResourceCriteria);
		page.setTotal(total);
		return page;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.syst.IRoleResourceService#select(com.jcin.cms.service.syst.RoleResourceCriteria)
	 */
	//@Override
	public Page select(RoleResourceCriteria criteria) {
		Page page = new Page();
		@SuppressWarnings("rawtypes")
		List list = roleResourceMapper.selectByExample(criteria);
		page.setRows(list);
		int total = roleResourceMapper.countByExample(criteria);
		page.setTotal(total);
		return page;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.syst.IRoleResourceService#selectAll()
	 */
	@Override
	public List<RoleResource> selectAll() {
		List<RoleResource> list = roleResourceMapper.selectByExample(null);
		return list;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.syst.IRoleResourceService#selectByPrimaryKey(java.lang
	 * .String)
	 */
	@Override
	public RoleResource selectByPrimaryKey(String id) {
		super.selectByPrimaryKey(id);

		RoleResource article = roleResourceMapper.selectByPrimaryKey(id);
		return article;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.syst.IRoleResourceService#update(com.jcin.cms.service.syst.
	 * RoleResource)
	 */
	@Override
	@Transactional
	public String update(RoleResource record) {
		// super.update(record);
//		record.setUpdateDate(new Date());
		int result = roleResourceMapper.updateByPrimaryKeySelective(record);
		return record.getId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.syst.IRoleResourceService#insertBatch(List)
	 */
	@Override
	@Transactional
	public int insertBatch(List<RoleResource> list) {
		int result = roleResourceMapper.insertBatch(list);
		super.insertBatch(list);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.syst.IRoleResourceService#deleteBatch(List)
	 */
	@Override
	@Transactional
	public int deleteBatch(List<String> list) {
		RoleResourceCriteria roleResourceCriteria = new RoleResourceCriteria();
		roleResourceCriteria.createCriteria().andIdIn(list);
		int result = roleResourceMapper.deleteByExample(roleResourceCriteria);
		super.deleteBatch(list);
		return result;
	}

}
