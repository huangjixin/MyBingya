/**
 * 一句话描述该类：<br/>
 * @author 黄记新
 * @date 2015-4-26,下午6:56:55
 *
 */
package com.jcin.cms.modules.pro.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jcin.cms.modules.pro.dao.SkuMapper;
import com.jcin.cms.modules.pro.domain.Sku;
import com.jcin.cms.modules.pro.domain.SkuCriteria;
import com.jcin.cms.modules.pro.service.ISkuService;
import com.jcin.cms.service.impl.BaseServiceImpl;
import com.jcin.cms.utils.Page;

/**
 * @author 黄记新
 * @date 2014-12-18,下午6:56:55
 * 
 */
@Service(value="skuService")
public class SkuServiceImpl extends BaseServiceImpl<Sku, String>
		implements ISkuService {
	private static Logger logger = LoggerFactory.getLogger(SkuServiceImpl.class);

	@Autowired
	private SkuMapper skuMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.ISkuService#deleteByPrimaryKey((java.lang
	 * .String ))
	 */
	@Override
	@Transactional
	public int deleteByPrimaryKey(String id) {
		// super.deleteByPrimaryKey(id);

		int result = skuMapper.deleteByPrimaryKey(id);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.ISkuService#insert(com.jcin.cms.service.pro.
	 * Sku)
	 */
	@Override
	@Transactional
	public String insert(Sku record) {
		if(record.getId()==null)
		 	super.insert(record);
		/*if(null==record.getCreateDate())
			record.setCreateDate(new Date());*/
		int result = skuMapper.insert(record);
		String id = record.getId();
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.ISkuService#select(com.jcin.cms.utils.Page)
	 */
	@Override
	public Page select(Page page) {
		super.select(page);
		//setOrderByClause("SER_NO  asc , ORG_ID desc");  
		SkuCriteria skuCriteria = new SkuCriteria();
		skuCriteria.setOrderByClause("id desc");
		skuCriteria.setPage(page);
		@SuppressWarnings("rawtypes")
		List list = skuMapper.selectByExample(skuCriteria);
		page.setRows(list);
		int total = skuMapper.countByExample(skuCriteria);
		page.setTotal(total);
		return page;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.ISkuService#select(com.jcin.cms.service.pro.SkuCriteria)
	 */
	//@Override
	@Override
	public Page select(SkuCriteria criteria) {
		Page page = new Page();
		if(null != criteria){
			if(null != criteria.getPage()){
				page = criteria.getPage();
			}
		}
		@SuppressWarnings("rawtypes")
		List list = skuMapper.selectByExample(criteria);
		page.setRows(list);
		int total = skuMapper.countByExample(criteria);
		page.setTotal(total);
		return page;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.ISkuService#selectAll()
	 */
	@Override
	public List<Sku> selectAll() {
		List<Sku> list = skuMapper.selectByExample(null);
		return list;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.ISkuService#selectByPrimaryKey(java.lang
	 * .String)
	 */
	@Override
	public Sku selectByPrimaryKey(String id) {
		super.selectByPrimaryKey(id);

		Sku record = skuMapper.selectByPrimaryKey(id);
		return record;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.ISkuService#update(com.jcin.cms.service.pro.
	 * Sku)
	 */
	@Override
	@Transactional
	public String update(Sku record) {
		// super.update(record);
		/*if(null==record.getUpdateDate())
			record.setUpdateDate(new Date());*/
		int result = skuMapper.updateByPrimaryKeySelective(record);
		return record.getId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.ISkuService#insertBatch(List)
	 */
	@Override
	@Transactional
	public int insertBatch(List<Sku> list) {
		int result = skuMapper.insertBatch(list);
		super.insertBatch(list);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.ISkuService#deleteBatch(List)
	 */
	@Override
	@Transactional
	public int deleteBatch(List<String> list) {
		SkuCriteria skuCriteria = new SkuCriteria();
		skuCriteria.createCriteria().andIdIn(list);
		int result = skuMapper.deleteByExample(skuCriteria);
		super.deleteBatch(list);
		return result;
	}
	
	
	@Override
	public List<Sku> selectByExample(
			SkuCriteria criteria) {
		return  skuMapper.selectByExample(criteria);
	}

}
