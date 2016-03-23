package  com.jcin.cms.modules.bet.service;

import java.util.List;

import com.jcin.cms.modules.bet.domain.FruitBetresultHistory;
import com.jcin.cms.modules.bet.domain.FruitBetresultHistoryCriteria;
import com.jcin.cms.modules.bet.service.IFruitBetresultHistoryService;
import com.jcin.cms.service.IBaseService;
import com.jcin.cms.utils.Page;

public interface IFruitBetresultHistoryService extends IBaseService<FruitBetresultHistory, String> {
	/**
	 * 封装查询条件，返回Page对象。
	 * @param criteria
	 * @return
	 */
	Page select(FruitBetresultHistoryCriteria criteria);
	
	/**
	 * 根据查询条件进行查询
	 * @param dictionaryCriteria
	 * @return
	 */
	List<FruitBetresultHistory> selectByExample(FruitBetresultHistoryCriteria criteria);
}