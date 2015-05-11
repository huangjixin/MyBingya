package  com.jcin.cms.service.system;

import com.jcin.cms.domain.system.RoleAuthorization;
import com.jcin.cms.domain.system.RoleAuthorizationCriteria;
import com.jcin.cms.service.system.IRoleAuthorizationService;
import com.jcin.cms.service.IBaseService;
import com.jcin.cms.utils.Page;

public interface IRoleAuthorizationService extends IBaseService<RoleAuthorization, String> {
	/**
	 * 封装查询条件，返回Page对象。
	 * @param criteria
	 * @return
	 */
	Page select(RoleAuthorizationCriteria criteria);
}