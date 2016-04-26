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

import com.jcin.cms.modules.pro.dao.PropertiesMapper;
import com.jcin.cms.modules.pro.domain.Properties;
import com.jcin.cms.modules.pro.domain.PropertiesCriteria;
import com.jcin.cms.modules.pro.service.IPropertiesService;
import com.jcin.cms.service.impl.BaseServiceImpl;
import com.jcin.cms.utils.Page;

/**
 * @author 黄记新
 * @date 2014-12-18,下午6:56:55
 * 
 */
@Service(value="propertiesService")
public class PropertiesServiceImpl extends BaseServiceImpl<Properties, String>
		implements IPropertiesService {
	private static Logger logger = Logger.getLogger(PropertiesServiceImpl.class
			.getName());

	@Autowired
	private PropertiesMapper propertiesMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.IPropertiesService#deleteByPrimaryKey((java.lang
	 * .String ))
	 */
	@Override
	@Transactional
	public int deleteByPrimaryKey(String id) {
		// super.deleteByPrimaryKey(id);

		int result = propertiesMapper.deleteByPrimaryKey(id);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.IPropertiesService#insert(com.jcin.cms.service.pro.
	 * Properties)
	 */
	@Override
	@Transactional
	public String insert(Properties record) {
		if(record.getId()==null)
		 	super.insert(record);
		if(null==record.getCreateDate())
			record.setCreateDate(new Date());
		int result = propertiesMapper.insert(record);
		String id = record.getId();
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.IPropertiesService#select(com.jcin.cms.utils.Page)
	 */
	@Override
	public Page select(Page page) {
		super.select(page);
		//setOrderByClause("SER_NO  asc , ORG_ID desc");  
		PropertiesCriteria propertiesCriteria = new PropertiesCriteria();
		propertiesCriteria.setOrderByClause("id desc");
		propertiesCriteria.setPage(page);
		@SuppressWarnings("rawtypes")
		List list = propertiesMapper.selectByExample(propertiesCriteria);
		page.setRows(list);
		int total = propertiesMapper.countByExample(propertiesCriteria);
		page.setTotal(total);
		return page;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.IPropertiesService#select(com.jcin.cms.service.pro.PropertiesCriteria)
	 */
	//@Override
	public Page select(PropertiesCriteria criteria) {
		Page page = new Page();
		if(null != criteria){
			if(null != criteria.getPage()){
				page = criteria.getPage();
			}
		}
		@SuppressWarnings("rawtypes")
		List list = propertiesMapper.selectByExample(criteria);
		page.setRows(list);
		int total = propertiesMapper.countByExample(criteria);
		page.setTotal(total);
		return page;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.IPropertiesService#selectAll()
	 */
	@Override
	public List<Properties> selectAll() {
		List<Properties> list = propertiesMapper.selectByExample(null);
		return list;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.IPropertiesService#selectByPrimaryKey(java.lang
	 * .String)
	 */
	@Override
	public Properties selectByPrimaryKey(String id) {
		super.selectByPrimaryKey(id);

		Properties record = propertiesMapper.selectByPrimaryKey(id);
		return record;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.IPropertiesService#update(com.jcin.cms.service.pro.
	 * Properties)
	 */
	@Override
	@Transactional
	public String update(Properties record) {
		// super.update(record);
//		if(null==record.getUpdateDate())
			record.setUpdateDate(new Date());
		int result = propertiesMapper.updateByPrimaryKeySelective(record);
		return record.getId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.IPropertiesService#insertBatch(List)
	 */
	@Override
	@Transactional
	public int insertBatch(List<Properties> list) {
		int result = propertiesMapper.insertBatch(list);
		super.insertBatch(list);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.IPropertiesService#deleteBatch(List)
	 */
	@Override
	@Transactional
	public int deleteBatch(List<String> list) {
		PropertiesCriteria propertiesCriteria = new PropertiesCriteria();
		propertiesCriteria.createCriteria().andIdIn(list);
		int result = propertiesMapper.deleteByExample(propertiesCriteria);
		super.deleteBatch(list);
		return result;
	}
	
	
	@Override
	public List<Properties> selectByExample(
			PropertiesCriteria criteria) {
		return  propertiesMapper.selectByExample(criteria);
	}

}
