/**
 * 中兴软创<br/>
 * 一句话描述该类：<br/>
 * @author 黄记新
 * @date 2014-12-18,下午6:56:55
 *
 */
/**
 * 
 */
package com.jcin.cms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jcin.cms.dao.AssetMapper;
import com.jcin.cms.domain.Asset;
import com.jcin.cms.domain.AssetCriteria;
import com.jcin.cms.service.IAssetService;
import com.jcin.cms.utils.Page;

/**
 * @author 黄记新
 * @date 2014-12-18,下午6:56:55
 * 
 */
@Service(value = "assetService")
public class AssetServiceImpl extends BaseServiceImpl<Asset, String>
		implements IAssetService {
	private static Logger logger = Logger.getLogger(AssetServiceImpl.class
			.getName());

	@Resource
	private AssetMapper assetMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.IAssetService#deleteByPrimaryKey((java.lang.String
	 * ))
	 */
	@Override
	@Transactional
	public int deleteByPrimaryKey(String id) {
		super.deleteByPrimaryKey(id);

		int result = assetMapper.deleteByPrimaryKey(id);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.IAssetService#insert(com.jcin.cms.domain.Asset)
	 */
	@Override
	@Transactional
	public int insert(Asset record) {
		super.insert(record);

//		record.setCreatedate(new Date().getTime());
		int result = assetMapper.insert(record);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jcin.cms.service.IAssetService#select(com.jcin.cms.utils.Page)
	 */
	@Override
	public Page select(Page page) {
		super.select(page);

		AssetCriteria assetCriteria = new AssetCriteria();
		assetCriteria.setPage(page);
		@SuppressWarnings("rawtypes")
		List list = assetMapper.selectByExample(assetCriteria);
		page.setRows(list);
		int total = assetMapper.countByExample(assetCriteria);
		page.setTotal(total);
		return page;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jcin.cms.service.ICommentService#select(com.jcin.cms.domain.
	 * AssetCriteria)
	 */
	@Override
	public Page select(AssetCriteria criteria) {
		Page page = new Page();
		@SuppressWarnings("rawtypes")
		List list = assetMapper.selectByExample(criteria);
		page.setRows(list);
		int total = assetMapper.countByExample(criteria);
		page.setTotal(total);
		return page;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.IAssetService#selectByPrimaryKey(java.lang.String)
	 */
	@Override
	public Asset selectByPrimaryKey(String id) {
		super.selectByPrimaryKey(id);

		Asset asset = assetMapper.selectByPrimaryKey(id);
		return asset;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.IAssetService#update(com.jcin.cms.domain.Asset)
	 */
	@Override
	@Transactional
	public int update(Asset record) {
		super.update(record);

		int result = assetMapper.updateByPrimaryKeySelective(record);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.IAssetService#insertBatch(List)
	 */
	@Override
	public int insertBatch(List<Asset> list) {
		int result = assetMapper.insertBatch(list);
		super.insertBatch(list);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.IAssetService#deleteBatch(List)
	 */
	@Override
	public int deleteBatch(List<String> list) {
		int result = assetMapper.deleteBatch(list);
		super.deleteBatch(list);
		return result;
	}
}
