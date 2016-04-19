package  com.jcin.cms.modules.pro.service;

import java.util.List;

import com.jcin.cms.modules.pro.domain.Properties;
import com.jcin.cms.modules.pro.domain.PropertiesCriteria;
import com.jcin.cms.modules.pro.service.IPropertiesService;
import com.jcin.cms.service.IBaseService;
import com.jcin.cms.utils.Page;

public interface IPropertiesService extends IBaseService<Properties, String> {
	/**
	 * 封装查询条件，返回Page对象。
	 * @param criteria
	 * @return
	 */
	Page select(PropertiesCriteria criteria);
	
	/**
	 * 根据查询条件进行查询
	 * @param dictionaryCriteria
	 * @return
	 */
	List<Properties> selectByExample(PropertiesCriteria criteria);
}