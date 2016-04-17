/**
 * 一句话描述该类：前端控制器，提供页面跳转，访问方法返回JSON<br/>
 * @author 黄记新 <br/>
 * @date 2015-4-29,10:52 <br/>
 *
 */
package com.jcin.cms.modules.channel.web;

import java.io.File;
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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

import com.jcin.cms.common.FileUtils;
import com.jcin.cms.common.FreeMarkerUtil;
import com.jcin.cms.common.Global;
import com.jcin.cms.common.UserUtils;
import com.jcin.cms.modules.channel.domain.Assets;
import com.jcin.cms.modules.channel.domain.Channel;
import com.jcin.cms.modules.channel.domain.Document;
import com.jcin.cms.modules.channel.domain.DocumentCriteria;
import com.jcin.cms.modules.channel.domain.FileVO;
import com.jcin.cms.modules.channel.service.IAssetsService;
import com.jcin.cms.modules.channel.service.IChannelService;
import com.jcin.cms.modules.channel.service.IDocumentService;
import com.jcin.cms.utils.ExcelUtil;
import com.jcin.cms.utils.Page;
import com.jcin.cms.web.BaseController;

@Controller
@RequestMapping(value = "admin/document")
public class DocumentController extends BaseController<Document> {
	private static Map<String, Object> cache = new HashMap<String, Object>();

	private static final String FILES_CACHE = "filesCache";// 文件缓存。

	@Resource
	private IDocumentService documentService;
	@Resource
	private IChannelService channelService;
	@Resource
	private IAssetsService assetsService;

	@RequiresPermissions("document:create")
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(Document document, Model uiModel) {
		uiModel.addAttribute("document", document);
		return root + "admin/modules/document/document_create.jsp";
	}

	@RequiresPermissions("document:create")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(@Valid Document document, BindingResult bindingResult,
			RedirectAttributes redirectAttributes, Model uiModel,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		/*
		 * if (bindingResult.hasErrors()) { populateEditForm(uiModel, document);
		 * return root+"admin/modules/document/document_create"; }
		 */
		if ("".equals(document.getChannelId())
				|| null == document.getChannelId()) {
			populateEditForm(uiModel, document);
			uiModel.addAttribute("msg", "请选中栏目");
			return root + "admin/modules/document/document_create.jsp";
		}
		documentService.insert(document);
		
		redirectAttributes.addFlashAttribute("msg", "新增成功");
		if(document.getAutoGenerate()){
			try {
				generateChannelDocs(document.getChannelId(),document, httpServletRequest, httpServletResponse);
			} catch (IOException e) {
				redirectAttributes.addFlashAttribute("msg", "新增成功,但是生成html文件有误，请检查模板或者路径");
				e.printStackTrace();
			}
		}
		redirectAttributes.addFlashAttribute("document", document);
		
		return "redirect:/" + Global.getAdminPath() + "/document/create";
	}

	@RequiresPermissions("document:update")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String update(@PathVariable("id") String id,@RequestParam(value="pageNumber")Integer pageNumber, Model uiModel) {
		Document document = documentService.selectByPrimaryKey(id);
		uiModel.addAttribute("document", document);
		uiModel.addAttribute("pageNumber", pageNumber);
		return root + "admin/modules/document/document_update.jsp";
	}

	@RequiresPermissions("document:update")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String update(Document document,
			RedirectAttributes redirectAttributes, Model uiModel,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		documentService.update(document);

		redirectAttributes.addFlashAttribute("msg", "修改成功");
		if(document.getAutoGenerate()){
			try {
				generateChannelDocs(document.getChannelId(),document, httpServletRequest, httpServletResponse);
			} catch (IOException e) {
				redirectAttributes.addFlashAttribute("msg", "修改成功,但是生成html文件有误，请检查模板或者路径");
				e.printStackTrace();
			}
		}
		redirectAttributes.addFlashAttribute("document", document);
		return "redirect:/" + Global.getAdminPath() + "/document/update/"
				+ document.getId();
	}

	@RequiresPermissions("document:show")
	@RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
	public String show(@PathVariable("id") String id, Model uiModel) {
		Document document = documentService.selectByPrimaryKey(id);

		uiModel.addAttribute("document", document);
		return root + "admin/modules/document/document_show.jsp";
	}

	@RequiresPermissions("document:view")
	@RequestMapping(value = { "", "list" })
	public String list(@RequestParam(value="pageNumber",required=false)Integer pageNumber,Model uiModel,HttpServletRequest httpServletRequest) {
		uiModel.addAttribute("pageNumber", pageNumber);
		return root + "admin/modules/document/document_list.jsp";
	}

