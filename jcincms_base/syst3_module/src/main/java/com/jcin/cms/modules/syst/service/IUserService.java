package  com.jcin.cms.modules.syst.service;


import java.util.Set;

import com.jcin.cms.modules.syst.domain.User;
import com.jcin.cms.modules.syst.domain.UserCriteria;
import com.jcin.cms.service.IBaseService;
import com.jcin.cms.utils.Page;

public interface IUserService extends IBaseService<User, String> {
	/**
	 * 封装查询条件，返回Page对象。
	 * @param criteria
	 * @return
	 */
	Page select(UserCriteria criteria);

	/**
	 * 通过用户名查询用户。
	 * @param username
	 * @return
	 */
	User findByUsername(String username);

	/**
	 * 通过用户名查询角色。
	 * @param username
	 * @return
	 */
	Set<String> findRoles(String username);

	/**
	 * 通过用户名查询权限集合。
	 * @param username
	 * @return
	 */
	Set<String> findPermissions(String username);
	
	/**
	 * 关联用户角色。
	 * @param userId
	 * @param roleId
	 */
	void connectUserRole(String userId,String roleId);
	
	/**
	 * 关联用户角色。
	 * @param userId
	 * @param oldRoleId
	 * @param newRoleId
	 */
	void updateUserRole(String userId, String oldRoleId, String newRoleId);
	
	/**
	 * 关联用户组织。
	 * @param userId
	 * @param roleId
	 */
	void connectUserOrganization(String userId,String roleId);
	
	/**
	 * 更新关联用户组织。
	 * @param userId
	 * @param oldOrgId
	 * @param newOrgId
	 */
	void updateUserOrganization(String userId, String oldOrgId, String newOrgId);
	
	/**
	 * 检查用户名密码
	 * @param username
	 * @param password
	 * @return
	 */
	boolean checkUsernamePassword(String username, String password);
	
	/**
	 * 更新密码。
	 * @param user
	 * @return
	 */
	boolean updatePassword(User user);

	/** 
	 * 根据组织ID进行查询并分页。
	 * @param organizationId
	 * @param userCriteria
	 * @return
	 */
	Page getByOrgId(UserCriteria userCriteria);

	/** 
	 * 根据角色Id进行查询并分页。
	 * @param userCriteria
	 * @return
	 */
	Page getByRoleId(UserCriteria userCriteria);
}