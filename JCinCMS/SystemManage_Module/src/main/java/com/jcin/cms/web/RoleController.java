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

import com.jcin.cms.domain.system.Role;
import com.jcin.cms.domain.system.RoleCriteria;
import com.jcin.cms.service.system.IRoleService;
import com.jcin.cms.utils.Page;

/**
 * @author 黄记新
 * @date 2014-12-18,下午7:01:46
 * 
 */
@Controller
@RequestMapping("/role")
public class RoleController extends BaseController<Role> {
	@Resource
	private IRoleService roleService;

	@RequestMapping(value = "/create")
	public ModelAndView create(@Valid Role role,
			BindingResult bindingResult, Model uiModel,
			HttpServletRequest httpServletRequest) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("view/role/role_add");
		if (bindingResult.hasErrors()) {
			populateEditForm(modelAndView, role);
			return modelAndView;
		}
		role.setCreatedate(new Date());
		super.create(role, bindingResult, uiModel, httpServletRequest);

		roleService.insert(role);

		populateEditForm(modelAndView, role);
		return modelAndView;
	}

	@RequestMapping(value = "new", produces = "text/html")
	public String createForm(Model uiModel) {
		populateEditForm(uiModel, new Role());
		return "view/role/role_add";
	}

	@RequestMapping(value = "/{id}")
	public ModelAndView show(@PathVariable("id") String id, Model uiModel) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("view/role/role_show");
		modelAndView.addObject("role",
				roleService.selectByPrimaryKey(id));
		modelAndView.addObject("itemId", id);
		return modelAndView;
	}

	@RequestMapping(value = "list", produces = "text/html")
	public String list(
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "size", required = false) Integer rows,
			Model uiModel) {
		return "view/role/role_list";
	}

	@RequestMapping(value = "/select")
	@ResponseBody
	public Page select(@Valid Page page, @Valid Role role,
			BindingResult bindingResult, Model uiModel,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		super.select(page, bindingResult, uiModel, httpServletRequest,
				httpServletResponse);
		RoleCriteria roleCriteria = new RoleCriteria();
		RoleCriteria.Criteria criteria = roleCriteria
				.createCriteria();
		roleCriteria.setPage(page);
		roleCriteria.setOrderByClause("id desc");
		if (null != role.getName()) {
			criteria.andNameLike("%" + role.getName() + "%");
		}
		page = roleService.select(roleCriteria);
		return page;
	}
	
	@RequestMapping(value = "/selectAll")
	@ResponseBody
	public List<Role> selectAll(HttpServletRequest httpServletRequest) {
		List<Role> list = roleService.selectAll();
		return list;
	}
	
	@RequestMapping(value = "update")
	public ModelAndView update(@Valid Role role,
			BindingResult bindingResult, Model uiModel,
			HttpServletRequest httpServletRequest) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("view/role/role_list");

		if (bindingResult.hasErrors()) {
			populateEditForm(modelAndView, role);
			return modelAndView;
		}
		uiModel.asMap().clear();
		roleService.update(role);
		populateEditForm(modelAndView, role);
		return modelAndView;
	}

	@RequestMapping(value = "/edit")
	public ModelAndView updateForm(@RequestParam String id, Model uiModel) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("view/role/role_update");
		populateEditForm(modelAndView, roleService.selectByPrimaryKey(id));
		return modelAndView;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
	public String delete(@PathVariable("id") String id,
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "size", required = false) Integer size,
			Model uiModel) {
		roleService.deleteByPrimaryKey(id);
		uiModel.asMap().clear();
		uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
		uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
		return "redirect:/view/role";
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
		int result = roleService.deleteBatch(list);

		return result;
	}

	void populateEditForm(Model uiModel, Role role) {
		uiModel.addAttribute("role", role);
	}

	void populateEditForm(ModelAndView modelAndView, Role role) {
		modelAndView.addObject("role", role);
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
