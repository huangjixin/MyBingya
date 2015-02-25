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

import com.jcin.cms.dao.NotPayedMapper;
import com.jcin.cms.domain.NotPayed;
import com.jcin.cms.domain.NotPayedCriteria;
import com.jcin.cms.service.INotPayedService;
import com.jcin.cms.utils.Page;

/**
 * @author 黄记新
 * @date 2014-12-18,下午6:56:55
 * 
 */
@Service(value = "notPayedService")
public class NotPayedServiceImpl extends BaseServiceImpl<NotPayed, String>
		implements INotPayedService {
	private static Logger logger = Logger.getLogger(NotPayedServiceImpl.class
			.getName());

	@Resource
	private NotPayedMapper notPayedMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.INotPayedService#deleteByPrimaryKey((java.lang.String
	 * ))
	 */
	@Override
	@Transactional
	public int deleteByPrimaryKey(String id) {
		super.deleteByPrimaryKey(id);

		int result = notPayedMapper.deleteByPrimaryKey(id);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.INotPayedService#insert(com.jcin.cms.domain.NotPayed
	 * )
	 */
	@Override
	@Transactional
	public String insert(NotPayed record) {
		super.insert(record);

		// record.setCreatedate(new Date().getTime());
		int result = notPayedMapper.insert(record);
		String id = record.getId();
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.INotPayedService#select(com.jcin.cms.utils.Page)
	 */
	@Override
	public Page select(Page page) {
		super.select(page);

		NotPayedCriteria notPayedCriteria = new NotPayedCriteria();
		notPayedCriteria.setPage(page);
		@SuppressWarnings("rawtypes")
		List list = notPayedMapper.selectByExample(notPayedCriteria);
		page.setRows(list);
		int total = notPayedMapper.countByExample(notPayedCriteria);
		page.setTotal(total);
		return page;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jcin.cms.service.ICommentService#select(com.jcin.cms.domain.
	 * NotPayedCriteria)
	 */
	@Override
	public Page select(NotPayedCriteria criteria) {
		Page page = new Page();
		@SuppressWarnings("rawtypes")
		List list = notPayedMapper.selectByExample(criteria);
		page.setRows(list);
		int total = notPayedMapper.countByExample(criteria);
		page.setTotal(total);
		return page;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.INotPayedService#selectByPrimaryKey(java.lang.String
	 * )
	 */
	@Override
	public NotPayed selectByPrimaryKey(String id) {
		super.selectByPrimaryKey(id);

		NotPayed notPayed = notPayedMapper.selectByPrimaryKey(id);
		return notPayed;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.INotPayedService#update(com.jcin.cms.domain.NotPayed
	 * )
	 */
	@Override
	@Transactional
	public String update(NotPayed record) {
		super.update(record);

		int result = notPayedMapper.updateByPrimaryKeySelective(record);
		return record.getId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jcin.cms.service.INotPayedService#insertBatch(List)
	 */
	@Override
	public int insertBatch(List<NotPayed> list) {
		int result = notPayedMapper.insertBatch(list);
		super.insertBatch(list);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jcin.cms.service.INotPayedService#deleteBatch(List)
	 */
	@Override
	public int deleteBatch(List<String> list) {
		int result = notPayedMapper.deleteBatch(list);
		super.deleteBatch(list);
		return result;
	}
	

	@Override
	public double getTotalGoodsMoney(NotPayedCriteria example) {
		double result = notPayedMapper.getTotalGoodsMoney(example);
		return result;
	}
}
