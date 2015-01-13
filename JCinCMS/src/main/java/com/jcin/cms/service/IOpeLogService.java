/**
 * 中兴软创<br/>
 * 一句话描述该类：<br/>
 * @author 黄记新
 * @date 2014-12-18,下午6:53:59
 *
 */
package com.jcin.cms.service;

import java.util.List;

import com.jcin.cms.domain.Operationlog;
import com.jcin.cms.domain.OperationlogCriteria;
import com.jcin.cms.utils.Page;

public interface IOpeLogService extends IBaseService<Operationlog, String> {
	/**
	 * 封装查询条件，返回Page对象。
	 * @param criteria
	 * @return
	 */
	Page select(OperationlogCriteria criteria);
	
	int insertBatch(List<Operationlog> list);
}
