/**
 * 一句话描述该类：<br/>
 * @author 黄记新
 * @date 2015-4-26,下午6:56:55
 *
 */
package com.jcin.cms.modules.bet.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.jcin.cms.modules.bet.dao.AccountHistoryMapper;
import com.jcin.cms.modules.bet.domain.AccountHistory;
import com.jcin.cms.modules.bet.domain.AccountHistoryCriteria;
import com.jcin.cms.modules.bet.service.IAccountHistoryService;
import com.jcin.cms.service.impl.BaseServiceImpl;
import com.jcin.cms.utils.Page;

/**
 * @author 黄记新
 * @date 2014-12-18,下午6:56:55
 * 
 */
@Service(value="accountHistoryService")
public class AccountHistoryServiceImpl extends BaseServiceImpl<AccountHistory, String>
		implements IAccountHistoryService {
	private static Logger logger = Logger.getLogger(AccountHistoryServiceImpl.class
			.getName());

	@Autowired
	private AccountHistoryMapper accountHistoryMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.bet.IAccountHistoryService#deleteByPrimaryKey((java.lang
	 * .String ))
	 */
	@Override
	@Transactional
	public int deleteByPrimaryKey(String id) {
		// super.deleteByPrimaryKey(id);

		int result = accountHistoryMapper.deleteByPrimaryKey(id);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.bet.IAccountHistoryService#insert(com.jcin.cms.service.bet.
	 * AccountHistory)
	 */
	@Override
	@Transactional
	public String insert(AccountHistory record) {
		if(record.getId()==null)
		 	super.insert(record);

		record.setCreateDate(new Date());
		int result = accountHistoryMapper.insert(record);
		String id = record.getId();
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.bet.IAccountHistoryService#select(com.jcin.cms.utils.Page)
	 */
	@Override
	public Page select(Page page) {
		super.select(page);
		//setOrderByClause("SER_NO  asc , ORG_ID desc");  
		AccountHistoryCriteria accountHistoryCriteria = new AccountHistoryCriteria();
		accountHistoryCriteria.setOrderByClause("id desc");
		accountHistoryCriteria.setPage(page);
		@SuppressWarnings("rawtypes")
		List list = accountHistoryMapper.selectByExample(accountHistoryCriteria);
		page.setRows(list);
		int total = accountHistoryMapper.countByExample(accountHistoryCriteria);
		page.setTotal(total);
		return page;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.bet.IAccountHistoryService#select(com.jcin.cms.service.bet.AccountHistoryCriteria)
	 */
	//@Override
	public Page select(AccountHistoryCriteria criteria) {
		Page page = new Page();
		if(null != criteria){
			if(null != criteria.getPage()){
				page = criteria.getPage();
			}
		}
		@SuppressWarnings("rawtypes")
		List list = accountHistoryMapper.selectByExample(criteria);
		page.setRows(list);
		int total = accountHistoryMapper.countByExample(criteria);
		page.setTotal(total);
		return page;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.bet.IAccountHistoryService#selectAll()
	 */
	@Override
	public List<AccountHistory> selectAll() {
		List<AccountHistory> list = accountHistoryMapper.selectByExample(null);
		return list;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.bet.IAccountHistoryService#selectByPrimaryKey(java.lang
	 * .String)
	 */
	@Override
	public AccountHistory selectByPrimaryKey(String id) {
		super.selectByPrimaryKey(id);

		AccountHistory record = accountHistoryMapper.selectByPrimaryKey(id);
		return record;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.bet.IAccountHistoryService#update(com.jcin.cms.service.bet.
	 * AccountHistory)
	 */
	@Override
	@Transactional
	public String update(AccountHistory record) {
		// super.update(record);
		record.setUpdateDate(new Date());
		int result = accountHistoryMapper.updateByPrimaryKey(record);
		return record.getId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.bet.IAccountHistoryService#insertBatch(List)
	 */
	@Override
	@Transactional
	public int insertBatch(List<AccountHistory> list) {
		int result = accountHistoryMapper.insertBatch(list);
		super.insertBatch(list);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.bet.IAccountHistoryService#deleteBatch(List)
	 */
	@Override
	@Transactional
	public int deleteBatch(List<String> list) {
		AccountHistoryCriteria accountHistoryCriteria = new AccountHistoryCriteria();
		accountHistoryCriteria.createCriteria().andIdIn(list);
		int result = accountHistoryMapper.deleteByExample(accountHistoryCriteria);
		super.deleteBatch(list);
		return result;
	}
	
	
	@Override
	public List<AccountHistory> selectByExample(
			AccountHistoryCriteria criteria) {
		return  accountHistoryMapper.selectByExample(criteria);
	}

}
