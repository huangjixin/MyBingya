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

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jcin.cms.dao.OperationlogMapper;
import com.jcin.cms.domain.Operationlog;
import com.jcin.cms.domain.OperationlogCriteria;
import com.jcin.cms.service.IOpeLogService;
import com.jcin.cms.utils.Page;

/**
 * @author 黄记新
 * @date 2014-12-18,下午6:56:55
 * 
 */
@Service(value = "opeLogService")
public class OpeLogServiceImpl extends BaseServiceImpl<Operationlog, String>
		implements IOpeLogService {
	private static Logger logger = Logger.getLogger(OpeLogServiceImpl.class
			.getName());

	@Resource
	private OperationlogMapper operationlogMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.IOperationlogService#deleteByPrimaryKey((java.lang
	 * .String ))
	 */
	@Override
	public int deleteByPrimaryKey(String id) {
		// super.deleteByPrimaryKey(id);

		int result = operationlogMapper.deleteByPrimaryKey(id);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.IOperationlogService#insert(com.jcin.cms.domain.
	 * Operationlog)
	 */
	@Override
	@Transactional
	public int insert(Operationlog record) {
		// super.insert(record);

		record.setCreatedate(new Date());
		int result = operationlogMapper.insert(record);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.IOperationlogService#select(com.jcin.cms.utils.Page)
	 */
	@Override
	public Page select(Page page) {
		super.select(page);

		OperationlogCriteria articleCriteria = new OperationlogCriteria();
		articleCriteria.setOrderByClause("order by id desc");
		articleCriteria.setPage(page);
		@SuppressWarnings("rawtypes")
		List list = operationlogMapper.selectByExample(articleCriteria);
		page.setRows(list);
		int total = operationlogMapper.countByExample(articleCriteria);
		page.setTotal(total);
		return page;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.IOperationlogService#selectByPrimaryKey(java.lang
	 * .String)
	 */
	@Override
	public Operationlog selectByPrimaryKey(String id) {
		super.selectByPrimaryKey(id);

		Operationlog article = operationlogMapper.selectByPrimaryKey(id);
		return article;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.IOperationlogService#update(com.jcin.cms.domain.
	 * Operationlog)
	 */
	@Override
	@Transactional
	public int update(Operationlog record) {
		// super.update(record);

		int result = operationlogMapper.updateByPrimaryKeySelective(record);
		return result;
	}

}