package  com.jcin.cms.modules.channel.service;

import java.util.List;

import com.jcin.cms.modules.channel.domain.Test;
import com.jcin.cms.modules.channel.domain.TestCriteria;
import com.jcin.cms.modules.channel.service.ITestService;
import com.jcin.cms.service.IBaseService;
import com.jcin.cms.utils.Page;

public interface ITestService extends IBaseService<Test, String> {
	/**
	 * 封装查询条件，返回Page对象。
	 * @param criteria
	 * @return
	 */
	Page select(TestCriteria criteria);
	
	/**
	 * 根据查询条件进行查询
	 * @param dictionaryCriteria
	 * @return
	 */
	List<Test> selectByExample(TestCriteria criteria);
}