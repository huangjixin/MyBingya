package  com.jcin.cms.service.system;

import com.jcin.cms.domain.system.UserGroup;
import com.jcin.cms.domain.system.UserGroupCriteria;
import com.jcin.cms.service.system.IUserGroupService;
import com.jcin.cms.service.IBaseService;
import com.jcin.cms.utils.Page;

public interface IUserGroupService extends IBaseService<UserGroup, String> {
	/**
	 * 封装查询条件，返回Page对象。
	 * @param criteria
	 * @return
	 */
	Page select(UserGroupCriteria criteria);
}