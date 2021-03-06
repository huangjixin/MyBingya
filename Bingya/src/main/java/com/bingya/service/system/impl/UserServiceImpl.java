/**
 * 
 */
package com.bingya.service.system.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bingya.dao.system.RoleMapper;
import com.bingya.dao.system.UserMapper;
import com.bingya.dao.system.UserRoleMapper;
import com.bingya.domain.system.Role;
import com.bingya.domain.system.User;
import com.bingya.domain.system.UserExample;
import com.bingya.domain.system.UserRole;
import com.bingya.domain.system.UserRoleExample;
import com.bingya.service.system.IRoleService;
import com.bingya.service.system.IUserService;
import com.bingya.util.Page;

import flex.messaging.util.UUIDUtils;

/**
 * @author huangjixin
 * 
 */
@Transactional
@Service(value = "userService")
@RemotingDestination(value = "userServiceImpl", channels = { "my-amf" })
public class UserServiceImpl implements IUserService {
	// ---------------------------------------------------
	// 常量（全部大写，用下划线分割），变量 （先常后私）
	// ---------------------------------------------------
	@Resource
	private UserMapper userMapper;

	@Resource
	private UserRoleMapper userRoleMapper;

	@Resource
	private RoleMapper roleMapper;

	@Resource
	private IRoleService roleService;

	// ---------------------------------------------------
	// public 公有方法
	// ---------------------------------------------------

	// ---------------------------------------------------
	// protected 方法
	// ---------------------------------------------------

	// ---------------------------------------------------
	// private 私有方法
	// ---------------------------------------------------
	/*
	 * 删除用户。
	 * 
	 * @see
	 * com.bingya.service.system.IGenericService#deleteByPrimaryKey(java.lang
	 * .Integer)
	 */
	@Override
	public int deleteByPrimaryKey(String id) {
		// --先删除子表数据。
		UserRoleExample userRoleExample = new UserRoleExample();
		userRoleExample.createCriteria().andUserIdEqualTo(id);
		List<UserRole> userRoles = userRoleMapper
				.selectByExample(userRoleExample);
		for (UserRole userRole : userRoles) {
			userRoleMapper.deleteByPrimaryKey(userRole.getId());
		}

		int i = userMapper.deleteByPrimaryKey(id);
		return i;
	}

	/*
	 * 插入用户实体。
	 * 
	 * @see
	 * com.bingya.service.system.IGenericService#insert(java.io.Serializable)
	 */
	@Override
	public String insert(User entity) {
		Date date = new Date();
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//格式化日期
		String dateStr = sdf.format(date);
		
		 entity.setCreatedate(dateStr);
		 Md5PasswordEncoder encoder = new Md5PasswordEncoder();
		 String password = encoder.encodePassword(entity.getPassword(), null);
		 entity.setPassword(password);
		 if(entity.getId()==null||"".equals(entity.getId())){
		 int count = userMapper.countByExample(new UserExample());
		 entity.setId(count+1+"");
		 }
		 
		int i = userMapper.insert(entity);
		return i + "";
	}

	/*
	 * 查询所有用户。
	 * 
	 * @see com.bingya.service.system.IGenericService#selectAll()
	 */
	@Override
	public List<User> selectAll() {
		List<User> list = userMapper.selectByExample(null);
		return list;
	}

	/*
	 * 根据用户ID查询用户实体。
	 * 
	 * @see
	 * com.bingya.service.system.IGenericService#selectByPrimaryKey(java.lang
	 * .Integer)
	 */
	@Override
	public User selectByPrimaryKey(String id) {
		User user = userMapper.selectByPrimaryKey(id);
		return user;
	}

	/*
	 * 更新用户。
	 * 
	 * @see
	 * com.bingya.service.system.IGenericService#update(java.io.Serializable)
	 */
	@Override
	public String update(User entity) {
		Md5PasswordEncoder encoder = new Md5PasswordEncoder();
		String password = entity.getPassword();
		password = encoder.encodePassword(password, null);
		entity.setPassword(password);
		int i = userMapper.updateByPrimaryKey(entity);
		return i + "";
	}

	/*
	 * 分页查询。
	 * 
	 * @see
	 * com.bingya.service.system.IGenericService#query(com.bingya.util.Page,
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public Page query(Page page, String key, String orderCondition) {
		UserExample userExample = new UserExample();
		if (null != key && !"".equals(key)) {
			key = "%" + key + "%";
			userExample.createCriteria().andUsernameLike(key);
		}
		// userExample.createCriteria().andDescriptionLike(key);
		userExample.setPage(page);
		int total = userMapper.countByExample(userExample);
		page.setTotal(total);
		List<User> list = userMapper.selectByExample(userExample);
		page.setRows(list);
		return page;
	}

	/*
	 * 根据用户id查询对应的角色。
	 * 
	 * @see
	 * com.bingya.service.system.IUserService#getRolesById(java.lang.String)
	 */
	@Override
	public List<Role> getRolesById(String id) {
		List<Role> roles = new ArrayList<Role>();

		UserRoleExample userRoleExample = new UserRoleExample();
		userRoleExample.createCriteria().andUserIdEqualTo(id);
		List<UserRole> userRoles = userRoleMapper
				.selectByExample(userRoleExample);
		for (UserRole userRole : userRoles) {
			Role role = roleMapper.selectByPrimaryKey(userRole.getRoleId());
			roles.add(role);
		}
		return roles;
	}

	@Override
	public User login(String username, String password) {
		Md5PasswordEncoder encoder = new Md5PasswordEncoder();
		password = encoder.encodePassword(password, null);
		UserExample userExample = new UserExample();
		userExample.createCriteria().andUsernameEqualTo(username)
				.andPasswordEqualTo(password);
		List<User> list = userMapper.selectByExample(userExample);
		if (list != null && list.size() > 0) {
			return list.get(0);
		} else
			return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public String getMenuByUserId(String id) {
		List<Role> roles = getRolesById(id);
		if (roles == null || roles.size() == 0)
			return null;
		else {
			Role role = roles.get(0);
			String str = roleService.getMenusXMLById(role.getId());
			return str;
		}
	}
	
	@Override
	public String connectUserRole(String userid, String roleid) {
		UserRoleExample userRoleExample = new UserRoleExample();
		userRoleExample.createCriteria().andUserIdEqualTo(userid);
		List<UserRole>userRoles = userRoleMapper.selectByExample(userRoleExample);
		
		UserRole userRole = null;
		if(null != userMapper && userRoles.size()>0){//更新
			userRole = userRoles.get(0);
			userRole.setRoleId(roleid);
			userRoleMapper.updateByExample(userRole, null);
		}else{//新建
			int count = userRoleMapper.countByExample(null);
			userRole = new UserRole();
			userRole.setId(count+1+"");
			userRole.setUserId(userid);
			userRole.setRoleId(roleid);
			userRoleMapper.insert(userRole);
		}
		
		return userRole.getId();
	}

	public static void main(String[] args) {
		Md5PasswordEncoder encoder = new Md5PasswordEncoder();
		String superAdminpPassword = encoder.encodePassword("123qweasdzxc", null);
		String adminpPassword = encoder.encodePassword("admin", null);
		System.out.println(superAdminpPassword+","+adminpPassword);
	}

}
