/**
 * 一句话描述该类：<br/>
 * @author 黄记新
 * @date 2015-4-26,下午6:56:55
 *
 */
package com.jcin.cms.modules.channel.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jcin.cms.modules.channel.dao.CommentMapper;
import com.jcin.cms.modules.channel.domain.Comment;
import com.jcin.cms.modules.channel.domain.CommentCriteria;
import com.jcin.cms.modules.channel.service.ICommentService;
import com.jcin.cms.service.impl.BaseServiceImpl;
import com.jcin.cms.utils.Page;

/**
 * @author 黄记新
 * @date 2014-12-18,下午6:56:55
 * 
 */
@Service(value="commentService")
public class CommentServiceImpl extends BaseServiceImpl<Comment, String>
		implements ICommentService {
	private static Logger logger = LoggerFactory.getLogger(CommentServiceImpl.class
			.getName());

	@Autowired
	private CommentMapper commentMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.channel.ICommentService#deleteByPrimaryKey((java.lang
	 * .String ))
	 */
	@Override
	@Transactional
	public int deleteByPrimaryKey(String id) {
		// super.deleteByPrimaryKey(id);

		int result = commentMapper.deleteByPrimaryKey(id);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.channel.ICommentService#insert(com.jcin.cms.service.channel.
	 * Comment)
	 */
	@Override
	@Transactional
	public String insert(Comment record) {
		 super.insert(record);

		record.setCreateDate(new Date());
		int result = commentMapper.insert(record);
		String id = record.getId();
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.channel.ICommentService#select(com.jcin.cms.utils.Page)
	 */
	@Override
	public Page select(Page page) {
		super.select(page);
		//setOrderByClause("SER_NO  asc , ORG_ID desc");  
		CommentCriteria commentCriteria = new CommentCriteria();
		commentCriteria.setOrderByClause("id desc");
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
	 * com.jcin.cms.service.channel.ICommentService#select(com.jcin.cms.service.channel.CommentCriteria)
	 */
	//@Override
	public Page select(CommentCriteria criteria) {
		Page page = new Page();
		if(null != criteria){
			if(null != criteria.getPage()){
				page = criteria.getPage();
			}
		}
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
	 * com.jcin.cms.service.channel.ICommentService#selectAll()
	 */
	@Override
	public List<Comment> selectAll() {
		List<Comment> list = commentMapper.selectByExample(null);
		return list;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.channel.ICommentService#selectByPrimaryKey(java.lang
	 * .String)
	 */
	@Override
	public Comment selectByPrimaryKey(String id) {
		super.selectByPrimaryKey(id);

		Comment article = commentMapper.selectByPrimaryKey(id);
		return article;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.channel.ICommentService#update(com.jcin.cms.service.channel.
	 * Comment)
	 */
	@Override
	@Transactional
	public String update(Comment record) {
		// super.update(record);
		record.setUpdateDate(new Date());
		int result = commentMapper.updateByPrimaryKey(record);
		return record.getId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.channel.ICommentService#insertBatch(List)
	 */
	@Override
	@Transactional
	public int insertBatch(List<Comment> list) {
		int result = commentMapper.insertBatch(list);
		super.insertBatch(list);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.channel.ICommentService#deleteBatch(List)
	 */
	@Override
	@Transactional
	public int deleteBatch(List<String> list) {
		CommentCriteria commentCriteria = new CommentCriteria();
		commentCriteria.createCriteria().andIdIn(list);
		int result = commentMapper.deleteByExample(commentCriteria);
		super.deleteBatch(list);
		return result;
	}
	
	
	@Override
	public List<Comment> selectByExample(
			CommentCriteria criteria) {
		return  commentMapper.selectByExample(criteria);
	}

}
