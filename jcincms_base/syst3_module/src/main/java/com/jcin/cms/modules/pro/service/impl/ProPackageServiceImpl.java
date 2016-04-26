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

import com.jcin.cms.modules.pro.dao.ProPackageMapper;
import com.jcin.cms.modules.pro.domain.ProPackage;
import com.jcin.cms.modules.pro.domain.ProPackageCriteria;
import com.jcin.cms.modules.pro.service.IProPackageService;
import com.jcin.cms.service.impl.BaseServiceImpl;
import com.jcin.cms.utils.Page;

/**
 * @author 黄记新
 * @date 2014-12-18,下午6:56:55
 * 
 */
@Service(value="proPackageService")
public class ProPackageServiceImpl extends BaseServiceImpl<ProPackage, String>
		implements IProPackageService {
	private static Logger logger = Logger.getLogger(ProPackageServiceImpl.class
			.getName());

	@Autowired
	private ProPackageMapper proPackageMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.IProPackageService#deleteByPrimaryKey((java.lang
	 * .String ))
	 */
	@Override
	@Transactional
	public int deleteByPrimaryKey(String id) {
		// super.deleteByPrimaryKey(id);

		int result = proPackageMapper.deleteByPrimaryKey(id);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.IProPackageService#insert(com.jcin.cms.service.pro.
	 * ProPackage)
	 */
	@Override
	@Transactional
	public String insert(ProPackage record) {
		if(record.getId()==null)
		 	super.insert(record);
		if(null==record.getCreateDate())
			record.setCreateDate(new Date());
		int result = proPackageMapper.insert(record);
		String id = record.getId();
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.IProPackageService#select(com.jcin.cms.utils.Page)
	 */
	@Override
	public Page select(Page page) {
		super.select(page);
		//setOrderByClause("SER_NO  asc , ORG_ID desc");  
		ProPackageCriteria proPackageCriteria = new ProPackageCriteria();
		proPackageCriteria.setOrderByClause("id desc");
		proPackageCriteria.setPage(page);
		@SuppressWarnings("rawtypes")
		List list = proPackageMapper.selectByExample(proPackageCriteria);
		page.setRows(list);
		int total = proPackageMapper.countByExample(proPackageCriteria);
		page.setTotal(total);
		return page;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.IProPackageService#select(com.jcin.cms.service.pro.ProPackageCriteria)
	 */
	//@Override
	public Page select(ProPackageCriteria criteria) {
		Page page = new Page();
		if(null != criteria){
			if(null != criteria.getPage()){
				page = criteria.getPage();
			}
		}
		@SuppressWarnings("rawtypes")
		List list = proPackageMapper.selectByExample(criteria);
		page.setRows(list);
		int total = proPackageMapper.countByExample(criteria);
		page.setTotal(total);
		return page;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.IProPackageService#selectAll()
	 */
	@Override
	public List<ProPackage> selectAll() {
		List<ProPackage> list = proPackageMapper.selectByExample(null);
		return list;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.IProPackageService#selectByPrimaryKey(java.lang
	 * .String)
	 */
	@Override
	public ProPackage selectByPrimaryKey(String id) {
		super.selectByPrimaryKey(id);

		ProPackage record = proPackageMapper.selectByPrimaryKey(id);
		return record;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.IProPackageService#update(com.jcin.cms.service.pro.
	 * ProPackage)
	 */
	@Override
	@Transactional
	public String update(ProPackage record) {
		// super.update(record);
//		if(null==record.getUpdateDate())
			record.setUpdateDate(new Date());
		int result = proPackageMapper.updateByPrimaryKeySelective(record);
		return record.getId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.IProPackageService#insertBatch(List)
	 */
	@Override
	@Transactional
	public int insertBatch(List<ProPackage> list) {
		int result = proPackageMapper.insertBatch(list);
		super.insertBatch(list);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.IProPackageService#deleteBatch(List)
	 */
	@Override
	@Transactional
	public int deleteBatch(List<String> list) {
		ProPackageCriteria proPackageCriteria = new ProPackageCriteria();
		proPackageCriteria.createCriteria().andIdIn(list);
		int result = proPackageMapper.deleteByExample(proPackageCriteria);
		super.deleteBatch(list);
		return result;
	}
	
	
	@Override
	public List<ProPackage> selectByExample(
			ProPackageCriteria criteria) {
		return  proPackageMapper.selectByExample(criteria);
	}

}
