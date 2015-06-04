package  com.jcin.cms.service.system;

import com.jcin.cms.domain.system.Authorization;
import com.jcin.cms.domain.system.AuthorizationCriteria;
import com.jcin.cms.service.system.IAuthorizationService;
import com.jcin.cms.service.IBaseService;
import com.jcin.cms.utils.Page;

public interface IAuthorizationService extends IBaseService<Authorization, String> {
	/**
	 * 封装查询条件，返回Page对象。
	 * @param criteria
	 * @return
	 */
	Page select(AuthorizationCriteria criteria);
}