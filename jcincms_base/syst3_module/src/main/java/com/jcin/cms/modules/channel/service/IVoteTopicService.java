package  com.jcin.cms.modules.channel.service;

import java.util.List;

import com.jcin.cms.modules.channel.domain.VoteTopic;
import com.jcin.cms.modules.channel.domain.VoteTopicCriteria;
import com.jcin.cms.modules.channel.service.IVoteTopicService;
import com.jcin.cms.service.IBaseService;
import com.jcin.cms.utils.Page;

public interface IVoteTopicService extends IBaseService<VoteTopic, String> {
	/**
	 * 封装查询条件，返回Page对象。
	 * @param criteria
	 * @return
	 */
	Page select(VoteTopicCriteria criteria);
	
	/**
	 * 根据查询条件进行查询
	 * @param dictionaryCriteria
	 * @return
	 */
	List<VoteTopic> selectByExample(VoteTopicCriteria criteria);
}