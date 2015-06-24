package  com.jcin.cms.service.system;

import java.util.List;

import com.jcin.cms.domain.system.Menu;
import com.jcin.cms.domain.system.MenuCriteria;
import com.jcin.cms.service.IBaseService;
import com.jcin.cms.utils.Page;

public interface IMenuService extends IBaseService<Menu, String> {
	/**
	 * 查询全部菜单,组织成树的形式。
	 * 
	 * @return
	 */
	List<Menu> getMenuTree();

	/**
	 * 根据ParentId列查询记录数。
	 * @param id
	 * @return
	 */
	List<Menu> getByParentId(String id);
	
	/**
	 * 封装查询条件，返回Page对象。
	 * @param criteria
	 * @return
	 */
	Page select(MenuCriteria criteria);
}