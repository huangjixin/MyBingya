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

import com.jcin.cms.domain.system.RoleAuthorization;
import com.jcin.cms.domain.system.RoleAuthorizationCriteria;
import com.jcin.cms.service.system.IRoleAuthorizationService;
import com.jcin.cms.utils.Page;
import com.jcin.cms.web.BaseController;

@Controller
@RequestMapping(value = "/roleAuthorization")
public class RoleAuthorizationController extends BaseController<RoleAuthorization>{
	@Resource
	private IRoleAuthorizationService roleAuthorizationService;

	@RequestMapping(value="createForm",method = RequestMethod.POST)
	public String create(@ModelAttribute RoleAuthorization roleAuthorization,
			HttpServletRequest httpServletRequest) {
			roleAuthorizationService.insert(roleAuthorization);
		return "redirect:/roleAuthorization/new";
		//return "redirect:/roleAuthorization/"
		//		+ encodeUrlPathSegment(roleAuthorization.getId().toString(),
		//				httpServletRequest);
	}

	@RequestMapping(value="new", produces = "text/html")
	public String createForm(Model uiModel) {
		populateEditForm(uiModel, new RoleAuthorization());
		return "view/roleAuthorization/roleAuthorization_create";
	}

	@RequestMapping(value = "/{id}", produces = "text/html")
	public String show(@PathVariable("id") String id, Model uiModel) {
		RoleAuthorization roleAuthorization = roleAuthorizationService.selectByPrimaryKey(id);
		uiModel.addAttribute("roleAuthorization", roleAuthorization);
		uiModel.addAttribute("itemId", id);
		return "view/roleAuthorization/roleAuthorization_show";
	}

	@RequestMapping(produces = "text/html")
	public String list(HttpServletRequest httpServletRequest) {
		return "view/roleAuthorization/roleAuthorization_list";
	}

	@RequestMapping(value="updateForm")
	public String update(@ModelAttribute RoleAuthorization roleAuthorization, Model uiModel,
			HttpServletRequest httpServletRequest) {
		uiModel.asMap().clear();
		roleAuthorizationService.update(roleAuthorization);
		return "redirect:/roleAuthorization/"
				+ encodeUrlPathSegment(roleAuthorization.getId().toString(),
						httpServletRequest);
	}

	@RequestMapping(value = "/edit")
	public String updateForm(@PathVariable("id") String id, Model uiModel) {
		RoleAuthorization roleAuthorization = roleAuthorizationService.selectByPrimaryKey(id);
		populateEditForm(uiModel, roleAuthorization);
		return "roleAuthorization/roleAuthorization_update";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
	public String delete(@PathVariable("id") String id, Model uiModel) {
		roleAuthorizationService.deleteByPrimaryKey(id);
		uiModel.asMap().clear();
		return "redirect:/roleAuthorization";
	}

	void populateEditForm(Model uiModel, RoleAuthorization roleAuthorization) {
		uiModel.addAttribute("roleAuthorization", roleAuthorization);
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
	public Page select(@ModelAttribute Page page, @ModelAttribute RoleAuthorization roleAuthorization,BindingResult bindingResult,Model uiModel,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		super.select(page, bindingResult, uiModel, httpServletRequest,
				httpServletResponse);
		RoleAuthorizationCriteria roleAuthorizationCriteria = new RoleAuthorizationCriteria();
		RoleAuthorizationCriteria.Criteria criteria = roleAuthorizationCriteria.createCriteria();
		roleAuthorizationCriteria.setPage(page);
		roleAuthorizationCriteria.setOrderByClause("id desc");
		if (null != roleAuthorization.getId()  && !"".equals(roleAuthorization.getId())) {
		  	criteria.andIdLike("%" + roleAuthorization.getId() + "%");
		}
		if (null != roleAuthorization.getRoleId()  && !"".equals(roleAuthorization.getRoleId())) {
		  	criteria.andRoleIdLike("%" + roleAuthorization.getRoleId() + "%");
		}
		if (null != roleAuthorization.getAuthorizationId()  && !"".equals(roleAuthorization.getAuthorizationId())) {
		  	criteria.andAuthorizationIdLike("%" + roleAuthorization.getAuthorizationId() + "%");
		}
		page = roleAuthorizationService.select(roleAuthorizationCriteria);
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
		int result = roleAuthorizationService.deleteBatch(list);

		return result;
	}
	
	@RequestMapping(value = "/create")
	@ResponseBody
	public String create(@ModelAttribute RoleAuthorization roleAuthorization,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		roleAuthorizationService.insert(roleAuthorization);
		String id = roleAuthorization.getId();
		return id;
	}
	
	@RequestMapping(value = "/update")
	@ResponseBody
	public String update(@ModelAttribute RoleAuthorization roleAuthorization,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		roleAuthorizationService.update(roleAuthorization);
		String id = roleAuthorization.getId();
		return id;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
