package  com.jcin.cms.service.system;

import com.jcin.cms.domain.system.UserRole;
import com.jcin.cms.domain.system.UserRoleCriteria;
import com.jcin.cms.service.system.IUserRoleService;
import com.jcin.cms.service.IBaseService;
import com.jcin.cms.utils.Page;

public interface IUserRoleService extends IBaseService<UserRole, String> {
	/**
	 * 封装查询条件，返回Page对象。
	 * @param criteria
	 * @return
	 */
	Page select(UserRoleCriteria criteria);
}