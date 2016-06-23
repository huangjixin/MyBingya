/**
 * 一句话描述该类：<br/>
 * @author 黄记新
 * @date 2015-4-26,下午6:56:55
 *
 */
package com.jcin.cms.modules.pro.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jcin.cms.modules.pro.dao.ValueMapper;
import com.jcin.cms.modules.pro.domain.Value;
import com.jcin.cms.modules.pro.domain.ValueCriteria;
import com.jcin.cms.modules.pro.service.IValueService;
import com.jcin.cms.service.impl.BaseServiceImpl;
import com.jcin.cms.utils.Page;

/**
 * @author 黄记新
 * @date 2014-12-18,下午6:56:55
 * 
 */
@Service(value="valueService")
public class ValueServiceImpl extends BaseServiceImpl<Value, String>
		implements IValueService {
	private static Logger logger = LoggerFactory.getLogger(ValueServiceImpl.class);

	@Autowired
	private ValueMapper valueMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.IValueService#deleteByPrimaryKey((java.lang
	 * .String ))
	 */
	@Override
	@Transactional
	public int deleteByPrimaryKey(String id) {
		// super.deleteByPrimaryKey(id);

		int result = valueMapper.deleteByPrimaryKey(id);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.IValueService#insert(com.jcin.cms.service.pro.
	 * Value)
	 */
	@Override
	@Transactional
	public String insert(Value record) {
		if(record.getId()==null)
		 	super.insert(record);
		if(null==record.getCreateDate())
			record.setCreateDate(new Date());
		int result = valueMapper.insert(record);
		String id = record.getId();
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.IValueService#select(com.jcin.cms.utils.Page)
	 */
	@Override
	public Page select(Page page) {
		super.select(page);
		//setOrderByClause("SER_NO  asc , ORG_ID desc");  
		ValueCriteria valueCriteria = new ValueCriteria();
		valueCriteria.setOrderByClause("id desc");
		valueCriteria.setPage(page);
		@SuppressWarnings("rawtypes")
		List list = valueMapper.selectByExample(valueCriteria);
		page.setRows(list);
		int total = valueMapper.countByExample(valueCriteria);
		page.setTotal(total);
		return page;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.IValueService#select(com.jcin.cms.service.pro.ValueCriteria)
	 */
	//@Override
	@Override
	public Page select(ValueCriteria criteria) {
		Page page = new Page();
		if(null != criteria){
			if(null != criteria.getPage()){
				page = criteria.getPage();
			}
		}
		@SuppressWarnings("rawtypes")
		List list = valueMapper.selectByExample(criteria);
		page.setRows(list);
		int total = valueMapper.countByExample(criteria);
		page.setTotal(total);
		return page;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.IValueService#selectAll()
	 */
	@Override
	public List<Value> selectAll() {
		List<Value> list = valueMapper.selectByExample(null);
		return list;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.IValueService#selectByPrimaryKey(java.lang
	 * .String)
	 */
	@Override
	public Value selectByPrimaryKey(String id) {
		super.selectByPrimaryKey(id);

		Value record = valueMapper.selectByPrimaryKey(id);
		return record;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.IValueService#update(com.jcin.cms.service.pro.
	 * Value)
	 */
	@Override
	@Transactional
	public String update(Value record) {
		// super.update(record);
//		if(null==record.getUpdateDate())
			record.setUpdateDate(new Date());
		int result = valueMapper.updateByPrimaryKeySelective(record);
		return record.getId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.IValueService#insertBatch(List)
	 */
	@Override
	@Transactional
	public int insertBatch(List<Value> list) {
		int result = valueMapper.insertBatch(list);
		super.insertBatch(list);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.IValueService#deleteBatch(List)
	 */
	@Override
	@Transactional
	public int deleteBatch(List<String> list) {
		ValueCriteria valueCriteria = new ValueCriteria();
		valueCriteria.createCriteria().andIdIn(list);
		int result = valueMapper.deleteByExample(valueCriteria);
		super.deleteBatch(list);
		return result;
	}
	
	
	@Override
	public List<Value> selectByExample(
			ValueCriteria criteria) {
		return  valueMapper.selectByExample(criteria);
	}

}
