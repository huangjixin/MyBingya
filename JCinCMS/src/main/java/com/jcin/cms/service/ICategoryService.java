/**
 * 中兴软创<br/>
 * 一句话描述该类：<br/>
 * @author 黄记新
 * @date 2014-12-18,下午6:53:59
 *
 */
package com.jcin.cms.service;

import com.jcin.cms.domain.Category;
import com.jcin.cms.utils.Page;

public interface ICategoryService {
	int deleteByPrimaryKey(String id);

	int insert(Category record);

	Page select(Page page);

	Category selectByPrimaryKey(String id);

	int update(Category record);
}
