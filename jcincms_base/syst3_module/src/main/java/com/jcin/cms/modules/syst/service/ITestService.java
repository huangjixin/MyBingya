package  com.jcin.cms.modules.syst.service;

import com.jcin.cms.modules.syst.domain.Test;
import com.jcin.cms.modules.syst.domain.TestCriteria;
import com.jcin.cms.modules.syst.service.ITestService;
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