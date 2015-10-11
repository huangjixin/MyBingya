package  com.jcin.cms.modules.syst.service;

import com.jcin.cms.modules.syst.domain.UserOrganization;
import com.jcin.cms.modules.syst.domain.UserOrganizationCriteria;
import com.jcin.cms.modules.syst.service.IUserOrganizationService;
import com.jcin.cms.service.IBaseService;
import com.jcin.cms.utils.Page;

public interface IUserOrganizationService extends IBaseService<UserOrganization, String> {
	/**
	 * 封装查询条件，返回Page对象。
	 * @param criteria
	 * @return
	 */
	Page select(UserOrganizationCriteria criteria);
}