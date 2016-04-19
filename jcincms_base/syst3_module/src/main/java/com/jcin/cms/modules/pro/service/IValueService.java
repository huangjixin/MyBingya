package  com.jcin.cms.modules.pro.service;

import java.util.List;

import com.jcin.cms.modules.pro.domain.Value;
import com.jcin.cms.modules.pro.domain.ValueCriteria;
import com.jcin.cms.modules.pro.service.IValueService;
import com.jcin.cms.service.IBaseService;
import com.jcin.cms.utils.Page;

public interface IValueService extends IBaseService<Value, String> {
	/**
	 * 封装查询条件，返回Page对象。
	 * @param criteria
	 * @return
	 */
	Page select(ValueCriteria criteria);
	
	/**
	 * 根据查询条件进行查询
	 * @param dictionaryCriteria
	 * @return
	 */
	List<Value> selectByExample(ValueCriteria criteria);
}