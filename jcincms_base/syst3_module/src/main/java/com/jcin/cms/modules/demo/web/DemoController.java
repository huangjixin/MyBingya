/**
 * 一句话描述该类：<br/>
 * @author 黄记新
 * @date 2015-10-21,下午4:00:41
 *
 */
/**
 * 
 */
package com.jcin.cms.modules.demo.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 黄记新
 * 
 */
@Controller
@RequestMapping(value = "channel")
public class DemoController {

	@RequestMapping
	public String list(HttpServletRequest httpServletRequest) {
		return "admin/modules/document/document_list";
	}
	
	@RequestMapping(value="{name}")
	public String channel(@PathVariable("name") String name,HttpServletRequest httpServletRequest) {
		return "admin/modules/document/document_list";
	}
	
	
	@RequestMapping(value="{name}/{id}")
	public String doc(@PathVariable("name") String name,@PathVariable("id") String id, HttpServletRequest httpServletRequest) {
		return "admin/modules/channel/channel_list";
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

}
