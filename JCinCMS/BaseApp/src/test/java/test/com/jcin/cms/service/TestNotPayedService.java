/**
 * 一句话描述该类：<br/>
 * @author 黄记新
 * @date 2014-12-18,下午7:51:09
 *
 */
package test.com.jcin.cms.service;

import javax.annotation.Resource;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.jcin.cms.domain.NotPayed;
import com.jcin.cms.service.INotPayedService;

@RunWith(SpringJUnit4ClassRunner.class)
// 指定测试用例的运行器 这里是指定了Junit4
@ContextConfiguration(locations = { "classpath:spring/applicationContext.xml" })
// 指定Spring的配置文件 /为classpath下
@Transactional
// // 这个非常关键，如果不加入这个注解配置，事务控制就会完全失效！
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
// 这里的事务关联到配置文件中的事务控制器（transactionManager =
// "transactionManager"），同时指定自动回滚（defaultRollback = true）。这样做操作的数据才不会污染数据库！
public class TestNotPayedService extends TestCase {
	@Resource
	private INotPayedService notPayedService;

	@Test
	public void testInsert() {
		NotPayed notPayed = new NotPayed();
		notPayed.setDescription("描述");
		notPayed.setGoodsMoney((double) 1000);
		notPayed.setMaterial("材质");
		notPayed.setPrice((double) 1000);
		notPayed.setSize("1000*1000");
		notPayed.setWeight((double) 1000);
		String result = notPayedService.insert(notPayed);
		Assert.assertEquals(1, result);
	}
}
