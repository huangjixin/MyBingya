/**
 * 中兴软创<br/>
 * 一句话描述该类：<br/>
 * @author 黄记新
 * @date 2014-12-18,下午7:51:09
 *
 */
package com.jcin.cms.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.jcin.cms.domain.Operationlog;
import com.jcin.cms.domain.Role;
import com.jcin.cms.domain.User;
import com.jcin.cms.utils.Page;

@RunWith(SpringJUnit4ClassRunner.class)
// 指定测试用例的运行器 这里是指定了Junit4
@ContextConfiguration(locations = { "classpath:spring/applicationContext.xml" })
// 指定Spring的配置文件 /为classpath下
@Transactional
// // 这个非常关键，如果不加入这个注解配置，事务控制就会完全失效！
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
// 这里的事务关联到配置文件中的事务控制器（transactionManager =
// "transactionManager"），同时指定自动回滚（defaultRollback = true）。这样做操作的数据才不会污染数据库！
public class TestOpelogService extends TestCase {
	@Resource
	private IOpeLogService opeLogService;

	@Test
	public void testInsertBatch() {
		List<Operationlog> list = new ArrayList<Operationlog>();
		Operationlog operationlog = new Operationlog();
		operationlog.setId(new Date().getTime()+"");
		operationlog.setName("test d");
		operationlog.setOperator("test");
		operationlog.setCreatedate(new Date());
		operationlog.setIp("localhost");
		operationlog.setDescription("desee");
		list.add(operationlog);
		int result = opeLogService.insertBatch(list);
		Assert.assertEquals(1, result);
	}

	@Test
	public void testDeleteBatch() {
		List<String> list = new ArrayList<String>();
		
		list.add("870136048");
		int result = opeLogService.deleteBatch(list);
		Assert.assertEquals(1, result);
	}

}
