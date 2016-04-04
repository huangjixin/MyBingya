package  com.jcin.cms.modules.syst.service;

import java.util.List;

import com.jcin.cms.modules.syst.domain.Guestbook;
import com.jcin.cms.modules.syst.domain.GuestbookCriteria;
import com.jcin.cms.modules.syst.service.IGuestbookService;
import com.jcin.cms.service.IBaseService;
import com.jcin.cms.utils.Page;

public interface IGuestbookService extends IBaseService<Guestbook, String> {
	/**
	 * 封装查询条件，返回Page对象。
	 * @param criteria
	 * @return
	 */
	Page select(GuestbookCriteria criteria);
	
	/**
	 * 根据查询条件进行查询
	 * @param dictionaryCriteria
	 * @return
	 */
	List<Guestbook> selectByExample(GuestbookCriteria criteria);
}