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

import com.jcin.cms.modules.syst.dao.UserOrganizationMapper;
import com.jcin.cms.modules.syst.domain.UserOrganization;
import com.jcin.cms.modules.syst.domain.UserOrganizationCriteria;
import com.jcin.cms.modules.syst.service.IUserOrganizationService;
import com.jcin.cms.service.impl.BaseServiceImpl;
import com.jcin.cms.utils.Page;

/**
 * @author 黄记新
 * @date 2014-12-18,下午6:56:55
 * 
 */
@Service
public class UserOrganizationServiceImpl extends BaseServiceImpl<UserOrganization, String>
		implements IUserOrganizationService {
	private static Logger logger = Logger.getLogger(UserOrganizationServiceImpl.class
			.getName());

	@Resource
	private UserOrganizationMapper userOrganizationMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.syst.IUserOrganizationService#deleteByPrimaryKey((java.lang
	 * .String ))
	 */
	@Override
	@Transactional
	public int deleteByPrimaryKey(String id) {
		// super.deleteByPrimaryKey(id);

		int result = userOrganizationMapper.deleteByPrimaryKey(id);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.syst.IUserOrganizationService#insert(com.jcin.cms.service.syst.
	 * UserOrganization)
	 */
	@Override
	@Transactional
	public String insert(UserOrganization record) {
		 super.insert(record);

//		record.setCreateDate(new Date());
		int result = userOrganizationMapper.insert(record);
		String id = record.getId();
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.syst.IUserOrganizationService#select(com.jcin.cms.utils.Page)
	 */
	@Override
	public Page select(Page page) {
		super.select(page);
		//setOrderByClause("SER_NO  asc , ORG_ID desc");  
		UserOrganizationCriteria userOrganizationCriteria = new UserOrganizationCriteria();
		userOrganizationCriteria.setOrderByClause("id desc");
		userOrganizationCriteria.setPage(page);
		@SuppressWarnings("rawtypes")
		List list = userOrganizationMapper.selectByExample(userOrganizationCriteria);
		page.setRows(list);
		int total = userOrganizationMapper.countByExample(userOrganizationCriteria);
		page.setTotal(total);
		return page;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.syst.IUserOrganizationService#select(com.jcin.cms.service.syst.UserOrganizationCriteria)
	 */
	//@Override
	public Page select(UserOrganizationCriteria criteria) {
		Page page = new Page();
		@SuppressWarnings("rawtypes")
		List list = userOrganizationMapper.selectByExample(criteria);
		page.setRows(list);
		int total = userOrganizationMapper.countByExample(criteria);
		page.setTotal(total);
		return page;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.syst.IUserOrganizationService#selectAll()
	 */
	@Override
	public List<UserOrganization> selectAll() {
		List<UserOrganization> list = userOrganizationMapper.selectByExample(null);
		return list;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.syst.IUserOrganizationService#selectByPrimaryKey(java.lang
	 * .String)
	 */
	@Override
	public UserOrganization selectByPrimaryKey(String id) {
		super.selectByPrimaryKey(id);

		UserOrganization article = userOrganizationMapper.selectByPrimaryKey(id);
		return article;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.syst.IUserOrganizationService#update(com.jcin.cms.service.syst.
	 * UserOrganization)
	 */
	@Override
	@Transactional
	public String update(UserOrganization record) {
		// super.update(record);
//		record.setUpdateDate(new Date());
		int result = userOrganizationMapper.updateByPrimaryKeySelective(record);
		return record.getId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.syst.IUserOrganizationService#insertBatch(List)
	 */
	@Override
	@Transactional
	public int insertBatch(List<UserOrganization> list) {
		int result = userOrganizationMapper.insertBatch(list);
		super.insertBatch(list);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.syst.IUserOrganizationService#deleteBatch(List)
	 */
	@Override
	@Transactional
	public int deleteBatch(List<String> list) {
		UserOrganizationCriteria userOrganizationCriteria = new UserOrganizationCriteria();
		userOrganizationCriteria.createCriteria().andIdIn(list);
		int result = userOrganizationMapper.deleteByExample(userOrganizationCriteria);
		super.deleteBatch(list);
		return result;
	}
	
	
	@Override
	public List<UserOrganization> selectByExample(
			UserOrganizationCriteria criteria) {
		return  userOrganizationMapper.selectByExample(criteria);
	}

}
