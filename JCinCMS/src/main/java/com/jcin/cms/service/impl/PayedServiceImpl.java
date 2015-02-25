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

import com.jcin.cms.dao.PayedMapper;
import com.jcin.cms.domain.Payed;
import com.jcin.cms.domain.PayedCriteria;
import com.jcin.cms.service.IPayedService;
import com.jcin.cms.utils.Page;

/**
 * @author 黄记新
 * @date 2014-12-18,下午6:56:55
 * 
 */
@Service(value = "payedService")
public class PayedServiceImpl extends BaseServiceImpl<Payed, String> implements
		IPayedService {
	private static Logger logger = Logger.getLogger(PayedServiceImpl.class
			.getName());

	@Resource
	private PayedMapper payedMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.IPayedService#deleteByPrimaryKey((java.lang.String
	 * ))
	 */
	@Override
	@Transactional
	public int deleteByPrimaryKey(String id) {
		super.deleteByPrimaryKey(id);

		int result = payedMapper.deleteByPrimaryKey(id);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jcin.cms.service.IPayedService#insert(com.jcin.cms.domain.Payed)
	 */
	@Override
	@Transactional
	public String insert(Payed record) {
		super.insert(record);

		// record.setCreatedate(new Date().getTime());
		int result = payedMapper.insert(record);
		String id = record.getId();
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jcin.cms.service.IPayedService#select(com.jcin.cms.utils.Page)
	 */
	@Override
	public Page select(Page page) {
		super.select(page);

		PayedCriteria payedCriteria = new PayedCriteria();
		payedCriteria.setPage(page);
		@SuppressWarnings("rawtypes")
		List list = payedMapper.selectByExample(payedCriteria);
		page.setRows(list);
		int total = payedMapper.countByExample(payedCriteria);
		page.setTotal(total);
		return page;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jcin.cms.service.ICommentService#select(com.jcin.cms.domain.
	 * PayedCriteria)
	 */
	@Override
	public Page select(PayedCriteria criteria) {
		Page page = new Page();
		@SuppressWarnings("rawtypes")
		List list = payedMapper.selectByExample(criteria);
		page.setRows(list);
		int total = payedMapper.countByExample(criteria);
		page.setTotal(total);
		return page;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.IPayedService#selectByPrimaryKey(java.lang.String)
	 */
	@Override
	public Payed selectByPrimaryKey(String id) {
		super.selectByPrimaryKey(id);

		Payed payed = payedMapper.selectByPrimaryKey(id);
		return payed;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jcin.cms.service.IPayedService#update(com.jcin.cms.domain.Payed)
	 */
	@Override
	@Transactional
	public int update(Payed record) {
		super.update(record);

		int result = payedMapper.updateByPrimaryKeySelective(record);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jcin.cms.service.IPayedService#insertBatch(List)
	 */
	@Override
	public int insertBatch(List<Payed> list) {
		int result = payedMapper.insertBatch(list);
		super.insertBatch(list);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jcin.cms.service.IPayedService#deleteBatch(List)
	 */
	@Override
	@Transactional
	public int deleteBatch(List<String> list) {
		int result = payedMapper.deleteBatch(list);
		return result;
	}

	@Override
	public double getTotalGoodsMoney(PayedCriteria example) {
		double result = payedMapper.getTotalGoodsMoney(example);
		return result;
	}
}
