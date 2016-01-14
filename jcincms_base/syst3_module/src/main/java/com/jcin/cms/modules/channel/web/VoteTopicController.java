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
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
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
import com.jcin.cms.common.UserUtils;
import com.jcin.cms.modules.channel.domain.VoteTopic;
import com.jcin.cms.modules.channel.domain.VoteTopicCriteria;
import com.jcin.cms.modules.channel.service.IVoteTopicService;
import com.jcin.cms.utils.Page;
import com.jcin.cms.utils.ExcelUtil;
import com.jcin.cms.web.BaseController;

@Controller
@RequestMapping(value = "${adminPath}/voteTopic")
public class VoteTopicController extends BaseController<VoteTopic>{
	@Autowired
	private IVoteTopicService voteTopicService;

//	@RequiresPermissions("voteTopic:create")
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(VoteTopic voteTopic, Model uiModel) {
		uiModel.addAttribute("voteTopic", voteTopic);
		return root+"admin/modules/voteTopic/voteTopic_create.jsp";
	}

//	@RequiresPermissions("voteTopic:create")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(VoteTopic voteTopic, RedirectAttributes redirectAttributes,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		voteTopic.setCreateBy(UserUtils.getUsername());
		voteTopic.setUpdateBy(UserUtils.getUsername());
		voteTopic.setCreateDate(new Date());
		voteTopic.setUpdateDate(new Date());
		voteTopicService.insert(voteTopic);
		
		redirectAttributes.addFlashAttribute("voteTopic", voteTopic);
		redirectAttributes.addFlashAttribute("msg", "新增成功");
		return "redirect:/"+Global.getAdminPath()+"/voteTopic/create";
	}
	
//	@RequiresPermissions("voteTopic:update")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String update(@PathVariable("id") String id, Model uiModel) {
		VoteTopic voteTopic = voteTopicService.selectByPrimaryKey(id);
		uiModel.addAttribute("voteTopic", voteTopic);
		return root+"admin/modules/voteTopic/voteTopic_update.jsp";
	}

//	@RequiresPermissions("voteTopic:update")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String update(VoteTopic voteTopic,RedirectAttributes redirectAttributes,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		voteTopic.setUpdateBy(UserUtils.getUsername());
		voteTopic.setUpdateDate(new Date());
		voteTopicService.update(voteTopic);
		
		redirectAttributes.addFlashAttribute("msg", "修改成功");
		redirectAttributes.addFlashAttribute("voteTopic", voteTopic);
		return "redirect:/"+Global.getAdminPath()+"/voteTopic/update/"+voteTopic.getId();
	}

//	@RequiresPermissions("voteTopic:show")
	@RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
	public String show(@PathVariable("id") String id, Model uiModel) {
		VoteTopic voteTopic = voteTopicService.selectByPrimaryKey(id);
		
		uiModel.addAttribute("voteTopic", voteTopic);
		return root+"admin/modules/voteTopic/voteTopic_show.jsp";
	}

//	@RequiresPermissions("voteTopic:view")
	@RequestMapping(value = { "", "list" })
	public String list(HttpServletRequest httpServletRequest) {
		return root+"admin/modules/voteTopic/voteTopic_list.jsp";
	}

