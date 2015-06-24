package  com.jcin.cms.service.system;

import com.jcin.cms.domain.system.UserGroupRole;
import com.jcin.cms.domain.system.UserGroupRoleCriteria;
import com.jcin.cms.service.system.IUserGroupRoleService;
import com.jcin.cms.service.IBaseService;
import com.jcin.cms.utils.Page;

public interface IUserGroupRoleService extends IBaseService<UserGroupRole, String> {
	/**
	 * 封装查询条件，返回Page对象。
	 * @param criteria
	 * @return
	 */
	Page select(UserGroupRoleCriteria criteria);
}