package  com.jcin.cms.modules.channel.service;

import java.util.List;

import com.jcin.cms.modules.channel.domain.Assets;
import com.jcin.cms.modules.channel.domain.AssetsCriteria;
import com.jcin.cms.modules.channel.service.IAssetsService;
import com.jcin.cms.service.IBaseService;
import com.jcin.cms.utils.Page;

public interface IAssetsService extends IBaseService<Assets, String> {
	/**
	 * 封装查询条件，返回Page对象。
	 * @param criteria
	 * @return
	 */
	Page select(AssetsCriteria criteria);
	
	/**
	 * 根据查询条件进行查询
	 * @param dictionaryCriteria
	 * @return
	 */
	List<Assets> selectByExample(AssetsCriteria criteria);
}