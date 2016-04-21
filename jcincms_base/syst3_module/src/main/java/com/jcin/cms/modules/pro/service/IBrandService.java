package  com.jcin.cms.modules.pro.service;

import java.util.List;

import com.jcin.cms.modules.pro.domain.Brand;
import com.jcin.cms.modules.pro.domain.BrandCriteria;
import com.jcin.cms.modules.pro.domain.BrandWithBLOBs;
import com.jcin.cms.modules.pro.service.IBrandService;
import com.jcin.cms.service.IBaseService;
import com.jcin.cms.utils.Page;

public interface IBrandService extends IBaseService<Brand, String> {
	/**
	 * 封装查询条件，返回Page对象。
	 * @param criteria
	 * @return
	 */
	Page select(BrandCriteria criteria);
	
	/**
	 * 根据查询条件进行查询
	 * @param dictionaryCriteria
	 * @return
	 */
	List<BrandWithBLOBs> selectByExample(BrandCriteria criteria);

	String insert(BrandWithBLOBs record);
	
	BrandWithBLOBs selectByPrimaryKey(String id);
	
	String update(BrandWithBLOBs record);
}