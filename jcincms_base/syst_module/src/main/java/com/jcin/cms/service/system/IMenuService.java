package  com.jcin.cms.service.system;

import com.jcin.cms.domain.system.Menu;
import com.jcin.cms.domain.system.MenuCriteria;
import com.jcin.cms.service.system.IMenuService;
import com.jcin.cms.service.IBaseService;
import com.jcin.cms.utils.Page;

public interface IMenuService extends IBaseService<Menu, String> {
	/**
	 * 封装查询条件，返回Page对象。
	 * @param criteria
	 * @return
	 */
	Page select(MenuCriteria criteria);
}