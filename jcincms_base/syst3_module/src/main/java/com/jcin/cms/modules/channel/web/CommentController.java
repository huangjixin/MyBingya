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

import javax.annotation.Resource;
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
import com.jcin.cms.modules.channel.domain.Comment;
import com.jcin.cms.modules.channel.domain.CommentCriteria;
import com.jcin.cms.modules.channel.service.ICommentService;
import com.jcin.cms.utils.Page;
import com.jcin.cms.utils.ExcelUtil;
import com.jcin.cms.web.BaseController;

@Controller
@RequestMapping(value = "admin/comment")
public class CommentController extends BaseController<Comment> {
	@Autowired
	private ICommentService commentService;

	// @RequiresPermissions("comment:create")
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(Comment comment, Model uiModel) {
		uiModel.addAttribute("comment", comment);
		return root+"admin/modules/comment/comment_create";
	}

	// @RequiresPermissions("comment:create")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(Comment comment,
			RedirectAttributes redirectAttributes, Model uiModel,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		commentService.insert(comment);

		redirectAttributes.addFlashAttribute("comment", comment);
		redirectAttributes.addFlashAttribute("msg", "新增成功");
		return "redirect:/" + Global.getAdminPath() + "/comment/create";
	}

	// @RequiresPermissions("comment:update")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String update(@PathVariable("id") String id, Model uiModel) {
		Comment comment = commentService.selectByPrimaryKey(id);
		uiModel.addAttribute("comment", comment);
		return root+"admin/modules/comment/comment_update";
	}

	// @RequiresPermissions("comment:update")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String update(Comment comment,
			RedirectAttributes redirectAttributes, Model uiModel,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		commentService.update(comment);

		redirectAttributes.addFlashAttribute("msg", "修改成功");
		redirectAttributes.addFlashAttribute("comment", comment);
		return "redirect:/" + Global.getAdminPath() + "/comment/update/"
				+ comment.getId();
	}

	// @RequiresPermissions("comment:show")
	@RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
	public String show(@PathVariable("id") String id, Model uiModel) {
		Comment comment = commentService.selectByPrimaryKey(id);

		uiModel.addAttribute("comment", comment);
		return root+"admin/modules/comment/comment_show";
	}

	// @RequiresPermissions("comment:view")
	@RequestMapping(value = { "", "list" })
	public String list(HttpServletRequest httpServletRequest) {
		return root+"admin/modules/comment/comment_list";
	}

	// @RequiresPermissions("comment:delete")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
	public String delete(@PathVariable("id") String id, Model uiModel) {
		commentService.deleteByPrimaryKey(id);
		uiModel.asMap().clear();
		return "redirect:/comment";
	}

	void populateEditForm(Model uiModel, Comment comment) {
		uiModel.addAttribute("comment", comment);
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

	// @RequiresPermissions("comment:view")
	@RequestMapping(value = "/select")
	@ResponseBody
	public Page select(@ModelAttribute Page page,
			@ModelAttribute Comment comment, Model uiModel,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		super.select(page, uiModel, httpServletRequest, httpServletResponse);
		CommentCriteria commentCriteria = new CommentCriteria();
		CommentCriteria.Criteria criteria = commentCriteria.createCriteria();
		commentCriteria.setPage(page);
		commentCriteria.setOrderByClause("id desc");
		if (null != comment.getId() && !"".equals(comment.getId())) {
			criteria.andIdLike("%" + comment.getId() + "%");
		}
		if (null != comment.getDocumentId()
				&& !"".equals(comment.getDocumentId())) {
			criteria.andDocumentIdLike("%" + comment.getDocumentId() + "%");
		}
		/*if (null != comment.getCreateDate()
				&& !"".equals(comment.getCreateDate())) {
			criteria.andCreateDateLike("%" + comment.getCreateDate() + "%");
		}
		if (null != comment.getUpdateDate()
				&& !"".equals(comment.getUpdateDate())) {
			criteria.andUpdateDateLike("%" + comment.getUpdateDate() + "%");
		}*/
		if (null != comment.getContent() && !"".equals(comment.getContent())) {
			criteria.andContentLike("%" + comment.getContent() + "%");
		}
		if (null != comment.getParentIds()
				&& !"".equals(comment.getParentIds())) {
			criteria.andParentIdsLike("%" + comment.getParentIds() + "%");
		}
		if (null != comment.getParentId() && !"".equals(comment.getParentId())) {
			criteria.andParentIdLike("%" + comment.getParentId() + "%");
		}
		/*if (null != comment.getHidden() && !"".equals(comment.getHidden())) {
			criteria.andHiddenLike("%" + comment.getHidden() + "%");
		}*/
		page = commentService.select(commentCriteria);
		return page;
	}

	// @RequiresPermissions("comment:delete")
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
		int result = commentService.deleteBatch(list);

		return result;
	}

	/**
	 * 全部导出Excel.
	 * 
	 * @param comment
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @throws IOException
	 */
	// @RequiresPermissions("comment:view")
	@RequestMapping(value = "/exportExcel")
	public void exportExcel(@ModelAttribute Comment comment,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		httpServletResponse.setCharacterEncoding("UTF-8");
		String filename = new String("用户信息".getBytes("GBK"), "iso8859-1");

		List<Comment> list = commentService.selectAll();

		List<Map<String, Object>> maps = createExcelRecord(list);

		String columnNames[] = { "Id", "DocumentId", "CreateDate",
				"UpdateDate", "Content", "ParentIds", "ParentId", "Hidden" };// 列名
		String keys[] = { "Id", "DocumentId", "CreateDate", "UpdateDate",
				"Content", "ParentIds", "ParentId", "Hidden" };// map中的key
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

	private List<Map<String, Object>> createExcelRecord(List<Comment> list) {
		List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sheetName", "sheet1");
		listmap.add(map);
		Comment comment = null;
		for (int j = 0; j < list.size(); j++) {
			comment = list.get(j);
			Map<String, Object> mapValue = new HashMap<String, Object>();
			mapValue.put("Id", comment.getId());
			mapValue.put("DocumentId", comment.getDocumentId());
			mapValue.put("CreateDate", comment.getCreateDate());
			mapValue.put("UpdateDate", comment.getUpdateDate());
			mapValue.put("Content", comment.getContent());
			mapValue.put("ParentIds", comment.getParentIds());
			mapValue.put("ParentId", comment.getParentId());
			mapValue.put("Hidden", comment.getHidden());
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
