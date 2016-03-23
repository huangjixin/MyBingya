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
import com.jcin.cms.modules.bet.domain.Account;
import com.jcin.cms.modules.bet.domain.AccountCriteria;
import com.jcin.cms.modules.bet.service.IAccountService;
import com.jcin.cms.utils.Page;
import com.jcin.cms.utils.ExcelUtil;
import com.jcin.cms.web.BaseController;

@Controller
@RequestMapping(value = "${adminPath}/account")
public class AccountController extends BaseController<Account>{
	@Autowired
	private IAccountService accountService;

//	@RequiresPermissions("account:create")
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(Account account, Model uiModel) {
		uiModel.addAttribute("account", account);
		return root+"admin/modules/account/account_create.jsp";
	}

//	@RequiresPermissions("account:create")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(Account account, RedirectAttributes redirectAttributes,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		accountService.insert(account);
		
		redirectAttributes.addFlashAttribute("account", account);
		redirectAttributes.addFlashAttribute("msg", "新增成功");
		return "redirect:/"+Global.getAdminPath()+"/account/create";
	}
	
//	@RequiresPermissions("account:update")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String update(@PathVariable("id") String id, Model uiModel) {
		Account account = accountService.selectByPrimaryKey(id);
		uiModel.addAttribute("account", account);
		return root+"admin/modules/account/account_update.jsp";
	}

//	@RequiresPermissions("account:update")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String update(Account account,RedirectAttributes redirectAttributes,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		accountService.update(account);
		
		redirectAttributes.addFlashAttribute("msg", "修改成功");
		redirectAttributes.addFlashAttribute("account", account);
		return "redirect:/"+Global.getAdminPath()+"/account/update/"+account.getId();
	}

//	@RequiresPermissions("account:show")
	@RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
	public String show(@PathVariable("id") String id, Model uiModel) {
		Account account = accountService.selectByPrimaryKey(id);
		
		uiModel.addAttribute("account", account);
		return root+"admin/modules/account/account_show.jsp";
	}

//	@RequiresPermissions("account:view")
	@RequestMapping(value = { "", "list" })
	public String list(HttpServletRequest httpServletRequest) {
		return root+"admin/modules/account/account_list.jsp";
	}

//	@RequiresPermissions("account:delete")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
	public String delete(@PathVariable("id") String id, Model uiModel) {
		accountService.deleteByPrimaryKey(id);
		uiModel.asMap().clear();
		return "redirect:/account";
	}

	void populateEditForm(Model uiModel, Account account) {
		uiModel.addAttribute("account", account);
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

//	@RequiresPermissions("account:view")
	@RequestMapping(value = "/select")
	@ResponseBody
	public Page select(@ModelAttribute Page page, @ModelAttribute Account account,Model uiModel,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		super.select(page, uiModel, httpServletRequest,
				httpServletResponse);
		AccountCriteria accountCriteria = new AccountCriteria();
		AccountCriteria.Criteria criteria = accountCriteria.createCriteria();
		accountCriteria.setPage(page);
		accountCriteria.setOrderByClause("id desc");
		if (null != account.getId()  && !"".equals(account.getId())) {
		  	criteria.andIdLike("%" + account.getId() + "%");
		}
		/*if (null != account.getTotal()  && !"".equals(account.getTotal())) {
		  	criteria.andTotalLike("%" + account.getTotal() + "%");
		}
		if (null != account.getCreateDate()  && !"".equals(account.getCreateDate())) {
		  	criteria.andCreateDateLike("%" + account.getCreateDate() + "%");
		}
		if (null != account.getUpdateDate()  && !"".equals(account.getUpdateDate())) {
		  	criteria.andUpdateDateLike("%" + account.getUpdateDate() + "%");
		}*/
		if (null != account.getDescription()  && !"".equals(account.getDescription())) {
		  	criteria.andDescriptionLike("%" + account.getDescription() + "%");
		}
		if (null != account.getCreateBy()  && !"".equals(account.getCreateBy())) {
		  	criteria.andCreateByLike("%" + account.getCreateBy() + "%");
		}
		if (null != account.getUpdateBy()  && !"".equals(account.getUpdateBy())) {
		  	criteria.andUpdateByLike("%" + account.getUpdateBy() + "%");
		}
		if (null != account.getUsername()  && !"".equals(account.getUsername())) {
		  	criteria.andUsernameLike("%" + account.getUsername() + "%");
		}
		page = accountService.select(accountCriteria);
		return page;
	}
	
//	@RequiresPermissions("account:delete")
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
		int result = accountService.deleteBatch(list);

		return result;
	}
	
	/**
	 * 全部导出Excel.
	 * @param account
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @throws IOException
	 */
//	@RequiresPermissions("account:view")
	@RequestMapping(value = "/exportExcel")
	public void exportExcel(@ModelAttribute Account account,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		httpServletResponse.setCharacterEncoding("UTF-8");
		String filename = new String("用户信息".getBytes("GBK"), "iso8859-1");

		List<Account>list = accountService.selectAll();

		List<Map<String, Object>> maps = createExcelRecord(list);

		String columnNames[] = { 
			"Id",
			"Total",
			"CreateDate",
			"UpdateDate",
			"Description",
			"CreateBy",
			"UpdateBy",
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

	private List<Map<String, Object>> createExcelRecord(List<Account> list) {
		List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sheetName", "sheet1");
		listmap.add(map);
		Account account = null;
		for (int j = 0; j < list.size(); j++) {
			account = list.get(j);
			Map<String, Object> mapValue = new HashMap<String, Object>();
				mapValue.put("Id",account.getId());
				mapValue.put("Total",account.getTotal());
				mapValue.put("CreateDate",account.getCreateDate());
				mapValue.put("UpdateDate",account.getUpdateDate());
				mapValue.put("Description",account.getDescription());
				mapValue.put("CreateBy",account.getCreateBy());
				mapValue.put("UpdateBy",account.getUpdateBy());
				mapValue.put("Username",account.getUsername());
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
