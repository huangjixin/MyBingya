/**
 * 
 */
package com.jcin.cms.service.system.impl;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.jcin.cms.service.IDataBaseBackupTask;
import com.jcin.cms.service.system.IMySQLService;

/**
 * @author Administrator
 *
 */
@Service
public class DataBaseBackupTaskImpl implements IDataBaseBackupTask {

	@Resource
	private IMySQLService mySQLService;
	
	/* (non-Javadoc)
	 * @see com.jcin.cms.service.IDataBaseBackupTask#backup()
	 */
	@Override
	@Scheduled(cron="0 0 23 * * ?")   //每天晚上十一點点触发 
	public void backup() {
//		Mysqlbackup record = new  Mysqlbackup();
//		mySQLService.insert(record);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
