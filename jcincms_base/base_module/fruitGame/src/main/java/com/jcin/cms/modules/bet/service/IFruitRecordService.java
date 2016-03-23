package  com.jcin.cms.modules.bet.service;

import java.util.List;

import com.jcin.cms.modules.bet.domain.FruitRecord;
import com.jcin.cms.modules.bet.domain.FruitRecordCriteria;
import com.jcin.cms.modules.bet.service.IFruitRecordService;
import com.jcin.cms.service.IBaseService;
import com.jcin.cms.utils.Page;

public interface IFruitRecordService extends IBaseService<FruitRecord, String> {
	/**
	 * 封装查询条件，返回Page对象。
	 * @param criteria
	 * @return
	 */
	Page select(FruitRecordCriteria criteria);
	
	/**
	 * 根据查询条件进行查询
	 * @param dictionaryCriteria
	 * @return
	 */
	List<FruitRecord> selectByExample(FruitRecordCriteria criteria);
}