/**
 * 一句话描述该类：<br/>
 * @author 黄记新
 * @date 2015-10-21,下午4:00:41
 *
 */
package com.jcin.cms.modules.urlhandler.web;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping(value = { "", "/", "index" })
public class DefaultIndexController extends BaseController {
	private static Logger logger = Logger
			.getLogger(DefaultIndexController.class.getName());

	public static long endtime = 0l;
	@Autowired
	private BasicConfig basicConfig; // 注入基础配置。

	private static String webrootPath;
	private static String contextPath;
	private static final String REDIRECT = "";

	@Autowired
	private IChannelService channelService;

	@Autowired
	private IDocumentService documentService;

	public static void main(String[] args) {
		System.out.println(new Date().getTime()+15552000000l);
		System.out.println(15552000000l);
	}
	/**
	 * 首页跳转。
	 * 
	 * @param sitePreference
	 * @param uiModel
	 * @param httpServletRequest
	 * @return
	 */
	@SuppressWarnings("deprecation")
	@RequestMapping(value = { "", "/", "index" })
	public String index(SitePreference sitePreference, Model uiModel,
			HttpServletRequest httpServletRequest) {
		/*if(endtime==0){
			try {
				endtime = new SimpleDateFormat("yyyy.MM.dd").parse("2016.10.01").getTime();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(new Date().getTime()+","+endtime+","+(new Date().getTime()-endtime));
		long end = endtime-new Date().getTime();
		if(endtime>0){
			return "/error.jsp";
		}*/
		String result = getIndexFile(sitePreference, httpServletRequest);
		if (null != result) {
			return result;
		}

		if (webrootPath == null) {
			webrootPath = httpServletRequest.getRealPath("/");
		}
		if (contextPath == null) {
			contextPath = httpServletRequest.getContextPath();
		}
		String webroot = webrootPath;
		String conPath = contextPath;

		/*
		 * String uri = httpServletRequest.getScheme() + "://" +
		 * httpServletRequest.getServerName() + ":" +
		 * httpServletRequest.getServerPort() +
		 * httpServletRequest.getRequestURI(); System.out.println(uri); String
		 * referer = httpServletRequest.getHeader("referer");
		 * System.out.println(referer);
		 */
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
			if (null != basicConfig.getMindexJsp()
					&& !"".equals(basicConfig.getMindexJsp())) {
				File file = new File(webroot + basicConfig.getMindexJsp());
				if (file.exists()) {
					logger.info("手机来的网页请求home-mobile");
					return basicConfig.getMindexJsp();
				}
			}
			return basicConfig.getIndexJsp();
			// "m-woshang-index.jsp";
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

		String webroot = webrootPath;
		String m_index = basicConfig.getMindexJsp();
		int dot = m_index.indexOf(".");
		m_index = m_index.substring(0, dot);
		webroot += m_index + ".html";
		File file = new File(webroot);
		if (file.exists()) {
			return REDIRECT + m_index + ".html";
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

		return basicConfig.getMindexJsp();
	}

	@SuppressWarnings("deprecation")
	private String getIndexFile(SitePreference sitePreference,
			HttpServletRequest httpServletRequest) {
		if (webrootPath == null) {
			webrootPath = httpServletRequest.getRealPath("/");
		}
		
		String webroot = webrootPath;
		if (sitePreference == SitePreference.MOBILE) {
			String m_index = basicConfig.getMindexJsp();
			int dot = m_index.indexOf(".");
			m_index = m_index.substring(0, dot);
			webroot += m_index + ".html";
			File file = new File(webroot);
			if (file.exists()) {
				return REDIRECT + m_index + ".html";
			}
		} else {
			String index = basicConfig.getIndexJsp();
			int dot = index.indexOf(".");
			index = index.substring(0, dot);
			webroot += index + ".html";
			File file = new File(webroot);
			if (file.exists()) {
				return REDIRECT + index + ".html";
			}
		}
		
		return null;
	}
}
