package  ${packageName};

import com.jcin.cms.domain.system.${domainObjectName};
import com.jcin.cms.domain.system.${domainObjectName}Criteria;
import com.jcin.cms.service.system.I${domainObjectName}Service;
import com.jcin.cms.service.IBaseService;
import com.jcin.cms.utils.Page;

public interface I${domainObjectName}Service extends IBaseService<${domainObjectName}, String> {
	/**
	 * 封装查询条件，返回Page对象。
	 * @param criteria
	 * @return
	 */
	Page select(${domainObjectName}Criteria criteria);
}