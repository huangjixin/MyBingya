/**
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
public class CommentServiceImpl extends BaseServiceImpl<Comment, String>
		implements ICommentService {
	private static Logger logger = Logger.getLogger(CommentServiceImpl.class
			.getName());

	@Resource
	private CommentMapper commentMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.ICommentService#deleteByPrimaryKey((java.lang.String
	 * ))
	 */
	@Override
	@Transactional
	public int deleteByPrimaryKey(String id) {
		super.deleteByPrimaryKey(id);

		int result = commentMapper.deleteByPrimaryKey(id);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.ICommentService#insert(com.jcin.cms.domain.Comment)
	 */
	@Override
	@Transactional
	public String insert(Comment record) {
		super.insert(record);

		int result = commentMapper.insert(record);
		String id = record.getId();
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jcin.cms.service.ICommentService#select(com.jcin.cms.utils.Page)
	 */
	@Override
	public Page select(Page page) {
		super.select(page);

		CommentCriteria commentCriteria = new CommentCriteria();
		commentCriteria.setPage(page);
		@SuppressWarnings("rawtypes")
		List list = commentMapper.selectByExample(commentCriteria);
		page.setRows(list);
		int total = commentMapper.countByExample(commentCriteria);
		page.setTotal(total);
		return page;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.ICommentService#select(com.jcin.cms.domain.CommentCriteria)
	 */
	@Override
	public Page select(CommentCriteria criteria) {
		Page page = new Page();
		@SuppressWarnings("rawtypes")
		List list = commentMapper.selectByExample(criteria);
		page.setRows(list);
		int total = commentMapper.countByExample(criteria);
		page.setTotal(total);
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
		super.selectByPrimaryKey(id);

		Comment comment = commentMapper.selectByPrimaryKey(id);
		return comment;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.ICommentService#update(com.jcin.cms.domain.Comment)
	 */
	@Override
	@Transactional
	public String update(Comment record) {
		super.update(record);

		int result = commentMapper.updateByPrimaryKeySelective(record);
		return record.getId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.ICommentService#insertBatch(List)
	 */
	@Override
	public int insertBatch(List<Comment> list) {
		int result = commentMapper.insertBatch(list);
		super.insertBatch(list);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.ICommentService#deleteBatch(List)
	 */
	@Override
	public int deleteBatch(List<String> list) {
		int result = commentMapper.deleteBatch(list);
		super.deleteBatch(list);
		return result;
	}
}
