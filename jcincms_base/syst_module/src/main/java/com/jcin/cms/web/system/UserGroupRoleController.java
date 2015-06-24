/**
 * 一句话描述该类：前端控制器，提供页面跳转，访问方法返回JSON<br/>
 * @author 黄记新 <br/>
 * @date 2015-4-29,10:52 <br/>
 *
 */
package com.jcin.cms.web.system;

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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

import com.jcin.cms.domain.system.UserGroupRole;
import com.jcin.cms.domain.system.UserGroupRoleCriteria;
import com.jcin.cms.service.system.IUserGroupRoleService;
import com.jcin.cms.utils.Page;
import com.jcin.cms.utils.ExcelUtil;
import com.jcin.cms.web.BaseController;

@Controller
@RequestMapping(value = "/userGroupRole")
public class UserGroupRoleController extends BaseController<UserGroupRole>{
	@Resource
	private IUserGroupRoleService userGroupRoleService;

	@RequestMapping(value="createForm",method = RequestMethod.POST)
	public String create(@Valid UserGroupRole userGroupRole,BindingResult result,Model uiModel,
			HttpServletRequest httpServletRequest) {
		if (result.hasErrors()) {
            populateEditForm(uiModel, userGroupRole);
            return "view/userGroupRole/userGroupRole_create";
        }
			userGroupRoleService.insert(userGroupRole);
		populateEditForm(uiModel, userGroupRole);
		return "redirect:/userGroupRole/new";
		//return "redirect:/userGroupRole/"
		//		+ encodeUrlPathSegment(userGroupRole.getId().toString(),
		//				httpServletRequest);
	}

	@RequestMapping(value="new", produces = "text/html")
	public String createForm(Model uiModel) {
		populateEditForm(uiModel, new UserGroupRole());
		return "view/userGroupRole/userGroupRole_create";
	}

	@RequestMapping(value = "/{id}", produces = "text/html")
	public String show(@PathVariable("id") String id, Model uiModel) {
		UserGroupRole userGroupRole = userGroupRoleService.selectByPrimaryKey(id);
		uiModel.addAttribute("userGroupRole", userGroupRole);
		uiModel.addAttribute("itemId", id);
		return "view/userGroupRole/userGroupRole_show";
	}

	@RequestMapping(produces = "text/html")
	public String list(HttpServletRequest httpServletRequest) {
		return "view/userGroupRole/userGroupRole_list";
	}

	@RequestMapping(value="updateForm")
	public String update(@Valid UserGroupRole userGroupRole,BindingResult result, Model uiModel,
			HttpServletRequest httpServletRequest) {
		uiModel.asMap().clear();
		userGroupRoleService.update(userGroupRole);
		populateEditForm(uiModel, userGroupRole);
		return "redirect:edit/"
				+ encodeUrlPathSegment(userGroupRole.getId().toString(),
						httpServletRequest);
	}

	@RequestMapping(value = "/edit/{id}")
	public String updateForm(@PathVariable("id") String id, Model uiModel) {
		UserGroupRole userGroupRole = userGroupRoleService.selectByPrimaryKey(id);
		populateEditForm(uiModel, userGroupRole);
		return "view/userGroupRole/userGroupRole_update";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
	public String delete(@PathVariable("id") String id, Model uiModel) {
		userGroupRoleService.deleteByPrimaryKey(id);
		uiModel.asMap().clear();
		return "redirect:/userGroupRole";
	}

	void populateEditForm(Model uiModel, UserGroupRole userGroupRole) {
		uiModel.addAttribute("userGroupRole", userGroupRole);
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

	// _/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
	// _/_/_/_/_/_/ 下面将产生JSON格式的返回值
	// _/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
	@RequestMapping(value = "/select")
	@ResponseBody
	public Page select(@ModelAttribute Page page, @ModelAttribute UserGroupRole userGroupRole,Model uiModel,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		super.select(page, uiModel, httpServletRequest,
				httpServletResponse);
		UserGroupRoleCriteria userGroupRoleCriteria = new UserGroupRoleCriteria();
		UserGroupRoleCriteria.Criteria criteria = userGroupRoleCriteria.createCriteria();
		userGroupRoleCriteria.setPage(page);
		userGroupRoleCriteria.setOrderByClause("id desc");
		if (null != userGroupRole.getId()  && !"".equals(userGroupRole.getId())) {
		  	criteria.andIdLike("%" + userGroupRole.getId() + "%");
		}
		if (null != userGroupRole.getRoleId()  && !"".equals(userGroupRole.getRoleId())) {
		  	criteria.andRoleIdLike("%" + userGroupRole.getRoleId() + "%");
		}
		page = userGroupRoleService.select(userGroupRoleCriteria);
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
		int result = userGroupRoleService.deleteBatch(list);

		return result;
	}
	
	@RequestMapping(value = "/create")
	@ResponseBody
	public String create(@ModelAttribute UserGroupRole userGroupRole,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		userGroupRoleService.insert(userGroupRole);
		String id = userGroupRole.getId();
		return id;
	}
	
	@RequestMapping(value = "/update")
	@ResponseBody
	public String update(@ModelAttribute UserGroupRole userGroupRole,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		userGroupRoleService.update(userGroupRole);
		String id = userGroupRole.getId();
		return id;
	}
	
	/**
	 * 全部导出Excel.
	 * @param userGroupRole
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @throws IOException
	 */
	@RequestMapping(value = "/exportExcel")
	public void exportExcel(@ModelAttribute UserGroupRole userGroupRole,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		httpServletResponse.setCharacterEncoding("UTF-8");
		String filename = new String("用户信息".getBytes("GBK"), "iso8859-1");

		List<UserGroupRole>list = userGroupRoleService.selectAll();

		List<Map<String, Object>> maps = createExcelRecord(list);

		String columnNames[] = { 
			"Id",
			"RoleId",
			"UserGroup_id"
		};// 列名
		String keys[] = { 
			"Id",
			"RoleId",
			"UserGroup_id"
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

	private List<Map<String, Object>> createExcelRecord(List<UserGroupRole> list) {
		List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sheetName", "sheet1");
		listmap.add(map);
		UserGroupRole userGroupRole = null;
		for (int j = 0; j < list.size(); j++) {
			userGroupRole = list.get(j);
			Map<String, Object> mapValue = new HashMap<String, Object>();
				mapValue.put("Id",userGroupRole.getId());
				mapValue.put("RoleId",userGroupRole.getRoleId());
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
