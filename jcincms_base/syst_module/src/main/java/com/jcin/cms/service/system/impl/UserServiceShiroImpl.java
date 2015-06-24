/**
 * 一句话描述该类：<br/>
 * @author 黄记新
 * @date 2015-5-23,上午10:33:53
 *
 */
/**
 * 
 */
package com.jcin.cms.service.system.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jcin.cms.dao.system.AuthorizationMapper;
import com.jcin.cms.dao.system.RoleAuthorizationMapper;
import com.jcin.cms.dao.system.RoleMapper;
import com.jcin.cms.dao.system.UserGroupMapper;
import com.jcin.cms.dao.system.UserGroupRoleMapper;
import com.jcin.cms.dao.system.UserMapper;
import com.jcin.cms.domain.system.Authorization;
import com.jcin.cms.domain.system.AuthorizationCriteria;
import com.jcin.cms.domain.system.Role;
import com.jcin.cms.domain.system.RoleAuthorization;
import com.jcin.cms.domain.system.RoleAuthorizationCriteria;
import com.jcin.cms.domain.system.RoleCriteria;
import com.jcin.cms.domain.system.User;
import com.jcin.cms.domain.system.UserCriteria;
import com.jcin.cms.domain.system.UserGroup;
import com.jcin.cms.domain.system.UserGroupCriteria;
import com.jcin.cms.domain.system.UserGroupRole;
import com.jcin.cms.domain.system.UserGroupRoleCriteria;
import com.jcin.cms.service.system.IUserServiceShiro;

/**
 * @author 黄记新
 * 
 */
@Service
public class UserServiceShiroImpl implements IUserServiceShiro {

	@Resource
	private UserMapper userMapper;

	@Resource
	private UserGroupMapper userGroupMapper;
	
	@Resource
	private UserGroupRoleMapper userGroupRoleMapper;

	@Resource
	private RoleMapper roleMapper;
	
	@Resource
	private RoleAuthorizationMapper roleAuthorizationMapper;
	
	@Resource
	private AuthorizationMapper authorizationMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.system.IUserServiceShiro#findRoles(java.lang.String)
	 */
	@Override
	public Set<String> findRoles(String username) {
		// ----------- 此处应该用sql去实现的，现在先用程序实现。
		UserCriteria userCriteria = new UserCriteria();
		UserCriteria.Criteria criteria = userCriteria.createCriteria();
		criteria.andUsernameEqualTo(username);
		List<User> users = userMapper.selectByExample(userCriteria);
		List<UserGroup> userGroups = new ArrayList<UserGroup>();	//查询用户组
		for (User user : users) {
			UserGroupCriteria userGroupCriteria = new UserGroupCriteria();
			UserGroupCriteria.Criteria cri = userGroupCriteria.createCriteria();
			cri.andIdEqualTo(user.getUserGroupId());
			userGroups.addAll(userGroupMapper.selectByExample(userGroupCriteria));
		}
		
		List<UserGroupRole> userGroupRoles = new ArrayList<UserGroupRole>();	//查询中间表
		for (UserGroup userGroup : userGroups) {
			UserGroupRoleCriteria userGroupRoleCriteria = new UserGroupRoleCriteria();
			UserGroupRoleCriteria.Criteria cri = userGroupRoleCriteria.createCriteria();
			cri.andUserGroupIdEqualTo(userGroup.getId());
			userGroupRoles.addAll(userGroupRoleMapper.selectByExample(userGroupRoleCriteria));
		}

		List<Role> roles = new ArrayList<Role>();				//查询角色表
		for (UserGroupRole userGroupRole : userGroupRoles) {
			RoleCriteria roleCriteria = new RoleCriteria();
			RoleCriteria.Criteria rolecri = roleCriteria.createCriteria();
			rolecri.andIdEqualTo(userGroupRole.getRoleId());
			roles.addAll(roleMapper.selectByExample(roleCriteria));
		}
		Set<String> set = new HashSet<String>();
		for (Role role : roles) {
			set.add(role.getName());
		}
		return set;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.system.IUserServiceShiro#findPermissions(java.lang
	 * .String)
	 */
	@Override
	public Set<String> findPermissions(String username) {
		// ----------- 此处应该用sql去实现的，现在先用程序实现。
		UserCriteria userCriteria = new UserCriteria();
		UserCriteria.Criteria criteria = userCriteria.createCriteria();
		criteria.andUsernameEqualTo(username);
		List<User> users = userMapper.selectByExample(userCriteria);
		List<UserGroup> userGroups = new ArrayList<UserGroup>();	//查询用户组
		for (User user : users) {
			UserGroupCriteria userGroupCriteria = new UserGroupCriteria();
			UserGroupCriteria.Criteria cri = userGroupCriteria.createCriteria();
			cri.andIdEqualTo(user.getUserGroupId());
			userGroups.addAll(userGroupMapper.selectByExample(userGroupCriteria));
		}
		
		List<UserGroupRole> userGroupRoles = new ArrayList<UserGroupRole>();	//查询中间表
		for (UserGroup userGroup : userGroups) {
			UserGroupRoleCriteria userGroupRoleCriteria = new UserGroupRoleCriteria();
			UserGroupRoleCriteria.Criteria cri = userGroupRoleCriteria.createCriteria();
			cri.andUserGroupIdEqualTo(userGroup.getId());
			userGroupRoles.addAll(userGroupRoleMapper.selectByExample(userGroupRoleCriteria));
		}

		List<Role> roles = new ArrayList<Role>();				//查询角色表
		for (UserGroupRole userGroupRole : userGroupRoles) {
			RoleCriteria roleCriteria = new RoleCriteria();
			RoleCriteria.Criteria rolecri = roleCriteria.createCriteria();
			rolecri.andIdEqualTo(userGroupRole.getRoleId());
			roles.addAll(roleMapper.selectByExample(roleCriteria));
		}
		
		List<RoleAuthorization> roleAuthorizations = new ArrayList<RoleAuthorization>();
		for (Role role : roles) {
			RoleAuthorizationCriteria authorizationCriteria = new RoleAuthorizationCriteria();
			RoleAuthorizationCriteria.Criteria roleAuthcri = authorizationCriteria.createCriteria();
			roleAuthcri.andRoleIdEqualTo(role.getId());
			roleAuthorizations.addAll(roleAuthorizationMapper.selectByExample(authorizationCriteria));
		}
		
		List<Authorization> authorizations = new ArrayList<Authorization>();
		for (RoleAuthorization roleAuthorization : roleAuthorizations) {
			AuthorizationCriteria authorizationCriteria = new AuthorizationCriteria();
			AuthorizationCriteria.Criteria authcri = authorizationCriteria.createCriteria();
			authcri.andIdEqualTo(roleAuthorization.getAuthorizationId());
			authorizations.addAll(authorizationMapper.selectByExample(authorizationCriteria));
		}
		
		
		Set<String> set = new HashSet<String>();
		for (Authorization authorization : authorizations) {
			set.add(authorization.getName());
		}
		return set;
	}

	@Override
	public User findByUsername(String username) {
		UserCriteria userCriteria = new UserCriteria();
		UserCriteria.Criteria criteria = userCriteria.createCriteria();
		criteria.andUsernameEqualTo(username);
		List<User> users = userMapper.selectByExample(userCriteria);
		if (null != users && users.size() > 0) {
			return users.get(0);
		}
		return null;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
