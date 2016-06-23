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
import com.jcin.cms.modules.pro.domain.Order;
import com.jcin.cms.modules.pro.domain.OrderCriteria;
import com.jcin.cms.modules.pro.service.IOrderService;
import com.jcin.cms.utils.Page;
import com.jcin.cms.utils.ExcelUtil;
import com.jcin.cms.web.BaseController;

@Controller
@RequestMapping(value = "${adminPath}/order")
public class OrderController extends BaseController<Order>{
	@Autowired
	private IOrderService orderService;

//	@RequiresPermissions("order:create")
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(Order order, Model uiModel) {
		uiModel.addAttribute("order", order);
		return root+"admin/modules/order/order_create.jsp";
	}

//	@RequiresPermissions("order:create")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(Order order, RedirectAttributes redirectAttributes,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		orderService.insert(order);
		
		redirectAttributes.addFlashAttribute("order", order);
		redirectAttributes.addFlashAttribute("msg", "新增成功");
		return "redirect:/"+Global.getAdminPath()+"/order/create";
	}
	
//	@RequiresPermissions("order:update")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String update(@PathVariable("id") String id, Model uiModel) {
		Order order = orderService.selectByPrimaryKey(id);
		uiModel.addAttribute("order", order);
		return root+"admin/modules/order/order_update.jsp";
	}

//	@RequiresPermissions("order:update")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String update(Order order,RedirectAttributes redirectAttributes,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		orderService.update(order);
		
		redirectAttributes.addFlashAttribute("msg", "修改成功");
		redirectAttributes.addFlashAttribute("order", order);
		return "redirect:/"+Global.getAdminPath()+"/order/update/"+order.getId();
	}

//	@RequiresPermissions("order:show")
	@RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
	public String show(@PathVariable("id") String id, Model uiModel) {
		Order order = orderService.selectByPrimaryKey(id);
		
		uiModel.addAttribute("order", order);
		return root+"admin/modules/order/order_show.jsp";
	}

//	@RequiresPermissions("order:view")
	@RequestMapping(value = { "", "list" })
	public String list(HttpServletRequest httpServletRequest) {
		return root+"admin/modules/order/order_list.jsp";
	}

//	@RequiresPermissions("order:delete")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
	public String delete(@PathVariable("id") String id, Model uiModel) {
		orderService.deleteByPrimaryKey(id);
		uiModel.asMap().clear();
		return "redirect:/order";
	}

	void populateEditForm(Model uiModel, Order order) {
		uiModel.addAttribute("order", order);
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

//	@RequiresPermissions("order:view")
	@RequestMapping(value = "/select")
	@ResponseBody
	public Page select(@ModelAttribute Page page, @ModelAttribute Order order,Model uiModel,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		super.select(page, uiModel, httpServletRequest,
				httpServletResponse);
		OrderCriteria orderCriteria = new OrderCriteria();
		OrderCriteria.Criteria criteria = orderCriteria.createCriteria();
		orderCriteria.setPage(page);
		orderCriteria.setOrderByClause("id desc");
		if (null != order.getId()  && !"".equals(order.getId())) {
		  	criteria.andIdLike("%" + order.getId() + "%");
		}
		if (null != order.getSerialnumber()  && !"".equals(order.getSerialnumber())) {
		  	criteria.andSerialnumberLike("%" + order.getSerialnumber() + "%");
		}
		if (null != order.getOrdercol()  && !"".equals(order.getOrdercol())) {
		  	criteria.andOrdercolLike("%" + order.getOrdercol() + "%");
		}
//		if (null != order.getCreateDate()  && !"".equals(order.getCreateDate())) {
//		  	criteria.andCreateDateLike("%" + order.getCreateDate() + "%");
//		}
//		if (null != order.getUpdateDate()  && !"".equals(order.getUpdateDate())) {
//		  	criteria.andUpdateDateLike("%" + order.getUpdateDate() + "%");
//		}
//		if (null != order.getPaytime()  && !"".equals(order.getPaytime())) {
//		  	criteria.andPaytimeLike("%" + order.getPaytime() + "%");
//		}
		if (null != order.getLogistics()  && !"".equals(order.getLogistics())) {
		  	criteria.andLogisticsLike("%" + order.getLogistics() + "%");
		}
		if (null != order.getStatus()  && !"".equals(order.getStatus())) {
		  	criteria.andStatusLike("%" + order.getStatus() + "%");
		}
		if (null != order.getTitle()  && !"".equals(order.getTitle())) {
		  	criteria.andTitleLike("%" + order.getTitle() + "%");
		}
//		if (null != order.getCounts()  && !"".equals(order.getCounts())) {
//		  	criteria.andCountsLike("%" + order.getCounts() + "%");
//		}
//		if (null != order.getPrice()  && !"".equals(order.getPrice())) {
//		  	criteria.andPriceLike("%" + order.getPrice() + "%");
//		}
//		if (null != order.getAmount()  && !"".equals(order.getAmount())) {
//		  	criteria.andAmountLike("%" + order.getAmount() + "%");
//		}
//		if (null != order.getRealAmount()  && !"".equals(order.getRealAmount())) {
//		  	criteria.andRealAmountLike("%" + order.getRealAmount() + "%");
//		}
//		if (null != order.getDisAmount()  && !"".equals(order.getDisAmount())) {
//		  	criteria.andDisAmountLike("%" + order.getDisAmount() + "%");
//		}
//		if (null != order.getPostage()  && !"".equals(order.getPostage())) {
//		  	criteria.andPostageLike("%" + order.getPostage() + "%");
//		}
//		if (null != order.getHasPostage()  && !"".equals(order.getHasPostage())) {
//		  	criteria.andHasPostageLike("%" + order.getHasPostage() + "%");
//		}
		if (null != order.getBuyerIp()  && !"".equals(order.getBuyerIp())) {
		  	criteria.andBuyerIpLike("%" + order.getBuyerIp() + "%");
		}
		if (null != order.getBuyerAddr()  && !"".equals(order.getBuyerAddr())) {
		  	criteria.andBuyerAddrLike("%" + order.getBuyerAddr() + "%");
		}
		page = orderService.select(orderCriteria);
		return page;
	}
	
//	@RequiresPermissions("order:delete")
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
		int result = orderService.deleteBatch(list);

		return result;
	}
	
	/**
	 * 全部导出Excel.
	 * @param order
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @throws IOException
	 */
