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
import com.jcin.cms.modules.bet.domain.AccountHistory;
import com.jcin.cms.modules.bet.domain.AccountHistoryCriteria;
import com.jcin.cms.modules.bet.service.IAccountHistoryService;
import com.jcin.cms.utils.Page;
import com.jcin.cms.utils.ExcelUtil;
import com.jcin.cms.web.BaseController;

@Controller
@RequestMapping(value = "${adminPath}/accountHistory")
public class AccountHistoryController extends BaseController<AccountHistory>{
	@Autowired
	private IAccountHistoryService accountHistoryService;

//	@RequiresPermissions("accountHistory:create")
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(AccountHistory accountHistory, Model uiModel) {
		uiModel.addAttribute("accountHistory", accountHistory);
		return root+"admin/modules/accountHistory/accountHistory_create.jsp";
	}

//	@RequiresPermissions("accountHistory:create")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(AccountHistory accountHistory, RedirectAttributes redirectAttributes,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		accountHistoryService.insert(accountHistory);
		
		redirectAttributes.addFlashAttribute("accountHistory", accountHistory);
		redirectAttributes.addFlashAttribute("msg", "新增成功");
		return "redirect:/"+Global.getAdminPath()+"/accountHistory/create";
	}
	
//	@RequiresPermissions("accountHistory:update")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String update(@PathVariable("id") String id, Model uiModel) {
		AccountHistory accountHistory = accountHistoryService.selectByPrimaryKey(id);
		uiModel.addAttribute("accountHistory", accountHistory);
		return root+"admin/modules/accountHistory/accountHistory_update.jsp";
	}

//	@RequiresPermissions("accountHistory:update")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String update(AccountHistory accountHistory,RedirectAttributes redirectAttributes,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		accountHistoryService.update(accountHistory);
		
		redirectAttributes.addFlashAttribute("msg", "修改成功");
		redirectAttributes.addFlashAttribute("accountHistory", accountHistory);
		return "redirect:/"+Global.getAdminPath()+"/accountHistory/update/"+accountHistory.getId();
	}

//	@RequiresPermissions("accountHistory:show")
	@RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
	public String show(@PathVariable("id") String id, Model uiModel) {
		AccountHistory accountHistory = accountHistoryService.selectByPrimaryKey(id);
		
		uiModel.addAttribute("accountHistory", accountHistory);
		return root+"admin/modules/accountHistory/accountHistory_show.jsp";
	}

//	@RequiresPermissions("accountHistory:view")
	@RequestMapping(value = { "", "list" })
	public String list(HttpServletRequest httpServletRequest) {
		return root+"admin/modules/accountHistory/accountHistory_list.jsp";
	}

//	@RequiresPermissions("accountHistory:delete")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
	public String delete(@PathVariable("id") String id, Model uiModel) {
		accountHistoryService.deleteByPrimaryKey(id);
		uiModel.asMap().clear();
		return "redirect:/accountHistory";
	}

	void populateEditForm(Model uiModel, AccountHistory accountHistory) {
		uiModel.addAttribute("accountHistory", accountHistory);
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

//	@RequiresPermissions("accountHistory:view")
	@RequestMapping(value = "/select")
	@ResponseBody
	public Page select(@ModelAttribute Page page, @ModelAttribute AccountHistory accountHistory,Model uiModel,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		super.select(page, uiModel, httpServletRequest,
				httpServletResponse);
		AccountHistoryCriteria accountHistoryCriteria = new AccountHistoryCriteria();
		AccountHistoryCriteria.Criteria criteria = accountHistoryCriteria.createCriteria();
		accountHistoryCriteria.setPage(page);
		accountHistoryCriteria.setOrderByClause("id desc");
		if (null != accountHistory.getId()  && !"".equals(accountHistory.getId())) {
		  	criteria.andIdLike("%" + accountHistory.getId() + "%");
		}
		/*if (null != accountHistory.getTotal()  && !"".equals(accountHistory.getTotal())) {
		  	criteria.andTotalLike("%" + accountHistory.getTotal() + "%");
		}
		if (null != accountHistory.getCreateDate()  && !"".equals(accountHistory.getCreateDate())) {
		  	criteria.andCreateDateLike("%" + accountHistory.getCreateDate() + "%");
		}
		if (null != accountHistory.getUpdateDate()  && !"".equals(accountHistory.getUpdateDate())) {
		  	criteria.andUpdateDateLike("%" + accountHistory.getUpdateDate() + "%");
		}*/
		if (null != accountHistory.getDescription()  && !"".equals(accountHistory.getDescription())) {
		  	criteria.andDescriptionLike("%" + accountHistory.getDescription() + "%");
		}
		if (null != accountHistory.getCreateBy()  && !"".equals(accountHistory.getCreateBy())) {
		  	criteria.andCreateByLike("%" + accountHistory.getCreateBy() + "%");
		}
		if (null != accountHistory.getUpdateBy()  && !"".equals(accountHistory.getUpdateBy())) {
		  	criteria.andUpdateByLike("%" + accountHistory.getUpdateBy() + "%");
		}
		if (null != accountHistory.getTbUserId()  && !"".equals(accountHistory.getTbUserId())) {
		  	criteria.andTbUserIdLike("%" + accountHistory.getTbUserId() + "%");
		}
		if (null != accountHistory.getUsername()  && !"".equals(accountHistory.getUsername())) {
		  	criteria.andUsernameLike("%" + accountHistory.getUsername() + "%");
		}
		page = accountHistoryService.select(accountHistoryCriteria);
		return page;
	}
	
//	@RequiresPermissions("accountHistory:delete")
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
		int result = accountHistoryService.deleteBatch(list);

		return result;
	}
	
	/**
	 * 全部导出Excel.
	 * @param accountHistory
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @throws IOException
	 */
//	@RequiresPermissions("accountHistory:view")
	@RequestMapping(value = "/exportExcel")
	public void exportExcel(@ModelAttribute AccountHistory accountHistory,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		httpServletResponse.setCharacterEncoding("UTF-8");
		String filename = new String("用户信息".getBytes("GBK"), "iso8859-1");

		List<AccountHistory>list = accountHistoryService.selectAll();

		List<Map<String, Object>> maps = createExcelRecord(list);

		String columnNames[] = { 
			"Id",
			"Total",
			"CreateDate",
			"UpdateDate",
			"Description",
			"CreateBy",
			"UpdateBy",
			"TbUser_id",
			"Username"
		};// 列名
		String keys[] = { 
			"Id",
			"Total",
			"CreateDate",
			"UpdateDate",
			"Description",
			"CreateBy",
			"UpdateBy",
			"TbUser_id",
			"Username"
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

	private List<Map<String, Object>> createExcelRecord(List<AccountHistory> list) {
		List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sheetName", "sheet1");
		listmap.add(map);
		AccountHistory accountHistory = null;
		for (int j = 0; j < list.size(); j++) {
			accountHistory = list.get(j);
			Map<String, Object> mapValue = new HashMap<String, Object>();
				mapValue.put("Id",accountHistory.getId());
				mapValue.put("Total",accountHistory.getTotal());
				mapValue.put("CreateDate",accountHistory.getCreateDate());
				mapValue.put("UpdateDate",accountHistory.getUpdateDate());
				mapValue.put("Description",accountHistory.getDescription());
				mapValue.put("CreateBy",accountHistory.getCreateBy());
				mapValue.put("UpdateBy",accountHistory.getUpdateBy());
				mapValue.put("TbUser_id",accountHistory.getTbUserId());
				mapValue.put("Username",accountHistory.getUsername());
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
