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

import com.jcin.cms.domain.system.RoleAuthorization;
import com.jcin.cms.domain.system.RoleAuthorizationCriteria;
import com.jcin.cms.service.system.IRoleAuthorizationService;
import com.jcin.cms.utils.Page;
import com.jcin.cms.utils.ExcelUtil;
import com.jcin.cms.web.BaseController;

@Controller
@RequestMapping(value = "/roleAuthorization")
public class RoleAuthorizationController extends BaseController<RoleAuthorization>{
	@Resource
	private IRoleAuthorizationService roleAuthorizationService;

	@RequestMapping(value="createForm",method = RequestMethod.POST)
	public String create(@Valid RoleAuthorization roleAuthorization,BindingResult result,Model uiModel,
			HttpServletRequest httpServletRequest) {
		if (result.hasErrors()) {
            populateEditForm(uiModel, roleAuthorization);
            return "view/roleAuthorization/roleAuthorization_create";
        }
			roleAuthorizationService.insert(roleAuthorization);
		populateEditForm(uiModel, roleAuthorization);
		return "redirect:/roleAuthorization/new";
		//return "redirect:/roleAuthorization/"
		//		+ encodeUrlPathSegment(roleAuthorization.getId().toString(),
		//				httpServletRequest);
	}

	@RequestMapping(value="new", produces = "text/html")
	public String createForm(Model uiModel) {
		populateEditForm(uiModel, new RoleAuthorization());
		return "view/roleAuthorization/roleAuthorization_create";
	}

	@RequestMapping(value = "/{id}", produces = "text/html")
	public String show(@PathVariable("id") String id, Model uiModel) {
		RoleAuthorization roleAuthorization = roleAuthorizationService.selectByPrimaryKey(id);
		uiModel.addAttribute("roleAuthorization", roleAuthorization);
		uiModel.addAttribute("itemId", id);
		return "view/roleAuthorization/roleAuthorization_show";
	}

	@RequestMapping(produces = "text/html")
	public String list(HttpServletRequest httpServletRequest) {
		return "view/roleAuthorization/roleAuthorization_list";
	}

	@RequestMapping(value="updateForm")
	public String update(@Valid RoleAuthorization roleAuthorization,BindingResult result, Model uiModel,
			HttpServletRequest httpServletRequest) {
		uiModel.asMap().clear();
		roleAuthorizationService.update(roleAuthorization);
		populateEditForm(uiModel, roleAuthorization);
		return "redirect:edit/"
				+ encodeUrlPathSegment(roleAuthorization.getId().toString(),
						httpServletRequest);
	}

	@RequestMapping(value = "/edit/{id}")
	public String updateForm(@PathVariable("id") String id, Model uiModel) {
		RoleAuthorization roleAuthorization = roleAuthorizationService.selectByPrimaryKey(id);
		populateEditForm(uiModel, roleAuthorization);
		return "view/roleAuthorization/roleAuthorization_update";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
	public String delete(@PathVariable("id") String id, Model uiModel) {
		roleAuthorizationService.deleteByPrimaryKey(id);
		uiModel.asMap().clear();
		return "redirect:/roleAuthorization";
	}

	void populateEditForm(Model uiModel, RoleAuthorization roleAuthorization) {
		uiModel.addAttribute("roleAuthorization", roleAuthorization);
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
	public Page select(@ModelAttribute Page page, @ModelAttribute RoleAuthorization roleAuthorization,Model uiModel,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		super.select(page, uiModel, httpServletRequest,
				httpServletResponse);
		RoleAuthorizationCriteria roleAuthorizationCriteria = new RoleAuthorizationCriteria();
		RoleAuthorizationCriteria.Criteria criteria = roleAuthorizationCriteria.createCriteria();
		roleAuthorizationCriteria.setPage(page);
		roleAuthorizationCriteria.setOrderByClause("id desc");
		if (null != roleAuthorization.getId()  && !"".equals(roleAuthorization.getId())) {
		  	criteria.andIdLike("%" + roleAuthorization.getId() + "%");
		}
		if (null != roleAuthorization.getRoleId()  && !"".equals(roleAuthorization.getRoleId())) {
		  	criteria.andRoleIdLike("%" + roleAuthorization.getRoleId() + "%");
		}
		if (null != roleAuthorization.getAuthorizationId()  && !"".equals(roleAuthorization.getAuthorizationId())) {
		  	criteria.andAuthorizationIdLike("%" + roleAuthorization.getAuthorizationId() + "%");
		}
		page = roleAuthorizationService.select(roleAuthorizationCriteria);
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
		int result = roleAuthorizationService.deleteBatch(list);

		return result;
	}
	
	@RequestMapping(value = "/create")
	@ResponseBody
	public String create(@ModelAttribute RoleAuthorization roleAuthorization,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		roleAuthorizationService.insert(roleAuthorization);
		String id = roleAuthorization.getId();
		return id;
	}
	
	@RequestMapping(value = "/update")
	@ResponseBody
	public String update(@ModelAttribute RoleAuthorization roleAuthorization,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		roleAuthorizationService.update(roleAuthorization);
		String id = roleAuthorization.getId();
		return id;
	}
	
	/**
	 * 全部导出Excel.
	 * @param roleAuthorization
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @throws IOException
	 */
	@RequestMapping(value = "/exportExcel")
	public void exportExcel(@ModelAttribute RoleAuthorization roleAuthorization,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		httpServletResponse.setCharacterEncoding("UTF-8");
		String filename = new String("用户信息".getBytes("GBK"), "iso8859-1");

		List<RoleAuthorization>list = roleAuthorizationService.selectAll();

		List<Map<String, Object>> maps = createExcelRecord(list);

		String columnNames[] = { 
			"Id",
			"RoleId",
			"AuthorizationId"
		};// 列名
		String keys[] = { 
			"Id",
			"RoleId",
			"AuthorizationId"
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

	private List<Map<String, Object>> createExcelRecord(List<RoleAuthorization> list) {
		List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sheetName", "sheet1");
		listmap.add(map);
		RoleAuthorization roleAuthorization = null;
		for (int j = 0; j < list.size(); j++) {
			roleAuthorization = list.get(j);
			Map<String, Object> mapValue = new HashMap<String, Object>();
				mapValue.put("Id",roleAuthorization.getId());
				mapValue.put("RoleId",roleAuthorization.getRoleId());
				mapValue.put("AuthorizationId",roleAuthorization.getAuthorizationId());
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
