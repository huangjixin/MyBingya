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
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.jcin.cms.modules.pro.domain.Category;
import com.jcin.cms.modules.pro.domain.CategoryCriteria;
import com.jcin.cms.modules.pro.service.ICategoryService;
import com.jcin.cms.utils.Page;
import com.jcin.cms.utils.ExcelUtil;
import com.jcin.cms.web.BaseController;

@Controller
@RequestMapping(value = "${adminPath}/category")
public class CategoryController extends BaseController<Category>{
	
	@Autowired
	private ICategoryService categoryService;

//	@RequiresPermissions("category:create")
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(Category category, Model uiModel) {
		uiModel.addAttribute("category", category);
		return root+"admin/modules/category/category_create.jsp";
	}

//	@RequiresPermissions("category:create")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(Category category, RedirectAttributes redirectAttributes,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		categoryService.insert(category);
		
		redirectAttributes.addFlashAttribute("category", category);
		redirectAttributes.addFlashAttribute("msg", "新增成功");
		return "redirect:/"+Global.getAdminPath()+"/category/create";
	}
	
//	@RequiresPermissions("category:update")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String update(@PathVariable("id") String id, Model uiModel) {
		Category category = categoryService.selectByPrimaryKey(id);
		uiModel.addAttribute("category", category);
		return root+"admin/modules/category/category_update.jsp";
	}

//	@RequiresPermissions("category:update")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String update(Category category,RedirectAttributes redirectAttributes,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		if (category.getId().equals(category.getParentId())) {
			redirectAttributes.addFlashAttribute("category", category);
			redirectAttributes.addFlashAttribute("msg", "父亲节点不应该为本身");
			return "redirect:/" + Global.getAdminPath() + "/category/update/"
					+ category.getId();
		}
		
		categoryService.update(category);
		
		redirectAttributes.addFlashAttribute("msg", "修改成功");
		redirectAttributes.addFlashAttribute("category", category);
		return "redirect:/"+Global.getAdminPath()+"/category/update/"+category.getId();
	}

//	@RequiresPermissions("category:show")
	@RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
	public String show(@PathVariable("id") String id, Model uiModel) {
		Category category = categoryService.selectByPrimaryKey(id);
		
		uiModel.addAttribute("category", category);
		return root+"admin/modules/category/category_show.jsp";
	}

//	@RequiresPermissions("category:view")
	@RequestMapping(value = { "", "list" })
	public String list(HttpServletRequest httpServletRequest) {
		return root+"admin/modules/category/category_list.jsp";
	}

//	@RequiresPermissions("category:delete")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
	public String delete(@PathVariable("id") String id, Model uiModel) {
		categoryService.deleteByPrimaryKey(id);
		uiModel.asMap().clear();
		return "redirect:/category";
	}

	void populateEditForm(Model uiModel, Category category) {
		uiModel.addAttribute("category", category);
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
	
	@RequestMapping(value = "/getCategoryTree")
	@ResponseBody
	public List<Category> getCategoryTree(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) {
		List<Category> categories = categoryService.getCategoryTree();
		return categories;
	}
	
//	@RequiresPermissions("category:view")
	@RequestMapping(value = "/select")
	@ResponseBody
	public Page select(@ModelAttribute Page page, @ModelAttribute Category category,Model uiModel,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		super.select(page, uiModel, httpServletRequest,
				httpServletResponse);
		CategoryCriteria categoryCriteria = new CategoryCriteria();
		CategoryCriteria.Criteria criteria = categoryCriteria.createCriteria();
		categoryCriteria.setPage(page);
		categoryCriteria.setOrderByClause("id desc");
		if (null != category.getId()  && !"".equals(category.getId())) {
		  	criteria.andIdLike("%" + category.getId() + "%");
		}
		if (null != category.getName()  && !"".equals(category.getName())) {
		  	criteria.andNameLike("%" + category.getName() + "%");
		}
		if (null != category.getParentId()  && !"".equals(category.getParentId())) {
		  	criteria.andParentIdLike("%" + category.getParentId() + "%");
		}
		/*if (null != category.getSortid()  && !"".equals(category.getSortid())) {
		  	criteria.andSortidLike("%" + category.getSortid() + "%");
		}
		if (null != category.getCreateDate()  && !"".equals(category.getCreateDate())) {
		  	criteria.andCreateDateLike("%" + category.getCreateDate() + "%");
		}
		if (null != category.getUpdateDate()  && !"".equals(category.getUpdateDate())) {
		  	criteria.andUpdateDateLike("%" + category.getUpdateDate() + "%");
		}
		if (null != category.getIsParent()  && !"".equals(category.getIsParent())) {
		  	criteria.andIsParentLike("%" + category.getIsParent() + "%");
		}*/
		page = categoryService.select(categoryCriteria);
		return page;
	}
	
//	@RequiresPermissions("category:delete")
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
		int result = categoryService.deleteBatch(list);

		return result;
	}
	
	/**
	 * 全部导出Excel.
	 * @param category
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @throws IOException
	 */
//	@RequiresPermissions("category:view")
	@RequestMapping(value = "/exportExcel")
	public void exportExcel(@ModelAttribute Category category,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		httpServletResponse.setCharacterEncoding("UTF-8");
		String filename = new String("用户信息".getBytes("GBK"), "iso8859-1");

		List<Category>list = categoryService.selectAll();

		List<Map<String, Object>> maps = createExcelRecord(list);

		String columnNames[] = { 
			"Id",
			"Name",
			"ParentId",
			"Sortid",
			"CreateDate",
			"UpdateDate",
			"IsParent"
		};// 列名
		String keys[] = { 
			"Id",
			"Name",
			"ParentId",
			"Sortid",
			"CreateDate",
			"UpdateDate",
			"IsParent"
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

	private List<Map<String, Object>> createExcelRecord(List<Category> list) {
		List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sheetName", "sheet1");
		listmap.add(map);
		Category category = null;
		for (int j = 0; j < list.size(); j++) {
			category = list.get(j);
			Map<String, Object> mapValue = new HashMap<String, Object>();
				mapValue.put("Id",category.getId());
				mapValue.put("Name",category.getName());
				mapValue.put("ParentId",category.getParentId());
				mapValue.put("Sortid",category.getSortid());
				mapValue.put("CreateDate",category.getCreateDate());
				mapValue.put("UpdateDate",category.getUpdateDate());
				mapValue.put("IsParent",category.getIsParent());
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
