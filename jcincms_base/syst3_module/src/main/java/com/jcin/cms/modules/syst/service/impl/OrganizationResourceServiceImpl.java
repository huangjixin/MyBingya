/**
 * 一句话描述该类：<br/>
 * @author 黄记新
 * @date 2015-4-26,下午6:56:55
 *
 */
package com.jcin.cms.modules.syst.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jcin.cms.modules.syst.dao.OrganizationResourceMapper;
import com.jcin.cms.modules.syst.domain.OrganizationResource;
import com.jcin.cms.modules.syst.domain.OrganizationResourceCriteria;
import com.jcin.cms.modules.syst.service.IOrganizationResourceService;
import com.jcin.cms.service.impl.BaseServiceImpl;
import com.jcin.cms.utils.Page;

/**
 * @author 黄记新
 * @date 2014-12-18,下午6:56:55
 * 
 */
@Service(value = "organizationResourceService")
public class OrganizationResourceServiceImpl extends BaseServiceImpl<OrganizationResource, String>
		implements IOrganizationResourceService {
	private static Logger logger = Logger.getLogger(OrganizationResourceServiceImpl.class
			.getName());

	@Resource
	private OrganizationResourceMapper organizationResourceMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.syst.IOrganizationResourceService#deleteByPrimaryKey((java.lang
	 * .String ))
	 */
	@Override
	@Transactional
	public int deleteByPrimaryKey(String id) {
		// super.deleteByPrimaryKey(id);

		int result = organizationResourceMapper.deleteByPrimaryKey(id);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.syst.IOrganizationResourceService#insert(com.jcin.cms.service.syst.
	 * OrganizationResource)
	 */
	@Override
	@Transactional
	public String insert(OrganizationResource record) {
		 super.insert(record);

//		record.setCreateDate(new Date());
		int result = organizationResourceMapper.insert(record);
		String id = record.getId();
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.syst.IOrganizationResourceService#select(com.jcin.cms.utils.Page)
	 */
	@Override
	public Page select(Page page) {
		super.select(page);
		//setOrderByClause("SER_NO  asc , ORG_ID desc");  
		OrganizationResourceCriteria organizationResourceCriteria = new OrganizationResourceCriteria();
		organizationResourceCriteria.setOrderByClause("id desc");
		organizationResourceCriteria.setPage(page);
		@SuppressWarnings("rawtypes")
		List list = organizationResourceMapper.selectByExample(organizationResourceCriteria);
		page.setRows(list);
		int total = organizationResourceMapper.countByExample(organizationResourceCriteria);
		page.setTotal(total);
		return page;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.syst.IOrganizationResourceService#select(com.jcin.cms.service.syst.OrganizationResourceCriteria)
	 */
	//@Override
	public Page select(OrganizationResourceCriteria criteria) {
		Page page = new Page();
		if(null != criteria){
			if(null != criteria.getPage()){
				page = criteria.getPage();
			}
		}
		@SuppressWarnings("rawtypes")
		List list = organizationResourceMapper.selectByExample(criteria);
		page.setRows(list);
		int total = organizationResourceMapper.countByExample(criteria);
		page.setTotal(total);
		return page;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.syst.IOrganizationResourceService#selectAll()
	 */
	@Override
	public List<OrganizationResource> selectAll() {
		List<OrganizationResource> list = organizationResourceMapper.selectByExample(null);
		return list;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.syst.IOrganizationResourceService#selectByPrimaryKey(java.lang
	 * .String)
	 */
	@Override
	public OrganizationResource selectByPrimaryKey(String id) {
		super.selectByPrimaryKey(id);

		OrganizationResource article = organizationResourceMapper.selectByPrimaryKey(id);
		return article;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.syst.IOrganizationResourceService#update(com.jcin.cms.service.syst.
	 * OrganizationResource)
	 */
	@Override
	@Transactional
	public String update(OrganizationResource record) {
		// super.update(record);
//		record.setUpdateDate(new Date());
		int result = organizationResourceMapper.updateByPrimaryKeySelective(record);
		return record.getId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.syst.IOrganizationResourceService#insertBatch(List)
	 */
	@Override
	@Transactional
	public int insertBatch(List<OrganizationResource> list) {
		int result = organizationResourceMapper.insertBatch(list);
		super.insertBatch(list);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.syst.IOrganizationResourceService#deleteBatch(List)
	 */
	@Override
	@Transactional
	public int deleteBatch(List<String> list) {
		OrganizationResourceCriteria organizationResourceCriteria = new OrganizationResourceCriteria();
		organizationResourceCriteria.createCriteria().andIdIn(list);
		int result = organizationResourceMapper.deleteByExample(organizationResourceCriteria);
		super.deleteBatch(list);
		return result;
	}

}
