/**
 * 一句话描述该类：<br/>
 * @author 黄记新
 * @date 2014-12-18,下午6:53:59
 *
 */
package com.jcin.cms.service;

import java.util.List;

import com.jcin.cms.domain.Category;
import com.jcin.cms.domain.CategoryCriteria;
import com.jcin.cms.utils.Page;

public interface ICategoryService extends IBaseService<Category, String> {
	/**
	 * 封装查询条件，返回Page对象。
	 * 
	 * @param criteria
	 * @return
	 */
	Page select(CategoryCriteria criteria);

	/**
	 * 查询树形结构的目录。
	 * 
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	List getCategoryTree();
}
