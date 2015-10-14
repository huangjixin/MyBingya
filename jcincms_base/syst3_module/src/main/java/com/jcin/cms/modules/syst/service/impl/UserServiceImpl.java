/**
 * 一句话描述该类：用户实现类<br/>
 * @author 黄记新
 * @date 2015-4-26,下午6:56:55
 *
 */
package com.jcin.cms.modules.syst.service.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jcin.cms.modules.syst.dao.ResourceMapper;
import com.jcin.cms.modules.syst.dao.RoleMapper;
import com.jcin.cms.modules.syst.dao.UserMapper;
import com.jcin.cms.modules.syst.dao.UserOrganizationMapper;
import com.jcin.cms.modules.syst.dao.UserRoleMapper;
import com.jcin.cms.modules.syst.domain.Resource;
import com.jcin.cms.modules.syst.domain.Role;
import com.jcin.cms.modules.syst.domain.User;
import com.jcin.cms.modules.syst.domain.UserCriteria;
import com.jcin.cms.modules.syst.domain.UserOrganization;
import com.jcin.cms.modules.syst.domain.UserOrganizationCriteria;
import com.jcin.cms.modules.syst.domain.UserRole;
import com.jcin.cms.modules.syst.domain.UserRoleCriteria;
import com.jcin.cms.modules.syst.service.IUserService;
import com.jcin.cms.service.impl.BaseServiceImpl;
import com.jcin.cms.utils.Page;

