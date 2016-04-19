package  com.jcin.cms.modules.pro.service;

import java.util.List;

import com.jcin.cms.modules.pro.domain.Sku;
import com.jcin.cms.modules.pro.domain.SkuCriteria;
import com.jcin.cms.modules.pro.service.ISkuService;
import com.jcin.cms.service.IBaseService;
import com.jcin.cms.utils.Page;

public interface ISkuService extends IBaseService<Sku, String> {
	/**
	 * 封装查询条件，返回Page对象。
	 * @param criteria
	 * @return
	 */
	Page select(SkuCriteria criteria);
	
	/**
	 * 根据查询条件进行查询
	 * @param dictionaryCriteria
	 * @return
	 */
	List<Sku> selectByExample(SkuCriteria criteria);
}