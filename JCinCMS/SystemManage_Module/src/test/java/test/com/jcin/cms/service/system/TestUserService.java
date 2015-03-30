/**
 * 一句话描述该类：<br/>
 * @author 黄记新
 * @date 2014-12-18,下午7:51:09
 *
 */
package test.com.jcin.cms.service.system;

import java.util.List;

import javax.annotation.Resource;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.jcin.cms.domain.system.Authorization;
import com.jcin.cms.domain.system.Role;
import com.jcin.cms.domain.system.User;
import com.jcin.cms.domain.system.UserCriteria;
import com.jcin.cms.service.system.IUserService;
import com.jcin.cms.service.system.impl.vo.UserExtention;
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
public class TestUserService extends TestCase {
	// String[] locations = {"bean1.xml", "bean2.xml", "bean3.xml"};
	// ApplicationContext ctx = new ClassPathXmlApplication(locations);

	@Resource
	private IUserService userService;

	@Test
	public void testGetAuthoByUserId() {
		List<Authorization> list = userService.getAuthoByUserId("1");
		assertEquals(1, list.size());
	}
	
	@Test
	public void testUpdate() {
		UserCriteria userCriteria = new UserCriteria();
		userCriteria.createCriteria().andUsernameEqualTo("12334");
		Page page = userService.select(userCriteria);
		User user = (User) page.getRows().get(0);
		user.setPassword("222222");
		List<Role>roles = userService.getRolesByUserId(user.getId());
		userService.update(user,roles.get(0).getId());
//		assertEquals(1, list.size());
	}
	
	@Test
	public void testInsert() {
		User user = new User();
		user.setUsername("admin");
		user.setPassword("123");
		user.setLocked(false);
		String userId = userService.insert(user);
		assertNotNull(userId);
	}
}
