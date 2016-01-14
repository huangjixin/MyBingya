/**
 * 一句话描述该类：前端控制器，提供页面跳转，访问方法返回JSON<br/>
 * @author 黄记新 <br/>
 * @date 2015-4-29,10:52 <br/>
 *
 */
package com.jcin.cms.modules.channel.web;

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
import com.jcin.cms.modules.channel.domain.VoteChoice;
import com.jcin.cms.modules.channel.domain.VoteChoiceCriteria;
import com.jcin.cms.modules.channel.service.IVoteChoiceService;
import com.jcin.cms.utils.Page;
import com.jcin.cms.utils.ExcelUtil;
import com.jcin.cms.web.BaseController;

@Controller
@RequestMapping(value = "${adminPath}/voteChoice")
public class VoteChoiceController extends BaseController<VoteChoice>{
	@Autowired
	private IVoteChoiceService voteChoiceService;

//	@RequiresPermissions("voteChoice:create")
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(VoteChoice voteChoice, Model uiModel) {
		uiModel.addAttribute("voteChoice", voteChoice);
		return root+"admin/modules/voteChoice/voteChoice_create.jsp";
	}

//	@RequiresPermissions("voteChoice:create")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(VoteChoice voteChoice, RedirectAttributes redirectAttributes,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		voteChoiceService.insert(voteChoice);
		
		redirectAttributes.addFlashAttribute("voteChoice", voteChoice);
		redirectAttributes.addFlashAttribute("msg", "新增成功");
		return "redirect:/"+Global.getAdminPath()+"/voteChoice/create";
	}
	
//	@RequiresPermissions("voteChoice:update")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String update(@PathVariable("id") String id, Model uiModel) {
		VoteChoice voteChoice = voteChoiceService.selectByPrimaryKey(id);
		uiModel.addAttribute("voteChoice", voteChoice);
		return root+"admin/modules/voteChoice/voteChoice_update.jsp";
	}

//	@RequiresPermissions("voteChoice:update")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String update(VoteChoice voteChoice,RedirectAttributes redirectAttributes,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		voteChoiceService.update(voteChoice);
		
		redirectAttributes.addFlashAttribute("msg", "修改成功");
		redirectAttributes.addFlashAttribute("voteChoice", voteChoice);
		return "redirect:/"+Global.getAdminPath()+"/voteChoice/update/"+voteChoice.getId();
	}

//	@RequiresPermissions("voteChoice:show")
	@RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
	public String show(@PathVariable("id") String id, Model uiModel) {
		VoteChoice voteChoice = voteChoiceService.selectByPrimaryKey(id);
		
		uiModel.addAttribute("voteChoice", voteChoice);
		return root+"admin/modules/voteChoice/voteChoice_show.jsp";
	}

//	@RequiresPermissions("voteChoice:view")
	@RequestMapping(value = { "", "list" })
	public String list(HttpServletRequest httpServletRequest) {
		return root+"admin/modules/voteChoice/voteChoice_list.jsp";
	}

