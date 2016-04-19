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

import com.jcin.cms.modules.pro.dao.OrderMapper;
import com.jcin.cms.modules.pro.domain.Order;
import com.jcin.cms.modules.pro.domain.OrderCriteria;
import com.jcin.cms.modules.pro.service.IOrderService;
import com.jcin.cms.service.impl.BaseServiceImpl;
import com.jcin.cms.utils.Page;

/**
 * @author 黄记新
 * @date 2014-12-18,下午6:56:55
 * 
 */
@Service(value="orderService")
public class OrderServiceImpl extends BaseServiceImpl<Order, String>
		implements IOrderService {
	private static Logger logger = Logger.getLogger(OrderServiceImpl.class
			.getName());

	@Autowired
	private OrderMapper orderMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.IOrderService#deleteByPrimaryKey((java.lang
	 * .String ))
	 */
	@Override
	@Transactional
	public int deleteByPrimaryKey(String id) {
		// super.deleteByPrimaryKey(id);

		int result = orderMapper.deleteByPrimaryKey(id);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.IOrderService#insert(com.jcin.cms.service.pro.
	 * Order)
	 */
	@Override
	@Transactional
	public String insert(Order record) {
		if(record.getId()==null)
		 	super.insert(record);
		if(null==record.getCreateDate())
			record.setCreateDate(new Date());
		int result = orderMapper.insert(record);
		String id = record.getId();
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.IOrderService#select(com.jcin.cms.utils.Page)
	 */
	@Override
	public Page select(Page page) {
		super.select(page);
		//setOrderByClause("SER_NO  asc , ORG_ID desc");  
		OrderCriteria orderCriteria = new OrderCriteria();
		orderCriteria.setOrderByClause("id desc");
		orderCriteria.setPage(page);
		@SuppressWarnings("rawtypes")
		List list = orderMapper.selectByExample(orderCriteria);
		page.setRows(list);
		int total = orderMapper.countByExample(orderCriteria);
		page.setTotal(total);
		return page;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.IOrderService#select(com.jcin.cms.service.pro.OrderCriteria)
	 */
	//@Override
	public Page select(OrderCriteria criteria) {
		Page page = new Page();
		if(null != criteria){
			if(null != criteria.getPage()){
				page = criteria.getPage();
			}
		}
		@SuppressWarnings("rawtypes")
		List list = orderMapper.selectByExample(criteria);
		page.setRows(list);
		int total = orderMapper.countByExample(criteria);
		page.setTotal(total);
		return page;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.IOrderService#selectAll()
	 */
	@Override
	public List<Order> selectAll() {
		List<Order> list = orderMapper.selectByExample(null);
		return list;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.IOrderService#selectByPrimaryKey(java.lang
	 * .String)
	 */
	@Override
	public Order selectByPrimaryKey(String id) {
		super.selectByPrimaryKey(id);

		Order record = orderMapper.selectByPrimaryKey(id);
		return record;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.IOrderService#update(com.jcin.cms.service.pro.
	 * Order)
	 */
	@Override
	@Transactional
	public String update(Order record) {
		// super.update(record);
		if(null==record.getUpdateDate())
			record.setUpdateDate(new Date());
		int result = orderMapper.updateByPrimaryKey(record);
		return record.getId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.IOrderService#insertBatch(List)
	 */
	@Override
	@Transactional
	public int insertBatch(List<Order> list) {
		int result = orderMapper.insertBatch(list);
		super.insertBatch(list);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.pro.IOrderService#deleteBatch(List)
	 */
	@Override
	@Transactional
	public int deleteBatch(List<String> list) {
		OrderCriteria orderCriteria = new OrderCriteria();
		orderCriteria.createCriteria().andIdIn(list);
		int result = orderMapper.deleteByExample(orderCriteria);
		super.deleteBatch(list);
		return result;
	}
	
	
	@Override
	public List<Order> selectByExample(
			OrderCriteria criteria) {
		return  orderMapper.selectByExample(criteria);
	}

}
