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

import com.jcin.cms.modules.syst.dao.OrganizationMapper;
import com.jcin.cms.modules.syst.domain.Organization;
import com.jcin.cms.modules.syst.domain.OrganizationCriteria;
import com.jcin.cms.modules.syst.service.IOrganizationService;
import com.jcin.cms.service.impl.BaseServiceImpl;
import com.jcin.cms.utils.Page;

/**
 * @author 黄记新
 * @date 2014-12-18,下午6:56:55
 * 
 */
@Service
public class OrganizationServiceImpl extends BaseServiceImpl<Organization, String>
		implements IOrganizationService {
	private static Logger logger = Logger.getLogger(OrganizationServiceImpl.class
			.getName());

	@Resource
	private OrganizationMapper organizationMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.syst.IOrganizationService#deleteByPrimaryKey((java.lang
	 * .String ))
	 */
	@Override
	@Transactional
	public int deleteByPrimaryKey(String id) {
		// super.deleteByPrimaryKey(id);

		int result = organizationMapper.deleteByPrimaryKey(id);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.syst.IOrganizationService#insert(com.jcin.cms.service.syst.
	 * Organization)
	 */
	@Override
	@Transactional
	public String insert(Organization organization) {
		if ("".equals(organization.getParentId())) {
			organization.setParentId(null);
		} else {
			Organization resou = selectByPrimaryKey(organization.getParentId());
			if (null != resou) {
				String parentids = resou.getParentIds();
				if (parentids == null || "".equals(parentids)) {
					parentids = resou.getId();
				} else {
					parentids += ("," + resou.getId());
				}
				organization.setParentIds(parentids);
			}
		}
		 super.insert(organization);

		organization.setCreateDate(new Date());
		int result = organizationMapper.insert(organization);
		String id = organization.getId();
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.syst.IOrganizationService#select(com.jcin.cms.utils.Page)
	 */
	@Override
	public Page select(Page page) {
		super.select(page);
		//setOrderByClause("SER_NO  asc , ORG_ID desc");  
		OrganizationCriteria organizationCriteria = new OrganizationCriteria();
		organizationCriteria.setOrderByClause("id desc");
		organizationCriteria.setPage(page);
		@SuppressWarnings("rawtypes")
		List list = organizationMapper.selectByExample(organizationCriteria);
		page.setRows(list);
		int total = organizationMapper.countByExample(organizationCriteria);
		page.setTotal(total);
		return page;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.syst.IOrganizationService#select(com.jcin.cms.service.syst.OrganizationCriteria)
	 */
	//@Override
	public Page select(OrganizationCriteria criteria) {
		Page page = new Page();
		@SuppressWarnings("rawtypes")
		List list = organizationMapper.selectByExample(criteria);
		page.setRows(list);
		int total = organizationMapper.countByExample(criteria);
		page.setTotal(total);
		return page;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.syst.IOrganizationService#selectAll()
	 */
	@Override
	public List<Organization> selectAll() {
		List<Organization> list = organizationMapper.selectByExample(null);
		return list;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.syst.IOrganizationService#selectByPrimaryKey(java.lang
	 * .String)
	 */
	@Override
	public Organization selectByPrimaryKey(String id) {
		super.selectByPrimaryKey(id);

		Organization article = organizationMapper.selectByPrimaryKey(id);
		return article;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.syst.IOrganizationService#update(com.jcin.cms.service.syst.
	 * Organization)
	 */
	@Override
	@Transactional
	public String update(Organization organization) {
		if ("".equals(organization.getParentId())) {
			organization.setParentId(null);
			organization.setParentIds(null);
		} else {
			Organization organization2 = selectByPrimaryKey(organization.getParentId());
			if (null != organization2) {
				String parentids = organization2.getParentIds();
				if (parentids == null || "".equals(parentids)) {
					parentids = organization2.getId();
				} else {
					parentids += ("," + organization2.getId());
				}
				organization.setParentIds(parentids);
			}
		}
		
		// super.update(record);
		organization.setUpdateDate(new Date());
		int result = organizationMapper.updateByPrimaryKey(organization);
		return organization.getId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.syst.IOrganizationService#insertBatch(List)
	 */
	@Override
	@Transactional
	public int insertBatch(List<Organization> list) {
		for (Organization organization : list) {
			if ("".equals(organization.getParentId())) {
				organization.setParentId(null);
			} else {
				Organization organization2 = selectByPrimaryKey(organization.getParentId());
				if (null != organization2) {
					String parentids = organization2.getParentIds();
					if (parentids == null || "".equals(parentids)) {
						parentids = organization2.getId();
					} else {
						parentids += ("," + organization2.getId());
					}
					organization.setParentIds(parentids);
				}
			}
		}
		int result = organizationMapper.insertBatch(list);
		super.insertBatch(list);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.syst.IOrganizationService#deleteBatch(List)
	 */
	@Override
	@Transactional
	public int deleteBatch(List<String> list) {
		OrganizationCriteria organizationCriteria = new OrganizationCriteria();
		organizationCriteria.createCriteria().andIdIn(list);
		int result = organizationMapper.deleteByExample(organizationCriteria);
		super.deleteBatch(list);
		return result;
	}

}
