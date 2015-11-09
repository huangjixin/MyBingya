/**
 * 一句话描述该类：<br/>
 * @author 黄记新
 * @date 2015-4-26,下午6:56:55
 *
 */
package com.jcin.cms.modules.channel.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.jcin.cms.modules.channel.dao.AssetsMapper;
import com.jcin.cms.modules.channel.domain.Assets;
import com.jcin.cms.modules.channel.domain.AssetsCriteria;
import com.jcin.cms.modules.channel.service.IAssetsService;
import com.jcin.cms.service.impl.BaseServiceImpl;
import com.jcin.cms.utils.Page;

/**
 * @author 黄记新
 * @date 2014-12-18,下午6:56:55
 * 
 */
@Service(value="assetsService")
public class AssetsServiceImpl extends BaseServiceImpl<Assets, String>
		implements IAssetsService {
	private static Logger logger = Logger.getLogger(AssetsServiceImpl.class
			.getName());

	@Autowired
	private AssetsMapper assetsMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.channel.IAssetsService#deleteByPrimaryKey((java.lang
	 * .String ))
	 */
	@Override
	@Transactional
	public int deleteByPrimaryKey(String id) {
		// super.deleteByPrimaryKey(id);

		int result = assetsMapper.deleteByPrimaryKey(id);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.channel.IAssetsService#insert(com.jcin.cms.service.channel.
	 * Assets)
	 */
	@Override
	@Transactional
	public String insert(Assets record) {
		 super.insert(record);

		record.setCreateDate(new Date());
		int result = assetsMapper.insert(record);
		String id = record.getId();
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.channel.IAssetsService#select(com.jcin.cms.utils.Page)
	 */
	@Override
	public Page select(Page page) {
		super.select(page);
		//setOrderByClause("SER_NO  asc , ORG_ID desc");  
		AssetsCriteria assetsCriteria = new AssetsCriteria();
		assetsCriteria.setOrderByClause("id desc");
		assetsCriteria.setPage(page);
		@SuppressWarnings("rawtypes")
		List list = assetsMapper.selectByExample(assetsCriteria);
		page.setRows(list);
		int total = assetsMapper.countByExample(assetsCriteria);
		page.setTotal(total);
		return page;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.channel.IAssetsService#select(com.jcin.cms.service.channel.AssetsCriteria)
	 */
	//@Override
	public Page select(AssetsCriteria criteria) {
		Page page = new Page();
		if(null != criteria){
			if(null != criteria.getPage()){
				page = criteria.getPage();
			}
		}
		@SuppressWarnings("rawtypes")
		List list = assetsMapper.selectByExample(criteria);
		page.setRows(list);
		int total = assetsMapper.countByExample(criteria);
		page.setTotal(total);
		return page;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.channel.IAssetsService#selectAll()
	 */
	@Override
	public List<Assets> selectAll() {
		List<Assets> list = assetsMapper.selectByExample(null);
		return list;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.channel.IAssetsService#selectByPrimaryKey(java.lang
	 * .String)
	 */
	@Override
	public Assets selectByPrimaryKey(String id) {
		super.selectByPrimaryKey(id);

		Assets article = assetsMapper.selectByPrimaryKey(id);
		return article;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.channel.IAssetsService#update(com.jcin.cms.service.channel.
	 * Assets)
	 */
	@Override
	@Transactional
	public String update(Assets record) {
		// super.update(record);
		record.setUpdateDate(new Date());
		int result = assetsMapper.updateByPrimaryKey(record);
		return record.getId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.channel.IAssetsService#insertBatch(List)
	 */
	@Override
	@Transactional
	public int insertBatch(List<Assets> list) {
		int result = assetsMapper.insertBatch(list);
		super.insertBatch(list);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.channel.IAssetsService#deleteBatch(List)
	 */
	@Override
	@Transactional
	public int deleteBatch(List<String> list) {
		AssetsCriteria assetsCriteria = new AssetsCriteria();
		assetsCriteria.createCriteria().andIdIn(list);
		int result = assetsMapper.deleteByExample(assetsCriteria);
		super.deleteBatch(list);
		return result;
	}
	
	
	@Override
	public List<Assets> selectByExample(
			AssetsCriteria criteria) {
		return  assetsMapper.selectByExample(criteria);
	}

}
