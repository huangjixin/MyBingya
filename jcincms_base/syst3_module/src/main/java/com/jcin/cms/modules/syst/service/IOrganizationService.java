package  com.jcin.cms.modules.syst.service;

import com.jcin.cms.modules.syst.domain.Organization;
import com.jcin.cms.modules.syst.domain.OrganizationCriteria;
import com.jcin.cms.modules.syst.service.IOrganizationService;
import com.jcin.cms.service.IBaseService;
import com.jcin.cms.utils.Page;

public interface IOrganizationService extends IBaseService<Organization, String> {
	/**
	 * 封装查询条件，返回Page对象。
	 * @param criteria
	 * @return
	 */
	Page select(OrganizationCriteria criteria);
}