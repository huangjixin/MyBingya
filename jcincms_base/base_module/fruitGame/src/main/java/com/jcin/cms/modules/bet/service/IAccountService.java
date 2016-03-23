package  com.jcin.cms.modules.bet.service;

import java.util.List;

import com.jcin.cms.modules.bet.domain.Account;
import com.jcin.cms.modules.bet.domain.AccountCriteria;
import com.jcin.cms.modules.bet.service.IAccountService;
import com.jcin.cms.service.IBaseService;
import com.jcin.cms.utils.Page;

public interface IAccountService extends IBaseService<Account, String> {
	/**
	 * 封装查询条件，返回Page对象。
	 * @param criteria
	 * @return
	 */
	Page select(AccountCriteria criteria);
	
	/**
	 * 根据查询条件进行查询
	 * @param dictionaryCriteria
	 * @return
	 */
	List<Account> selectByExample(AccountCriteria criteria);
}