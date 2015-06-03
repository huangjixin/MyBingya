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

import com.jcin.cms.domain.system.UserRole;
import com.jcin.cms.domain.system.UserRoleCriteria;
import com.jcin.cms.service.system.IUserRoleService;
import com.jcin.cms.utils.Page;
import com.jcin.cms.utils.ExcelUtil;
import com.jcin.cms.web.BaseController;

@Controller
@RequestMapping(value = "/userRole")
public class UserRoleController extends BaseController<UserRole>{
	@Resource
	private IUserRoleService userRoleService;

	@RequestMapping(value="createForm",method = RequestMethod.POST)
	public String create(@Valid UserRole userRole,BindingResult result,Model uiModel,
			HttpServletRequest httpServletRequest) {
		if (result.hasErrors()) {
            populateEditForm(uiModel, userRole);
            return "view/userRole/userRole_create";
        }
			userRoleService.insert(userRole);
		populateEditForm(uiModel, userRole);
		return "redirect:/userRole/new";
		//return "redirect:/userRole/"
		//		+ encodeUrlPathSegment(userRole.getId().toString(),
		//				httpServletRequest);
	}

	@RequestMapping(value="new", produces = "text/html")
	public String createForm(Model uiModel) {
		populateEditForm(uiModel, new UserRole());
		return "view/userRole/userRole_create";
	}

	@RequestMapping(value = "/{id}", produces = "text/html")
	public String show(@PathVariable("id") String id, Model uiModel) {
		UserRole userRole = userRoleService.selectByPrimaryKey(id);
		uiModel.addAttribute("userRole", userRole);
		uiModel.addAttribute("itemId", id);
		return "view/userRole/userRole_show";
	}

	@RequestMapping(produces = "text/html")
	public String list(HttpServletRequest httpServletRequest) {
		return "view/userRole/userRole_list";
	}

	@RequestMapping(value="updateForm")
	public String update(@Valid UserRole userRole,BindingResult result, Model uiModel,
			HttpServletRequest httpServletRequest) {
		uiModel.asMap().clear();
		userRoleService.update(userRole);
		populateEditForm(uiModel, userRole);
		return "redirect:edit/"
				+ encodeUrlPathSegment(userRole.getId().toString(),
						httpServletRequest);
	}

	@RequestMapping(value = "/edit/{id}")
	public String updateForm(@PathVariable("id") String id, Model uiModel) {
		UserRole userRole = userRoleService.selectByPrimaryKey(id);
		populateEditForm(uiModel, userRole);
		return "view/userRole/userRole_update";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
	public String delete(@PathVariable("id") String id, Model uiModel) {
		userRoleService.deleteByPrimaryKey(id);
		uiModel.asMap().clear();
		return "redirect:/userRole";
	}

	void populateEditForm(Model uiModel, UserRole userRole) {
		uiModel.addAttribute("userRole", userRole);
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
	public Page select(@ModelAttribute Page page, @ModelAttribute UserRole userRole,Model uiModel,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		super.select(page, uiModel, httpServletRequest,
				httpServletResponse);
		UserRoleCriteria userRoleCriteria = new UserRoleCriteria();
		UserRoleCriteria.Criteria criteria = userRoleCriteria.createCriteria();
		userRoleCriteria.setPage(page);
		userRoleCriteria.setOrderByClause("id desc");
		if (null != userRole.getId()  && !"".equals(userRole.getId())) {
		  	criteria.andIdLike("%" + userRole.getId() + "%");
		}
		if (null != userRole.getUserId()  && !"".equals(userRole.getUserId())) {
		  	criteria.andUserIdLike("%" + userRole.getUserId() + "%");
		}
		if (null != userRole.getRoleId()  && !"".equals(userRole.getRoleId())) {
		  	criteria.andRoleIdLike("%" + userRole.getRoleId() + "%");
		}
		page = userRoleService.select(userRoleCriteria);
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
		int result = userRoleService.deleteBatch(list);

		return result;
	}
	
	@RequestMapping(value = "/create")
	@ResponseBody
	public String create(@ModelAttribute UserRole userRole,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		userRoleService.insert(userRole);
		String id = userRole.getId();
		return id;
	}
	
	@RequestMapping(value = "/update")
	@ResponseBody
	public String update(@ModelAttribute UserRole userRole,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		userRoleService.update(userRole);
		String id = userRole.getId();
		return id;
	}
	
	/**
	 * 全部导出Excel.
	 * @param userRole
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @throws IOException
	 */
	@RequestMapping(value = "/exportExcel")
	public void exportExcel(@ModelAttribute UserRole userRole,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		httpServletResponse.setCharacterEncoding("UTF-8");
		String filename = new String("用户信息".getBytes("GBK"), "iso8859-1");

		List<UserRole>list = userRoleService.selectAll();

		List<Map<String, Object>> maps = createExcelRecord(list);

		String columnNames[] = { 
			"Id",
			"UserId",
			"RoleId"
		};// 列名
		String keys[] = { 
			"Id",
			"UserId",
			"RoleId"
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

	private List<Map<String, Object>> createExcelRecord(List<UserRole> list) {
		List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sheetName", "sheet1");
		listmap.add(map);
		UserRole userRole = null;
		for (int j = 0; j < list.size(); j++) {
			userRole = list.get(j);
			Map<String, Object> mapValue = new HashMap<String, Object>();
				mapValue.put("Id",userRole.getId());
				mapValue.put("UserId",userRole.getUserId());
				mapValue.put("RoleId",userRole.getRoleId());
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
