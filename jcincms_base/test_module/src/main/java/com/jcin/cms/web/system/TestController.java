/**
 * 一句话描述该类：前端控制器，提供页面跳转，访问方法返回JSON<br/>
 * @author 黄记新 <br/>
 * @date 2015-4-29,10:52 <br/>
 *
 */
package com.jcin.cms.web.system;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jcin.cms.domain.system.Role;
import com.jcin.cms.domain.system.Test;
import com.jcin.cms.service.system.ITestService;
import com.jcin.cms.web.BaseController;

@Controller
@RequestMapping(value = "/test")
public class TestController extends BaseController<Test> {
	@Resource
	private ITestService testService;

	@RequestMapping(value = "/getRoles")
	@ResponseBody
	public List<Role> getRoles() {
		List<Role> roles = testService.selectAll();
		return roles;
	}

}
