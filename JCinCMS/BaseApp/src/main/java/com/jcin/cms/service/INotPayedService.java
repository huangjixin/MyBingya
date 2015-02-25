/**
 * 一句话描述该类：<br/>
 * @author 黄记新
 * @date 2014-12-18,下午6:53:59
 *
 */
package com.jcin.cms.service;

import com.jcin.cms.domain.NotPayed;
import com.jcin.cms.domain.NotPayedCriteria;
import com.jcin.cms.utils.Page;

public interface INotPayedService extends IBaseService<NotPayed, String>{
	/**
	 * 封装查询条件，返回Page对象。
	 * @param criteria
	 * @return
	 */
	Page select(NotPayedCriteria criteria);
	
	double getTotalGoodsMoney(NotPayedCriteria example);
}
