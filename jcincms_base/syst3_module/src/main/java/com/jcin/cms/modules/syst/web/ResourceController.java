/**
 * 一句话描述该类：用户管理前端控制器，提供页面跳转，访问方法返回JSON<br/>
 * @author 黄记新 <br/>
 * @date 2015-4-29,10:52 <br/>
 *
 */
package com.jcin.cms.modules.syst.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
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

import com.jcin.cms.common.Global;
import com.jcin.cms.common.UserUtils;
import com.jcin.cms.modules.syst.domain.Resource;
import com.jcin.cms.modules.syst.domain.ResourceCriteria;
import com.jcin.cms.modules.syst.domain.Role;
import com.jcin.cms.modules.syst.service.IResourceService;
import com.jcin.cms.modules.syst.service.IRoleService;
import com.jcin.cms.modules.syst.service.IUserService;
import com.jcin.cms.utils.Page;
import com.jcin.cms.web.BaseController;

@Controller
@RequestMapping(value = "${adminPath}/resource")
public class ResourceController extends BaseController<Resource> {
	@Autowired
	private IResourceService resourceService;
	@Autowired
	private IRoleService roleService;
	@Autowired
	private IUserService userService;

	@RequiresPermissions("resource:create")
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(Resource resource, Model uiModel) {
		uiModel.addAttribute("resource", resource);
		return "admin/modules/resource/resource_create";
	}

	@RequiresPermissions("resource:create")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(Resource resource,
			@RequestParam(required = false) String roleId,
			RedirectAttributes redirectAttributes, Model uiModel,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		
		resourceService.insert(resource);
		redirectAttributes.addFlashAttribute("resource", resource);
		redirectAttributes.addFlashAttribute("msg", "新增成功");
		return "redirect:/" + Global.getAdminPath() + "/resource/create";
	}

	@RequiresPermissions("resource:update")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String update(@PathVariable("id") String id, Model uiModel) {
		Resource resource = resourceService.selectByPrimaryKey(id);
		uiModel.addAttribute("resource", resource);

		return "admin/modules/resource/resource_update";
	}

	@RequiresPermissions("resource:update")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String update(Resource resource,
			@RequestParam(required = false) String roleId,
			RedirectAttributes redirectAttributes, Model uiModel,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		if (resource.getId().equals(resource.getParentId())) {
			redirectAttributes.addFlashAttribute("resource", resource);
			redirectAttributes.addFlashAttribute("msg", "父亲节点不应该为本身");
			return "redirect:/" + Global.getAdminPath() + "/resource/update/"
					+ resource.getId();
		}

		resourceService.update(resource);

		redirectAttributes.addFlashAttribute("msg", "修改成功");
		redirectAttributes.addFlashAttribute("resource", resource);
		UserUtils.getResource(true);
		return "redirect:/" + Global.getAdminPath() + "/resource/update/"
				+ resource.getId();
	}

	@RequiresPermissions("resource:show")
	@RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
	public String show(@PathVariable("id") String id, Model uiModel) {
		Resource resource = resourceService.selectByPrimaryKey(id);
		List<Role> roles = roleService.selectAll();
		uiModel.addAttribute("roleList", roles);

		/*
		 * List<Role>list =
		 * roleService.selectByResourcename(resource.getResourcename()); if(null
		 * != list && list.size()>0){ uiModel.addAttribute("roleId",
		 * list.get(0).getId()); }
		 */

		uiModel.addAttribute("resource", resource);
		return "admin/modules/resource/resource_show";
	}

	@RequiresPermissions("resource:view")
	@RequestMapping(value = { "", "list" })
	public String list(HttpServletRequest httpServletRequest) {
		return "admin/modules/resource/resource_list";
	}

	@RequestMapping(value = "test", method = RequestMethod.GET)
	@ResponseBody
	public List<Resource> test(Model uiModel,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		List<Resource> list = resourceService.selectAll();
		return list;
	}

	@RequestMapping(value = "/select")
	@ResponseBody
	public Page select(@ModelAttribute Page page,
			@ModelAttribute Resource resource, Model uiModel,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		super.select(page, uiModel, httpServletRequest, httpServletResponse);
		ResourceCriteria resourceCriteria = new ResourceCriteria();
		ResourceCriteria.Criteria criteria = resourceCriteria.createCriteria();
		resourceCriteria.setPage(page);
		resourceCriteria.setOrderByClause("id desc");
		if (null != resource.getId() && !"".equals(resource.getId())) {
			criteria.andIdLike("%" + resource.getId() + "%");
		}
		if (null != resource.getName() && !"".equals(resource.getName())) {
			criteria.andNameLike("%" + resource.getName() + "%");
		}
		page = resourceService.select(resourceCriteria);
		return page;
	}

	@RequiresPermissions("resource:delete")
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
		int result = resourceService.deleteBatch(list);
		return result;
	}

	@RequestMapping(value = "/getResourceTree")
	@ResponseBody
	public List<Resource> getResourceTree(@ModelAttribute Resource resource,
			@RequestParam(required = false) boolean menuOnly,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		List<Resource> list = resourceService.getResourceTree(null, menuOnly);
		return list;
	}

	@RequestMapping(value = "/getMenu")
	@ResponseBody
	public List<Resource> getMenu(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		Subject currentUser = SecurityUtils.getSubject();
		Object object = currentUser.getPrincipal();
		Set<String> set = null;
		if (object != null) {
			set = userService.findPermissions(object.toString());
		}
		List<Resource> list = resourceService.getResourceTree(set, true);
		return list;
	}

}