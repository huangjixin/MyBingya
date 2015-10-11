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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jcin.cms.modules.syst.domain.Log;
import com.jcin.cms.modules.syst.domain.LogCriteria;
import com.jcin.cms.modules.syst.service.ILogService;
import com.jcin.cms.utils.ExcelUtil;
import com.jcin.cms.utils.Page;
import com.jcin.cms.web.BaseController;

@Controller
@RequestMapping(value = "${adminPath}/log")
public class LogController extends BaseController<Log> {
	@Autowired
	private ILogService logService;


	@RequiresPermissions("log:view")
	@RequestMapping(value = { "", "list" })
	public String list(HttpServletRequest httpServletRequest) {
		return "admin/modules/log/log_list";
	}

	@RequestMapping(value = "/select")
	@ResponseBody
	public Page select(@ModelAttribute Page page, @ModelAttribute Log log,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		super.select(page, uiModel, httpServletRequest, httpServletResponse);
		LogCriteria logCriteria = new LogCriteria();
		LogCriteria.Criteria criteria = logCriteria.createCriteria();
		logCriteria.setPage(page);
		logCriteria.setOrderByClause("id desc");
		if (null != log.getId() && !"".equals(log.getId())) {
			criteria.andIdLike("%" + log.getId() + "%");
		}
		
		page = logService.select(logCriteria);
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
		int result = logService.deleteBatch(list);

		return result;
	}

	/**
	 * 全部导出Excel.
	 * 
	 * @param log
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @throws IOException
	 */
	@RequestMapping(value = "/exportExcel")
	public void exportExcel(@ModelAttribute Log log,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		httpServletResponse.setCharacterEncoding("UTF-8");
		String filename = new String("Log".getBytes("GBK"), "iso8859-1");

		List<Log> list = logService.selectAll();

		List<Map<String, Object>> maps = createExcelRecord(list);

		String columnNames[] = { "Id", "Logname", "Password", "Status",
				"Description", "Enabled", "CreateDate", "UpdateDate", "Ip",
				"Telephone", "Salt", "Locked", "Email", "Sex", "Address",
				"LogGroup_id" };// 列名
		String keys[] = { "Id", "Logname", "Password", "CreateDate",
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

	private List<Map<String, Object>> createExcelRecord(List<Log> list) {
		List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sheetName", "sheet1");
		listmap.add(map);
		Log log = null;
		for (int j = 0; j < list.size(); j++) {
			log = list.get(j);
			Map<String, Object> mapValue = new HashMap<String, Object>();
			mapValue.put("Id", log.getId());
			listmap.add(mapValue);
		}
		return listmap;
	}
}