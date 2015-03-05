/**
 * 一句话描述该类：用户服务实现类<br/>
 * @author 黄记新
 * @date 2014-12-18,下午6:56:55
 *
 */
package com.jcin.cms.service.system.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jcin.cms.dao.system.AuthorizationMapper;
import com.jcin.cms.dao.system.RoleMapper;
import com.jcin.cms.dao.system.UserMapper;
import com.jcin.cms.dao.system.UserRoleMapper;
import com.jcin.cms.domain.system.Authorization;
import com.jcin.cms.domain.system.Role;
import com.jcin.cms.domain.system.RoleCriteria;
import com.jcin.cms.domain.system.User;
import com.jcin.cms.domain.system.UserCriteria;
import com.jcin.cms.domain.system.UserRole;
import com.jcin.cms.domain.system.UserRoleCriteria;
import com.jcin.cms.service.impl.BaseServiceImpl;
import com.jcin.cms.service.system.IUserService;
import com.jcin.cms.utils.Page;
import com.jcin.cms.web.vo.LoginResponse;

/**
 * @author 黄记新
 * @date 2014-12-18,下午6:56:55
 * 
 */
@Service(value = "userService")
public class UserServiceImpl extends BaseServiceImpl<User, String> implements
		IUserService {
	private static Logger logger = Logger.getLogger(UserServiceImpl.class
			.getName());

	@Resource
	private UserMapper userMapper;

	@Resource
	private UserRoleMapper userRoleMapper;

	@Resource
	private RoleMapper roleMapper;
	
	@Resource
	private AuthorizationMapper authorizationMapper;
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.IUserService#deleteByPrimaryKey((java.lang.String))
	 */
	@Override
	@Transactional
	public int deleteByPrimaryKey(String id) {
		super.deleteByPrimaryKey(id);
//		logger.info(LoginResponse.user == null ? "" : LoginResponse.user
//				.getUsername()
//				+ " UserServiceImpl.deleteByPrimaryKey"
//				+ ",ID:"
//				+ id + "成功");
		int result = userMapper.deleteByPrimaryKey(id);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jcin.cms.service.IUserService#insert(com.jcin.cms.domain.User)
	 */
	@Override
	@Transactional
	public String insert(User record) {
		super.insert(record);
		Md5PasswordEncoder passwordEncoder = new Md5PasswordEncoder();
		String pas = passwordEncoder.encodePassword(record.getPassword(), "");
		record.setPassword(pas);
//		logger.info(LoginResponse.user == null ? "" : LoginResponse.user
//				.getUsername()
//				+ "操作 UserServiceImpl.insert"
//				+ ",record:"
//				+ record.getUsername() + "成功");
		userMapper.insert(record);
		String id = record.getId();
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jcin.cms.service.IUserService#select(com.jcin.cms.utils.Page)
	 */
	@Override
	public Page select(Page page) {
		// super.select(page);

		UserCriteria userCriteria = new UserCriteria();
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
	 * com.jcin.cms.service.IUserService#select(com.jcin.cms.domain.UserCriteria
	 * )
	 */
	@Override
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
	 * @see
	 * com.jcin.cms.service.IUserService#selectByPrimaryKey(java.lang.String)
	 */
	@Override
	public User selectByPrimaryKey(String id) {
		User user = userMapper.selectByPrimaryKey(id);
		return user;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jcin.cms.service.IUserService#update(com.jcin.cms.domain.User)
	 */
	@Override
	@Transactional
	public String update(User record) {
		super.update(record);
		Md5PasswordEncoder passwordEncoder = new Md5PasswordEncoder();
		String pas = passwordEncoder.encodePassword(record.getPassword(), "");
		record.setPassword(pas);
		int result = userMapper.updateByPrimaryKey(record);
		return record.getId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jcin.cms.service.IUserService#validateLogin(String)
	 */
	@Override
	public List<User> validateLogin(String username, String password) {
		UserCriteria userCriteria = new UserCriteria();
		userCriteria.createCriteria().andUsernameEqualTo(username)
				.andPasswordEqualTo(password);
		List<User> users = userMapper.selectByExample(userCriteria);
		return users;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jcin.cms.service.IUserService#getRolesByUserId(String)
	 */
	@Override
	public List<Role> getRolesByUserId(String id) {
		List<Role> roles = roleMapper.getRolesByUserId(id);
		
		return roles;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.IUserService#insertBatch(List)
	 */
	@Override
	public int insertBatch(List<User> list) {
		int result = userMapper.insertBatch(list);
		super.insertBatch(list);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.IUserService#deleteBatch(List)
	 */
	@Override
	public int deleteBatch(List<String> list) {
		int result = userMapper.deleteBatch(list);
		super.deleteBatch(list);
		return result;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.IUserService#getAuthoByUserId(String)
	 */
	@Override
	public List<Authorization> getAuthoByUserId(String id) {
		List<Authorization> authorizations = authorizationMapper.selectByUserId(id);
		return authorizations;
	}
}