/**
 * @author 黄记新
 * @date 2014-12-18,下午6:56:55
 * 
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User, String> implements
		IUserService {
	private static Logger logger = Logger.getLogger(UserServiceImpl.class
			.getName());

	@javax.annotation.Resource
	private UserMapper userMapper;
	@javax.annotation.Resource
	private RoleMapper roleMapper;
	@javax.annotation.Resource
	private UserRoleMapper userRoleMapper;
	@javax.annotation.Resource
	private UserOrganizationMapper userOrganizationMapper;
	@javax.annotation.Resource
	private ResourceMapper resourceMapper;
//	@javax.annotation.Resource
//	private Userre;
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.system.IUserService#deleteByPrimaryKey((java.lang
	 * .String ))
	 */
	@Override
	@Transactional(readOnly = false)
	public int deleteByPrimaryKey(String id) {
		// super.deleteByPrimaryKey(id);

		int result = userMapper.deleteByPrimaryKey(id);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.system.IUserService#insert(com.jcin.cms.service.
	 * system. User)
	 */
	@Override
	@Transactional(readOnly = false)
	public String insert(User record) {
		super.insert(record);

		record.setCreateDate(new Date());
		int result = userMapper.insert(record);
		String id = record.getId();
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.system.IUserService#select(com.jcin.cms.utils.Page)
	 */
	@Override
	public Page select(Page page) {
		super.select(page);
		// setOrderByClause("SER_NO  asc , ORG_ID desc");
		UserCriteria userCriteria = new UserCriteria();
		userCriteria.setOrderByClause("id desc");
		userCriteria.setPage(page);
		@SuppressWarnings("rawtypes")
		List list = userMapper.selectByExample(userCriteria);
		page.setRows(list);
		int total = userMapper.countByExample(userCriteria);
		page.setTotal(total);
		return page;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.system.IUserService#select(com.jcin.cms.service.
	 * system.UserCriteria)
	 */
	// @Override
	public Page select(UserCriteria criteria) {
		Page page = new Page();
		@SuppressWarnings("rawtypes")
		List list = userMapper.selectByExample(criteria);
		page.setRows(list);
		int total = userMapper.countByExample(criteria);
		page.setTotal(total);
		return page;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jcin.cms.service.system.IUserService#selectAll()
	 */
	@Override
	public List<User> selectAll() {
		List<User> list = userMapper.selectByExample(null);
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.system.IUserService#selectByPrimaryKey(java.lang
	 * .String)
	 */
	@Override
	public User selectByPrimaryKey(String id) {
		super.selectByPrimaryKey(id);

		User article = userMapper.selectByPrimaryKey(id);
		return article;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.system.IUserService#update(com.jcin.cms.service.
	 * system. User)
	 */
	@Override
	@Transactional(readOnly = false)
	public String update(User record) {
		// super.update(record);
		record.setUpdateDate(new Date());
		int result = userMapper.updateByPrimaryKeySelective(record);
		return record.getId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jcin.cms.service.system.IUserService#insertBatch(List)
	 */
	@Override
	@Transactional(readOnly = false)
	public int insertBatch(List<User> list) {
		int result = userMapper.insertBatch(list);
		super.insertBatch(list);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jcin.cms.service.system.IUserService#deleteBatch(List)
	 */
	@Override
	@Transactional(readOnly = false)
	public int deleteBatch(List<String> list) {
		UserCriteria userCriteria = new UserCriteria();
		userCriteria.createCriteria().andIdIn(list);
		int result = userMapper.deleteByExample(userCriteria);
		super.deleteBatch(list);
		return result;
	}

	@Override
	public User findByUsername(String username) {
		UserCriteria userCriteria = new UserCriteria();
		userCriteria.createCriteria().andUsernameEqualTo(username);
		List<User> list = userMapper.selectByExample(userCriteria);
		return (null != list && list.size() > 0) ? list.get(0) : null;
	}

	@Override
	public Set<String> findRoles(String username) {
		List<Role> list = roleMapper.selectByUsername(username);
		Set<String> set = new HashSet<String>(list.size());
		for (Role role : list) {
			set.add(role.getName());
		}
		logger.debug("角色集合是：{：" + set.toString() + "}");
		return set;
	}

	@Override
	public Set<String> findPermissions(String username) {
		List<Resource> list = resourceMapper.selectByUsername(username);
		Set<String> set = new HashSet<String>();
		for (Resource resource : list) {
			if (null != resource.getAuthName() && !"".equals(resource.getAuthName())) {
				set.add(resource.getAuthName());
			}
		}
		
		list = resourceMapper.selectOnOrgByUsername(username);
		for (Resource resource : list) {
			if (null != resource.getAuthName() && !"".equals(resource.getAuthName())) {
				set.add(resource.getAuthName());
			}
		}
		logger.debug("权限集合是：{：" + set.toString() + "}");
		return set;
	}

	@Override
	@Transactional(readOnly = false)
	public void connectUserRole(String userId, String roleId) {
		UserRole record = new UserRole();
		record.setId(new Date().getTime()+"");
		record.setUserId(userId);
		record.setTbRoleId(roleId);
		userRoleMapper.insert(record);
	}

	@Override
	@Transactional(readOnly = false)
	public void updateUserRole(String userId, String oldRoleId, String newRoleId) {
		UserRoleCriteria userRoleCriteria = new UserRoleCriteria();
		userRoleCriteria.createCriteria().andUserIdEqualTo(userId).andTbRoleIdEqualTo(oldRoleId);
		List<UserRole>userRoles = userRoleMapper.selectByExample(userRoleCriteria);
		if(null != userRoles && userRoles.size()>0){//更新
			UserRole userRole  = userRoles.get(0);
			if(null != newRoleId){
				userRole.setTbRoleId(newRoleId);
				userRoleMapper.updateByPrimaryKey(userRole);
			}else{
				userRoleMapper.deleteByPrimaryKey(userRole.getId());
			}
		}else{//新增
			if((null == oldRoleId || "".equals(oldRoleId)) && null != newRoleId){
				UserRole userRole  = new UserRole();
				userRole.setId(new Date().getTime()+"");
				userRole.setUserId(userId);
				userRole.setTbRoleId(newRoleId);
				userRoleMapper.insert(userRole);
			}
			
		}
	}


	@Override
	public void connectUserOrganization(String userId, String roleId) {
		UserOrganization record = new UserOrganization();
		record.setId(new Date().getTime()+"");
		record.setUserId(userId);
		record.setOrganizationId(roleId);
		userOrganizationMapper.insert(record);
	}

	@Override
	public void updateUserOrganization(String userId, String oldOrgId,
			String newOrgId) {
		if(oldOrgId == null){
			oldOrgId="";
		}
		UserOrganizationCriteria userOrganizationCriteria = new UserOrganizationCriteria();
		userOrganizationCriteria.createCriteria().andUserIdEqualTo(userId).andOrganizationIdEqualTo(oldOrgId);
		List<UserOrganization>userOrganizations = userOrganizationMapper.selectByExample(userOrganizationCriteria);
		if(null != userOrganizations && userOrganizations.size()>0){
			UserOrganization userOrganization  = userOrganizations.get(0);
			if(null != newOrgId){
				userOrganization.setOrganizationId(newOrgId);
				userOrganizationMapper.updateByPrimaryKey(userOrganization);
			}else{
				userOrganizationMapper.deleteByPrimaryKey(userOrganization.getId());
			}
		}else{//新增
			if((null == oldOrgId || "".equals(oldOrgId)) && null != newOrgId){
				UserOrganization userOrganization  = new UserOrganization();
				userOrganization.setId(new Date().getTime()+"");
				userOrganization.setUserId(userId);
				userOrganization.setOrganizationId(newOrgId);
				userOrganizationMapper.insert(userOrganization);
			}
			
		}
	}
	
	@Override
	public boolean checkUsernamePassword(String username, String password) {
		UserCriteria userCriteria = new UserCriteria();
		userCriteria.createCriteria().andUsernameEqualTo(username).andPasswordEqualTo(password);
		List<User> list = userMapper.selectByExample(userCriteria);
		return (null != list && list.size() > 0) ? true : false;
	}

	@Override
	public boolean updatePassword(User user) {
//		User user2 = userMapper.selectByPrimaryKey(user.getId());
//		user2.setPassword(user.getPassword());
		userMapper.updateByPrimaryKeySelective(user);
		return true;
	}


}