	@RequiresPermissions("document:delete")
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

	@RequiresPermissions("document:view")
	@RequestMapping(value = "/select")
	@ResponseBody
	public Page select(@ModelAttribute Page page,
			@ModelAttribute Document document, Model uiModel,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		super.select(page, uiModel, httpServletRequest, httpServletResponse);
		DocumentCriteria documentCriteria = new DocumentCriteria();
		DocumentCriteria.Criteria criteria = documentCriteria.createCriteria();
		documentCriteria.setPage(page);
		documentCriteria.setOrderByClause("id desc");
		if (null != document.getId() && !"".equals(document.getId())) {
			criteria.andIdLike("%" + document.getId() + "%");
		}
		if (null != document.getDocumentTemplete()
				&& !"".equals(document.getDocumentTemplete())) {
			criteria.andDocumentTempleteLike("%"
					+ document.getDocumentTemplete() + "%");
		}
		if (null != document.getChannelId()
				&& !"".equals(document.getChannelId())) {
			criteria.andChannelIdLike("%" + document.getChannelId() + "%");
		}
		if (null != document.getTitle() && !"".equals(document.getTitle())) {
			criteria.andTitleLike("%" + document.getTitle() + "%");
		}
		if (null != document.getColor() && !"".equals(document.getColor())) {
			criteria.andColorLike("%" + document.getColor() + "%");
		}
		if (null != document.getKeyword() && !"".equals(document.getKeyword())) {
			criteria.andKeywordLike("%" + document.getKeyword() + "%");
		}
		if (null != document.getDescrition()
				&& !"".equals(document.getDescrition())) {
			criteria.andDescritionLike("%" + document.getDescrition() + "%");
		}
		if (null != document.getPriority()
				&& !"".equals(document.getPriority())) {
			criteria.andPriorityEqualTo(document.getPriority());
		}
		if (null != document.getSource() && !"".equals(document.getSource())) {
			criteria.andSourceLike("%" + document.getSource() + "%");
		}
		if (null != document.getSourceAddr()
				&& !"".equals(document.getSourceAddr())) {
			criteria.andSourceAddrLike("%" + document.getSourceAddr() + "%");
		}
		if (null != document.getAuthor() && !"".equals(document.getAuthor())) {
			criteria.andAuthorLike("%" + document.getAuthor() + "%");
		}
		if (null != document.getTitleImage()
				&& !"".equals(document.getTitleImage())) {
			criteria.andTitleImageLike("%" + document.getTitleImage() + "%");
		}
		if (null != document.getFileName()
				&& !"".equals(document.getFileName())) {
			criteria.andFileNameLike("%" + document.getFileName() + "%");
		}
		if (null != document.getFileAddr()
				&& !"".equals(document.getFileAddr())) {
			criteria.andFileAddrLike("%" + document.getFileAddr() + "%");
		}
		page = documentService.select(documentCriteria);
		return page;
	}

