/**
 * 中兴软创<br/>
 * 一句话描述该类：<br/>
 * @author 黄记新
 * @date 2014-12-18,下午7:01:46
 *
 */
/**
 * 
 */
package com.jcin.cms.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.jcin.cms.domain.Operationlog;
import com.jcin.cms.domain.OperationlogCriteria;
import com.jcin.cms.exception.ExcelException;
import com.jcin.cms.service.IOpeLogService;
import com.jcin.cms.utils.ExcelUtil;
import com.jcin.cms.utils.Page;

/**
 * @author 黄记新
 * @date 2014-12-18,下午7:01:46
 * 
 */
@Controller
@RequestMapping("/opelog")
public class OpelogController extends BaseController {
	@Resource
	private IOpeLogService opeLogService;

	@RequestMapping("/list")
	public String list() {
		return "view/opelog/list";
	}

	@RequestMapping(value = "/select")
	@ResponseBody
	public Page select(
			@Valid Page page,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "operator", required = false) String operator,
			BindingResult bindingResult, Model uiModel,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		super.select(page, bindingResult, uiModel, httpServletRequest,
				httpServletResponse);
		OperationlogCriteria operationlogCriteria = new OperationlogCriteria();
		OperationlogCriteria.Criteria criteria = operationlogCriteria
				.createCriteria();
		operationlogCriteria.setPage(page);
		operationlogCriteria.setOrderByClause("id desc");
		if (null != name) {
			criteria.andNameLike("%" + name + "%");
		}
		if (null != operator) {
			criteria.andOperatorLike("%" + operator + "%");
		}

