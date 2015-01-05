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

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jcin.cms.dao.ArticleMapper;
import com.jcin.cms.domain.Article;
import com.jcin.cms.domain.ArticleCriteria;
import com.jcin.cms.domain.CategoryCriteria;
import com.jcin.cms.service.IArticleService;
import com.jcin.cms.utils.Page;

/**
 * @author 黄记新
 * @date 2014-12-18,下午6:56:55
 * 
 */
@Service(value = "articleService")
public class ArticleServiceImpl extends BaseServiceImpl<Article, String>
		implements IArticleService {
	private static Logger logger = Logger.getLogger(ArticleServiceImpl.class
			.getName());

	@Resource
	private ArticleMapper articleMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.IArticleService#deleteByPrimaryKey((java.lang.String
	 * ))
	 */
	@Override
	@Transactional
	public int deleteByPrimaryKey(String id) {
		super.deleteByPrimaryKey(id);

		int result = articleMapper.deleteByPrimaryKey(id);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.IArticleService#insert(com.jcin.cms.domain.Article)
	 */
	@Override
	@Transactional
	public int insert(Article record) {
		super.insert(record);

		record.setCreatedate(new Date());
		int result = articleMapper.insert(record);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jcin.cms.service.IArticleService#select(com.jcin.cms.utils.Page)
	 */
	@Override
	public Page select(Page page) {
		super.select(page);

		ArticleCriteria articleCriteria = new ArticleCriteria();
		articleCriteria.setPage(page);
		@SuppressWarnings("rawtypes")
		List list = articleMapper.selectByExample(articleCriteria);
		page.setRows(list);
		int total = articleMapper.countByExample(articleCriteria);
		page.setTotal(total);
		return page;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jcin.cms.service.ICommentService#select(com.jcin.cms.domain.
	 * ArticleCriteria)
	 */
	@Override
	public Page select(ArticleCriteria criteria) {
		Page page = new Page();
		@SuppressWarnings("rawtypes")
		List list = articleMapper.selectByExample(criteria);
		page.setRows(list);
		int total = articleMapper.countByExample(criteria);
		page.setTotal(total);
		return page;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.IArticleService#selectByPrimaryKey(java.lang.String)
	 */
	@Override
	public Article selectByPrimaryKey(String id) {
		super.selectByPrimaryKey(id);

		Article article = articleMapper.selectByPrimaryKey(id);
		return article;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.IArticleService#update(com.jcin.cms.domain.Article)
	 */
	@Override
	@Transactional
	public int update(Article record) {
		super.update(record);

		int result = articleMapper.updateByPrimaryKeySelective(record);
		return result;
	}

}
