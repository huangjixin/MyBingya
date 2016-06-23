package com.jcin.cms.modules.syst.service;

import java.util.List;
import com.jcin.cms.modules.syst.domain.Organization;
import com.jcin.cms.modules.syst.domain.OrganizationCriteria;
import com.jcin.cms.service.IBaseService;
import com.jcin.cms.utils.Page;

/**
 * @author 黄记新，@date 2015.10.12
 *
 */
public interface IOrganizationService extends
		IBaseService<Organization, String> {
	/**
	 * 封装查询条件，返回Page对象。
	 * 
	 * @param criteria
	 * @return
	 */
	Page select(OrganizationCriteria criteria);

	/**
	 * 创建组织树。
	 * 
	 * @return
	 */
	List<Organization> getOrganizationTree(List<Organization> orgs);

	/**
	 * 根据parentId进行查询
	 * @param id
	 * @return
	 */
	List<Organization> getByParentId(String id);

	/**
	 * 根据用户名查询组织。
	 * @param username
	 * @return
	 */
	List<Organization> selectByUsername(String username);

	/**
	 * 关联组织资源。
	 * @param orgId
	 * @param resourceIds
	 */
	void connectOrgResource(String orgId, List<String> resourceIds);
	
}