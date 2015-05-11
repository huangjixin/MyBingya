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

import com.jcin.cms.domain.system.Role;
import com.jcin.cms.domain.system.RoleCriteria;
import com.jcin.cms.service.system.IRoleService;
import com.jcin.cms.utils.Page;
import com.jcin.cms.web.BaseController;

@Controller
@RequestMapping(value = "/role")
public class RoleController extends BaseController<Role>{
	@Resource
	private IRoleService roleService;

	@RequestMapping(value="createForm",method = RequestMethod.POST)
	public String create(@ModelAttribute Role role,
			HttpServletRequest httpServletRequest) {
			roleService.insert(role);
		return "redirect:/role/new";
		//return "redirect:/role/"
		//		+ encodeUrlPathSegment(role.getId().toString(),
		//				httpServletRequest);
	}

	@RequestMapping(value="new", produces = "text/html")
	public String createForm(Model uiModel) {
		populateEditForm(uiModel, new Role());
		return "view/role/role_create";
	}

	@RequestMapping(value = "/{id}", produces = "text/html")
	public String show(@PathVariable("id") String id, Model uiModel) {
		Role role = roleService.selectByPrimaryKey(id);
		uiModel.addAttribute("role", role);
		uiModel.addAttribute("itemId", id);
		return "view/role/role_show";
	}

	@RequestMapping(produces = "text/html")
	public String list(HttpServletRequest httpServletRequest) {
		return "view/role/role_list";
	}

	@RequestMapping(value="updateForm")
	public String update(@ModelAttribute Role role, Model uiModel,
			HttpServletRequest httpServletRequest) {
		uiModel.asMap().clear();
		roleService.update(role);
		return "redirect:/role/"
				+ encodeUrlPathSegment(role.getId().toString(),
						httpServletRequest);
	}

	@RequestMapping(value = "/edit")
	public String updateForm(@PathVariable("id") String id, Model uiModel) {
		Role role = roleService.selectByPrimaryKey(id);
		populateEditForm(uiModel, role);
		return "role/role_update";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
	public String delete(@PathVariable("id") String id, Model uiModel) {
		roleService.deleteByPrimaryKey(id);
		uiModel.asMap().clear();
		return "redirect:/role";
	}

	void populateEditForm(Model uiModel, Role role) {
		uiModel.addAttribute("role", role);
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
	public Page select(@ModelAttribute Page page, @ModelAttribute Role role,BindingResult bindingResult,Model uiModel,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		super.select(page, bindingResult, uiModel, httpServletRequest,
				httpServletResponse);
		RoleCriteria roleCriteria = new RoleCriteria();
		RoleCriteria.Criteria criteria = roleCriteria.createCriteria();
		roleCriteria.setPage(page);
		roleCriteria.setOrderByClause("id desc");
		if (null != role.getId()  && !"".equals(role.getId())) {
		  	criteria.andIdLike("%" + role.getId() + "%");
		}
		if (null != role.getName()  && !"".equals(role.getName())) {
		  	criteria.andNameLike("%" + role.getName() + "%");
		}
		if (null != role.getDescription()  && !"".equals(role.getDescription())) {
		  	criteria.andDescriptionLike("%" + role.getDescription() + "%");
		}
		page = roleService.select(roleCriteria);
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
		int result = roleService.deleteBatch(list);

		return result;
	}
	
	@RequestMapping(value = "/create")
	@ResponseBody
	public String create(@ModelAttribute Role role,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		roleService.insert(role);
		String id = role.getId();
		return id;
	}
	
	@RequestMapping(value = "/update")
	@ResponseBody
	public String update(@ModelAttribute Role role,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		roleService.update(role);
		String id = role.getId();
		return id;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
