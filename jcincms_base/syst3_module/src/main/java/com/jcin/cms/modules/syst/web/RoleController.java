/**
 * 一句话描述该类：用户管理前端控制器，提供页面跳转，访问方法返回JSON<br/>
 * @author 黄记新 <br/>
 * @date 2015-4-29,10:52 <br/>
 *
 */
package com.jcin.cms.modules.syst.web;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.shiro.authz.annotation.RequiresPermissions;
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
import com.jcin.cms.modules.syst.domain.Role;
import com.jcin.cms.modules.syst.domain.RoleCriteria;
import com.jcin.cms.modules.syst.domain.UserCriteria;
import com.jcin.cms.modules.syst.service.IResourceService;
import com.jcin.cms.modules.syst.service.IRoleService;
import com.jcin.cms.modules.syst.service.IUserService;
import com.jcin.cms.utils.ExcelUtil;
import com.jcin.cms.utils.Page;
import com.jcin.cms.web.BaseController;

@Controller
@RequestMapping(value = "admin/role")
public class RoleController extends BaseController<Role> {
	@Autowired
	private IRoleService roleService;
	@Autowired
	private IResourceService resourceService;
	@Autowired
	private IUserService userService;

	@RequiresPermissions("role:create")
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(Role role, Model uiModel) {
		uiModel.addAttribute("role", role);
		List<Role> roles = roleService.selectAll();
		uiModel.addAttribute("roleList", roles);
		return root+"admin/modules/role/role_create.jsp";
	}

	@RequiresPermissions("role:create")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(Role role,
			@RequestParam(required = false) String roleId,
			RedirectAttributes redirectAttributes, Model uiModel,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		roleService.insert(role);
		/*
		 * if (null != roleId && !"".equals(roleId)) { // 关联用户角色
		 * roleService.connectRoleRole(role.getId(), roleId);
		 * redirectAttributes.addFlashAttribute("roleId", roleId); }
		 */
		redirectAttributes.addFlashAttribute("role", role);
		redirectAttributes.addFlashAttribute("msg", "新增成功");
		return "redirect:/" + Global.getAdminPath() + "/role/create";
	}

	@RequiresPermissions("role:update")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String update(@PathVariable("id") String id, Model uiModel) {
		Role role = roleService.selectByPrimaryKey(id);
		uiModel.addAttribute("role", role);

		List<Role> roles = roleService.selectAll();
		uiModel.addAttribute("roleList", roles);

		/*
		 * List<Role> list = roleService.selectByRolename(role.getRolename());
		 * if (null != list && list.size() > 0) { uiModel.addAttribute("roleId",
		 * list.get(0).getId()); }
		 */
		return root+"admin/modules/role/role_update.jsp";
	}

	@RequiresPermissions("role:update")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String update(Role role,
			@RequestParam(required = false) String roleId,
			RedirectAttributes redirectAttributes, Model uiModel,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		roleService.update(role);

		/*
		 * List<Role> list = roleService.selectByRolename(role.getRolename());
		 * if (null != list && list.size() > 0) { if
		 * (!list.get(0).getId().equals(roleId)) {
		 * roleService.updateRoleRole(role.getId(), list.get(0).getId(),
		 * roleId); } uiModel.addAttribute("roleId", roleId); }
		 */

		redirectAttributes.addFlashAttribute("msg", "修改成功");
		redirectAttributes.addFlashAttribute("role", role);
		return "redirect:/" + Global.getAdminPath() + "/role/update/"
				+ role.getId();
	}

	@RequiresPermissions("role:show")
	@RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
	public String show(@PathVariable("id") String id, Model uiModel) {
		/*
		 * Role role = roleService.selectByPrimaryKey(id); List<Role> roles =
		 * roleService.selectAll(); uiModel.addAttribute("roleList", roles);
		 * 
		 * List<Role> list = roleService.selectByRolename(role.getName()); if
		 * (null != list && list.size() > 0) { uiModel.addAttribute("roleId",
		 * list.get(0).getId()); }
		 * 
		 * uiModel.addAttribute("role", role);
		 */
		return root+"admin/modules/role/role_show.jsp";
	}

