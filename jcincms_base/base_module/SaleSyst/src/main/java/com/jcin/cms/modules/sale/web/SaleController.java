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
import com.jcin.cms.modules.sale.domain.Sale;
import com.jcin.cms.modules.sale.domain.SaleCriteria;
import com.jcin.cms.modules.sale.service.ISaleService;
import com.jcin.cms.utils.ExcelUtil;
import com.jcin.cms.utils.Page;
import com.jcin.cms.web.BaseController;

@Controller
@RequestMapping(value = "${adminPath}/sale")
public class SaleController extends BaseController<Sale>{
	@Autowired
	private ISaleService saleService;

//	@RequiresPermissions("sale:create")
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(Sale sale, Model uiModel) {
		uiModel.addAttribute("sale", sale);
		return root+"admin/modules/sale/sale_create.jsp";
	}

//	@RequiresPermissions("sale:create")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(Sale sale, RedirectAttributes redirectAttributes,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		saleService.insert(sale);
		
		redirectAttributes.addFlashAttribute("sale", sale);
		redirectAttributes.addFlashAttribute("msg", "新增成功");
		return "redirect:/"+Global.getAdminPath()+"/sale/create";
	}
	
//	@RequiresPermissions("sale:update")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String update(@PathVariable("id") String id, Model uiModel) {
		Sale sale = saleService.selectByPrimaryKey(id);
		uiModel.addAttribute("sale", sale);
		return root+"admin/modules/sale/sale_update.jsp";
	}

//	@RequiresPermissions("sale:update")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String update(Sale sale,RedirectAttributes redirectAttributes,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		saleService.update(sale);
		
		redirectAttributes.addFlashAttribute("msg", "修改成功");
		redirectAttributes.addFlashAttribute("sale", sale);
		return "redirect:/"+Global.getAdminPath()+"/sale/update/"+sale.getId();
	}

//	@RequiresPermissions("sale:show")
	@RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
	public String show(@PathVariable("id") String id, Model uiModel) {
		Sale sale = saleService.selectByPrimaryKey(id);
		
		uiModel.addAttribute("sale", sale);
		return root+"admin/modules/sale/sale_show.jsp";
	}

//	@RequiresPermissions("sale:view")
	@RequestMapping(value = { "", "list" })
	public String list(HttpServletRequest httpServletRequest) {
		return root+"admin/modules/sale/sale_list.jsp";
	}

//	@RequiresPermissions("sale:delete")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
	public String delete(@PathVariable("id") String id, Model uiModel) {
		saleService.deleteByPrimaryKey(id);
		uiModel.asMap().clear();
		return "redirect:/sale";
	}

	void populateEditForm(Model uiModel, Sale sale) {
		uiModel.addAttribute("sale", sale);
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

//	@RequiresPermissions("sale:view")
	@RequestMapping(value = "/select")
	@ResponseBody
	public Page select(@ModelAttribute Page page, @ModelAttribute Sale sale,Model uiModel,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		super.select(page, uiModel, httpServletRequest,
				httpServletResponse);
		SaleCriteria saleCriteria = new SaleCriteria();
		SaleCriteria.Criteria criteria = saleCriteria.createCriteria();
		saleCriteria.setPage(page);
		saleCriteria.setOrderByClause("id desc");
		if (null != sale.getProName()  && !"".equals(sale.getProName())) {
			criteria.andProNameLike("%" + sale.getProName() + "%");
		}
		
		/*if (null != sale.getId()  && !"".equals(sale.getId())) {
		  	criteria.andIdLike("%" + sale.getId() + "%");
		}
		if (null != sale.getProId()  && !"".equals(sale.getProId())) {
		  	criteria.andProIdLike("%" + sale.getProId() + "%");
		}*/
//		if (null != sale.getSaleAmount()  && !"".equals(sale.getSaleAmount())) {
//		  	criteria.andSaleAmountLike("%" + sale.getSaleAmount() + "%");
//		}
//		if (null != sale.getTotalAmount()  && !"".equals(sale.getTotalAmount())) {
//		  	criteria.andTotalAmountLike("%" + sale.getTotalAmount() + "%");
//		}
//		if (null != sale.getCreateDate()  && !"".equals(sale.getCreateDate())) {
//		  	criteria.andCreateDateLike("%" + sale.getCreateDate() + "%");
//		}
		if (null != sale.getCreateBy()  && !"".equals(sale.getCreateBy())) {
		  	criteria.andCreateByLike("%" + sale.getCreateBy() + "%");
		}
//		if (null != sale.getSaleNum()  && !"".equals(sale.getSaleNum())) {
//		  	criteria.andSaleNumLike("%" + sale.getSaleNum() + "%");
//		}
		page = saleService.select(saleCriteria);
		return page;
	}
	
//	@RequiresPermissions("sale:delete")
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
		int result = saleService.deleteBatch(list);

		return result;
	}
	
	/**
	 * 全部导出Excel.
	 * @param sale
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @throws IOException
	 */
//	@RequiresPermissions("sale:view")
	@RequestMapping(value = "/exportExcel")
	public void exportExcel(@ModelAttribute Sale sale,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		httpServletResponse.setCharacterEncoding("UTF-8");
		String filename = new String("用户信息".getBytes("GBK"), "iso8859-1");

		List<Sale>list = saleService.selectAll();

		List<Map<String, Object>> maps = createExcelRecord(list);

		String columnNames[] = { 
			"Id",
			"ProId",
			"SaleAmount",
			"TotalAmount",
			"CreateDate",
			"CreateBy",
			"SaleNum"
		};// 列名
		String keys[] = { 
			"Id",
			"ProId",
			"SaleAmount",
			"TotalAmount",
			"CreateDate",
			"CreateBy",
			"SaleNum"
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

	private List<Map<String, Object>> createExcelRecord(List<Sale> list) {
		List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sheetName", "sheet1");
		listmap.add(map);
		Sale sale = null;
		for (int j = 0; j < list.size(); j++) {
			sale = list.get(j);
			Map<String, Object> mapValue = new HashMap<String, Object>();
				mapValue.put("Id",sale.getId());
				mapValue.put("ProId",sale.getProId());
				mapValue.put("SaleAmount",sale.getSaleAmount());
				mapValue.put("TotalAmount",sale.getTotalAmount());
				mapValue.put("CreateDate",sale.getCreateDate());
				mapValue.put("CreateBy",sale.getCreateBy());
				mapValue.put("SaleNum",sale.getSaleNum());
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
