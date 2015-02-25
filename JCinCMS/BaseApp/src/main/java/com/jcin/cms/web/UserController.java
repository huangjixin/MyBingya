/**
 * 中兴软创<br/>
 * 一句话描述该类：<br/>
 * @author 黄记新
 * @date 2014-12-18,下午7:01:46
 *
 */
/**
 * 
 */
package com.jcin.cms.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jcin.cms.domain.User;
import com.jcin.cms.domain.UserCriteria;
import com.jcin.cms.service.IUserService;
import com.jcin.cms.utils.Page;

/**
 * @author 黄记新
 * @date 2014-12-18,下午7:01:46
 * 
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
	@Resource
	private IUserService userService;

	@RequestMapping("/list")
	public String list() {
		return "view/user/list";
	}

	@RequestMapping(value = "/select")
	@ResponseBody
	public Page select(@Valid Page page, BindingResult bindingResult,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		super.select(page, bindingResult, uiModel, httpServletRequest,
				httpServletResponse);
		// 接收前台查询参数
		String name = httpServletRequest.getParameter("username");
		UserCriteria operationlogCriteria = new UserCriteria();
		UserCriteria.Criteria criteria = operationlogCriteria.createCriteria();
		operationlogCriteria.setPage(page);
		if (null != name) {
			criteria.andUsernameLike("%" + name + "%");
		}
		page = userService.select(operationlogCriteria);
		return page;
	}

	@RequestMapping(value = "/deleteById")
	@ResponseBody
	public int deleteById(@RequestParam(value = "idstring") String idstring,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {

		String[] ids = idstring.split(",");
		int result = 0;
		for (String idStr : ids) {
			result = userService.deleteByPrimaryKey(idStr);
		}

		return result;
	}

	@RequestMapping(value = "/new")
	public String create(@Valid User user, BindingResult bindingResult,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		String id = userService.insert(user);
		return this.list();
	}

	@RequestMapping(value = "/resetPassword")
	@ResponseBody
	public ModelMap resetPassword(@RequestParam(value = "id") String id,
			@RequestParam(value = "password") String password,
			@RequestParam(value = "repassword") String repassword,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		ModelMap modelMap = new ModelMap();
		User user = userService.selectByPrimaryKey(id);
		Md5PasswordEncoder passwordEncoder = new Md5PasswordEncoder();
		String pas = passwordEncoder.encodePassword(password, "");

		if (pas.equals(user.getPassword())) {
			pas = passwordEncoder.encodePassword(repassword, "");
			user.setPassword(pas);
			userService.update(user);
		} else {

		}

		return modelMap;
	}

	@RequestMapping(value = "/exportExcel")
	@ResponseBody
	public void exportExcel(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		User user = new User();
		user.setUsername("eteste");
		httpServletResponse.setContentType("text/javascript");
		PrintWriter out = httpServletResponse.getWriter();
		out.print(user);
		out.flush();
		out.close();
	}

	@RequestMapping(value = "/userAdd")
	public String userAdd(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		return "view/user/userAdd";
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
