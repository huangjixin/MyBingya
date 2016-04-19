package  com.jcin.cms.modules.pro.service;

import java.util.List;

import com.jcin.cms.modules.pro.domain.ProductValue;
import com.jcin.cms.modules.pro.domain.ProductValueCriteria;
import com.jcin.cms.modules.pro.service.IProductValueService;
import com.jcin.cms.service.IBaseService;
import com.jcin.cms.utils.Page;

public interface IProductValueService extends IBaseService<ProductValue, String> {
	/**
	 * 封装查询条件，返回Page对象。
	 * @param criteria
	 * @return
	 */
	Page select(ProductValueCriteria criteria);
	
	/**
	 * 根据查询条件进行查询
	 * @param dictionaryCriteria
	 * @return
	 */
	List<ProductValue> selectByExample(ProductValueCriteria criteria);
}