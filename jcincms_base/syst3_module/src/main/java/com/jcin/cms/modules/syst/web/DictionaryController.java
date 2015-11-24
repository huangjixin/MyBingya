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
import javax.validation.Valid;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.shiro.authz.annotation.RequiresPermissions;
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

import com.jcin.cms.common.DictionaryUtils;
import com.jcin.cms.common.Global;
import com.jcin.cms.modules.syst.domain.Dictionary;
import com.jcin.cms.modules.syst.domain.DictionaryCriteria;
import com.jcin.cms.modules.syst.service.IDictionaryService;
import com.jcin.cms.utils.Page;
import com.jcin.cms.utils.ExcelUtil;
import com.jcin.cms.web.BaseController;

@Controller
@RequestMapping(value = "admin/dictionary")
public class DictionaryController extends BaseController<Dictionary>{
	@Resource
	private IDictionaryService dictionaryService;

	@RequiresPermissions("dictionary:create")
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(Dictionary dictionary, Model uiModel) {
		uiModel.addAttribute("dictionary", dictionary);
		return root+"admin/modules/dictionary/dictionary_create";
	}

	@RequiresPermissions("dictionary:create")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(Dictionary dictionary, RedirectAttributes redirectAttributes,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		dictionaryService.insert(dictionary);
		
		redirectAttributes.addFlashAttribute("dictionary", dictionary);
		redirectAttributes.addFlashAttribute("msg", "新增成功");
		return "redirect:/"+Global.getAdminPath()+"/dictionary/create";
	}
	
	@RequiresPermissions("dictionary:update")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String update(@PathVariable("id") String id, Model uiModel) {
		Dictionary dictionary = dictionaryService.selectByPrimaryKey(id);
		uiModel.addAttribute("dictionary", dictionary);
		return root+"admin/modules/dictionary/dictionary_update";
	}

	@RequiresPermissions("dictionary:update")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String update(Dictionary dictionary ,@RequestParam(required=false) String roleId,RedirectAttributes redirectAttributes,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		dictionaryService.update(dictionary);
		
		redirectAttributes.addFlashAttribute("msg", "修改成功");
		redirectAttributes.addFlashAttribute("dictionary", dictionary);
		return "redirect:/"+Global.getAdminPath()+"/dictionary/update/"+dictionary.getId();
	}

	@RequiresPermissions("dictionary:show")
	@RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
	public String show(@PathVariable("id") String id, Model uiModel) {
		Dictionary dictionary = dictionaryService.selectByPrimaryKey(id);
		
		uiModel.addAttribute("dictionary", dictionary);
		return root+"admin/modules/dictionary/dictionary_show";
	}

	@RequiresPermissions("dictionary:view")
	@RequestMapping(value = { "", "list" })
	public String list(HttpServletRequest httpServletRequest) {
		return root+"admin/modules/dictionary/dictionary_list";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
	public String delete(@PathVariable("id") String id, Model uiModel) {
		dictionaryService.deleteByPrimaryKey(id);
		uiModel.asMap().clear();
		return "redirect:/dictionary";
	}

	void populateEditForm(Model uiModel, Dictionary dictionary) {
		uiModel.addAttribute("dictionary", dictionary);
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

	@RequestMapping(value = "/select")
	@ResponseBody
	public Page select(@ModelAttribute Page page, @ModelAttribute Dictionary dictionary,Model uiModel,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		super.select(page, uiModel, httpServletRequest,
				httpServletResponse);
		DictionaryCriteria dictionaryCriteria = new DictionaryCriteria();
		DictionaryCriteria.Criteria criteria = dictionaryCriteria.createCriteria();
		dictionaryCriteria.setPage(page);
		dictionaryCriteria.setOrderByClause("id desc");
		if (null != dictionary.getId()  && !"".equals(dictionary.getId())) {
		  	criteria.andIdLike("%" + dictionary.getId() + "%");
		}
		if (null != dictionary.getType()  && !"".equals(dictionary.getType())) {
		  	criteria.andTypeLike("%" + dictionary.getType() + "%");
		}
		if (null != dictionary.getLabel()  && !"".equals(dictionary.getLabel())) {
		  	criteria.andLabelLike("%" + dictionary.getLabel() + "%");
		}
		if (null != dictionary.getValue()  && !"".equals(dictionary.getValue())) {
		  	criteria.andValueLike("%" + dictionary.getValue() + "%");
		}
		page = dictionaryService.select(dictionaryCriteria);
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
		int result = dictionaryService.deleteBatch(list);

		return result;
	}
	
	@RequestMapping(value = "/getByType")
	@ResponseBody
	public List<Dictionary> getByType(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		
		List<Dictionary> dictionaries = DictionaryUtils.getAvailable();
		
		return dictionaries;
	}
	
	/**
	 * 全部导出Excel.
	 * @param dictionary
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @throws IOException
	 */
	@RequestMapping(value = "/exportExcel")
	public void exportExcel(@ModelAttribute Dictionary dictionary,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		httpServletResponse.setCharacterEncoding("UTF-8");
		String filename = new String("用户信息".getBytes("GBK"), "iso8859-1");

		List<Dictionary>list = dictionaryService.selectAll();

		List<Map<String, Object>> maps = createExcelRecord(list);

		String columnNames[] = { 
			"Id",
			"Type",
			"Label",
			"Value"
		};// 列名
		String keys[] = { 
			"Id",
			"Type",
			"Label",
			"Value"
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

	private List<Map<String, Object>> createExcelRecord(List<Dictionary> list) {
		List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sheetName", "sheet1");
		listmap.add(map);
		Dictionary dictionary = null;
		for (int j = 0; j < list.size(); j++) {
			dictionary = list.get(j);
			Map<String, Object> mapValue = new HashMap<String, Object>();
				mapValue.put("Id",dictionary.getId());
				mapValue.put("Type",dictionary.getType());
				mapValue.put("Label",dictionary.getLabel());
				mapValue.put("Value",dictionary.getValue());
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
