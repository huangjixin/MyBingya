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
import com.jcin.cms.modules.pro.domain.Properties;
import com.jcin.cms.modules.pro.domain.PropertiesCriteria;
import com.jcin.cms.modules.pro.service.IPropertiesService;
import com.jcin.cms.utils.Page;
import com.jcin.cms.utils.ExcelUtil;
import com.jcin.cms.web.BaseController;

@Controller
@RequestMapping(value = "${adminPath}/properties")
public class PropertiesController extends BaseController<Properties>{
	@Autowired
	private IPropertiesService propertiesService;

//	@RequiresPermissions("properties:create")
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(Properties properties, Model uiModel) {
		uiModel.addAttribute("properties", properties);
		return root+"admin/modules/properties/properties_create.jsp";
	}

//	@RequiresPermissions("properties:create")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(Properties properties, RedirectAttributes redirectAttributes,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		propertiesService.insert(properties);
		
		redirectAttributes.addFlashAttribute("properties", properties);
		redirectAttributes.addFlashAttribute("msg", "新增成功");
		return "redirect:/"+Global.getAdminPath()+"/properties/create";
	}
	
//	@RequiresPermissions("properties:update")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String update(@PathVariable("id") String id, Model uiModel) {
		Properties properties = propertiesService.selectByPrimaryKey(id);
		uiModel.addAttribute("properties", properties);
		return root+"admin/modules/properties/properties_update.jsp";
	}

//	@RequiresPermissions("properties:update")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String update(Properties properties,RedirectAttributes redirectAttributes,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		propertiesService.update(properties);
		
		redirectAttributes.addFlashAttribute("msg", "修改成功");
		redirectAttributes.addFlashAttribute("properties", properties);
		return "redirect:/"+Global.getAdminPath()+"/properties/update/"+properties.getId();
	}

//	@RequiresPermissions("properties:show")
	@RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
	public String show(@PathVariable("id") String id, Model uiModel) {
		Properties properties = propertiesService.selectByPrimaryKey(id);
		
		uiModel.addAttribute("properties", properties);
		return root+"admin/modules/properties/properties_show.jsp";
	}

//	@RequiresPermissions("properties:view")
	@RequestMapping(value = { "", "list" })
	public String list(HttpServletRequest httpServletRequest) {
		return root+"admin/modules/properties/properties_list.jsp";
	}

//	@RequiresPermissions("properties:delete")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
	public String delete(@PathVariable("id") String id, Model uiModel) {
		propertiesService.deleteByPrimaryKey(id);
		uiModel.asMap().clear();
		return "redirect:/properties";
	}

	void populateEditForm(Model uiModel, Properties properties) {
		uiModel.addAttribute("properties", properties);
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

//	@RequiresPermissions("properties:view")
	@RequestMapping(value = "/select")
	@ResponseBody
	public Page select(@ModelAttribute Page page, @ModelAttribute Properties properties,Model uiModel,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		super.select(page, uiModel, httpServletRequest,
				httpServletResponse);
		PropertiesCriteria propertiesCriteria = new PropertiesCriteria();
		PropertiesCriteria.Criteria criteria = propertiesCriteria.createCriteria();
		propertiesCriteria.setPage(page);
		propertiesCriteria.setOrderByClause("id desc");
		if (null != properties.getId()  && !"".equals(properties.getId())) {
		  	criteria.andIdLike("%" + properties.getId() + "%");
		}
		if (null != properties.getName()  && !"".equals(properties.getName())) {
		  	criteria.andNameLike("%" + properties.getName() + "%");
		}
//		if (null != properties.getProCategory_id()  && !"".equals(properties.getProCategory_id())) {
//		  	criteria.andProCategory_idLike("%" + properties.getProCategory_id() + "%");
//		}
//		if (null != properties.getSortid()  && !"".equals(properties.getSortid())) {
//		  	criteria.andSortidLike("%" + properties.getSortid() + "%");
//		}
//		if (null != properties.getCreateDate()  && !"".equals(properties.getCreateDate())) {
//		  	criteria.andCreateDateLike("%" + properties.getCreateDate() + "%");
//		}
//		if (null != properties.getUpdateDate()  && !"".equals(properties.getUpdateDate())) {
//		  	criteria.andUpdateDateLike("%" + properties.getUpdateDate() + "%");
//		}
		if (null != properties.getStatus()  && !"".equals(properties.getStatus())) {
		  	criteria.andStatusLike("%" + properties.getStatus() + "%");
		}
		page = propertiesService.select(propertiesCriteria);
		return page;
	}
	
//	@RequiresPermissions("properties:delete")
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
		int result = propertiesService.deleteBatch(list);

		return result;
	}
	
	/**
	 * 全部导出Excel.
	 * @param properties
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @throws IOException
	 */
//	@RequiresPermissions("properties:view")
	@RequestMapping(value = "/exportExcel")
	public void exportExcel(@ModelAttribute Properties properties,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		httpServletResponse.setCharacterEncoding("UTF-8");
		String filename = new String("用户信息".getBytes("GBK"), "iso8859-1");

		List<Properties>list = propertiesService.selectAll();

		List<Map<String, Object>> maps = createExcelRecord(list);

		String columnNames[] = { 
			"Id",
			"Name",
			"ProCategory_id",
			"Sortid",
			"CreateDate",
			"UpdateDate",
			"Status"
		};// 列名
		String keys[] = { 
			"Id",
			"Name",
			"ProCategory_id",
			"Sortid",
			"CreateDate",
			"UpdateDate",
			"Status"
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

	private List<Map<String, Object>> createExcelRecord(List<Properties> list) {
		List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sheetName", "sheet1");
		listmap.add(map);
		Properties properties = null;
		for (int j = 0; j < list.size(); j++) {
			properties = list.get(j);
			Map<String, Object> mapValue = new HashMap<String, Object>();
				mapValue.put("Id",properties.getId());
				mapValue.put("Name",properties.getName());
//				mapValue.put("ProCategory_id",properties.getProCategory_id());
				mapValue.put("Sortid",properties.getSortid());
				mapValue.put("CreateDate",properties.getCreateDate());
				mapValue.put("UpdateDate",properties.getUpdateDate());
				mapValue.put("Status",properties.getStatus());
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
