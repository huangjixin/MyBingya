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
import com.jcin.cms.common.PasswordHelper;
import com.jcin.cms.common.UserUtils;
import com.jcin.cms.modules.syst.domain.Organization;
import com.jcin.cms.modules.syst.domain.Role;
import com.jcin.cms.modules.syst.domain.User;
import com.jcin.cms.modules.syst.domain.UserCriteria;
import com.jcin.cms.modules.syst.service.IOrganizationService;
import com.jcin.cms.modules.syst.service.IRoleService;
import com.jcin.cms.modules.syst.service.IUserService;
import com.jcin.cms.utils.ExcelUtil;
import com.jcin.cms.utils.Page;
import com.jcin.cms.web.BaseController;

@Controller
@RequestMapping(value = "admin/user")
public class UserController extends BaseController<User> {
	@Autowired
	private IUserService userService;
	@Autowired
	private IRoleService roleService;
	@Autowired
	private IOrganizationService organizationService;

	@RequiresPermissions("user:create")
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(User user, Model uiModel) {
		uiModel.addAttribute("user", user);
		List<Role> roles = roleService.selectAll();
		uiModel.addAttribute("roleList", roles);
		return root+"admin/modules/user/user_create.jsp";
	}

	@RequiresPermissions("user:create")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(User user,
			@RequestParam(required = false) String roleId,
			@RequestParam(required = false) String organizationId,
			RedirectAttributes redirectAttributes, Model uiModel,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		userService.insert(user);
		if (null != roleId && !"".equals(roleId)) { // 关联用户角色
			userService.connectUserRole(user.getId(), roleId);
			redirectAttributes.addFlashAttribute("roleId", roleId);
		}
		if (null != organizationId && !"".equals(organizationId)) { // 关联组织
			userService.connectUserOrganization(user.getId(), organizationId);
			redirectAttributes.addFlashAttribute("organizationId",
					organizationId);
		}
		redirectAttributes.addFlashAttribute("user", user);
		redirectAttributes.addFlashAttribute("msg", "新增成功");
		return "redirect:/" + Global.getAdminPath() + "/user/create";
	}

	@RequiresPermissions("user:update")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String update(@PathVariable("id") String id, Model uiModel) {
		User user = userService.selectByPrimaryKey(id);
		uiModel.addAttribute("user", user);

		List<Role> roles = roleService.selectAll();
		uiModel.addAttribute("roleList", roles);

		List<Role> list = roleService.selectByUsername(user.getUsername());
		if (null != list && list.size() > 0) {
			uiModel.addAttribute("roleId", list.get(0).getId());
		}

		List<Organization> organizations = organizationService.selectAll();
		uiModel.addAttribute("organizationList", organizations);

		List<Organization> list2 = organizationService.selectByUsername(user
				.getUsername());
		if (null != list2 && list2.size() > 0) {
			uiModel.addAttribute("organizationId", list2.get(0).getId());
		}

		return root+"admin/modules/user/user_update.jsp";
	}

	@RequiresPermissions("user:update")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String update(User user,
			@RequestParam(required = false) String roleId,
			@RequestParam(required = false) String organizationId,
			RedirectAttributes redirectAttributes, Model uiModel,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		user.setUpdateBy(UserUtils.getUsername());
		user.setUpdateDate(new Date());
		userService.update(user);
		if("".equals(roleId)){
			roleId = null;
		}
		if("".equals(organizationId)){
			organizationId = null;
		}
		List<Role> list = roleService.selectByUsername(user.getUsername());
		if (null != list && list.size() > 0) {//更新
			if (!list.get(0).getId().equals(roleId)) {
				userService.updateUserRole(user.getId(), list.get(0).getId(),
						roleId);
			}
			uiModel.addAttribute("roleId", roleId);
		}else{
			userService.updateUserRole(user.getId(), null,
					roleId);
		}
		
		List<Organization> organizations = organizationService.selectByUsername(user.getUsername());
		if (null != organizations && organizations.size() > 0) {
			if (!organizations.get(0).getId().equals(organizationId)) {
				userService.updateUserOrganization(user.getId(), organizations.get(0).getId(),
						organizationId);
			}
			uiModel.addAttribute("organizationId", organizationId);
		}else{
			userService.updateUserOrganization(user.getId(), null,
					organizationId);
		}

		redirectAttributes.addFlashAttribute("msg", "修改成功");
		redirectAttributes.addFlashAttribute("user", user);
		return "redirect:/" + Global.getAdminPath() + "/user/update/"
				+ user.getId();
	}

	@RequiresPermissions("user:show")
	@RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
	public String show(@PathVariable("id") String id, Model uiModel) {
		User user = userService.selectByPrimaryKey(id);
		List<Role> roles = roleService.selectAll();
		uiModel.addAttribute("roleList", roles);

		List<Role> list = roleService.selectByUsername(user.getUsername());
		if (null != list && list.size() > 0) {
			uiModel.addAttribute("roleId", list.get(0).getId());
		}

		uiModel.addAttribute("user", user);
		return root+"admin/modules/user/user_show.jsp";
	}

