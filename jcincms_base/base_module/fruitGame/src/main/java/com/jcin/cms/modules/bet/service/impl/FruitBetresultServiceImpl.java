/**
 * 一句话描述该类：<br/>
 * @author 黄记新
 * @date 2015-4-26,下午6:56:55
 *
 */
package com.jcin.cms.modules.bet.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.jcin.cms.modules.bet.dao.FruitBetresultMapper;
import com.jcin.cms.modules.bet.domain.FruitBetresult;
import com.jcin.cms.modules.bet.domain.FruitBetresultCriteria;
import com.jcin.cms.modules.bet.service.IFruitBetresultService;
import com.jcin.cms.service.impl.BaseServiceImpl;
import com.jcin.cms.utils.Page;

/**
 * @author 黄记新
 * @date 2014-12-18,下午6:56:55
 * 
 */
@Service(value="fruitBetresultService")
public class FruitBetresultServiceImpl extends BaseServiceImpl<FruitBetresult, String>
		implements IFruitBetresultService {
	private static Logger logger = Logger.getLogger(FruitBetresultServiceImpl.class
			.getName());

	@Autowired
	private FruitBetresultMapper fruitBetresultMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.bet.IFruitBetresultService#deleteByPrimaryKey((java.lang
	 * .String ))
	 */
	@Override
	@Transactional
	public int deleteByPrimaryKey(String id) {
		// super.deleteByPrimaryKey(id);

		int result = fruitBetresultMapper.deleteByPrimaryKey(id);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.bet.IFruitBetresultService#insert(com.jcin.cms.service.bet.
	 * FruitBetresult)
	 */
	@Override
	@Transactional
	public String insert(FruitBetresult record) {
		if(record.getId()==null)
		 	super.insert(record);

		record.setCreateDate(new Date());
		int result = fruitBetresultMapper.insert(record);
		String id = record.getId();
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.bet.IFruitBetresultService#select(com.jcin.cms.utils.Page)
	 */
	@Override
	public Page select(Page page) {
		super.select(page);
		//setOrderByClause("SER_NO  asc , ORG_ID desc");  
		FruitBetresultCriteria fruitBetresultCriteria = new FruitBetresultCriteria();
		fruitBetresultCriteria.setOrderByClause("id desc");
		fruitBetresultCriteria.setPage(page);
		@SuppressWarnings("rawtypes")
		List list = fruitBetresultMapper.selectByExample(fruitBetresultCriteria);
		page.setRows(list);
		int total = fruitBetresultMapper.countByExample(fruitBetresultCriteria);
		page.setTotal(total);
		return page;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.bet.IFruitBetresultService#select(com.jcin.cms.service.bet.FruitBetresultCriteria)
	 */
	//@Override
	public Page select(FruitBetresultCriteria criteria) {
		Page page = new Page();
		if(null != criteria){
			if(null != criteria.getPage()){
				page = criteria.getPage();
			}
		}
		@SuppressWarnings("rawtypes")
		List list = fruitBetresultMapper.selectByExample(criteria);
		page.setRows(list);
		int total = fruitBetresultMapper.countByExample(criteria);
		page.setTotal(total);
		return page;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.bet.IFruitBetresultService#selectAll()
	 */
	@Override
	public List<FruitBetresult> selectAll() {
		List<FruitBetresult> list = fruitBetresultMapper.selectByExample(null);
		return list;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.bet.IFruitBetresultService#selectByPrimaryKey(java.lang
	 * .String)
	 */
	@Override
	public FruitBetresult selectByPrimaryKey(String id) {
		super.selectByPrimaryKey(id);

		FruitBetresult record = fruitBetresultMapper.selectByPrimaryKey(id);
		return record;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.bet.IFruitBetresultService#update(com.jcin.cms.service.bet.
	 * FruitBetresult)
	 */
	@Override
	@Transactional
	public String update(FruitBetresult record) {
		// super.update(record);
		record.setUpdateDate(new Date());
		int result = fruitBetresultMapper.updateByPrimaryKey(record);
		return record.getId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.bet.IFruitBetresultService#insertBatch(List)
	 */
	@Override
	@Transactional
	public int insertBatch(List<FruitBetresult> list) {
		int result = fruitBetresultMapper.insertBatch(list);
		super.insertBatch(list);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.bet.IFruitBetresultService#deleteBatch(List)
	 */
	@Override
	@Transactional
	public int deleteBatch(List<String> list) {
		FruitBetresultCriteria fruitBetresultCriteria = new FruitBetresultCriteria();
		fruitBetresultCriteria.createCriteria().andIdIn(list);
		int result = fruitBetresultMapper.deleteByExample(fruitBetresultCriteria);
		super.deleteBatch(list);
		return result;
	}
	
	
	@Override
	public List<FruitBetresult> selectByExample(
			FruitBetresultCriteria criteria) {
		return  fruitBetresultMapper.selectByExample(criteria);
	}

}
