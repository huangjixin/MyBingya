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
import com.jcin.cms.modules.syst.domain.Role;
import com.jcin.cms.modules.syst.domain.RoleCriteria;
import com.jcin.cms.modules.syst.domain.Role;
import com.jcin.cms.modules.syst.service.IRoleService;
import com.jcin.cms.modules.syst.service.IRoleService;
import com.jcin.cms.utils.ExcelUtil;
import com.jcin.cms.utils.Page;
import com.jcin.cms.web.BaseController;

@Controller
@RequestMapping(value = "${adminPath}/role")
public class RoleController extends BaseController<Role> {
	@Autowired
	private IRoleService roleService;

	@RequiresPermissions("role:create")
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(Role role, Model uiModel) {
		uiModel.addAttribute("role", role);
		List<Role> roles = roleService.selectAll();
		uiModel.addAttribute("roleList", roles);
		return "admin/modules/role/role_create";
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
		return "admin/modules/role/role_update";
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
		return "admin/modules/role/role_show";
	}

	@RequiresPermissions("role:view")
	@RequestMapping(value = { "", "list" })
	public String list(HttpServletRequest httpServletRequest) {
		return "admin/modules/role/role_list";
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