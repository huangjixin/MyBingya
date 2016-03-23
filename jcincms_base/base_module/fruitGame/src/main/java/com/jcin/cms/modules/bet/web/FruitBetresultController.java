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
import com.jcin.cms.modules.bet.domain.FruitBetresult;
import com.jcin.cms.modules.bet.domain.FruitBetresultCriteria;
import com.jcin.cms.modules.bet.service.IFruitBetresultService;
import com.jcin.cms.utils.Page;
import com.jcin.cms.utils.ExcelUtil;
import com.jcin.cms.web.BaseController;

@Controller
@RequestMapping(value = "${adminPath}/fruitBetresult")
public class FruitBetresultController extends BaseController<FruitBetresult>{
	@Autowired
	private IFruitBetresultService fruitBetresultService;

//	@RequiresPermissions("fruitBetresult:create")
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(FruitBetresult fruitBetresult, Model uiModel) {
		uiModel.addAttribute("fruitBetresult", fruitBetresult);
		return root+"admin/modules/fruitBetresult/fruitBetresult_create.jsp";
	}

//	@RequiresPermissions("fruitBetresult:create")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(FruitBetresult fruitBetresult, RedirectAttributes redirectAttributes,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		fruitBetresultService.insert(fruitBetresult);
		
		redirectAttributes.addFlashAttribute("fruitBetresult", fruitBetresult);
		redirectAttributes.addFlashAttribute("msg", "新增成功");
		return "redirect:/"+Global.getAdminPath()+"/fruitBetresult/create";
	}
	
//	@RequiresPermissions("fruitBetresult:update")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String update(@PathVariable("id") String id, Model uiModel) {
		FruitBetresult fruitBetresult = fruitBetresultService.selectByPrimaryKey(id);
		uiModel.addAttribute("fruitBetresult", fruitBetresult);
		return root+"admin/modules/fruitBetresult/fruitBetresult_update.jsp";
	}

//	@RequiresPermissions("fruitBetresult:update")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String update(FruitBetresult fruitBetresult,RedirectAttributes redirectAttributes,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		fruitBetresultService.update(fruitBetresult);
		
		redirectAttributes.addFlashAttribute("msg", "修改成功");
		redirectAttributes.addFlashAttribute("fruitBetresult", fruitBetresult);
		return "redirect:/"+Global.getAdminPath()+"/fruitBetresult/update/"+fruitBetresult.getId();
	}

//	@RequiresPermissions("fruitBetresult:show")
	@RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
	public String show(@PathVariable("id") String id, Model uiModel) {
		FruitBetresult fruitBetresult = fruitBetresultService.selectByPrimaryKey(id);
		
		uiModel.addAttribute("fruitBetresult", fruitBetresult);
		return root+"admin/modules/fruitBetresult/fruitBetresult_show.jsp";
	}

//	@RequiresPermissions("fruitBetresult:view")
	@RequestMapping(value = { "", "list" })
	public String list(HttpServletRequest httpServletRequest) {
		return root+"admin/modules/fruitBetresult/fruitBetresult_list.jsp";
	}

