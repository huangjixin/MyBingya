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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jcin.cms.domain.NotPayed;
import com.jcin.cms.domain.NotPayedCriteria;
import com.jcin.cms.domain.Payed;
import com.jcin.cms.domain.PayedCriteria;
import com.jcin.cms.service.INotPayedService;
import com.jcin.cms.utils.ExcelUtil;
import com.jcin.cms.utils.Page;

/**
 * @author 黄记新
 * @date 2014-12-18,下午7:01:46
 * 
 */
@Controller
@RequestMapping("/notPayed")
public class NotPayedController extends BaseController {
	@Resource
	private INotPayedService notPayedService;

	@RequestMapping("/list")
	public String list() {
		return "view/notPayed/list";
	}

	@RequestMapping(value = "/select")
	@ResponseBody
	public Page select(@Valid Page page, @Valid NotPayed notPayed,
			BindingResult bindingResult, Model uiModel,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		super.select(page, bindingResult, uiModel, httpServletRequest,
				httpServletResponse);
		NotPayedCriteria operationlogCriteria = new NotPayedCriteria();
		NotPayedCriteria.Criteria criteria = operationlogCriteria
				.createCriteria();
		operationlogCriteria.setPage(page);
		if (null != notPayed.getMaterial()) {
			criteria.andMaterialLike("%" + notPayed.getMaterial() + "%");
		}
		if (null != notPayed.getSize()) {
			criteria.andSizeLike("%" + notPayed.getMaterial() + "%");
		}
		if (null != notPayed.getRecorddate()) {
			criteria.andRecorddateLike("%" + notPayed.getRecorddate() + "%");
		}
		if (null != notPayed.getCustomerName()) {
			criteria.andCustomerNameLike("%" + notPayed.getCustomerName() + "%");
		}
		operationlogCriteria.setOrderByClause(" id desc");
		page = notPayedService.select(operationlogCriteria);
		return page;
	}

	@RequestMapping(value = "/deleteById")
	@ResponseBody
	public int deleteById(@RequestParam(value = "idstring") String idstring,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {

		String[] ids = idstring.split(",");
		List list = new ArrayList();
		for (String idStr : ids) {
			list.add(idStr);
		}
		int result = notPayedService.deleteBatch(list);

		return result;
	}

	@RequestMapping(value = "/new")
	public String create(@Valid NotPayed notPayed, BindingResult bindingResult,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		String id = notPayedService.insert(notPayed);

		return "view/notPayed/list";
	}

	@RequestMapping(value = "/update")
	public String update(@Valid NotPayed notPayed, BindingResult bindingResult,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		int result = notPayedService.update(notPayed);

		return "view/notPayed/list";
	}

	@RequestMapping(value = "/notPayedAdd")
	public String notPayedAdd(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		return "view/notPayed/add";
	}

	@RequestMapping(value = "/notPayedUpdate")
	public ModelAndView notPayedUpdate(@RequestParam String id,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		NotPayed notPayed = new NotPayed();
		if (null != id && !"".equals(id)) {
			notPayed = notPayedService.selectByPrimaryKey(id);
		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("notPayed", notPayed);
		modelAndView.setViewName("view/notPayed/update");
		return modelAndView;
	}
	
	@RequestMapping(value = "/exportExcel")
	public void exportExcel(@Valid NotPayed notPayed, BindingResult bindingResult,
			Model uiModel,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		httpServletResponse.setCharacterEncoding("UTF-8");
		String filename = new String("notPayed".getBytes("GBK"), "iso8859-1");

		NotPayedCriteria notPayedCriteria = new NotPayedCriteria();
		NotPayedCriteria.Criteria criteria = notPayedCriteria.createCriteria();
		
		if (null != notPayed.getMaterial()) {
			criteria.andMaterialLike("%" + notPayed.getMaterial() + "%");
		}
		if (null != notPayed.getSize()) {
			criteria.andSizeLike("%" + notPayed.getMaterial() + "%");
		}
		if (null != notPayed.getRecorddate()) {
			criteria.andRecorddateLike("%" + notPayed.getRecorddate() + "%");
		}
		if (null != notPayed.getCustomerName()) {
			criteria.andCustomerNameLike("%" + notPayed.getCustomerName() + "%");
		}
		notPayedCriteria.setOrderByClause(" id desc");
		Page page = notPayedService.select(notPayedCriteria);


		@SuppressWarnings("unchecked")
		List<NotPayed> list = page.getRows();

		List<Map<String, Object>> maps = createExcelRecord(list);

		String columnNames[] = { "序号", "日期", "客户名", "材质" , "规格" , "重量" , "单价" , "货款" };// 列名
		String keys[] = { "id", "recorddate", "customerName", "material", "size" , "weight" , "price" , "goodsMoney" };// map中的key
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
		String path = "D:" + File.separator + filename;
		OutputStream out = new FileOutputStream(path);
		hwb.write(out);
		out.close();
		// System.out.println("数据库导出成功");

		OutputStream os = httpServletResponse.getOutputStream();
		hwb.write(os);
		os.flush();
		os.close();
	}
	
	private List<Map<String, Object>> createExcelRecord(List<NotPayed> list) {
		List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sheetName", "sheet1");
		listmap.add(map);
		NotPayed notPayed = null;
		for (int j = 0; j < list.size(); j++) {
			notPayed = list.get(j);
			Map<String, Object> mapValue = new HashMap<String, Object>();
			mapValue.put("id", notPayed.getId());
			mapValue.put("recorddate", notPayed.getRecorddate());
			mapValue.put("customerName", notPayed.getCustomerName());
			mapValue.put("material", notPayed.getMaterial());
			mapValue.put("createdate", notPayed.getCreatedate());
			mapValue.put("size", notPayed.getSize());
			mapValue.put("weight", notPayed.getWeight());
			mapValue.put("price", notPayed.getPrice());
			mapValue.put("goodsMoney", notPayed.getGoodsMoney());
			listmap.add(mapValue);
		}
		return listmap;
	}

}
