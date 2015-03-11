package com.jcin.cms.service;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.jcin.cms.service.client.ui.LoginWindow;
import com.jcin.cms.utils.Page;

/**
 * Hello world!
 * 
 */
public class App {
	public static void main(String[] args) {
		String url = "http://192.168.1.101:8081/JCinCMS/testController/getPage";
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		Page page = restTemplate.getForObject(url, Page.class);
		
//		@SuppressWarnings("resource")
//		ApplicationContext ctx = new  FileSystemXmlApplicationContext(new String[]{"classpath:spring/applicationContext.xml"});
//		IUserService userService = (IUserService) ctx.getBean("userService");
//		Page page = new Page();
//		page = userService.select(page);
//		System.out.println(page.getRows().size());
		
		LoginWindow loginWindow = new LoginWindow();
	}
}
