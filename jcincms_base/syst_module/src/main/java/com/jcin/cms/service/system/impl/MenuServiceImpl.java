/**
 * 一句话描述该类：<br/>
 * @author 黄记新
 * @date 2015-4-26,下午6:56:55
 *
 */
package com.jcin.cms.service.system.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jcin.cms.dao.system.MenuMapper;
import com.jcin.cms.domain.system.Menu;
import com.jcin.cms.domain.system.MenuCriteria;
import com.jcin.cms.service.system.IMenuService;
import com.jcin.cms.service.impl.BaseServiceImpl;
import com.jcin.cms.utils.Page;

/**
 * @author 黄记新
 * @date 2014-12-18,下午6:56:55
 * 
 */
@Service
public class MenuServiceImpl extends BaseServiceImpl<Menu, String>
		implements IMenuService {
	private static Logger logger = Logger.getLogger(MenuServiceImpl.class
			.getName());

	@Resource
	private MenuMapper menuMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.system.IMenuService#deleteByPrimaryKey((java.lang
	 * .String ))
	 */
	@Override
	@Transactional
	public int deleteByPrimaryKey(String id) {
		// super.deleteByPrimaryKey(id);

		int result = menuMapper.deleteByPrimaryKey(id);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.system.IMenuService#insert(com.jcin.cms.service.system.
	 * Menu)
	 */
	@Override
	@Transactional
	public String insert(Menu record) {
		 super.insert(record);

		record.setCreateDate(new Date());
		int result = menuMapper.insert(record);
		String id = record.getId();
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.system.IMenuService#select(com.jcin.cms.utils.Page)
	 */
	@Override
	public Page select(Page page) {
		super.select(page);
		//setOrderByClause("SER_NO  asc , ORG_ID desc");  
		MenuCriteria menuCriteria = new MenuCriteria();
		menuCriteria.setOrderByClause("id desc");
		menuCriteria.setPage(page);
		@SuppressWarnings("rawtypes")
		List list = menuMapper.selectByExample(menuCriteria);
		page.setRows(list);
		int total = menuMapper.countByExample(menuCriteria);
		page.setTotal(total);
		return page;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.system.IMenuService#select(com.jcin.cms.service.system.MenuCriteria)
	 */
	//@Override
	public Page select(MenuCriteria criteria) {
		Page page = new Page();
		@SuppressWarnings("rawtypes")
		List list = menuMapper.selectByExample(criteria);
		page.setRows(list);
		int total = menuMapper.countByExample(criteria);
		page.setTotal(total);
		return page;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.system.IMenuService#selectAll()
	 */
	@Override
	public List<Menu> selectAll() {
		List<Menu> list = menuMapper.selectByExample(null);
		return list;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.system.IMenuService#selectByPrimaryKey(java.lang
	 * .String)
	 */
	@Override
	public Menu selectByPrimaryKey(String id) {
		super.selectByPrimaryKey(id);

		Menu article = menuMapper.selectByPrimaryKey(id);
		return article;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.system.IMenuService#update(com.jcin.cms.service.system.
	 * Menu)
	 */
	@Override
	@Transactional
	public String update(Menu record) {
		// super.update(record);
		record.setUpdateDate(new Date());
		int result = menuMapper.updateByPrimaryKeySelective(record);
		return record.getId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.system.IMenuService#insertBatch(List)
	 */
	@Override
	@Transactional
	public int insertBatch(List<Menu> list) {
		int result = menuMapper.insertBatch(list);
		super.insertBatch(list);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.system.IMenuService#deleteBatch(List)
	 */
	@Override
	@Transactional
	public int deleteBatch(List<String> list) {
		MenuCriteria menuCriteria = new MenuCriteria();
		menuCriteria.createCriteria().andIdIn(list);
		int result = menuMapper.deleteByExample(menuCriteria);
		super.deleteBatch(list);
		return result;
	}

}
