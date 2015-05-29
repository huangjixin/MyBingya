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

import com.jcin.cms.domain.system.Test;
import com.jcin.cms.domain.system.TestCriteria;
import com.jcin.cms.service.system.ITestService;
import com.jcin.cms.utils.Page;
import com.jcin.cms.web.BaseController;

@Controller
@RequestMapping(value = "/test")
public class TestController extends BaseController<Test>{
	@Resource
	private ITestService testService;


	@RequestMapping(value="login", produces = "text/html")
	public String login(Model uiModel) {
		populateEditForm(uiModel, new Test());
		return "view/test/test_create";
	}
	
	@RequestMapping(value="createForm",method = RequestMethod.POST)
	public String create(@ModelAttribute Test test,
			HttpServletRequest httpServletRequest) {
			testService.insert(test);
		return "redirect:/test/new";
		//return "redirect:/test/"
		//		+ encodeUrlPathSegment(test.getId().toString(),
		//				httpServletRequest);
	}

	@RequestMapping(value="new", produces = "text/html")
	public String createForm(Model uiModel) {
		populateEditForm(uiModel, new Test());
		return "view/test/test_create";
	}

	@RequestMapping(value = "/{id}", produces = "text/html")
	public String show(@PathVariable("id") String id, Model uiModel) {
		Test test = testService.selectByPrimaryKey(id);
		uiModel.addAttribute("test", test);
		uiModel.addAttribute("itemId", id);
		return "view/test/test_show";
	}

	@RequestMapping(produces = "text/html")
	public String list(HttpServletRequest httpServletRequest) {
		return "view/test/test_list";
	}

	@RequestMapping(value="updateForm")
	public String update(@ModelAttribute Test test, Model uiModel,
			HttpServletRequest httpServletRequest) {
		uiModel.asMap().clear();
		testService.update(test);
		return "redirect:/test/"
				+ encodeUrlPathSegment(test.getId().toString(),
						httpServletRequest);
	}

	@RequestMapping(value = "/edit")
	public String updateForm(@PathVariable("id") String id, Model uiModel) {
		Test test = testService.selectByPrimaryKey(id);
		populateEditForm(uiModel, test);
		return "test/test_update";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
	public String delete(@PathVariable("id") String id, Model uiModel) {
		testService.deleteByPrimaryKey(id);
		uiModel.asMap().clear();
		return "redirect:/test";
	}

	void populateEditForm(Model uiModel, Test test) {
		uiModel.addAttribute("test", test);
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
	public Page select(@ModelAttribute Page page, @ModelAttribute Test test,BindingResult bindingResult,Model uiModel,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		super.select(page, bindingResult, uiModel, httpServletRequest,
				httpServletResponse);
		TestCriteria testCriteria = new TestCriteria();
		TestCriteria.Criteria criteria = testCriteria.createCriteria();
		testCriteria.setPage(page);
		testCriteria.setOrderByClause("id desc");
		if (null != test.getId()  && !"".equals(test.getId())) {
		  	criteria.andIdLike("%" + test.getId() + "%");
		}
		if (null != test.getDescription()  && !"".equals(test.getDescription())) {
		  	criteria.andDescriptionLike("%" + test.getDescription() + "%");
		}
		page = testService.select(testCriteria);
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
		int result = testService.deleteBatch(list);

		return result;
	}
	
	@RequestMapping(value = "/create")
	@ResponseBody
	public String create(@ModelAttribute Test test,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		testService.insert(test);
		String id = test.getId();
		return id;
	}
	
	@RequestMapping(value = "/update")
	@ResponseBody
	public String update(@ModelAttribute Test test,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		testService.update(test);
		String id = test.getId();
		return id;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
