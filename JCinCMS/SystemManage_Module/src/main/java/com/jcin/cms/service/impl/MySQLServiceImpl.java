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

import com.jcin.cms.dao.MysqlbackupMapper;
import com.jcin.cms.domain.Mysqlbackup;
import com.jcin.cms.domain.MysqlbackupCriteria;
import com.jcin.cms.service.IMySQLService;
import com.jcin.cms.utils.Page;

/**
 * @author 黄记新
 * @date 2014-12-18,下午6:56:55
 * 
 */
@Service(value = "mysqlService")
public class MySQLServiceImpl extends BaseServiceImpl<Mysqlbackup, String>
		implements IMySQLService {
	private static Logger logger = Logger.getLogger(MySQLServiceImpl.class
			.getName());

	@Resource
	private MysqlbackupMapper mysqlMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.IMysqlbackupService#deleteByPrimaryKey((java.lang
	 * .String))
	 */
	@Override
	@Transactional
	public int deleteByPrimaryKey(String id) {
		// super.deleteByPrimaryKey(id);

		int result = mysqlMapper.deleteByPrimaryKey(id);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jcin.cms.service.IMysqlbackupService#insert(com.jcin.cms.domain.
	 * Mysqlbackup)
	 */
	@Override
	@Transactional
	public String insert(Mysqlbackup record) {
		super.insert(record);

		// record.setCreatedate(new Date());
		int result = mysqlMapper.insert(record);
		String id = record.getId();
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.IMysqlbackupService#select(com.jcin.cms.utils.Page)
	 */
	@Override
	public Page select(Page page) {
		// super.select(page);

		MysqlbackupCriteria userCriteria = new MysqlbackupCriteria();
		userCriteria.setPage(page);
		@SuppressWarnings("rawtypes")
		List list = mysqlMapper.selectByExample(userCriteria);
		page.setRows(list);
		int total = mysqlMapper.countByExample(userCriteria);
		page.setTotal(total);
		return page;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jcin.cms.service.IMysqlbackupService#select(com.jcin.cms.domain.
	 * MysqlbackupCriteria)
	 */
	@Override
	public Page select(MysqlbackupCriteria criteria) {
		Page page = new Page();
		@SuppressWarnings("rawtypes")
		List list = mysqlMapper.selectByExample(criteria);
		page.setRows(list);
		int total = mysqlMapper.countByExample(criteria);
		page.setTotal(total);
		return page;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.IMysqlbackupService#selectByPrimaryKey(java.lang
	 * .String)
	 */
	@Override
	public Mysqlbackup selectByPrimaryKey(String id) {
		// super.selectByPrimaryKey(id);

		Mysqlbackup user = mysqlMapper.selectByPrimaryKey(id);
		return user;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jcin.cms.service.IMysqlbackupService#update(com.jcin.cms.domain.
	 * Mysqlbackup)
	 */
	@Override
	@Transactional
	public String update(Mysqlbackup record) {
		super.update(record);

		int result = mysqlMapper.updateByPrimaryKey(record);
		return record.getId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.IMysqlbackupService#insertBatch(List)
	 */
	@Override
	public int insertBatch(List<Mysqlbackup> list) {
		int result = mysqlMapper.insertBatch(list);
		super.insertBatch(list);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.IMysqlbackupService#deleteBatch(List)
	 */
	@Override
	public int deleteBatch(List<String> list) {
		int result = mysqlMapper.deleteBatch(list);
		super.deleteBatch(list);
		return result;
	}
}
