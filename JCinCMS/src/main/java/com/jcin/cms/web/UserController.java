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

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jcin.cms.domain.UserCriteria;
import com.jcin.cms.domain.User;
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
	@ResponseBody
	public String create(@Valid User user, BindingResult bindingResult,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		// userService.insert(user);
		httpServletResponse.setContentType("text/html");
		PrintWriter out = httpServletResponse.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
		return null;
	}

	@RequestMapping(value = "/test")
	@ResponseBody
	public void test(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		User user = new User();
		user.setUsername("eteste");
		httpServletResponse.setContentType("text/javascript");
		PrintWriter out = httpServletResponse.getWriter();
		out.print(user);
		out.flush();
		out.close();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
