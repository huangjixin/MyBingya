/**
 * 一句话描述该类：<br/>
 * @author 黄记新
 * @date 2015-3-1,下午8:52:03
 *
 */
package com.jcin.cms.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/JCinCMS")
public class JCinCMSController {
	@RequestMapping(value="/jcincmsController")
	public String test() {
		return "test Jcincms controller";
	}

}
