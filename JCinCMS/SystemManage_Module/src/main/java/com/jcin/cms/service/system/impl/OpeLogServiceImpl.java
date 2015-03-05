/**
 * 一句话描述该类：操作日志服务实现类<br/>
 * @author 黄记新
 * @date 2014-12-18,下午6:56:55
 *
 */
package com.jcin.cms.service.system.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jcin.cms.dao.system.OperationlogMapper;
import com.jcin.cms.domain.system.Operationlog;
import com.jcin.cms.domain.system.OperationlogCriteria;
import com.jcin.cms.service.impl.BaseServiceImpl;
import com.jcin.cms.service.system.IOpeLogService;
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
	@Transactional
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
	public String insert(Operationlog record) {
		 super.insert(record);

//		record.setCreatedate(new Date()+"");
		int result = operationlogMapper.insert(record);
		String id = record.getId();
		return id;
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
		//setOrderByClause("SER_NO  asc , ORG_ID desc");  
		OperationlogCriteria operationlogCriteria = new OperationlogCriteria();
		operationlogCriteria.setOrderByClause("id desc");
		operationlogCriteria.setPage(page);
		@SuppressWarnings("rawtypes")
		List list = operationlogMapper.selectByExample(operationlogCriteria);
		page.setRows(list);
		int total = operationlogMapper.countByExample(operationlogCriteria);
		page.setTotal(total);
		return page;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.IOperationlogService#select(com.jcin.cms.domain.OperationlogCriteria)
	 */
	@Override
	public Page select(OperationlogCriteria criteria) {
		Page page = new Page();
		@SuppressWarnings("rawtypes")
		List list = operationlogMapper.selectByExample(criteria);
		page.setRows(list);
		int total = operationlogMapper.countByExample(criteria);
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
	public String update(Operationlog record) {
		// super.update(record);

		int result = operationlogMapper.updateByPrimaryKeySelective(record);
		return record.getId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.IOperationlogService#insertBatch(List)
	 */
	@Override
	public int insertBatch(List<Operationlog> list) {
		int result = operationlogMapper.insertBatch(list);
		super.insertBatch(list);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.IOperationlogService#deleteBatch(List)
	 */
	@Override
	public int deleteBatch(List<String> list) {
		OperationlogCriteria operationlogCriteria = new OperationlogCriteria();
		operationlogCriteria.createCriteria().andIdIn(list);
		int result = operationlogMapper.deleteByExample(operationlogCriteria);
		super.deleteBatch(list);
		return result;
	}

}
