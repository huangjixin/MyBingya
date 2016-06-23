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
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.shiro.authz.annotation.RequiresPermissions;
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
import com.jcin.cms.modules.channel.domain.Assets;
import com.jcin.cms.modules.channel.domain.AssetsCriteria;
import com.jcin.cms.modules.channel.service.IAssetsService;
import com.jcin.cms.utils.Page;
import com.jcin.cms.utils.ExcelUtil;
import com.jcin.cms.web.BaseController;

@Controller
@RequestMapping(value = "admin/assets")
public class AssetsController extends BaseController<Assets>{
	@Autowired
	private IAssetsService assetsService;

	@RequiresPermissions("assets:create")
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(Assets assets, Model uiModel) {
		uiModel.addAttribute("assets", assets);
		return root+"admin/modules/assets/assets_create.jsp";
	}

	@RequiresPermissions("assets:create")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(Assets assets, RedirectAttributes redirectAttributes,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		assetsService.insert(assets);
		
		redirectAttributes.addFlashAttribute("assets", assets);
		redirectAttributes.addFlashAttribute("msg", "新增成功");
		return "redirect:/"+Global.getAdminPath()+"/assets/create";
	}
	
	@RequiresPermissions("assets:update")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String update(@PathVariable("id") String id, Model uiModel) {
		Assets assets = assetsService.selectByPrimaryKey(id);
		uiModel.addAttribute("assets", assets);
		return root+"admin/modules/assets/assets_update.jsp";
	}

	@RequiresPermissions("assets:update")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String update(Assets assets,RedirectAttributes redirectAttributes,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		assetsService.update(assets);
		
		redirectAttributes.addFlashAttribute("msg", "修改成功");
		redirectAttributes.addFlashAttribute("assets", assets);
		return "redirect:/"+Global.getAdminPath()+"/assets/update/"+assets.getId();
	}

	@RequiresPermissions("assets:show")
	@RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
	public String show(@PathVariable("id") String id, Model uiModel) {
		Assets assets = assetsService.selectByPrimaryKey(id);
		
		uiModel.addAttribute("assets", assets);
		return root+"admin/modules/assets/assets_show.jsp";
	}

	@RequiresPermissions("assets:view")
	@RequestMapping(value = { "", "list" })
	public String list(HttpServletRequest httpServletRequest) {
		return root+"admin/modules/assets/assets_list.jsp";
	}

//	@RequiresPermissions("assets:delete")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
	public String delete(@PathVariable("id") String id, Model uiModel) {
		assetsService.deleteByPrimaryKey(id);
		uiModel.asMap().clear();
		return "redirect:/assets";
	}

	void populateEditForm(Model uiModel, Assets assets) {
		uiModel.addAttribute("assets", assets);
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

	@RequiresPermissions("assets:view")
	@RequestMapping(value = "/select")
	@ResponseBody
	public Page select(@ModelAttribute Page page, @ModelAttribute Assets assets,Model uiModel,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		super.select(page, uiModel, httpServletRequest,
				httpServletResponse);
		AssetsCriteria assetsCriteria = new AssetsCriteria();
		AssetsCriteria.Criteria criteria = assetsCriteria.createCriteria();
		assetsCriteria.setPage(page);
		assetsCriteria.setOrderByClause("id desc");
		if (null != assets.getId()  && !"".equals(assets.getId())) {
		  	criteria.andIdLike("%" + assets.getId() + "%");
		}
		if (null != assets.getName()  && !"".equals(assets.getName())) {
		  	criteria.andNameLike("%" + assets.getName() + "%");
		}
		if (null != assets.getPath()  && !"".equals(assets.getPath())) {
		  	criteria.andPathLike("%" + assets.getPath() + "%");
		}
		if (null != assets.getUrl()  && !"".equals(assets.getUrl())) {
		  	criteria.andUrlLike("%" + assets.getUrl() + "%");
		}
//		if (null != assets.getCreateDate()  && !"".equals(assets.getCreateDate())) {
//		  	criteria.andCreateDateLike("%" + assets.getCreateDate() + "%");
//		}
//		if (null != assets.getUpdateDate()  && !"".equals(assets.getUpdateDate())) {
//		  	criteria.andUpdateDateLike("%" + assets.getUpdateDate() + "%");
//		}
//		if (null != assets.getSize()  && !"".equals(assets.getSize())) {
//		  	criteria.andSizeLike("%" + assets.getSize() + "%");
//		}
		page = assetsService.select(assetsCriteria);
		return page;
	}
	
	@RequiresPermissions("assets:delete")
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
		int result = assetsService.deleteBatch(list);

		return result;
	}
	
	/**
	 * 全部导出Excel.
	 * @param assets
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @throws IOException
	 */
	@RequiresPermissions("assets:view")
	@RequestMapping(value = "/exportExcel")
	public void exportExcel(@ModelAttribute Assets assets,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		httpServletResponse.setCharacterEncoding("UTF-8");
		String filename = new String("用户信息".getBytes("GBK"), "iso8859-1");

		List<Assets>list = assetsService.selectAll();

		List<Map<String, Object>> maps = createExcelRecord(list);

		String columnNames[] = { 
			"Id",
			"Name",
			"Path",
			"Url",
			"CreateDate",
			"UpdateDate",
			"Size"
		};// 列名
		String keys[] = { 
			"Id",
			"Name",
			"Path",
			"Url",
			"CreateDate",
			"UpdateDate",
			"Size"
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

	private List<Map<String, Object>> createExcelRecord(List<Assets> list) {
		List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sheetName", "sheet1");
		listmap.add(map);
		Assets assets = null;
		for (int j = 0; j < list.size(); j++) {
			assets = list.get(j);
			Map<String, Object> mapValue = new HashMap<String, Object>();
				mapValue.put("Id",assets.getId());
				mapValue.put("Name",assets.getName());
				mapValue.put("Path",assets.getPath());
				mapValue.put("Url",assets.getUrl());
				mapValue.put("CreateDate",assets.getCreateDate());
				mapValue.put("UpdateDate",assets.getUpdateDate());
				mapValue.put("Size",assets.getSize());
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
