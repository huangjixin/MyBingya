/**
 * 一句话描述该类：菜单服务实现类<br/>
 * @author 黄记新
 * @date 2014-12-18,下午6:56:55
 *
 */
package com.jcin.cms.service.system.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jcin.cms.dao.system.AuthorizationMapper;
import com.jcin.cms.dao.system.MenuMapper;
import com.jcin.cms.domain.system.Authorization;
import com.jcin.cms.domain.system.AuthorizationCriteria;
import com.jcin.cms.domain.system.Menu;
import com.jcin.cms.service.impl.BaseServiceImpl;
import com.jcin.cms.service.system.IAuthorizationService;
import com.jcin.cms.service.system.impl.vo.AuthorizationExtention;
import com.jcin.cms.utils.Page;

/**
 * @author 黄记新
 * @date 2014-12-18,下午6:56:55
 * 
 */
@Service(value = "authorizationService")
public class AuthorizationServiceImpl extends BaseServiceImpl<Authorization, String> implements
		IAuthorizationService {
	private static Logger logger = Logger.getLogger(AuthorizationServiceImpl.class
			.getName());

	@Resource
	private AuthorizationMapper authorizationMapper;
	@Resource
	private MenuMapper menuMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.IAuthorizationService#deleteByPrimaryKey((java.lang.String))
	 */
	@Override
	@Transactional
	public int deleteByPrimaryKey(String id) {
		super.deleteByPrimaryKey(id);
		int result = authorizationMapper.deleteByPrimaryKey(id);

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jcin.cms.service.IAuthorizationService#insert(com.jcin.cms.domain.Authorization)
	 */
	@Override
	@Transactional
	public String insert(Authorization record) {
		super.insert(record);

		authorizationMapper.insert(record);
		String id = record.getId();
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jcin.cms.service.IAuthorizationService#select(com.jcin.cms.utils.Page)
	 */
	@Override
	public Page select(Page page) {
		super.select(page);

		AuthorizationCriteria authorizationCriteria = new AuthorizationCriteria();
		authorizationCriteria.setPage(page);
		@SuppressWarnings("rawtypes")
		List list = authorizationMapper.selectByExample(authorizationCriteria);
		page.setRows(list);
		int total = authorizationMapper.countByExample(authorizationCriteria);
		page.setTotal(total);
		return page;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.IAuthorizationService#select(com.jcin.cms.domain.AuthorizationCriteria
	 * )
	 */
	@Override
	public Page select(AuthorizationCriteria criteria) {
		Page page = new Page();
		@SuppressWarnings("rawtypes")
		List list = authorizationMapper.selectByExample(criteria);
		page.setRows(list);
		int total = authorizationMapper.countByExample(criteria);
		page.setTotal(total);
		return page;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.IAuthorizationService#selectByPrimaryKey(java.lang.String)
	 */
	@Override
	public Authorization selectByPrimaryKey(String id) {
		super.selectByPrimaryKey(id);

		Authorization authorization = authorizationMapper.selectByPrimaryKey(id);
		return authorization;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jcin.cms.service.IAuthorizationService#update(com.jcin.cms.domain.Authorization)
	 */
	@Override
	@Transactional
	public String update(Authorization record) {
		super.update(record);

		int result = authorizationMapper.updateByPrimaryKeySelective(record);
		return record.getId();
	}

	// @SuppressWarnings({ "rawtypes", "unchecked" })
	// @Override
	// public List getAuthorizationTree(String roleId) throws JSONException {
	// List<RoleAuthorization> roleAuthorizations = null;
	// if (roleId != null || "".equals(roleId)) {
	// RoleAuthorizationCriteria roleAuthorizationCriteria = new RoleAuthorizationCriteria();
	// roleAuthorizationCriteria.createCriteria().andRoleIdEqualTo(roleId);
	// roleAuthorizations = roleAuthorizationMapper.selectByExample(roleAuthorizationCriteria);
	// }
	//
	// AuthorizationCriteria authorizationExample = new AuthorizationCriteria();
	// authorizationExample.createCriteria().andParentidIsNull();
	//
	// List<Authorization> list = authorizationMapper.selectByExample(authorizationExample);
	// List children = new ArrayList();
	// for (Authorization object : list) {
	// boolean flag = false;
	// if(roleAuthorizations != null){
	// for (RoleAuthorization roleAuthorization : roleAuthorizations) {
	// if (roleAuthorization.getAuthorizationId().equals(object.getId())) {
	// flag = true;
	// break;
	// }
	// }
	// }
	//
	// if (!flag && roleAuthorizations != null) {
	// continue;
	// }
	//
	// JSONObject jsonObject;
	//
	// jsonObject = searialAuthorization(object, roleAuthorizations);
	// children.add(jsonObject);
	// }
	// return children;
	// }

	@Override
	public List<Authorization> getByParentId(String id) {
		AuthorizationCriteria authorizationExample = new AuthorizationCriteria();
		authorizationExample.createCriteria().andParentIdEqualTo(id);
		List<Authorization> list = authorizationMapper.selectByExample(authorizationExample);

		return list;
	}

	// @SuppressWarnings("rawtypes")
	// public JSONObject searialAuthorization(Authorization authorization, List<RoleAuthorization> roleAuthorizations) throws
	// JSONException {
	// JSONObject jsonObject = new JSONObject();
	// jsonObject.put("id", authorization.getId());
	// jsonObject.put("parentid", authorization.getParentid());
	// jsonObject.put("name", authorization.getName());
	// jsonObject.put("url", authorization.getUrl());
	// jsonObject.put("createdate", authorization.getCreatedate());
	// jsonObject.put("description", authorization.getDescription());
	// jsonObject.put("updatedate", authorization.getUpdatedate());
	//
	// List list = searialChild(authorization, roleAuthorizations);
	// if (null != list) {
	// jsonObject.put("children", list);
	// }
	//
	// return jsonObject;
	// }

	// @SuppressWarnings({ "rawtypes", "unchecked" })
	// public List searialChild(Authorization authorization, List<RoleAuthorization> roleAuthorizations) throws
	// JSONException {
	// List children = null;
	// List<Authorization> list = getByParentId(authorization.getId());
	// if (list != null && list.size() > 0) {
	// children = new ArrayList();
	// }
	// for (Authorization object : list) {
	// boolean flag = false;
	// if(roleAuthorizations != null){
	// for (RoleAuthorization roleAuthorization : roleAuthorizations) {
	// if (roleAuthorization.getAuthorizationId().equals(object.getId())) {
	// flag = true;
	// break;
	// }
	// }
	// }
	// if (!flag && roleAuthorizations != null) {
	// continue;
	// }
	//
	// JSONObject jsonObject = searialAuthorization(object, roleAuthorizations);
	// children.add(jsonObject);
	// }
	// return children;
	// }

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jcin.cms.service.IAuthorizationService#insertBatch(List)
	 */
	@Override
	@Transactional
	public int insertBatch(List<Authorization> list) {
		int result = authorizationMapper.insertBatch(list);
		super.insertBatch(list);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.IAuthorizationService#deleteBatch(List)
	 */
	@Override
	@Transactional
	public int deleteBatch(List<String> list) {
		AuthorizationCriteria authorizationCriteria = new AuthorizationCriteria();
		authorizationCriteria.createCriteria().andIdIn(list);
		int result = authorizationMapper.deleteByExample(authorizationCriteria);
		super.deleteBatch(list);
		return result;
	}
	
	@Override
	public List<AuthorizationExtention> getAuthorizationTree() {
		AuthorizationCriteria authorizationExample = new AuthorizationCriteria();
		authorizationExample.createCriteria().andParentIdIsNull();

		List<Authorization> list = authorizationMapper.selectByExample(authorizationExample);
		List<AuthorizationExtention> extentions = new ArrayList<AuthorizationExtention>();

		for (Authorization authorization : list) {
			AuthorizationExtention extention = new AuthorizationExtention();
			extention.setId(authorization.getId());
			extention.setCreatedate(authorization.getCreatedate());
			extention.setDescription(authorization.getDescription());
			extention.setName(authorization.getName());
			extention.setParentId(authorization.getParentId());
			extention.setUpdatedate(authorization.getUpdatedate());
			extention.setUrl(authorization.getUrl());
			
			extentions.add(extention);
		}

		List<AuthorizationExtention> children = new ArrayList<AuthorizationExtention>();
		for (AuthorizationExtention object : extentions) {

			AuthorizationExtention authorization;

			authorization = searialAuthorization(object);
			children.add(authorization);
		}
		return children;
	}

	public AuthorizationExtention searialAuthorization(AuthorizationExtention authorization) {
		AuthorizationExtention extention = new AuthorizationExtention();
		extention.setId(authorization.getId());
		extention.setCreatedate(authorization.getCreatedate());
		extention.setDescription(authorization.getDescription());
		extention.setName(authorization.getName());
		extention.setParentId(authorization.getParentId());
		extention.setUpdatedate(authorization.getUpdatedate());
		extention.setUrl(authorization.getUrl());

		List<AuthorizationExtention> list = searialChild(authorization.getId());
		if (null != list) {
			extention.setChildren(list);
		}

		return extention;
	}

	public List<AuthorizationExtention> searialChild(String id) {
		List<AuthorizationExtention> children = null;
		List<Authorization> list = getByParentId(id);
		List<AuthorizationExtention> extentions = new ArrayList<AuthorizationExtention>();

		for (Authorization authorization : list) {
			AuthorizationExtention extention = new AuthorizationExtention();
			extention.setId(authorization.getId());
			extention.setCreatedate(authorization.getCreatedate());
			extention.setDescription(authorization.getDescription());
			extention.setName(authorization.getName());
			extention.setParentId(authorization.getParentId());
			extention.setUpdatedate(authorization.getUpdatedate());
			extention.setUrl(authorization.getUrl());
			extentions.add(extention);
		}

		if (list != null && list.size() > 0) {
			children = new ArrayList<AuthorizationExtention>();
		}
		for (AuthorizationExtention object : extentions) {

			AuthorizationExtention jsonObject = searialAuthorization(object);
			children.add(jsonObject);
		}
		return children;
	}

	@Override
	public void sychMenu() {
		List<Authorization> list = authorizationMapper.selectByExample(null);
		List<String>idList = new ArrayList<String>();
		for (Authorization authorization : list) {
			idList.add(authorization.getId());
		}
		
		AuthorizationCriteria authorizationCriteria = new AuthorizationCriteria();
		authorizationCriteria.createCriteria().andIdIn(idList);
		if(idList.size()>0){
			authorizationMapper.deleteByExample(authorizationCriteria);
		}
		
		
		List<Menu>menus = menuMapper.selectByExample(null);
		list = new ArrayList<Authorization>();
		for (Menu menu : menus) {
			Authorization authorization = new Authorization();
			authorization.setId(menu.getId());
			authorization.setParentId(menu.getParentid());
			authorization.setName(menu.getName());
			authorization.setUrl(menu.getUrl());
			list.add(authorization);
		}
		
		authorizationMapper.insertBatch(list);
	}
}
