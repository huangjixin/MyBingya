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
import com.jcin.cms.modules.syst.domain.RoleResource;
import com.jcin.cms.modules.syst.domain.RoleResourceCriteria;
import com.jcin.cms.modules.syst.service.IRoleResourceService;
import com.jcin.cms.utils.Page;
import com.jcin.cms.utils.ExcelUtil;
import com.jcin.cms.web.BaseController;

@Controller
@RequestMapping(value = "admin/roleResource")
public class RoleResourceController extends BaseController<RoleResource>{
	@Resource
	private IRoleResourceService roleResourceService;

	@RequiresPermissions("roleResource:create")
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(RoleResource roleResource, Model uiModel) {
		uiModel.addAttribute("roleResource", roleResource);
		return "admin/modules/roleResource/roleResource_create.jsp";
	}

	@RequiresPermissions("roleResource:create")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(RoleResource roleResource, RedirectAttributes redirectAttributes,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		roleResourceService.insert(roleResource);
		
		redirectAttributes.addFlashAttribute("roleResource", roleResource);
		redirectAttributes.addFlashAttribute("msg", "新增成功");
		return "redirect:/"+Global.getAdminPath()+"/roleResource/create";
	}
	
	@RequiresPermissions("roleResource:update")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String update(@PathVariable("id") String id, Model uiModel) {
		RoleResource roleResource = roleResourceService.selectByPrimaryKey(id);
		uiModel.addAttribute("roleResource", roleResource);
		return "admin/modules/roleResource/roleResource_update.jsp";
	}

	@RequiresPermissions("roleResource:update")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String update(RoleResource roleResource,RedirectAttributes redirectAttributes,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		roleResourceService.update(roleResource);
		
		redirectAttributes.addFlashAttribute("msg", "修改成功");
		redirectAttributes.addFlashAttribute("roleResource", roleResource);
		return "redirect:/"+Global.getAdminPath()+"/roleResource/update/"+roleResource.getId();
	}

	@RequiresPermissions("roleResource:show")
	@RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
	public String show(@PathVariable("id") String id, Model uiModel) {
		RoleResource roleResource = roleResourceService.selectByPrimaryKey(id);
		
		uiModel.addAttribute("roleResource", roleResource);
		return "admin/modules/roleResource/roleResource_show.jsp";
	}

	@RequiresPermissions("roleResource:view")
	@RequestMapping(value = { "", "list" })
	public String list(HttpServletRequest httpServletRequest) {
		return "admin/modules/roleResource/roleResource_list.jsp";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
	public String delete(@PathVariable("id") String id, Model uiModel) {
		roleResourceService.deleteByPrimaryKey(id);
		uiModel.asMap().clear();
		return "redirect:/roleResource";
	}

	void populateEditForm(Model uiModel, RoleResource roleResource) {
		uiModel.addAttribute("roleResource", roleResource);
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
	public Page select(@ModelAttribute Page page, @ModelAttribute RoleResource roleResource,Model uiModel,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		super.select(page, uiModel, httpServletRequest,
				httpServletResponse);
		RoleResourceCriteria roleResourceCriteria = new RoleResourceCriteria();
		RoleResourceCriteria.Criteria criteria = roleResourceCriteria.createCriteria();
		roleResourceCriteria.setPage(page);
		roleResourceCriteria.setOrderByClause("id desc");
		if (null != roleResource.getId()  && !"".equals(roleResource.getId())) {
		  	criteria.andIdLike("%" + roleResource.getId() + "%");
		}
		if (null != roleResource.getRoleId()  && !"".equals(roleResource.getRoleId())) {
		  	criteria.andRoleIdLike("%" + roleResource.getRoleId() + "%");
		}
		if (null != roleResource.getResourceId()  && !"".equals(roleResource.getResourceId())) {
		  	criteria.andResourceIdLike("%" + roleResource.getResourceId() + "%");
		}
		page = roleResourceService.select(roleResourceCriteria);
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
		int result = roleResourceService.deleteBatch(list);

		return result;
	}
	
	/**
	 * 全部导出Excel.
	 * @param roleResource
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @throws IOException
	 */
	@RequestMapping(value = "/exportExcel")
	public void exportExcel(@ModelAttribute RoleResource roleResource,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		httpServletResponse.setCharacterEncoding("UTF-8");
		String filename = new String("用户信息".getBytes("GBK"), "iso8859-1");

		List<RoleResource>list = roleResourceService.selectAll();

		List<Map<String, Object>> maps = createExcelRecord(list);

		String columnNames[] = { 
			"Id",
			"RoleId",
			"ResourceId"
		};// 列名
		String keys[] = { 
			"Id",
			"RoleId",
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

	private List<Map<String, Object>> createExcelRecord(List<RoleResource> list) {
		List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sheetName", "sheet1");
		listmap.add(map);
		RoleResource roleResource = null;
		for (int j = 0; j < list.size(); j++) {
			roleResource = list.get(j);
			Map<String, Object> mapValue = new HashMap<String, Object>();
				mapValue.put("Id",roleResource.getId());
				mapValue.put("RoleId",roleResource.getRoleId());
				mapValue.put("ResourceId",roleResource.getResourceId());
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
