/**
 * 一句话描述该类：前端控制器，提供页面跳转，访问方法返回JSON<br/>
 * @author 黄记新 <br/>
 * @date 2015-4-29,10:52 <br/>
 *
 */
package com.jcin.cms.modules.pro.web;

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
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
import com.jcin.cms.modules.pro.domain.OrderComment;
import com.jcin.cms.modules.pro.domain.OrderCommentCriteria;
import com.jcin.cms.modules.pro.service.IOrderCommentService;
import com.jcin.cms.utils.Page;
import com.jcin.cms.utils.ExcelUtil;
import com.jcin.cms.web.BaseController;

@Controller
@RequestMapping(value = "${adminPath}/orderComment")
public class OrderCommentController extends BaseController<OrderComment>{
	@Autowired
	private IOrderCommentService orderCommentService;

//	@RequiresPermissions("orderComment:create")
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(OrderComment orderComment, Model uiModel) {
		uiModel.addAttribute("orderComment", orderComment);
		return root+"admin/modules/orderComment/orderComment_create.jsp";
	}

//	@RequiresPermissions("orderComment:create")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(OrderComment orderComment, RedirectAttributes redirectAttributes,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		orderCommentService.insert(orderComment);
		
		redirectAttributes.addFlashAttribute("orderComment", orderComment);
		redirectAttributes.addFlashAttribute("msg", "新增成功");
		return "redirect:/"+Global.getAdminPath()+"/orderComment/create";
	}
	
//	@RequiresPermissions("orderComment:update")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String update(@PathVariable("id") String id, Model uiModel) {
		OrderComment orderComment = orderCommentService.selectByPrimaryKey(id);
		uiModel.addAttribute("orderComment", orderComment);
		return root+"admin/modules/orderComment/orderComment_update.jsp";
	}

//	@RequiresPermissions("orderComment:update")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String update(OrderComment orderComment,RedirectAttributes redirectAttributes,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		orderCommentService.update(orderComment);
		
		redirectAttributes.addFlashAttribute("msg", "修改成功");
		redirectAttributes.addFlashAttribute("orderComment", orderComment);
		return "redirect:/"+Global.getAdminPath()+"/orderComment/update/"+orderComment.getId();
	}

//	@RequiresPermissions("orderComment:show")
	@RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
	public String show(@PathVariable("id") String id, Model uiModel) {
		OrderComment orderComment = orderCommentService.selectByPrimaryKey(id);
		
		uiModel.addAttribute("orderComment", orderComment);
		return root+"admin/modules/orderComment/orderComment_show.jsp";
	}

//	@RequiresPermissions("orderComment:view")
	@RequestMapping(value = { "", "list" })
	public String list(HttpServletRequest httpServletRequest) {
		return root+"admin/modules/orderComment/orderComment_list.jsp";
	}

//	@RequiresPermissions("orderComment:delete")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
	public String delete(@PathVariable("id") String id, Model uiModel) {
		orderCommentService.deleteByPrimaryKey(id);
		uiModel.asMap().clear();
		return "redirect:/orderComment";
	}

	void populateEditForm(Model uiModel, OrderComment orderComment) {
		uiModel.addAttribute("orderComment", orderComment);
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

//	@RequiresPermissions("orderComment:view")
	@RequestMapping(value = "/select")
	@ResponseBody
	public Page select(@ModelAttribute Page page, @ModelAttribute OrderComment orderComment,Model uiModel,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		super.select(page, uiModel, httpServletRequest,
				httpServletResponse);
		OrderCommentCriteria orderCommentCriteria = new OrderCommentCriteria();
		OrderCommentCriteria.Criteria criteria = orderCommentCriteria.createCriteria();
		orderCommentCriteria.setPage(page);
		orderCommentCriteria.setOrderByClause("id desc");
		if (null != orderComment.getId()  && !"".equals(orderComment.getId())) {
		  	criteria.andIdLike("%" + orderComment.getId() + "%");
		}
//		if (null != orderComment.getCreateDate()  && !"".equals(orderComment.getCreateDate())) {
//		  	criteria.andCreateDateLike("%" + orderComment.getCreateDate() + "%");
//		}
//		if (null != orderComment.getUpdateDate()  && !"".equals(orderComment.getUpdateDate())) {
//		  	criteria.andUpdateDateLike("%" + orderComment.getUpdateDate() + "%");
//		}
		if (null != orderComment.getContent()  && !"".equals(orderComment.getContent())) {
		  	criteria.andContentLike("%" + orderComment.getContent() + "%");
		}
		if (null != orderComment.getOrderId()  && !"".equals(orderComment.getOrderId())) {
		  	criteria.andOrderIdLike("%" + orderComment.getOrderId() + "%");
		}
		page = orderCommentService.select(orderCommentCriteria);
		return page;
	}
	
//	@RequiresPermissions("orderComment:delete")
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
		int result = orderCommentService.deleteBatch(list);

		return result;
	}
	
	/**
	 * 全部导出Excel.
	 * @param orderComment
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @throws IOException
	 */
//	@RequiresPermissions("orderComment:view")
	@RequestMapping(value = "/exportExcel")
	public void exportExcel(@ModelAttribute OrderComment orderComment,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		httpServletResponse.setCharacterEncoding("UTF-8");
		String filename = new String("用户信息".getBytes("GBK"), "iso8859-1");

		List<OrderComment>list = orderCommentService.selectAll();

		List<Map<String, Object>> maps = createExcelRecord(list);

		String columnNames[] = { 
			"Id",
			"CreateDate",
			"UpdateDate",
			"Content",
			"OrderId"
		};// 列名
		String keys[] = { 
			"Id",
			"CreateDate",
			"UpdateDate",
			"Content",
			"OrderId"
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

	private List<Map<String, Object>> createExcelRecord(List<OrderComment> list) {
		List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sheetName", "sheet1");
		listmap.add(map);
		OrderComment orderComment = null;
		for (int j = 0; j < list.size(); j++) {
			orderComment = list.get(j);
			Map<String, Object> mapValue = new HashMap<String, Object>();
				mapValue.put("Id",orderComment.getId());
				mapValue.put("CreateDate",orderComment.getCreateDate());
				mapValue.put("UpdateDate",orderComment.getUpdateDate());
				mapValue.put("Content",orderComment.getContent());
				mapValue.put("OrderId",orderComment.getOrderId());
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
