package  com.jcin.cms.modules.pro.service;

import java.util.List;

import com.jcin.cms.modules.pro.domain.Order;
import com.jcin.cms.modules.pro.domain.OrderCriteria;
import com.jcin.cms.modules.pro.service.IOrderService;
import com.jcin.cms.service.IBaseService;
import com.jcin.cms.utils.Page;

public interface IOrderService extends IBaseService<Order, String> {
	/**
	 * 封装查询条件，返回Page对象。
	 * @param criteria
	 * @return
	 */
	Page select(OrderCriteria criteria);
	
	/**
	 * 根据查询条件进行查询
	 * @param dictionaryCriteria
	 * @return
	 */
	List<Order> selectByExample(OrderCriteria criteria);
}