/**
 * 一句话描述该类：<br/>
 * @author 黄记新
 * @date 2016-6-14,上午10:07:01
 *
 */
package com.jcin.cms.web;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 功能概要：
 * 
 * @author 黄记新
 * @since2015年9月28日
 */
// 指定bean注入的配置文件
@ContextConfiguration("classpath:spring/applicationContext.xml")
//@ContextConfiguration(locations = { "classpath:application.xml" })
// 使用标准的JUnit @RunWith注释来告诉JUnit使用Spring TestRunner
@RunWith(SpringJUnit4ClassRunner.class)
public abstract class SpringTestCase extends AbstractJUnit4SpringContextTests {
	protected Logger logger = LoggerFactory.getLogger(getClass());
}
