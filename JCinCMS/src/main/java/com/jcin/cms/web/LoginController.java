/**
 * 中兴软创<br/>
 * 一句话描述该类：登录验证，登出跳转<br/>
 * @author 黄记新
 * @date 2014-12-18,下午5:41:35
 *
 */
package com.jcin.cms.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.jcin.cms.domain.User;
import com.jcin.cms.service.IUserService;
import com.jcin.cms.web.vo.LoginResponse;

@Controller
@RequestMapping(value = "/login")
public class LoginController {
	@Resource
	private IUserService userService;

	@RequestMapping
	public String login(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		return "view/login";
	}

	@RequestMapping(value = "/validatelogin")
	public Object validateLogin(@Valid @NotNull User user,
			BindingResult bindingResult, Model uiModel,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		ModelAndView modelAndView = new ModelAndView();

		List<User> list = userService.validateLogin(user.getUsername(),
				user.getPassword());
		if (list.size() == 0) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("loginInfo", "用户名或者密码错误。");
			modelAndView.addObject(map);
			return new ModelAndView("view/login", map);
		}

		LoginResponse loginResponse = LoginResponse.getInstance();
		HttpSession session = httpServletRequest.getSession();

		session.setAttribute("loginInfo", loginResponse);

		return new ModelAndView(new RedirectView(
				httpServletRequest.getContextPath()));
	}

	@RequestMapping(value = "/logout")
	public String logout() {
		return "logout";
	}

	@RequestMapping(value = "/validatelogout")
	public ModelAndView validateLogout(@Valid @NotNull User user,
			BindingResult bindingResult, Model uiModel,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		ModelAndView modelAndView = new ModelAndView();

		List<User> list = userService.validateLogin(user.getUsername(),
				user.getPassword());
		if (list.size() == 0) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("loginInfo", "用户名或者密码错误。");
			modelAndView.addObject(map);
			return modelAndView;
		}

		LoginResponse loginResponse = LoginResponse.getInstance();
		HttpSession session = httpServletRequest.getSession();

		session.setAttribute("loginInfo", loginResponse);

		return new ModelAndView(new RedirectView("view/login"));
	}
}
