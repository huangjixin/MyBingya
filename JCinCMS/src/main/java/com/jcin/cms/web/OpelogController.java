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

import com.jcin.cms.domain.OperationlogCriteria;
import com.jcin.cms.service.IOpeLogService;
import com.jcin.cms.utils.Page;

/**
 * @author 黄记新
 * @date 2014-12-18,下午7:01:46
 * 
 */
@Controller
@RequestMapping("/opelog")
public class OpelogController extends BaseController {
	@Resource
	private IOpeLogService opeLogService;

	@RequestMapping("/list")
	public String list() {
		return "view/opelog/list";
	}

	@RequestMapping(value = "/select")
	@ResponseBody
	public Page select(@Valid Page page, BindingResult bindingResult,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		super.select(page, bindingResult, uiModel, httpServletRequest,
				httpServletResponse);
		// 接收前台查询参数
		String name = httpServletRequest.getParameter("name");
		String operator = httpServletRequest.getParameter("operator");
		OperationlogCriteria operationlogCriteria = new OperationlogCriteria();
		OperationlogCriteria.Criteria criteria = operationlogCriteria
				.createCriteria();
		operationlogCriteria.setPage(page);
		if (null != name) {
			criteria.andNameLike("%" + name + "%");
		}
		if (null != operator) {
			criteria.andOperatorLike("%" + operator + "%");
		}

		page = opeLogService.select(operationlogCriteria);
		return page;
	}

	@RequestMapping(value = "/deleteById")
	@ResponseBody
	public int deleteById(@RequestParam(value = "idstring") String idstring,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {

		String[] ids = idstring.split(",");
		int result = 0;
		for (String idStr : ids) {
			result = opeLogService.deleteByPrimaryKey(idStr);
		}

		return result;
	}

}
