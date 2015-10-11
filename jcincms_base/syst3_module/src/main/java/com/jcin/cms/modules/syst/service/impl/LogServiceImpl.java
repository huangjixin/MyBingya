/**
 * 一句话描述该类：用户实现类<br/>
 * @author 黄记新
 * @date 2015-4-26,下午6:56:55
 *
 */
package com.jcin.cms.modules.syst.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jcin.cms.modules.syst.dao.LogMapper;
import com.jcin.cms.modules.syst.dao.RoleMapper;
import com.jcin.cms.modules.syst.domain.Log;
import com.jcin.cms.modules.syst.domain.LogCriteria;
import com.jcin.cms.modules.syst.service.ILogService;
import com.jcin.cms.service.impl.BaseServiceImpl;
import com.jcin.cms.utils.Page;

/**
 * @author 黄记新
 * @date 2014-12-18,下午6:56:55
 * 
 */
@Service
public class LogServiceImpl extends BaseServiceImpl<Log, String> implements
		ILogService {
	private static Logger logger = Logger.getLogger(LogServiceImpl.class
			.getName());

	@Autowired
	private LogMapper logMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jcin.cms.service.system.ILogService#deleteByPrimaryKey((java
	 * .lang .String ))
	 */
	@Override
	@Transactional(readOnly = false)
	public int deleteByPrimaryKey(String id) {
		// super.deleteByPrimaryKey(id);

		int result = logMapper.deleteByPrimaryKey(id);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jcin.cms.service.system.ILogService#insert(com.jcin.cms.service.
	 * system. Log)
	 */
	@Override
	@Transactional(readOnly = false)
	public String insert(Log record) {
		super.insert(record);

		// record.setCreateDate(new Date());
		int result = logMapper.insert(record);
		String id = record.getId();
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jcin.cms.service.system.ILogService#select(com.jcin.cms.utils
	 * .Page)
	 */
	@Override
	public Page select(Page page) {
		super.select(page);
		// setOrderByClause("SER_NO  asc , ORG_ID desc");
		LogCriteria resourceCriteria = new LogCriteria();
		resourceCriteria.setOrderByClause("id desc");
		resourceCriteria.setPage(page);
		@SuppressWarnings("rawtypes")
		List list = logMapper.selectByExample(resourceCriteria);
		page.setRows(list);
		int total = logMapper.countByExample(resourceCriteria);
		page.setTotal(total);
		return page;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jcin.cms.service.system.ILogService#select(com.jcin.cms.service.
	 * system.LogCriteria)
	 */
	// @Override
	public Page select(LogCriteria criteria) {
		Page page = new Page();
		@SuppressWarnings("rawtypes")
		List list = logMapper.selectByExample(criteria);
		page.setRows(list);
		int total = logMapper.countByExample(criteria);
		page.setTotal(total);
		return page;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jcin.cms.service.system.ILogService#selectAll()
	 */
	@Override
	public List<Log> selectAll() {
		List<Log> list = logMapper.selectByExample(null);
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jcin.cms.service.system.ILogService#selectByPrimaryKey(java.lang
	 * .String)
	 */
	@Override
	public Log selectByPrimaryKey(String id) {
		super.selectByPrimaryKey(id);

		Log article = logMapper.selectByPrimaryKey(id);
		return article;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jcin.cms.service.system.ILogService#update(com.jcin.cms.service.
	 * system. Log)
	 */
	@Override
	@Transactional(readOnly = false)
	public String update(Log record) {
		// super.update(record);
		// record.setUpdateDate(new Date());
		int result = logMapper.updateByPrimaryKey(record);
		return record.getId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jcin.cms.service.system.ILogService#insertBatch(List)
	 */
	@Override
	@Transactional(readOnly = false)
	public int insertBatch(List<Log> list) {
		int result = logMapper.insertBatch(list);
		super.insertBatch(list);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jcin.cms.service.system.ILogService#deleteBatch(List)
	 */
	@Override
	@Transactional(readOnly = false)
	public int deleteBatch(List<String> list) {
		LogCriteria resourceCriteria = new LogCriteria();
		resourceCriteria.createCriteria().andIdIn(list);
		int result = logMapper.deleteByExample(resourceCriteria);
		super.deleteBatch(list);
		return result;
	}
}
