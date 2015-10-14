package com.jcin.cms.modules.syst.service;

import java.util.List;
import java.util.Set;

import com.jcin.cms.modules.syst.domain.Organization;
import com.jcin.cms.modules.syst.domain.Resource;
import com.jcin.cms.modules.syst.domain.ResourceCriteria;
import com.jcin.cms.service.IBaseService;
import com.jcin.cms.utils.Page;

public interface IResourceService extends IBaseService<Resource, String> {
	/**
	 * 封装查询条件，返回Page对象。
	 * 
	 * @param criteria
	 * @return
	 */
	Page select(ResourceCriteria criteria);

	/**
	 * 关联权限角色。
	 * 
	 * @param resourcename
	 * @return
	 */
	void connectResourceRole(String resourceId, String roleId);

	/**
	 * 更新关联关系
	 * @param resourceId
	 * @param oldRoleId
	 * @param newRoleId
	 */
	void updateResourceRole(String resourceId, String oldRoleId, String newRoleId);

	/**
	 * 创建资源树。
	 * @return
	 */
	List<Resource> getResourceCheckboxTree(List<Resource> resources);
	
	/**
	 * 创建资源树。
	 * @return
	 */
	List<Resource> getResourceTree(Set<String>permission,boolean menuOnly);
	
	/**
	 * 根据父亲节点查找。
	 * @param id
	 * @return
	 */
	List<Resource> getByParentId(String id);
	
	/**
	 * 根据角色查找。
	 * @param id
	 * @return
	 */
	List<Resource> selectByRoleId(String roleId);
	
	/**
	 * 根据组织查找。
	 * @param id
	 * @return
	 */
	List<Resource> selectByOrgId(String orgId);
}