package  com.jcin.cms.modules.pro.service;

import java.util.List;

import com.jcin.cms.modules.pro.domain.Product;
import com.jcin.cms.modules.pro.domain.ProductCriteria;
import com.jcin.cms.modules.pro.domain.ProductWithBLOBs;
import com.jcin.cms.modules.pro.service.IProductService;
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
	
	@Override
	ProductWithBLOBs selectByPrimaryKey(String id);
	
	String insert(ProductWithBLOBs record);
	
	String update(ProductWithBLOBs record);
}