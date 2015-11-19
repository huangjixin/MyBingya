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
import com.jcin.cms.modules.syst.domain.OrganizationResource;
import com.jcin.cms.modules.syst.domain.OrganizationResourceCriteria;
import com.jcin.cms.modules.syst.service.IOrganizationResourceService;
import com.jcin.cms.utils.Page;
import com.jcin.cms.utils.ExcelUtil;
import com.jcin.cms.web.BaseController;

@Controller
@RequestMapping(value = "${adminPath}/organizationResource")
public class OrganizationResourceController extends BaseController<OrganizationResource>{
	@Resource
	private IOrganizationResourceService organizationResourceService;

//	@RequiresPermissions("organizationResource:create")
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(OrganizationResource organizationResource, Model uiModel) {
		uiModel.addAttribute("organizationResource", organizationResource);
		return "admin/modules/organizationResource/organizationResource_create";
	}

//	@RequiresPermissions("organizationResource:create")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(OrganizationResource organizationResource, RedirectAttributes redirectAttributes,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		organizationResourceService.insert(organizationResource);
		
		redirectAttributes.addFlashAttribute("organizationResource", organizationResource);
		redirectAttributes.addFlashAttribute("msg", "新增成功");
		return "redirect:/"+Global.getAdminPath()+"/organizationResource/create";
	}
	
//	@RequiresPermissions("organizationResource:update")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String update(@PathVariable("id") String id, Model uiModel) {
		OrganizationResource organizationResource = organizationResourceService.selectByPrimaryKey(id);
		uiModel.addAttribute("organizationResource", organizationResource);
		return "admin/modules/organizationResource/organizationResource_update";
	}

//	@RequiresPermissions("organizationResource:update")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String update(OrganizationResource organizationResource,RedirectAttributes redirectAttributes,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		organizationResourceService.update(organizationResource);
		
		redirectAttributes.addFlashAttribute("msg", "修改成功");
		redirectAttributes.addFlashAttribute("organizationResource", organizationResource);
		return "redirect:/"+Global.getAdminPath()+"/organizationResource/update/"+organizationResource.getId();
	}

//	@RequiresPermissions("organizationResource:show")
	@RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
	public String show(@PathVariable("id") String id, Model uiModel) {
		OrganizationResource organizationResource = organizationResourceService.selectByPrimaryKey(id);
		
		uiModel.addAttribute("organizationResource", organizationResource);
		return "admin/modules/organizationResource/organizationResource_show";
	}

//	@RequiresPermissions("organizationResource:view")
	@RequestMapping(value = { "", "list" })
	public String list(HttpServletRequest httpServletRequest) {
		return "admin/modules/organizationResource/organizationResource_list";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
	public String delete(@PathVariable("id") String id, Model uiModel) {
		organizationResourceService.deleteByPrimaryKey(id);
		uiModel.asMap().clear();
		return "redirect:/organizationResource";
	}

	void populateEditForm(Model uiModel, OrganizationResource organizationResource) {
		uiModel.addAttribute("organizationResource", organizationResource);
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
	public Page select(@ModelAttribute Page page, @ModelAttribute OrganizationResource organizationResource,Model uiModel,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		super.select(page, uiModel, httpServletRequest,
				httpServletResponse);
		OrganizationResourceCriteria organizationResourceCriteria = new OrganizationResourceCriteria();
		OrganizationResourceCriteria.Criteria criteria = organizationResourceCriteria.createCriteria();
		organizationResourceCriteria.setPage(page);
		organizationResourceCriteria.setOrderByClause("id desc");
		if (null != organizationResource.getId()  && !"".equals(organizationResource.getId())) {
		  	criteria.andIdLike("%" + organizationResource.getId() + "%");
		}
		if (null != organizationResource.getOrganizationId()  && !"".equals(organizationResource.getOrganizationId())) {
		  	criteria.andOrganizationIdLike("%" + organizationResource.getOrganizationId() + "%");
		}
		if (null != organizationResource.getResourceId()  && !"".equals(organizationResource.getResourceId())) {
		  	criteria.andResourceIdLike("%" + organizationResource.getResourceId() + "%");
		}
		page = organizationResourceService.select(organizationResourceCriteria);
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
		int result = organizationResourceService.deleteBatch(list);

		return result;
	}
	
	/**
	 * 全部导出Excel.
	 * @param organizationResource
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @throws IOException
	 */
	@RequestMapping(value = "/exportExcel")
	public void exportExcel(@ModelAttribute OrganizationResource organizationResource,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		httpServletResponse.setCharacterEncoding("UTF-8");
		String filename = new String("用户信息".getBytes("GBK"), "iso8859-1");

		List<OrganizationResource>list = organizationResourceService.selectAll();

		List<Map<String, Object>> maps = createExcelRecord(list);

		String columnNames[] = { 
			"Id",
			"OrganizationId",
			"ResourceId"
		};// 列名
		String keys[] = { 
			"Id",
			"OrganizationId",
			"ResourceId"
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

	private List<Map<String, Object>> createExcelRecord(List<OrganizationResource> list) {
		List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sheetName", "sheet1");
		listmap.add(map);
		OrganizationResource organizationResource = null;
		for (int j = 0; j < list.size(); j++) {
			organizationResource = list.get(j);
			Map<String, Object> mapValue = new HashMap<String, Object>();
				mapValue.put("Id",organizationResource.getId());
				mapValue.put("OrganizationId",organizationResource.getOrganizationId());
				mapValue.put("ResourceId",organizationResource.getResourceId());
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
