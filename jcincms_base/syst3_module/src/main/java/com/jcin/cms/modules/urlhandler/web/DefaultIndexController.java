/**
 * 一句话描述该类：<br/>
 * @author 黄记新
 * @date 2015-10-21,下午4:00:41
 *
 */
package com.jcin.cms.modules.urlhandler.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.mobile.device.site.SitePreference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jcin.cms.common.SpringUtils;
import com.jcin.cms.common.UserUtils;
import com.jcin.cms.modules.channel.domain.Channel;
import com.jcin.cms.modules.channel.domain.Document;
import com.jcin.cms.modules.channel.domain.DocumentCriteria;
import com.jcin.cms.modules.channel.service.IChannelService;
import com.jcin.cms.modules.channel.service.IDocumentService;
import com.jcin.cms.modules.channel.service.impl.ChannelServiceImpl;
import com.jcin.cms.modules.syst.service.impl.DbBackupServiceImpl;
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
	private static Logger logger = Logger.getLogger(DefaultIndexController.class
			.getName());
	private static IChannelService channelServ = SpringUtils
			.getBean(ChannelServiceImpl.class);

	@Autowired
	private IChannelService channelService;

	@Autowired
	private IDocumentService documentService;

	/**
	 * 首页跳转。
	 * @param sitePreference
	 * @param uiModel
	 * @param httpServletRequest
	 * @return
	 */
	@RequestMapping
	public String index(SitePreference sitePreference,Model uiModel, HttpServletRequest httpServletRequest) {
		// List<Channel> list = channelService.getChannelTree();
		List<Channel> list = UserUtils.getChannels(); // 利用缓存。
		uiModel.addAttribute("list", list);
		
		Page page = new Page();
		List<Document> recommendDocs = documentService.getRecommendDoc(page);
		for (Document document : recommendDocs) {
			Channel channel = channelService.selectByPrimaryKey(document.getChannelId());
			document.setChannel(channel);
		}
		uiModel.addAttribute("recommendDocs", recommendDocs);
		if (sitePreference == SitePreference.MOBILE) {
			logger.info("手机来的网页请求home-mobile");
			return "m-index.jsp";
        } else {
        	logger.info("PC来的网页请求");
        	return "index.jsp";
        }
	}
}
