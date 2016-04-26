/**
 * 一句话描述该类：<br/>
 * @author 黄记新
 * @date 2015-4-26,下午6:56:55
 *
 */
package com.jcin.cms.modules.pro.service.impl;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jcin.cms.common.FileUtils;
import com.jcin.cms.modules.channel.dao.AssetsMapper;
import com.jcin.cms.modules.channel.domain.Assets;
import com.jcin.cms.modules.channel.domain.Document;
import com.jcin.cms.modules.pro.dao.ProductMapper;
import com.jcin.cms.modules.pro.domain.Product;
import com.jcin.cms.modules.pro.domain.ProductCriteria;
import com.jcin.cms.modules.pro.domain.ProductWithBLOBs;
import com.jcin.cms.modules.pro.service.IProductService;
import com.jcin.cms.service.impl.BaseServiceImpl;
import com.jcin.cms.utils.Page;

/**
 * @author 黄记新
 * @date 2014-12-18,下午6:56:55
 * 
 */
@Service(value="productService")
public class ProductServiceImpl extends BaseServiceImpl<Product, String>
		implements IProductService {
	private static Logger logger = Logger.getLogger(ProductServiceImpl.class
			.getName());

	@Autowired
	private ProductMapper productMapper;

	@Resource
	private AssetsMapper assetsMapper;
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.IProductService#deleteByPrimaryKey((java.lang
	 * .String ))
	 */
	@Override
	@Transactional
	public int deleteByPrimaryKey(String id) {
		// super.deleteByPrimaryKey(id);

		int result = productMapper.deleteByPrimaryKey(id);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.IProductService#insert(com.jcin.cms.service.pro.
	 * Product)
	 */
	@Override
	@Transactional
	public String insert(ProductWithBLOBs record) {
		if(record.getId()==null || "".equals(record.getId())){
			record.setId(""+new Date().getTime());
		}
		if(null==record.getCreateDate()){
			record.setCreateDate(new Date());
		}
		int result = productMapper.insert(record);
		String id = record.getId();
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.IProductService#select(com.jcin.cms.utils.Page)
	 */
	@Override
	public Page select(Page page) {
		super.select(page);
		//setOrderByClause("SER_NO  asc , ORG_ID desc");  
		ProductCriteria productCriteria = new ProductCriteria();
		productCriteria.setOrderByClause("id desc");
		productCriteria.setPage(page);
		@SuppressWarnings("rawtypes")
		List list = productMapper.selectByExample(productCriteria);
		page.setRows(list);
		int total = productMapper.countByExample(productCriteria);
		page.setTotal(total);
		return page;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.IProductService#select(com.jcin.cms.service.pro.ProductCriteria)
	 */
	//@Override
	public Page select(ProductCriteria criteria) {
		Page page = new Page();
		if(null != criteria){
			if(null != criteria.getPage()){
				page = criteria.getPage();
			}
		}
		@SuppressWarnings("rawtypes")
		List list = productMapper.selectByExample(criteria);
		page.setRows(list);
		int total = productMapper.countByExample(criteria);
		page.setTotal(total);
		return page;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.IProductService#selectAll()
	 */
	@Override
	public List<Product> selectAll() {
		List<Product> list = productMapper.selectByExample(null);
		return list;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.IProductService#selectByPrimaryKey(java.lang
	 * .String)
	 */
	@Override
	public ProductWithBLOBs selectByPrimaryKey(String id) {
		super.selectByPrimaryKey(id);

		ProductWithBLOBs record = productMapper.selectByPrimaryKey(id);
		return record;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.IProductService#update(com.jcin.cms.service.pro.
	 * Product)
	 */
	@Override
	@Transactional
	public String update(ProductWithBLOBs record) {
		// super.update(record);
//		if(null==record.getUpdateDate())
			record.setUpdateDate(new Date());
		int result = productMapper.updateByPrimaryKeySelective(record);
		return record.getId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.IProductService#insertBatch(List)
	 */
	@Override
	@Transactional
	public int insertBatch(List<Product> list) {
		int result = productMapper.insertBatch(list);
		super.insertBatch(list);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.IProductService#deleteBatch(List)
	 */
	@Override
	@Transactional
	public int deleteBatch(List<String> list) {
		if(list.size()>0){
			for (String id : list) {
				Product product = productMapper.selectByPrimaryKey(id);
				String assetsIds = product.getAssets();
				if(null != assetsIds && !"".equals(assetsIds)){
					String[] ids = assetsIds.split(",");
					for (String assetid : ids) {
						Assets assets = assetsMapper.selectByPrimaryKey(assetid);
						if(assets!=null){
							String uploadPath = assets.getPath();
							String webroot = System.getProperty("zwtech.root");
							uploadPath = webroot+ uploadPath;
							if(null!=uploadPath && !"".equals(uploadPath)){
								File file = new File(uploadPath);
								logger.info(file.exists());
								FileUtils.deleteFile(uploadPath);
							}
							
							assetsMapper.deleteByPrimaryKey(assetid);
						}
						
					}
				}
			}
		}
		ProductCriteria productCriteria = new ProductCriteria();
		productCriteria.createCriteria().andIdIn(list);
		int result = productMapper.deleteByExample(productCriteria);
		super.deleteBatch(list);
		return result;
	}
	
	
	@Override
	public List<Product> selectByExample(
			ProductCriteria criteria) {
		return  productMapper.selectByExample(criteria);
	}

}
