package test.com.jcin.cms.service.system.impl;
import java.util.List;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jcin.cms.domain.system.Menu;
import com.jcin.cms.service.system.IMenuService;
import com.sun.star.mozilla.MenuSingleChange;

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
		menu.setName("操作日志");
		menu.setId("12");
		menu.setParentId("11");
		String id = menuService.insert(menu);
		org.junit.Assert.assertNotNull(id);
	}

	@Test
	public void testGetMenuTree() {
		List<Menu> list = menuService.getMenuTree();
		org.junit.Assert.assertNotNull(list);
	}
	
	@Test
	public void testDeleteByPrimaryKey() {
		int id  = menuService.deleteByPrimaryKey("1434849123735");
		org.junit.Assert.assertNotNull(id);
	}

}
