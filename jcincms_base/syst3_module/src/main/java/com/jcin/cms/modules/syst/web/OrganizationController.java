/**
 * 一句话描述该类：前端控制器，提供页面跳转，访问方法返回JSON<br/>
 * @author 黄记新 <br/>
 * @date 2015-4-29,10:52 <br/>
 *
 */
package com.jcin.cms.modules.syst.web;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
import com.jcin.cms.common.UserUtils;
import com.jcin.cms.modules.syst.domain.Organization;
import com.jcin.cms.modules.syst.domain.OrganizationCriteria;
import com.jcin.cms.modules.syst.domain.Resource;
import com.jcin.cms.modules.syst.domain.UserCriteria;
import com.jcin.cms.modules.syst.service.IOrganizationService;
import com.jcin.cms.modules.syst.service.IResourceService;
import com.jcin.cms.modules.syst.service.IUserService;
import com.jcin.cms.utils.Page;
import com.jcin.cms.web.BaseController;

@Controller
@RequestMapping(value = "${adminPath}/organization")
public class OrganizationController extends BaseController<Organization> {
	@Autowired
	private IOrganizationService organizationService;
	@Autowired
	private IResourceService resourceService;
	@Autowired
	private IUserService userService;

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
		/*
		 * List<com.jcin.cms.modules.syst.domain.Resource> resources = null; if
		 * (organizationId != null) { resources =
		 * resourceService.selectByOrgId(organizationId); }
		 */
		List<Organization> list = organizationService.getOrganizationTree(null);
		return list;
	}

	@RequestMapping(value = "/getResourceCheckboxTree")
	@ResponseBody
	public List<Resource> getResourceCheckboxTree(
			@RequestParam(value = "organizationId", required = false) String organizationId,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		List<com.jcin.cms.modules.syst.domain.Resource> resources = null;
		if (organizationId != null) {
			resources = resourceService.selectByOrgId(organizationId);
		}
		/*
		 * List<Resource> list = resourceService
		 * .getResourceCheckboxTree(resources);
		 */
		List<Resource> list = UserUtils.getResource(false);
		getResourceCheckboxTree(list, resources);
		return list;
	}
	
	@RequestMapping(value = "/refreshResourceCheckboxTree")
	@ResponseBody
	public void refreshResourceCheckboxTree(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		UserUtils.getResource(true);
	}

	private List<Resource> getResourceCheckboxTree(List<Resource> list,
			List<Resource> resources) {
		boolean inResources = false;
		for (Resource object : list) {
			if (null != resources) {
				for (int i = 0; i < resources.size(); i++) {
					Resource resource = resources.get(i);
					if (object.getId().equals(resource.getId())) {
						object.setChecked(true);
						inResources = true;
						break;
					}
				}
			}
			if (!inResources) {
				object.setChecked(false);
			}
			searialResource(object, resources);
		}

		return list;
	}

	@SuppressWarnings("rawtypes")
	private void searialResource(Resource resource, List<Resource> resources) {
		if (resource != null) {
			if (null != resources) {
				boolean inResources = false;
				for (int i = 0; i < resources.size(); i++) {
					Resource resource1 = resources.get(i);
					if (resource.getId().equals(resource1.getId())) {
						resource.setChecked(true);
						inResources = true;
						break;
					}
				}

				if (!inResources) {
					resource.setChecked(false);
				}
			}
			List<Resource> list = resource.getChildren();
			if (null != list && list.size() > 0) {
				for (Resource resource2 : list) {
					searialResource(resource2, resources);
				}
			}
		}
	}


	/**
	 * 根据组织ID查询用户。
	 * @param page
	 * @param organizationId
	 * @param uiModel
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @return
	 */
	@RequestMapping(value = "/getByOrgId")
	@ResponseBody
	public Page getByOrgId(@ModelAttribute Page page, @RequestParam(value = "organizationId",required=true) String organizationId,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		super.select(page, uiModel, httpServletRequest, httpServletResponse);
		UserCriteria userCriteria = new UserCriteria();
		UserCriteria.Criteria criteria = userCriteria.createCriteria();
		userCriteria.setPage(page);
		userCriteria.setOrgId(organizationId);
		page = userService.getByOrgId(userCriteria);
		return page;
	}
	
	/**
	 * 关联组织资源。
	 * 
	 * @param organizationId
	 * @param resourceIds
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @throws IOException
	 */
	@RequestMapping(value = "/connectOrganizationResource")
	@ResponseBody
	public void connectOrganizationResource(
			@RequestParam(value = "organizationId") String organizationId,
			@RequestParam(value = "resourceIds") String resourceIds,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		if (resourceIds == null) {
			resourceIds = "";
		}

		List<String> list = new ArrayList<String>();
		if(!"".equals(resourceIds)){
			String[] ids = resourceIds.split(",");
			for (String idstr : ids) {
				list.add(idstr);
			}
		}

		organizationService.connectOrgResource(organizationId, list);
	}
}
