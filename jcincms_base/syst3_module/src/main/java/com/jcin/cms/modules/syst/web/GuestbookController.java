/**
 * 一句话描述该类：前端控制器，提供页面跳转，访问方法返回JSON<br/>
 * @author 黄记新 <br/>
 * @date 2015-4-29,10:52 <br/>
 *
 */
package com.jcin.cms.modules.syst.web;

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
import com.jcin.cms.modules.syst.domain.Guestbook;
import com.jcin.cms.modules.syst.domain.GuestbookCriteria;
import com.jcin.cms.modules.syst.service.IGuestbookService;
import com.jcin.cms.utils.Page;
import com.jcin.cms.utils.ExcelUtil;
import com.jcin.cms.web.BaseController;

@Controller
@RequestMapping(value = "${adminPath}/guestbook")
public class GuestbookController extends BaseController<Guestbook>{
	@Autowired
	private IGuestbookService guestbookService;

//	@RequiresPermissions("guestbook:create")
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(Guestbook guestbook, Model uiModel) {
		uiModel.addAttribute("guestbook", guestbook);
		return root+"admin/modules/guestbook/guestbook_create.jsp";
	}

//	@RequiresPermissions("guestbook:create")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(Guestbook guestbook, RedirectAttributes redirectAttributes,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		guestbookService.insert(guestbook);
		
		redirectAttributes.addFlashAttribute("guestbook", guestbook);
		redirectAttributes.addFlashAttribute("msg", "新增成功");
		return "redirect:/"+Global.getAdminPath()+"/guestbook/create";
	}
	
//	@RequiresPermissions("guestbook:update")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String update(@PathVariable("id") String id, Model uiModel) {
		Guestbook guestbook = guestbookService.selectByPrimaryKey(id);
		uiModel.addAttribute("guestbook", guestbook);
		return root+"admin/modules/guestbook/guestbook_update.jsp";
	}

//	@RequiresPermissions("guestbook:update")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String update(Guestbook guestbook,RedirectAttributes redirectAttributes,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		guestbookService.update(guestbook);
		
		redirectAttributes.addFlashAttribute("msg", "修改成功");
		redirectAttributes.addFlashAttribute("guestbook", guestbook);
		return "redirect:/"+Global.getAdminPath()+"/guestbook/update/"+guestbook.getId();
	}

//	@RequiresPermissions("guestbook:show")
	@RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
	public String show(@PathVariable("id") String id, Model uiModel) {
		Guestbook guestbook = guestbookService.selectByPrimaryKey(id);
		
		uiModel.addAttribute("guestbook", guestbook);
		return root+"admin/modules/guestbook/guestbook_show.jsp";
	}

//	@RequiresPermissions("guestbook:view")
	@RequestMapping(value = { "", "list" })
	public String list(HttpServletRequest httpServletRequest) {
		return root+"admin/modules/guestbook/guestbook_list.jsp";
	}

//	@RequiresPermissions("guestbook:delete")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
	public String delete(@PathVariable("id") String id, Model uiModel) {
		guestbookService.deleteByPrimaryKey(id);
		uiModel.asMap().clear();
		return "redirect:/guestbook";
	}

	void populateEditForm(Model uiModel, Guestbook guestbook) {
		uiModel.addAttribute("guestbook", guestbook);
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

//	@RequiresPermissions("guestbook:view")
	@RequestMapping(value = "/select")
	@ResponseBody
	public Page select(@ModelAttribute Page page, @ModelAttribute Guestbook guestbook,Model uiModel,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		super.select(page, uiModel, httpServletRequest,
				httpServletResponse);
		GuestbookCriteria guestbookCriteria = new GuestbookCriteria();
		GuestbookCriteria.Criteria criteria = guestbookCriteria.createCriteria();
		guestbookCriteria.setPage(page);
		guestbookCriteria.setOrderByClause("id desc");
		if (null != guestbook.getId()  && !"".equals(guestbook.getId())) {
		  	criteria.andIdLike("%" + guestbook.getId() + "%");
		}
		if (null != guestbook.getTopic()  && !"".equals(guestbook.getTopic())) {
		  	criteria.andTopicLike("%" + guestbook.getTopic() + "%");
		}
		if (null != guestbook.getContent()  && !"".equals(guestbook.getContent())) {
		  	criteria.andContentLike("%" + guestbook.getContent() + "%");
		}
		if (null != guestbook.getTel()  && !"".equals(guestbook.getTel())) {
		  	criteria.andTelLike("%" + guestbook.getTel() + "%");
		}
		if (null != guestbook.getQq()  && !"".equals(guestbook.getQq())) {
		  	criteria.andQqLike("%" + guestbook.getQq() + "%");
		}
		if (null != guestbook.getName()  && !"".equals(guestbook.getName())) {
		  	criteria.andNameLike("%" + guestbook.getName() + "%");
		}
		if (null != guestbook.getEmail()  && !"".equals(guestbook.getEmail())) {
		  	criteria.andEmailLike("%" + guestbook.getEmail() + "%");
		}
		page = guestbookService.select(guestbookCriteria);
		return page;
	}
	
//	@RequiresPermissions("guestbook:delete")
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
		int result = guestbookService.deleteBatch(list);

		return result;
	}
	
	/**
	 * 全部导出Excel.
	 * @param guestbook
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @throws IOException
	 */
//	@RequiresPermissions("guestbook:view")
	@RequestMapping(value = "/exportExcel")
	public void exportExcel(@ModelAttribute Guestbook guestbook,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		httpServletResponse.setCharacterEncoding("UTF-8");
		String filename = new String("用户信息".getBytes("GBK"), "iso8859-1");

		List<Guestbook>list = guestbookService.selectAll();

		List<Map<String, Object>> maps = createExcelRecord(list);

		String columnNames[] = { 
			"Id",
			"Topic",
			"Content",
			"Tel",
			"Qq",
			"Name",
			"Email",
			"CreateDate",
			"UpdateDate"
		};// 列名
		String keys[] = { 
			"Id",
			"Topic",
			"Content",
			"Tel",
			"Qq",
			"Name",
			"Email",
			"CreateDate",
			"UpdateDate"
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

	private List<Map<String, Object>> createExcelRecord(List<Guestbook> list) {
		List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sheetName", "sheet1");
		listmap.add(map);
		Guestbook guestbook = null;
		for (int j = 0; j < list.size(); j++) {
			guestbook = list.get(j);
			Map<String, Object> mapValue = new HashMap<String, Object>();
				mapValue.put("Id",guestbook.getId());
				mapValue.put("Topic",guestbook.getTopic());
				mapValue.put("Content",guestbook.getContent());
				mapValue.put("Tel",guestbook.getTel());
				mapValue.put("Qq",guestbook.getQq());
				mapValue.put("Name",guestbook.getName());
				mapValue.put("Email",guestbook.getEmail());
				mapValue.put("CreateDate",guestbook.getCreateDate());
				mapValue.put("UpdateDate",guestbook.getUpdateDate());
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
