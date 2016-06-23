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

import com.jcin.cms.modules.pro.dao.BrandMapper;
import com.jcin.cms.modules.pro.domain.Brand;
import com.jcin.cms.modules.pro.domain.BrandCriteria;
import com.jcin.cms.modules.pro.domain.BrandWithBLOBs;
import com.jcin.cms.modules.pro.service.IBrandService;
import com.jcin.cms.service.impl.BaseServiceImpl;
import com.jcin.cms.utils.Page;

/**
 * @author 黄记新
 * @date 2014-12-18,下午6:56:55
 * 
 */
@Service(value="brandService")
public class BrandServiceImpl extends BaseServiceImpl<Brand, String>
		implements IBrandService {
	private static Logger logger = LoggerFactory.getLogger(BrandServiceImpl.class
			.getName());

	@Autowired
	private BrandMapper brandMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.IBrandService#deleteByPrimaryKey((java.lang
	 * .String ))
	 */
	@Override
	@Transactional
	public int deleteByPrimaryKey(String id) {
		// super.deleteByPrimaryKey(id);

		int result = brandMapper.deleteByPrimaryKey(id);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.IBrandService#insert(com.jcin.cms.service.pro.
	 * Brand)
	 */
	@Override
	@Transactional
	public String insert(BrandWithBLOBs record) {
		if(record.getId()==null||"".equals(record.getId()))
			record.setId(new Date().getTime()+"");
		if(null==record.getCreateDate())
			record.setCreateDate(new Date());
		int result = brandMapper.insert(record);
		String id = record.getId();
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.IBrandService#select(com.jcin.cms.utils.Page)
	 */
	@Override
	public Page select(Page page) {
		super.select(page);
		//setOrderByClause("SER_NO  asc , ORG_ID desc");  
		BrandCriteria brandCriteria = new BrandCriteria();
		brandCriteria.setOrderByClause("id desc");
		brandCriteria.setPage(page);
		@SuppressWarnings("rawtypes")
		List list = brandMapper.selectByExample(brandCriteria);
		page.setRows(list);
		int total = brandMapper.countByExample(brandCriteria);
		page.setTotal(total);
		return page;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.IBrandService#select(com.jcin.cms.service.pro.BrandCriteria)
	 */
	//@Override
	@Override
	public Page select(BrandCriteria criteria) {
		Page page = new Page();
		if(null != criteria){
			if(null != criteria.getPage()){
				page = criteria.getPage();
			}
		}
		@SuppressWarnings("rawtypes")
		List list = brandMapper.selectByExample(criteria);
		page.setRows(list);
		int total = brandMapper.countByExample(criteria);
		page.setTotal(total);
		return page;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.IBrandService#selectAll()
	 */
	@Override
	public List<Brand> selectAll() {
		List<Brand> list = brandMapper.selectByExample(null);
		return list;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.IBrandService#selectByPrimaryKey(java.lang
	 * .String)
	 */
	@Override
	public BrandWithBLOBs selectByPrimaryKey(String id) {
		super.selectByPrimaryKey(id);

		BrandWithBLOBs record = brandMapper.selectByPrimaryKey(id);
		return record;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.IBrandService#update(com.jcin.cms.service.pro.
	 * Brand)
	 */
	@Override
	@Transactional
	public String update(BrandWithBLOBs record) {
		// super.update(record);
//		if(null==record.getUpdateDate())
			record.setUpdateDate(new Date());
		int result = brandMapper.updateByPrimaryKeySelective(record);
		return record.getId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.IBrandService#insertBatch(List)
	 */
	@Override
	@Transactional
	public int insertBatch(List<Brand> list) {
		int result = brandMapper.insertBatch(list);
		super.insertBatch(list);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.IBrandService#deleteBatch(List)
	 */
	@Override
	@Transactional
	public int deleteBatch(List<String> list) {
		BrandCriteria brandCriteria = new BrandCriteria();
		brandCriteria.createCriteria().andIdIn(list);
		int result = brandMapper.deleteByExample(brandCriteria);
		super.deleteBatch(list);
		return result;
	}
	
	
	@Override
	public List<BrandWithBLOBs> selectByExample(
			BrandCriteria criteria) {
		return  brandMapper.selectByExampleWithBLOBs(criteria);
	}

}
