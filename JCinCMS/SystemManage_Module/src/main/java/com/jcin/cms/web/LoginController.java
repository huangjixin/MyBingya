/**
 * 中兴软创<br/>
 * 一句话描述该类：登录验证，登出跳转<br/>
 * @author 黄记新
 * @date 2014-12-18,下午5:41:35
 *
 */
package com.jcin.cms.web;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jcin.cms.domain.Operationlog;
import com.jcin.cms.domain.User;
import com.jcin.cms.service.IOpeLogService;
import com.jcin.cms.service.IUserService;
import com.jcin.cms.utils.EncryptUtil;
import com.jcin.cms.web.vo.LoginResponse;

@Controller
@RequestMapping(value = "/login")
public class LoginController {
	@Resource
	private IUserService userService;

	@Resource
	private IOpeLogService opeLogService;

	@Resource
	private EncryptUtil encryptUtil;

	@RequestMapping
	public String login(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		return "view/login";
	}

	@RequestMapping(value = "/validatelogin")
	@ResponseBody
	public Map validateLogin(
			@Valid User user,
			@RequestParam(value = "encryptStrLength", required = false) Integer encryptStrLength,
			BindingResult bindingResult, Model uiModel,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		String password = user.getPassword();
		// System.out.println("加密原文密码是：" + password);
		password = (String) encryptUtil.decrypt(password);
		// if (null != encryptStrLength) {
		// System.out.println("解密原文密码是："
		// + password.substring(0, encryptStrLength));
		// } else
		System.out.println("解密原文密码是：" + password);
		ModelMap modelMap = new ModelMap();
		List<User> list = userService.validateLogin(user.getUsername(),
				user.getPassword());
		if (list.size() == 0) {
			modelMap.put("loginResult", "error");
			modelMap.put("loginInfo", "用户名或者密码错误。");
			return modelMap;
		}
		String ip = httpServletRequest.getRemoteHost();
		user.setIp(ip);
		userService.update(user);
		LoginResponse loginResponse = LoginResponse.getInstance();
		LoginResponse.user = user;
		HttpSession session = httpServletRequest.getSession();

		session.setAttribute("loginInfo", loginResponse);
		modelMap.put("loginResult", "success");

		// 操作日志。
		Operationlog operationlog = new Operationlog();
		operationlog.setId(new Date().getTime() + "");
		String opeName = Thread.currentThread().getStackTrace()[1]
				.getMethodName();
		operationlog.setName(LoginController.class.getName() + "." + opeName
				+ " 登录成功");
		if (LoginResponse.user != null) {
			operationlog.setOperator(LoginResponse.user.getUsername());
		}

		operationlog.setCreatedate(new Date());
		opeLogService.insert(operationlog);

		return modelMap;
	}

	@RequestMapping(value = "/logout")
	public String logout() {
		return "logout";
	}

	@RequestMapping(value = "/validatelogout")
	public String validateLogout(@Valid User user, BindingResult bindingResult,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		// ModelMap modelMap = new ModelMap();

		LoginResponse.user = null;

		HttpSession session = httpServletRequest.getSession();

		session.setAttribute("loginInfo", null);
		String viewPath = httpServletRequest.getContextPath();
		return "view/login";
	}
}
