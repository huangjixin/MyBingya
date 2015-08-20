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

import com.jcin.cms.domain.system.Menu;
import com.jcin.cms.domain.system.UserGroup;
import com.jcin.cms.domain.system.UserGroupCriteria;
import com.jcin.cms.service.system.IUserGroupService;
import com.jcin.cms.utils.Page;
import com.jcin.cms.utils.ExcelUtil;
import com.jcin.cms.web.BaseController;

@Controller
@RequestMapping(value = "/userGroup")
public class UserGroupController extends BaseController<UserGroup>{
	@Resource
	private IUserGroupService userGroupService;

	@RequestMapping(value="createForm",method = RequestMethod.POST)
	public String create(@Valid UserGroup userGroup,BindingResult result,Model uiModel,
			HttpServletRequest httpServletRequest) {
		if (result.hasErrors()) {
            populateEditForm(uiModel, userGroup);
            return "view/userGroup/userGroup_create";
        }
			userGroupService.insert(userGroup);
		populateEditForm(uiModel, userGroup);
		return "redirect:/userGroup/new";
		//return "redirect:/userGroup/"
		//		+ encodeUrlPathSegment(userGroup.getId().toString(),
		//				httpServletRequest);
	}

	@RequestMapping(value="new", produces = "text/html")
	public String createForm(Model uiModel) {
		populateEditForm(uiModel, new UserGroup());
		return "view/userGroup/userGroup_create";
	}

	@RequestMapping(value = "/{id}", produces = "text/html")
	public String show(@PathVariable("id") String id, Model uiModel) {
		UserGroup userGroup = userGroupService.selectByPrimaryKey(id);
		uiModel.addAttribute("userGroup", userGroup);
		uiModel.addAttribute("itemId", id);
		return "view/userGroup/userGroup_show";
	}

	@RequestMapping(produces = "text/html")
	public String list(HttpServletRequest httpServletRequest) {
		return "view/userGroup/userGroup_list";
	}

	@RequestMapping(value="updateForm")
	public String update(@Valid UserGroup userGroup,BindingResult result, Model uiModel,
			HttpServletRequest httpServletRequest) {
		uiModel.asMap().clear();
		userGroupService.update(userGroup);
		populateEditForm(uiModel, userGroup);
		return "redirect:edit/"
				+ encodeUrlPathSegment(userGroup.getId().toString(),
						httpServletRequest);
	}

	@RequestMapping(value = "/edit/{id}")
	public String updateForm(@PathVariable("id") String id, Model uiModel) {
		UserGroup userGroup = userGroupService.selectByPrimaryKey(id);
		populateEditForm(uiModel, userGroup);
		return "view/userGroup/userGroup_update";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
	public String delete(@PathVariable("id") String id, Model uiModel) {
		userGroupService.deleteByPrimaryKey(id);
		uiModel.asMap().clear();
		return "redirect:/userGroup";
	}

	void populateEditForm(Model uiModel, UserGroup userGroup) {
		uiModel.addAttribute("userGroup", userGroup);
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
	public Page select(@ModelAttribute Page page, @ModelAttribute UserGroup userGroup,Model uiModel,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		super.select(page, uiModel, httpServletRequest,
				httpServletResponse);
		UserGroupCriteria userGroupCriteria = new UserGroupCriteria();
		UserGroupCriteria.Criteria criteria = userGroupCriteria.createCriteria();
		userGroupCriteria.setPage(page);
		userGroupCriteria.setOrderByClause("id desc");
		if (null != userGroup.getId()  && !"".equals(userGroup.getId())) {
		  	criteria.andIdLike("%" + userGroup.getId() + "%");
		}
		if (null != userGroup.getGroupname()  && !"".equals(userGroup.getGroupname())) {
		  	criteria.andGroupnameLike("%" + userGroup.getGroupname() + "%");
		}
		/*if (null != userGroup.getStatus()  && !"".equals(userGroup.getStatus())) {
		  	criteria.andStatusLike("%" + userGroup.getStatus() + "%");
		}
		if (null != userGroup.getDescription()  && !"".equals(userGroup.getDescription())) {
		  	criteria.andDescriptionLike("%" + userGroup.getDescription() + "%");
		}
		if (null != userGroup.getEnabled()  && !"".equals(userGroup.getEnabled())) {
		  	criteria.andEnabledLike("%" + userGroup.getEnabled() + "%");
		}
		if (null != userGroup.getCreateDate()  && !"".equals(userGroup.getCreateDate())) {
		  	criteria.andCreateDateLike("%" + userGroup.getCreateDate() + "%");
		}
		if (null != userGroup.getUpdateDate()  && !"".equals(userGroup.getUpdateDate())) {
		  	criteria.andUpdateDateLike("%" + userGroup.getUpdateDate() + "%");
		}
		if (null != userGroup.getLocked()  && !"".equals(userGroup.getLocked())) {
		  	criteria.andLockedLike("%" + userGroup.getLocked() + "%");
		}*/
		page = userGroupService.select(userGroupCriteria);
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
		int result = userGroupService.deleteBatch(list);

		return result;
	}
	
	@RequestMapping(value = "/create")
	@ResponseBody
	public String create(@ModelAttribute UserGroup userGroup,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		userGroupService.insert(userGroup);
		String id = userGroup.getId();
		return id;
	}
	
	@RequestMapping(value = "/update")
	@ResponseBody
	public String update(@ModelAttribute UserGroup userGroup,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		userGroupService.update(userGroup);
		String id = userGroup.getId();
		return id;
	}

	@RequestMapping(value = "/getUserGroup")
	@ResponseBody
	public List<UserGroup> getUserGroup(
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		List<UserGroup> list = userGroupService.selectAll();
		return list;
	}
	
	/**
	 * 全部导出Excel.
	 * @param userGroup
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @throws IOException
	 */
	@RequestMapping(value = "/exportExcel")
	public void exportExcel(@ModelAttribute UserGroup userGroup,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		httpServletResponse.setCharacterEncoding("UTF-8");
		String filename = new String("用户组信息".getBytes("GBK"), "iso8859-1");

		List<UserGroup>list = userGroupService.selectAll();

		List<Map<String, Object>> maps = createExcelRecord(list);

		String columnNames[] = { 
			"Id",
			"Groupname",
			"Status",
			"Description",
			"Enabled",
			"CreateDate",
			"UpdateDate",
			"Locked"
		};// 列名
		String keys[] = { 
			"Id",
			"Groupname",
			"Status",
			"Description",
			"Enabled",
			"CreateDate",
			"UpdateDate",
			"Locked"
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

	private List<Map<String, Object>> createExcelRecord(List<UserGroup> list) {
		List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sheetName", "sheet1");
		listmap.add(map);
		UserGroup userGroup = null;
		for (int j = 0; j < list.size(); j++) {
			userGroup = list.get(j);
			Map<String, Object> mapValue = new HashMap<String, Object>();
				mapValue.put("Id",userGroup.getId());
				mapValue.put("Groupname",userGroup.getGroupname());
				mapValue.put("Status",userGroup.getStatus());
				mapValue.put("Description",userGroup.getDescription());
				mapValue.put("Enabled",userGroup.getEnabled());
				mapValue.put("CreateDate",userGroup.getCreateDate());
				mapValue.put("UpdateDate",userGroup.getUpdateDate());
				mapValue.put("Locked",userGroup.getLocked());
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
