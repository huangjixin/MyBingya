/**
 * 中兴软创<br/>
 * 一句话描述该类：<br/>
 * @author 黄记新
 * @date 2014-12-18,下午6:56:55
 *
 */
/**
 * 
 */
package com.jcin.cms.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jcin.cms.dao.MenuMapper;
import com.jcin.cms.domain.Menu;
import com.jcin.cms.domain.MenuCriteria;
import com.jcin.cms.service.IMenuService;
import com.jcin.cms.utils.Page;

/**
 * @author 黄记新
 * @date 2014-12-18,下午6:56:55
 * 
 */
@Service(value = "menuService")
public class MenuServiceImpl extends BaseServiceImpl<Menu, String> implements
		IMenuService {
	private static Logger logger = Logger.getLogger(MenuServiceImpl.class
			.getName());

	@Resource
	private MenuMapper menuMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jcin.cms.service.IMenuService#deleteByPrimaryKey((java.lang.String))
	 */
	@Override
	public int deleteByPrimaryKey(String id) {
		super.deleteByPrimaryKey(id);

		int result = menuMapper.deleteByPrimaryKey(id);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jcin.cms.service.IMenuService#insert(com.jcin.cms.domain.Menu)
	 */
	@Override
	@Transactional
	public int insert(Menu record) {
		super.insert(record);

		record.setCreatedate(new Date());
		int result = menuMapper.insert(record);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jcin.cms.service.IMenuService#select(com.jcin.cms.utils.Page)
	 */
	@Override
	public Page select(Page page) {
		super.select(page);

		MenuCriteria menuCriteria = new MenuCriteria();
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
	 * com.jcin.cms.service.IMenuService#selectByPrimaryKey(java.lang.String)
	 */
	@Override
	public Menu selectByPrimaryKey(String id) {
		super.selectByPrimaryKey(id);

		Menu menu = menuMapper.selectByPrimaryKey(id);
		return menu;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jcin.cms.service.IMenuService#update(com.jcin.cms.domain.Menu)
	 */
	@Override
	@Transactional
	public int update(Menu record) {
		super.update(record);

		int result = menuMapper.updateByPrimaryKeySelective(record);
		return result;
	}

}
