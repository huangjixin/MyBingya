package com.jcin.cms.modules.syst.service;

import com.jcin.cms.modules.syst.domain.Log;
import com.jcin.cms.modules.syst.domain.LogCriteria;
import com.jcin.cms.service.IBaseService;
import com.jcin.cms.utils.Page;

public interface ILogService extends IBaseService<Log, String> {
	/**
	 * 封装查询条件，返回Page对象。
	 * 
	 * @param criteria
	 * @return
	 */
	Page select(LogCriteria criteria);
}