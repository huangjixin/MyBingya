/**
 * 中兴软创<br/>
 * 一句话描述该类：<br/>
 * @author 黄记新
 * @date 2014-12-18,下午6:53:59
 *
 */
package com.jcin.cms.service;

import com.jcin.cms.domain.Mysqlbackup;
import com.jcin.cms.domain.MysqlbackupCriteria;
import com.jcin.cms.utils.Page;

public interface IMySQLService extends IBaseService<Mysqlbackup, String> {
	/**
	 * 封装查询条件，返回Page对象。
	 * 
	 * @param criteria
	 * @return
	 */
	Page select(MysqlbackupCriteria criteria);
}
