package  com.jcin.cms.modules.syst.service;

import java.util.List;

import com.jcin.cms.modules.syst.domain.MemberLebel;
import com.jcin.cms.modules.syst.domain.MemberLebelCriteria;
import com.jcin.cms.modules.syst.service.IMemberLebelService;
import com.jcin.cms.service.IBaseService;
import com.jcin.cms.utils.Page;

public interface IMemberLebelService extends IBaseService<MemberLebel, String> {
	/**
	 * 封装查询条件，返回Page对象。
	 * @param criteria
	 * @return
	 */
	Page select(MemberLebelCriteria criteria);
	
	/**
	 * 根据查询条件进行查询
	 * @param dictionaryCriteria
	 * @return
	 */
	List<MemberLebel> selectByExample(MemberLebelCriteria criteria);
}