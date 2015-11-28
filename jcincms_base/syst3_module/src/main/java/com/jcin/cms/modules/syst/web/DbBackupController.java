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
import org.apache.shiro.authz.annotation.RequiresPermissions;
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
import com.jcin.cms.modules.syst.domain.DbBackup;
import com.jcin.cms.modules.syst.domain.DbBackupCriteria;
import com.jcin.cms.modules.syst.service.IDbBackupService;
import com.jcin.cms.utils.ExcelUtil;
import com.jcin.cms.utils.Page;
import com.jcin.cms.web.BaseController;

@Controller
@RequestMapping(value = "admin/dbBackup")
public class DbBackupController extends BaseController<DbBackup>{
	@Resource
	private IDbBackupService dbBackupService;

	@RequiresPermissions("dbBackup:create")
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(DbBackup dbBackup, Model uiModel) {
		uiModel.addAttribute("dbBackup", dbBackup);
		return root+"admin/modules/dbBackup/dbBackup_create.jsp";
	}

	@RequiresPermissions("dbBackup:create")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(DbBackup dbBackup, RedirectAttributes redirectAttributes,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		dbBackupService.insert(dbBackup);
		
		redirectAttributes.addFlashAttribute("dbBackup", dbBackup);
		redirectAttributes.addFlashAttribute("msg", "新增成功");
		return "redirect:/"+Global.getAdminPath()+"/dbBackup/create";
	}
	
	@RequiresPermissions("dbBackup:update")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String update(@PathVariable("id") String id, Model uiModel) {
		DbBackup dbBackup = dbBackupService.selectByPrimaryKey(id);
		uiModel.addAttribute("dbBackup", dbBackup);
		return root+"admin/modules/dbBackup/dbBackup_update.jsp";
	}

	@RequiresPermissions("dbBackup:update")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String update(DbBackup dbBackup,RedirectAttributes redirectAttributes,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		dbBackupService.update(dbBackup);
		
		redirectAttributes.addFlashAttribute("msg", "修改成功");
		redirectAttributes.addFlashAttribute("dbBackup", dbBackup);
		return "redirect:/"+Global.getAdminPath()+"/dbBackup/update/"+dbBackup.getId();
	}

	@RequiresPermissions("dbBackup:show")
	@RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
	public String show(@PathVariable("id") String id, Model uiModel) {
		DbBackup dbBackup = dbBackupService.selectByPrimaryKey(id);
		
		uiModel.addAttribute("dbBackup", dbBackup);
		return root+"admin/modules/dbBackup/dbBackup_show.jsp";
	}

	@RequiresPermissions("dbBackup:view")
	@RequestMapping(value = { "", "list" })
	public String list(HttpServletRequest httpServletRequest) {
		return root+"admin/modules/dbBackup/dbBackup_list.jsp";
	}

	@RequiresPermissions("dbBackup:delete")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
	public String delete(@PathVariable("id") String id, Model uiModel) {
		dbBackupService.deleteByPrimaryKey(id);
		uiModel.asMap().clear();
		return "redirect:/dbBackup";
	}

	void populateEditForm(Model uiModel, DbBackup dbBackup) {
		uiModel.addAttribute("dbBackup", dbBackup);
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

	@RequiresPermissions("dbBackup:view")
	@RequestMapping(value = "/select")
	@ResponseBody
	public Page select(@ModelAttribute Page page, @ModelAttribute DbBackup dbBackup,Model uiModel,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		super.select(page, uiModel, httpServletRequest,
				httpServletResponse);
		DbBackupCriteria dbBackupCriteria = new DbBackupCriteria();
		DbBackupCriteria.Criteria criteria = dbBackupCriteria.createCriteria();
		dbBackupCriteria.setPage(page);
		dbBackupCriteria.setOrderByClause("create_date desc");
		if (null != dbBackup.getId()  && !"".equals(dbBackup.getId())) {
		  	criteria.andIdLike("%" + dbBackup.getId() + "%");
		}
		if (null != dbBackup.getName()  && !"".equals(dbBackup.getName())) {
		  	criteria.andNameLike("%" + dbBackup.getName() + "%");
		}
		if (null != dbBackup.getPath()  && !"".equals(dbBackup.getPath())) {
		  	criteria.andPathLike("%" + dbBackup.getPath() + "%");
		}
//		if (null != dbBackup.getCreateDate()  && !"".equals(dbBackup.getCreateDate())) {
//		  	criteria.andCreateDateLike("%" + dbBackup.getCreateDate() + "%");
//		}
		page = dbBackupService.select(dbBackupCriteria);
		return page;
	}
	
	@RequiresPermissions("dbBackup:delete")
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
		int result = dbBackupService.deleteBatch(list);

		return result;
	}
	
	@RequestMapping(value = "/backup")
	@ResponseBody
	public void backup(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		dbBackupService.backup();
	}
	
	/**
	 * 还原数据库。
	 * @param name
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @throws IOException
	 */
	@RequestMapping(value = "/load")
	@ResponseBody
	public void load(@RequestParam(value = "name") String name,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		dbBackupService.load(name);
	}
	
	
	/**
	 * 全部导出Excel.
	 * @param dbBackup
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @throws IOException
	 */
//	@RequiresPermissions("dbBackup:view")
	@RequestMapping(value = "/exportExcel")
	public void exportExcel(@ModelAttribute DbBackup dbBackup,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		httpServletResponse.setCharacterEncoding("UTF-8");
		String filename = new String("用户信息".getBytes("GBK"), "iso8859-1");

		List<DbBackup>list = dbBackupService.selectAll();

		List<Map<String, Object>> maps = createExcelRecord(list);

		String columnNames[] = { 
			"Id",
			"Name",
			"Path",
			"CreateDate"
		};// 列名
		String keys[] = { 
			"Id",
			"Name",
			"Path",
			"CreateDate"
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

	private List<Map<String, Object>> createExcelRecord(List<DbBackup> list) {
		List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sheetName", "sheet1");
		listmap.add(map);
		DbBackup dbBackup = null;
		for (int j = 0; j < list.size(); j++) {
			dbBackup = list.get(j);
			Map<String, Object> mapValue = new HashMap<String, Object>();
				mapValue.put("Id",dbBackup.getId());
				mapValue.put("Name",dbBackup.getName());
				mapValue.put("Path",dbBackup.getPath());
				mapValue.put("CreateDate",dbBackup.getCreateDate());
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
