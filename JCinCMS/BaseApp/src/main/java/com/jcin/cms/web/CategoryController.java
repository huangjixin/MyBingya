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
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jcin.cms.domain.Category;
import com.jcin.cms.service.ICategoryService;

/**
 * @author 黄记新
 * @date 2014-12-18,下午7:01:46
 * 
 */
@Controller
@RequestMapping("/category")
public class CategoryController extends BaseController{
	@Resource
	private ICategoryService categoryService;

	@RequestMapping("/list")
	public String list() {
		return "view/category/list";
	}

	@RequestMapping(value = "/new")
	@ResponseBody
	public String create(@Valid Category category, BindingResult bindingResult,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		categoryService.insert(category);
		return null;
	}
	
	@RequestMapping(value = "/update")
	@ResponseBody
	public String update(@Valid Category category, BindingResult bindingResult,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		categoryService.update(category);
		return null;
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/getCategory")
	@ResponseBody
	public List getCategory(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		List list = categoryService.getCategoryTree();
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
			result = categoryService.deleteByPrimaryKey(idStr);
		}

		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
