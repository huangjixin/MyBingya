package test.com.jcin.cms.service.system.impl;
import static org.junit.Assert.fail;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.dubbo.common.json.JSON;
import com.alibaba.dubbo.common.json.JSONObject;
import com.jcin.cms.domain.system.Menu;
import com.jcin.cms.service.system.IMenuService;

/**
 * 一句话描述该类：<br/>
 * 
 * @author 黄记新
 * @date 2015-6-21,上午9:03:51
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class TestMenuServiceImpl {
	@Autowired
	private IMenuService menuService;

	@Test
	public void testInsertMenu() {
		Menu menu = new Menu();
		menu.setName("test");
		String id = menuService.insert(menu);
		org.junit.Assert.assertNotNull(id);
	}

	@Test
	public void testGetMenuTree() {
		List<JSONObject> list = menuService.getMenuTree();
		org.junit.Assert.assertNotNull(list);
	}
	
	@Test
	public void testDeleteByPrimaryKey() {
		int id  = menuService.deleteByPrimaryKey("1434850270559");
		org.junit.Assert.assertNotNull(id);
	}

}
