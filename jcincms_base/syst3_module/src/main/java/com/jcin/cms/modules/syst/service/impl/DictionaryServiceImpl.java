/**
 * 一句话描述该类：<br/>
 * @author 黄记新
 * @date 2015-4-26,下午6:56:55
 *
 */
package com.jcin.cms.modules.syst.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jcin.cms.modules.syst.dao.DictionaryMapper;
import com.jcin.cms.modules.syst.domain.Dictionary;
import com.jcin.cms.modules.syst.domain.DictionaryCriteria;
import com.jcin.cms.modules.syst.service.IDictionaryService;
import com.jcin.cms.service.impl.BaseServiceImpl;
import com.jcin.cms.utils.Page;

/**
 * @author 黄记新
 * @date 2014-12-18,下午6:56:55
 * 
 */
@Service(value="dictionaryService")
public class DictionaryServiceImpl extends BaseServiceImpl<Dictionary, String>
		implements IDictionaryService {
	private static Logger logger = Logger.getLogger(DictionaryServiceImpl.class
			.getName());

	@Resource
	private DictionaryMapper dictionaryMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.syst.IDictionaryService#deleteByPrimaryKey((java.lang
	 * .String ))
	 */
	@Override
	@Transactional
	public int deleteByPrimaryKey(String id) {
		// super.deleteByPrimaryKey(id);

		int result = dictionaryMapper.deleteByPrimaryKey(id);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.syst.IDictionaryService#insert(com.jcin.cms.service.syst.
	 * Dictionary)
	 */
	@Override
	@Transactional
	public String insert(Dictionary record) {
		 super.insert(record);

//		record.setCreateDate(new Date());
		int result = dictionaryMapper.insert(record);
		String id = record.getId();
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.syst.IDictionaryService#select(com.jcin.cms.utils.Page)
	 */
	@Override
	public Page select(Page page) {
		super.select(page);
		//setOrderByClause("SER_NO  asc , ORG_ID desc");  
		DictionaryCriteria dictionaryCriteria = new DictionaryCriteria();
		dictionaryCriteria.setOrderByClause("id desc");
		dictionaryCriteria.setPage(page);
		@SuppressWarnings("rawtypes")
		List list = dictionaryMapper.selectByExample(dictionaryCriteria);
		page.setRows(list);
		int total = dictionaryMapper.countByExample(dictionaryCriteria);
		page.setTotal(total);
		return page;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.syst.IDictionaryService#select(com.jcin.cms.service.syst.DictionaryCriteria)
	 */
	//@Override
	public Page select(DictionaryCriteria criteria) {
		Page page = new Page();
		@SuppressWarnings("rawtypes")
		List list = dictionaryMapper.selectByExample(criteria);
		page.setRows(list);
		int total = dictionaryMapper.countByExample(criteria);
		page.setTotal(total);
		return page;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.syst.IDictionaryService#selectAll()
	 */
	@Override
	public List<Dictionary> selectAll() {
		List<Dictionary> list = dictionaryMapper.selectByExample(null);
		return list;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.syst.IDictionaryService#selectByPrimaryKey(java.lang
	 * .String)
	 */
	@Override
	public Dictionary selectByPrimaryKey(String id) {
		super.selectByPrimaryKey(id);

		Dictionary article = dictionaryMapper.selectByPrimaryKey(id);
		return article;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.syst.IDictionaryService#update(com.jcin.cms.service.syst.
	 * Dictionary)
	 */
	@Override
	@Transactional
	public String update(Dictionary record) {
		// super.update(record);
//		record.setUpdateDate(new Date());
		int result = dictionaryMapper.updateByPrimaryKeySelective(record);
		return record.getId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.syst.IDictionaryService#insertBatch(List)
	 */
	@Override
	@Transactional
	public int insertBatch(List<Dictionary> list) {
		int result = dictionaryMapper.insertBatch(list);
		super.insertBatch(list);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.syst.IDictionaryService#deleteBatch(List)
	 */
	@Override
	@Transactional
	public int deleteBatch(List<String> list) {
		DictionaryCriteria dictionaryCriteria = new DictionaryCriteria();
		dictionaryCriteria.createCriteria().andIdIn(list);
		int result = dictionaryMapper.deleteByExample(dictionaryCriteria);
		super.deleteBatch(list);
		return result;
	}

	@Override
	public List<Dictionary> selectByExample(
			DictionaryCriteria dictionaryCriteria) {
		return  dictionaryMapper.selectByExample(dictionaryCriteria);
	}

}
