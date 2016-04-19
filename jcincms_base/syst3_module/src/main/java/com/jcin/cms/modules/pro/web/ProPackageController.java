/**
 * 一句话描述该类：前端控制器，提供页面跳转，访问方法返回JSON<br/>
 * @author 黄记新 <br/>
 * @date 2015-4-29,10:52 <br/>
 *
 */
package com.jcin.cms.modules.pro.web;

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
import com.jcin.cms.modules.pro.domain.ProPackage;
import com.jcin.cms.modules.pro.domain.ProPackageCriteria;
import com.jcin.cms.modules.pro.service.IProPackageService;
import com.jcin.cms.utils.Page;
import com.jcin.cms.utils.ExcelUtil;
import com.jcin.cms.web.BaseController;

@Controller
@RequestMapping(value = "${adminPath}/proPackage")
public class ProPackageController extends BaseController<ProPackage>{
	@Autowired
	private IProPackageService proPackageService;

//	@RequiresPermissions("proPackage:create")
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(ProPackage proPackage, Model uiModel) {
		uiModel.addAttribute("proPackage", proPackage);
		return root+"admin/modules/proPackage/proPackage_create.jsp";
	}

//	@RequiresPermissions("proPackage:create")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(ProPackage proPackage, RedirectAttributes redirectAttributes,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		proPackageService.insert(proPackage);
		
		redirectAttributes.addFlashAttribute("proPackage", proPackage);
		redirectAttributes.addFlashAttribute("msg", "新增成功");
		return "redirect:/"+Global.getAdminPath()+"/proPackage/create";
	}
	
//	@RequiresPermissions("proPackage:update")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String update(@PathVariable("id") String id, Model uiModel) {
		ProPackage proPackage = proPackageService.selectByPrimaryKey(id);
		uiModel.addAttribute("proPackage", proPackage);
		return root+"admin/modules/proPackage/proPackage_update.jsp";
	}

//	@RequiresPermissions("proPackage:update")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String update(ProPackage proPackage,RedirectAttributes redirectAttributes,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		proPackageService.update(proPackage);
		
		redirectAttributes.addFlashAttribute("msg", "修改成功");
		redirectAttributes.addFlashAttribute("proPackage", proPackage);
		return "redirect:/"+Global.getAdminPath()+"/proPackage/update/"+proPackage.getId();
	}

//	@RequiresPermissions("proPackage:show")
	@RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
	public String show(@PathVariable("id") String id, Model uiModel) {
		ProPackage proPackage = proPackageService.selectByPrimaryKey(id);
		
		uiModel.addAttribute("proPackage", proPackage);
		return root+"admin/modules/proPackage/proPackage_show.jsp";
	}

//	@RequiresPermissions("proPackage:view")
	@RequestMapping(value = { "", "list" })
	public String list(HttpServletRequest httpServletRequest) {
		return root+"admin/modules/proPackage/proPackage_list.jsp";
	}

//	@RequiresPermissions("proPackage:delete")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
	public String delete(@PathVariable("id") String id, Model uiModel) {
		proPackageService.deleteByPrimaryKey(id);
		uiModel.asMap().clear();
		return "redirect:/proPackage";
	}

	void populateEditForm(Model uiModel, ProPackage proPackage) {
		uiModel.addAttribute("proPackage", proPackage);
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

//	@RequiresPermissions("proPackage:view")
	@RequestMapping(value = "/select")
	@ResponseBody
	public Page select(@ModelAttribute Page page, @ModelAttribute ProPackage proPackage,Model uiModel,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		super.select(page, uiModel, httpServletRequest,
				httpServletResponse);
		ProPackageCriteria proPackageCriteria = new ProPackageCriteria();
		ProPackageCriteria.Criteria criteria = proPackageCriteria.createCriteria();
		proPackageCriteria.setPage(page);
		proPackageCriteria.setOrderByClause("id desc");
		if (null != proPackage.getId()  && !"".equals(proPackage.getId())) {
		  	criteria.andIdLike("%" + proPackage.getId() + "%");
		}
		if (null != proPackage.getSkuId()  && !"".equals(proPackage.getSkuId())) {
		  	criteria.andSkuIdLike("%" + proPackage.getSkuId() + "%");
		}
//		if (null != proPackage.getCounts()  && !"".equals(proPackage.getCounts())) {
//		  	criteria.andCountsLike("%" + proPackage.getCounts() + "%");
//		}
//		if (null != proPackage.getPrice()  && !"".equals(proPackage.getPrice())) {
//		  	criteria.andPriceLike("%" + proPackage.getPrice() + "%");
//		}
//		if (null != proPackage.getCreateDate()  && !"".equals(proPackage.getCreateDate())) {
//		  	criteria.andCreateDateLike("%" + proPackage.getCreateDate() + "%");
//		}
//		if (null != proPackage.getUpdateDate()  && !"".equals(proPackage.getUpdateDate())) {
//		  	criteria.andUpdateDateLike("%" + proPackage.getUpdateDate() + "%");
//		}
		page = proPackageService.select(proPackageCriteria);
		return page;
	}
	
//	@RequiresPermissions("proPackage:delete")
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
		int result = proPackageService.deleteBatch(list);

		return result;
	}
	
	/**
	 * 全部导出Excel.
	 * @param proPackage
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @throws IOException
	 */
//	@RequiresPermissions("proPackage:view")
	@RequestMapping(value = "/exportExcel")
	public void exportExcel(@ModelAttribute ProPackage proPackage,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		httpServletResponse.setCharacterEncoding("UTF-8");
		String filename = new String("用户信息".getBytes("GBK"), "iso8859-1");

		List<ProPackage>list = proPackageService.selectAll();

		List<Map<String, Object>> maps = createExcelRecord(list);

		String columnNames[] = { 
			"Id",
			"SkuId",
			"Counts",
			"Price",
			"CreateDate",
			"UpdateDate"
		};// 列名
		String keys[] = { 
			"Id",
			"SkuId",
			"Counts",
			"Price",
			"CreateDate",
			"UpdateDate"
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

	private List<Map<String, Object>> createExcelRecord(List<ProPackage> list) {
		List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sheetName", "sheet1");
		listmap.add(map);
		ProPackage proPackage = null;
		for (int j = 0; j < list.size(); j++) {
			proPackage = list.get(j);
			Map<String, Object> mapValue = new HashMap<String, Object>();
				mapValue.put("Id",proPackage.getId());
				mapValue.put("SkuId",proPackage.getSkuId());
				mapValue.put("Counts",proPackage.getCounts());
				mapValue.put("Price",proPackage.getPrice());
				mapValue.put("CreateDate",proPackage.getCreateDate());
				mapValue.put("UpdateDate",proPackage.getUpdateDate());
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
