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

import com.jcin.cms.modules.bet.dao.FruitRecordMapper;
import com.jcin.cms.modules.bet.domain.FruitRecord;
import com.jcin.cms.modules.bet.domain.FruitRecordCriteria;
import com.jcin.cms.modules.bet.service.IFruitRecordService;
import com.jcin.cms.service.impl.BaseServiceImpl;
import com.jcin.cms.utils.Page;

/**
 * @author 黄记新
 * @date 2014-12-18,下午6:56:55
 * 
 */
@Service(value="fruitRecordService")
public class FruitRecordServiceImpl extends BaseServiceImpl<FruitRecord, String>
		implements IFruitRecordService {
	private static Logger logger = Logger.getLogger(FruitRecordServiceImpl.class
			.getName());

	@Autowired
	private FruitRecordMapper fruitRecordMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.bet.IFruitRecordService#deleteByPrimaryKey((java.lang
	 * .String ))
	 */
	@Override
	@Transactional
	public int deleteByPrimaryKey(String id) {
		// super.deleteByPrimaryKey(id);

		int result = fruitRecordMapper.deleteByPrimaryKey(id);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.bet.IFruitRecordService#insert(com.jcin.cms.service.bet.
	 * FruitRecord)
	 */
	@Override
	@Transactional
	public String insert(FruitRecord record) {
		if(record.getId()==null)
		 	super.insert(record);

		record.setCreateDate(new Date());
		int result = fruitRecordMapper.insert(record);
		String id = record.getId();
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.bet.IFruitRecordService#select(com.jcin.cms.utils.Page)
	 */
	@Override
	public Page select(Page page) {
		super.select(page);
		//setOrderByClause("SER_NO  asc , ORG_ID desc");  
		FruitRecordCriteria fruitRecordCriteria = new FruitRecordCriteria();
		fruitRecordCriteria.setOrderByClause("id desc");
		fruitRecordCriteria.setPage(page);
		@SuppressWarnings("rawtypes")
		List list = fruitRecordMapper.selectByExample(fruitRecordCriteria);
		page.setRows(list);
		int total = fruitRecordMapper.countByExample(fruitRecordCriteria);
		page.setTotal(total);
		return page;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.bet.IFruitRecordService#select(com.jcin.cms.service.bet.FruitRecordCriteria)
	 */
	//@Override
	public Page select(FruitRecordCriteria criteria) {
		Page page = new Page();
		if(null != criteria){
			if(null != criteria.getPage()){
				page = criteria.getPage();
			}
		}
		@SuppressWarnings("rawtypes")
		List list = fruitRecordMapper.selectByExample(criteria);
		page.setRows(list);
		int total = fruitRecordMapper.countByExample(criteria);
		page.setTotal(total);
		return page;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.bet.IFruitRecordService#selectAll()
	 */
	@Override
	public List<FruitRecord> selectAll() {
		List<FruitRecord> list = fruitRecordMapper.selectByExample(null);
		return list;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.bet.IFruitRecordService#selectByPrimaryKey(java.lang
	 * .String)
	 */
	@Override
	public FruitRecord selectByPrimaryKey(String id) {
		super.selectByPrimaryKey(id);

		FruitRecord record = fruitRecordMapper.selectByPrimaryKey(id);
		return record;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.bet.IFruitRecordService#update(com.jcin.cms.service.bet.
	 * FruitRecord)
	 */
	@Override
	@Transactional
	public String update(FruitRecord record) {
		// super.update(record);
		record.setUpdateDate(new Date());
		int result = fruitRecordMapper.updateByPrimaryKey(record);
		return record.getId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.bet.IFruitRecordService#insertBatch(List)
	 */
	@Override
	@Transactional
	public int insertBatch(List<FruitRecord> list) {
		int result = fruitRecordMapper.insertBatch(list);
		super.insertBatch(list);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.bet.IFruitRecordService#deleteBatch(List)
	 */
	@Override
	@Transactional
	public int deleteBatch(List<String> list) {
		FruitRecordCriteria fruitRecordCriteria = new FruitRecordCriteria();
		fruitRecordCriteria.createCriteria().andIdIn(list);
		int result = fruitRecordMapper.deleteByExample(fruitRecordCriteria);
		super.deleteBatch(list);
		return result;
	}
	
	
	@Override
	public List<FruitRecord> selectByExample(
			FruitRecordCriteria criteria) {
		return  fruitRecordMapper.selectByExample(criteria);
	}

}
