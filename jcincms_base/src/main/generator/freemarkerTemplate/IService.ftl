package  ${packageName};

import java.util.List;

import com.jcin.cms.modules.${moduleName}.domain.${domainObjectName};
import com.jcin.cms.modules.${moduleName}.domain.${domainObjectName}Criteria;
import com.jcin.cms.modules.${moduleName}.service.I${domainObjectName}Service;
import com.jcin.cms.service.IBaseService;
import com.jcin.cms.utils.Page;

public interface I${domainObjectName}Service extends IBaseService<${domainObjectName}, String> {
	/**
	 * 封装查询条件，返回Page对象。
	 * @param criteria
	 * @return
	 */
	Page select(${domainObjectName}Criteria criteria);
	
	/**
	 * 根据查询条件进行查询
	 * @param dictionaryCriteria
	 * @return
	 */
	List<${domainObjectName}> selectByExample(${domainObjectName}Criteria criteria);
}