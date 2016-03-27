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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jcin.cms.modules.sale.dao.ProductMapper;
import com.jcin.cms.modules.sale.domain.Buy;
import com.jcin.cms.modules.sale.domain.BuyCriteria;
import com.jcin.cms.modules.sale.domain.Product;
import com.jcin.cms.modules.sale.domain.ProductCriteria;
import com.jcin.cms.modules.sale.domain.ProductSaleTj;
import com.jcin.cms.modules.sale.domain.Sale;
import com.jcin.cms.modules.sale.domain.SaleCriteria;
import com.jcin.cms.modules.sale.service.IBuyService;
import com.jcin.cms.modules.sale.service.IProductService;
import com.jcin.cms.modules.sale.service.ISaleService;
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

	@Autowired
	private IBuyService buyService;
	@Autowired
	private ISaleService saleService;
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.sale.IProductService#deleteByPrimaryKey((java.lang
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
	 * com.jcin.cms.service.sale.IProductService#insert(com.jcin.cms.service.sale.
	 * Product)
	 */
	@Override
	@Transactional
	public String insert(Product record) {
		if(record.getId()==null)
		 	super.insert(record);

		record.setCreateDate(new Date());
		int result = productMapper.insert(record);
		String id = record.getId();
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.sale.IProductService#select(com.jcin.cms.utils.Page)
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
	 * com.jcin.cms.service.sale.IProductService#select(com.jcin.cms.service.sale.ProductCriteria)
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
	 * com.jcin.cms.service.sale.IProductService#selectAll()
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
	 * com.jcin.cms.service.sale.IProductService#selectByPrimaryKey(java.lang
	 * .String)
	 */
	@Override
	public Product selectByPrimaryKey(String id) {
		super.selectByPrimaryKey(id);

		Product record = productMapper.selectByPrimaryKey(id);
		return record;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.sale.IProductService#update(com.jcin.cms.service.sale.
	 * Product)
	 */
	@Override
	@Transactional
	public String update(Product product) {
		// super.update(record);
//		record.setUpdateDate(new Date());
		int result = productMapper.updateByPrimaryKey(product);
		
		BuyCriteria buyCriteria = new BuyCriteria();
		buyCriteria.createCriteria().andProIdEqualTo(product.getId());
		Buy buy = new Buy();
		buy.setProName(product.getName());
		buyService.updateByExampleSelective(buy, buyCriteria);
		
		SaleCriteria saleCriteria = new SaleCriteria();
		saleCriteria.createCriteria().andProIdEqualTo(product.getId());
		Sale sale = new Sale();
		sale.setProName(product.getName());
		saleService.updateByExampleSelective(sale, saleCriteria);
		
		return product.getId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.sale.IProductService#insertBatch(List)
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
	 * com.jcin.cms.service.sale.IProductService#deleteBatch(List)
	 */
	@Override
	@Transactional
	public int deleteBatch(List<String> list) {
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

	@Override
	public Page selectTongjiByExample(Product record,
			ProductCriteria example) {
		Page page = new Page();
		if(null != example){
			if(null != example.getPage()){
				page = example.getPage();
			}
		}
		List<ProductSaleTj> list = productMapper.selectTongjiByExample(record,example);
		page.setRows(list);
		int total = productMapper.countTongjiByExample(record,example);
		page.setTotal(total);
		return page;
	}

	@Override
	public Page selectProByExample( Product record, ProductCriteria example) {
		Page page = new Page();
		if(null != example){
			if(null != example.getPage()){
				page = example.getPage();
			}
		}
		List<ProductSaleTj> list = productMapper.selectProByExample(record,example);
		page.setRows(list);
		int total = productMapper.countProByExample(record,example);
		page.setTotal(total);
		return page;
	}

}
