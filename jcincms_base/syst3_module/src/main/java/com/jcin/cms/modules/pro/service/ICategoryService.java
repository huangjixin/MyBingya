package  com.jcin.cms.modules.pro.service;

import java.util.List;
import java.util.Set;

import com.jcin.cms.modules.pro.domain.Category;
import com.jcin.cms.modules.pro.domain.CategoryCriteria;
import com.jcin.cms.modules.pro.service.ICategoryService;
import com.jcin.cms.modules.syst.domain.Resource;
import com.jcin.cms.service.IBaseService;
import com.jcin.cms.utils.Page;

public interface ICategoryService extends IBaseService<Category, String> {
	/**
	 * 封装查询条件，返回Page对象。
	 * @param criteria
	 * @return
	 */
	Page select(CategoryCriteria criteria);
	
	/**
	 * 根据查询条件进行查询
	 * @param dictionaryCriteria
	 * @return
	 */
	List<Category> selectByExample(CategoryCriteria criteria);
	
	/**
	 * 根据父亲节点查找。
	 * @param id
	 * @return
	 */
	List<Category> getByParentId(String id);
	
	/**
	 * 创建种类树。
	 * @return
	 */
	List<Category> getCategoryTree();
}