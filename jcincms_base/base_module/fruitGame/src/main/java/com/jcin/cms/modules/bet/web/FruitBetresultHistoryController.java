/**
 * 一句话描述该类：前端控制器，提供页面跳转，访问方法返回JSON<br/>
 * @author 黄记新 <br/>
 * @date 2015-4-29,10:52 <br/>
 *
 */
package com.jcin.cms.modules.bet.web;

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
import com.jcin.cms.modules.bet.domain.FruitBetresultHistory;
import com.jcin.cms.modules.bet.domain.FruitBetresultHistoryCriteria;
import com.jcin.cms.modules.bet.service.IFruitBetresultHistoryService;
import com.jcin.cms.utils.Page;
import com.jcin.cms.utils.ExcelUtil;
import com.jcin.cms.web.BaseController;

@Controller
@RequestMapping(value = "${adminPath}/fruitBetresultHistory")
public class FruitBetresultHistoryController extends BaseController<FruitBetresultHistory>{
	@Autowired
	private IFruitBetresultHistoryService fruitBetresultHistoryService;

//	@RequiresPermissions("fruitBetresultHistory:create")
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(FruitBetresultHistory fruitBetresultHistory, Model uiModel) {
		uiModel.addAttribute("fruitBetresultHistory", fruitBetresultHistory);
		return root+"admin/modules/fruitBetresultHistory/fruitBetresultHistory_create.jsp";
	}

//	@RequiresPermissions("fruitBetresultHistory:create")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(FruitBetresultHistory fruitBetresultHistory, RedirectAttributes redirectAttributes,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		fruitBetresultHistoryService.insert(fruitBetresultHistory);
		
		redirectAttributes.addFlashAttribute("fruitBetresultHistory", fruitBetresultHistory);
		redirectAttributes.addFlashAttribute("msg", "新增成功");
		return "redirect:/"+Global.getAdminPath()+"/fruitBetresultHistory/create";
	}
	
//	@RequiresPermissions("fruitBetresultHistory:update")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String update(@PathVariable("id") String id, Model uiModel) {
		FruitBetresultHistory fruitBetresultHistory = fruitBetresultHistoryService.selectByPrimaryKey(id);
		uiModel.addAttribute("fruitBetresultHistory", fruitBetresultHistory);
		return root+"admin/modules/fruitBetresultHistory/fruitBetresultHistory_update.jsp";
	}

//	@RequiresPermissions("fruitBetresultHistory:update")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String update(FruitBetresultHistory fruitBetresultHistory,RedirectAttributes redirectAttributes,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		fruitBetresultHistoryService.update(fruitBetresultHistory);
		
		redirectAttributes.addFlashAttribute("msg", "修改成功");
		redirectAttributes.addFlashAttribute("fruitBetresultHistory", fruitBetresultHistory);
		return "redirect:/"+Global.getAdminPath()+"/fruitBetresultHistory/update/"+fruitBetresultHistory.getId();
	}

//	@RequiresPermissions("fruitBetresultHistory:show")
	@RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
	public String show(@PathVariable("id") String id, Model uiModel) {
		FruitBetresultHistory fruitBetresultHistory = fruitBetresultHistoryService.selectByPrimaryKey(id);
		
		uiModel.addAttribute("fruitBetresultHistory", fruitBetresultHistory);
		return root+"admin/modules/fruitBetresultHistory/fruitBetresultHistory_show.jsp";
	}

//	@RequiresPermissions("fruitBetresultHistory:view")
	@RequestMapping(value = { "", "list" })
	public String list(HttpServletRequest httpServletRequest) {
		return root+"admin/modules/fruitBetresultHistory/fruitBetresultHistory_list.jsp";
	}

