/**
 * 
 */
package com.bingya.service.content.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bingya.dao.system.CommentMapper;
import com.bingya.domain.system.ArticleExample;
import com.bingya.domain.system.Comment;
import com.bingya.domain.system.CommentExample;
import com.bingya.service.content.ICommentService;
import com.bingya.util.Page;

/**
 * @author huangjixin
 * 
 */
@Transactional
@Service(value = "commentService")
@RemotingDestination(value = "commentServiceImpl", channels = { "my-amf" })
public class CommentServiceImpl implements ICommentService {
	// ---------------------------------------------------
	// 常量（全部大写，用下划线分割），变量 （先常后私）
	// ---------------------------------------------------
	@Resource
	private CommentMapper commentMapper;

	// ---------------------------------------------------
	// public 公有方法
	// ---------------------------------------------------

	// ---------------------------------------------------
	// protected 方法
	// ---------------------------------------------------

	// ---------------------------------------------------
	// private 私有方法
	// ---------------------------------------------------
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bingya.service.IGenericService#deleteByPrimaryKey(java.lang.Integer)
	 */
	@Override
	public int deleteByPrimaryKey(String id) {
		// 外键删除完毕；
		int i = commentMapper.deleteByPrimaryKey(id);
		return i;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bingya.service.IGenericService#insert(java.io.Serializable)
	 */
	@Override
	public String insert(Comment entity) {
		if(entity.getId()==null||"".equals(entity.getId())){
			 int count = commentMapper.countByExample(null);
			 entity.setId(count+1+"");
		}
		commentMapper.insertSelective(entity);
		return entity.getId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bingya.service.IGenericService#selectAll()
	 */
	@Override
	public List<Comment> selectAll() {
		return commentMapper.selectByExample(null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bingya.service.IGenericService#selectByPrimaryKey(java.lang.Integer)
	 */
	@Override
	public Comment selectByPrimaryKey(String id) {
		return commentMapper.selectByPrimaryKey(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bingya.service.IGenericService#update(java.io.Serializable)
	 */
	@Override
	public String update(Comment entity) {
		return commentMapper.updateByExampleSelective(entity, null)+"";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bingya.service.IGenericService#query(com.bingya.util.Page,
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public Page query(Page page, String key, String orderCondition) {
		key = "%" + key + "%";
		CommentExample commentExample = new CommentExample();
		// commentExample.createCriteria().andDescriptionLike(key);
		commentExample.setPage(page);
		int total = commentMapper.countByExample(commentExample);
		page.setTotal(total);
		List<Comment> list = commentMapper.selectByExample(commentExample);
		page.setRows(list);
		return page;
	}

}
