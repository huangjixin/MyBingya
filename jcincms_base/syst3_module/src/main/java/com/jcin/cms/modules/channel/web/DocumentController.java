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

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.ss.usermodel.Workbook;
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
import com.jcin.cms.modules.channel.domain.Channel;
import com.jcin.cms.modules.channel.domain.Document;
import com.jcin.cms.modules.channel.domain.DocumentCriteria;
import com.jcin.cms.modules.channel.service.IChannelService;
import com.jcin.cms.modules.channel.service.IDocumentService;
import com.jcin.cms.utils.ExcelUtil;
import com.jcin.cms.utils.Page;
import com.jcin.cms.web.BaseController;

@Controller
@RequestMapping(value = "${adminPath}/document")
public class DocumentController extends BaseController<Document>{
	@Resource
	private IDocumentService documentService;
	@Resource
	private IChannelService channelService;

//	@RequiresPermissions("document:create")
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(Document document, Model uiModel) {
		uiModel.addAttribute("document", document);
		return "admin/modules/document/document_create";
	}

//	@RequiresPermissions("document:create")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(@Valid Document document, BindingResult bindingResult, RedirectAttributes redirectAttributes,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		if(bindingResult.hasErrors()){
			 populateEditForm(uiModel, document);
	         return "admin/modules/document/document_create";
		}
		if("".equals(document.getChannelId()) && null ==document.getChannelId()){
			populateEditForm(uiModel, document);
			uiModel.addAttribute("msg", "请选中栏目");
			return "admin/modules/document/document_create";
		}
		documentService.insert(document);
		
		redirectAttributes.addFlashAttribute("document", document);
		redirectAttributes.addFlashAttribute("msg", "新增成功");
		return "redirect:/"+Global.getAdminPath()+"/document/create";
	}
	
//	@RequiresPermissions("document:update")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String update(@PathVariable("id") String id, Model uiModel) {
		Document document = documentService.selectByPrimaryKey(id);
		uiModel.addAttribute("document", document);
		return "admin/modules/document/document_update";
	}

//	@RequiresPermissions("document:update")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String update(Document document,RedirectAttributes redirectAttributes,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		documentService.update(document);
		
		redirectAttributes.addFlashAttribute("msg", "修改成功");
		redirectAttributes.addFlashAttribute("document", document);
		return "redirect:/"+Global.getAdminPath()+"/document/update/"+document.getId();
	}

//	@RequiresPermissions("document:show")
	@RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
	public String show(@PathVariable("id") String id, Model uiModel) {
		Document document = documentService.selectByPrimaryKey(id);
		
		uiModel.addAttribute("document", document);
		return "admin/modules/document/document_show";
	}

//	@RequiresPermissions("document:view")
	@RequestMapping(value = { "", "list" })
	public String list(HttpServletRequest httpServletRequest) {
		return "admin/modules/document/document_list";
	}

