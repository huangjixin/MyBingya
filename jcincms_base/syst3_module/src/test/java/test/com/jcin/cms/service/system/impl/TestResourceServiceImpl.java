package test.com.jcin.cms.service.system.impl;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jcin.cms.modules.syst.domain.Resource;
import com.jcin.cms.modules.syst.service.IResourceService;

/**
 * 一句话描述该类：<br/>
 * 
 * @author 黄记新
 * @date 2015-6-21,上午9:03:51
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class TestResourceServiceImpl {
	@Autowired
	private IResourceService resourceService;

	@Test
	public void testInsertResource() {
		Resource resource = new Resource();
		resource.setName("操作日志");
		resource.setId("12");
		resource.setParentId("11");
		String id = resourceService.insert(resource);
		org.junit.Assert.assertNotNull(id);
	}

	@Test
	public void testGetResourceTree() {
		List<Resource> list = resourceService.getResourceTree(null, false);
		org.junit.Assert.assertNotNull(list);
	}

	@Test
	public void testDeleteByPrimaryKey() {
		int id = resourceService.deleteByPrimaryKey("1434849123735");
		org.junit.Assert.assertNotNull(id);
	}

}
