/**
 * 一句话描述该类：前端控制器，提供页面跳转，访问方法返回JSON<br/>
 * @author 黄记新 <br/>
 * @date 2015-4-29,10:52 <br/>
 *
 */
package com.jcin.cms.modules.syst.web;

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
import com.jcin.cms.modules.syst.domain.Organization;
import com.jcin.cms.modules.syst.domain.OrganizationCriteria;
import com.jcin.cms.modules.syst.service.IOrganizationService;
import com.jcin.cms.utils.Page;
import com.jcin.cms.utils.ExcelUtil;
import com.jcin.cms.web.BaseController;

@Controller
@RequestMapping(value = "${adminPath}/organization")
public class OrganizationController extends BaseController<Organization>{
	@Resource
	private IOrganizationService organizationService;

//	@RequiresPermissions("organization:create")
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(Organization organization, Model uiModel) {
		uiModel.addAttribute("organization", organization);
		return "admin/modules/organization/organization_create";
	}

//	@RequiresPermissions("organization:create")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(Organization organization, RedirectAttributes redirectAttributes,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		organizationService.insert(organization);
		
		redirectAttributes.addFlashAttribute("organization", organization);
		redirectAttributes.addFlashAttribute("msg", "新增成功");
		return "redirect:/"+Global.getAdminPath()+"/organization/create";
	}
	
//	@RequiresPermissions("organization:update")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String update(@PathVariable("id") String id, Model uiModel) {
		Organization organization = organizationService.selectByPrimaryKey(id);
		uiModel.addAttribute("organization", organization);
		return "admin/modules/organization/organization_update";
	}

//	@RequiresPermissions("organization:update")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String update(Organization organization,RedirectAttributes redirectAttributes,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		
		organizationService.update(organization);
		
		redirectAttributes.addFlashAttribute("msg", "修改成功");
		redirectAttributes.addFlashAttribute("organization", organization);
		return "redirect:/"+Global.getAdminPath()+"/organization/update/"+organization.getId();
	}

//	@RequiresPermissions("organization:show")
	@RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
	public String show(@PathVariable("id") String id, Model uiModel) {
		Organization organization = organizationService.selectByPrimaryKey(id);
		
		uiModel.addAttribute("organization", organization);
		return "admin/modules/organization/organization_show";
	}

//	@RequiresPermissions("organization:view")
	@RequestMapping(value = { "", "list" })
	public String list(HttpServletRequest httpServletRequest) {
		return "admin/modules/organization/organization_list";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
	public String delete(@PathVariable("id") String id, Model uiModel) {
		organizationService.deleteByPrimaryKey(id);
		uiModel.asMap().clear();
		return "redirect:/organization";
	}

	void populateEditForm(Model uiModel, Organization organization) {
		uiModel.addAttribute("organization", organization);
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

	@RequestMapping(value = "/select")
	@ResponseBody
	public Page select(@ModelAttribute Page page, @ModelAttribute Organization organization,Model uiModel,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		super.select(page, uiModel, httpServletRequest,
				httpServletResponse);
		OrganizationCriteria organizationCriteria = new OrganizationCriteria();
		OrganizationCriteria.Criteria criteria = organizationCriteria.createCriteria();
		organizationCriteria.setPage(page);
		organizationCriteria.setOrderByClause("id desc");
		if (null != organization.getId()  && !"".equals(organization.getId())) {
		  	criteria.andIdLike("%" + organization.getId() + "%");
		}
		if (null != organization.getName()  && !"".equals(organization.getName())) {
		  	criteria.andNameLike("%" + organization.getName() + "%");
		}
		if (null != organization.getParentId()  && !"".equals(organization.getParentId())) {
		  	criteria.andParentIdLike("%" + organization.getParentId() + "%");
		}
		if (null != organization.getParentIds()  && !"".equals(organization.getParentIds())) {
		  	criteria.andParentIdsLike("%" + organization.getParentIds() + "%");
		}
		
		page = organizationService.select(organizationCriteria);
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
		int result = organizationService.deleteBatch(list);

		return result;
	}
	
	/**
	 * 全部导出Excel.
	 * @param organization
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @throws IOException
	 */
	@RequestMapping(value = "/exportExcel")
	public void exportExcel(@ModelAttribute Organization organization,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		httpServletResponse.setCharacterEncoding("UTF-8");
		String filename = new String("用户信息".getBytes("GBK"), "iso8859-1");

		List<Organization>list = organizationService.selectAll();

		List<Map<String, Object>> maps = createExcelRecord(list);

		String columnNames[] = { 
			"Id",
			"Name",
			"ParentId",
			"ParentIds",
			"Available",
			"CreateDate",
			"UpdateDate"
		};// 列名
		String keys[] = { 
			"Id",
			"Name",
			"ParentId",
			"ParentIds",
			"Available",
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

	private List<Map<String, Object>> createExcelRecord(List<Organization> list) {
		List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sheetName", "sheet1");
		listmap.add(map);
		Organization organization = null;
		for (int j = 0; j < list.size(); j++) {
			organization = list.get(j);
			Map<String, Object> mapValue = new HashMap<String, Object>();
				mapValue.put("Id",organization.getId());
				mapValue.put("Name",organization.getName());
				mapValue.put("ParentId",organization.getParentId());
				mapValue.put("ParentIds",organization.getParentIds());
				mapValue.put("Available",organization.getAvailable());
				mapValue.put("CreateDate",organization.getCreateDate());
				mapValue.put("UpdateDate",organization.getUpdateDate());
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
