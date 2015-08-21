package  com.jcin.cms.service.system;

import java.util.List;

import com.jcin.cms.domain.system.Role;
import com.jcin.cms.domain.system.UserGroup;
import com.jcin.cms.domain.system.UserGroupCriteria;
import com.jcin.cms.service.IBaseService;
import com.jcin.cms.utils.Page;

public interface IUserGroupService extends IBaseService<UserGroup, String> {
	/**
	 * 封装查询条件，返回Page对象。
	 * @param criteria
	 * @return
	 */
	Page select(UserGroupCriteria criteria);
	
	/**
	 * 根据用户组ID查询角色。
	 * @param userGroupID
	 * @return
	 */
	List<Role> getRoleByUserGroupID(String userGroupID);
}