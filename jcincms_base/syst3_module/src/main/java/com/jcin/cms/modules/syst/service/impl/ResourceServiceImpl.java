/**
 * 一句话描述该类：用户实现类<br/>
 * @author 黄记新
 * @date 2015-4-26,下午6:56:55
 *
 */
package com.jcin.cms.modules.syst.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jcin.cms.modules.syst.dao.ResourceMapper;
import com.jcin.cms.modules.syst.dao.RoleMapper;
import com.jcin.cms.modules.syst.dao.RoleResourceMapper;
import com.jcin.cms.modules.syst.domain.Resource;
import com.jcin.cms.modules.syst.domain.ResourceCriteria;
import com.jcin.cms.modules.syst.domain.RoleResource;
import com.jcin.cms.modules.syst.domain.RoleResourceCriteria;
import com.jcin.cms.modules.syst.service.IResourceService;
import com.jcin.cms.service.impl.BaseServiceImpl;
import com.jcin.cms.utils.Page;

/**
 * @author 黄记新
 * @date 2014-12-18,下午6:56:55
 * 
 */
@Service
public class ResourceServiceImpl extends BaseServiceImpl<Resource, String>
		implements IResourceService {
	private static Logger logger = Logger.getLogger(ResourceServiceImpl.class
			.getName());

	@javax.annotation.Resource
	private ResourceMapper resourceMapper;
	@javax.annotation.Resource
	private RoleMapper roleMapper;
	@javax.annotation.Resource
	private RoleResourceMapper roleResourceMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.system.IResourceService#deleteByPrimaryKey((java
	 * .lang .String ))
	 */
	@Override
	@Transactional(readOnly = false)
	public int deleteByPrimaryKey(String id) {
		// super.deleteByPrimaryKey(id);

		int result = resourceMapper.deleteByPrimaryKey(id);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.system.IResourceService#insert(com.jcin.cms.service.
	 * system. Resource)
	 */
	@Override
	@Transactional(readOnly = false)
	public String insert(Resource resource) {
		if ("".equals(resource.getParentId())) {
			resource.setParentId(null);
		} else {
			Resource resou = selectByPrimaryKey(resource.getParentId());
			if (null != resou) {
				String parentids = resou.getParentids();
				if (parentids == null || "".equals(parentids)) {
					parentids = resou.getId();
				} else {
					parentids += ("," + resou.getId());
				}
				resource.setParentids(parentids);
			}
		}
		super.insert(resource);

		// record.setCreateDate(new Date());
		int result = resourceMapper.insert(resource);
		String id = resource.getId();
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.system.IResourceService#select(com.jcin.cms.utils
	 * .Page)
	 */
	@Override
	public Page select(Page page) {
		super.select(page);
		// setOrderByClause("SER_NO  asc , ORG_ID desc");
		ResourceCriteria resourceCriteria = new ResourceCriteria();
		resourceCriteria.setOrderByClause("id desc");
		resourceCriteria.setPage(page);
		@SuppressWarnings("rawtypes")
		List list = resourceMapper.selectByExample(resourceCriteria);
		page.setRows(list);
		int total = resourceMapper.countByExample(resourceCriteria);
		page.setTotal(total);
		return page;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.system.IResourceService#select(com.jcin.cms.service.
	 * system.ResourceCriteria)
	 */
	// @Override
	public Page select(ResourceCriteria criteria) {
		Page page = new Page();
		@SuppressWarnings("rawtypes")
		List list = resourceMapper.selectByExample(criteria);
		page.setRows(list);
		int total = resourceMapper.countByExample(criteria);
		page.setTotal(total);
		return page;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jcin.cms.service.system.IResourceService#selectAll()
	 */
	@Override
	public List<Resource> selectAll() {
		List<Resource> list = resourceMapper.selectByExample(null);
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.system.IResourceService#selectByPrimaryKey(java.lang
	 * .String)
	 */
	@Override
	public Resource selectByPrimaryKey(String id) {
		super.selectByPrimaryKey(id);

		Resource article = resourceMapper.selectByPrimaryKey(id);
		return article;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.system.IResourceService#update(com.jcin.cms.service.
	 * system. Resource)
	 */
	@Override
	@Transactional(readOnly = false)
	public String update(Resource resource) {
		if ("".equals(resource.getParentId())) {
			resource.setParentId(null);
			resource.setParentids(null);
		} else {
			Resource resou = selectByPrimaryKey(resource.getParentId());
			if (null != resou) {
				String parentids = resou.getParentids();
				if (parentids == null || "".equals(parentids)) {
					parentids = resou.getId();
				} else {
					parentids += ("," + resou.getId());
				}
				resource.setParentids(parentids);
			}
		}
		// super.update(record);
		// record.setUpdateDate(new Date());
		int result = resourceMapper.updateByPrimaryKey(resource);
		return resource.getId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jcin.cms.service.system.IResourceService#insertBatch(List)
	 */
	@Override
	@Transactional(readOnly = false)
	public int insertBatch(List<Resource> list) {
		for (Resource resource : list) {
			if ("".equals(resource.getParentId())) {
				resource.setParentId(null);
			} else {
				Resource resou = selectByPrimaryKey(resource.getParentId());
				if (null != resou) {
					String parentids = resou.getParentids();
					if (parentids == null || "".equals(parentids)) {
						parentids = resou.getId();
					} else {
						parentids += ("," + resou.getId());
					}
					resource.setParentids(parentids);
				}
			}
		}
		
		
		int result = resourceMapper.insertBatch(list);
		super.insertBatch(list);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jcin.cms.service.system.IResourceService#deleteBatch(List)
	 */
	@Override
	@Transactional(readOnly = false)
	public int deleteBatch(List<String> list) {
		ResourceCriteria resourceCriteria = new ResourceCriteria();
		resourceCriteria.createCriteria().andIdIn(list);
		int result = resourceMapper.deleteByExample(resourceCriteria);
		super.deleteBatch(list);
		return result;
	}

	@Override
	@Transactional(readOnly = false)
	public void connectResourceRole(String resourceId, String roleId) {
		RoleResource record = new RoleResource();
		record.setId(new Date().getTime() + "");
		record.setResourceId(resourceId);
		record.setRoleId(roleId);
		roleResourceMapper.insert(record);
	}

	@Override
	@Transactional(readOnly = false)
	public void updateResourceRole(String resourceId, String oldRoleId,
			String newRoleId) {
		RoleResourceCriteria roleResourceCriteria = new RoleResourceCriteria();
		roleResourceCriteria.createCriteria().andResourceIdEqualTo(resourceId)
				.andRoleIdEqualTo(oldRoleId);
		List<RoleResource> roleResources = roleResourceMapper
				.selectByExample(roleResourceCriteria);
		if (null != roleResources && roleResources.size() > 0) {
			RoleResource roleResource = roleResources.get(0);
			roleResource.setRoleId(newRoleId);
			roleResourceMapper.updateByPrimaryKey(roleResource);
		}
	}

	@Override
	public List<Resource> getResourceTree(Set<String> permission,
			boolean menuOnly) {
		ResourceCriteria resourceExample = new ResourceCriteria();
		resourceExample.createCriteria().andParentIdIsNull();

		List<Resource> list = resourceMapper.selectByExample(resourceExample);
		List<Resource> children = new ArrayList<Resource>();
		for (Resource object : list) {
			if(object.getAuthName()!=null && !"".equals(object.getAuthName()) && permission !=null && !permission.contains(object.getAuthName())){
				continue;
			}
			Resource jsonObject;
			
			try {
				jsonObject = searialResource(object, permission, menuOnly);
				if(jsonObject!=null){
					children.add(jsonObject);
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}

		}
		return children;
	}

	@SuppressWarnings("rawtypes")
	public Resource searialResource(Resource resource, Set<String> permission,
			boolean menuOnly) throws JSONException {
		Resource jsonObject = new Resource();
		if (menuOnly) {// 如果仅仅是菜单
			if(resource.getType().equals(Resource.ResourceType.button)){
				jsonObject = null;
			}else{
				jsonObject.setId(resource.getId());
				jsonObject.setParentId(resource.getParentId());
				jsonObject.setName(resource.getName());
				jsonObject.setType(resource.getType());
				jsonObject.setPath(resource.getPath());
				jsonObject.setAuthName(resource.getAuthName());
				jsonObject.setParentids(resource.getParentids());
			}
		}else{
			jsonObject.setId(resource.getId());
			jsonObject.setParentId(resource.getParentId());
			jsonObject.setName(resource.getName());
			jsonObject.setType(resource.getType());
			jsonObject.setPath(resource.getPath());
			jsonObject.setAuthName(resource.getAuthName());
			jsonObject.setParentids(resource.getParentids());
		}

		List<Resource> list = searialChild(resource, permission, menuOnly);
		if (null != list) {
			jsonObject.setChildren(list);
		}

		return jsonObject;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Resource> searialChild(Resource resource,
			Set<String> permission, boolean menuOnly) throws JSONException {
		List children = null;
		List<Resource> list = getByParentId(resource.getId());
		if (list != null && list.size() > 0) {
			children = new ArrayList();
		}
		for (Resource object : list) {
			if(object.getAuthName()!=null && !"".equals(object.getAuthName()) && permission !=null && !permission.contains(object.getAuthName())){
				continue;
			}
			Resource jsonObject = searialResource(object, permission, menuOnly);
			if(jsonObject!=null){
				children.add(jsonObject);
			}
		}
		return children;
	}

	@Override
	public List<Resource> getByParentId(String id) {
		ResourceCriteria resourceExample = new ResourceCriteria();
		resourceExample.createCriteria().andParentIdEqualTo(id);
		List<Resource> list = resourceMapper.selectByExample(resourceExample);

		return list;
	}
}