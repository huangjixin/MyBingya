/**
 * 一句话描述该类：<br/>
 * @author 黄记新
 * @date 2015-3-3,下午7:22:10
 *
 */
package com.jcin.cms.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/testController")
public class TestController {

	@RequestMapping(value="/test")
	@ResponseBody
	public String test() {
		return "test hello";
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
