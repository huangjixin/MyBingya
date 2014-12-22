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

import com.jcin.cms.dao.CommentMapper;
import com.jcin.cms.domain.Comment;
import com.jcin.cms.domain.CommentCriteria;
import com.jcin.cms.service.ICommentService;
import com.jcin.cms.utils.Page;

/**
 * @author 黄记新
 * @date 2014-12-18,下午6:56:55
 * 
 */
@Service(value = "commentService")
public class CommentServiceImpl implements ICommentService {
	private static Logger logger = Logger.getLogger(CommentServiceImpl.class.getName());
	
	@Resource
	private CommentMapper commentMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.ICommentService#deleteByPrimaryKey((java.lang.String))
	 */
	@Override
	public int deleteByPrimaryKey(String id) {
		int result = commentMapper.deleteByPrimaryKey(id);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jcin.cms.service.ICommentService#insert(com.jcin.cms.domain.Comment)
	 */
	@Override
	@Transactional
	public int insert(Comment record) {
		int result = commentMapper.insert(record);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jcin.cms.service.ICommentService#select(com.jcin.cms.utils.Page)
	 */
	@Override
	public Page select(Page page) {
		CommentCriteria commentCriteria = new CommentCriteria();
		commentCriteria.setPage(page);
		@SuppressWarnings("rawtypes")
		List list = commentMapper.selectByExample(commentCriteria);
		page.setRows(list);
		return page;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.ICommentService#selectByPrimaryKey(java.lang.String)
	 */
	@Override
	public Comment selectByPrimaryKey(String id) {
		Comment comment = commentMapper.selectByPrimaryKey(id);
		return comment;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jcin.cms.service.ICommentService#update(com.jcin.cms.domain.Comment)
	 */
	@Override
	@Transactional
	public int update(Comment record) {
		int result = commentMapper.updateByPrimaryKeySelective(record);
		return result;
	}

}
