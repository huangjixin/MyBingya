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
import com.jcin.cms.modules.pro.domain.Brand;
import com.jcin.cms.modules.pro.domain.BrandCriteria;
import com.jcin.cms.modules.pro.domain.BrandWithBLOBs;
import com.jcin.cms.modules.pro.service.IBrandService;
import com.jcin.cms.utils.Page;
import com.jcin.cms.utils.ExcelUtil;
import com.jcin.cms.web.BaseController;

@Controller
@RequestMapping(value = "${adminPath}/brand")
public class BrandController extends BaseController<Brand>{
	@Autowired
	private IBrandService brandService;

//	@RequiresPermissions("brand:create")
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(BrandWithBLOBs brand, Model uiModel) {
		uiModel.addAttribute("brand", brand);
		return root+"admin/modules/brand/brand_create.jsp";
	}

//	@RequiresPermissions("brand:create")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(BrandWithBLOBs brand, RedirectAttributes redirectAttributes,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		brandService.insert(brand);
		
		redirectAttributes.addFlashAttribute("brand", brand);
		redirectAttributes.addFlashAttribute("msg", "新增成功");
		return "redirect:/"+Global.getAdminPath()+"/brand/create";
	}
	
//	@RequiresPermissions("brand:update")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String update(@PathVariable("id") String id, Model uiModel) {
		BrandWithBLOBs brand = brandService.selectByPrimaryKey(id);
		uiModel.addAttribute("brand", brand);
		return root+"admin/modules/brand/brand_update.jsp";
	}

//	@RequiresPermissions("brand:update")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String update(BrandWithBLOBs brand,RedirectAttributes redirectAttributes,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		brandService.update(brand);
		
		redirectAttributes.addFlashAttribute("msg", "修改成功");
		redirectAttributes.addFlashAttribute("brand", brand);
		return "redirect:/"+Global.getAdminPath()+"/brand/update/"+brand.getId();
	}

//	@RequiresPermissions("brand:show")
	@RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
	public String show(@PathVariable("id") String id, Model uiModel) {
		Brand brand = brandService.selectByPrimaryKey(id);
		
		uiModel.addAttribute("brand", brand);
		return root+"admin/modules/brand/brand_show.jsp";
	}

//	@RequiresPermissions("brand:view")
	@RequestMapping(value = { "", "list" })
	public String list(HttpServletRequest httpServletRequest) {
		return root+"admin/modules/brand/brand_list.jsp";
	}

//	@RequiresPermissions("brand:delete")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
	public String delete(@PathVariable("id") String id, Model uiModel) {
		brandService.deleteByPrimaryKey(id);
		uiModel.asMap().clear();
		return "redirect:/brand";
	}

	void populateEditForm(Model uiModel, Brand brand) {
		uiModel.addAttribute("brand", brand);
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

//	@RequiresPermissions("brand:view")
	@RequestMapping(value = "/select")
	@ResponseBody
	public Page select(@ModelAttribute Page page, @ModelAttribute Brand brand,Model uiModel,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		super.select(page, uiModel, httpServletRequest,
				httpServletResponse);
		BrandCriteria brandCriteria = new BrandCriteria();
		BrandCriteria.Criteria criteria = brandCriteria.createCriteria();
		brandCriteria.setPage(page);
		brandCriteria.setOrderByClause("id desc");
		if (null != brand.getId()  && !"".equals(brand.getId())) {
		  	criteria.andIdLike("%" + brand.getId() + "%");
		}
		if (null != brand.getProCategoryId()  && !"".equals(brand.getProCategoryId())) {
		  	criteria.andProCategoryIdLike("%" + brand.getProCategoryId() + "%");
		}
		if (null != brand.getZhName()  && !"".equals(brand.getZhName())) {
		  	criteria.andZhNameLike("%" + brand.getZhName() + "%");
		}
		if (null != brand.getEnName()  && !"".equals(brand.getEnName())) {
		  	criteria.andEnNameLike("%" + brand.getEnName() + "%");
		}
		if (null != brand.getStatus()  && !"".equals(brand.getStatus())) {
		  	criteria.andStatusLike("%" + brand.getStatus() + "%");
		}
		if (null != brand.getWebsite()  && !"".equals(brand.getWebsite())) {
		  	criteria.andWebsiteLike("%" + brand.getWebsite() + "%");
		}
		/*if (null != brand.getUpdateDate()  && !"".equals(brand.getUpdateDate())) {
		  	criteria.andUpdateDateLike("%" + brand.getUpdateDate() + "%");
		}
		if (null != brand.getCreateDate()  && !"".equals(brand.getCreateDate())) {
		  	criteria.andCreateDateLike("%" + brand.getCreateDate() + "%");
		}
		if (null != brand.getDescription()  && !"".equals(brand.getDescription())) {
		  	criteria.andDescriptionLike("%" + brand.getDescription() + "%");
		}
		if (null != brand.getStory()  && !"".equals(brand.getStory())) {
		  	criteria.andStoryLike("%" + brand.getStory() + "%");
		}*/
		page = brandService.select(brandCriteria);
		return page;
	}
	
//	@RequiresPermissions("brand:delete")
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
		int result = brandService.deleteBatch(list);

		return result;
	}
	
	/**
	 * 全部导出Excel.
	 * @param brand
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @throws IOException
	 */
//	@RequiresPermissions("brand:view")
	@RequestMapping(value = "/exportExcel")
	public void exportExcel(@ModelAttribute Brand brand,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		httpServletResponse.setCharacterEncoding("UTF-8");
		String filename = new String("用户信息".getBytes("GBK"), "iso8859-1");

		List<Brand>list = brandService.selectAll();

		List<Map<String, Object>> maps = createExcelRecord(list);

		String columnNames[] = { 
			"Id",
			"ProCategory_id",
			"ZhName",
			"EnName",
			"Status",
			"Website",
			"UpdateDate",
			"CreateDate",
			"Description",
			"Story"
		};// 列名
		String keys[] = { 
			"Id",
			"ProCategory_id",
			"ZhName",
			"EnName",
			"Status",
			"Website",
			"UpdateDate",
			"CreateDate",
			"Description",
			"Story"
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

	private List<Map<String, Object>> createExcelRecord(List<Brand> list) {
		List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sheetName", "sheet1");
		listmap.add(map);
		Brand brand = null;
		for (int j = 0; j < list.size(); j++) {
			brand = list.get(j);
			Map<String, Object> mapValue = new HashMap<String, Object>();
				mapValue.put("Id",brand.getId());
				mapValue.put("ProCategory_id",brand.getProCategoryId());
				mapValue.put("ZhName",brand.getZhName());
				mapValue.put("EnName",brand.getEnName());
				mapValue.put("Status",brand.getStatus());
				mapValue.put("Website",brand.getWebsite());
				mapValue.put("UpdateDate",brand.getUpdateDate());
				mapValue.put("CreateDate",brand.getCreateDate());
//				mapValue.put("Description",brand.getDescription());
//				mapValue.put("Story",brand.getStory());
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
