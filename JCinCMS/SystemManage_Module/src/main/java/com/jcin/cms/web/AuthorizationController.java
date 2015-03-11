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

import com.jcin.cms.domain.system.Authorization;
import com.jcin.cms.domain.system.AuthorizationCriteria;
import com.jcin.cms.service.system.IAuthorizationService;
import com.jcin.cms.service.system.impl.vo.AuthorizationExtention;
import com.jcin.cms.utils.Page;

/**
 * @author 黄记新
 * @date 2014-12-18,下午7:01:46
 * 
 */
@Controller
@RequestMapping("/authorization")
public class AuthorizationController extends BaseController<Authorization> {
	@Resource
	private IAuthorizationService authorizationService;

	@RequestMapping(value = "/create")
	public ModelAndView create(@Valid Authorization authorization, BindingResult bindingResult,
			Model uiModel, HttpServletRequest httpServletRequest) {
		//为空字符串则为顶级菜单。
		if("".equals(authorization.getParentId())){
			authorization.setParentId(null);
		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("view/authorization/authorization_add");
		if (bindingResult.hasErrors()) {
			populateEditForm(modelAndView, authorization);
			return modelAndView;
		}
		authorization.setCreatedate(new Date());
		super.create(authorization, bindingResult, uiModel, httpServletRequest);

		authorizationService.insert(authorization);

		populateEditForm(modelAndView, authorization);
		modelAndView.addObject("result", "添加成功");
		return modelAndView;
	}

	@RequestMapping(value = "new", produces = "text/html")
	public String createForm(Model uiModel) {
		populateEditForm(uiModel, new Authorization());
		return "view/authorization/authorization_add";
	}

	@RequestMapping(value = "/{id}")
	public ModelAndView show(@PathVariable("id") String id, Model uiModel) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("view/authorization/authorization_show");
		modelAndView.addObject("authorization", authorizationService.selectByPrimaryKey(id));
		modelAndView.addObject("itemId", id);
		return modelAndView;
	}

	@RequestMapping(value = "/list", produces = "text/html")
	public String list(
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "size", required = false) Integer rows,
			Model uiModel) {
		return "view/authorization/authorization_list";
	}

	@RequestMapping(value = "/select")
	@ResponseBody
	public Page select(@Valid Page page, @Valid Authorization authorization,
			BindingResult bindingResult, Model uiModel,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		super.select(page, bindingResult, uiModel, httpServletRequest,
				httpServletResponse);
		AuthorizationCriteria authorizationCriteria = new AuthorizationCriteria();
		AuthorizationCriteria.Criteria criteria = authorizationCriteria.createCriteria();
		authorizationCriteria.setPage(page);
		authorizationCriteria.setOrderByClause("id desc");
		if (null != authorization.getName()) {
			criteria.andNameLike("%" + authorization.getName() + "%");
		}
		page = authorizationService.select(authorizationCriteria);
		return page;
	}

	@RequestMapping(value = "update")
	public ModelAndView update(@Valid Authorization authorization, BindingResult bindingResult,
			Model uiModel, HttpServletRequest httpServletRequest) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("view/authorization/authorization_list");

		if (bindingResult.hasErrors()) {
			populateEditForm(modelAndView, authorization);
			return modelAndView;
		}
		uiModel.asMap().clear();
		authorizationService.update(authorization);
		populateEditForm(modelAndView, authorization);
		modelAndView.addObject("result", "更新成功");
		return modelAndView;
	}

	@RequestMapping(value = "/edit")
	public ModelAndView updateForm(@RequestParam String id, Model uiModel) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("view/authorization/authorization_update");
		populateEditForm(modelAndView, authorizationService.selectByPrimaryKey(id));
		return modelAndView;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
	public String delete(@PathVariable("id") String id,
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "size", required = false) Integer size,
			Model uiModel) {
		authorizationService.deleteByPrimaryKey(id);
		uiModel.asMap().clear();
		uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
		uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
		return "redirect:/view/authorization";
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

	@RequestMapping(value = "/getAuthorization")
	@ResponseBody
	public List<AuthorizationExtention> getAuthorization(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		List<AuthorizationExtention> list = authorizationService.getAuthorizationTree();
		return list;
	}

	void populateEditForm(Model uiModel, Authorization authorization) {
		uiModel.addAttribute("authorization", authorization);
	}

	void populateEditForm(ModelAndView modelAndView, Authorization authorization) {
		modelAndView.addObject("authorization", authorization);
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
