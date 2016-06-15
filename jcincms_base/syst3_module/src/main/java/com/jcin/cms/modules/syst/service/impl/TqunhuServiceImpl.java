/**
 * 一句话描述该类：用户实现类<br/>
 * @author 黄记新
 * @date 2015-4-26,下午6:56:55
 *
 */
package com.jcin.cms.modules.syst.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jcin.cms.modules.syst.dao.TqunhuInfoMapper;
import com.jcin.cms.modules.syst.domain.CreatedTb;
import com.jcin.cms.modules.syst.domain.TqunhuInfo;
import com.jcin.cms.modules.syst.domain.TqunhuInfoCriteria;
import com.jcin.cms.modules.syst.service.ITqunhuInfoService;
import com.jcin.cms.service.impl.BaseServiceImpl;
import com.jcin.cms.utils.Page;

/**
 * @author 黄记新
 * @date 2014-12-18,下午6:56:55
 * 
 */
@Service(value = "tqunhuInfoService")
public class TqunhuServiceImpl extends BaseServiceImpl<TqunhuInfo, String>
		implements ITqunhuInfoService {
	private static Logger logger = LoggerFactory
			.getLogger(TqunhuServiceImpl.class.getName());

	@javax.annotation.Resource
	private TqunhuInfoMapper tqunhuInfoMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.system.ITqunhuInfoService#deleteByPrimaryKey((java
	 * .lang .String ))
	 */
	@Override
	@Transactional(readOnly = false)
	public int deleteByPrimaryKey(String id) {
		// super.deleteByPrimaryKey(id);

		int result = tqunhuInfoMapper.deleteByPrimaryKey(Integer.valueOf(id));
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.system.ITqunhuInfoService#insert(com.jcin.cms.service
	 * . system. TqunhuInfo)
	 */
	@Override
	@Transactional(readOnly = false)
	public String insert(TqunhuInfo record) {
		// super.insert(record);

		// record.setCreateDate(new Date());
		int result = tqunhuInfoMapper.insert(record);
		String id = record.getId() + "";
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.system.ITqunhuInfoService#select(com.jcin.cms.utils
	 * .Page)
	 */
	@Override
	public Page select(Page page) {
		super.select(page);
		// setOrderByClause("SER_NO  asc , ORG_ID desc");
		TqunhuInfoCriteria roleCriteria = new TqunhuInfoCriteria();
		roleCriteria.setOrderByClause("id desc");
		roleCriteria.setPage(page);
		@SuppressWarnings("rawtypes")
		List list = tqunhuInfoMapper.selectByExample(roleCriteria);
		page.setRows(list);
		int total = tqunhuInfoMapper.countByExample(roleCriteria);
		page.setTotal(total);
		return page;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.system.ITqunhuInfoService#select(com.jcin.cms.service
	 * . system.TqunhuInfoCriteria)
	 */
	// @Override
	public Page select(TqunhuInfoCriteria criteria) {
		Page page = new Page();
		if (null != criteria) {
			if (null != criteria.getPage()) {
				page = criteria.getPage();
			}
		}
		@SuppressWarnings("rawtypes")
		List list = tqunhuInfoMapper.selectByExample(criteria);
		page.setRows(list);
		int total = tqunhuInfoMapper.countByExample(criteria);
		page.setTotal(total);
		return page;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jcin.cms.service.system.ITqunhuInfoService#selectAll()
	 */
	@Override
	public List<TqunhuInfo> selectAll() {
		List<TqunhuInfo> list = tqunhuInfoMapper.selectByExample(null);
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.system.ITqunhuInfoService#selectByPrimaryKey(java
	 * .lang .String)
	 */
	@Override
	public TqunhuInfo selectByPrimaryKey(String id) {
		super.selectByPrimaryKey(id);

		TqunhuInfo article = tqunhuInfoMapper.selectByPrimaryKey(Integer
				.valueOf(id));
		return article;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.system.ITqunhuInfoService#update(com.jcin.cms.service
	 * . system. TqunhuInfo)
	 */
	@Override
	@Transactional(readOnly = false)
	public String update(TqunhuInfo record) {
		// super.update(record);
		// record.setUpdateDate(new Date());
		int result = tqunhuInfoMapper.updateByPrimaryKeySelective(record);
		return record.getId() + "";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jcin.cms.service.system.ITqunhuInfoService#insertBatch(List)
	 */
	@Override
	@Transactional(readOnly = false)
	public int insertBatch(List<TqunhuInfo> list) {
		int result = tqunhuInfoMapper.insertBatch(list);
		super.insertBatch(list);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jcin.cms.service.system.ITqunhuInfoService#deleteBatch(List)
	 */
	@Override
	@Transactional(readOnly = false)
	public int deleteBatch(List<String> list) {
		// TqunhuInfoCriteria roleCriteria = new TqunhuInfoCriteria();
		// roleCriteria.createCriteria().andIdIn(list);
		// int result = tqunhuInfoMapper.deleteByExample(roleCriteria);
		// super.deleteBatch(list);
		return 0;
	}

	@Override
	public int count(TqunhuInfoCriteria criteria) {
		int total = tqunhuInfoMapper.countByExample(criteria);
		return total;
	}

	/**
	 * 动态创建表。
	 * 
	 * @param table_name
	 */
	@Override
	public void createTableSql(String table_name) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("table_name", table_name);
		tqunhuInfoMapper.createTableSql(map);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void insertCreatedTb(CreatedTb createdTb) {
		tqunhuInfoMapper.insertCreatedTb(createdTb);
	}

	@Override
	public int insertCreatedTable(CreatedTb createdTb) {
		int res = tqunhuInfoMapper.insertCreatedTable(createdTb);
		return res;
	}
}