//	@RequiresPermissions("document:delete")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
	public String delete(@PathVariable("id") String id, Model uiModel) {
		documentService.deleteByPrimaryKey(id);
		uiModel.asMap().clear();
		return "redirect:/document";
	}

	void populateEditForm(Model uiModel, Document document) {
		uiModel.addAttribute("document", document);
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

	@RequestMapping(value = "/getChannelTree")
	@ResponseBody
	public List<Channel> getChannelTree(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		List<Channel> list = channelService.getChannelTree(null);
		return list;
	}
	
//	@RequiresPermissions("document:view")
	@RequestMapping(value = "/select")
	@ResponseBody
	public Page select(@ModelAttribute Page page, @ModelAttribute Document document,Model uiModel,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		super.select(page, uiModel, httpServletRequest,
				httpServletResponse);
		DocumentCriteria documentCriteria = new DocumentCriteria();
		DocumentCriteria.Criteria criteria = documentCriteria.createCriteria();
		documentCriteria.setPage(page);
		documentCriteria.setOrderByClause("id desc");
		if (null != document.getId()  && !"".equals(document.getId())) {
		  	criteria.andIdLike("%" + document.getId() + "%");
		}
		if (null != document.getChannelId()  && !"".equals(document.getChannelId())) {
		  	criteria.andChannelIdLike("%" + document.getChannelId() + "%");
		}
		if (null != document.getTitle()  && !"".equals(document.getTitle())) {
		  	criteria.andTitleLike("%" + document.getTitle() + "%");
		}
		if (null != document.getColor()  && !"".equals(document.getColor())) {
		  	criteria.andColorLike("%" + document.getColor() + "%");
		}
		if (null != document.getKeyword()  && !"".equals(document.getKeyword())) {
		  	criteria.andKeywordLike("%" + document.getKeyword() + "%");
		}
		if (null != document.getDescrition()  && !"".equals(document.getDescrition())) {
		  	criteria.andDescritionLike("%" + document.getDescrition() + "%");
		}
		if (null != document.getPriority()  && !"".equals(document.getPriority())) {
		  	criteria.andPriorityEqualTo(document.getPriority());
		}
		if (null != document.getSource()  && !"".equals(document.getSource())) {
		  	criteria.andSourceLike("%" + document.getSource() + "%");
		}
		if (null != document.getSourceAddr()  && !"".equals(document.getSourceAddr())) {
		  	criteria.andSourceAddrLike("%" + document.getSourceAddr() + "%");
		}
		if (null != document.getAuthor()  && !"".equals(document.getAuthor())) {
		  	criteria.andAuthorLike("%" + document.getAuthor() + "%");
		}
		if (null != document.getTitleImage()  && !"".equals(document.getTitleImage())) {
		  	criteria.andTitleImageLike("%" + document.getTitleImage() + "%");
		}
		if (null != document.getFileName()  && !"".equals(document.getFileName())) {
		  	criteria.andFileNameLike("%" + document.getFileName() + "%");
		}
		if (null != document.getFileAddr()  && !"".equals(document.getFileAddr())) {
		  	criteria.andFileAddrLike("%" + document.getFileAddr() + "%");
		}
		page = documentService.select(documentCriteria);
		return page;
	}
	
//	@RequiresPermissions("document:delete")
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
		int result = documentService.deleteBatch(list);

		return result;
	}
	
	/**
	 * 全部导出Excel.
	 * @param document
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @throws IOException
	 */
//	@RequiresPermissions("document:view")
	@RequestMapping(value = "/exportExcel")
	public void exportExcel(@ModelAttribute Document document,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		httpServletResponse.setCharacterEncoding("UTF-8");
		String filename = new String("用户信息".getBytes("GBK"), "iso8859-1");

		List<Document>list = documentService.selectAll();

		List<Map<String, Object>> maps = createExcelRecord(list);

		String columnNames[] = { 
			"Id",
			"ChannelId",
			"Title",
			"Color",
			"Keyword",
			"Desc",
			"Priority",
			"Source",
			"SourceAddr",
			"Author",
			"TitleImage",
			"FileName",
			"FileAddr",
			"Size",
			"Content"
		};// 列名
		String keys[] = { 
			"Id",
			"ChannelId",
			"Title",
			"Color",
			"Keyword",
			"getDescrition",
			"Priority",
			"Source",
			"SourceAddr",
			"Author",
			"TitleImage",
			"FileName",
			"FileAddr",
			"Size",
			"Content"
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

	private List<Map<String, Object>> createExcelRecord(List<Document> list) {
		List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sheetName", "sheet1");
		listmap.add(map);
		Document document = null;
		for (int j = 0; j < list.size(); j++) {
			document = list.get(j);
			Map<String, Object> mapValue = new HashMap<String, Object>();
				mapValue.put("Id",document.getId());
				mapValue.put("ChannelId",document.getChannelId());
				mapValue.put("Title",document.getTitle());
				mapValue.put("Color",document.getColor());
				mapValue.put("Keyword",document.getKeyword());
				mapValue.put("getDescrition",document.getDescrition());
				mapValue.put("Priority",document.getPriority());
				mapValue.put("Source",document.getSource());
				mapValue.put("SourceAddr",document.getSourceAddr());
				mapValue.put("Author",document.getAuthor());
				mapValue.put("TitleImage",document.getTitleImage());
				mapValue.put("FileName",document.getFileName());
				mapValue.put("FileAddr",document.getFileAddr());
				mapValue.put("Size",document.getSize());
				mapValue.put("Content",document.getContent());
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