	@RequiresPermissions("role:view")
	@RequestMapping(value = { "", "list" })
	public String list(HttpServletRequest httpServletRequest) {
		return root+"admin/modules/role/role_list.jsp";
	}

	@RequestMapping(value = "test", method = RequestMethod.GET)
	@ResponseBody
	public List<Role> test(Model uiModel,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		List<Role> list = roleService.selectAll();
		return list;
	}

	@RequestMapping(value = "/select")
	@ResponseBody
	public Page select(@ModelAttribute Page page, @ModelAttribute Role role,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		super.select(page, uiModel, httpServletRequest, httpServletResponse);
		RoleCriteria roleCriteria = new RoleCriteria();
		RoleCriteria.Criteria criteria = roleCriteria.createCriteria();
		roleCriteria.setPage(page);
		roleCriteria.setOrderByClause("id desc");
		if (null != role.getId() && !"".equals(role.getId())) {
			criteria.andIdLike("%" + role.getId() + "%");
		}
		if (null != role.getName() && !"".equals(role.getName())) {
			criteria.andNameLike("%" + role.getName() + "%");
		}
		page = roleService.select(roleCriteria);
		return page;
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
	@RequestMapping(value = "/getByRoleId")
	@ResponseBody
	public Page getByOrgId(@ModelAttribute Page page, @RequestParam(value = "roleId",required=true) String roleId,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		super.select(page, uiModel, httpServletRequest, httpServletResponse);
		UserCriteria userCriteria = new UserCriteria();
		UserCriteria.Criteria criteria = userCriteria.createCriteria();
		userCriteria.setPage(page);
		userCriteria.setRoleId(roleId);
		page = userService.getByRoleId(userCriteria);
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
		int result = roleService.deleteBatch(list);

		return result;
	}
	
	@RequestMapping(value = "/getResourceCheckboxTree")
	@ResponseBody
	public List<Resource> getResourceCheckboxTree(@RequestParam(value = "roleId",required=false) String roleId,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		List<Resource>resources= null;
		if(roleId!=null){
			resources = resourceService.selectByRoleId(roleId);
		}
//		List<Resource> list = resourceService.getResourceCheckboxTree(resources);
		List<Resource> list = UserUtils.getResource(false);
		getResourceCheckboxTree(list, resources);
		return list;
	}
	
	private List<Resource> getResourceCheckboxTree(List<Resource> list,List<Resource> resources) {
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
	
	@RequestMapping(value = "/connectRoleResource")
	@ResponseBody
	public void connectRoleResource(@RequestParam(value = "roleId") String roleId,@RequestParam(value = "resourceIds") String resourceIds,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		if(resourceIds==null){
			resourceIds = "";
		}
		
		List<String> list = new ArrayList<String>();
		if(!"".equals(resourceIds)){
			String[] ids = resourceIds.split(",");
			for (String idstr : ids) {
				list.add(idstr);
			}
		}
		
		roleService.connectRoleResource(roleId, list);
	}
	
	/**
	 * 全部导出Excel.
	 * 
	 * @param role
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @throws IOException
	 */
	@RequestMapping(value = "/exportExcel")
	public void exportExcel(@ModelAttribute Role role,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		httpServletResponse.setCharacterEncoding("UTF-8");
		String filename = new String("Role".getBytes("GBK"), "iso8859-1");

		List<Role> list = roleService.selectAll();

		List<Map<String, Object>> maps = createExcelRecord(list);

		String columnNames[] = { "Id", "Rolename" };// 列名
		String keys[] = { "Id", "Name" };// map中的key
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

	private List<Map<String, Object>> createExcelRecord(List<Role> list) {
		List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sheetName", "sheet1");
		listmap.add(map);
		Role role = null;
		for (int j = 0; j < list.size(); j++) {
			role = list.get(j);
			Map<String, Object> mapValue = new HashMap<String, Object>();
			mapValue.put("Id", role.getId());
			mapValue.put("Name", role.getName());
			listmap.add(mapValue);
		}
		return listmap;
	}
}