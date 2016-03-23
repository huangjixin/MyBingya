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

import com.jcin.cms.modules.sale.dao.BuyMapper;
import com.jcin.cms.modules.sale.domain.Buy;
import com.jcin.cms.modules.sale.domain.BuyCriteria;
import com.jcin.cms.modules.sale.domain.Storage;
import com.jcin.cms.modules.sale.domain.StorageCriteria;
import com.jcin.cms.modules.sale.service.IBuyService;
import com.jcin.cms.modules.sale.service.IStorageService;
import com.jcin.cms.service.impl.BaseServiceImpl;
import com.jcin.cms.utils.Page;

/**
 * @author 黄记新
 * @date 2014-12-18,下午6:56:55
 * 
 */
@Service(value="buyService")
public class BuyServiceImpl extends BaseServiceImpl<Buy, String>
		implements IBuyService {
	private static Logger logger = Logger.getLogger(BuyServiceImpl.class
			.getName());

	@Autowired
	private BuyMapper buyMapper;

	@Autowired
	private IStorageService storageService;
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.sale.IBuyService#deleteByPrimaryKey((java.lang
	 * .String ))
	 */
	@Override
	@Transactional
	public int deleteByPrimaryKey(String id) {
		// super.deleteByPrimaryKey(id);

		int result = buyMapper.deleteByPrimaryKey(id);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.sale.IBuyService#insert(com.jcin.cms.service.sale.
	 * Buy)
	 */
	@Override
	@Transactional
	public String insert(Buy record) {
		if(record.getId()==null)
		 	super.insert(record);
		if(record.getCreateDate()==null){
			record.setCreateDate(new Date());
		}
		
		int result = buyMapper.insert(record);
		String id = record.getId();
		
		StorageCriteria storageCriteria = new StorageCriteria();
		StorageCriteria.Criteria criteria = storageCriteria.createCriteria();
		criteria.andProIdEqualTo(record.getProId());
		List<Storage>storages = storageService.selectByExample(storageCriteria);
		Storage storage = null;
		//更新或者添加库存。
		if(storages!=null && storages.size()>0){
			storage = storages.get(0);
			storage.setProcount(storage.getProcount()+record.getBuyNum());
			storage.setBuyId(record.getId());
			storageService.update(storage);
		}else{
			storage = new Storage();
			storage.setProcount(record.getBuyNum());
			storage.setProId(record.getProId());
			storage.setProName(record.getProName());
			storage.setBuyId(record.getId());
			storageService.insert(storage);
		}
		
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.sale.IBuyService#select(com.jcin.cms.utils.Page)
	 */
	@Override
	public Page select(Page page) {
		super.select(page);
		//setOrderByClause("SER_NO  asc , ORG_ID desc");  
		BuyCriteria buyCriteria = new BuyCriteria();
		buyCriteria.setOrderByClause("id desc");
		buyCriteria.setPage(page);
		@SuppressWarnings("rawtypes")
		List list = buyMapper.selectByExample(buyCriteria);
		page.setRows(list);
		int total = buyMapper.countByExample(buyCriteria);
		page.setTotal(total);
		return page;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.sale.IBuyService#select(com.jcin.cms.service.sale.BuyCriteria)
	 */
	//@Override
	public Page select(BuyCriteria criteria) {
		Page page = new Page();
		if(null != criteria){
			if(null != criteria.getPage()){
				page = criteria.getPage();
			}
		}
		@SuppressWarnings("rawtypes")
		List list = buyMapper.selectByExample(criteria);
		page.setRows(list);
		int total = buyMapper.countByExample(criteria);
		page.setTotal(total);
		return page;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.sale.IBuyService#selectAll()
	 */
	@Override
	public List<Buy> selectAll() {
		List<Buy> list = buyMapper.selectByExample(null);
		return list;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.sale.IBuyService#selectByPrimaryKey(java.lang
	 * .String)
	 */
	@Override
	public Buy selectByPrimaryKey(String id) {
		super.selectByPrimaryKey(id);

		Buy record = buyMapper.selectByPrimaryKey(id);
		return record;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.sale.IBuyService#update(com.jcin.cms.service.sale.
	 * Buy)
	 */
	@Override
	@Transactional
	public String update(Buy record) {
		// super.update(record);
//		record.setUpdateDate(new Date());
		int result = buyMapper.updateByPrimaryKey(record);
		return record.getId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.sale.IBuyService#insertBatch(List)
	 */
	@Override
	@Transactional
	public int insertBatch(List<Buy> list) {
		int result = buyMapper.insertBatch(list);
		super.insertBatch(list);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.sale.IBuyService#deleteBatch(List)
	 */
	@Override
	@Transactional
	public int deleteBatch(List<String> list) {
		BuyCriteria buyCriteria = new BuyCriteria();
		buyCriteria.createCriteria().andIdIn(list);
		int result = buyMapper.deleteByExample(buyCriteria);
		super.deleteBatch(list);
		return result;
	}
	
	
	@Override
	public List<Buy> selectByExample(
			BuyCriteria criteria) {
		return  buyMapper.selectByExample(criteria);
	}

	@Override
	public int updateByExampleSelective(@Param("record") Buy record,
			@Param("example") BuyCriteria example) {
		return buyMapper.updateByExampleSelective(record, example);
	}

}