	@RequiresPermissions("user:update")
	@RequestMapping(value = "/changePassword", method = RequestMethod.GET)
	public String changePassword(Model uiModel,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		User user = UserUtils.getUser();
		uiModel.addAttribute("user", user);
		return root+"admin/modules/user/changePassword.jsp";
	}

	/**
	 * 密码更改。
	 * @param user
	 * @param newPassword
	 * @param uiModel
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @return
	 */
	@RequiresPermissions("user:update")
	@RequestMapping(value = "/changePassword", method = RequestMethod.POST)
	public String changePassword(
			User user,
			@RequestParam(value = "newPassword", required = true) String newPassword,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		User user2 = UserUtils.getUser();
		if (!user2.getPassword().equals(PasswordHelper.encryptPassword(user.getPassword()))) {
			uiModel.addAttribute("msg", "旧密码输入有误");
			return root+"admin/modules/user/changePassword";
		}
		User user3 = new User();
		newPassword = PasswordHelper.encryptPassword(newPassword);
		user3.setPassword(newPassword);
		user3.setId(user2.getId());
		userService.updatePassword(user3);
		return "redirect:/" + Global.getAdminPath() + "/logout";
	}

	@RequiresPermissions("user:view")
	@RequestMapping(value = { "", "list" })
	public String list(HttpServletRequest httpServletRequest) {
		return root+"admin/modules/user/user_list.jsp";
	}

	/**
	 * 跳转到产品信息页面。
	 * @param httpServletRequest
	 * @return
	 */
	@RequestMapping(value = { "productInfo" })
	public String productInfo(HttpServletRequest httpServletRequest) {
		return root+"admin/modules/user/product_info.jsp";
	}

	@RequestMapping(value = "test", method = RequestMethod.GET)
	@ResponseBody
	public List<User> test(Model uiModel,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		List<User> list = userService.selectAll();
		return list;
	}

	@RequestMapping(value = "/select")
	@ResponseBody
	public Page select(@ModelAttribute Page page, @ModelAttribute User user,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		super.select(page, uiModel, httpServletRequest, httpServletResponse);
		UserCriteria userCriteria = new UserCriteria();
		UserCriteria.Criteria criteria = userCriteria.createCriteria();
		userCriteria.setPage(page);
		userCriteria.setOrderByClause("id desc");
		if (null != user.getId() && !"".equals(user.getId())) {
			criteria.andIdLike("%" + user.getId() + "%");
		}
		if (null != user.getUsername() && !"".equals(user.getUsername())) {
			criteria.andUsernameLike("%" + user.getUsername() + "%");
		}
		if (null != user.getPassword() && !"".equals(user.getPassword())) {
			criteria.andPasswordLike("%" + user.getPassword() + "%");
		}
		page = userService.select(userCriteria);
		if(page.getRows()!=null && page.getRows().size()>0){
			List<User>users = page.getRows();
			for (User user2 : users) {
				List<Role>roles = roleService.selectByUsername(user2.getUsername());
				if(roles!=null && roles.size()>0){
					user2.setRoleName(roles.get(0).getName());
				}
			}
		}
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
		int result = userService.deleteBatch(list);

		return result;
	}

	/**
	 * 全部导出Excel.
	 * 
	 * @param user
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @throws IOException
	 */
	@RequestMapping(value = "/exportExcel")
	public void exportExcel(@ModelAttribute User user,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		httpServletResponse.setCharacterEncoding("UTF-8");
		String filename = new String("User".getBytes("GBK"), "iso8859-1");

		List<User> list = userService.selectAll();

		List<Map<String, Object>> maps = createExcelRecord(list);

		String columnNames[] = { "Id", "Username", "Password", "Status",
				"Description", "Enabled", "CreateDate", "UpdateDate", "Ip",
				"Telephone", "Salt", "Locked", "Email", "Sex", "Address",
				"UserGroup_id" };// 列名
		String keys[] = { "Id", "Username", "Password", "CreateDate",
				"UpdateDate" };// map中的key
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

	private List<Map<String, Object>> createExcelRecord(List<User> list) {
		List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sheetName", "sheet1");
		listmap.add(map);
		User user = null;
		for (int j = 0; j < list.size(); j++) {
			user = list.get(j);
			Map<String, Object> mapValue = new HashMap<String, Object>();
			mapValue.put("Id", user.getId());
			mapValue.put("Username", user.getUsername());
			mapValue.put("Password", user.getPassword());
			mapValue.put("CreateDate", user.getCreateDate());
			mapValue.put("UpdateDate", user.getUpdateDate());
			listmap.add(mapValue);
		}
		return listmap;
	}
}