/**
 * 一句话描述该类：<br/>
 * @author 黄记新
 * @date 2015-4-26,下午6:56:55
 *
 */
package com.jcin.cms.modules.pro.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jcin.cms.modules.pro.dao.CategoryMapper;
import com.jcin.cms.modules.pro.domain.Category;
import com.jcin.cms.modules.pro.domain.CategoryCriteria;
import com.jcin.cms.modules.pro.service.ICategoryService;
import com.jcin.cms.service.impl.BaseServiceImpl;
import com.jcin.cms.utils.Page;

/**
 * @author 黄记新
 * @date 2014-12-18,下午6:56:55
 * 
 */
@Service(value = "categoryService")
public class CategoryServiceImpl extends BaseServiceImpl<Category, String>
		implements ICategoryService {
	private static Logger logger = LoggerFactory
			.getLogger(CategoryServiceImpl.class);

	@Autowired
	private CategoryMapper categoryMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.ICategoryService#deleteByPrimaryKey((java.lang
	 * .String ))
	 */
	@Override
	@Transactional
	public int deleteByPrimaryKey(String id) {
		// super.deleteByPrimaryKey(id);

		int result = categoryMapper.deleteByPrimaryKey(id);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.ICategoryService#insert(com.jcin.cms.service
	 * .pro. Category)
	 */
	@Override
	@Transactional
	public String insert(Category record) {
		if (record.getId() == null)
			super.insert(record);
		if (null == record.getCreateDate())
			record.setCreateDate(new Date());

		if ("".equals(record.getParentId()))
			record.setParentId(null);

		int result = categoryMapper.insert(record);
		String id = record.getId();
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.ICategoryService#select(com.jcin.cms.utils.Page)
	 */
	@Override
	public Page select(Page page) {
		super.select(page);
		// setOrderByClause("SER_NO  asc , ORG_ID desc");
		CategoryCriteria categoryCriteria = new CategoryCriteria();
		categoryCriteria.setOrderByClause("id desc");
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
	 * com.jcin.cms.service.pro.ICategoryService#select(com.jcin.cms.service
	 * .pro.CategoryCriteria)
	 */
	// @Override
	@Override
	public Page select(CategoryCriteria criteria) {
		Page page = new Page();
		if (null != criteria) {
			if (null != criteria.getPage()) {
				page = criteria.getPage();
			}
		}
		@SuppressWarnings("rawtypes")
		List list = categoryMapper.selectByExample(criteria);
		page.setRows(list);
		int total = categoryMapper.countByExample(criteria);
		page.setTotal(total);
		return page;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jcin.cms.service.pro.ICategoryService#selectAll()
	 */
	@Override
	public List<Category> selectAll() {
		List<Category> list = categoryMapper.selectByExample(null);
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.ICategoryService#selectByPrimaryKey(java.lang
	 * .String)
	 */
	@Override
	public Category selectByPrimaryKey(String id) {
		super.selectByPrimaryKey(id);

		Category record = categoryMapper.selectByPrimaryKey(id);
		return record;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.ICategoryService#update(com.jcin.cms.service
	 * .pro. Category)
	 */
	@Override
	@Transactional
	public String update(Category record) {
		// super.update(record);
		// if(null==record.getUpdateDate())
		record.setUpdateDate(new Date());
		int result = categoryMapper.updateByPrimaryKeySelective(record);
		return record.getId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jcin.cms.service.pro.ICategoryService#insertBatch(List)
	 */
	@Override
	@Transactional
	public int insertBatch(List<Category> list) {
		int result = categoryMapper.insertBatch(list);
		super.insertBatch(list);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jcin.cms.service.pro.ICategoryService#deleteBatch(List)
	 */
	@Override
	@Transactional
	public int deleteBatch(List<String> list) {
		CategoryCriteria categoryCriteria = new CategoryCriteria();
		categoryCriteria.createCriteria().andIdIn(list);
		int result = categoryMapper.deleteByExample(categoryCriteria);
		super.deleteBatch(list);
		return result;
	}

	@Override
	public List<Category> selectByExample(CategoryCriteria criteria) {
		return categoryMapper.selectByExample(criteria);
	}

	@Override
	public List<Category> getCategoryTree() {
		CategoryCriteria categoryExample = new CategoryCriteria();
		categoryExample.createCriteria().andParentIdIsNull();
		categoryExample.setOrderByClause("sortid asc");
		List<Category> list = categoryMapper.selectByExample(categoryExample);
		List<Category> children = new ArrayList<Category>();
		for (Category object : list) {
			Category jsonObject;
			jsonObject = searialCategory(object);
			if (jsonObject != null) {
				children.add(jsonObject);
			}

		}
		return children;
	}

	@SuppressWarnings("rawtypes")
	public Category searialCategory(Category category) {
		Category jsonObject = new Category();
		jsonObject.setId(category.getId());
		jsonObject.setParentId(category.getParentId());
		jsonObject.setName(category.getName());
		jsonObject.setCreateDate(category.getCreateDate());
		jsonObject.setUpdateDate(category.getUpdateDate());
		jsonObject.setSortid(category.getSortid());

		List<Category> list = searialChild(category);
		if (null != list) {
			jsonObject.setChildren(list);
		}

		return jsonObject;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Category> searialChild(Category category) {
		List children = null;
		List<Category> list = getByParentId(category.getId());
		if (list != null && list.size() > 0) {
			children = new ArrayList();
		}
		for (Category object : list) {
			Category jsonObject = searialCategory(object);
			if (jsonObject != null) {
				children.add(jsonObject);
			}
		}
		return children;
	}

	@Override
	public List<Category> getByParentId(String id) {
		CategoryCriteria categoryExample = new CategoryCriteria();
		categoryExample.createCriteria().andParentIdEqualTo(id);
		categoryExample.setOrderByClause("sortid asc");
		List<Category> list = categoryMapper.selectByExample(categoryExample);
		return list;
	}
}
