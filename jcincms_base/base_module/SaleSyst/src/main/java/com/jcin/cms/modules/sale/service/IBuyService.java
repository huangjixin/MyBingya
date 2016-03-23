package  com.jcin.cms.modules.sale.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jcin.cms.modules.sale.domain.Buy;
import com.jcin.cms.modules.sale.domain.BuyCriteria;
import com.jcin.cms.modules.sale.service.IBuyService;
import com.jcin.cms.service.IBaseService;
import com.jcin.cms.utils.Page;

public interface IBuyService extends IBaseService<Buy, String> {
	/**
	 * 封装查询条件，返回Page对象。
	 * @param criteria
	 * @return
	 */
	Page select(BuyCriteria criteria);
	
	/**
	 * 根据查询条件进行查询
	 * @param dictionaryCriteria
	 * @return
	 */
	List<Buy> selectByExample(BuyCriteria criteria);
	
	int updateByExampleSelective(@Param("record") Buy record, @Param("example") BuyCriteria example);
}