/**
 * 中兴软创<br/>
 * 一句话描述该类：<br/>
 * @author 黄记新
 * @date 2014-12-18,下午6:53:59
 *
 */
package com.jcin.cms.service;

import com.jcin.cms.domain.Menu;
import com.jcin.cms.utils.Page;

public interface IMenuService {
	int deleteByPrimaryKey(String id);

	int insert(Menu record);

	Page select(Page page);

	Menu selectByPrimaryKey(String id);

	int update(Menu record);
}