		page = opeLogService.select(operationlogCriteria);
		return page;
	}

	@RequestMapping(value = "/deleteById")
	@ResponseBody
	public int deleteById(@RequestParam(value = "idstring") String idstring,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {

		String[] ids = idstring.split(",");
		int result = 0;
		for (String idStr : ids) {
			result = opeLogService.deleteByPrimaryKey(idStr);
		}

		return result;
	}

	@RequestMapping(value = "/exportExcel")
	public void exportExcel(@RequestParam(required = false) String name,
			@RequestParam(required = false) String operator,
			@RequestParam(required = false) String ip,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		httpServletResponse.setCharacterEncoding("UTF-8");
		String filename = new String("操作日志".getBytes("GBK"), "iso8859-1");

		OperationlogCriteria operationlogCriteria = new OperationlogCriteria();
		OperationlogCriteria.Criteria criteria = operationlogCriteria
				.createCriteria();
		operationlogCriteria.setOrderByClause("id desc");
		if (null != name && !"".equals(name)) {
			criteria.andNameLike("%" + name + "%");
			filename += "_" + new String(name.getBytes("GBK"), "iso8859-1");
		}
		if (null != operator && !"".equals(operator)) {
			criteria.andOperatorLike("%" + operator + "%");
			filename += "_" + new String(operator.getBytes("GBK"), "iso8859-1");
		}

		if (null != ip && !"".equals(ip)) {
			criteria.andOperatorLike("%" + ip + "%");
			filename += "_" + new String(ip.getBytes("GBK"), "iso8859-1");
		}

		Page page = opeLogService.select(operationlogCriteria);

		@SuppressWarnings("unchecked")
		List<Operationlog> list = page.getRows();

		List<Map<String, Object>> maps = createExcelRecord(list);

		String columnNames[] = { "ID", "名称","操作人","修改日期" };// 列名
		String keys[] = { "id", "name","operator","createdate" };// map中的key
		Workbook hwb = ExcelUtil.createWorkBook(maps, keys, columnNames);
		// // 获取总列数
		// int CountColumnNum = list.size();
		// // 创建Excel文档
		// HSSFWorkbook hwb = new HSSFWorkbook();
		// Operationlog xlsDto = null;
		// // sheet 对应一个工作页
		// HSSFSheet sheet = hwb.createSheet("pldrxkxxmb");
		// HSSFRow firstrow = sheet.createRow(0); // 下标为0的行开始
		// HSSFCell[] firstcell = new HSSFCell[CountColumnNum];
		// String[] names = new String[CountColumnNum];
		// names[0] = "ID";
		// names[1] = "名称";
		// for (int j = 0; j < CountColumnNum; j++) {
		// firstcell[j] = firstrow.createCell(j);
		// firstcell[j].setCellValue(new HSSFRichTextString(names[j]));
		// }
		// for (int i = 0; i < list.size(); i++) {
		// // 创建一行
		// HSSFRow row = sheet.createRow(i + 1);
		// // 得到要插入的每一条记录
		// xlsDto = list.get(i);
		// for (int colu = 0; colu <= 4; colu++) {
		// // 在一行内循环
		// HSSFCell xh = row.createCell(0);
		// xh.setCellValue(xlsDto.getId());
		// HSSFCell xm = row.createCell(1);
		// xm.setCellValue(xlsDto.getName());
		// }
		// }

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");// 等价于now.toLocaleString()
		filename += "_" + sdf.format(new Date()) + ".xls";
		httpServletResponse.setContentType("APPLICATION/OCTET-STREAM");
		httpServletResponse.setHeader("Content-Disposition",
				"attachment; filename=\"" + filename + "\"");

		// String path = httpServletRequest.getServletContext().getRealPath(
		// File.separator);
		// path += "testwrite.xls";
		// 创建文件输出流，准备输出电子表格
		// OutputStream out = new FileOutputStream(path);
		// hwb.write(out);
		// out.close();
		// System.out.println("数据库导出成功");

		OutputStream os = httpServletResponse.getOutputStream();
		hwb.write(os);
		os.flush();
		os.close();
	}

	private List<Map<String, Object>> createExcelRecord(List<Operationlog> list) {
		List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sheetName", "sheet1");
		listmap.add(map);
		Operationlog operationlog = null;
		for (int j = 0; j < list.size(); j++) {
			operationlog = list.get(j);
			Map<String, Object> mapValue = new HashMap<String, Object>();
			mapValue.put("id", operationlog.getId());
			mapValue.put("name", operationlog.getName());
			mapValue.put("createdate", operationlog.getCreatedate());
			mapValue.put("description", operationlog.getDescription());
			mapValue.put("ip", operationlog.getIp());
			mapValue.put("operator", operationlog.getOperator());
			listmap.add(mapValue);
		}
		return listmap;
	}

	@RequestMapping(value = "/excelToList")
	@ResponseBody
	public Page excelToList(
			@RequestParam(value = "file", required = true) MultipartFile file,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException,
			ExcelException {
		InputStream is = file.getInputStream();
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
		List<Operationlog> list = null;
		LinkedHashMap<String, String> fieldMap = new LinkedHashMap<String, String>();
		fieldMap.put("名称", "name");
		fieldMap.put("操作人", "operator");
//		fieldMap.put("修改日期", "createdate");
		Page page = new Page();
		list = ExcelUtil
				.excelToList(hssfWorkbook, Operationlog.class, fieldMap);
		page.setRows(list);
		page.setTotal(list.size());
		return page;
	}

	@RequestMapping(value = "/importExcel")
	@ResponseBody
	public List<Operationlog> importExcel(
			@RequestParam(value = "file", required = true) MultipartFile file,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException,
			ExcelException {
		// MultipartFile uFile = (MultipartFile)httpServletRequest.get("uFile");
//		String path = httpServletRequest.getServletContext().getRealPath(
//				File.separator);
		String path = httpServletRequest.getServletPath();
		path += file.getName();
		// OutputStream outputStream = new FileOutputStream(path);
		// outputStream.w
		// InputStream is = new FileInputStream(path);
		InputStream is = file.getInputStream();
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
		// Operationlog operationlog = null;
		List<Operationlog> list = null;
		LinkedHashMap<String, String> fieldMap = new LinkedHashMap<String, String>();
		fieldMap.put("操作名称", "name");

		list = ExcelUtil
				.excelToList(hssfWorkbook, Operationlog.class, fieldMap);
		if (list.size() > 0) {
			long time = new Date().getTime();
			int i = 0;
			Date date = new Date();
			for (Operationlog operationlog : list) {
				operationlog.setId((time + i) + "");
				operationlog.setCreatedate(date);
				i++;
			}
		}
		// Read the Sheet
		// for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets();
		// numSheet++) {
		// HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
		// if (hssfSheet == null) {
		// continue;
		// }
		// // Read the Row
		// for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
		// HSSFRow hssfRow = hssfSheet.getRow(rowNum);
		// if (hssfRow != null) {
		// operationlog = new Operationlog();
		// HSSFCell name = hssfRow.getCell(0);
		// operationlog.setName(getValue(name));
		// list.add(operationlog);
		// }
		// }
		// }
		// for (Operationlog operationlog2 : list) {
		// operationlog2.setId("" + (Math.round(1000000000 * Math.random())));
		// operationlog2.setCreatedate(new Date());
		// }
		int result = opeLogService.insertBatch(list);
		return list;
	}

	// @SuppressWarnings("static-access")
	// private String getValue(HSSFCell hssfCell) {
	// if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
	// return String.valueOf(hssfCell.getBooleanCellValue());
	// } else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
	// return String.valueOf(hssfCell.getNumericCellValue());
	// } else {
	// return String.valueOf(hssfCell.getStringCellValue());
	// }
	// }
}
