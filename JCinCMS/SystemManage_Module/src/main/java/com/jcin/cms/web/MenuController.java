/**
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
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

import com.jcin.cms.domain.system.Menu;
import com.jcin.cms.domain.system.MenuCriteria;
import com.jcin.cms.service.system.IMenuService;
import com.jcin.cms.service.system.impl.vo.MenuExtention;
import com.jcin.cms.utils.Page;

/**
 * @author 黄记新
 * @date 2014-12-18,下午7:01:46
 * 
 */
@Controller
@RequestMapping("/menu")
public class MenuController extends BaseController<Menu> {
	@Resource
	private IMenuService menuService;

	@RequestMapping(value = "/create")
	public ModelAndView create(@Valid Menu menu, BindingResult bindingResult,
			Model uiModel, HttpServletRequest httpServletRequest) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("view/menu/menu_add");
		if (bindingResult.hasErrors()) {
			populateEditForm(modelAndView, menu);
			return modelAndView;
		}
		menu.setCreatedate(new Date());
		super.create(menu, bindingResult, uiModel, httpServletRequest);

		menuService.insert(menu);

		populateEditForm(modelAndView, menu);
		return modelAndView;
	}

	@RequestMapping(value = "new", produces = "text/html")
	public String createForm(Model uiModel) {
		populateEditForm(uiModel, new Menu());
		return "view/menu/menu_add";
	}

	@RequestMapping(value = "/{id}")
	public ModelAndView show(@PathVariable("id") String id, Model uiModel) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("view/menu/menu_show");
		modelAndView.addObject("menu", menuService.selectByPrimaryKey(id));
		modelAndView.addObject("itemId", id);
		return modelAndView;
	}

	@RequestMapping(value = "/list", produces = "text/html")
	public String list(
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "size", required = false) Integer rows,
			Model uiModel) {
		return "view/menu/menu_list";
	}

	@RequestMapping(value = "/select")
	@ResponseBody
	public Page select(@Valid Page page, @Valid Menu menu,
			BindingResult bindingResult, Model uiModel,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		super.select(page, bindingResult, uiModel, httpServletRequest,
				httpServletResponse);
		MenuCriteria menuCriteria = new MenuCriteria();
		MenuCriteria.Criteria criteria = menuCriteria.createCriteria();
		menuCriteria.setPage(page);
		menuCriteria.setOrderByClause("id desc");
		if (null != menu.getName()) {
			criteria.andNameLike("%" + menu.getName() + "%");
		}
		page = menuService.select(menuCriteria);
		return page;
	}

	@RequestMapping(value = "update")
	public ModelAndView update(@Valid Menu menu, BindingResult bindingResult,
			Model uiModel, HttpServletRequest httpServletRequest) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("view/menu/menu_list");

		if (bindingResult.hasErrors()) {
			populateEditForm(modelAndView, menu);
			return modelAndView;
		}
		uiModel.asMap().clear();
		menuService.update(menu);
		populateEditForm(modelAndView, menu);
		return modelAndView;
	}

	@RequestMapping(value = "/edit")
	public ModelAndView updateForm(@RequestParam String id, Model uiModel) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("view/menu/menu_update");
		populateEditForm(modelAndView, menuService.selectByPrimaryKey(id));
		return modelAndView;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
	public String delete(@PathVariable("id") String id,
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "size", required = false) Integer size,
			Model uiModel) {
		menuService.deleteByPrimaryKey(id);
		uiModel.asMap().clear();
		uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
		uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
		return "redirect:/view/menu";
	}

	@RequestMapping(value = "/deleteById")
	@ResponseBody
	public int deleteById(@RequestParam(value = "idstring") String idstring,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {

		String[] ids = idstring.split(",");
		List<String> list = new ArrayList<String>();
		for (String idstr : ids) {
			list.add(idstr);
		}
		int result = menuService.deleteBatch(list);

		return result;
	}

	@RequestMapping(value = "/getMenu")
	@ResponseBody
	public List<MenuExtention> getMenu(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		List<MenuExtention> list = menuService.getMenuTree();
		return list;
	}

	void populateEditForm(Model uiModel, Menu menu) {
		uiModel.addAttribute("menu", menu);
	}

	void populateEditForm(ModelAndView modelAndView, Menu menu) {
		modelAndView.addObject("menu", menu);
	}

	String encodeUrlPathSegment(String pathSegment,
			HttpServletRequest httpServletRequest) {
		String enc = httpServletRequest.getCharacterEncoding();
		if (enc == null) {
			enc = WebUtils.DEFAULT_CHARACTER_ENCODING;
		}
		try {
			pathSegment = UriUtils.encodePathSegment(pathSegment, enc);
		} catch (UnsupportedEncodingException uee) {
		}
		return pathSegment;
	}
}