//	@RequiresPermissions("fruitBetresult:delete")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
	public String delete(@PathVariable("id") String id, Model uiModel) {
		fruitBetresultService.deleteByPrimaryKey(id);
		uiModel.asMap().clear();
		return "redirect:/fruitBetresult";
	}

	void populateEditForm(Model uiModel, FruitBetresult fruitBetresult) {
		uiModel.addAttribute("fruitBetresult", fruitBetresult);
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

//	@RequiresPermissions("fruitBetresult:view")
	@RequestMapping(value = "/select")
	@ResponseBody
	public Page select(@ModelAttribute Page page, @ModelAttribute FruitBetresult fruitBetresult,Model uiModel,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		super.select(page, uiModel, httpServletRequest,
				httpServletResponse);
		FruitBetresultCriteria fruitBetresultCriteria = new FruitBetresultCriteria();
		FruitBetresultCriteria.Criteria criteria = fruitBetresultCriteria.createCriteria();
		fruitBetresultCriteria.setPage(page);
		fruitBetresultCriteria.setOrderByClause("id desc");
		if (null != fruitBetresult.getId()  && !"".equals(fruitBetresult.getId())) {
		  	criteria.andIdLike("%" + fruitBetresult.getId() + "%");
		}
		/*if (null != fruitBetresult.getCreateDate()  && !"".equals(fruitBetresult.getCreateDate())) {
		  	criteria.andCreateDateLike("%" + fruitBetresult.getCreateDate() + "%");
		}*/
		if (null != fruitBetresult.getCreateBy()  && !"".equals(fruitBetresult.getCreateBy())) {
		  	criteria.andCreateByLike("%" + fruitBetresult.getCreateBy() + "%");
		}
		/*if (null != fruitBetresult.getUpdateDate()  && !"".equals(fruitBetresult.getUpdateDate())) {
		  	criteria.andUpdateDateLike("%" + fruitBetresult.getUpdateDate() + "%");
		}*/
		if (null != fruitBetresult.getUpdateBy()  && !"".equals(fruitBetresult.getUpdateBy())) {
		  	criteria.andUpdateByLike("%" + fruitBetresult.getUpdateBy() + "%");
		}
		/*if (null != fruitBetresult.getDa()  && !"".equals(fruitBetresult.getDa())) {
		  	criteria.andDaLike("%" + fruitBetresult.getDa() + "%");
		}
		if (null != fruitBetresult.getXiao()  && !"".equals(fruitBetresult.getXiao())) {
		  	criteria.andXiaoLike("%" + fruitBetresult.getXiao() + "%");
		}
		if (null != fruitBetresult.getDan()  && !"".equals(fruitBetresult.getDan())) {
		  	criteria.andDanLike("%" + fruitBetresult.getDan() + "%");
		}
		if (null != fruitBetresult.getShuang()  && !"".equals(fruitBetresult.getShuang())) {
		  	criteria.andShuangLike("%" + fruitBetresult.getShuang() + "%");
		}
		if (null != fruitBetresult.getPingguo()  && !"".equals(fruitBetresult.getPingguo())) {
		  	criteria.andPingguoLike("%" + fruitBetresult.getPingguo() + "%");
		}
		if (null != fruitBetresult.getPutao()  && !"".equals(fruitBetresult.getPutao())) {
		  	criteria.andPutaoLike("%" + fruitBetresult.getPutao() + "%");
		}
		if (null != fruitBetresult.getBoluo()  && !"".equals(fruitBetresult.getBoluo())) {
		  	criteria.andBoluoLike("%" + fruitBetresult.getBoluo() + "%");
		}
		if (null != fruitBetresult.getCaomei()  && !"".equals(fruitBetresult.getCaomei())) {
		  	criteria.andCaomeiLike("%" + fruitBetresult.getCaomei() + "%");
		}
		if (null != fruitBetresult.getXigua()  && !"".equals(fruitBetresult.getXigua())) {
		  	criteria.andXiguaLike("%" + fruitBetresult.getXigua() + "%");
		}
		if (null != fruitBetresult.getXiangjiao()  && !"".equals(fruitBetresult.getXiangjiao())) {
		  	criteria.andXiangjiaoLike("%" + fruitBetresult.getXiangjiao() + "%");
		}*/
		if (null != fruitBetresult.getDescription()  && !"".equals(fruitBetresult.getDescription())) {
		  	criteria.andDescriptionLike("%" + fruitBetresult.getDescription() + "%");
		}
		if (null != fruitBetresult.getUsername()  && !"".equals(fruitBetresult.getUsername())) {
		  	criteria.andUsernameLike("%" + fruitBetresult.getUsername() + "%");
		}
		if (null != fruitBetresult.getUserId()  && !"".equals(fruitBetresult.getUserId())) {
		  	criteria.andUserIdLike("%" + fruitBetresult.getUserId() + "%");
		}
		page = fruitBetresultService.select(fruitBetresultCriteria);
		return page;
	}
	
//	@RequiresPermissions("fruitBetresult:delete")
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
		int result = fruitBetresultService.deleteBatch(list);

		return result;
	}
	
	/**
	 * 全部导出Excel.
	 * @param fruitBetresult
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @throws IOException
	 */
//	@RequiresPermissions("fruitBetresult:view")
	@RequestMapping(value = "/exportExcel")
	public void exportExcel(@ModelAttribute FruitBetresult fruitBetresult,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		httpServletResponse.setCharacterEncoding("UTF-8");
		String filename = new String("用户信息".getBytes("GBK"), "iso8859-1");

		List<FruitBetresult>list = fruitBetresultService.selectAll();

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

	private List<Map<String, Object>> createExcelRecord(List<FruitBetresult> list) {
		List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sheetName", "sheet1");
		listmap.add(map);
		FruitBetresult fruitBetresult = null;
		for (int j = 0; j < list.size(); j++) {
			fruitBetresult = list.get(j);
			Map<String, Object> mapValue = new HashMap<String, Object>();
				mapValue.put("Id",fruitBetresult.getId());
				mapValue.put("CreateDate",fruitBetresult.getCreateDate());
				mapValue.put("CreateBy",fruitBetresult.getCreateBy());
				mapValue.put("UpdateDate",fruitBetresult.getUpdateDate());
				mapValue.put("UpdateBy",fruitBetresult.getUpdateBy());
				mapValue.put("Da",fruitBetresult.getDa());
				mapValue.put("Xiao",fruitBetresult.getXiao());
				mapValue.put("Dan",fruitBetresult.getDan());
				mapValue.put("Shuang",fruitBetresult.getShuang());
				mapValue.put("Pingguo",fruitBetresult.getPingguo());
				mapValue.put("Putao",fruitBetresult.getPutao());
				mapValue.put("Boluo",fruitBetresult.getBoluo());
				mapValue.put("Caomei",fruitBetresult.getCaomei());
				mapValue.put("Xigua",fruitBetresult.getXigua());
				mapValue.put("Xiangjiao",fruitBetresult.getXiangjiao());
				mapValue.put("Description",fruitBetresult.getDescription());
				mapValue.put("Username",fruitBetresult.getUsername());
				mapValue.put("UserId",fruitBetresult.getUserId());
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