//	@RequiresPermissions("fruitBetresultHistory:delete")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
	public String delete(@PathVariable("id") String id, Model uiModel) {
		fruitBetresultHistoryService.deleteByPrimaryKey(id);
		uiModel.asMap().clear();
		return "redirect:/fruitBetresultHistory";
	}

	void populateEditForm(Model uiModel, FruitBetresultHistory fruitBetresultHistory) {
		uiModel.addAttribute("fruitBetresultHistory", fruitBetresultHistory);
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

//	@RequiresPermissions("fruitBetresultHistory:view")
	@RequestMapping(value = "/select")
	@ResponseBody
	public Page select(@ModelAttribute Page page, @ModelAttribute FruitBetresultHistory fruitBetresultHistory,Model uiModel,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		super.select(page, uiModel, httpServletRequest,
				httpServletResponse);
		FruitBetresultHistoryCriteria fruitBetresultHistoryCriteria = new FruitBetresultHistoryCriteria();
		FruitBetresultHistoryCriteria.Criteria criteria = fruitBetresultHistoryCriteria.createCriteria();
		fruitBetresultHistoryCriteria.setPage(page);
		fruitBetresultHistoryCriteria.setOrderByClause("id desc");
		if (null != fruitBetresultHistory.getId()  && !"".equals(fruitBetresultHistory.getId())) {
		  	criteria.andIdLike("%" + fruitBetresultHistory.getId() + "%");
		}
//		if (null != fruitBetresultHistory.getCreateDate()  && !"".equals(fruitBetresultHistory.getCreateDate())) {
//		  	criteria.andCreateDateLike("%" + fruitBetresultHistory.getCreateDate() + "%");
//		}
		if (null != fruitBetresultHistory.getCreateBy()  && !"".equals(fruitBetresultHistory.getCreateBy())) {
		  	criteria.andCreateByLike("%" + fruitBetresultHistory.getCreateBy() + "%");
		}
//		if (null != fruitBetresultHistory.getUpdateDate()  && !"".equals(fruitBetresultHistory.getUpdateDate())) {
//		  	criteria.andUpdateDateLike("%" + fruitBetresultHistory.getUpdateDate() + "%");
//		}
		if (null != fruitBetresultHistory.getUpdateBy()  && !"".equals(fruitBetresultHistory.getUpdateBy())) {
		  	criteria.andUpdateByLike("%" + fruitBetresultHistory.getUpdateBy() + "%");
		}
		/*if (null != fruitBetresultHistory.getDa()  && !"".equals(fruitBetresultHistory.getDa())) {
		  	criteria.andDaLike("%" + fruitBetresultHistory.getDa() + "%");
		}
		if (null != fruitBetresultHistory.getXiao()  && !"".equals(fruitBetresultHistory.getXiao())) {
		  	criteria.andXiaoLike("%" + fruitBetresultHistory.getXiao() + "%");
		}
		if (null != fruitBetresultHistory.getDan()  && !"".equals(fruitBetresultHistory.getDan())) {
		  	criteria.andDanLike("%" + fruitBetresultHistory.getDan() + "%");
		}
		if (null != fruitBetresultHistory.getShuang()  && !"".equals(fruitBetresultHistory.getShuang())) {
		  	criteria.andShuangLike("%" + fruitBetresultHistory.getShuang() + "%");
		}
		if (null != fruitBetresultHistory.getPingguo()  && !"".equals(fruitBetresultHistory.getPingguo())) {
		  	criteria.andPingguoLike("%" + fruitBetresultHistory.getPingguo() + "%");
		}
		if (null != fruitBetresultHistory.getPutao()  && !"".equals(fruitBetresultHistory.getPutao())) {
		  	criteria.andPutaoLike("%" + fruitBetresultHistory.getPutao() + "%");
		}
		if (null != fruitBetresultHistory.getBoluo()  && !"".equals(fruitBetresultHistory.getBoluo())) {
		  	criteria.andBoluoLike("%" + fruitBetresultHistory.getBoluo() + "%");
		}
		if (null != fruitBetresultHistory.getCaomei()  && !"".equals(fruitBetresultHistory.getCaomei())) {
		  	criteria.andCaomeiLike("%" + fruitBetresultHistory.getCaomei() + "%");
		}
		if (null != fruitBetresultHistory.getXigua()  && !"".equals(fruitBetresultHistory.getXigua())) {
		  	criteria.andXiguaLike("%" + fruitBetresultHistory.getXigua() + "%");
		}
		if (null != fruitBetresultHistory.getXiangjiao()  && !"".equals(fruitBetresultHistory.getXiangjiao())) {
		  	criteria.andXiangjiaoLike("%" + fruitBetresultHistory.getXiangjiao() + "%");
		}*/
		if (null != fruitBetresultHistory.getDescription()  && !"".equals(fruitBetresultHistory.getDescription())) {
		  	criteria.andDescriptionLike("%" + fruitBetresultHistory.getDescription() + "%");
		}
		if (null != fruitBetresultHistory.getUsername()  && !"".equals(fruitBetresultHistory.getUsername())) {
		  	criteria.andUsernameLike("%" + fruitBetresultHistory.getUsername() + "%");
		}
		if (null != fruitBetresultHistory.getUserId()  && !"".equals(fruitBetresultHistory.getUserId())) {
		  	criteria.andUserIdLike("%" + fruitBetresultHistory.getUserId() + "%");
		}
		page = fruitBetresultHistoryService.select(fruitBetresultHistoryCriteria);
		return page;
	}
	
//	@RequiresPermissions("fruitBetresultHistory:delete")
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
		int result = fruitBetresultHistoryService.deleteBatch(list);

		return result;
	}
	
	/**
	 * 全部导出Excel.
	 * @param fruitBetresultHistory
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @throws IOException
	 */
