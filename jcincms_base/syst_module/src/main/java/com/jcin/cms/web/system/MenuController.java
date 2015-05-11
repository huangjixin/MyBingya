/**
 * 一句话描述该类：前端控制器，提供页面跳转，访问方法返回JSON<br/>
 * @author 黄记新 <br/>
 * @date 2015-4-29,10:52 <br/>
 *
 */
package com.jcin.cms.web.system;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

import com.jcin.cms.domain.system.Menu;
import com.jcin.cms.domain.system.MenuCriteria;
import com.jcin.cms.service.system.IMenuService;
import com.jcin.cms.utils.Page;
import com.jcin.cms.web.BaseController;

@Controller
@RequestMapping(value = "/menu")
public class MenuController extends BaseController<Menu>{
	@Resource
	private IMenuService menuService;

	@RequestMapping(value="createForm",method = RequestMethod.POST)
	public String create(@ModelAttribute Menu menu,
			HttpServletRequest httpServletRequest) {
			menuService.insert(menu);
		return "redirect:/menu/new";
		//return "redirect:/menu/"
		//		+ encodeUrlPathSegment(menu.getId().toString(),
		//				httpServletRequest);
	}

	@RequestMapping(value="new", produces = "text/html")
	public String createForm(Model uiModel) {
		populateEditForm(uiModel, new Menu());
		return "view/menu/menu_create";
	}

	@RequestMapping(value = "/{id}", produces = "text/html")
	public String show(@PathVariable("id") String id, Model uiModel) {
		Menu menu = menuService.selectByPrimaryKey(id);
		uiModel.addAttribute("menu", menu);
		uiModel.addAttribute("itemId", id);
		return "view/menu/menu_show";
	}

	@RequestMapping(produces = "text/html")
	public String list(HttpServletRequest httpServletRequest) {
		return "view/menu/menu_list";
	}

	@RequestMapping(value="updateForm")
	public String update(@ModelAttribute Menu menu, Model uiModel,
			HttpServletRequest httpServletRequest) {
		uiModel.asMap().clear();
		menuService.update(menu);
		return "redirect:/menu/"
				+ encodeUrlPathSegment(menu.getId().toString(),
						httpServletRequest);
	}

	@RequestMapping(value = "/edit")
	public String updateForm(@PathVariable("id") String id, Model uiModel) {
		Menu menu = menuService.selectByPrimaryKey(id);
		populateEditForm(uiModel, menu);
		return "menu/menu_update";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
	public String delete(@PathVariable("id") String id, Model uiModel) {
		menuService.deleteByPrimaryKey(id);
		uiModel.asMap().clear();
		return "redirect:/menu";
	}

	void populateEditForm(Model uiModel, Menu menu) {
		uiModel.addAttribute("menu", menu);
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

	// _/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
	// _/_/_/_/_/_/ 下面将产生JSON格式的返回值
	// _/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
	@RequestMapping(value = "/select")
	@ResponseBody
	public Page select(@ModelAttribute Page page, @ModelAttribute Menu menu,BindingResult bindingResult,Model uiModel,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		super.select(page, bindingResult, uiModel, httpServletRequest,
				httpServletResponse);
		MenuCriteria menuCriteria = new MenuCriteria();
		MenuCriteria.Criteria criteria = menuCriteria.createCriteria();
		menuCriteria.setPage(page);
		menuCriteria.setOrderByClause("id desc");
		if (null != menu.getId()  && !"".equals(menu.getId())) {
		  	criteria.andIdLike("%" + menu.getId() + "%");
		}
		if (null != menu.getName()  && !"".equals(menu.getName())) {
		  	criteria.andNameLike("%" + menu.getName() + "%");
		}
		if (null != menu.getDescription()  && !"".equals(menu.getDescription())) {
		  	criteria.andDescriptionLike("%" + menu.getDescription() + "%");
		}
		if (null != menu.getPath()  && !"".equals(menu.getPath())) {
		  	criteria.andPathLike("%" + menu.getPath() + "%");
		}
		if (null != menu.getParentId()  && !"".equals(menu.getParentId())) {
		  	criteria.andParentIdLike("%" + menu.getParentId() + "%");
		}
		if (null != menu.getIcon()  && !"".equals(menu.getIcon())) {
		  	criteria.andIconLike("%" + menu.getIcon() + "%");
		}
		if (null != menu.getUrl()  && !"".equals(menu.getUrl())) {
		  	criteria.andUrlLike("%" + menu.getUrl() + "%");
		}
		page = menuService.select(menuCriteria);
		return page;
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
	
	@RequestMapping(value = "/create")
	@ResponseBody
	public String create(@ModelAttribute Menu menu,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		menuService.insert(menu);
		String id = menu.getId();
		return id;
	}
	
	@RequestMapping(value = "/update")
	@ResponseBody
	public String update(@ModelAttribute Menu menu,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		menuService.update(menu);
		String id = menu.getId();
		return id;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
