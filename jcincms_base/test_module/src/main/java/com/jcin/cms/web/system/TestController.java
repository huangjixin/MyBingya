/**
 * 一句话描述该类：前端控制器，提供页面跳转，访问方法返回JSON<br/>
 * @author 黄记新 <br/>
 * @date 2015-4-29,10:52 <br/>
 *
 */
package com.jcin.cms.web.system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jcin.cms.domain.system.Test;
import com.jcin.cms.web.BaseController;

@Controller
@RequestMapping(value = "/test")
public class TestController extends BaseController<Test> {
	//使用分布式框架dubbo获取到的接口。
//	@Resource
//	private ITestService testService;

	/*@RequestMapping(value = "/getRoles")
	@ResponseBody
	public List<Role> getRoles() {
		List<Role> roles = new ArrayList<Role>();
//		roles= testService.selectAll();
		return roles;
	}*/

}
