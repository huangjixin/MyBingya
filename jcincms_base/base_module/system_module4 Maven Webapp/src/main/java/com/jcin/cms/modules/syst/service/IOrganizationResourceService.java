package  com.jcin.cms.modules.syst.service;

import com.jcin.cms.modules.syst.domain.OrganizationResource;
import com.jcin.cms.modules.syst.domain.OrganizationResourceCriteria;
import com.jcin.cms.modules.syst.service.IOrganizationResourceService;
import com.jcin.cms.service.IBaseService;
import com.jcin.cms.utils.Page;

public interface IOrganizationResourceService extends IBaseService<OrganizationResource, String> {
	/**
	 * 封装查询条件，返回Page对象。
	 * @param criteria
	 * @return
	 */
	Page select(OrganizationResourceCriteria criteria);
}