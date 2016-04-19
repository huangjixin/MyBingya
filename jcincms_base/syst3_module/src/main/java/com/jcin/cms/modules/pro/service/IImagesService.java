package  com.jcin.cms.modules.pro.service;

import java.util.List;

import com.jcin.cms.modules.pro.domain.Images;
import com.jcin.cms.modules.pro.domain.ImagesCriteria;
import com.jcin.cms.modules.pro.service.IImagesService;
import com.jcin.cms.service.IBaseService;
import com.jcin.cms.utils.Page;

public interface IImagesService extends IBaseService<Images, String> {
	/**
	 * 封装查询条件，返回Page对象。
	 * @param criteria
	 * @return
	 */
	Page select(ImagesCriteria criteria);
	
	/**
	 * 根据查询条件进行查询
	 * @param dictionaryCriteria
	 * @return
	 */
	List<Images> selectByExample(ImagesCriteria criteria);
}