//	@RequiresPermissions("voteTopic:delete")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
	public String delete(@PathVariable("id") String id, Model uiModel) {
		voteTopicService.deleteByPrimaryKey(id);
		uiModel.asMap().clear();
		return "redirect:/voteTopic";
	}

	void populateEditForm(Model uiModel, VoteTopic voteTopic) {
		uiModel.addAttribute("voteTopic", voteTopic);
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

//	@RequiresPermissions("voteTopic:view")
	@RequestMapping(value = "/select")
	@ResponseBody
	public Page select(@ModelAttribute Page page, @ModelAttribute VoteTopic voteTopic,Model uiModel,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		super.select(page, uiModel, httpServletRequest,
				httpServletResponse);
		VoteTopicCriteria voteTopicCriteria = new VoteTopicCriteria();
		VoteTopicCriteria.Criteria criteria = voteTopicCriteria.createCriteria();
		voteTopicCriteria.setPage(page);
		voteTopicCriteria.setOrderByClause("id desc");
		if (null != voteTopic.getId()  && !"".equals(voteTopic.getId())) {
		  	criteria.andIdLike("%" + voteTopic.getId() + "%");
		}
		if (null != voteTopic.getType()  && !"".equals(voteTopic.getType())) {
		  	criteria.andTypeLike("%" + voteTopic.getType() + "%");
		}
		/*if (null != voteTopic.getEndTime()  && !"".equals(voteTopic.getEndTime())) {
		  	criteria.andEndTimeLike("%" + voteTopic.getEndTime() + "%");
		}*/
		if (null != voteTopic.getIntroduction()  && !"".equals(voteTopic.getIntroduction())) {
		  	criteria.andIntroductionLike("%" + voteTopic.getIntroduction() + "%");
		}
		if (null != voteTopic.getCreateBy()  && !"".equals(voteTopic.getCreateBy())) {
		  	criteria.andCreateByLike("%" + voteTopic.getCreateBy() + "%");
		}
		if (null != voteTopic.getUpdateBy()  && !"".equals(voteTopic.getUpdateBy())) {
		  	criteria.andUpdateByLike("%" + voteTopic.getUpdateBy() + "%");
		}
		/*if (null != voteTopic.getCreateDate()  && !"".equals(voteTopic.getCreateDate())) {
		  	criteria.andCreateDateLike("%" + voteTopic.getCreateDate() + "%");
		}
		if (null != voteTopic.getUpdateDate()  && !"".equals(voteTopic.getUpdateDate())) {
		  	criteria.andUpdateDateLike("%" + voteTopic.getUpdateDate() + "%");
		}*/
		if (null != voteTopic.getName()  && !"".equals(voteTopic.getName())) {
		  	criteria.andNameLike("%" + voteTopic.getName() + "%");
		}
		page = voteTopicService.select(voteTopicCriteria);
		return page;
	}
	
//	@RequiresPermissions("voteTopic:delete")
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
		int result = voteTopicService.deleteBatch(list);

		return result;
	}
	
	/**
	 * 全部导出Excel.
	 * @param voteTopic
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @throws IOException
	 */
//	@RequiresPermissions("voteTopic:view")
	@RequestMapping(value = "/exportExcel")
	public void exportExcel(@ModelAttribute VoteTopic voteTopic,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		httpServletResponse.setCharacterEncoding("UTF-8");
		String filename = new String("用户信息".getBytes("GBK"), "iso8859-1");

		List<VoteTopic>list = voteTopicService.selectAll();

		List<Map<String, Object>> maps = createExcelRecord(list);

		String columnNames[] = { 
			"Id",
			"Type",
			"EndTime",
			"Introduction",
			"CreateBy",
			"UpdateBy",
			"CreateDate",
			"UpdateDate",
			"Name"
		};// 列名
		String keys[] = { 
			"Id",
			"Type",
			"EndTime",
			"Introduction",
			"CreateBy",
			"UpdateBy",
			"CreateDate",
			"UpdateDate",
			"Name"
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

	private List<Map<String, Object>> createExcelRecord(List<VoteTopic> list) {
		List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sheetName", "sheet1");
		listmap.add(map);
		VoteTopic voteTopic = null;
		for (int j = 0; j < list.size(); j++) {
			voteTopic = list.get(j);
			Map<String, Object> mapValue = new HashMap<String, Object>();
				mapValue.put("Id",voteTopic.getId());
				mapValue.put("Type",voteTopic.getType());
				mapValue.put("EndTime",voteTopic.getEndTime());
				mapValue.put("Introduction",voteTopic.getIntroduction());
				mapValue.put("CreateBy",voteTopic.getCreateBy());
				mapValue.put("UpdateBy",voteTopic.getUpdateBy());
				mapValue.put("CreateDate",voteTopic.getCreateDate());
				mapValue.put("UpdateDate",voteTopic.getUpdateDate());
				mapValue.put("Name",voteTopic.getName());
			listmap.add(mapValue);
		}
		return listmap;
	}
	
	/*@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, true));
	}*/
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
