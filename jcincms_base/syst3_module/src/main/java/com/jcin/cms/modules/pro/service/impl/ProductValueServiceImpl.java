/**
 * 一句话描述该类：<br/>
 * @author 黄记新
 * @date 2015-4-26,下午6:56:55
 *
 */
package com.jcin.cms.modules.pro.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.jcin.cms.modules.pro.dao.ProductValueMapper;
import com.jcin.cms.modules.pro.domain.ProductValue;
import com.jcin.cms.modules.pro.domain.ProductValueCriteria;
import com.jcin.cms.modules.pro.service.IProductValueService;
import com.jcin.cms.service.impl.BaseServiceImpl;
import com.jcin.cms.utils.Page;

/**
 * @author 黄记新
 * @date 2014-12-18,下午6:56:55
 * 
 */
@Service(value="productValueService")
public class ProductValueServiceImpl extends BaseServiceImpl<ProductValue, String>
		implements IProductValueService {
	private static Logger logger = Logger.getLogger(ProductValueServiceImpl.class
			.getName());

	@Autowired
	private ProductValueMapper productValueMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.IProductValueService#deleteByPrimaryKey((java.lang
	 * .String ))
	 */
	@Override
	@Transactional
	public int deleteByPrimaryKey(String id) {
		// super.deleteByPrimaryKey(id);

		int result = productValueMapper.deleteByPrimaryKey(id);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.IProductValueService#insert(com.jcin.cms.service.pro.
	 * ProductValue)
	 */
	@Override
	@Transactional
	public String insert(ProductValue record) {
		if(record.getId()==null)
		 	super.insert(record);
		/*if(null==record.getCreateDate())
			record.setCreateDate(new Date());*/
		int result = productValueMapper.insert(record);
		String id = record.getId();
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.IProductValueService#select(com.jcin.cms.utils.Page)
	 */
	@Override
	public Page select(Page page) {
		super.select(page);
		//setOrderByClause("SER_NO  asc , ORG_ID desc");  
		ProductValueCriteria productValueCriteria = new ProductValueCriteria();
		productValueCriteria.setOrderByClause("id desc");
		productValueCriteria.setPage(page);
		@SuppressWarnings("rawtypes")
		List list = productValueMapper.selectByExample(productValueCriteria);
		page.setRows(list);
		int total = productValueMapper.countByExample(productValueCriteria);
		page.setTotal(total);
		return page;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.IProductValueService#select(com.jcin.cms.service.pro.ProductValueCriteria)
	 */
	//@Override
	public Page select(ProductValueCriteria criteria) {
		Page page = new Page();
		if(null != criteria){
			if(null != criteria.getPage()){
				page = criteria.getPage();
			}
		}
		@SuppressWarnings("rawtypes")
		List list = productValueMapper.selectByExample(criteria);
		page.setRows(list);
		int total = productValueMapper.countByExample(criteria);
		page.setTotal(total);
		return page;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.IProductValueService#selectAll()
	 */
	@Override
	public List<ProductValue> selectAll() {
		List<ProductValue> list = productValueMapper.selectByExample(null);
		return list;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.IProductValueService#selectByPrimaryKey(java.lang
	 * .String)
	 */
	@Override
	public ProductValue selectByPrimaryKey(String id) {
		super.selectByPrimaryKey(id);

		ProductValue record = productValueMapper.selectByPrimaryKey(id);
		return record;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.IProductValueService#update(com.jcin.cms.service.pro.
	 * ProductValue)
	 */
	@Override
	@Transactional
	public String update(ProductValue record) {
		// super.update(record);
		/*if(null==record.getUpdateDate())
			record.setUpdateDate(new Date());*/
		int result = productValueMapper.updateByPrimaryKeySelective(record);
		return record.getId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.IProductValueService#insertBatch(List)
	 */
	@Override
	@Transactional
	public int insertBatch(List<ProductValue> list) {
		int result = productValueMapper.insertBatch(list);
		super.insertBatch(list);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.IProductValueService#deleteBatch(List)
	 */
	@Override
	@Transactional
	public int deleteBatch(List<String> list) {
		ProductValueCriteria productValueCriteria = new ProductValueCriteria();
		productValueCriteria.createCriteria().andIdIn(list);
		int result = productValueMapper.deleteByExample(productValueCriteria);
		super.deleteBatch(list);
		return result;
	}
	
	
	@Override
	public List<ProductValue> selectByExample(
			ProductValueCriteria criteria) {
		return  productValueMapper.selectByExample(criteria);
	}

}
