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

import com.jcin.cms.domain.system.Operationlog;
import com.jcin.cms.domain.system.OperationlogCriteria;
import com.jcin.cms.service.system.IOpeLogService;
import com.jcin.cms.utils.Page;

/**
 * @author 黄记新
 * @date 2014-12-18,下午7:01:46
 * 
 */
@Controller
@RequestMapping("/opelog")
public class OpelogController extends BaseController<Operationlog> {
	@Resource
	private IOpeLogService opeLogService;

	@RequestMapping(value = "/create")
	public ModelAndView create(@Valid Operationlog operationlog,
			BindingResult bindingResult, Model uiModel,
			HttpServletRequest httpServletRequest) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("view/opelog/opelog_add");
		if (bindingResult.hasErrors()) {
			populateEditForm(modelAndView, operationlog);
			return modelAndView;
		}
		operationlog.setCreatedate(new Date());
		super.create(operationlog, bindingResult, uiModel, httpServletRequest);

		opeLogService.insert(operationlog);

		populateEditForm(modelAndView, operationlog);
		return modelAndView;
	}

	@RequestMapping(value = "new", produces = "text/html")
	public String createForm(Model uiModel) {
		populateEditForm(uiModel, new Operationlog());
		return "view/opelog/opelog_add";
	}

	@RequestMapping(value = "/{id}")
	public ModelAndView show(@PathVariable("id") String id, Model uiModel) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("view/opelog/opelog_show");
		modelAndView.addObject("operationlog",
				opeLogService.selectByPrimaryKey(id));
		modelAndView.addObject("itemId", id);
		return modelAndView;
	}

	@RequestMapping(value = "list", produces = "text/html")
	public String list(
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "size", required = false) Integer rows,
			Model uiModel) {
		return "view/opelog/opelog_list";
	}

	@RequestMapping(value = "/select")
	@ResponseBody
	public Page select(@Valid Page page, @Valid Operationlog operationlog,
			BindingResult bindingResult, Model uiModel,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		super.select(page, bindingResult, uiModel, httpServletRequest,
				httpServletResponse);
		OperationlogCriteria operationlogCriteria = new OperationlogCriteria();
		OperationlogCriteria.Criteria criteria = operationlogCriteria
				.createCriteria();
		operationlogCriteria.setPage(page);
		operationlogCriteria.setOrderByClause("id desc");
		if (null != operationlog.getName()) {
			criteria.andNameLike("%" + operationlog.getName() + "%");
		}
		page = opeLogService.select(operationlogCriteria);
		return page;
	}

	@RequestMapping(value = "update")
	public ModelAndView update(@Valid Operationlog operationlog,
			BindingResult bindingResult, Model uiModel,
			HttpServletRequest httpServletRequest) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("view/opelog/opelog_list");

		if (bindingResult.hasErrors()) {
			populateEditForm(modelAndView, operationlog);
			return modelAndView;
		}
		uiModel.asMap().clear();
		opeLogService.update(operationlog);
		populateEditForm(modelAndView, operationlog);
		return modelAndView;
	}

	@RequestMapping(value = "/edit")
	public ModelAndView updateForm(@RequestParam String id, Model uiModel) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("view/opelog/opelog_update");
		populateEditForm(modelAndView, opeLogService.selectByPrimaryKey(id));
		return modelAndView;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
	public String delete(@PathVariable("id") String id,
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "size", required = false) Integer size,
			Model uiModel) {
		opeLogService.deleteByPrimaryKey(id);
		uiModel.asMap().clear();
		uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
		uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
		return "redirect:/view/opelog";
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
		int result = opeLogService.deleteBatch(list);

		return result;
	}

	void populateEditForm(Model uiModel, Operationlog operationlog) {
		uiModel.addAttribute("operationlog", operationlog);
	}

	void populateEditForm(ModelAndView modelAndView, Operationlog operationlog) {
		modelAndView.addObject("operationlog", operationlog);
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
