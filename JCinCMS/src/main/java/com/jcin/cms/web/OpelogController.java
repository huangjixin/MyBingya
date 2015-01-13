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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jcin.cms.domain.Operationlog;
import com.jcin.cms.domain.OperationlogCriteria;
import com.jcin.cms.service.IOpeLogService;
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
	public void exportExcel(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {

		// 接收前台查询参数
		String name = httpServletRequest.getParameter("name");
		String operator = httpServletRequest.getParameter("operator");
		OperationlogCriteria operationlogCriteria = new OperationlogCriteria();
		OperationlogCriteria.Criteria criteria = operationlogCriteria
				.createCriteria();
		operationlogCriteria.setOrderByClause("id desc");
		if (null != name) {
			criteria.andNameLike("%" + name + "%");
		}
		if (null != operator) {
			criteria.andOperatorLike("%" + operator + "%");
		}

		Page page = opeLogService.select(operationlogCriteria);

		@SuppressWarnings("unchecked")
		List<Operationlog> list = page.getRows();

		// 获取总列数
        int CountColumnNum = list.size();
        // 创建Excel文档
        HSSFWorkbook hwb = new HSSFWorkbook();
        Operationlog xlsDto = null;
        // sheet 对应一个工作页
        HSSFSheet sheet = hwb.createSheet("pldrxkxxmb");
        HSSFRow firstrow = sheet.createRow(0); // 下标为0的行开始
        HSSFCell[] firstcell = new HSSFCell[CountColumnNum];
        String[] names = new String[CountColumnNum];
        names[0] = "ID";
        names[1] = "名称";
        for (int j = 0; j < CountColumnNum; j++) {
            firstcell[j] = firstrow.createCell(j);
            firstcell[j].setCellValue(new HSSFRichTextString(names[j]));
        }
        for (int i = 0; i < list.size(); i++) {
            // 创建一行
            HSSFRow row = sheet.createRow(i + 1);
            // 得到要插入的每一条记录
            xlsDto = list.get(i);
            for (int colu = 0; colu <= 4; colu++) {
                // 在一行内循环
                HSSFCell xh = row.createCell(0);
                xh.setCellValue(xlsDto.getId());
                HSSFCell xm = row.createCell(1);
                xm.setCellValue(xlsDto.getName());
            }
        }
        
        String path = httpServletRequest.getServletContext().getRealPath(
				File.separator);
		path += "testwrite.xls";
        // 创建文件输出流，准备输出电子表格
        OutputStream out = new FileOutputStream(path);
        hwb.write(out);
        out.close();
        System.out.println("数据库导出成功");
        
		// // 获取总列数
		// int CountColumnNum = 1;
		// // 创建Excel文档
		// HSSFWorkbook hwb = new HSSFWorkbook();
		// Operationlog operationlog = null;
		//
		// // sheet 对应一个工作页
		// HSSFSheet sheet = hwb.createSheet("opelog");
		// HSSFRow firstrow = sheet.createRow(0); // 下标为0的行开始
		// HSSFCell[] firstcell = new HSSFCell[CountColumnNum];
		// String[] names = new String[CountColumnNum];
		// names[0] = "名称";
		// for (int j = 0; j < CountColumnNum; j++) {
		// firstcell[j] = firstrow.createCell(j);
		// firstcell[j].setCellValue(new HSSFRichTextString(names[j]));
		// }
		// for (int i = 0; i < list.size(); i++) {
		// // 创建一行
		// HSSFRow row = sheet.createRow(i + 1);
		// // 得到要插入的每一条记录
		// operationlog = list.get(i);
		// for (int colu = 0; colu <= 1; colu++) {
		// // 在一行内循环
		// HSSFCell xh = row.createCell(0);
		// xh.setCellValue(operationlog.getName());
		// }
		// }

		// 产生工作簿对象
//		HSSFWorkbook workbook = new HSSFWorkbook();
//		// 产生工作表对象
//		HSSFSheet sheet = workbook.createSheet();
//		for (int i = 0; i <= 300; i++) {
//			HSSFRow row = sheet.createRow((int) i);// 创建一行
//			HSSFCell cell = row.createCell((int) 0);// 创建一列
//			cell.setCellType(HSSFCell.CELL_TYPE_STRING);
//			cell.setCellValue("测试成功" + i);
//		}
//
//		OutputStream fOut = httpServletResponse.getOutputStream();
//		workbook.write(fOut);

		// PrintWriter out = httpServletResponse.getWriter();
		// out.write(sheet);
		// Retrieve the output stream
		// ServletOutputStream outputStream =
		// httpServletResponse.getOutputStream();
		// // Write to the output stream
		// sheet.getWorkbook().write(outputStream);
		// // 清除缓存
		// outputStream.flush();
		// outputStream.close();
	}

	@RequestMapping(value = "/readXls")
	@ResponseBody
	public List<Operationlog> readXls(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {

		String path = httpServletRequest.getServletContext().getRealPath(
				File.separator);
		path += "test.xls";
		InputStream is = new FileInputStream(path);
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
		Operationlog operationlog = null;
		List<Operationlog> list = new ArrayList<Operationlog>();
		// Read the Sheet
		for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
			HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
			if (hssfSheet == null) {
				continue;
			}
			// Read the Row
			for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
				HSSFRow hssfRow = hssfSheet.getRow(rowNum);
				if (hssfRow != null) {
					operationlog = new Operationlog();
					HSSFCell name = hssfRow.getCell(0);
					operationlog.setName(getValue(name));
					list.add(operationlog);
				}
			}
		}
		for (Operationlog operationlog2 : list) {
			operationlog2.setId("" + (Math.round(1000000000 * Math.random())));
			operationlog2.setCreatedate(new Date());
		}
		int result = opeLogService.insertBatch(list);
		return list;
	}

	@SuppressWarnings("static-access")
	private String getValue(HSSFCell hssfCell) {
		if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
			return String.valueOf(hssfCell.getBooleanCellValue());
		} else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
			return String.valueOf(hssfCell.getNumericCellValue());
		} else {
			return String.valueOf(hssfCell.getStringCellValue());
		}
	}

	/**
	 * 
	 * @param xls
	 *            XlsDto实体类的一个对象
	 * @throws Exception
	 *             在导入Excel的过程中抛出异常
	 */
	public static void xlsDto2Excel(List<Operationlog> xls) throws Exception {
        
    }
}
