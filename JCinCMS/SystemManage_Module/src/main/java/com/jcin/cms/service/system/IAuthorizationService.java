/**
 * 一句话描述该类：<br/>
 * @author 黄记新
 * @date 2014-12-18,下午6:53:59
 *
 */
package com.jcin.cms.service.system;

import java.util.List;

import com.jcin.cms.domain.system.Authorization;
import com.jcin.cms.domain.system.AuthorizationCriteria;
import com.jcin.cms.service.IBaseService;
import com.jcin.cms.service.system.impl.vo.AuthorizationExtention;
import com.jcin.cms.utils.Page;

public interface IAuthorizationService extends
		IBaseService<Authorization, String> {
	
	/**
	 * 查询权限树
	 * @return
	 */
	List<AuthorizationExtention> getAuthorizationTree();

	/**
	 * 根据ParentId列查询记录数。
	 * 
	 * @param id
	 * @return
	 */
	List<Authorization> getByParentId(String id);

	/**
	 * 封装查询条件，返回Page对象。
	 * 
	 * @param criteria
	 * @return
	 */
	Page select(AuthorizationCriteria criteria);
}
