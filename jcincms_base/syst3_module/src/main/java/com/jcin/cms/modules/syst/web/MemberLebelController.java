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
import com.jcin.cms.modules.syst.domain.MemberLebel;
import com.jcin.cms.modules.syst.domain.MemberLebelCriteria;
import com.jcin.cms.modules.syst.service.IMemberLebelService;
import com.jcin.cms.utils.Page;
import com.jcin.cms.utils.ExcelUtil;
import com.jcin.cms.web.BaseController;

@Controller
@RequestMapping(value = "${adminPath}/memberLebel")
public class MemberLebelController extends BaseController<MemberLebel>{
	@Autowired
	private IMemberLebelService memberLebelService;

//	@RequiresPermissions("memberLebel:create")
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(MemberLebel memberLebel, Model uiModel) {
		uiModel.addAttribute("memberLebel", memberLebel);
		return root+"admin/modules/memberLebel/memberLebel_create.jsp";
	}

//	@RequiresPermissions("memberLebel:create")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(MemberLebel memberLebel, RedirectAttributes redirectAttributes,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		memberLebelService.insert(memberLebel);
		
		redirectAttributes.addFlashAttribute("memberLebel", memberLebel);
		redirectAttributes.addFlashAttribute("msg", "新增成功");
		return "redirect:/"+Global.getAdminPath()+"/memberLebel/create";
	}
	
//	@RequiresPermissions("memberLebel:update")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String update(@PathVariable("id") String id, Model uiModel) {
		MemberLebel memberLebel = memberLebelService.selectByPrimaryKey(id);
		uiModel.addAttribute("memberLebel", memberLebel);
		return root+"admin/modules/memberLebel/memberLebel_update.jsp";
	}

//	@RequiresPermissions("memberLebel:update")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String update(MemberLebel memberLebel,RedirectAttributes redirectAttributes,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		memberLebelService.update(memberLebel);
		
		redirectAttributes.addFlashAttribute("msg", "修改成功");
		redirectAttributes.addFlashAttribute("memberLebel", memberLebel);
		return "redirect:/"+Global.getAdminPath()+"/memberLebel/update/"+memberLebel.getId();
	}

//	@RequiresPermissions("memberLebel:show")
	@RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
	public String show(@PathVariable("id") String id, Model uiModel) {
		MemberLebel memberLebel = memberLebelService.selectByPrimaryKey(id);
		
		uiModel.addAttribute("memberLebel", memberLebel);
		return root+"admin/modules/memberLebel/memberLebel_show.jsp";
	}

//	@RequiresPermissions("memberLebel:view")
	@RequestMapping(value = { "", "list" })
	public String list(HttpServletRequest httpServletRequest) {
		return root+"admin/modules/memberLebel/memberLebel_list.jsp";
	}

//	@RequiresPermissions("memberLebel:delete")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
	public String delete(@PathVariable("id") String id, Model uiModel) {
		memberLebelService.deleteByPrimaryKey(id);
		uiModel.asMap().clear();
		return "redirect:/memberLebel";
	}

	void populateEditForm(Model uiModel, MemberLebel memberLebel) {
		uiModel.addAttribute("memberLebel", memberLebel);
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

//	@RequiresPermissions("memberLebel:view")
	@RequestMapping(value = "/select")
	@ResponseBody
	public Page select(@ModelAttribute Page page, @ModelAttribute MemberLebel memberLebel,Model uiModel,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		super.select(page, uiModel, httpServletRequest,
				httpServletResponse);
		MemberLebelCriteria memberLebelCriteria = new MemberLebelCriteria();
		MemberLebelCriteria.Criteria criteria = memberLebelCriteria.createCriteria();
		memberLebelCriteria.setPage(page);
		memberLebelCriteria.setOrderByClause("id desc");
		if (null != memberLebel.getId()  && !"".equals(memberLebel.getId())) {
		  	criteria.andIdLike("%" + memberLebel.getId() + "%");
		}
		if (null != memberLebel.getName()  && !"".equals(memberLebel.getName())) {
		  	criteria.andNameLike("%" + memberLebel.getName() + "%");
		}
		if (null != memberLebel.getDescription()  && !"".equals(memberLebel.getDescription())) {
		  	criteria.andDescriptionLike("%" + memberLebel.getDescription() + "%");
		}
		page = memberLebelService.select(memberLebelCriteria);
		return page;
	}
	
//	@RequiresPermissions("memberLebel:delete")
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
		int result = memberLebelService.deleteBatch(list);

		return result;
	}
	
	/**
	 * 全部导出Excel.
	 * @param memberLebel
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @throws IOException
	 */
//	@RequiresPermissions("memberLebel:view")
	@RequestMapping(value = "/exportExcel")
	public void exportExcel(@ModelAttribute MemberLebel memberLebel,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		httpServletResponse.setCharacterEncoding("UTF-8");
		String filename = new String("用户信息".getBytes("GBK"), "iso8859-1");

		List<MemberLebel>list = memberLebelService.selectAll();

		List<Map<String, Object>> maps = createExcelRecord(list);

		String columnNames[] = { 
			"Id",
			"Name",
			"Description"
		};// 列名
		String keys[] = { 
			"Id",
			"Name",
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

	private List<Map<String, Object>> createExcelRecord(List<MemberLebel> list) {
		List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sheetName", "sheet1");
		listmap.add(map);
		MemberLebel memberLebel = null;
		for (int j = 0; j < list.size(); j++) {
			memberLebel = list.get(j);
			Map<String, Object> mapValue = new HashMap<String, Object>();
				mapValue.put("Id",memberLebel.getId());
				mapValue.put("Name",memberLebel.getName());
				mapValue.put("Description",memberLebel.getDescription());
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