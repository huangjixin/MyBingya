package  com.jcin.cms.service.system;

import com.jcin.cms.domain.system.Role;
import com.jcin.cms.domain.system.RoleCriteria;
import com.jcin.cms.service.system.IRoleService;
import com.jcin.cms.service.IBaseService;
import com.jcin.cms.utils.Page;

public interface IRoleService extends IBaseService<Role, String> {
	/**
	 * 封装查询条件，返回Page对象。
	 * @param criteria
	 * @return
	 */
	Page select(RoleCriteria criteria);
}