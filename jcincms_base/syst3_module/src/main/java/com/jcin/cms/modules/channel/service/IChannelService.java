package  com.jcin.cms.modules.channel.service;

import java.util.List;

import com.jcin.cms.modules.channel.domain.Channel;
import com.jcin.cms.modules.channel.domain.ChannelCriteria;
import com.jcin.cms.service.IBaseService;
import com.jcin.cms.utils.Page;

public interface IChannelService extends IBaseService<Channel, String> {
	/**
	 * 封装查询条件，返回Page对象。
	 * @param criteria
	 * @return
	 */
	Page select(ChannelCriteria criteria);
	
	/**
	 * 根据查询条件进行查询
	 * @param dictionaryCriteria
	 * @return
	 */
	List<Channel> selectByExample(ChannelCriteria criteria);

	/**
	 * 创建组织树。
	 * 
	 * @return
	 */
	List<Channel> getChannelTree(List<Channel> channels);

	List<Channel> getByParentId(String id);
}