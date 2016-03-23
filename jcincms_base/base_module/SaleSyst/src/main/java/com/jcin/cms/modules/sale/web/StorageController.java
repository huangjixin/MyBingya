/**
 * 一句话描述该类：前端控制器，提供页面跳转，访问方法返回JSON<br/>
 * @author 黄记新 <br/>
 * @date 2015-4-29,10:52 <br/>
 *
 */
package com.jcin.cms.modules.sale.web;

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
import com.jcin.cms.modules.sale.domain.Storage;
import com.jcin.cms.modules.sale.domain.StorageCriteria;
import com.jcin.cms.modules.sale.service.IStorageService;
import com.jcin.cms.utils.Page;
import com.jcin.cms.utils.ExcelUtil;
import com.jcin.cms.web.BaseController;

@Controller
@RequestMapping(value = "${adminPath}/storage")
public class StorageController extends BaseController<Storage>{
	@Autowired
	private IStorageService storageService;

//	@RequiresPermissions("storage:create")
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(Storage storage, Model uiModel) {
		uiModel.addAttribute("storage", storage);
		return root+"admin/modules/storage/storage_create.jsp";
	}

//	@RequiresPermissions("storage:create")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(Storage storage, RedirectAttributes redirectAttributes,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		storageService.insert(storage);
		
		redirectAttributes.addFlashAttribute("storage", storage);
		redirectAttributes.addFlashAttribute("msg", "新增成功");
		return "redirect:/"+Global.getAdminPath()+"/storage/create";
	}
	
//	@RequiresPermissions("storage:update")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String update(@PathVariable("id") String id, Model uiModel) {
		Storage storage = storageService.selectByPrimaryKey(id);
		uiModel.addAttribute("storage", storage);
		return root+"admin/modules/storage/storage_update.jsp";
	}

//	@RequiresPermissions("storage:update")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String update(Storage storage,RedirectAttributes redirectAttributes,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		storageService.update(storage);
		
		redirectAttributes.addFlashAttribute("msg", "修改成功");
		redirectAttributes.addFlashAttribute("storage", storage);
		return "redirect:/"+Global.getAdminPath()+"/storage/update/"+storage.getId();
	}

//	@RequiresPermissions("storage:show")
	@RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
	public String show(@PathVariable("id") String id, Model uiModel) {
		Storage storage = storageService.selectByPrimaryKey(id);
		
		uiModel.addAttribute("storage", storage);
		return root+"admin/modules/storage/storage_show.jsp";
	}

//	@RequiresPermissions("storage:view")
	@RequestMapping(value = { "", "list" })
	public String list(HttpServletRequest httpServletRequest) {
		return root+"admin/modules/storage/storage_list.jsp";
	}

//	@RequiresPermissions("storage:delete")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
	public String delete(@PathVariable("id") String id, Model uiModel) {
		storageService.deleteByPrimaryKey(id);
		uiModel.asMap().clear();
		return "redirect:/storage";
	}

	void populateEditForm(Model uiModel, Storage storage) {
		uiModel.addAttribute("storage", storage);
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

//	@RequiresPermissions("storage:view")
	@RequestMapping(value = "/select")
	@ResponseBody
	public Page select(@ModelAttribute Page page, @ModelAttribute Storage storage,Model uiModel,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		super.select(page, uiModel, httpServletRequest,
				httpServletResponse);
		StorageCriteria storageCriteria = new StorageCriteria();
		StorageCriteria.Criteria criteria = storageCriteria.createCriteria();
		storageCriteria.setPage(page);
		storageCriteria.setOrderByClause("id desc");
		if (null != storage.getId()  && !"".equals(storage.getId())) {
		  	criteria.andIdLike("%" + storage.getId() + "%");
		}
		if (null != storage.getProName()  && !"".equals(storage.getProName())) {
		  	criteria.andProNameLike("%" + storage.getProName() + "%");
		}
		if (null != storage.getProId()  && !"".equals(storage.getProId())) {
		  	criteria.andProIdLike("%" + storage.getProId() + "%");
		}
		if (null != storage.getBuyId()  && !"".equals(storage.getBuyId())) {
		  	criteria.andBuyIdLike("%" + storage.getBuyId() + "%");
		}
		if (null != storage.getSaleId()  && !"".equals(storage.getSaleId())) {
		  	criteria.andSaleIdLike("%" + storage.getSaleId() + "%");
		}
		page = storageService.select(storageCriteria);
		return page;
	}
	
//	@RequiresPermissions("storage:delete")
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
		int result = storageService.deleteBatch(list);

		return result;
	}
	
	/**
	 * 全部导出Excel.
	 * @param storage
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @throws IOException
	 */
//	@RequiresPermissions("storage:view")
	@RequestMapping(value = "/exportExcel")
	public void exportExcel(@ModelAttribute Storage storage,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		httpServletResponse.setCharacterEncoding("UTF-8");
		String filename = new String("用户信息".getBytes("GBK"), "iso8859-1");

		List<Storage>list = storageService.selectAll();

		List<Map<String, Object>> maps = createExcelRecord(list);

		String columnNames[] = { 
			"Id",
			"ProName",
			"ProId",
			"BuyId",
			"SaleId",
			"Procount"
		};// 列名
		String keys[] = { 
			"Id",
			"ProName",
			"ProId",
			"BuyId",
			"SaleId",
			"Procount"
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

	private List<Map<String, Object>> createExcelRecord(List<Storage> list) {
		List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sheetName", "sheet1");
		listmap.add(map);
		Storage storage = null;
		for (int j = 0; j < list.size(); j++) {
			storage = list.get(j);
			Map<String, Object> mapValue = new HashMap<String, Object>();
				mapValue.put("Id",storage.getId());
				mapValue.put("ProName",storage.getProName());
				mapValue.put("ProId",storage.getProId());
				mapValue.put("BuyId",storage.getBuyId());
				mapValue.put("SaleId",storage.getSaleId());
				mapValue.put("Procount",storage.getProcount());
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
