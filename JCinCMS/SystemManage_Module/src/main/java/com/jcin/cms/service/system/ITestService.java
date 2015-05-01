package  com.jcin.cms.service.system;

import com.jcin.cms.domain.system.Test;
import com.jcin.cms.domain.system.TestCriteria;
import com.jcin.cms.service.system.ITestService;
import com.jcin.cms.service.IBaseService;
import com.jcin.cms.utils.Page;

public interface ITestService extends IBaseService<Test, String> {
	/**
	 * 封装查询条件，返回Page对象。
	 * @param criteria
	 * @return
	 */
	Page select(TestCriteria criteria);
}