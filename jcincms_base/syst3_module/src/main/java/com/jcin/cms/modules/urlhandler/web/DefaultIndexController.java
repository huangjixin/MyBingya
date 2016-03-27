/**
 * 一句话描述该类：<br/>
 * @author 黄记新
 * @date 2015-10-21,下午4:00:41
 *
 */
package com.jcin.cms.modules.urlhandler.web;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.mobile.device.site.SitePreference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jcin.cms.common.UserUtils;
import com.jcin.cms.modules.channel.domain.Channel;
import com.jcin.cms.modules.channel.service.IChannelService;
import com.jcin.cms.modules.channel.service.IDocumentService;
import com.jcin.cms.modules.urlhandler.domain.BasicConfig;
import com.jcin.cms.web.BaseController;

/**
 * @author 黄记新
 * 
 */
@SuppressWarnings("rawtypes")
@Controller
@RequestMapping(value = { "", "/" })
public class DefaultIndexController extends BaseController {
	private static Logger logger = Logger
			.getLogger(DefaultIndexController.class.getName());

	@Autowired
	private BasicConfig basicConfig; // 注入基础配置。

	private static String webrootPath;
	private static String contextPath;
	private static final String REDIRECT = "redirect:";

	@Autowired
	private IChannelService channelService;

	@Autowired
	private IDocumentService documentService;

	/**
	 * 首页跳转。
	 * 
	 * @param sitePreference
	 * @param uiModel
	 * @param httpServletRequest
	 * @return
	 */
	@RequestMapping(value = { "", "/", "index" })
	public String index(SitePreference sitePreference, Model uiModel,
			HttpServletRequest httpServletRequest) {

		String result = getIndexFile(sitePreference, httpServletRequest);
		if (null != result) {
			return result;
		}
		String uri = httpServletRequest.getScheme() + "://"
				+ httpServletRequest.getServerName() + ":"
				+ httpServletRequest.getServerPort()
				+ httpServletRequest.getRequestURI();
		System.out.println(uri);
		String referer = httpServletRequest.getHeader("referer");
		System.out.println(referer);
		// List<Channel> list = channelService.getChannelTree();
		List<Channel> list = UserUtils.getChannels(); // 利用缓存。
		uiModel.addAttribute("list", list);
		// 约定指向文档的栏目不会出现在模块内容当中。
		List<Channel> modules = new ArrayList<Channel>();
		for (Channel channel2 : list) {
			if (!channel2.getAsdocument()) {
				modules.add(channel2);
			}
		}
		uiModel.addAttribute("modules", modules);

		// 查询推荐文档。
		/*
		 * Page page = new Page(); page.setPageSize(8);
		 */
		// List<Document> recommendDocs = documentService.getRecommendDoc(page);
		/*
		 * List<Document> recommendDocs =
		 * documentService.getDocByChannelCode(null,page); for (Document
		 * document : recommendDocs) { Channel channel =
		 * channelService.selectByPrimaryKey(document.getChannelId());
		 * document.setChannel(channel); } uiModel.addAttribute("recommendDocs",
		 * recommendDocs); page.setPageSize(5); List<Document> recommendImage =
		 * documentService.getRecommendImage(page); for (Document document :
		 * recommendImage) { Channel channel =
		 * channelService.selectByPrimaryKey(document.getChannelId());
		 * document.setChannel(channel); }
		 * uiModel.addAttribute("recommendImage", recommendImage); // 高点击率
		 * page.setPageSize(10); List<Document> clickCountDocs =
		 * documentService.getClickCountDoc(null, page); for (Document document
		 * : clickCountDocs) { Channel channel =
		 * channelService.selectByPrimaryKey(document .getChannelId());
		 * document.setChannel(channel); }
		 * uiModel.addAttribute("clickCountDocs", clickCountDocs);
		 */
		// return "m-woshang-index.jsp";
		if (sitePreference == SitePreference.MOBILE) {
			logger.info("手机来的网页请求home-mobile");
			return basicConfig.getMindexJsp();// "m-woshang-index.jsp";
		} else {
			logger.info("PC来的网页请求");
			return basicConfig.getIndexJsp();// "woshang-index.jsp";
		}
	}

	@RequestMapping(value = "m-index")
	public String mindex(SitePreference sitePreference, Model uiModel,
			HttpServletRequest httpServletRequest) {
		if (webrootPath == null) {
			webrootPath = httpServletRequest.getRealPath("/");
		}
		if (contextPath == null) {
			contextPath = httpServletRequest.getContextPath();
		}
		String webroot = webrootPath;
		String conPath = contextPath;
		String requestRri = httpServletRequest.getRequestURI();
		int index = -1;
		if ("".equals(conPath)) {
			index = 0;
		} else {
			index = requestRri.lastIndexOf(conPath);
		}
		webroot += requestRri + ".html";
		File file = new File(webroot);
		if (file.exists()) {
			return REDIRECT + requestRri + ".html";
		}

		List<Channel> list = UserUtils.getChannels(); // 利用缓存。
		uiModel.addAttribute("list", list);
		// 约定指向文档的栏目不会出现在模块内容当中。
		List<Channel> modules = new ArrayList<Channel>();
		for (Channel channel2 : list) {
			if (!channel2.getAsdocument()) {
				modules.add(channel2);
			}
		}
		uiModel.addAttribute("modules", modules);

		return "m-woshang-index.jsp";
	}

	@SuppressWarnings("deprecation")
	private String getIndexFile(SitePreference sitePreference,
			HttpServletRequest httpServletRequest) {
		if (webrootPath == null) {
			webrootPath = httpServletRequest.getRealPath("/");
		}
		if (contextPath == null) {
			contextPath = httpServletRequest.getContextPath();
		}
		String webroot = webrootPath;
		String conPath = contextPath;

		String requestRri = httpServletRequest.getRequestURI();
		int index = -1;
		if ("".equals(conPath)) {
			index = 0;
		} else {
			index = requestRri.lastIndexOf(conPath);
		}

		if (index != -1) {
			requestRri = requestRri.substring(index + conPath.length() + 1);
			requestRri = requestRri.replaceAll("//", File.separator);

			if (sitePreference == SitePreference.MOBILE) {
				webroot += requestRri + "m-index.html";
				File file = new File(webroot);
				if (file.exists()) {
					return REDIRECT + requestRri + "m-index.html";
				}
			} else {
				webroot += requestRri + "index.html";
				File file = new File(webroot);
				if (file.exists()) {
					return REDIRECT + requestRri + "index.html";
				}
			}
		}
		return null;
	}
}
