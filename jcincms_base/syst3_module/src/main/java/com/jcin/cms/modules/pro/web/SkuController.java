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
import com.jcin.cms.modules.pro.domain.Sku;
import com.jcin.cms.modules.pro.domain.SkuCriteria;
import com.jcin.cms.modules.pro.service.ISkuService;
import com.jcin.cms.utils.Page;
import com.jcin.cms.utils.ExcelUtil;
import com.jcin.cms.web.BaseController;

@Controller
@RequestMapping(value = "${adminPath}/sku")
public class SkuController extends BaseController<Sku>{
	@Autowired
	private ISkuService skuService;

//	@RequiresPermissions("sku:create")
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(Sku sku, Model uiModel) {
		uiModel.addAttribute("sku", sku);
		return root+"admin/modules/sku/sku_create.jsp";
	}

//	@RequiresPermissions("sku:create")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(Sku sku, RedirectAttributes redirectAttributes,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		skuService.insert(sku);
		
		redirectAttributes.addFlashAttribute("sku", sku);
		redirectAttributes.addFlashAttribute("msg", "新增成功");
		return "redirect:/"+Global.getAdminPath()+"/sku/create";
	}
	
//	@RequiresPermissions("sku:update")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String update(@PathVariable("id") String id, Model uiModel) {
		Sku sku = skuService.selectByPrimaryKey(id);
		uiModel.addAttribute("sku", sku);
		return root+"admin/modules/sku/sku_update.jsp";
	}

//	@RequiresPermissions("sku:update")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String update(Sku sku,RedirectAttributes redirectAttributes,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		skuService.update(sku);
		
		redirectAttributes.addFlashAttribute("msg", "修改成功");
		redirectAttributes.addFlashAttribute("sku", sku);
		return "redirect:/"+Global.getAdminPath()+"/sku/update/"+sku.getId();
	}

//	@RequiresPermissions("sku:show")
	@RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
	public String show(@PathVariable("id") String id, Model uiModel) {
		Sku sku = skuService.selectByPrimaryKey(id);
		
		uiModel.addAttribute("sku", sku);
		return root+"admin/modules/sku/sku_show.jsp";
	}

//	@RequiresPermissions("sku:view")
	@RequestMapping(value = { "", "list" })
	public String list(HttpServletRequest httpServletRequest) {
		return root+"admin/modules/sku/sku_list.jsp";
	}

//	@RequiresPermissions("sku:delete")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
	public String delete(@PathVariable("id") String id, Model uiModel) {
		skuService.deleteByPrimaryKey(id);
		uiModel.asMap().clear();
		return "redirect:/sku";
	}

	void populateEditForm(Model uiModel, Sku sku) {
		uiModel.addAttribute("sku", sku);
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

//	@RequiresPermissions("sku:view")
	@RequestMapping(value = "/select")
	@ResponseBody
	public Page select(@ModelAttribute Page page, @ModelAttribute Sku sku,Model uiModel,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		super.select(page, uiModel, httpServletRequest,
				httpServletResponse);
		SkuCriteria skuCriteria = new SkuCriteria();
		SkuCriteria.Criteria criteria = skuCriteria.createCriteria();
		skuCriteria.setPage(page);
		skuCriteria.setOrderByClause("id desc");
		if (null != sku.getId()  && !"".equals(sku.getId())) {
		  	criteria.andIdLike("%" + sku.getId() + "%");
		}
		if (null != sku.getProductId()  && !"".equals(sku.getProductId())) {
		  	criteria.andProductIdLike("%" + sku.getProductId() + "%");
		}
//		if (null != sku.getCounts()  && !"".equals(sku.getCounts())) {
//		  	criteria.andCountsLike("%" + sku.getCounts() + "%");
//		}
//		if (null != sku.getPrice()  && !"".equals(sku.getPrice())) {
//		  	criteria.andPriceLike("%" + sku.getPrice() + "%");
//		}
		if (null != sku.getName()  && !"".equals(sku.getName())) {
		  	criteria.andNameLike("%" + sku.getName() + "%");
		}
		if (null != sku.getStatus()  && !"".equals(sku.getStatus())) {
		  	criteria.andStatusLike("%" + sku.getStatus() + "%");
		}
		page = skuService.select(skuCriteria);
		return page;
	}
	
//	@RequiresPermissions("sku:delete")
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
		int result = skuService.deleteBatch(list);

		return result;
	}
	
	/**
	 * 全部导出Excel.
	 * @param sku
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @throws IOException
	 */
//	@RequiresPermissions("sku:view")
	@RequestMapping(value = "/exportExcel")
	public void exportExcel(@ModelAttribute Sku sku,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		httpServletResponse.setCharacterEncoding("UTF-8");
		String filename = new String("用户信息".getBytes("GBK"), "iso8859-1");

		List<Sku>list = skuService.selectAll();

		List<Map<String, Object>> maps = createExcelRecord(list);

		String columnNames[] = { 
			"Id",
			"ProductId",
			"Counts",
			"Price",
			"Name",
			"Status"
		};// 列名
		String keys[] = { 
			"Id",
			"ProductId",
			"Counts",
			"Price",
			"Name",
			"Status"
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

	private List<Map<String, Object>> createExcelRecord(List<Sku> list) {
		List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sheetName", "sheet1");
		listmap.add(map);
		Sku sku = null;
		for (int j = 0; j < list.size(); j++) {
			sku = list.get(j);
			Map<String, Object> mapValue = new HashMap<String, Object>();
				mapValue.put("Id",sku.getId());
				mapValue.put("ProductId",sku.getProductId());
				mapValue.put("Counts",sku.getCounts());
				mapValue.put("Price",sku.getPrice());
				mapValue.put("Name",sku.getName());
				mapValue.put("Status",sku.getStatus());
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
