package  com.jcin.cms.modules.syst.service;

import com.jcin.cms.modules.syst.domain.Dictionary;
import com.jcin.cms.modules.syst.domain.DictionaryCriteria;
import com.jcin.cms.modules.syst.service.IDictionaryService;
import com.jcin.cms.service.IBaseService;
import com.jcin.cms.utils.Page;

public interface IDictionaryService extends IBaseService<Dictionary, String> {
	/**
	 * 封装查询条件，返回Page对象。
	 * @param criteria
	 * @return
	 */
	Page select(DictionaryCriteria criteria);
}