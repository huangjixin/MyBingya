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

import com.jcin.cms.domain.system.Authorization;
import com.jcin.cms.domain.system.AuthorizationCriteria;
import com.jcin.cms.service.system.IAuthorizationService;
import com.jcin.cms.utils.Page;
import com.jcin.cms.web.BaseController;

@Controller
@RequestMapping(value = "/authorization")
public class AuthorizationController extends BaseController<Authorization>{
	@Resource
	private IAuthorizationService authorizationService;

	@RequestMapping(value="createForm",method = RequestMethod.POST)
	public String create(@ModelAttribute Authorization authorization,
			HttpServletRequest httpServletRequest) {
			authorizationService.insert(authorization);
		return "redirect:/authorization/new";
		//return "redirect:/authorization/"
		//		+ encodeUrlPathSegment(authorization.getId().toString(),
		//				httpServletRequest);
	}

	@RequestMapping(value="new", produces = "text/html")
	public String createForm(Model uiModel) {
		populateEditForm(uiModel, new Authorization());
		return "view/authorization/authorization_create";
	}

	@RequestMapping(value = "/{id}", produces = "text/html")
	public String show(@PathVariable("id") String id, Model uiModel) {
		Authorization authorization = authorizationService.selectByPrimaryKey(id);
		uiModel.addAttribute("authorization", authorization);
		uiModel.addAttribute("itemId", id);
		return "view/authorization/authorization_show";
	}

	@RequestMapping(produces = "text/html")
	public String list(HttpServletRequest httpServletRequest) {
		return "view/authorization/authorization_list";
	}

	@RequestMapping(value="updateForm")
	public String update(@ModelAttribute Authorization authorization, Model uiModel,
			HttpServletRequest httpServletRequest) {
		uiModel.asMap().clear();
		authorizationService.update(authorization);
		return "redirect:/authorization/"
				+ encodeUrlPathSegment(authorization.getId().toString(),
						httpServletRequest);
	}

	@RequestMapping(value = "/edit")
	public String updateForm(@PathVariable("id") String id, Model uiModel) {
		Authorization authorization = authorizationService.selectByPrimaryKey(id);
		populateEditForm(uiModel, authorization);
		return "authorization/authorization_update";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
	public String delete(@PathVariable("id") String id, Model uiModel) {
		authorizationService.deleteByPrimaryKey(id);
		uiModel.asMap().clear();
		return "redirect:/authorization";
	}

	void populateEditForm(Model uiModel, Authorization authorization) {
		uiModel.addAttribute("authorization", authorization);
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
	public Page select(@ModelAttribute Page page, @ModelAttribute Authorization authorization,BindingResult bindingResult,Model uiModel,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		super.select(page, bindingResult, uiModel, httpServletRequest,
				httpServletResponse);
		AuthorizationCriteria authorizationCriteria = new AuthorizationCriteria();
		AuthorizationCriteria.Criteria criteria = authorizationCriteria.createCriteria();
		authorizationCriteria.setPage(page);
		authorizationCriteria.setOrderByClause("id desc");
		if (null != authorization.getId()  && !"".equals(authorization.getId())) {
		  	criteria.andIdLike("%" + authorization.getId() + "%");
		}
		if (null != authorization.getName()  && !"".equals(authorization.getName())) {
		  	criteria.andNameLike("%" + authorization.getName() + "%");
		}
		if (null != authorization.getDescription()  && !"".equals(authorization.getDescription())) {
		  	criteria.andDescriptionLike("%" + authorization.getDescription() + "%");
		}
		if (null != authorization.getParentId()  && !"".equals(authorization.getParentId())) {
		  	criteria.andParentIdLike("%" + authorization.getParentId() + "%");
		}
		if (null != authorization.getUrl()  && !"".equals(authorization.getUrl())) {
		  	criteria.andUrlLike("%" + authorization.getUrl() + "%");
		}
		if (null != authorization.getParentIds()  && !"".equals(authorization.getParentIds())) {
		  	criteria.andParentIdsLike("%" + authorization.getParentIds() + "%");
		}
		page = authorizationService.select(authorizationCriteria);
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
		int result = authorizationService.deleteBatch(list);

		return result;
	}
	
	@RequestMapping(value = "/create")
	@ResponseBody
	public String create(@ModelAttribute Authorization authorization,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		authorizationService.insert(authorization);
		String id = authorization.getId();
		return id;
	}
	
	@RequestMapping(value = "/update")
	@ResponseBody
	public String update(@ModelAttribute Authorization authorization,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		authorizationService.update(authorization);
		String id = authorization.getId();
		return id;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
