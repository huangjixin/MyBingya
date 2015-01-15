/**
 * 中兴软创<br/>
 * 一句话描述该类：<br/>
 * @author 黄记新
 * @date 2014-12-18,下午6:53:59
 *
 */
package com.jcin.cms.service;

import com.jcin.cms.domain.Article;
import com.jcin.cms.domain.ArticleCriteria;
import com.jcin.cms.utils.Page;

public interface IArticleService extends IBaseService<Article, String>{
	/**
	 * 封装查询条件，返回Page对象。
	 * @param criteria
	 * @return
	 */
	Page select(ArticleCriteria criteria);
}
