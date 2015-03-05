/**
 * 一句话描述该类：<br/>
 * @author 黄记新
 * @date 2014-12-18,下午6:53:59
 *
 */
package com.jcin.cms.service.system;

import com.jcin.cms.domain.system.Operationlog;
import com.jcin.cms.domain.system.OperationlogCriteria;
import com.jcin.cms.service.IBaseService;
import com.jcin.cms.utils.Page;

public interface IOpeLogService extends IBaseService<Operationlog, String> {
	/**
	 * 封装查询条件，返回Page对象。
	 * @param criteria
	 * @return
	 */
	Page select(OperationlogCriteria criteria);
}
