package  com.jcin.cms.modules.bet.service;

import java.util.List;

import com.jcin.cms.modules.bet.domain.AccountHistory;
import com.jcin.cms.modules.bet.domain.AccountHistoryCriteria;
import com.jcin.cms.modules.bet.service.IAccountHistoryService;
import com.jcin.cms.service.IBaseService;
import com.jcin.cms.utils.Page;

public interface IAccountHistoryService extends IBaseService<AccountHistory, String> {
	/**
	 * 封装查询条件，返回Page对象。
	 * @param criteria
	 * @return
	 */
	Page select(AccountHistoryCriteria criteria);
	
	/**
	 * 根据查询条件进行查询
	 * @param dictionaryCriteria
	 * @return
	 */
	List<AccountHistory> selectByExample(AccountHistoryCriteria criteria);
}