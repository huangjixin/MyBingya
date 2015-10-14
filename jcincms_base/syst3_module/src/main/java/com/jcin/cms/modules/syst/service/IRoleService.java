package  com.jcin.cms.modules.syst.service;


import java.util.List;

import com.jcin.cms.modules.syst.domain.Role;
import com.jcin.cms.modules.syst.domain.RoleCriteria;
import com.jcin.cms.service.IBaseService;
import com.jcin.cms.utils.Page;

public interface IRoleService extends IBaseService<Role, String> {
	/**
	 * 封装查询条件，返回Page对象。
	 * @param criteria
	 * @return
	 */
	Page select(RoleCriteria criteria);
	
	/**
	 * 根据用户查询角色
	 * @param username
	 * @return
	 */
	List<Role> selectByUsername(String username);
	
	/**
	 * 通过用户名查询权限集合。
	 * @param username
	 * @return
	 */
	void updateUserRole(String roleId, String oldUserId, String newUserId);
	
	/**
	 * 关联角色资源
	 * @param roleId
	 * @param resourceIds
	 */
	void connectRoleResource(String roleId, List<String> resourceIds);
}