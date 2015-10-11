/**
 * 一句话描述该类：前端登录控制器，提供页面跳转，访问方法返回JSON<br/>
 * @author 黄记新 <br/>
 * @date 2015-4-29,10:52 <br/>
 *
 */
package com.jcin.cms.modules.syst.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jcin.cms.modules.syst.domain.User;
import com.jcin.cms.web.BaseController;

@Controller
@RequestMapping(value = "${adminPath}")
public class LoginController extends BaseController<User> {

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login(Model uiModel, HttpServletRequest request) {

		return "admin/modules/login";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(@ModelAttribute User user, Model uiModel,
			HttpServletRequest request) {
		String exceptionClassName = (String) request
				.getAttribute("shiroLoginFailure");
		String error = null;
		if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
			error = "用户名/密码错误";
		} else if (IncorrectCredentialsException.class.getName().equals(
				exceptionClassName)) {
			error = "用户名/密码错误";
		} else if (exceptionClassName != null) {
			error = "其他错误：" + exceptionClassName;
		}
		uiModel.addAttribute("error", error);
		return "admin/modules/login";
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String index(Model uiModel) {
		return "admin/modules/index";
	}

}