package  com.jcin.cms.modules.syst.service;


import com.jcin.cms.modules.syst.domain.CreatedTb;
import com.jcin.cms.modules.syst.domain.TqunhuInfo;
import com.jcin.cms.modules.syst.domain.TqunhuInfoCriteria;
import com.jcin.cms.service.IBaseService;
import com.jcin.cms.utils.Page;

public interface ITqunhuInfoService extends IBaseService<TqunhuInfo, String> {
	/**
	 * 封装查询条件，返回Page对象。
	 * @param criteria
	 * @return
	 */
	Page select(TqunhuInfoCriteria criteria);
	
	/**
	 * 查询总条目数。
	 * @param criteria
	 * @return
	 */
	int count(TqunhuInfoCriteria criteria);
	
	/**
     * 动态创建表。
     * @param table_name
     */
    void createTableSql(String table_name);

    /**
     * 动态创建表。
     * @param table_name
     */
    void insertCreatedTb(CreatedTb createdTb);
    
    int insertCreatedTable(CreatedTb createdTb);
}