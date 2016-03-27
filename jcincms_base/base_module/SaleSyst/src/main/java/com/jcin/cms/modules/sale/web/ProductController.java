/**
 * 一句话描述该类：前端控制器，提供页面跳转，访问方法返回JSON<br/>
 * @author 黄记新 <br/>
 * @date 2015-4-29,10:52 <br/>
 *
 */
package com.jcin.cms.modules.sale.web;

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
import com.jcin.cms.modules.sale.domain.Buy;
import com.jcin.cms.modules.sale.domain.BuyCriteria;
import com.jcin.cms.modules.sale.domain.Product;
import com.jcin.cms.modules.sale.domain.ProductCriteria;
import com.jcin.cms.modules.sale.domain.Sale;
import com.jcin.cms.modules.sale.domain.SaleCriteria;
import com.jcin.cms.modules.sale.service.IBuyService;
import com.jcin.cms.modules.sale.service.IProductService;
import com.jcin.cms.modules.sale.service.ISaleService;
import com.jcin.cms.utils.ExcelUtil;
import com.jcin.cms.utils.Page;
import com.jcin.cms.web.BaseController;

@Controller
@RequestMapping(value = "${adminPath}/product")
public class ProductController extends BaseController<Product>{
	@Autowired
	private IProductService productService;
	@Autowired
	private IBuyService buyService;
	@Autowired
	private ISaleService saleService;

//	@RequiresPermissions("product:create")
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(Product product, Model uiModel) {
		uiModel.addAttribute("product", product);
		return root+"admin/modules/product/product_create.jsp";
	}
	
	@RequestMapping(value = "/salequery", method = RequestMethod.GET)
	public String salequery(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		return root+"admin/modules/product/salequery.jsp";
	}

//	@RequiresPermissions("product:create")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(Product product, RedirectAttributes redirectAttributes,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		productService.insert(product);
		
		redirectAttributes.addFlashAttribute("product", product);
		redirectAttributes.addFlashAttribute("msg", "新增成功");
		return "redirect:/"+Global.getAdminPath()+"/product/create";
	}
	
//	@RequiresPermissions("product:update")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String update(@PathVariable("id") String id, Model uiModel) {
		Product product = productService.selectByPrimaryKey(id);
		uiModel.addAttribute("product", product);
		return root+"admin/modules/product/product_update.jsp";
	}

//	@RequiresPermissions("product:update")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String update(Product product,RedirectAttributes redirectAttributes,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		productService.update(product);
		
		redirectAttributes.addFlashAttribute("msg", "修改成功");
		redirectAttributes.addFlashAttribute("product", product);
		return "redirect:/"+Global.getAdminPath()+"/product/update/"+product.getId();
	}

//	@RequiresPermissions("product:show")
	@RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
	public String show(@PathVariable("id") String id, Model uiModel) {
		Product product = productService.selectByPrimaryKey(id);
		
		uiModel.addAttribute("product", product);
		return root+"admin/modules/product/product_show.jsp";
	}

//	@RequiresPermissions("product:view")
	@RequestMapping(value = { "", "list" })
	public String list(HttpServletRequest httpServletRequest) {
		return root+"admin/modules/product/product_list.jsp";
	}

//	@RequiresPermissions("product:delete")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
	public String delete(@PathVariable("id") String id, Model uiModel) {
		productService.deleteByPrimaryKey(id);
		uiModel.asMap().clear();
		return "redirect:/product";
	}

	void populateEditForm(Model uiModel, Product product) {
		uiModel.addAttribute("product", product);
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

//	@RequiresPermissions("product:view")
	@RequestMapping(value = "/select")
	@ResponseBody
	public Page select(@ModelAttribute Page page, @ModelAttribute Product product,Model uiModel,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		if("".equals(product.getName())){
			product.setName(null);
		}
		super.select(page, uiModel, httpServletRequest,
				httpServletResponse);
		ProductCriteria productCriteria = new ProductCriteria();
		ProductCriteria.Criteria criteria = productCriteria.createCriteria();
		productCriteria.setPage(page);
		productCriteria.setOrderByClause("id desc");
		if (null != product.getId()  && !"".equals(product.getId())) {
		  	criteria.andIdLike("%" + product.getId() + "%");
		}
		if (null != product.getName()  && !"".equals(product.getName())) {
		  	criteria.andNameLike("%" + product.getName() + "%");
		}
		/*if (null != product.getCreateDate()  && !"".equals(product.getCreateDate())) {
		  	criteria.andCreateDateLike("%" + product.getCreateDate() + "%");
		}*/
		if (null != product.getCreateBy()  && !"".equals(product.getCreateBy())) {
		  	criteria.andCreateByLike("%" + product.getCreateBy() + "%");
		}
		if (null != product.getParentId()  && !"".equals(product.getParentId())) {
		  	criteria.andParentIdLike("%" + product.getParentId() + "%");
		}
		if (null != product.getDescription()  && !"".equals(product.getDescription())) {
		  	criteria.andDescriptionLike("%" + product.getDescription() + "%");
		}
		page = productService.selectProByExample(product,productCriteria);
		return page;
	}
	
	@RequestMapping(value = "/tongji")
	@ResponseBody
	public Page tongji(@ModelAttribute Page page, @ModelAttribute Product product,Model uiModel,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		super.select(page, uiModel, httpServletRequest,
				httpServletResponse);
		ProductCriteria productCriteria = new ProductCriteria();
		ProductCriteria.Criteria criteria = productCriteria.createCriteria();
		productCriteria.setPage(page);
		/*if (null != product.getName()  && !"".equals(product.getName())) {
			criteria.andNameLike("%" + product.getName() + "%");
		}*/
		if("".equals(product.getName())){
			product.setName(null);
		}
		page = productService.selectTongjiByExample(product, productCriteria);
		return page;
	}
	
//	@RequiresPermissions("product:delete")
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
		int result = productService.deleteBatch(list);

		return result;
	}
	
	/**
	 * 全部导出Excel.
	 * @param product
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @throws IOException
	 */
//	@RequiresPermissions("product:view")
	@RequestMapping(value = "/exportExcel")
	public void exportExcel(@ModelAttribute Product product,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		httpServletResponse.setCharacterEncoding("UTF-8");
		String filename = new String("用户信息".getBytes("GBK"), "iso8859-1");

		List<Product>list = productService.selectAll();

		List<Map<String, Object>> maps = createExcelRecord(list);

		String columnNames[] = { 
			"Id",
			"Name",
			"CreateDate",
			"CreateBy",
			"ParentId",
			"Description"
		};// 列名
		String keys[] = { 
			"Id",
			"Name",
			"CreateDate",
			"CreateBy",
			"ParentId",
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

	private List<Map<String, Object>> createExcelRecord(List<Product> list) {
		List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sheetName", "sheet1");
		listmap.add(map);
		Product product = null;
		for (int j = 0; j < list.size(); j++) {
			product = list.get(j);
			Map<String, Object> mapValue = new HashMap<String, Object>();
				mapValue.put("Id",product.getId());
				mapValue.put("Name",product.getName());
				mapValue.put("CreateDate",product.getCreateDate());
				mapValue.put("CreateBy",product.getCreateBy());
				mapValue.put("ParentId",product.getParentId());
				mapValue.put("Description",product.getDescription());
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
