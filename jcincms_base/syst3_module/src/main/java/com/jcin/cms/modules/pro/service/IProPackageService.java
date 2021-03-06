package  com.jcin.cms.modules.pro.service;

import java.util.List;

import com.jcin.cms.modules.pro.domain.ProPackage;
import com.jcin.cms.modules.pro.domain.ProPackageCriteria;
import com.jcin.cms.modules.pro.service.IProPackageService;
import com.jcin.cms.service.IBaseService;
import com.jcin.cms.utils.Page;

public interface IProPackageService extends IBaseService<ProPackage, String> {
	/**
	 * 封装查询条件，返回Page对象。
	 * @param criteria
	 * @return
	 */
	Page select(ProPackageCriteria criteria);
	
	/**
	 * 根据查询条件进行查询
	 * @param dictionaryCriteria
	 * @return
	 */
	List<ProPackage> selectByExample(ProPackageCriteria criteria);
}