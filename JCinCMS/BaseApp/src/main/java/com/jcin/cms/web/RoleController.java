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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jcin.cms.domain.Role;

/**
 * @author 黄记新
 * @date 2014-12-18,下午7:01:46
 * 
 */
@Controller
@RequestMapping("/role")
public class RoleController {
	@RequestMapping("/list")
	public String list() {
		return "/role/list";
	}

	@RequestMapping(value = "/new")
	@ResponseBody
	public String create(@Valid Role role, BindingResult bindingResult,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		// roleService.insert(role);
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
		Role role = new Role();
		role.setName("eteste");
		httpServletResponse.setContentType("text/javascript");
		PrintWriter out = httpServletResponse.getWriter();
		out.print(role);
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
