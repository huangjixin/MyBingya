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

import org.springframework.beans.BeanUtils;
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
import com.jcin.cms.domain.system.User;
import com.jcin.cms.domain.system.UserCriteria;
import com.jcin.cms.service.system.IUserService;
import com.jcin.cms.utils.Page;

/**
 * @author 黄记新
 * @date 2014-12-18,下午7:01:46
 * 
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController<User> {
	@Resource
	private IUserService userService;

	@RequestMapping(value = "/create")
	public ModelAndView create(@Valid User user,@Valid String roleId,
			BindingResult bindingResult, Model uiModel,
			HttpServletRequest httpServletRequest) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("view/user/user_add");
		if (bindingResult.hasErrors()) {
			populateEditForm(modelAndView, user);
			return modelAndView;
		}
		user.setCreatedate(new Date());
//		super.create(user, bindingResult, uiModel, httpServletRequest);

		userService.insert(user,roleId);
		modelAndView.addObject("roleId", roleId);
		populateEditForm(modelAndView, user);
		return modelAndView;
	}

	@RequestMapping(value = "new", produces = "text/html")
	public String createForm(Model uiModel) {
		populateEditForm(uiModel, new User());
		uiModel.addAttribute("roleId", "");
		return "view/user/user_add";
	}

	@RequestMapping(value = "/{id}")
	public ModelAndView show(@PathVariable("id") String id, Model uiModel) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("view/user/user_show");
		modelAndView.addObject("user", userService.selectByPrimaryKey(id));
		modelAndView.addObject("itemId", id);
		return modelAndView;
	}

	@RequestMapping(value = "list", produces = "text/html")
	public String list(
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "size", required = false) Integer rows,
			Model uiModel) {
		return "view/user/user_list";
	}

	@RequestMapping(value = "/select")
	@ResponseBody
	public Page select(@Valid Page page, @Valid User user,
			BindingResult bindingResult, Model uiModel,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		super.select(page, bindingResult, uiModel, httpServletRequest,
				httpServletResponse);
		UserCriteria userCriteria = new UserCriteria();
		UserCriteria.Criteria criteria = userCriteria.createCriteria();
		userCriteria.setPage(page);
		userCriteria.setOrderByClause("id desc");
		if (null != user.getUsername()) {
			criteria.andUsernameLike("%" + user.getUsername() + "%");
		}
		page = userService.select(userCriteria);
		return page;
	}

	@RequestMapping(value = "update")
	public String update(@Valid User user, @Valid String roleId, BindingResult bindingResult,
			Model uiModel, HttpServletRequest httpServletRequest) {
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.setViewName("view/user/user_list");
//
//		if (bindingResult.hasErrors()) {
//			populateEditForm(modelAndView, user);
//			return modelAndView;
//		}
//		uiModel.asMap().clear();
		userService.update(user,roleId);
//		populateEditForm(modelAndView, user);
//		return modelAndView;
		return "view/user/user_list";
	}

	@RequestMapping(value = "/edit")
	public ModelAndView updateForm(@RequestParam String id, Model uiModel) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("view/user/user_update");
		User user = userService.selectByPrimaryKey(id);
		List<Role>roles = userService.getRolesByUserId(id);
		String roleId = "";
		if(roles.size()>0){
			roleId = roles.get(0).getId();
		}
		populateEditForm(modelAndView, user);
		modelAndView.addObject("roleId", roleId);
		return modelAndView;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
	public String delete(@PathVariable("id") String id,
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "size", required = false) Integer size,
			Model uiModel) {
		userService.deleteByPrimaryKey(id);
		uiModel.asMap().clear();
		uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
		uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
		return "redirect:/view/user";
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
		int result = userService.deleteBatch(list);

		return result;
	}

	void populateEditForm(Model uiModel, User user) {
		uiModel.addAttribute("user", user);
	}

	void populateEditForm(ModelAndView modelAndView, User user) {
		modelAndView.addObject("user", user);
		
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
