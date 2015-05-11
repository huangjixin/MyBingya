package  com.jcin.cms.service.system;

import com.jcin.cms.domain.system.User;
import com.jcin.cms.domain.system.UserCriteria;
import com.jcin.cms.service.system.IUserService;
import com.jcin.cms.service.IBaseService;
import com.jcin.cms.utils.Page;

public interface IUserService extends IBaseService<User, String> {
	/**
	 * 封装查询条件，返回Page对象。
	 * @param criteria
	 * @return
	 */
	Page select(UserCriteria criteria);
}