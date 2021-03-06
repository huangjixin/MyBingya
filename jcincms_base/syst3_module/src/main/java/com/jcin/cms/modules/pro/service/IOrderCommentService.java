package  com.jcin.cms.modules.pro.service;

import java.util.List;

import com.jcin.cms.modules.pro.domain.OrderComment;
import com.jcin.cms.modules.pro.domain.OrderCommentCriteria;
import com.jcin.cms.modules.pro.service.IOrderCommentService;
import com.jcin.cms.service.IBaseService;
import com.jcin.cms.utils.Page;

public interface IOrderCommentService extends IBaseService<OrderComment, String> {
	/**
	 * 封装查询条件，返回Page对象。
	 * @param criteria
	 * @return
	 */
	Page select(OrderCommentCriteria criteria);
	
	/**
	 * 根据查询条件进行查询
	 * @param dictionaryCriteria
	 * @return
	 */
	List<OrderComment> selectByExample(OrderCommentCriteria criteria);
}