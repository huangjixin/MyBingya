package  com.jcin.cms.modules.sale.service;

import java.util.List;

import com.jcin.cms.modules.sale.domain.Storage;
import com.jcin.cms.modules.sale.domain.StorageCriteria;
import com.jcin.cms.modules.sale.service.IStorageService;
import com.jcin.cms.service.IBaseService;
import com.jcin.cms.utils.Page;

public interface IStorageService extends IBaseService<Storage, String> {
	/**
	 * 封装查询条件，返回Page对象。
	 * @param criteria
	 * @return
	 */
	Page select(StorageCriteria criteria);
	
	/**
	 * 根据查询条件进行查询
	 * @param dictionaryCriteria
	 * @return
	 */
	List<Storage> selectByExample(StorageCriteria criteria);
}