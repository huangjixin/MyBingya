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
import org.springframework.web.bind.annotation.RequestParam;
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
	public String create(@Valid Menu menu, BindingResult bindingResult,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		menuService.insert(menu);
		return null;
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/getMenu")
	@ResponseBody
	public List getMenu(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		List list = menuService.getMenuTree();
		return list;
	}

	@RequestMapping(value = "/deleteById")
	@ResponseBody
	public int deleteById(
			@RequestParam(value = "id", required = true) String id,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		int result = menuService.deleteByPrimaryKey(id);

		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
