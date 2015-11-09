/**
 * 一句话描述该类：<br/>
 * @author 黄记新
 * @date 2015-4-26,下午6:56:55
 *
 */
package com.jcin.cms.modules.syst.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jcin.cms.common.MysqlUtil;
import com.jcin.cms.modules.syst.dao.DbBackupMapper;
import com.jcin.cms.modules.syst.domain.DbBackup;
import com.jcin.cms.modules.syst.domain.DbBackupCriteria;
import com.jcin.cms.modules.syst.service.IDbBackupService;
import com.jcin.cms.service.impl.BaseServiceImpl;
import com.jcin.cms.utils.Page;

/**
 * @author 黄记新
 * @date 2014-12-18,下午6:56:55
 * 
 */
@Service(value="dbBackupService")
public class DbBackupServiceImpl extends BaseServiceImpl<DbBackup, String>
		implements IDbBackupService {
	private static Logger logger = Logger.getLogger(DbBackupServiceImpl.class
			.getName());

	@Resource
	private DbBackupMapper dbBackupMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.syst.IDbBackupService#deleteByPrimaryKey((java.lang
	 * .String ))
	 */
	@Override
	@Transactional
	public int deleteByPrimaryKey(String id) {
		// super.deleteByPrimaryKey(id);

		int result = dbBackupMapper.deleteByPrimaryKey(id);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.syst.IDbBackupService#insert(com.jcin.cms.service.syst.
	 * DbBackup)
	 */
	@Override
	@Transactional
	public String insert(DbBackup record) {
		 super.insert(record);

		record.setCreateDate(new Date());
		int result = dbBackupMapper.insert(record);
		String id = record.getId();
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.syst.IDbBackupService#select(com.jcin.cms.utils.Page)
	 */
	@Override
	public Page select(Page page) {
		super.select(page);
		//setOrderByClause("SER_NO  asc , ORG_ID desc");  
		DbBackupCriteria dbBackupCriteria = new DbBackupCriteria();
		dbBackupCriteria.setOrderByClause("id desc");
		dbBackupCriteria.setPage(page);
		@SuppressWarnings("rawtypes")
		List list = dbBackupMapper.selectByExample(dbBackupCriteria);
		page.setRows(list);
		int total = dbBackupMapper.countByExample(dbBackupCriteria);
		page.setTotal(total);
		return page;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.syst.IDbBackupService#select(com.jcin.cms.service.syst.DbBackupCriteria)
	 */
	//@Override
	public Page select(DbBackupCriteria criteria) {
		Page page = new Page();
		if(null != criteria){
			if(null != criteria.getPage()){
				page = criteria.getPage();
			}
		}
		@SuppressWarnings("rawtypes")
		List list = dbBackupMapper.selectByExample(criteria);
		page.setRows(list);
		int total = dbBackupMapper.countByExample(criteria);
		page.setTotal(total);
		return page;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.syst.IDbBackupService#selectAll()
	 */
	@Override
	public List<DbBackup> selectAll() {
		List<DbBackup> list = dbBackupMapper.selectByExample(null);
		return list;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.syst.IDbBackupService#selectByPrimaryKey(java.lang
	 * .String)
	 */
	@Override
	public DbBackup selectByPrimaryKey(String id) {
		super.selectByPrimaryKey(id);

		DbBackup article = dbBackupMapper.selectByPrimaryKey(id);
		return article;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.syst.IDbBackupService#update(com.jcin.cms.service.syst.
	 * DbBackup)
	 */
	@Override
	@Transactional
	public String update(DbBackup record) {
		// super.update(record);
//		record.setUpdateDate(new Date());
		int result = dbBackupMapper.updateByPrimaryKeySelective(record);
		return record.getId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.syst.IDbBackupService#insertBatch(List)
	 */
	@Override
	@Transactional
	public int insertBatch(List<DbBackup> list) {
		int result = dbBackupMapper.insertBatch(list);
		super.insertBatch(list);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.syst.IDbBackupService#deleteBatch(List)
	 */
	@Override
	@Transactional
	public int deleteBatch(List<String> list) {
		DbBackupCriteria dbBackupCriteria = new DbBackupCriteria();
		dbBackupCriteria.createCriteria().andIdIn(list);
		int result = dbBackupMapper.deleteByExample(dbBackupCriteria);
		super.deleteBatch(list);
		return result;
	}
	
	
	@Override
	public List<DbBackup> selectByExample(
			DbBackupCriteria criteria) {
		return  dbBackupMapper.selectByExample(criteria);
	}

	@Override
	@Transactional(readOnly=false)
	public void backup() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd");
		String name = sdf.format(new Date());
		name+=".sql";
		String path = MysqlUtil.backup(name);
		
		DbBackup dbBackup = new DbBackup();
		dbBackup.setId(UUID.randomUUID().toString());
		dbBackup.setName(name);
		dbBackup.setCreateDate(new Date());
		dbBackup.setPath(path);
		dbBackupMapper.insert(dbBackup);
	}

	@Override
	public void load(String name) {
		MysqlUtil.load(name);
	}
	
	/*@Scheduled(fixedRate = 5000)  
	public void doSomething() {   
		System.out.println("hello,world");
	}*/  
	
	@Scheduled(cron = "0 0 12 * * ?")//每天凌晨两点执行  
    void doSomethingWith(){  
        logger.info("定时任务开始......");  
        long begin = System.currentTimeMillis();  
      
        //执行数据库操作了哦...  
        backup();
        long end = System.currentTimeMillis();  
        logger.info("定时任务结束，共耗时：[" + (end-begin) / 1000 + "]秒");  
	} 

}
