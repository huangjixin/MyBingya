/**
 * 一句话描述该类：前端HTML页面生成器。
 * @author 黄记新 <br/>
 * @date 2015-12-3,16:39 <br/>
 *
 */
package com.jcin.cms.modules.channel.web;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jcin.cms.common.FileUtils;
import com.jcin.cms.common.FreeMarkerUtil;
import com.jcin.cms.common.UserUtils;
import com.jcin.cms.modules.channel.domain.Channel;
import com.jcin.cms.modules.channel.domain.Document;
import com.jcin.cms.modules.channel.domain.FileVO;
import com.jcin.cms.modules.channel.service.IChannelService;
import com.jcin.cms.modules.channel.service.IDocumentService;
import com.jcin.cms.utils.Page;
import com.jcin.cms.web.BaseController;

@Controller
@RequestMapping(value = "admin/htmlgenerate")
public class HtmlGeneraterController extends BaseController {

	@Autowired
	private IDocumentService documentService;

	@Autowired
	private IChannelService channelService;

	@RequiresPermissions("htmlgenerate:view")
	@RequestMapping(value = { "", "htmlgenerate" })
	public String htmlgenerate(HttpServletRequest httpServletRequest) {
		return root + "admin/modules/htmlgenerate/htmlgenerate.jsp";
	}

	@RequestMapping(value = "/deleteAll")
	@ResponseBody
	public String deleteAll(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		deleteIndex(httpServletRequest, httpServletResponse);
		@SuppressWarnings("deprecation")
		String webroot = httpServletRequest.getRealPath("/") + "channel";
		File file = new File(webroot);
		if (file.exists()) {
			File[] files = file.listFiles();
			for (File file2 : files) {
				file2.delete();
				FileUtils.deleteDirectory(file2.getAbsolutePath());
			}
		}
		return "删除所有成功";
	}

	@RequestMapping(value = "/generateAll")
	@ResponseBody
	public String generateAll(
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse,
			@RequestParam(value = "indexTemp", required = false) String indexTemp)
			throws IOException {
		generateIndex(httpServletRequest, httpServletResponse, indexTemp);
		List<Channel> menus = UserUtils.getChannels();// 菜单。
		for (Channel channel : menus) {
			generateChannel(channel.getId(), true, httpServletRequest,
					httpServletResponse);
			generateChannelDocs(channel.getId(), true, httpServletRequest,
					httpServletResponse);
		}
		return "生成所有成功";
	}

	@RequestMapping(value = "/generateIndex")
	@ResponseBody
	public String generateIndex(
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse,
			@RequestParam(value = "indexTemp", required = false) String indexTemp)
			throws IOException {
		@SuppressWarnings("deprecation")
		String webroot = httpServletRequest.getRealPath("/");
		String conPath = httpServletRequest.getContextPath();
		Map<String, Object> root = new HashMap<String, Object>();

		// 菜单
		List<Channel> menus = UserUtils.getChannels();
		// 约定指向文档的栏目不会出现在模块内容当中。
		List<Channel> modules = new ArrayList<Channel>();
		for (Channel channel2 : menus) {
			if (!channel2.getAsdocument()) {
				modules.add(channel2);
			}
		}
		root.put("modules", modules);

		Page page = new Page();
		page.setPageSize(10);
		Map<String, Object> menusMap = new HashMap<String, Object>();
		for (Channel channel : menus) {
			List<Document> documents = documentService.getDocByChannelCode(
					channel.getCode(), page);
			menusMap.put(channel.getCode(), documents);
			root.put(channel.getCode(), menusMap);
		}

		// 查询栏目推荐。
		Page recommendPage = new Page();
		recommendPage.setPageSize(8);
		List<Document> recommendDocs = documentService.getDocByChannelCode(
				null, recommendPage);
		for (Document document : recommendDocs) {
			Channel channel2 = channelService.selectByPrimaryKey(document
					.getChannelId());
			document.setChannel(channel2);
		}

		// 点击率排名
		Page page1 = new Page();
		List<Document> clickCountDocs = documentService.getClickCountDoc(null,
				page1);
		for (Document document1 : clickCountDocs) {
			Channel channel1 = channelService.selectByPrimaryKey(document1
					.getChannelId());
			document1.setChannel(channel1);
		}
		root.put("clickCountDocs", clickCountDocs);
		root.put("menusMap", menusMap);
		root.put("path", webroot);
		root.put("ctx", conPath);
		root.put("menus", menus);
		root.put("recommendDocs", recommendDocs);// 推荐文章。

		String templatesPath = webroot;
		String templateFile = "template" + File.separator + "index.ftl";
		if(null != indexTemp && !"".equals(indexTemp)){
			templateFile = indexTemp;
		}
		String htmlFile = webroot + "index.html";
		FreeMarkerUtil.analysisTemplate(templatesPath, templateFile, htmlFile,
				root);

		templateFile = "template" + File.separator + "m-index.ftl";
		htmlFile = webroot + "m-index.html";
		FreeMarkerUtil.analysisTemplate(templatesPath, templateFile, htmlFile,
				root);
		return "生成首页成功";
	}

