/**
 * 一句话描述该类：前端控制器，提供页面跳转，访问方法返回JSON<br/>
 * @author 黄记新 <br/>
 * @date 2015-4-29,10:52 <br/>
 *
 */
package com.jcin.cms.modules.bet.web;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
import com.jcin.cms.modules.bet.domain.FruitRecord;
import com.jcin.cms.modules.bet.domain.FruitRecordCriteria;
import com.jcin.cms.modules.bet.service.IFruitRecordService;
import com.jcin.cms.utils.Page;
import com.jcin.cms.utils.ExcelUtil;
import com.jcin.cms.web.BaseController;

@Controller
@RequestMapping(value = "${adminPath}/fruitRecord")
public class FruitRecordController extends BaseController<FruitRecord>{
	@Autowired
	private IFruitRecordService fruitRecordService;

//	@RequiresPermissions("fruitRecord:create")
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(FruitRecord fruitRecord, Model uiModel) {
		uiModel.addAttribute("fruitRecord", fruitRecord);
		return root+"admin/modules/fruitRecord/fruitRecord_create.jsp";
	}

//	@RequiresPermissions("fruitRecord:create")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(FruitRecord fruitRecord, RedirectAttributes redirectAttributes,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		fruitRecordService.insert(fruitRecord);
		
		redirectAttributes.addFlashAttribute("fruitRecord", fruitRecord);
		redirectAttributes.addFlashAttribute("msg", "新增成功");
		return "redirect:/"+Global.getAdminPath()+"/fruitRecord/create";
	}
	
//	@RequiresPermissions("fruitRecord:update")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String update(@PathVariable("id") String id, Model uiModel) {
		FruitRecord fruitRecord = fruitRecordService.selectByPrimaryKey(id);
		uiModel.addAttribute("fruitRecord", fruitRecord);
		return root+"admin/modules/fruitRecord/fruitRecord_update.jsp";
	}

//	@RequiresPermissions("fruitRecord:update")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String update(FruitRecord fruitRecord,RedirectAttributes redirectAttributes,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		fruitRecordService.update(fruitRecord);
		
		redirectAttributes.addFlashAttribute("msg", "修改成功");
		redirectAttributes.addFlashAttribute("fruitRecord", fruitRecord);
		return "redirect:/"+Global.getAdminPath()+"/fruitRecord/update/"+fruitRecord.getId();
	}

//	@RequiresPermissions("fruitRecord:show")
	@RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
	public String show(@PathVariable("id") String id, Model uiModel) {
		FruitRecord fruitRecord = fruitRecordService.selectByPrimaryKey(id);
		
		uiModel.addAttribute("fruitRecord", fruitRecord);
		return root+"admin/modules/fruitRecord/fruitRecord_show.jsp";
	}

//	@RequiresPermissions("fruitRecord:view")
	@RequestMapping(value = { "", "list" })
	public String list(HttpServletRequest httpServletRequest) {
		return root+"admin/modules/fruitRecord/fruitRecord_list.jsp";
	}

//	@RequiresPermissions("fruitRecord:delete")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
	public String delete(@PathVariable("id") String id, Model uiModel) {
		fruitRecordService.deleteByPrimaryKey(id);
		uiModel.asMap().clear();
		return "redirect:/fruitRecord";
	}

	void populateEditForm(Model uiModel, FruitRecord fruitRecord) {
		uiModel.addAttribute("fruitRecord", fruitRecord);
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

//	@RequiresPermissions("fruitRecord:view")
	@RequestMapping(value = "/select")
	@ResponseBody
	public Page select(@ModelAttribute Page page, @ModelAttribute FruitRecord fruitRecord,Model uiModel,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		super.select(page, uiModel, httpServletRequest,
				httpServletResponse);
		FruitRecordCriteria fruitRecordCriteria = new FruitRecordCriteria();
		FruitRecordCriteria.Criteria criteria = fruitRecordCriteria.createCriteria();
		fruitRecordCriteria.setPage(page);
		fruitRecordCriteria.setOrderByClause("id desc");
		if (null != fruitRecord.getId()  && !"".equals(fruitRecord.getId())) {
		  	criteria.andIdLike("%" + fruitRecord.getId() + "%");
		}
		/*if (null != fruitRecord.getResult()  && !"".equals(fruitRecord.getResult())) {
		  	criteria.andResultLike("%" + fruitRecord.getResult() + "%");
		}
		if (null != fruitRecord.getCreateDate()  && !"".equals(fruitRecord.getCreateDate())) {
		  	criteria.andCreateDateLike("%" + fruitRecord.getCreateDate() + "%");
		}*/
		if (null != fruitRecord.getCreateBy()  && !"".equals(fruitRecord.getCreateBy())) {
		  	criteria.andCreateByLike("%" + fruitRecord.getCreateBy() + "%");
		}
		/*if (null != fruitRecord.getUpdateDate()  && !"".equals(fruitRecord.getUpdateDate())) {
		  	criteria.andUpdateDateLike("%" + fruitRecord.getUpdateDate() + "%");
		}*/
		if (null != fruitRecord.getUpdateBy()  && !"".equals(fruitRecord.getUpdateBy())) {
		  	criteria.andUpdateByLike("%" + fruitRecord.getUpdateBy() + "%");
		}
		if (null != fruitRecord.getDescription()  && !"".equals(fruitRecord.getDescription())) {
		  	criteria.andDescriptionLike("%" + fruitRecord.getDescription() + "%");
		}
		page = fruitRecordService.select(fruitRecordCriteria);
		return page;
	}
	
//	@RequiresPermissions("fruitRecord:delete")
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
		int result = fruitRecordService.deleteBatch(list);

		return result;
	}
	
	/**
	 * 全部导出Excel.
	 * @param fruitRecord
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @throws IOException
	 */
//	@RequiresPermissions("fruitRecord:view")
	@RequestMapping(value = "/exportExcel")
	public void exportExcel(@ModelAttribute FruitRecord fruitRecord,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		httpServletResponse.setCharacterEncoding("UTF-8");
		String filename = new String("用户信息".getBytes("GBK"), "iso8859-1");

		List<FruitRecord>list = fruitRecordService.selectAll();

		List<Map<String, Object>> maps = createExcelRecord(list);

		String columnNames[] = { 
			"Id",
			"Result",
			"CreateDate",
			"CreateBy",
			"UpdateDate",
			"UpdateBy",
			"Description"
		};// 列名
		String keys[] = { 
			"Id",
			"Result",
			"CreateDate",
			"CreateBy",
			"UpdateDate",
			"UpdateBy",
			"Description"
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

	private List<Map<String, Object>> createExcelRecord(List<FruitRecord> list) {
		List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sheetName", "sheet1");
		listmap.add(map);
		FruitRecord fruitRecord = null;
		for (int j = 0; j < list.size(); j++) {
			fruitRecord = list.get(j);
			Map<String, Object> mapValue = new HashMap<String, Object>();
				mapValue.put("Id",fruitRecord.getId());
				mapValue.put("Result",fruitRecord.getResult());
				mapValue.put("CreateDate",fruitRecord.getCreateDate());
				mapValue.put("CreateBy",fruitRecord.getCreateBy());
				mapValue.put("UpdateDate",fruitRecord.getUpdateDate());
				mapValue.put("UpdateBy",fruitRecord.getUpdateBy());
				mapValue.put("Description",fruitRecord.getDescription());
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
