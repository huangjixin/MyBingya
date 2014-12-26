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
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.converter.json.Jackson2ObjectMapperFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jcin.cms.domain.Menu;
import com.jcin.cms.domain.User;
import com.jcin.cms.service.IMenuService;

/**
 * @author 黄记新
 * @date 2014-12-18,下午7:01:46
 * 
 */
@Controller
@RequestMapping("/menu")
public class MenuController {
	@Resource
	private IMenuService menuService;

	@RequestMapping("/list")
	public String list() {
		return "view/menu/list";
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

	@RequestMapping(value = "/getMenu")
	@ResponseBody
	public void getMenu(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		List<Menu> list = new ArrayList<Menu>();
		Menu menu = new Menu();
		menu.setId("12");
		menu.setName("123");
		list.add(menu);
		PrintWriter out = httpServletResponse.getWriter();
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(list);
		System.out.println(json);
		out.print(json);
		out.flush();
		out.close();

		// return list;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
