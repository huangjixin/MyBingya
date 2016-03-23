/**
 * 一句话描述该类：<br/>
 * @author 黄记新
 * @date 2015-4-26,下午6:56:55
 *
 */
package com.jcin.cms.modules.sale.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.jcin.cms.modules.sale.dao.SaleMapper;
import com.jcin.cms.modules.sale.domain.Sale;
import com.jcin.cms.modules.sale.domain.SaleCriteria;
import com.jcin.cms.modules.sale.domain.Storage;
import com.jcin.cms.modules.sale.domain.StorageCriteria;
import com.jcin.cms.modules.sale.service.ISaleService;
import com.jcin.cms.modules.sale.service.IStorageService;
import com.jcin.cms.service.impl.BaseServiceImpl;
import com.jcin.cms.utils.Page;

/**
 * @author 黄记新
 * @date 2014-12-18,下午6:56:55
 * 
 */
@Service(value="saleService")
public class SaleServiceImpl extends BaseServiceImpl<Sale, String>
		implements ISaleService {
	private static Logger logger = Logger.getLogger(SaleServiceImpl.class
			.getName());
	@Autowired
	private IStorageService storageService;
	
	@Autowired
	private SaleMapper saleMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.sale.ISaleService#deleteByPrimaryKey((java.lang
	 * .String ))
	 */
	@Override
	@Transactional
	public int deleteByPrimaryKey(String id) {
		// super.deleteByPrimaryKey(id);

		int result = saleMapper.deleteByPrimaryKey(id);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.sale.ISaleService#insert(com.jcin.cms.service.sale.
	 * Sale)
	 */
	@Override
	@Transactional
	public String insert(Sale sale) {
		if(sale.getId()==null)
		 	super.insert(sale);

		if(sale.getCreateDate()==null){
			sale.setCreateDate(new Date());
		}
		int result = saleMapper.insert(sale);
		

		StorageCriteria storageCriteria = new StorageCriteria();
		StorageCriteria.Criteria criteria = storageCriteria.createCriteria();
		criteria.andProIdEqualTo(sale.getProId());
		List<Storage>storages = storageService.selectByExample(storageCriteria);
		Storage storage = null;
		//更新或者添加库存。
		if(storages!=null && storages.size()>0){
			storage = storages.get(0);
			storage.setSaleId(sale.getId());
			storage.setProcount(storage.getProcount()-sale.getSaleNum());
			storageService.update(storage);
		}else{
			storage = new Storage();
			storage.setProcount(sale.getSaleNum());
			storage.setProId(sale.getProId());
			storage.setProName(sale.getProName());
			storage.setSaleId(sale.getId());
			storageService.insert(storage);
		}
		
		String id = sale.getId();
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.sale.ISaleService#select(com.jcin.cms.utils.Page)
	 */
	@Override
	public Page select(Page page) {
		super.select(page);
		//setOrderByClause("SER_NO  asc , ORG_ID desc");  
		SaleCriteria saleCriteria = new SaleCriteria();
		saleCriteria.setOrderByClause("id desc");
		saleCriteria.setPage(page);
		@SuppressWarnings("rawtypes")
		List list = saleMapper.selectByExample(saleCriteria);
		page.setRows(list);
		int total = saleMapper.countByExample(saleCriteria);
		page.setTotal(total);
		return page;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.sale.ISaleService#select(com.jcin.cms.service.sale.SaleCriteria)
	 */
	//@Override
	public Page select(SaleCriteria criteria) {
		Page page = new Page();
		if(null != criteria){
			if(null != criteria.getPage()){
				page = criteria.getPage();
			}
		}
		@SuppressWarnings("rawtypes")
		List list = saleMapper.selectByExample(criteria);
		page.setRows(list);
		int total = saleMapper.countByExample(criteria);
		page.setTotal(total);
		return page;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.sale.ISaleService#selectAll()
	 */
	@Override
	public List<Sale> selectAll() {
		List<Sale> list = saleMapper.selectByExample(null);
		return list;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.sale.ISaleService#selectByPrimaryKey(java.lang
	 * .String)
	 */
	@Override
	public Sale selectByPrimaryKey(String id) {
		super.selectByPrimaryKey(id);

		Sale record = saleMapper.selectByPrimaryKey(id);
		return record;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.sale.ISaleService#update(com.jcin.cms.service.sale.
	 * Sale)
	 */
	@Override
	@Transactional
	public String update(Sale record) {
		// super.update(record);
//		record.setUpdateDate(new Date());
		int result = saleMapper.updateByPrimaryKey(record);
		return record.getId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.sale.ISaleService#insertBatch(List)
	 */
	@Override
	@Transactional
	public int insertBatch(List<Sale> list) {
		int result = saleMapper.insertBatch(list);
		super.insertBatch(list);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.sale.ISaleService#deleteBatch(List)
	 */
	@Override
	@Transactional
	public int deleteBatch(List<String> list) {
		SaleCriteria saleCriteria = new SaleCriteria();
		saleCriteria.createCriteria().andIdIn(list);
		int result = saleMapper.deleteByExample(saleCriteria);
		super.deleteBatch(list);
		return result;
	}
	
	
	@Override
	public List<Sale> selectByExample(
			SaleCriteria criteria) {
		return  saleMapper.selectByExample(criteria);
	}

	@Override
	public int updateByExampleSelective(@Param("record") Sale record,
			@Param("example") SaleCriteria example) {
		return  saleMapper.updateByExampleSelective(record, example); 
	}

}
