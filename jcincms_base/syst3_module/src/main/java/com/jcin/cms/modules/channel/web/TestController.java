/**
 * 一句话描述该类：前端控制器，提供页面跳转，访问方法返回JSON<br/>
 * @author 黄记新 <br/>
 * @date 2015-4-29,10:52 <br/>
 *
 */
package com.jcin.cms.modules.channel.web;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

import com.jcin.cms.common.Global;
import com.jcin.cms.modules.channel.domain.Test;
import com.jcin.cms.modules.channel.domain.TestCriteria;
import com.jcin.cms.modules.channel.service.ITestService;
import com.jcin.cms.utils.Page;
import com.jcin.cms.utils.ExcelUtil;
import com.jcin.cms.web.BaseController;

@Controller
@RequestMapping(value = "admin/test")
public class TestController extends BaseController<Test>{
	@Resource
	private ITestService testService;

//	@RequiresPermissions("test:create")
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(Test test, Model uiModel) {
		uiModel.addAttribute("test", test);
		return "admin/modules/test/test_create";
	}

//	@RequiresPermissions("test:create")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(Test test, RedirectAttributes redirectAttributes,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		testService.insert(test);
		
		redirectAttributes.addFlashAttribute("test", test);
		redirectAttributes.addFlashAttribute("msg", "新增成功");
		return "redirect:/"+Global.getAdminPath()+"/test/create";
	}
	
//	@RequiresPermissions("test:update")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String update(@PathVariable("id") String id, Model uiModel) {
		Test test = testService.selectByPrimaryKey(id);
		uiModel.addAttribute("test", test);
		return "admin/modules/test/test_update";
	}

//	@RequiresPermissions("test:update")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String update(Test test,RedirectAttributes redirectAttributes,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		testService.update(test);
		
		redirectAttributes.addFlashAttribute("msg", "修改成功");
		redirectAttributes.addFlashAttribute("test", test);
		return "redirect:/"+Global.getAdminPath()+"/test/update/"+test.getId();
	}

//	@RequiresPermissions("test:show")
	@RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
	public String show(@PathVariable("id") String id, Model uiModel) {
		Test test = testService.selectByPrimaryKey(id);
		
		uiModel.addAttribute("test", test);
		return "admin/modules/test/test_show";
	}

//	@RequiresPermissions("test:view")
	@RequestMapping(value = { "", "list" })
	public String list(HttpServletRequest httpServletRequest) {
		return "admin/modules/test/test_list";
	}

//	@RequiresPermissions("test:delete")
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

//	@RequiresPermissions("test:view")
	@RequestMapping(value = "/select")
	@ResponseBody
	public Page select(@ModelAttribute Page page, @ModelAttribute Test test,Model uiModel,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		super.select(page, uiModel, httpServletRequest,
				httpServletResponse);
		TestCriteria testCriteria = new TestCriteria();
		TestCriteria.Criteria criteria = testCriteria.createCriteria();
		testCriteria.setPage(page);
		testCriteria.setOrderByClause("id desc");
		if (null != test.getId()  && !"".equals(test.getId())) {
		  	criteria.andIdLike("%" + test.getId() + "%");
		}
		if (null != test.getName()  && !"".equals(test.getName())) {
		  	criteria.andNameLike("%" + test.getName() + "%");
		}
		page = testService.select(testCriteria);
		return page;
	}
	
//	@RequiresPermissions("test:delete")
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
	
	/**
	 * 全部导出Excel.
	 * @param test
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @throws IOException
	 */
//	@RequiresPermissions("test:view")
	@RequestMapping(value = "/exportExcel")
	public void exportExcel(@ModelAttribute Test test,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		httpServletResponse.setCharacterEncoding("UTF-8");
		String filename = new String("用户信息".getBytes("GBK"), "iso8859-1");

		List<Test>list = testService.selectAll();

		List<Map<String, Object>> maps = createExcelRecord(list);

		String columnNames[] = { 
			"Id",
			"Name",
			"CreateDate",
			"UpdateDate"
		};// 列名
		String keys[] = { 
			"Id",
			"Name",
			"CreateDate",
			"UpdateDate"
		};// map中的key
		Workbook hwb = ExcelUtil.createWorkBook(maps, keys, columnNames);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");// 等价于now.toLocaleString()
		filename += "_" + sdf.format(new Date()) + ".xls";
		httpServletResponse.setContentType("APPLICATION/OCTET-STREAM");
		httpServletResponse.setHeader("Content-Disposition",
				"attachment; filename=\"" + filename + "\"");
		OutputStream os = httpServletResponse.getOutputStream();
		hwb.write(os);
		os.flush();
		os.close();
	}

	private List<Map<String, Object>> createExcelRecord(List<Test> list) {
		List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sheetName", "sheet1");
		listmap.add(map);
		Test test = null;
		for (int j = 0; j < list.size(); j++) {
			test = list.get(j);
			Map<String, Object> mapValue = new HashMap<String, Object>();
				mapValue.put("Id",test.getId());
				mapValue.put("Name",test.getName());
				mapValue.put("CreateDate",test.getCreateDate());
				mapValue.put("UpdateDate",test.getUpdateDate());
			listmap.add(mapValue);
		}
		return listmap;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