	@RequestMapping(value = "/deleteIndex")
	@ResponseBody
	public String deleteIndex(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		@SuppressWarnings("deprecation")
		String webroot = httpServletRequest.getRealPath("/") + "index.html";
		File file = new File(webroot);
		if (file.exists()) {
			file.delete();
		}
		@SuppressWarnings("deprecation")
		String m_index = httpServletRequest.getRealPath("/") + "m-index.html";
		File m_file = new File(m_index);
		if (m_file.exists()) {
			m_file.delete();
		}
		return "删除首页成功";
	}

	@RequestMapping(value = "/generateChannel")
	@ResponseBody
	public String generateChannel(
			@RequestParam(value = "id") String id,
			@RequestParam(value = "generateSubchannel", required = false) boolean generateSubchannel,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {

		@SuppressWarnings("deprecation")
		String webroot = httpServletRequest.getRealPath("/");
		String conPath = httpServletRequest.getContextPath();
		Map<String, Object> root = new HashMap<String, Object>();

		List<Channel> menus = UserUtils.getChannels();// 菜单。
		// 约定指向文档的栏目不会出现在模块内容当中。
		List<Channel> modules = new ArrayList<Channel>();
		for (Channel channel2 : menus) {
			if (!channel2.getAsdocument()) {
				modules.add(channel2);
			}
		}
		root.put("modules", modules);

		List<Channel> result = new ArrayList<Channel>();
		searchChannel(menus, id, result);
		if (result.size() == 0) {
			return "生成栏目失败，注意刷新栏目";
		}

		Page page = new Page();
		page.setPageSize(10);
		Map<String, Object> menusMap = new HashMap<String, Object>();
		Channel toGeneratedChannel = result.get(0);
		if (null != toGeneratedChannel.getChildren()
				&& toGeneratedChannel.getChildren().size() > 0) {
			for (Channel channel : toGeneratedChannel.getChildren()) {
				List<Document> documents = documentService.getDocByChannelCode(
						channel.getCode(), page);
				menusMap.put(channel.getCode(), documents);
				root.put(channel.getCode(), menusMap);
			}
		}

		// 查询栏目推荐。
		Page recommendPage = new Page();
		recommendPage.setPageSize(8);
		List<Document> recommendDocs = documentService.getDocByChannelCode(
				toGeneratedChannel.getCode(), recommendPage);
		for (Document document : recommendDocs) {
			Channel channel2 = channelService.selectByPrimaryKey(document
					.getChannelId());
			document.setChannel(channel2);
		}

		if (null == toGeneratedChannel.getChildren()
				|| toGeneratedChannel.getChildren().size() == 0) {
			documentService.getDocByChannelCode(toGeneratedChannel.getCode(),
					page);
			root.put("page", page);
		}

		// 点击率排名
		Page page1 = new Page();
		List<Document> clickCountDocs = documentService.getClickCountDoc(
				toGeneratedChannel.getCode(), page1);
		for (Document document1 : clickCountDocs) {
			Channel channel1 = channelService.selectByPrimaryKey(document1
					.getChannelId());
			document1.setChannel(channel1);
		}
		root.put("clickCountDocs", clickCountDocs);
		root.put("channel", toGeneratedChannel);
		root.put("subChannels", toGeneratedChannel.getChildren());
		root.put("menusMap", menusMap);
		root.put("path", webroot);
		root.put("ctx", conPath);
		root.put("menus", menus);
		root.put("recommendDocs", recommendDocs);// 推荐文章。
		List<Channel> navChan = getParentChannels(menus, toGeneratedChannel);
		root.put("navChan", navChan);

		String linkAddr = toGeneratedChannel.getLinkAddr();
		linkAddr = linkAddr.replaceAll("//", File.separator);
		String toGeneratedFiles = webroot + linkAddr;
		File file = new File(toGeneratedFiles);
		if (!file.exists()) {
			FileUtils.createDirectory(toGeneratedFiles);
		}

		String templatesPath = webroot;
		String templateFile = "";
		if (toGeneratedChannel.getChildren() != null
				&& toGeneratedChannel.getChildren().size() > 0) {
			templateFile = "template" + File.separator + "channels.ftl";
		} else {
			templateFile = "template" + File.separator + "channel.ftl";
		}

		// 如果栏目直接是文档的话,那应该找到相应的文档生成模板。
		if (toGeneratedChannel.getAsdocument()) {
			List<Document> documents = documentService
					.getDocByChannelId(toGeneratedChannel.getId());
			if (documents != null && documents.size() > 0) {
				Document docu = documents.get(0);
				if (docu.getGeneTemplate() != null
						&& !"".equals(docu.getGeneTemplate())) {
					templateFile = docu.getGeneTemplate();
					templateFile = templateFile.replaceAll("//", File.separator);
					root.put("document", docu);
				}
			}
		}

		String htmlFile = toGeneratedFiles + File.separator + "docs"
				+ File.separator + toGeneratedChannel.getCode() + "1.html";
		FileUtils.createDirectory(toGeneratedFiles + File.separator + "docs");

		// 栏目的叶子节点生成。
		if (null == toGeneratedChannel.getChildren()
				|| toGeneratedChannel.getChildren().size() == 0) {
			int totalPage = page.getTotalPage();
			for (int i = 0; i <= totalPage; i++) {
				templateFile = "template" + File.separator + "channel.ftl";
				htmlFile = toGeneratedFiles + File.separator + "docs"
						+ File.separator + toGeneratedChannel.getCode()
						+ (i + 1) + ".html";
				page.setStart(i * page.getPageSize());
				documentService.getDocByChannelCode(
						toGeneratedChannel.getCode(), page);
				root.put("page", page);
				root.put("i", i + 1);
				// 如果栏目直接是文档的话,那应该找到相应的文档生成模板。
				if (toGeneratedChannel.getAsdocument()) {
					List<Document> documents = documentService
							.getDocByChannelId(toGeneratedChannel.getId());
					if (documents != null && documents.size() > 0) {
						Document docu = documents.get(0);
						if (docu.getGeneTemplate() != null
								&& !"".equals(docu.getGeneTemplate())) {
							templateFile = docu.getGeneTemplate();
							root.put("document", docu);
						}
					}
				}

				FreeMarkerUtil.analysisTemplate(templatesPath, templateFile,
						htmlFile, root);

				// 移动端；
				templateFile = "template" + File.separator + "m-channel.ftl";
				htmlFile = toGeneratedFiles + File.separator + "docs"
						+ File.separator + toGeneratedChannel.getCode()
						+ (i + 1) + "m.html";
				// 如果栏目直接是文档的话,那应该找到相应的文档生成模板。
				if (toGeneratedChannel.getAsdocument()) {
					List<Document> documents = documentService
							.getDocByChannelId(toGeneratedChannel.getId());
					if (documents != null && documents.size() > 0) {
						Document docu = documents.get(0);
						if (docu.getmGeneTemplate() != null
								&& !"".equals(docu.getmGeneTemplate())) {
							templateFile = docu.getmGeneTemplate();
							templateFile = templateFile.replaceAll("/", File.separator);
							root.put("document", docu);
						}
					}
				}
				FreeMarkerUtil.analysisTemplate(templatesPath, templateFile,
						htmlFile, root);
			}
		} else { // 非叶子节点生成使用channels模板，叶子节点使用channel模板
			FreeMarkerUtil.analysisTemplate(templatesPath, templateFile,
					htmlFile, root);

			// 移动端；
			templateFile = "template" + File.separator + "m-channels.ftl";
			htmlFile = toGeneratedFiles + File.separator + "docs"
					+ File.separator + toGeneratedChannel.getCode() + "1m.html";
			// 如果栏目直接是文档的话,那应该找到相应的文档生成模板。
			if (toGeneratedChannel.getAsdocument()) {
				List<Document> documents = documentService
						.getDocByChannelId(toGeneratedChannel.getId());
				if (documents != null && documents.size() > 0) {
					Document docu = documents.get(0);
					if (docu.getmGeneTemplate() != null
							&& !"".equals(docu.getmGeneTemplate())) {
						templateFile = docu.getmGeneTemplate();
						root.put("document", docu);
					}
				}
			}
			FreeMarkerUtil.analysisTemplate(templatesPath, templateFile,
					htmlFile, root);
		}

		// 生成子栏目。
		if (generateSubchannel) {
			if (null != toGeneratedChannel.getChildren()
					&& toGeneratedChannel.getChildren().size() > 0) {
				for (Channel channel : toGeneratedChannel.getChildren()) {
					generateSubChannel(channel, httpServletRequest);
				}
			}
		}

		return "生成栏目成功";
	}

	private void generateSubChannel(Channel toChannel,
			HttpServletRequest httpServletRequest) {
		@SuppressWarnings("deprecation")
		String webroot = httpServletRequest.getRealPath("/");
		String conPath = httpServletRequest.getContextPath();
		Map<String, Object> root = new HashMap<String, Object>();

		List<Channel> menus = UserUtils.getChannels();// 菜单。
		// 约定指向文档的栏目不会出现在模块内容当中。
		List<Channel> modules = new ArrayList<Channel>();
		for (Channel channel2 : menus) {
			if (!channel2.getAsdocument()) {
				modules.add(channel2);
			}
		}
		root.put("modules", modules);

		List<Channel> result = new ArrayList<Channel>();
		searchChannel(menus, toChannel.getId(), result);
		if (result.size() == 0) {
			return;
		}

		Page page = new Page();
		page.setPageSize(10);
		Map<String, Object> menusMap = new HashMap<String, Object>();
		Channel toGeneratedChannel = result.get(0);
		if (null != toGeneratedChannel.getChildren()
				&& toGeneratedChannel.getChildren().size() > 0) {
			for (int i = 0; i < toGeneratedChannel.getChildren().size(); i++) {
				Channel channel = toGeneratedChannel.getChildren().get(i);
				List<Document> documents = documentService.getDocByChannelCode(
						channel.getCode(), page);
				menusMap.put(channel.getCode(), documents);
				root.put(channel.getCode(), menusMap);
			}
		}

		if (null == toGeneratedChannel.getChildren()
				|| toGeneratedChannel.getChildren().size() == 0) {
			documentService.getDocByChannelCode(toGeneratedChannel.getCode(),
					page);
			root.put("page", page);
		}

		// 查询栏目推荐。
		Page recommendPage = new Page();
		recommendPage.setPageSize(8);
		List<Document> recommendDocs = documentService.getDocByChannelCode(
				toGeneratedChannel.getCode(), recommendPage);
		for (Document document : recommendDocs) {
			Channel channel2 = channelService.selectByPrimaryKey(document
					.getChannelId());
			document.setChannel(channel2);
		}

		// 点击率排名
		Page page1 = new Page();
		List<Document> clickCountDocs = documentService.getClickCountDoc(
				toGeneratedChannel.getCode(), page1);
		for (Document document1 : clickCountDocs) {
			Channel channel1 = channelService.selectByPrimaryKey(document1
					.getChannelId());
			document1.setChannel(channel1);
		}
		root.put("clickCountDocs", clickCountDocs);
		root.put("channel", toGeneratedChannel);
		root.put("subChannels", toGeneratedChannel.getChildren());
		root.put("menusMap", menusMap);
		root.put("path", webroot);
		root.put("ctx", conPath);
		root.put("menus", menus);
		root.put("recommendDocs", recommendDocs);// 推荐文章。
		List<Channel> navChan = getParentChannels(menus, toGeneratedChannel);
		root.put("navChan", navChan);

		String linkAddr = toGeneratedChannel.getLinkAddr();
		linkAddr = linkAddr.replaceAll("//", File.separator);
		String toGeneratedFiles = webroot + linkAddr;
		File file = new File(toGeneratedFiles);
		if (!file.exists()) {
			FileUtils.createDirectory(toGeneratedFiles);
		}

		String templatesPath = webroot;
		String templateFile = "";
		if (toGeneratedChannel.getChildren() != null
				&& toGeneratedChannel.getChildren().size() > 0) {
			templateFile = "template" + File.separator + "channels.ftl";
		} else {
			templateFile = "template" + File.separator + "channel.ftl";
		}

		// 如果栏目直接是文档的话,那应该找到相应的文档生成模板。
		if (toGeneratedChannel.getAsdocument()) {
			List<Document> documents = documentService
					.getDocByChannelId(toGeneratedChannel.getId());
			if (documents != null && documents.size() > 0) {
				Document docu = documents.get(0);
				if (docu.getGeneTemplate() != null
						&& !"".equals(docu.getGeneTemplate())) {
					templateFile = docu.getGeneTemplate();
					root.put("document", docu);
				}
			}
		}
		/*
		 * String templateFile = toGeneratedChannel.getChildren() != null &&
		 * toGeneratedChannel.getChildren().size() > 0 ? "template" +
		 * File.separator + "channels.ftl" : "template" + File.separator +
		 * "channel.ftl";
		 */
		String htmlFile = toGeneratedFiles + File.separator + "docs"
				+ File.separator + toGeneratedChannel.getCode() + "1.html";
		FileUtils.createDirectory(toGeneratedFiles + File.separator + "docs");

		// 栏目的叶子节点生成。
		if (null == toGeneratedChannel.getChildren()
				|| toGeneratedChannel.getChildren().size() == 0) {
			int totalPage = page.getTotalPage();
			for (int i = 0; i <= totalPage; i++) {
				templateFile = "template" + File.separator + "channel.ftl";
				htmlFile = toGeneratedFiles + File.separator + "docs"
						+ File.separator + toGeneratedChannel.getCode()
						+ (i + 1) + ".html";
				page.setStart(i * page.getPageSize());
				documentService.getDocByChannelCode(
						toGeneratedChannel.getCode(), page);
				root.put("page", page);
				root.put("i", i + 1);
				// 如果栏目直接是文档的话,那应该找到相应的文档生成模板。
				if (toGeneratedChannel.getAsdocument()) {
					List<Document> documents = documentService
							.getDocByChannelId(toGeneratedChannel.getId());
					if (documents != null && documents.size() > 0) {
						Document docu = documents.get(0);
						if (docu.getGeneTemplate() != null
								&& !"".equals(docu.getGeneTemplate())) {
							templateFile = docu.getGeneTemplate();
							root.put("document", docu);
						}
					}
				}
				FreeMarkerUtil.analysisTemplate(templatesPath, templateFile,
						htmlFile, root);

				// 移动端；
				templateFile = "template" + File.separator + "m-channel.ftl";
				// 如果栏目直接是文档的话,那应该找到相应的文档生成模板。
				if (toGeneratedChannel.getAsdocument()) {
					List<Document> documents = documentService
							.getDocByChannelId(toGeneratedChannel.getId());
					if (documents != null && documents.size() > 0) {
						Document docu = documents.get(0);
						if (docu.getmGeneTemplate() != null
								&& !"".equals(docu.getmGeneTemplate())) {
							templateFile = docu.getmGeneTemplate();
							root.put("document", docu);
						}
					}
				}
				htmlFile = toGeneratedFiles + File.separator + "docs"
						+ File.separator + toGeneratedChannel.getCode()
						+ (i + 1) + "m.html";
				FreeMarkerUtil.analysisTemplate(templatesPath, templateFile,
						htmlFile, root);
			}
		} else { // 非叶子节点生成使用channels模板，叶子节点使用channel模板
			FreeMarkerUtil.analysisTemplate(templatesPath, templateFile,
					htmlFile, root);

			// 移动端；
			templateFile = "template" + File.separator + "m-channels.ftl";
			// 如果栏目直接是文档的话,那应该找到相应的文档生成模板。
			if (toGeneratedChannel.getAsdocument()) {
				List<Document> documents = documentService
						.getDocByChannelId(toGeneratedChannel.getId());
				if (documents != null && documents.size() > 0) {
					Document docu = documents.get(0);
					if (docu.getmGeneTemplate() != null
							&& !"".equals(docu.getmGeneTemplate())) {
						templateFile = docu.getmGeneTemplate();
						root.put("document", docu);
					}
				}
			}
			htmlFile = toGeneratedFiles + File.separator + "docs"
					+ File.separator + toGeneratedChannel.getCode() + "1m.html";
			FreeMarkerUtil.analysisTemplate(templatesPath, templateFile,
					htmlFile, root);
		}

		if (null != toGeneratedChannel.getChildren()
				&& toGeneratedChannel.getChildren().size() > 0) {
			for (Channel channel : toGeneratedChannel.getChildren()) {
				generateSubChannel(channel, httpServletRequest);
			}
		}
	}

	@RequestMapping(value = "/deleleChannel")
	@ResponseBody
	public String deleleChannel(
			@RequestParam(value = "id") String id,
			@RequestParam(value = "deleteSubchannel", required = false) boolean deleteSubchannel,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {

		@SuppressWarnings("deprecation")
		String webroot = httpServletRequest.getRealPath("/");

		List<Channel> menus = UserUtils.getChannels();// 菜单。

		List<Channel> result = new ArrayList<Channel>();
		searchChannel(menus, id, result);
		if (result.size() == 0) {
			return "获取栏目失败，注意刷新栏目";
		}

		Channel toGeneratedChannel = result.get(0);

		String linkAddr = toGeneratedChannel.getLinkAddr();
		linkAddr = linkAddr.replaceAll("//", File.separator);
		String toGeneratedFiles = webroot + linkAddr;
		File file = new File(toGeneratedFiles + File.separator + "docs"
				+ File.separator + toGeneratedChannel.getCode() + ".html");
		if (file.exists()) {
			file.delete();
		}
		if (deleteSubchannel) {
			file = new File(toGeneratedFiles);
			deleteSubChannel(file, toGeneratedChannel);
			/*
			 * if(file.exists()){ FileUtils.deleteDirectory(toGeneratedFiles); }
			 */
		}

		return "删除栏目成功";
	}

	public void deleteSubChannel(File file, Channel channel) {
		File[] list = file.listFiles();
		if (list != null) {
			for (File object : list) {
				if (channel.getChildren() != null
						&& channel.getChildren().size() > 0) {
					for (Channel chan : channel.getChildren()) {
						String path = object.getAbsolutePath() + File.separator
								+ "docs" + File.separator + chan.getCode()
								+ ".html";
						File f = new File(path);
						if (f.exists()) {
							f.delete();
						}
						deleteSubChannel(object, chan);
					}
				}
			}
		}
	}

	@RequestMapping(value = "/deleteChannelDoc")
	@ResponseBody
	public String deleteChannelDoc(
			@RequestParam(value = "id") String id,
			@RequestParam(value = "deleteSubchannelDoc", required = false) boolean deleteSubchannelDoc,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {

		@SuppressWarnings("deprecation")
		String webroot = httpServletRequest.getRealPath("/");

		List<Channel> menus = UserUtils.getChannels();// 菜单。

		List<Channel> result = new ArrayList<Channel>();
		searchChannel(menus, id, result);
		if (result.size() == 0) {
			return "获取栏目失败，注意刷新栏目";
		}

		Channel toGeneratedChannel = result.get(0);

		String linkAddr = toGeneratedChannel.getLinkAddr();
		linkAddr = linkAddr.replaceAll("//", File.separator);
		String toGeneratedFiles = webroot + linkAddr;
		String fileName = toGeneratedFiles + File.separator + "docs"
				+ File.separator + toGeneratedChannel.getCode() + "1.html";
		File file = new File(fileName);
		if (file.exists()) {
			FileUtils.deleteFile(fileName);
		}
		// 移动端，约定后缀名前面加“m”；
		fileName = toGeneratedFiles + File.separator + "docs" + File.separator
				+ toGeneratedChannel.getCode() + "1m.html";
		file = new File(fileName);
		if (file.exists()) {
			FileUtils.deleteFile(fileName);
		}

		if (deleteSubchannelDoc) {
			file = new File(toGeneratedFiles);
			if (file.exists()) {
				deleteSubDoc(file);
			}
		}

		return "删除栏目文档成功";
	}

	public void deleteSubDoc(File file) {
		File[] list = file.listFiles();
		if (list != null) {
			for (File object : list) {
				if (object.getName().indexOf("1.html") != -1
						|| object.getName().indexOf("1m.html") != -1) {
					FileUtils.deleteFile(object.getAbsolutePath());
				}
				deleteSubDoc(object);
			}
		}
	}

	/**
	 * 生成栏目文档。
	 * 
	 * @param id
	 * @param generateSubchannelDoc
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/generateDocs")
	@ResponseBody
	public String generateChannelDocs(
			@RequestParam(value = "id") String id,
			@RequestParam(value = "generateSubchannelDoc", required = false) boolean generateSubchannelDoc,
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
		Page page1 = new Page();
		List<Document> clickCountDocs = documentService.getClickCountDoc(
				toGeneratedChannel.getCode(), page1);
		for (Document document1 : clickCountDocs) {
			Channel channel1 = channelService.selectByPrimaryKey(document1
					.getChannelId());
			document1.setChannel(channel1);
		}

		List<Document> documents = documentService
				.getDocByChannelId(toGeneratedChannel.getId());
		if (null != documents && documents.size() > 0) {
			for (Document document : documents) {
				Map<String, Object> root = new HashMap<String, Object>();
				String templatesPath = webroot;
				String templateFile = "template" + File.separator + "doc.ftl";
				String htmlFile = toGeneratedFiles + File.separator
						+ document.getId() + ".html";
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
				root.put("clickCountDocs", clickCountDocs);
				root.put("document", document);

				FreeMarkerUtil.analysisTemplate(templatesPath, templateFile,
						htmlFile, root);
				// 移动端
				templateFile = "template" + File.separator + "m-doc.ftl";
				htmlFile = toGeneratedFiles + File.separator + document.getId()
						+ "m.html";
				FreeMarkerUtil.analysisTemplate(templatesPath, templateFile,
						htmlFile, root);
			}
		}

		if (generateSubchannelDoc) {
			if (null != toGeneratedChannel.getChildren()
					&& toGeneratedChannel.getChildren().size() > 0) {
				for (Channel channel : toGeneratedChannel.getChildren()) {
					generateSubChannelDocs(channel, httpServletRequest);
				}
			}
		}

		return "生成栏目文档成功";
	}

	private void generateSubChannelDocs(Channel toChannel,
			HttpServletRequest httpServletRequest) {
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
		searchChannel(menus, toChannel.getId(), result);
		if (result.size() == 0) {
			return;
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
		Page page1 = new Page();
		List<Document> clickCountDocs = documentService.getClickCountDoc(
				toGeneratedChannel.getCode(), page1);
		for (Document document1 : clickCountDocs) {
			Channel channel1 = channelService.selectByPrimaryKey(document1
					.getChannelId());
			document1.setChannel(channel1);
		}
		List<Document> documents = documentService
				.getDocByChannelId(toGeneratedChannel.getId());
		if (null != documents && documents.size() > 0) {
			for (Document document : documents) {
				Map<String, Object> root = new HashMap<String, Object>();
				String templatesPath = webroot;
				String templateFile = "template" + File.separator + "doc.ftl";
				String htmlFile = toGeneratedFiles + File.separator
						+ document.getId() + ".html";

				root.put("channel", toGeneratedChannel);
				Document lastdoc = documentService.selectLastRecord(document);
				Document nextdoc = documentService.selectNextRecord(document);
				root.put("lastdoc", lastdoc);
				root.put("nextdoc", nextdoc);
				root.put("path", webroot);
				root.put("ctx", conPath);
				root.put("menus", menus);
				root.put("modules", modules);
				root.put("navChan", navChan);
				root.put("clickCountDocs", clickCountDocs);
				root.put("document", document);

				FreeMarkerUtil.analysisTemplate(templatesPath, templateFile,
						htmlFile, root);
				// 移动端
				templateFile = "template" + File.separator + "m-doc.ftl";
				htmlFile = toGeneratedFiles + File.separator + document.getId()
						+ "m.html";
				FreeMarkerUtil.analysisTemplate(templatesPath, templateFile,
						htmlFile, root);
			}
		}

		if (null != toGeneratedChannel.getChildren()
				&& toGeneratedChannel.getChildren().size() > 0) {
			for (Channel channel : toGeneratedChannel.getChildren()) {
				generateSubChannelDocs(channel, httpServletRequest);
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

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
