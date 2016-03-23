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

import com.jcin.cms.modules.bet.dao.FruitBetresultHistoryMapper;
import com.jcin.cms.modules.bet.domain.FruitBetresultHistory;
import com.jcin.cms.modules.bet.domain.FruitBetresultHistoryCriteria;
import com.jcin.cms.modules.bet.service.IFruitBetresultHistoryService;
import com.jcin.cms.service.impl.BaseServiceImpl;
import com.jcin.cms.utils.Page;

/**
 * @author 黄记新
 * @date 2014-12-18,下午6:56:55
 * 
 */
@Service(value="fruitBetresultHistoryService")
public class FruitBetresultHistoryServiceImpl extends BaseServiceImpl<FruitBetresultHistory, String>
		implements IFruitBetresultHistoryService {
	private static Logger logger = Logger.getLogger(FruitBetresultHistoryServiceImpl.class
			.getName());

	@Autowired
	private FruitBetresultHistoryMapper fruitBetresultHistoryMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.bet.IFruitBetresultHistoryService#deleteByPrimaryKey((java.lang
	 * .String ))
	 */
	@Override
	@Transactional
	public int deleteByPrimaryKey(String id) {
		// super.deleteByPrimaryKey(id);

		int result = fruitBetresultHistoryMapper.deleteByPrimaryKey(id);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.bet.IFruitBetresultHistoryService#insert(com.jcin.cms.service.bet.
	 * FruitBetresultHistory)
	 */
	@Override
	@Transactional
	public String insert(FruitBetresultHistory record) {
		if(record.getId()==null)
		 	super.insert(record);

		record.setCreateDate(new Date());
		int result = fruitBetresultHistoryMapper.insert(record);
		String id = record.getId();
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.bet.IFruitBetresultHistoryService#select(com.jcin.cms.utils.Page)
	 */
	@Override
	public Page select(Page page) {
		super.select(page);
		//setOrderByClause("SER_NO  asc , ORG_ID desc");  
		FruitBetresultHistoryCriteria fruitBetresultHistoryCriteria = new FruitBetresultHistoryCriteria();
		fruitBetresultHistoryCriteria.setOrderByClause("id desc");
		fruitBetresultHistoryCriteria.setPage(page);
		@SuppressWarnings("rawtypes")
		List list = fruitBetresultHistoryMapper.selectByExample(fruitBetresultHistoryCriteria);
		page.setRows(list);
		int total = fruitBetresultHistoryMapper.countByExample(fruitBetresultHistoryCriteria);
		page.setTotal(total);
		return page;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.bet.IFruitBetresultHistoryService#select(com.jcin.cms.service.bet.FruitBetresultHistoryCriteria)
	 */
	//@Override
	public Page select(FruitBetresultHistoryCriteria criteria) {
		Page page = new Page();
		if(null != criteria){
			if(null != criteria.getPage()){
				page = criteria.getPage();
			}
		}
		@SuppressWarnings("rawtypes")
		List list = fruitBetresultHistoryMapper.selectByExample(criteria);
		page.setRows(list);
		int total = fruitBetresultHistoryMapper.countByExample(criteria);
		page.setTotal(total);
		return page;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.bet.IFruitBetresultHistoryService#selectAll()
	 */
	@Override
	public List<FruitBetresultHistory> selectAll() {
		List<FruitBetresultHistory> list = fruitBetresultHistoryMapper.selectByExample(null);
		return list;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.bet.IFruitBetresultHistoryService#selectByPrimaryKey(java.lang
	 * .String)
	 */
	@Override
	public FruitBetresultHistory selectByPrimaryKey(String id) {
		super.selectByPrimaryKey(id);

		FruitBetresultHistory record = fruitBetresultHistoryMapper.selectByPrimaryKey(id);
		return record;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.bet.IFruitBetresultHistoryService#update(com.jcin.cms.service.bet.
	 * FruitBetresultHistory)
	 */
	@Override
	@Transactional
	public String update(FruitBetresultHistory record) {
		// super.update(record);
		record.setUpdateDate(new Date());
		int result = fruitBetresultHistoryMapper.updateByPrimaryKey(record);
		return record.getId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.bet.IFruitBetresultHistoryService#insertBatch(List)
	 */
	@Override
	@Transactional
	public int insertBatch(List<FruitBetresultHistory> list) {
		int result = fruitBetresultHistoryMapper.insertBatch(list);
		super.insertBatch(list);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.bet.IFruitBetresultHistoryService#deleteBatch(List)
	 */
	@Override
	@Transactional
	public int deleteBatch(List<String> list) {
		FruitBetresultHistoryCriteria fruitBetresultHistoryCriteria = new FruitBetresultHistoryCriteria();
		fruitBetresultHistoryCriteria.createCriteria().andIdIn(list);
		int result = fruitBetresultHistoryMapper.deleteByExample(fruitBetresultHistoryCriteria);
		super.deleteBatch(list);
		return result;
	}
	
	
	@Override
	public List<FruitBetresultHistory> selectByExample(
			FruitBetresultHistoryCriteria criteria) {
		return  fruitBetresultHistoryMapper.selectByExample(criteria);
	}

}
