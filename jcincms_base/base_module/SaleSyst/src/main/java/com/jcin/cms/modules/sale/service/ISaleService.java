package  com.jcin.cms.modules.sale.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jcin.cms.modules.sale.domain.Buy;
import com.jcin.cms.modules.sale.domain.Sale;
import com.jcin.cms.modules.sale.domain.SaleCriteria;
import com.jcin.cms.modules.sale.service.ISaleService;
import com.jcin.cms.service.IBaseService;
import com.jcin.cms.utils.Page;

public interface ISaleService extends IBaseService<Sale, String> {
	/**
	 * 封装查询条件，返回Page对象。
	 * @param criteria
	 * @return
	 */
	Page select(SaleCriteria criteria);
	
	/**
	 * 根据查询条件进行查询
	 * @param dictionaryCriteria
	 * @return
	 */
	List<Sale> selectByExample(SaleCriteria criteria);
	
	int updateByExampleSelective(@Param("record") Sale record, @Param("example") SaleCriteria example);
}