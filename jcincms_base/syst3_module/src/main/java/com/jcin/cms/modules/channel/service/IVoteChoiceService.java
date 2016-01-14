package  com.jcin.cms.modules.channel.service;

import java.util.List;

import com.jcin.cms.modules.channel.domain.VoteChoice;
import com.jcin.cms.modules.channel.domain.VoteChoiceCriteria;
import com.jcin.cms.modules.channel.service.IVoteChoiceService;
import com.jcin.cms.service.IBaseService;
import com.jcin.cms.utils.Page;

public interface IVoteChoiceService extends IBaseService<VoteChoice, String> {
	/**
	 * 封装查询条件，返回Page对象。
	 * @param criteria
	 * @return
	 */
	Page select(VoteChoiceCriteria criteria);
	
	/**
	 * 根据查询条件进行查询
	 * @param dictionaryCriteria
	 * @return
	 */
	List<VoteChoice> selectByExample(VoteChoiceCriteria criteria);
}