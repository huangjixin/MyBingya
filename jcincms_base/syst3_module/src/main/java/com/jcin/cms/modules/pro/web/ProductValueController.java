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
import com.jcin.cms.modules.pro.domain.ProductValue;
import com.jcin.cms.modules.pro.domain.ProductValueCriteria;
import com.jcin.cms.modules.pro.service.IProductValueService;
import com.jcin.cms.utils.Page;
import com.jcin.cms.utils.ExcelUtil;
import com.jcin.cms.web.BaseController;

@Controller
@RequestMapping(value = "${adminPath}/productValue")
public class ProductValueController extends BaseController<ProductValue>{
	@Autowired
	private IProductValueService productValueService;

//	@RequiresPermissions("productValue:create")
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(ProductValue productValue, Model uiModel) {
		uiModel.addAttribute("productValue", productValue);
		return root+"admin/modules/productValue/productValue_create.jsp";
	}

//	@RequiresPermissions("productValue:create")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(ProductValue productValue, RedirectAttributes redirectAttributes,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		productValueService.insert(productValue);
		
		redirectAttributes.addFlashAttribute("productValue", productValue);
		redirectAttributes.addFlashAttribute("msg", "新增成功");
		return "redirect:/"+Global.getAdminPath()+"/productValue/create";
	}
	
//	@RequiresPermissions("productValue:update")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String update(@PathVariable("id") String id, Model uiModel) {
		ProductValue productValue = productValueService.selectByPrimaryKey(id);
		uiModel.addAttribute("productValue", productValue);
		return root+"admin/modules/productValue/productValue_update.jsp";
	}

//	@RequiresPermissions("productValue:update")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String update(ProductValue productValue,RedirectAttributes redirectAttributes,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		productValueService.update(productValue);
		
		redirectAttributes.addFlashAttribute("msg", "修改成功");
		redirectAttributes.addFlashAttribute("productValue", productValue);
		return "redirect:/"+Global.getAdminPath()+"/productValue/update/"+productValue.getId();
	}

//	@RequiresPermissions("productValue:show")
	@RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
	public String show(@PathVariable("id") String id, Model uiModel) {
		ProductValue productValue = productValueService.selectByPrimaryKey(id);
		
		uiModel.addAttribute("productValue", productValue);
		return root+"admin/modules/productValue/productValue_show.jsp";
	}

//	@RequiresPermissions("productValue:view")
	@RequestMapping(value = { "", "list" })
	public String list(HttpServletRequest httpServletRequest) {
		return root+"admin/modules/productValue/productValue_list.jsp";
	}

//	@RequiresPermissions("productValue:delete")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
	public String delete(@PathVariable("id") String id, Model uiModel) {
		productValueService.deleteByPrimaryKey(id);
		uiModel.asMap().clear();
		return "redirect:/productValue";
	}

	void populateEditForm(Model uiModel, ProductValue productValue) {
		uiModel.addAttribute("productValue", productValue);
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

//	@RequiresPermissions("productValue:view")
	@RequestMapping(value = "/select")
	@ResponseBody
	public Page select(@ModelAttribute Page page, @ModelAttribute ProductValue productValue,Model uiModel,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		super.select(page, uiModel, httpServletRequest,
				httpServletResponse);
		ProductValueCriteria productValueCriteria = new ProductValueCriteria();
		ProductValueCriteria.Criteria criteria = productValueCriteria.createCriteria();
		productValueCriteria.setPage(page);
		productValueCriteria.setOrderByClause("id desc");
		if (null != productValue.getId()  && !"".equals(productValue.getId())) {
		  	criteria.andIdLike("%" + productValue.getId() + "%");
		}
//		if (null != productValue.getProProduct_id()  && !"".equals(productValue.getProProduct_id())) {
//		  	criteria.andProProduct_idLike("%" + productValue.getProProduct_id() + "%");
//		}
//		if (null != productValue.getProProerties_id()  && !"".equals(productValue.getProProerties_id())) {
//		  	criteria.andProProerties_idLike("%" + productValue.getProProerties_id() + "%");
//		}
//		if (null != productValue.getProValue_id()  && !"".equals(productValue.getProValue_id())) {
//		  	criteria.andProValue_idLike("%" + productValue.getProValue_id() + "%");
//		}
//		if (null != productValue.getIsSku()  && !"".equals(productValue.getIsSku())) {
//		  	criteria.andIsSkuLike("%" + productValue.getIsSku() + "%");
//		}
		if (null != productValue.getSkuId()  && !"".equals(productValue.getSkuId())) {
		  	criteria.andSkuIdLike("%" + productValue.getSkuId() + "%");
		}
		page = productValueService.select(productValueCriteria);
		return page;
	}
	
//	@RequiresPermissions("productValue:delete")
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
		int result = productValueService.deleteBatch(list);

		return result;
	}
	
	/**
	 * 全部导出Excel.
	 * @param productValue
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @throws IOException
	 */
//	@RequiresPermissions("productValue:view")
	@RequestMapping(value = "/exportExcel")
	public void exportExcel(@ModelAttribute ProductValue productValue,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		httpServletResponse.setCharacterEncoding("UTF-8");
		String filename = new String("用户信息".getBytes("GBK"), "iso8859-1");

		List<ProductValue>list = productValueService.selectAll();

		List<Map<String, Object>> maps = createExcelRecord(list);

		String columnNames[] = { 
			"Id",
			"ProProduct_id",
			"ProProerties_id",
			"ProValue_id",
			"IsSku",
			"SkuId"
		};// 列名
		String keys[] = { 
			"Id",
			"ProProduct_id",
			"ProProerties_id",
			"ProValue_id",
			"IsSku",
			"SkuId"
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

	private List<Map<String, Object>> createExcelRecord(List<ProductValue> list) {
		List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sheetName", "sheet1");
		listmap.add(map);
		ProductValue productValue = null;
		for (int j = 0; j < list.size(); j++) {
			productValue = list.get(j);
			Map<String, Object> mapValue = new HashMap<String, Object>();
				mapValue.put("Id",productValue.getId());
//				mapValue.put("ProProduct_id",productValue.getProProduct_id());
//				mapValue.put("ProProerties_id",productValue.getProProerties_id());
//				mapValue.put("ProValue_id",productValue.getProValue_id());
				mapValue.put("IsSku",productValue.getIsSku());
				mapValue.put("SkuId",productValue.getSkuId());
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
