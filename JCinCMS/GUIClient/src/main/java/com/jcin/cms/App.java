package com.jcin.cms;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.jcin.cms.service.system.IUserService;
import com.jcin.cms.utils.Page;

/**
 * Hello world!
 * 
 */
public class App {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext ctx = new  FileSystemXmlApplicationContext(new String[]{"classpath:spring/applicationContext.xml"});
		IUserService userService = (IUserService) ctx.getBean("userService");
		Page page = new Page();
		page = userService.select(page);
		System.out.println(page.getRows().size());
	}
}
