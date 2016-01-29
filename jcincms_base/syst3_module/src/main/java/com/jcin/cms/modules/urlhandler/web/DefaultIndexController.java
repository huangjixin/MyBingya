/**
 * 一句话描述该类：<br/>
 * @author 黄记新
 * @date 2015-10-21,下午4:00:41
 *
 */
package com.jcin.cms.modules.urlhandler.web;

import java.util.ArrayList;
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
import com.jcin.cms.modules.channel.domain.Document;
import com.jcin.cms.modules.channel.service.IChannelService;
import com.jcin.cms.modules.channel.service.IDocumentService;
import com.jcin.cms.utils.Page;
import com.jcin.cms.web.BaseController;

/**
 * @author 黄记新
 * 
 */
@SuppressWarnings("rawtypes")
@Controller
@RequestMapping(value = { "", "/" })
// @Scope(value="prototype")
public class DefaultIndexController extends BaseController {
	private static Logger logger = Logger
			.getLogger(DefaultIndexController.class.getName());

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
	@RequestMapping
	public String index(SitePreference sitePreference, Model uiModel,
			HttpServletRequest httpServletRequest) {
		String uri =httpServletRequest.getRequestURI();
		System.out.println(uri); 
		String referer = httpServletRequest.getHeader("Referer");
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

		//查询推荐文档。
		Page page = new Page();
		page.setPageSize(8);
//		List<Document> recommendDocs = documentService.getRecommendDoc(page);
		List<Document> recommendDocs = documentService.getDocByChannelCode(null,page);
		for (Document document : recommendDocs) {
			Channel channel = channelService.selectByPrimaryKey(document.getChannelId());
			document.setChannel(channel);
		}
		uiModel.addAttribute("recommendDocs", recommendDocs);
		page.setPageSize(5);
		List<Document> recommendImage = documentService.getRecommendImage(page);
		for (Document document : recommendImage) {
			Channel channel = channelService.selectByPrimaryKey(document.getChannelId());
			document.setChannel(channel);
		}
		uiModel.addAttribute("recommendImage", recommendImage);
		// 高点击率
		page.setPageSize(10);
		List<Document> clickCountDocs = documentService.getClickCountDoc(null,
				page);
		for (Document document : clickCountDocs) {
			Channel channel = channelService.selectByPrimaryKey(document
					.getChannelId());
			document.setChannel(channel);
		}
		uiModel.addAttribute("clickCountDocs", clickCountDocs);

		if (sitePreference == SitePreference.MOBILE) {
			logger.info("手机来的网页请求home-mobile");
			return "m-index.jsp";
		} else {
			logger.info("PC来的网页请求");
			return "zhiwo-index.jsp";
		}
	}
}
