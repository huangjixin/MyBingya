/**
 * 一句话描述该类：<br/>
 * @author 黄记新
 * @date 2015-4-26,下午6:56:55
 *
 */
package ${packageName};

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.jcin.cms.modules.${moduleName}.dao.${domainObjectName}Mapper;
import com.jcin.cms.modules.${moduleName}.domain.${domainObjectName};
import com.jcin.cms.modules.${moduleName}.domain.${domainObjectName}Criteria;
import com.jcin.cms.modules.${moduleName}.service.I${domainObjectName}Service;
import com.jcin.cms.service.impl.BaseServiceImpl;
import com.jcin.cms.utils.Page;

/**
 * @author 黄记新
 * @date 2014-12-18,下午6:56:55
 * 
 */
@Service
public class ${domainObjectName}ServiceImpl extends BaseServiceImpl<${domainObjectName}, String>
		implements I${domainObjectName}Service {
	private static Logger logger = Logger.getLogger(${domainObjectName}ServiceImpl.class
			.getName());

	@Autowired
	private ${domainObjectName}Mapper ${daoMapper}Mapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.${moduleName}.I${domainObjectName}Service#deleteByPrimaryKey((java.lang
	 * .String ))
	 */
	@Override
	@Transactional
	public int deleteByPrimaryKey(String id) {
		// super.deleteByPrimaryKey(id);

		int result = ${daoMapper}Mapper.deleteByPrimaryKey(id);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.${moduleName}.I${domainObjectName}Service#insert(com.jcin.cms.service.${moduleName}.
	 * ${domainObjectName})
	 */
	@Override
	@Transactional
	public String insert(${domainObjectName} record) {
		 super.insert(record);

		record.setCreateDate(new Date());
		int result = ${daoMapper}Mapper.insert(record);
		String id = record.getId();
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.${moduleName}.I${domainObjectName}Service#select(com.jcin.cms.utils.Page)
	 */
	@Override
	public Page select(Page page) {
		super.select(page);
		//setOrderByClause("SER_NO  asc , ORG_ID desc");  
		${domainObjectName}Criteria ${daoMapper}Criteria = new ${domainObjectName}Criteria();
		${daoMapper}Criteria.setOrderByClause("id desc");
		${daoMapper}Criteria.setPage(page);
		@SuppressWarnings("rawtypes")
		List list = ${daoMapper}Mapper.selectByExample(${daoMapper}Criteria);
		page.setRows(list);
		int total = ${daoMapper}Mapper.countByExample(${daoMapper}Criteria);
		page.setTotal(total);
		return page;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.${moduleName}.I${domainObjectName}Service#select(com.jcin.cms.service.${moduleName}.${domainObjectName}Criteria)
	 */
	//@Override
	public Page select(${domainObjectName}Criteria criteria) {
		Page page = new Page();
		@SuppressWarnings("rawtypes")
		List list = ${daoMapper}Mapper.selectByExample(criteria);
		page.setRows(list);
		int total = ${daoMapper}Mapper.countByExample(criteria);
		page.setTotal(total);
		return page;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.${moduleName}.I${domainObjectName}Service#selectAll()
	 */
	@Override
	public List<${domainObjectName}> selectAll() {
		List<${domainObjectName}> list = ${daoMapper}Mapper.selectByExample(null);
		return list;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.${moduleName}.I${domainObjectName}Service#selectByPrimaryKey(java.lang
	 * .String)
	 */
	@Override
	public ${domainObjectName} selectByPrimaryKey(String id) {
		super.selectByPrimaryKey(id);

		${domainObjectName} article = ${daoMapper}Mapper.selectByPrimaryKey(id);
		return article;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.${moduleName}.I${domainObjectName}Service#update(com.jcin.cms.service.${moduleName}.
	 * ${domainObjectName})
	 */
	@Override
	@Transactional
	public String update(${domainObjectName} record) {
		// super.update(record);
		record.setUpdateDate(new Date());
		int result = ${daoMapper}Mapper.updateByPrimaryKey(record);
		return record.getId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.${moduleName}.I${domainObjectName}Service#insertBatch(List)
	 */
	@Override
	@Transactional
	public int insertBatch(List<${domainObjectName}> list) {
		int result = ${daoMapper}Mapper.insertBatch(list);
		super.insertBatch(list);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.${moduleName}.I${domainObjectName}Service#deleteBatch(List)
	 */
	@Override
	@Transactional
	public int deleteBatch(List<String> list) {
		${domainObjectName}Criteria ${daoMapper}Criteria = new ${domainObjectName}Criteria();
		${daoMapper}Criteria.createCriteria().andIdIn(list);
		int result = ${daoMapper}Mapper.deleteByExample(${daoMapper}Criteria);
		super.deleteBatch(list);
		return result;
	}
	
	
	@Override
	public List<${domainObjectName}> selectByExample(
			${domainObjectName}Criteria criteria) {
		return  ${daoMapper}Mapper.selectByExample(criteria);
	}

}
