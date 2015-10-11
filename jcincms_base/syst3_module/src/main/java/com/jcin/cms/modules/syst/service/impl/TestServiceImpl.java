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

import com.jcin.cms.modules.syst.dao.TestMapper;
import com.jcin.cms.modules.syst.domain.Test;
import com.jcin.cms.modules.syst.domain.TestCriteria;
import com.jcin.cms.modules.syst.service.ITestService;
import com.jcin.cms.service.impl.BaseServiceImpl;
import com.jcin.cms.utils.Page;

/**
 * @author 黄记新
 * @date 2014-12-18,下午6:56:55
 * 
 */
@Service
public class TestServiceImpl extends BaseServiceImpl<Test, String>
		implements ITestService {
	private static Logger logger = Logger.getLogger(TestServiceImpl.class
			.getName());

	@Resource
	private TestMapper testMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.syst.ITestService#deleteByPrimaryKey((java.lang
	 * .String ))
	 */
	@Override
	@Transactional
	public int deleteByPrimaryKey(String id) {
		// super.deleteByPrimaryKey(id);

		int result = testMapper.deleteByPrimaryKey(id);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.syst.ITestService#insert(com.jcin.cms.service.syst.
	 * Test)
	 */
	@Override
	@Transactional
	public String insert(Test record) {
		 super.insert(record);

		record.setCreateDate(new Date());
		int result = testMapper.insert(record);
		String id = record.getId();
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.syst.ITestService#select(com.jcin.cms.utils.Page)
	 */
	@Override
	public Page select(Page page) {
		super.select(page);
		//setOrderByClause("SER_NO  asc , ORG_ID desc");  
		TestCriteria testCriteria = new TestCriteria();
		testCriteria.setOrderByClause("id desc");
		testCriteria.setPage(page);
		@SuppressWarnings("rawtypes")
		List list = testMapper.selectByExample(testCriteria);
		page.setRows(list);
		int total = testMapper.countByExample(testCriteria);
		page.setTotal(total);
		return page;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.syst.ITestService#select(com.jcin.cms.service.syst.TestCriteria)
	 */
	//@Override
	public Page select(TestCriteria criteria) {
		Page page = new Page();
		@SuppressWarnings("rawtypes")
		List list = testMapper.selectByExample(criteria);
		page.setRows(list);
		int total = testMapper.countByExample(criteria);
		page.setTotal(total);
		return page;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.syst.ITestService#selectAll()
	 */
	@Override
	public List<Test> selectAll() {
		List<Test> list = testMapper.selectByExample(null);
		return list;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.syst.ITestService#selectByPrimaryKey(java.lang
	 * .String)
	 */
	@Override
	public Test selectByPrimaryKey(String id) {
		super.selectByPrimaryKey(id);

		Test article = testMapper.selectByPrimaryKey(id);
		return article;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.syst.ITestService#update(com.jcin.cms.service.syst.
	 * Test)
	 */
	@Override
	@Transactional
	public String update(Test record) {
		// super.update(record);
		record.setUpdateDate(new Date());
		int result = testMapper.updateByPrimaryKeySelective(record);
		return record.getId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.syst.ITestService#insertBatch(List)
	 */
	@Override
	@Transactional
	public int insertBatch(List<Test> list) {
		int result = testMapper.insertBatch(list);
		super.insertBatch(list);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.syst.ITestService#deleteBatch(List)
	 */
	@Override
	@Transactional
	public int deleteBatch(List<String> list) {
		TestCriteria testCriteria = new TestCriteria();
		testCriteria.createCriteria().andIdIn(list);
		int result = testMapper.deleteByExample(testCriteria);
		super.deleteBatch(list);
		return result;
	}

}