//	@RequiresPermissions("order:view")
	@RequestMapping(value = "/exportExcel")
	public void exportExcel(@ModelAttribute Order order,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		httpServletResponse.setCharacterEncoding("UTF-8");
		String filename = new String("用户信息".getBytes("GBK"), "iso8859-1");

		List<Order>list = orderService.selectAll();

		List<Map<String, Object>> maps = createExcelRecord(list);

		String columnNames[] = { 
			"Id",
			"Serialnumber",
			"Ordercol",
			"CreateDate",
			"UpdateDate",
			"Paytime",
			"Logistics",
			"Status",
			"Title",
			"Counts",
			"Price",
			"Amount",
			"RealAmount",
			"DisAmount",
			"Postage",
			"HasPostage",
			"BuyerIp",
			"BuyerAddr"
		};// 列名
		String keys[] = { 
			"Id",
			"Serialnumber",
			"Ordercol",
			"CreateDate",
			"UpdateDate",
			"Paytime",
			"Logistics",
			"Status",
			"Title",
			"Counts",
			"Price",
			"Amount",
			"RealAmount",
			"DisAmount",
			"Postage",
			"HasPostage",
			"BuyerIp",
			"BuyerAddr"
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

	private List<Map<String, Object>> createExcelRecord(List<Order> list) {
		List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sheetName", "sheet1");
		listmap.add(map);
		Order order = null;
		for (int j = 0; j < list.size(); j++) {
			order = list.get(j);
			Map<String, Object> mapValue = new HashMap<String, Object>();
				mapValue.put("Id",order.getId());
				mapValue.put("Serialnumber",order.getSerialnumber());
				mapValue.put("Ordercol",order.getOrdercol());
				mapValue.put("CreateDate",order.getCreateDate());
				mapValue.put("UpdateDate",order.getUpdateDate());
				mapValue.put("Paytime",order.getPaytime());
				mapValue.put("Logistics",order.getLogistics());
				mapValue.put("Status",order.getStatus());
				mapValue.put("Title",order.getTitle());
				mapValue.put("Counts",order.getCounts());
				mapValue.put("Price",order.getPrice());
				mapValue.put("Amount",order.getAmount());
				mapValue.put("RealAmount",order.getRealAmount());
				mapValue.put("DisAmount",order.getDisAmount());
				mapValue.put("Postage",order.getPostage());
				mapValue.put("HasPostage",order.getHasPostage());
				mapValue.put("BuyerIp",order.getBuyerIp());
				mapValue.put("BuyerAddr",order.getBuyerAddr());
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
