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
import com.jcin.cms.modules.sale.domain.Buy;
import com.jcin.cms.modules.sale.domain.BuyCriteria;
import com.jcin.cms.modules.sale.domain.Storage;
import com.jcin.cms.modules.sale.domain.StorageCriteria;
import com.jcin.cms.modules.sale.service.IBuyService;
import com.jcin.cms.modules.sale.service.IStorageService;
import com.jcin.cms.utils.Page;
import com.jcin.cms.utils.ExcelUtil;
import com.jcin.cms.web.BaseController;

@Controller
@RequestMapping(value = "${adminPath}/buy")
public class BuyController extends BaseController<Buy>{
	@Autowired
	private IBuyService buyService;

//	@RequiresPermissions("buy:create")
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(Buy buy, Model uiModel) {
		uiModel.addAttribute("buy", buy);
		return root+"admin/modules/buy/buy_create.jsp";
	}

//	@RequiresPermissions("buy:create")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(Buy buy, RedirectAttributes redirectAttributes,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		buyService.insert(buy);
		
		redirectAttributes.addFlashAttribute("buy", buy);
		redirectAttributes.addFlashAttribute("msg", "新增成功");
		return "redirect:/"+Global.getAdminPath()+"/buy/create";
	}
	
//	@RequiresPermissions("buy:update")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String update(@PathVariable("id") String id, Model uiModel) {
		Buy buy = buyService.selectByPrimaryKey(id);
		uiModel.addAttribute("buy", buy);
		return root+"admin/modules/buy/buy_update.jsp";
	}

//	@RequiresPermissions("buy:update")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String update(Buy buy,RedirectAttributes redirectAttributes,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		buyService.update(buy);
		
		redirectAttributes.addFlashAttribute("msg", "修改成功");
		redirectAttributes.addFlashAttribute("buy", buy);
		return "redirect:/"+Global.getAdminPath()+"/buy/update/"+buy.getId();
	}

//	@RequiresPermissions("buy:show")
	@RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
	public String show(@PathVariable("id") String id, Model uiModel) {
		Buy buy = buyService.selectByPrimaryKey(id);
		
		uiModel.addAttribute("buy", buy);
		return root+"admin/modules/buy/buy_show.jsp";
	}

//	@RequiresPermissions("buy:view")
	@RequestMapping(value = { "", "list" })
	public String list(HttpServletRequest httpServletRequest) {
		return root+"admin/modules/buy/buy_list.jsp";
	}

//	@RequiresPermissions("buy:delete")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
	public String delete(@PathVariable("id") String id, Model uiModel) {
		buyService.deleteByPrimaryKey(id);
		uiModel.asMap().clear();
		return "redirect:/buy";
	}

	void populateEditForm(Model uiModel, Buy buy) {
		uiModel.addAttribute("buy", buy);
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

//	@RequiresPermissions("buy:view")
	@RequestMapping(value = "/select")
	@ResponseBody
	public Page select(@ModelAttribute Page page, @ModelAttribute Buy buy,Model uiModel,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		super.select(page, uiModel, httpServletRequest,
				httpServletResponse);
		BuyCriteria buyCriteria = new BuyCriteria();
		BuyCriteria.Criteria criteria = buyCriteria.createCriteria();
		buyCriteria.setPage(page);
		buyCriteria.setOrderByClause("id desc");
		/*if (null != buy.getId()  && !"".equals(buy.getId())) {
		  	criteria.andIdLike("%" + buy.getId() + "%");
		}*/
		if (null != buy.getProName()  && !"".equals(buy.getProName())) {
			criteria.andProNameLike("%" + buy.getProName() + "%");
		}
		/*if (null != buy.getCreateDate()  && !"".equals(buy.getCreateDate())) {
		  	criteria.andCreateDateLike("%" + buy.getCreateDate() + "%");
		}
		if (null != buy.getCreateBy()  && !"".equals(buy.getCreateBy())) {
		  	criteria.andCreateByLike("%" + buy.getCreateBy() + "%");
		}
		if (null != buy.getProId()  && !"".equals(buy.getProId())) {
		  	criteria.andProIdLike("%" + buy.getProId() + "%");
		}*/
		/*if (null != buy.getBuyNum()  && !"".equals(buy.getBuyNum())) {
		  	criteria.andBuyNumLike("%" + buy.getBuyNum() + "%");
		}
		if (null != buy.getBuyAmount()  && !"".equals(buy.getBuyAmount())) {
		  	criteria.andBuyAmountLike("%" + buy.getBuyAmount() + "%");
		}
		if (null != buy.getTotalAmount()  && !"".equals(buy.getTotalAmount())) {
		  	criteria.andTotalAmountLike("%" + buy.getTotalAmount() + "%");
		}*/
		page = buyService.select(buyCriteria);
		return page;
	}
	
//	@RequiresPermissions("buy:delete")
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
		int result = buyService.deleteBatch(list);

		return result;
	}
	
	/**
	 * 全部导出Excel.
	 * @param buy
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @throws IOException
	 */
//	@RequiresPermissions("buy:view")
	@RequestMapping(value = "/exportExcel")
	public void exportExcel(@ModelAttribute Buy buy,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		httpServletResponse.setCharacterEncoding("UTF-8");
		String filename = new String("用户信息".getBytes("GBK"), "iso8859-1");

		List<Buy>list = buyService.selectAll();

		List<Map<String, Object>> maps = createExcelRecord(list);

		String columnNames[] = { 
			"Id",
			"CreateDate",
			"CreateBy",
			"ProId",
			"BuyNum",
			"BuyAmount",
			"TotalAmount"
		};// 列名
		String keys[] = { 
			"Id",
			"CreateDate",
			"CreateBy",
			"ProId",
			"BuyNum",
			"BuyAmount",
			"TotalAmount"
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

	private List<Map<String, Object>> createExcelRecord(List<Buy> list) {
		List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sheetName", "sheet1");
		listmap.add(map);
		Buy buy = null;
		for (int j = 0; j < list.size(); j++) {
			buy = list.get(j);
			Map<String, Object> mapValue = new HashMap<String, Object>();
				mapValue.put("Id",buy.getId());
				mapValue.put("CreateDate",buy.getCreateDate());
				mapValue.put("CreateBy",buy.getCreateBy());
				mapValue.put("ProId",buy.getProId());
				mapValue.put("BuyNum",buy.getBuyNum());
				mapValue.put("BuyAmount",buy.getBuyAmount());
				mapValue.put("TotalAmount",buy.getTotalAmount());
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
