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
import com.jcin.cms.modules.pro.domain.Images;
import com.jcin.cms.modules.pro.domain.ImagesCriteria;
import com.jcin.cms.modules.pro.service.IImagesService;
import com.jcin.cms.utils.Page;
import com.jcin.cms.utils.ExcelUtil;
import com.jcin.cms.web.BaseController;

@Controller
@RequestMapping(value = "${adminPath}/images")
public class ImagesController extends BaseController<Images>{
	@Autowired
	private IImagesService imagesService;

//	@RequiresPermissions("images:create")
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(Images images, Model uiModel) {
		uiModel.addAttribute("images", images);
		return root+"admin/modules/images/images_create.jsp";
	}

//	@RequiresPermissions("images:create")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(Images images, RedirectAttributes redirectAttributes,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		imagesService.insert(images);
		
		redirectAttributes.addFlashAttribute("images", images);
		redirectAttributes.addFlashAttribute("msg", "新增成功");
		return "redirect:/"+Global.getAdminPath()+"/images/create";
	}
	
//	@RequiresPermissions("images:update")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String update(@PathVariable("id") String id, Model uiModel) {
		Images images = imagesService.selectByPrimaryKey(id);
		uiModel.addAttribute("images", images);
		return root+"admin/modules/images/images_update.jsp";
	}

//	@RequiresPermissions("images:update")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String update(Images images,RedirectAttributes redirectAttributes,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		imagesService.update(images);
		
		redirectAttributes.addFlashAttribute("msg", "修改成功");
		redirectAttributes.addFlashAttribute("images", images);
		return "redirect:/"+Global.getAdminPath()+"/images/update/"+images.getId();
	}

//	@RequiresPermissions("images:show")
	@RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
	public String show(@PathVariable("id") String id, Model uiModel) {
		Images images = imagesService.selectByPrimaryKey(id);
		
		uiModel.addAttribute("images", images);
		return root+"admin/modules/images/images_show.jsp";
	}

//	@RequiresPermissions("images:view")
	@RequestMapping(value = { "", "list" })
	public String list(HttpServletRequest httpServletRequest) {
		return root+"admin/modules/images/images_list.jsp";
	}

//	@RequiresPermissions("images:delete")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
	public String delete(@PathVariable("id") String id, Model uiModel) {
		imagesService.deleteByPrimaryKey(id);
		uiModel.asMap().clear();
		return "redirect:/images";
	}

	void populateEditForm(Model uiModel, Images images) {
		uiModel.addAttribute("images", images);
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

//	@RequiresPermissions("images:view")
	@RequestMapping(value = "/select")
	@ResponseBody
	public Page select(@ModelAttribute Page page, @ModelAttribute Images images,Model uiModel,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		super.select(page, uiModel, httpServletRequest,
				httpServletResponse);
		ImagesCriteria imagesCriteria = new ImagesCriteria();
		ImagesCriteria.Criteria criteria = imagesCriteria.createCriteria();
		imagesCriteria.setPage(page);
		imagesCriteria.setOrderByClause("id desc");
		if (null != images.getId()  && !"".equals(images.getId())) {
		  	criteria.andIdLike("%" + images.getId() + "%");
		}
		if (null != images.getSite()  && !"".equals(images.getSite())) {
		  	criteria.andSiteLike("%" + images.getSite() + "%");
		}
//		if (null != images.getProProduct_id()  && !"".equals(images.getProProduct_id())) {
//		  	criteria.andProProduct_idLike("%" + images.getProProduct_id() + "%");
//		}
		if (null != images.getPosition()  && !"".equals(images.getPosition())) {
		  	criteria.andPositionLike("%" + images.getPosition() + "%");
		}
//		if (null != images.getSortid()  && !"".equals(images.getSortid())) {
//		  	criteria.andSortidLike("%" + images.getSortid() + "%");
//		}
//		if (null != images.getIsmasterpic()  && !"".equals(images.getIsmasterpic())) {
//		  	criteria.andIsmasterpicLike("%" + images.getIsmasterpic() + "%");
//		}
//		if (null != images.getCreateDate()  && !"".equals(images.getCreateDate())) {
//		  	criteria.andCreateDateLike("%" + images.getCreateDate() + "%");
//		}
//		if (null != images.getUpdateDate()  && !"".equals(images.getUpdateDate())) {
//		  	criteria.andUpdateDateLike("%" + images.getUpdateDate() + "%");
//		}
		page = imagesService.select(imagesCriteria);
		return page;
	}
	
//	@RequiresPermissions("images:delete")
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
		int result = imagesService.deleteBatch(list);

		return result;
	}
	
	/**
	 * 全部导出Excel.
	 * @param images
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @throws IOException
	 */
//	@RequiresPermissions("images:view")
	@RequestMapping(value = "/exportExcel")
	public void exportExcel(@ModelAttribute Images images,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		httpServletResponse.setCharacterEncoding("UTF-8");
		String filename = new String("用户信息".getBytes("GBK"), "iso8859-1");

		List<Images>list = imagesService.selectAll();

		List<Map<String, Object>> maps = createExcelRecord(list);

		String columnNames[] = { 
			"Id",
			"Site",
			"ProProduct_id",
			"Position",
			"Sortid",
			"Ismasterpic",
			"CreateDate",
			"UpdateDate"
		};// 列名
		String keys[] = { 
			"Id",
			"Site",
			"ProProduct_id",
			"Position",
			"Sortid",
			"Ismasterpic",
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

	private List<Map<String, Object>> createExcelRecord(List<Images> list) {
		List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sheetName", "sheet1");
		listmap.add(map);
		Images images = null;
		for (int j = 0; j < list.size(); j++) {
			images = list.get(j);
			Map<String, Object> mapValue = new HashMap<String, Object>();
				mapValue.put("Id",images.getId());
				mapValue.put("Site",images.getSite());
//				mapValue.put("ProProduct_id",images.getProProduct_id());
				mapValue.put("Position",images.getPosition());
				mapValue.put("Sortid",images.getSortid());
				mapValue.put("Ismasterpic",images.getIsmasterpic());
				mapValue.put("CreateDate",images.getCreateDate());
				mapValue.put("UpdateDate",images.getUpdateDate());
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
