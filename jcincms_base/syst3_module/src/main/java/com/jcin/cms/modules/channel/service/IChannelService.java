package  com.jcin.cms.modules.channel.service;

import java.util.List;
import java.util.Set;

import com.jcin.cms.modules.channel.domain.Channel;
import com.jcin.cms.modules.channel.domain.ChannelCriteria;
import com.jcin.cms.modules.syst.domain.Resource;
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

	/**
	 * 根据父类Id进行查询。
	 * @param id
	 * @return
	 */
	List<Channel> getByParentId(String id);
	
	/**
	 * 根据父类Id进行查询。
	 * @param id
	 * @return
	 */
	Channel getByCode(String name);
	
	/**
	 * 创建栏目树。
	 * @return
	 */
	List<Channel> getChannelTree();
}