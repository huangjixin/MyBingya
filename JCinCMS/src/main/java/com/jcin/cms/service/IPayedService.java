/**
 * 一句话描述该类：<br/>
 * @author 黄记新
 * @date 2014-12-18,下午6:53:59
 *
 */
package com.jcin.cms.service;

import com.jcin.cms.domain.Payed;
import com.jcin.cms.domain.PayedCriteria;
import com.jcin.cms.utils.Page;

public interface IPayedService extends IBaseService<Payed, String>{
	/**
	 * 封装查询条件，返回Page对象。
	 * @param criteria
	 * @return
	 */
	Page select(PayedCriteria criteria);
	
	double getTotalGoodsMoney(PayedCriteria example);
}