//	@RequiresPermissions("voteChoice:delete")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
	public String delete(@PathVariable("id") String id, Model uiModel) {
		voteChoiceService.deleteByPrimaryKey(id);
		uiModel.asMap().clear();
		return "redirect:/voteChoice";
	}

	void populateEditForm(Model uiModel, VoteChoice voteChoice) {
		uiModel.addAttribute("voteChoice", voteChoice);
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

//	@RequiresPermissions("voteChoice:view")
	@RequestMapping(value = "/select")
	@ResponseBody
	public Page select(@ModelAttribute Page page, @ModelAttribute VoteChoice voteChoice,Model uiModel,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		super.select(page, uiModel, httpServletRequest,
				httpServletResponse);
		VoteChoiceCriteria voteChoiceCriteria = new VoteChoiceCriteria();
		VoteChoiceCriteria.Criteria criteria = voteChoiceCriteria.createCriteria();
		voteChoiceCriteria.setPage(page);
		voteChoiceCriteria.setOrderByClause("id desc");
		if (null != voteChoice.getId()  && !"".equals(voteChoice.getId())) {
		  	criteria.andIdLike("%" + voteChoice.getId() + "%");
		}
		if (null != voteChoice.getName()  && !"".equals(voteChoice.getName())) {
		  	criteria.andNameLike("%" + voteChoice.getName() + "%");
		}
		/*if (null != voteChoice.getVoteCount()  && !"".equals(voteChoice.getVoteCount())) {
		  	criteria.andVoteCountLike("%" + voteChoice.getVoteCount() + "%");
		}*/
		if (null != voteChoice.getCreateBy()  && !"".equals(voteChoice.getCreateBy())) {
		  	criteria.andCreateByLike("%" + voteChoice.getCreateBy() + "%");
		}
		if (null != voteChoice.getUpdateBy()  && !"".equals(voteChoice.getUpdateBy())) {
		  	criteria.andUpdateByLike("%" + voteChoice.getUpdateBy() + "%");
		}
		/*if (null != voteChoice.getCreateDate()  && !"".equals(voteChoice.getCreateDate())) {
		  	criteria.andCreateDateLike("%" + voteChoice.getCreateDate() + "%");
		}
		if (null != voteChoice.getUpdateDate()  && !"".equals(voteChoice.getUpdateDate())) {
		  	criteria.andUpdateDateLike("%" + voteChoice.getUpdateDate() + "%");
		}*/
		if (null != voteChoice.getImage()  && !"".equals(voteChoice.getImage())) {
		  	criteria.andImageLike("%" + voteChoice.getImage() + "%");
		}
		/*if (null != voteChoice.getTbVote_topic_id()  && !"".equals(voteChoice.getTbVote_topic_id())) {
		  	criteria.andTbVote_topic_idLike("%" + voteChoice.getTbVote_topic_id() + "%");
		}*/
		page = voteChoiceService.select(voteChoiceCriteria);
		return page;
	}
	
//	@RequiresPermissions("voteChoice:delete")
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
		int result = voteChoiceService.deleteBatch(list);

		return result;
	}
	
	/**
	 * 全部导出Excel.
	 * @param voteChoice
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @throws IOException
	 */
//	@RequiresPermissions("voteChoice:view")
	@RequestMapping(value = "/exportExcel")
	public void exportExcel(@ModelAttribute VoteChoice voteChoice,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		httpServletResponse.setCharacterEncoding("UTF-8");
		String filename = new String("用户信息".getBytes("GBK"), "iso8859-1");

		List<VoteChoice>list = voteChoiceService.selectAll();

		List<Map<String, Object>> maps = createExcelRecord(list);

		String columnNames[] = { 
			"Id",
			"Name",
			"VoteCount",
			"CreateBy",
			"UpdateBy",
			"CreateDate",
			"UpdateDate",
			"Image",
			"TbVote_topic_id"
		};// 列名
		String keys[] = { 
			"Id",
			"Name",
			"VoteCount",
			"CreateBy",
			"UpdateBy",
			"CreateDate",
			"UpdateDate",
			"Image",
			"TbVote_topic_id"
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

	private List<Map<String, Object>> createExcelRecord(List<VoteChoice> list) {
		List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sheetName", "sheet1");
		listmap.add(map);
		VoteChoice voteChoice = null;
		for (int j = 0; j < list.size(); j++) {
			voteChoice = list.get(j);
			Map<String, Object> mapValue = new HashMap<String, Object>();
				mapValue.put("Id",voteChoice.getId());
				mapValue.put("Name",voteChoice.getName());
				mapValue.put("VoteCount",voteChoice.getVoteCount());
				mapValue.put("CreateBy",voteChoice.getCreateBy());
				mapValue.put("UpdateBy",voteChoice.getUpdateBy());
				mapValue.put("CreateDate",voteChoice.getCreateDate());
				mapValue.put("UpdateDate",voteChoice.getUpdateDate());
				mapValue.put("Image",voteChoice.getImage());
				/*mapValue.put("TbVote_topic_id",voteChoice.getTbVote_topic_id());*/
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
