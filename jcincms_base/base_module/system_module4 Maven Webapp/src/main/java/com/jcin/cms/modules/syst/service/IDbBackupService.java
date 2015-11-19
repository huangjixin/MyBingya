package com.jcin.cms.modules.syst.service;

import java.util.List;

import com.jcin.cms.modules.syst.domain.DbBackup;
import com.jcin.cms.modules.syst.domain.DbBackupCriteria;
import com.jcin.cms.modules.syst.service.IDbBackupService;
import com.jcin.cms.service.IBaseService;
import com.jcin.cms.utils.Page;

public interface IDbBackupService extends IBaseService<DbBackup, String> {
	/**
	 * 封装查询条件，返回Page对象。
	 * 
	 * @param criteria
	 * @return
	 */
	Page select(DbBackupCriteria criteria);

	/**
	 * 根据查询条件进行查询
	 * 
	 * @param dictionaryCriteria
	 * @return
	 */
	List<DbBackup> selectByExample(DbBackupCriteria criteria);

	void backup();

	void load(String name);
}