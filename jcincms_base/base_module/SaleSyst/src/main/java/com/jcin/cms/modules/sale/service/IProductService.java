package  com.jcin.cms.modules.sale.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jcin.cms.modules.sale.domain.Product;
import com.jcin.cms.modules.sale.domain.ProductCriteria;
import com.jcin.cms.modules.sale.domain.ProductSaleTj;
import com.jcin.cms.modules.sale.service.IProductService;
import com.jcin.cms.service.IBaseService;
import com.jcin.cms.utils.Page;

public interface IProductService extends IBaseService<Product, String> {
	/**
	 * 封装查询条件，返回Page对象。
	 * @param criteria
	 * @return
	 */
	Page select(ProductCriteria criteria);
	
	/**
	 * 根据查询条件进行查询
	 * @param dictionaryCriteria
	 * @return
	 */
	List<Product> selectByExample(ProductCriteria criteria);
	
	Page selectTongjiByExample(Product record,ProductCriteria example);
}