/**
 * 一句话描述该类：<br/>
 * @author 黄记新
 * @date 2015-3-3,下午7:22:10
 *
 */
package com.jcin.cms.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jcin.cms.service.system.IUserService;
import com.jcin.cms.utils.Page;

@Controller
@RequestMapping(value = "/testController")
public class TestController {

	@Resource
	private IUserService userService;

	@RequestMapping(value = "/test")
	@ResponseBody
	public String test() {
		return "test hello";
	}
	
	@RequestMapping(value = "/getPage")
	@ResponseBody
	public Page getPage() {
		Page page = new Page();
		page = userService.select(page);
		return page;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
