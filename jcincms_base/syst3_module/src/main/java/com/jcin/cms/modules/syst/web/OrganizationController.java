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
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
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
import com.jcin.cms.modules.syst.service.IResourceService;
import com.jcin.cms.utils.Page;
import com.jcin.cms.utils.ExcelUtil;
import com.jcin.cms.web.BaseController;

@Controller
@RequestMapping(value = "${adminPath}/organization")
public class OrganizationController extends BaseController<Organization> {
	@Resource
	private IOrganizationService organizationService;
	@Resource
	private IResourceService resourceService;

	// @RequiresPermissions("organization:create")
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(Organization organization, Model uiModel) {
		uiModel.addAttribute("organization", organization);
		return "admin/modules/organization/organization_create";
	}

	// @RequiresPermissions("organization:create")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(Organization organization,
			RedirectAttributes redirectAttributes, Model uiModel,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		organizationService.insert(organization);

		redirectAttributes.addFlashAttribute("organization", organization);
		redirectAttributes.addFlashAttribute("msg", "新增成功");
		return "redirect:/" + Global.getAdminPath() + "/organization/create";
	}

	// @RequiresPermissions("organization:update")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String update(@PathVariable("id") String id, Model uiModel) {
		Organization organization = organizationService.selectByPrimaryKey(id);
		uiModel.addAttribute("organization", organization);
		return "admin/modules/organization/organization_update";
	}

	// @RequiresPermissions("organization:update")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String update(Organization organization,
			RedirectAttributes redirectAttributes, Model uiModel,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {

		organizationService.update(organization);

		redirectAttributes.addFlashAttribute("msg", "修改成功");
		redirectAttributes.addFlashAttribute("organization", organization);
		return "redirect:/" + Global.getAdminPath() + "/organization/update/"
				+ organization.getId();
	}

	// @RequiresPermissions("organization:show")
	@RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
	public String show(@PathVariable("id") String id, Model uiModel) {
		Organization organization = organizationService.selectByPrimaryKey(id);

		uiModel.addAttribute("organization", organization);
		return "admin/modules/organization/organization_show";
	}

	// @RequiresPermissions("organization:view")
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

	// @RequiresPermissions("organization:view")
	@RequestMapping(value = "/select")
	@ResponseBody
	public Page select(@ModelAttribute Page page,
			@ModelAttribute Organization organization, Model uiModel,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		super.select(page, uiModel, httpServletRequest, httpServletResponse);
		OrganizationCriteria organizationCriteria = new OrganizationCriteria();
		OrganizationCriteria.Criteria criteria = organizationCriteria
				.createCriteria();
		organizationCriteria.setPage(page);
		organizationCriteria.setOrderByClause("id desc");
		if (null != organization.getId() && !"".equals(organization.getId())) {
			criteria.andIdLike("%" + organization.getId() + "%");
		}
		if (null != organization.getName()
				&& !"".equals(organization.getName())) {
			criteria.andNameLike("%" + organization.getName() + "%");
		}
		if (null != organization.getParentId()
				&& !"".equals(organization.getParentId())) {
			criteria.andParentIdLike("%" + organization.getParentId() + "%");
		}
		if (null != organization.getParentIds()
				&& !"".equals(organization.getParentIds())) {
			criteria.andParentIdsLike("%" + organization.getParentIds() + "%");
		}

		page = organizationService.select(organizationCriteria);
		return page;
	}

	// @RequiresPermissions("organization:update")
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

	@RequestMapping(value = "/getOrganizationTree")
	@ResponseBody
	public List<Organization> getOrganizationTree(
			@RequestParam(value = "organizationId", required = false) String organizationId,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		/*List<com.jcin.cms.modules.syst.domain.Resource> resources = null;
		if (organizationId != null) {
			resources = resourceService.selectByOrgId(organizationId);
		}*/
		List<Organization> list = organizationService.getOrganizationTree(null);
		return list;
	}
	
	@RequestMapping(value = "/getResourceCheckboxTree")
	@ResponseBody
	public List<com.jcin.cms.modules.syst.domain.Resource> getResourceCheckboxTree(
			@RequestParam(value = "organizationId", required = false) String organizationId,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		List<com.jcin.cms.modules.syst.domain.Resource> resources = null;
		if (organizationId != null) {
			resources = resourceService.selectByOrgId(organizationId);
		}
		List<com.jcin.cms.modules.syst.domain.Resource> list = resourceService
				.getResourceCheckboxTree(resources);
		return list;
	}
	

	@RequestMapping(value = "/connectOrganizationResource")
	@ResponseBody
	public void connectOrganizationResource(@RequestParam(value = "organizationId") String organizationId,@RequestParam(value = "resourceIds") String resourceIds,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		if(resourceIds==null){
			resourceIds = "";
		}
		
		String[] ids = resourceIds.split(",");
		List<String> list = new ArrayList<String>();
		for (String idstr : ids) {
			list.add(idstr);
		}
		
		organizationService.connectOrgResource(organizationId, list);
	}
}
