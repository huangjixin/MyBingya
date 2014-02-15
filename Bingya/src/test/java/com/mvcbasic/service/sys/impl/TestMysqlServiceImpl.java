package com.mvcbasic.service.sys.impl;

import static org.junit.Assert.fail;

import java.io.IOException;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bingya.service.system.IMySqlService;

@RunWith(SpringJUnit4ClassRunner.class)
//指定测试用例的运行器 这里是指定了Junit4
@ContextConfiguration({ "/META-INF/spring/applicationContext.xml" })
//指定Spring的配置文件 /为classpath下
public class TestMysqlServiceImpl {
	@Resource
	private IMySqlService mySqlService;
	@Test
	public void testBackup() throws IOException {
		String database = mySqlService.backup(null);
		fail("尚未实现");
	}

	@Test
	public void testRestore() {
		mySqlService.restore("E:/game_workspace/Bingya/src/main/resources/aa.sql",true);
		fail("尚未实现");
	}

}
