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
import org.springframework.web.servlet.ModelAndView;

import com.jcin.cms.domain.Menu;
import com.jcin.cms.domain.Payed;
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
		if("".equals(menu.getId())){
			menu.setId(null);
		}
		if("".equals(menu.getParentid())){
			menu.setParentid(null);
		}
		menuService.insert(menu);
		return "view/menu/list";
	}
	
	@RequestMapping(value = "/update")
	public String update(@Valid Menu menu, BindingResult bindingResult,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		if("".equals(menu.getId())){
			menu.setId(null);
		}
		if("".equals(menu.getParentid())){
			menu.setParentid(null);
		}
		menuService.update(menu);
		return "view/menu/list";
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/getMenu")
	@ResponseBody
	public List getMenu(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		List list = menuService.getMenuTree(null);
		return list;
	}

	@RequestMapping(value = "/deleteById")
	@ResponseBody
	public int deleteById(
			@RequestParam(value = "idstring", required = true) String idstring,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {

		String[] ids = idstring.split(",");
		int result = 0;
		for (String idStr : ids) {
			result = menuService.deleteByPrimaryKey(idStr);
		}

		return result;
	}


	@RequestMapping(value = "/menuUpdate")
	public ModelAndView menuUpdate(@RequestParam String id,HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		Menu menu = new Menu();
		if (null != id && !"".equals(id)) {
			menu = menuService.selectByPrimaryKey(id);
		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("menu", menu);
		modelAndView.setViewName("view/menu/menu_update");
		return modelAndView;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