	@RequiresPermissions("document:delete")
	@RequestMapping(value = "/deleteById")
	@ResponseBody
	public int deleteById(@RequestParam(value = "idstring") String idstring,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {

		String[] ids = idstring.split(",");
		List<String> list = new ArrayList<String>();
		for (String idstr : ids) {
//			Document document = documentService.selectByPrimaryKey(idstr);
			deleteChannelDoc(idstring,httpServletRequest,httpServletResponse);
			list.add(idstr);
		}
		int result = documentService.deleteBatch(list);

		return result;
	}

	private SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
	private SimpleDateFormat dftime = new SimpleDateFormat("yyyyMMddhhmmss");
	
	@RequestMapping(value = "/uploadFile")
	@ResponseBody
	public Map<String, Object> uploadFile(
			@RequestParam(value = "file", required = false) MultipartFile file,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		String uploadWeb = "";
		// 组合零时图片名
		String imageName = file.getOriginalFilename();
		String tempImageName = imageName;
		/*String file_ext = imageName.substring(imageName.lastIndexOf(".") + 1);
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd_hhmmss");
		String imgeName = df.format(new Date());
		String tempImageName = imgeName + "." + file_ext;*/
		
		/*String uploadPath = Global.getUploadpath() + UserUtils.getUserId()
				+ File.separator + tempImageName;*/
		Date date = new Date();
		String fileDir = df.format(date);
		tempImageName =dftime.format(date)+tempImageName; 
		@SuppressWarnings("deprecation") 
		String uploadPath = httpServletRequest.getRealPath("/") + "upload" + File.separator + UserUtils.getUserId() + File.separator + fileDir + File.separator + tempImageName;
		uploadWeb = httpServletRequest.getContextPath()+"upload/" + UserUtils.getUserId() + "/" + fileDir + "/" +tempImageName;
		uploadWeb = "upload/" + UserUtils.getUserId() + "/" + fileDir + "/" +tempImageName;
		File targetFile = new File(uploadPath);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}

		if (file.getSize() > 0) {
			try {
				file.transferTo(targetFile);
			} catch (IllegalStateException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
//		FileUtils.createFile(uploadPath);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("msg", "上传成功");
		map.put("fileName", tempImageName);
		map.put("fileAddr", uploadWeb);
		map.put("size", file.getSize());

		Assets assets = new Assets();
		assets.setName(tempImageName);
		assets.setPath(uploadPath);
		assets.setUrl(uploadWeb);
		assetsService.insert(assets);
		map.put("assetsId", assets.getId());
		return map;
	}

	/**
	 * 全部导出Excel.
	 * 
	 * @param document
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @throws IOException
	 */
	@RequiresPermissions("document:view")
	@RequestMapping(value = "/exportExcel")
	public void exportExcel(@ModelAttribute Document document,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		httpServletResponse.setCharacterEncoding("UTF-8");
		String filename = new String("用户信息".getBytes("GBK"), "iso8859-1");

		List<Document> list = documentService.selectAll();

		List<Map<String, Object>> maps = createExcelRecord(list);

		String columnNames[] = { "Id", "ChannelId", "Title", "Color",
				"Keyword", "Desc", "Priority", "Source", "SourceAddr",
				"Author", "TitleImage", "FileName", "FileAddr", "Size",
				"Content" };// 列名
		String keys[] = { "Id", "ChannelId", "Title", "Color", "Keyword",
				"getDescrition", "Priority", "Source", "SourceAddr", "Author",
				"TitleImage", "FileName", "FileAddr", "Size", "Content" };// map中的key
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
			mapValue.put("Id", document.getId());
			mapValue.put("ChannelId", document.getChannelId());
			mapValue.put("Title", document.getTitle());
			mapValue.put("Color", document.getColor());
			mapValue.put("Keyword", document.getKeyword());
			mapValue.put("getDescrition", document.getDescrition());
			mapValue.put("Priority", document.getPriority());
			mapValue.put("Source", document.getSource());
			mapValue.put("SourceAddr", document.getSourceAddr());
			mapValue.put("Author", document.getAuthor());
			mapValue.put("TitleImage", document.getTitleImage());
			mapValue.put("FileName", document.getFileName());
			mapValue.put("FileAddr", document.getFileAddr());
			mapValue.put("Size", document.getSize());
			mapValue.put("Content", document.getContent());
			listmap.add(mapValue);
		}
		return listmap;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DocumentController documentController = new DocumentController();
		File file = new File("D:/workspace/.metadata/.me_tcat7/webapps/syst/");
		List<FileVO> list = documentController.getWebsiteFiles(file);
	}

	@RequestMapping(value = "/getWebsiteFiles")
	@ResponseBody
	public List<FileVO> getWebsiteFiles(
			@RequestParam(value = "refresh",required=false) boolean refresh,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		List<FileVO> list =null;
		if(!refresh){
			list = (List<FileVO>) cache.get(FILES_CACHE);
			if(list!=null){
				return list;
			}
		}else{
			cache.remove(FILES_CACHE);
		}
		
		@SuppressWarnings("deprecation")
		String webroot = httpServletRequest.getRealPath("/");
		File file = new File(webroot);
//		list = getFiles(refresh, file);
		list = getFiles(file);
		file = new File(webroot+File.separator+"template");
		FileVO fileVO = new FileVO();
		fileVO.setName("template");
		List<FileVO> templates = getFiles(file);
		fileVO.setChildren(templates);
		list.add(fileVO);
		return list;
	}

	/**
	 * 刷新缓存去文件数组。
	 * @param refresh
	 * @param file
	 * @return
	 */
	private List<FileVO> getFiles(boolean refresh, File file) {
		if (refresh) {
			cache.remove(FILES_CACHE);
			List<FileVO> list = getWebsiteFiles(file);
			if (list != null && list.size() > 0) {
				cache.put(FILES_CACHE, list);
			}
			return list;
		} else {
			@SuppressWarnings("unchecked")
			List<FileVO> list = (List<FileVO>) cache.get(FILES_CACHE);
			if (list == null) {
				list = getWebsiteFiles(file);
				if (list != null && list.size() > 0) {
					cache.put(FILES_CACHE, list);
				}
			}
			return list;
		}

	}

	//file必须是ROOT。
	public List<FileVO> getFiles(File file) {
		List<FileVO> children = new ArrayList<FileVO>();
		File[] childs = file.listFiles();
		for (File object : childs) {
			if(object.isFile()){
				FileVO fileVO =  new FileVO();
				fileVO.setName(object.getName());
				if (fileVO != null) {
					children.add(fileVO);
				}
			}
		}
		return children;
	}
	
	public List<FileVO> getWebsiteFiles(File file) {
		List<FileVO> children = new ArrayList<FileVO>();
		File[] childs = file.listFiles();
		for (File object : childs) {
			FileVO fileVO = null;
			fileVO = searialFileVO(object);
			if (fileVO != null) {
				children.add(fileVO);
			}
		}
		return children;
	}

	public FileVO searialFileVO(File file) {

		FileVO fileVO = new FileVO();
		fileVO.setName(file.getName());

		List<FileVO> list = searialChild(file);
		if (null != list) {
			fileVO.setChildren(list);
		}

		return fileVO;
	}

	public List<FileVO> searialChild(File file) {
		List children = null;
		File[] list = file.listFiles();
		if (list != null && list.length > 0) {
			children = new ArrayList();
		}
		if (list != null) {
			for (File object : list) {
				FileVO jsonObject = searialFileVO(object);
				if (jsonObject != null) {
					children.add(jsonObject);
				}
			}
		}

		return children;
	}
	
	
	public String generateChannelDocs(String id,Document document,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		@SuppressWarnings("deprecation")
		String webroot = httpServletRequest.getRealPath("/");
		String conPath = httpServletRequest.getContextPath();

		List<Channel> menus = UserUtils.getChannels();// 菜单。
		// 约定指向文档的栏目不会出现在模块内容当中。
		List<Channel> modules = new ArrayList<Channel>();
		for (Channel channel2 : menus) {
			if (!channel2.getAsdocument()) {
				modules.add(channel2);
			}
		}

		List<Channel> result = new ArrayList<Channel>();
		searchChannel(menus, id, result);
		if (result.size() == 0) {
			return "获取栏目失败，注意刷新栏目";
		}

		Channel toGeneratedChannel = result.get(0);

		String linkAddr = toGeneratedChannel.getLinkAddr();
		linkAddr = linkAddr.replaceAll("//", File.separator);
		String toGeneratedFiles = webroot + linkAddr + File.separator + "docs";// 不要生成在doc里面，免得引起路径问题。
		File file = new File(toGeneratedFiles);
		if (!file.exists()) {
			FileUtils.createDirectory(toGeneratedFiles);
		}

		List<Channel> navChan = getParentChannels(menus, toGeneratedChannel);
		// 点击率排名
		/*Page page1 = new Page();
		List<Document> clickCountDocs = documentService.getClickCountDoc(
				toGeneratedChannel.getCode(), page1);
		for (Document document1 : clickCountDocs) {
			Channel channel1 = channelService.selectByPrimaryKey(document1
					.getChannelId());
			document1.setChannel(channel1);
		}*/
		
		Map<String, Object> root = new HashMap<String, Object>();
		
		Document lastdoc = documentService.selectLastRecord(document);
		Document nextdoc = documentService.selectNextRecord(document);
		root.put("lastdoc", lastdoc);
		root.put("nextdoc", nextdoc);
		root.put("channel", toGeneratedChannel);
		root.put("path", webroot);
		root.put("ctx", conPath);
		root.put("menus", menus);
		root.put("modules", modules);
		root.put("navChan", navChan);
//		root.put("clickCountDocs", clickCountDocs);
		root.put("document", document);
		
		String templatesPath = webroot;
		String templateFile = "template" + File.separator + "doc.ftl";
		templateFile = "";
		if (null != toGeneratedChannel.getDocGeneTemplate()
				&& !"".equals(toGeneratedChannel.getDocGeneTemplate())) {
			templateFile = toGeneratedChannel.getDocGeneTemplate();
		}
		if (null != document.getGeneTemplate()
				&& !"".equals(document.getGeneTemplate())) {
			templateFile = document.getGeneTemplate();
		}
		
		String htmlFile = toGeneratedFiles + File.separator
				+ document.getId() + ".html";
		
		File file1 = new File(webroot+templateFile);
		if(!"".equals(templateFile)){
			if(file1.exists()){
				FreeMarkerUtil.analysisTemplate(templatesPath, templateFile,
						htmlFile, root);
			}
		}
		
		// 移动端
		templateFile = "template" + File.separator + "m-doc.ftl";
		templateFile = "";
		if (null != toGeneratedChannel.getDocMgeneTemplate()
				&& !"".equals(toGeneratedChannel.getDocMgeneTemplate())) {
			templateFile = toGeneratedChannel.getDocMgeneTemplate();
		}
		
		if (null != document.getmGeneTemplate()
				&& !"".equals(document.getmGeneTemplate())) {
			templateFile = document.getmGeneTemplate();
		}
		
		htmlFile = toGeneratedFiles + File.separator + document.getId()
				+ "m.html";
		if(!"".equals(templateFile)){
			file1 = new File(webroot+templateFile);
			if(file1.exists()){
				FreeMarkerUtil.analysisTemplate(templatesPath, templateFile,
						htmlFile, root);
			}
		}

		return "生成栏目文档成功";
	}
	
	@RequestMapping(value = "/geneChannelDoc")
	@ResponseBody
	public String geneChannelDoc(@RequestParam(value = "idstring") String idstring,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		String[] ids = idstring.split(",");
		for (String idstr : ids) {
			Document document = documentService.selectByPrimaryKey(idstr);
			if(null!=document){
				generateChannelDocs(document.getChannelId(),document,httpServletRequest,httpServletResponse);
			}
		}
		
		return "succ";
	}
	
	@RequestMapping(value = "/deleteChannelDoc")
	@ResponseBody
	public void deleteChannelDoc(@RequestParam(value = "idstring") String idstring,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		String[] ids = idstring.split(",");
		for (String idstr : ids) {
			Document document = documentService.selectByPrimaryKey(idstr);
			if(null!=document){
				@SuppressWarnings("deprecation")
				String webroot = httpServletRequest.getRealPath("/");

				List<Channel> menus = UserUtils.getChannels();// 菜单。

				List<Channel> result = new ArrayList<Channel>();
				searchChannel(menus, document.getChannelId(), result);
				if (result.size() == 0) {
					continue;
				}

				Channel toGeneratedChannel = result.get(0);

				String linkAddr = toGeneratedChannel.getLinkAddr();
				linkAddr = linkAddr.replaceAll("//", File.separator);
				String toGeneratedFiles = webroot + linkAddr;
				String fileName = toGeneratedFiles + File.separator + "docs"
						+ File.separator + document.getId() + ".html";
				File file = new File(fileName);
				if (file.exists()) {
					file.delete();
					FileUtils.deleteFile(fileName);
				}
				// 移动端，约定后缀名前面加“m”；
				fileName = toGeneratedFiles + File.separator + "docs" 
				+ File.separator + document.getId() + "m.html";
				file = new File(fileName);
				if (file.exists()) { 
					file.delete();
					FileUtils.deleteFile(fileName);
				}
			}
		}
	}

	private List<Channel> getParentChannels(List<Channel> list,
			Channel currentChannel) {
		List<Channel> result = new ArrayList<Channel>();
		while (currentChannel != null
				&& !"".equals(currentChannel.getParentId())
				&& null != currentChannel.getParentId()) {
			result.add(currentChannel);
			List<Channel> res = new ArrayList<Channel>();
			searchChannel(list, currentChannel, res);
			if (res.size() > 0) {
				currentChannel = res.get(0);
			}
		}
		result.add(currentChannel);
		List<Channel> temp = new ArrayList<Channel>();
		for (int i = result.size() - 1; i >= 0; i--) {
			temp.add(result.get(i));
		}
		result = temp;
		return result;
	}

	private Channel searchChannel(List<Channel> list, String id,
			List<Channel> result) {
		Channel chan = null;
		for (Channel channel : list) {
			if (channel.getId().equals(id)) {
				result.add((chan = channel));
				break;
			}
			if (channel.getChildren() != null
					&& channel.getChildren().size() > 0) {
				chan = searchChannel(channel.getChildren(), id, result);
			}
		}
		return null;
	}

	private Channel searchChannel(List<Channel> list, Channel currentChannel,
			List<Channel> result) {
		Channel chan = null;
		for (Channel channel : list) {
			if (channel.getId().equals(currentChannel.getParentId())) {
				result.add(chan = channel);
				break;
			}
			if (channel.getChildren() != null
					&& channel.getChildren().size() > 0) {
				chan = searchChannel(channel.getChildren(), currentChannel,
						result);
			}
		}
		return null;
	}
}
