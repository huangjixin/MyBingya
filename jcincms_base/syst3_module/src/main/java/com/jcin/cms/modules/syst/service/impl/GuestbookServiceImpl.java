/**
 * 一句话描述该类：<br/>
 * @author 黄记新
 * @date 2015-4-26,下午6:56:55
 *
 */
package com.jcin.cms.modules.syst.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.jcin.cms.modules.syst.dao.GuestbookMapper;
import com.jcin.cms.modules.syst.domain.Guestbook;
import com.jcin.cms.modules.syst.domain.GuestbookCriteria;
import com.jcin.cms.modules.syst.service.IGuestbookService;
import com.jcin.cms.service.impl.BaseServiceImpl;
import com.jcin.cms.utils.Page;

/**
 * @author 黄记新
 * @date 2014-12-18,下午6:56:55
 * 
 */
@Service(value="guestbookService")
public class GuestbookServiceImpl extends BaseServiceImpl<Guestbook, String>
		implements IGuestbookService {
	private static Logger logger = Logger.getLogger(GuestbookServiceImpl.class
			.getName());

	@Autowired
	private GuestbookMapper guestbookMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.syst.IGuestbookService#deleteByPrimaryKey((java.lang
	 * .String ))
	 */
	@Override
	@Transactional
	public int deleteByPrimaryKey(String id) {
		// super.deleteByPrimaryKey(id);

		int result = guestbookMapper.deleteByPrimaryKey(id);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.syst.IGuestbookService#insert(com.jcin.cms.service.syst.
	 * Guestbook)
	 */
	@Override
	@Transactional
	public String insert(Guestbook record) {
		if(record.getId()==null)
		 	super.insert(record);

		record.setCreateDate(new Date());
		int result = guestbookMapper.insert(record);
		String id = record.getId();
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.syst.IGuestbookService#select(com.jcin.cms.utils.Page)
	 */
	@Override
	public Page select(Page page) {
		super.select(page);
		//setOrderByClause("SER_NO  asc , ORG_ID desc");  
		GuestbookCriteria guestbookCriteria = new GuestbookCriteria();
		guestbookCriteria.setOrderByClause("id desc");
		guestbookCriteria.setPage(page);
		@SuppressWarnings("rawtypes")
		List list = guestbookMapper.selectByExample(guestbookCriteria);
		page.setRows(list);
		int total = guestbookMapper.countByExample(guestbookCriteria);
		page.setTotal(total);
		return page;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.syst.IGuestbookService#select(com.jcin.cms.service.syst.GuestbookCriteria)
	 */
	//@Override
	public Page select(GuestbookCriteria criteria) {
		Page page = new Page();
		if(null != criteria){
			if(null != criteria.getPage()){
				page = criteria.getPage();
			}
		}
		@SuppressWarnings("rawtypes")
		List list = guestbookMapper.selectByExample(criteria);
		page.setRows(list);
		int total = guestbookMapper.countByExample(criteria);
		page.setTotal(total);
		return page;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.syst.IGuestbookService#selectAll()
	 */
	@Override
	public List<Guestbook> selectAll() {
		List<Guestbook> list = guestbookMapper.selectByExample(null);
		return list;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.syst.IGuestbookService#selectByPrimaryKey(java.lang
	 * .String)
	 */
	@Override
	public Guestbook selectByPrimaryKey(String id) {
		super.selectByPrimaryKey(id);

		Guestbook record = guestbookMapper.selectByPrimaryKey(id);
		return record;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.syst.IGuestbookService#update(com.jcin.cms.service.syst.
	 * Guestbook)
	 */
	@Override
	@Transactional
	public String update(Guestbook record) {
		// super.update(record);
		record.setUpdateDate(new Date());
		int result = guestbookMapper.updateByPrimaryKey(record);
		return record.getId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.syst.IGuestbookService#insertBatch(List)
	 */
	@Override
	@Transactional
	public int insertBatch(List<Guestbook> list) {
		int result = guestbookMapper.insertBatch(list);
		super.insertBatch(list);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.syst.IGuestbookService#deleteBatch(List)
	 */
	@Override
	@Transactional
	public int deleteBatch(List<String> list) {
		GuestbookCriteria guestbookCriteria = new GuestbookCriteria();
		guestbookCriteria.createCriteria().andIdIn(list);
		int result = guestbookMapper.deleteByExample(guestbookCriteria);
		super.deleteBatch(list);
		return result;
	}
	
	
	@Override
	public List<Guestbook> selectByExample(
			GuestbookCriteria criteria) {
		return  guestbookMapper.selectByExample(criteria);
	}

}
