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

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Workbook;
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
import com.jcin.cms.modules.syst.domain.UserOrganization;
import com.jcin.cms.modules.syst.domain.UserOrganizationCriteria;
import com.jcin.cms.modules.syst.service.IUserOrganizationService;
import com.jcin.cms.utils.Page;
import com.jcin.cms.utils.ExcelUtil;
import com.jcin.cms.web.BaseController;

@Controller
@RequestMapping(value = "admin/userOrganization")
public class UserOrganizationController extends BaseController<UserOrganization>{
	@Resource
	private IUserOrganizationService userOrganizationService;

//	@RequiresPermissions("userOrganization:create")
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(UserOrganization userOrganization, Model uiModel) {
		uiModel.addAttribute("userOrganization", userOrganization);
		return root+"admin/modules/userOrganization/userOrganization_create.jsp";
	}

//	@RequiresPermissions("userOrganization:create")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(UserOrganization userOrganization, RedirectAttributes redirectAttributes,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		userOrganizationService.insert(userOrganization);
		
		redirectAttributes.addFlashAttribute("userOrganization", userOrganization);
		redirectAttributes.addFlashAttribute("msg", "新增成功");
		return "redirect:/"+Global.getAdminPath()+"/userOrganization/create";
	}
	
//	@RequiresPermissions("userOrganization:update")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String update(@PathVariable("id") String id, Model uiModel) {
		UserOrganization userOrganization = userOrganizationService.selectByPrimaryKey(id);
		uiModel.addAttribute("userOrganization", userOrganization);
		return root+"admin/modules/userOrganization/userOrganization_update.jsp";
	}

//	@RequiresPermissions("userOrganization:update")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String update(UserOrganization userOrganization,RedirectAttributes redirectAttributes,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		userOrganizationService.update(userOrganization);
		
		redirectAttributes.addFlashAttribute("msg", "修改成功");
		redirectAttributes.addFlashAttribute("userOrganization", userOrganization);
		return "redirect:/"+Global.getAdminPath()+"/userOrganization/update/"+userOrganization.getId();
	}

//	@RequiresPermissions("userOrganization:show")
	@RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
	public String show(@PathVariable("id") String id, Model uiModel) {
		UserOrganization userOrganization = userOrganizationService.selectByPrimaryKey(id);
		
		uiModel.addAttribute("userOrganization", userOrganization);
		return root+"admin/modules/userOrganization/userOrganization_show.jsp";
	}

//	@RequiresPermissions("userOrganization:view")
	@RequestMapping(value = { "", "list" })
	public String list(HttpServletRequest httpServletRequest) {
		return root+"admin/modules/userOrganization/userOrganization_list.jsp";
	}

//	@RequiresPermissions("userOrganization:delete")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
	public String delete(@PathVariable("id") String id, Model uiModel) {
		userOrganizationService.deleteByPrimaryKey(id);
		uiModel.asMap().clear();
		return "redirect:/userOrganization";
	}

	void populateEditForm(Model uiModel, UserOrganization userOrganization) {
		uiModel.addAttribute("userOrganization", userOrganization);
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

//	@RequiresPermissions("userOrganization:view")
	@RequestMapping(value = "/select")
	@ResponseBody
	public Page select(@ModelAttribute Page page, @ModelAttribute UserOrganization userOrganization,Model uiModel,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		super.select(page, uiModel, httpServletRequest,
				httpServletResponse);
		UserOrganizationCriteria userOrganizationCriteria = new UserOrganizationCriteria();
		UserOrganizationCriteria.Criteria criteria = userOrganizationCriteria.createCriteria();
		userOrganizationCriteria.setPage(page);
		userOrganizationCriteria.setOrderByClause("id desc");
		if (null != userOrganization.getId()  && !"".equals(userOrganization.getId())) {
		  	criteria.andIdLike("%" + userOrganization.getId() + "%");
		}
		if (null != userOrganization.getUserId()  && !"".equals(userOrganization.getUserId())) {
		  	criteria.andUserIdLike("%" + userOrganization.getUserId() + "%");
		}
		if (null != userOrganization.getOrganizationId()  && !"".equals(userOrganization.getOrganizationId())) {
		  	criteria.andOrganizationIdLike("%" + userOrganization.getOrganizationId() + "%");
		}
		page = userOrganizationService.select(userOrganizationCriteria);
		return page;
	}
	
//	@RequiresPermissions("userOrganization:delete")
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
		int result = userOrganizationService.deleteBatch(list);

		return result;
	}
	
	/**
	 * 全部导出Excel.
	 * @param userOrganization
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @throws IOException
	 */
//	@RequiresPermissions("userOrganization:view")
	@RequestMapping(value = "/exportExcel")
	public void exportExcel(@ModelAttribute UserOrganization userOrganization,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		httpServletResponse.setCharacterEncoding("UTF-8");
		String filename = new String("用户信息".getBytes("GBK"), "iso8859-1");

		List<UserOrganization>list = userOrganizationService.selectAll();

		List<Map<String, Object>> maps = createExcelRecord(list);

		String columnNames[] = { 
			"Id",
			"UserId",
			"OrganizationId"
		};// 列名
		String keys[] = { 
			"Id",
			"UserId",
			"OrganizationId"
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

	private List<Map<String, Object>> createExcelRecord(List<UserOrganization> list) {
		List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sheetName", "sheet1");
		listmap.add(map);
		UserOrganization userOrganization = null;
		for (int j = 0; j < list.size(); j++) {
			userOrganization = list.get(j);
			Map<String, Object> mapValue = new HashMap<String, Object>();
				mapValue.put("Id",userOrganization.getId());
				mapValue.put("UserId",userOrganization.getUserId());
				mapValue.put("OrganizationId",userOrganization.getOrganizationId());
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
