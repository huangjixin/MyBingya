/**
 * 一句话描述该类：前端控制器，提供页面跳转，访问方法返回JSON<br/>
 * @author 黄记新 <br/>
 * @date 2015-4-29,10:52 <br/>
 *
 */
package com.jcin.cms.modules.pro.web;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.jcin.cms.modules.pro.domain.Value;
import com.jcin.cms.modules.pro.domain.ValueCriteria;
import com.jcin.cms.modules.pro.service.IValueService;
import com.jcin.cms.utils.Page;
import com.jcin.cms.utils.ExcelUtil;
import com.jcin.cms.web.BaseController;

@Controller
@RequestMapping(value = "${adminPath}/value")
public class ValueController extends BaseController<Value>{
	@Autowired
	private IValueService valueService;

//	@RequiresPermissions("value:create")
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(Value value, Model uiModel) {
		uiModel.addAttribute("value", value);
		return root+"admin/modules/value/value_create.jsp";
	}

//	@RequiresPermissions("value:create")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(Value value, RedirectAttributes redirectAttributes,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		valueService.insert(value);
		
		redirectAttributes.addFlashAttribute("value", value);
		redirectAttributes.addFlashAttribute("msg", "新增成功");
		return "redirect:/"+Global.getAdminPath()+"/value/create";
	}
	
//	@RequiresPermissions("value:update")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String update(@PathVariable("id") String id, Model uiModel) {
		Value value = valueService.selectByPrimaryKey(id);
		uiModel.addAttribute("value", value);
		return root+"admin/modules/value/value_update.jsp";
	}

//	@RequiresPermissions("value:update")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String update(Value value,RedirectAttributes redirectAttributes,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		valueService.update(value);
		
		redirectAttributes.addFlashAttribute("msg", "修改成功");
		redirectAttributes.addFlashAttribute("value", value);
		return "redirect:/"+Global.getAdminPath()+"/value/update/"+value.getId();
	}

//	@RequiresPermissions("value:show")
	@RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
	public String show(@PathVariable("id") String id, Model uiModel) {
		Value value = valueService.selectByPrimaryKey(id);
		
		uiModel.addAttribute("value", value);
		return root+"admin/modules/value/value_show.jsp";
	}

//	@RequiresPermissions("value:view")
	@RequestMapping(value = { "", "list" })
	public String list(HttpServletRequest httpServletRequest) {
		return root+"admin/modules/value/value_list.jsp";
	}

//	@RequiresPermissions("value:delete")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
	public String delete(@PathVariable("id") String id, Model uiModel) {
		valueService.deleteByPrimaryKey(id);
		uiModel.asMap().clear();
		return "redirect:/value";
	}

	void populateEditForm(Model uiModel, Value value) {
		uiModel.addAttribute("value", value);
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

//	@RequiresPermissions("value:view")
	@RequestMapping(value = "/select")
	@ResponseBody
	public Page select(@ModelAttribute Page page, @ModelAttribute Value value,Model uiModel,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		super.select(page, uiModel, httpServletRequest,
				httpServletResponse);
		ValueCriteria valueCriteria = new ValueCriteria();
		ValueCriteria.Criteria criteria = valueCriteria.createCriteria();
		valueCriteria.setPage(page);
		valueCriteria.setOrderByClause("id desc");
		if (null != value.getId()  && !"".equals(value.getId())) {
		  	criteria.andIdLike("%" + value.getId() + "%");
		}
		if (null != value.getName()  && !"".equals(value.getName())) {
		  	criteria.andNameLike("%" + value.getName() + "%");
		}
//		if (null != value.getProProperties_id()  && !"".equals(value.getProProperties_id())) {
//		  	criteria.andProProperties_idLike("%" + value.getProProperties_id() + "%");
//		}
//		if (null != value.getStatus()  && !"".equals(value.getStatus())) {
//		  	criteria.andStatusLike("%" + value.getStatus() + "%");
//		}
//		if (null != value.getProCategory_id()  && !"".equals(value.getProCategory_id())) {
//		  	criteria.andProCategory_idLike("%" + value.getProCategory_id() + "%");
//		}
//		if (null != value.getSortid()  && !"".equals(value.getSortid())) {
//		  	criteria.andSortidLike("%" + value.getSortid() + "%");
//		}
//		if (null != value.getCreateDate()  && !"".equals(value.getCreateDate())) {
//		  	criteria.andCreateDateLike("%" + value.getCreateDate() + "%");
//		}
//		if (null != value.getUpdateDate()  && !"".equals(value.getUpdateDate())) {
//		  	criteria.andUpdateDateLike("%" + value.getUpdateDate() + "%");
//		}
		page = valueService.select(valueCriteria);
		return page;
	}
	
//	@RequiresPermissions("value:delete")
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
		int result = valueService.deleteBatch(list);

		return result;
	}
	
	/**
	 * 全部导出Excel.
	 * @param value
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @throws IOException
	 */
//	@RequiresPermissions("value:view")
	@RequestMapping(value = "/exportExcel")
	public void exportExcel(@ModelAttribute Value value,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		httpServletResponse.setCharacterEncoding("UTF-8");
		String filename = new String("用户信息".getBytes("GBK"), "iso8859-1");

		List<Value>list = valueService.selectAll();

		List<Map<String, Object>> maps = createExcelRecord(list);

		String columnNames[] = { 
			"Id",
			"Name",
			"ProProperties_id",
			"Status",
			"ProCategory_id",
			"Sortid",
			"CreateDate",
			"UpdateDate"
		};// 列名
		String keys[] = { 
			"Id",
			"Name",
			"ProProperties_id",
			"Status",
			"ProCategory_id",
			"Sortid",
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

	private List<Map<String, Object>> createExcelRecord(List<Value> list) {
		List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sheetName", "sheet1");
		listmap.add(map);
		Value value = null;
		for (int j = 0; j < list.size(); j++) {
			value = list.get(j);
			Map<String, Object> mapValue = new HashMap<String, Object>();
				mapValue.put("Id",value.getId());
				mapValue.put("Name",value.getName());
//				mapValue.put("ProProperties_id",value.getProProperties_id());
				mapValue.put("Status",value.getStatus());
//				mapValue.put("ProCategory_id",value.getProCategory_id());
				mapValue.put("Sortid",value.getSortid());
				mapValue.put("CreateDate",value.getCreateDate());
				mapValue.put("UpdateDate",value.getUpdateDate());
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
