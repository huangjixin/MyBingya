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

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

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
	@Transactional
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
	 * @see com.jcin.cms.service.ICommentService#select(com.jcin.cms.domain.
	 * CategoryCriteria)
	 */
	@Override
	public Page select(CategoryCriteria criteria) {
		Page page = new Page();
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
	 * @see
	 * com.jcin.cms.service.ICategoryService#selectByPrimaryKey(java.lang.String
	 * )
	 */
	@Override
	public Category selectByPrimaryKey(String id) {
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

	@Override
	public List getCategoryTree() {
		CategoryCriteria categorCriteria = new CategoryCriteria();
		categorCriteria.createCriteria().andParentidIsNull();

		List<Category> list = categoryMapper.selectByExample(categorCriteria);
		List children = new ArrayList();
		for (Category object : list) {

			JSONObject jsonObject;

			jsonObject = searialChild(object);
			children.add(jsonObject);
		}
		return children;
	}

	@SuppressWarnings("rawtypes")
	public JSONObject searialChild(Category Category) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("id", Category.getId());
		jsonObject.put("parentid", Category.getParentid());
		jsonObject.put("name", Category.getName());
		jsonObject.put("createdate", Category.getCreatedate());
		jsonObject.put("description", Category.getDescription());
		jsonObject.put("updatedate", Category.getUpdatedate());

		List list = searialChildren(Category);
		if (null != list) {
			jsonObject.put("children", list);
		}

		return jsonObject;
	}

	public List<Category> getByParentId(String id) {
		CategoryCriteria categorCriteria = new CategoryCriteria();
		categorCriteria.createCriteria().andParentidEqualTo(id);
		List<Category> list = categoryMapper.selectByExample(categorCriteria);

		return list;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List searialChildren(Category category) {
		List children = null;
		List<Category> list = getByParentId(category.getId());
		if (list != null && list.size() > 0) {
			children = new ArrayList();
		}
		for (Category object : list) {

			JSONObject jsonObject = searialChild(object);
			children.add(jsonObject);
		}
		return children;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.ICategoryService#insertBatch(List)
	 */
	@Override
	public int insertBatch(List<Category> list) {
		int result = categoryMapper.insertBatch(list);
		super.insertBatch(list);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.ICategoryService#deleteBatch(List)
	 */
	@Override
	public int deleteBatch(List<String> list) {
		int result = categoryMapper.deleteBatch(list);
		super.deleteBatch(list);
		return result;
	}
}
