package  com.jcin.cms.modules.bet.service;

import java.util.List;

import com.jcin.cms.modules.bet.domain.FruitBetresult;
import com.jcin.cms.modules.bet.domain.FruitBetresultCriteria;
import com.jcin.cms.modules.bet.service.IFruitBetresultService;
import com.jcin.cms.service.IBaseService;
import com.jcin.cms.utils.Page;

public interface IFruitBetresultService extends IBaseService<FruitBetresult, String> {
	/**
	 * 封装查询条件，返回Page对象。
	 * @param criteria
	 * @return
	 */
	Page select(FruitBetresultCriteria criteria);
	
	/**
	 * 根据查询条件进行查询
	 * @param dictionaryCriteria
	 * @return
	 */
	List<FruitBetresult> selectByExample(FruitBetresultCriteria criteria);
}