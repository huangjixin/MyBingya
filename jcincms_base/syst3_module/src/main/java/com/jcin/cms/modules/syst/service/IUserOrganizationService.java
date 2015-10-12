package  com.jcin.cms.modules.syst.service;

import java.util.List;

import com.jcin.cms.modules.syst.domain.UserOrganization;
import com.jcin.cms.modules.syst.domain.UserOrganizationCriteria;
import com.jcin.cms.service.IBaseService;
import com.jcin.cms.utils.Page;

public interface IUserOrganizationService extends IBaseService<UserOrganization, String> {
	/**
	 * 封装查询条件，返回Page对象。
	 * @param criteria
	 * @return
	 */
	Page select(UserOrganizationCriteria criteria);
	
	/**
	 * 根据查询条件进行查询
	 * @param dictionaryCriteria
	 * @return
	 */
	List<UserOrganization> selectByExample(UserOrganizationCriteria criteria);
}