//	@RequiresPermissions("fruitBetresultHistory:view")
	@RequestMapping(value = "/exportExcel")
	public void exportExcel(@ModelAttribute FruitBetresultHistory fruitBetresultHistory,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		httpServletResponse.setCharacterEncoding("UTF-8");
		String filename = new String("用户信息".getBytes("GBK"), "iso8859-1");

		List<FruitBetresultHistory>list = fruitBetresultHistoryService.selectAll();

		List<Map<String, Object>> maps = createExcelRecord(list);

		String columnNames[] = { 
			"Id",
			"CreateDate",
			"CreateBy",
			"UpdateDate",
			"UpdateBy",
			"Da",
			"Xiao",
			"Dan",
			"Shuang",
			"Pingguo",
			"Putao",
			"Boluo",
			"Caomei",
			"Xigua",
			"Xiangjiao",
			"Description",
			"Username",
			"UserId"
		};// 列名
		String keys[] = { 
			"Id",
			"CreateDate",
			"CreateBy",
			"UpdateDate",
			"UpdateBy",
			"Da",
			"Xiao",
			"Dan",
			"Shuang",
			"Pingguo",
			"Putao",
			"Boluo",
			"Caomei",
			"Xigua",
			"Xiangjiao",
			"Description",
			"Username",
			"UserId"
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

	private List<Map<String, Object>> createExcelRecord(List<FruitBetresultHistory> list) {
		List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sheetName", "sheet1");
		listmap.add(map);
		FruitBetresultHistory fruitBetresultHistory = null;
		for (int j = 0; j < list.size(); j++) {
			fruitBetresultHistory = list.get(j);
			Map<String, Object> mapValue = new HashMap<String, Object>();
				mapValue.put("Id",fruitBetresultHistory.getId());
				mapValue.put("CreateDate",fruitBetresultHistory.getCreateDate());
				mapValue.put("CreateBy",fruitBetresultHistory.getCreateBy());
				mapValue.put("UpdateDate",fruitBetresultHistory.getUpdateDate());
				mapValue.put("UpdateBy",fruitBetresultHistory.getUpdateBy());
				mapValue.put("Da",fruitBetresultHistory.getDa());
				mapValue.put("Xiao",fruitBetresultHistory.getXiao());
				mapValue.put("Dan",fruitBetresultHistory.getDan());
				mapValue.put("Shuang",fruitBetresultHistory.getShuang());
				mapValue.put("Pingguo",fruitBetresultHistory.getPingguo());
				mapValue.put("Putao",fruitBetresultHistory.getPutao());
				mapValue.put("Boluo",fruitBetresultHistory.getBoluo());
				mapValue.put("Caomei",fruitBetresultHistory.getCaomei());
				mapValue.put("Xigua",fruitBetresultHistory.getXigua());
				mapValue.put("Xiangjiao",fruitBetresultHistory.getXiangjiao());
				mapValue.put("Description",fruitBetresultHistory.getDescription());
				mapValue.put("Username",fruitBetresultHistory.getUsername());
				mapValue.put("UserId",fruitBetresultHistory.getUserId());
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
