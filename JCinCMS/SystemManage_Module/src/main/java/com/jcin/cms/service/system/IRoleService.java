/**
 * 一句话描述该类：<br/>
 * @author 黄记新
 * @date 2014-12-18,下午6:53:59
 *
 */
package com.jcin.cms.service.system;

import java.util.List;

import com.jcin.cms.domain.system.Role;
import com.jcin.cms.domain.system.RoleCriteria;
import com.jcin.cms.domain.system.User;
import com.jcin.cms.service.IBaseService;
import com.jcin.cms.utils.Page;

public interface IRoleService  extends IBaseService<Role, String>{

	/**
	 * 封装查询条件，返回Page对象。
	 * @param criteria
	 * @return
	 */
	Page select(RoleCriteria criteria);
	
	/**
	 * 根据角色ID获取关联所属用户。
	 * @param id
	 * @return
	 */
	List<User> getUsesByRoleId(String id);
	
}
