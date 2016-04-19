/**
 * 一句话描述该类：<br/>
 * @author 黄记新
 * @date 2015-4-26,下午6:56:55
 *
 */
package com.jcin.cms.modules.pro.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.jcin.cms.modules.pro.dao.OrderCommentMapper;
import com.jcin.cms.modules.pro.domain.OrderComment;
import com.jcin.cms.modules.pro.domain.OrderCommentCriteria;
import com.jcin.cms.modules.pro.service.IOrderCommentService;
import com.jcin.cms.service.impl.BaseServiceImpl;
import com.jcin.cms.utils.Page;

/**
 * @author 黄记新
 * @date 2014-12-18,下午6:56:55
 * 
 */
@Service(value="orderCommentService")
public class OrderCommentServiceImpl extends BaseServiceImpl<OrderComment, String>
		implements IOrderCommentService {
	private static Logger logger = Logger.getLogger(OrderCommentServiceImpl.class
			.getName());

	@Autowired
	private OrderCommentMapper orderCommentMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.IOrderCommentService#deleteByPrimaryKey((java.lang
	 * .String ))
	 */
	@Override
	@Transactional
	public int deleteByPrimaryKey(String id) {
		// super.deleteByPrimaryKey(id);

		int result = orderCommentMapper.deleteByPrimaryKey(id);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.IOrderCommentService#insert(com.jcin.cms.service.pro.
	 * OrderComment)
	 */
	@Override
	@Transactional
	public String insert(OrderComment record) {
		if(record.getId()==null)
		 	super.insert(record);
		if(null==record.getCreateDate())
			record.setCreateDate(new Date());
		int result = orderCommentMapper.insert(record);
		String id = record.getId();
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.IOrderCommentService#select(com.jcin.cms.utils.Page)
	 */
	@Override
	public Page select(Page page) {
		super.select(page);
		//setOrderByClause("SER_NO  asc , ORG_ID desc");  
		OrderCommentCriteria orderCommentCriteria = new OrderCommentCriteria();
		orderCommentCriteria.setOrderByClause("id desc");
		orderCommentCriteria.setPage(page);
		@SuppressWarnings("rawtypes")
		List list = orderCommentMapper.selectByExample(orderCommentCriteria);
		page.setRows(list);
		int total = orderCommentMapper.countByExample(orderCommentCriteria);
		page.setTotal(total);
		return page;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.IOrderCommentService#select(com.jcin.cms.service.pro.OrderCommentCriteria)
	 */
	//@Override
	public Page select(OrderCommentCriteria criteria) {
		Page page = new Page();
		if(null != criteria){
			if(null != criteria.getPage()){
				page = criteria.getPage();
			}
		}
		@SuppressWarnings("rawtypes")
		List list = orderCommentMapper.selectByExample(criteria);
		page.setRows(list);
		int total = orderCommentMapper.countByExample(criteria);
		page.setTotal(total);
		return page;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.IOrderCommentService#selectAll()
	 */
	@Override
	public List<OrderComment> selectAll() {
		List<OrderComment> list = orderCommentMapper.selectByExample(null);
		return list;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.IOrderCommentService#selectByPrimaryKey(java.lang
	 * .String)
	 */
	@Override
	public OrderComment selectByPrimaryKey(String id) {
		super.selectByPrimaryKey(id);

		OrderComment record = orderCommentMapper.selectByPrimaryKey(id);
		return record;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.IOrderCommentService#update(com.jcin.cms.service.pro.
	 * OrderComment)
	 */
	@Override
	@Transactional
	public String update(OrderComment record) {
		// super.update(record);
		if(null==record.getUpdateDate())
			record.setUpdateDate(new Date());
		int result = orderCommentMapper.updateByPrimaryKey(record);
		return record.getId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.IOrderCommentService#insertBatch(List)
	 */
	@Override
	@Transactional
	public int insertBatch(List<OrderComment> list) {
		int result = orderCommentMapper.insertBatch(list);
		super.insertBatch(list);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.IOrderCommentService#deleteBatch(List)
	 */
	@Override
	@Transactional
	public int deleteBatch(List<String> list) {
		OrderCommentCriteria orderCommentCriteria = new OrderCommentCriteria();
		orderCommentCriteria.createCriteria().andIdIn(list);
		int result = orderCommentMapper.deleteByExample(orderCommentCriteria);
		super.deleteBatch(list);
		return result;
	}
	
	
	@Override
	public List<OrderComment> selectByExample(
			OrderCommentCriteria criteria) {
		return  orderCommentMapper.selectByExample(criteria);
	}

}
