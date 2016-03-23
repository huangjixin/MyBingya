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

import com.jcin.cms.modules.bet.dao.AccountMapper;
import com.jcin.cms.modules.bet.domain.Account;
import com.jcin.cms.modules.bet.domain.AccountCriteria;
import com.jcin.cms.modules.bet.service.IAccountService;
import com.jcin.cms.service.impl.BaseServiceImpl;
import com.jcin.cms.utils.Page;

/**
 * @author 黄记新
 * @date 2014-12-18,下午6:56:55
 * 
 */
@Service(value="accountService")
public class AccountServiceImpl extends BaseServiceImpl<Account, String>
		implements IAccountService {
	private static Logger logger = Logger.getLogger(AccountServiceImpl.class
			.getName());

	@Autowired
	private AccountMapper accountMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.bet.IAccountService#deleteByPrimaryKey((java.lang
	 * .String ))
	 */
	@Override
	@Transactional
	public int deleteByPrimaryKey(String id) {
		// super.deleteByPrimaryKey(id);

		int result = accountMapper.deleteByPrimaryKey(id);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.bet.IAccountService#insert(com.jcin.cms.service.bet.
	 * Account)
	 */
	@Override
	@Transactional
	public String insert(Account record) {
		if(record.getId()==null)
		 	super.insert(record);

		record.setCreateDate(new Date());
		int result = accountMapper.insert(record);
		String id = record.getId();
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.bet.IAccountService#select(com.jcin.cms.utils.Page)
	 */
	@Override
	public Page select(Page page) {
		super.select(page);
		//setOrderByClause("SER_NO  asc , ORG_ID desc");  
		AccountCriteria accountCriteria = new AccountCriteria();
		accountCriteria.setOrderByClause("id desc");
		accountCriteria.setPage(page);
		@SuppressWarnings("rawtypes")
		List list = accountMapper.selectByExample(accountCriteria);
		page.setRows(list);
		int total = accountMapper.countByExample(accountCriteria);
		page.setTotal(total);
		return page;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.bet.IAccountService#select(com.jcin.cms.service.bet.AccountCriteria)
	 */
	//@Override
	public Page select(AccountCriteria criteria) {
		Page page = new Page();
		if(null != criteria){
			if(null != criteria.getPage()){
				page = criteria.getPage();
			}
		}
		@SuppressWarnings("rawtypes")
		List list = accountMapper.selectByExample(criteria);
		page.setRows(list);
		int total = accountMapper.countByExample(criteria);
		page.setTotal(total);
		return page;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.bet.IAccountService#selectAll()
	 */
	@Override
	public List<Account> selectAll() {
		List<Account> list = accountMapper.selectByExample(null);
		return list;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.bet.IAccountService#selectByPrimaryKey(java.lang
	 * .String)
	 */
	@Override
	public Account selectByPrimaryKey(String id) {
		super.selectByPrimaryKey(id);

		Account record = accountMapper.selectByPrimaryKey(id);
		return record;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.bet.IAccountService#update(com.jcin.cms.service.bet.
	 * Account)
	 */
	@Override
	@Transactional
	public String update(Account record) {
		// super.update(record);
		record.setUpdateDate(new Date());
		int result = accountMapper.updateByPrimaryKey(record);
		return record.getId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.bet.IAccountService#insertBatch(List)
	 */
	@Override
	@Transactional
	public int insertBatch(List<Account> list) {
		int result = accountMapper.insertBatch(list);
		super.insertBatch(list);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.bet.IAccountService#deleteBatch(List)
	 */
	@Override
	@Transactional
	public int deleteBatch(List<String> list) {
		AccountCriteria accountCriteria = new AccountCriteria();
		accountCriteria.createCriteria().andIdIn(list);
		int result = accountMapper.deleteByExample(accountCriteria);
		super.deleteBatch(list);
		return result;
	}
	
	
	@Override
	public List<Account> selectByExample(
			AccountCriteria criteria) {
		return  accountMapper.selectByExample(criteria);
	}

}
