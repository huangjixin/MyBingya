/**
 * 一句话描述该类：安装向导控制器<br/>
 * @author 黄记新
 * @date 2015-6-2,上午10:25:58
 *
 */
package com.jcin.cms.web.setup;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/setup") 
public class SetupController {

	/**
	 * 1.首页。
	 * @return
	 */
	@RequestMapping(value="/license")
	public String license() {
		return "index";
	}
	
	/**
	 * 2.数据库设置。
	 * @return
	 */
	@RequestMapping(value="/database")
	public String database() {
		return "database";
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
