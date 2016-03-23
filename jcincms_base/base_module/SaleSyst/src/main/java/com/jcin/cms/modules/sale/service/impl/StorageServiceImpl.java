/**
 * 一句话描述该类：<br/>
 * @author 黄记新
 * @date 2015-4-26,下午6:56:55
 *
 */
package com.jcin.cms.modules.sale.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.jcin.cms.modules.sale.dao.StorageMapper;
import com.jcin.cms.modules.sale.domain.Storage;
import com.jcin.cms.modules.sale.domain.StorageCriteria;
import com.jcin.cms.modules.sale.service.IStorageService;
import com.jcin.cms.service.impl.BaseServiceImpl;
import com.jcin.cms.utils.Page;

/**
 * @author 黄记新
 * @date 2014-12-18,下午6:56:55
 * 
 */
@Service(value="storageService")
public class StorageServiceImpl extends BaseServiceImpl<Storage, String>
		implements IStorageService {
	private static Logger logger = Logger.getLogger(StorageServiceImpl.class
			.getName());

	@Autowired
	private StorageMapper storageMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.sale.IStorageService#deleteByPrimaryKey((java.lang
	 * .String ))
	 */
	@Override
	@Transactional
	public int deleteByPrimaryKey(String id) {
		// super.deleteByPrimaryKey(id);

		int result = storageMapper.deleteByPrimaryKey(id);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.sale.IStorageService#insert(com.jcin.cms.service.sale.
	 * Storage)
	 */
	@Override
	@Transactional
	public String insert(Storage record) {
		if(record.getId()==null)
		 	super.insert(record);

//		record.setCreateDate(new Date());
		int result = storageMapper.insert(record);
		String id = record.getId();
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.sale.IStorageService#select(com.jcin.cms.utils.Page)
	 */
	@Override
	public Page select(Page page) {
		super.select(page);
		//setOrderByClause("SER_NO  asc , ORG_ID desc");  
		StorageCriteria storageCriteria = new StorageCriteria();
		storageCriteria.setOrderByClause("id desc");
		storageCriteria.setPage(page);
		@SuppressWarnings("rawtypes")
		List list = storageMapper.selectByExample(storageCriteria);
		page.setRows(list);
		int total = storageMapper.countByExample(storageCriteria);
		page.setTotal(total);
		return page;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.sale.IStorageService#select(com.jcin.cms.service.sale.StorageCriteria)
	 */
	//@Override
	public Page select(StorageCriteria criteria) {
		Page page = new Page();
		if(null != criteria){
			if(null != criteria.getPage()){
				page = criteria.getPage();
			}
		}
		@SuppressWarnings("rawtypes")
		List list = storageMapper.selectByExample(criteria);
		page.setRows(list);
		int total = storageMapper.countByExample(criteria);
		page.setTotal(total);
		return page;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.sale.IStorageService#selectAll()
	 */
	@Override
	public List<Storage> selectAll() {
		List<Storage> list = storageMapper.selectByExample(null);
		return list;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.sale.IStorageService#selectByPrimaryKey(java.lang
	 * .String)
	 */
	@Override
	public Storage selectByPrimaryKey(String id) {
		super.selectByPrimaryKey(id);

		Storage record = storageMapper.selectByPrimaryKey(id);
		return record;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.sale.IStorageService#update(com.jcin.cms.service.sale.
	 * Storage)
	 */
	@Override
	@Transactional
	public String update(Storage record) {
		// super.update(record);
//		record.setUpdateDate(new Date());
		int result = storageMapper.updateByPrimaryKey(record);
		return record.getId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.sale.IStorageService#insertBatch(List)
	 */
	@Override
	@Transactional
	public int insertBatch(List<Storage> list) {
		int result = storageMapper.insertBatch(list);
		super.insertBatch(list);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.sale.IStorageService#deleteBatch(List)
	 */
	@Override
	@Transactional
	public int deleteBatch(List<String> list) {
		StorageCriteria storageCriteria = new StorageCriteria();
		storageCriteria.createCriteria().andIdIn(list);
		int result = storageMapper.deleteByExample(storageCriteria);
		super.deleteBatch(list);
		return result;
	}
	
	
	@Override
	public List<Storage> selectByExample(
			StorageCriteria criteria) {
		return  storageMapper.selectByExample(criteria);
	}

}
