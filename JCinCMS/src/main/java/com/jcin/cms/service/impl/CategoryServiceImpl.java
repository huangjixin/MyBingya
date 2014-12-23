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

import com.jcin.cms.dao.CategoryMapper;
import com.jcin.cms.domain.Category;
import com.jcin.cms.domain.CategoryCriteria;
import com.jcin.cms.service.ICategoryService;
import com.jcin.cms.utils.Page;

/**
 * @author 黄记新
 * @date 2014-12-18,下午6:56:55
 * 
 */
@Service(value = "categoryService")
public class CategoryServiceImpl extends BaseServiceImpl<Category, String>
		implements ICategoryService {
	private static Logger logger = Logger.getLogger(CategoryServiceImpl.class
			.getName());

	@Resource
	private CategoryMapper categoryMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.ICategoryService#deleteByPrimaryKey((java.lang.String
	 * ))
	 */
	@Override
	public int deleteByPrimaryKey(String id) {
		super.deleteByPrimaryKey(id);

		int result = categoryMapper.deleteByPrimaryKey(id);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.ICategoryService#insert(com.jcin.cms.domain.Category
	 * )
	 */
	@Override
	@Transactional
	public int insert(Category record) {
		super.insert(record);

		int result = categoryMapper.insert(record);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.ICategoryService#select(com.jcin.cms.utils.Page)
	 */
	@Override
	public Page select(Page page) {
		super.select(page);

		CategoryCriteria categoryCriteria = new CategoryCriteria();
		categoryCriteria.setPage(page);
		@SuppressWarnings("rawtypes")
		List list = categoryMapper.selectByExample(categoryCriteria);
		page.setRows(list);
		int total = categoryMapper.countByExample(categoryCriteria);
		page.setTotal(total);
		
		return page;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.ICategoryService#selectByPrimaryKey(java.lang.String
	 * )
	 */
	@Override
	public Category selectByPrimaryKey(String id) {
		super.selectByPrimaryKey(id);

		Category category = categoryMapper.selectByPrimaryKey(id);
		return category;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.ICategoryService#update(com.jcin.cms.domain.Category
	 * )
	 */
	@Override
	@Transactional
	public int update(Category record) {
		super.update(record);

		int result = categoryMapper.updateByPrimaryKeySelective(record);
		return result;
	}

}
