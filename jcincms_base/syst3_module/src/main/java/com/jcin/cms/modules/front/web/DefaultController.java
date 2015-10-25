/**
 * 一句话描述该类：<br/>
 * @author 黄记新
 * @date 2015-10-21,下午4:00:41
 *
 */
/**
 * 
 */
package com.jcin.cms.modules.front.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jcin.cms.modules.channel.domain.Channel;
import com.jcin.cms.modules.channel.domain.Document;
import com.jcin.cms.modules.channel.domain.DocumentCriteria;
import com.jcin.cms.modules.channel.service.IChannelService;
import com.jcin.cms.modules.channel.service.IDocumentService;
import com.jcin.cms.utils.Page;

/**
 * @author 黄记新
 * 
 */
@Controller
@RequestMapping(value = "/")
public class DefaultController {

	@Autowired
	private IChannelService channelService;

	@Autowired
	private IDocumentService documentService;

	@RequestMapping
	public String index(Model uiModel, HttpServletRequest httpServletRequest) {
		List<Channel> list = channelService.selectAll();
		uiModel.addAttribute("list", list);
		return "front/index";
	}

	@RequestMapping(value = "{channels:^(?!${excludePath}).*$}")
	public String channels(@PathVariable("channels") String channels,
			@ModelAttribute Page page, Model uiModel,
			HttpServletRequest httpServletRequest) {
		String requestRri = httpServletRequest.getRequestURI();
		Channel channel = channelService.getByCode(channels);
		if (null == channel) {
			return "front/channelNotExsit";
		}

		channel.setLinkAddr(requestRri);

		if (channel.hasChildren()) { // 此处应该返回栏目一级级模板目录。
			for (int i = 0; i < channel.getChildren().size(); i++) {
				Channel ch = channel.getChildren().get(i);
				ch.setLinkAddr(requestRri + "/" + ch.getCode());
			}
			uiModel.addAttribute("name", channel.getName());
			uiModel.addAttribute("channel", channel);
			if(null!=channel.getChannelTemplete() && !"".equals(channel.getChannelTemplete())){
				return channel.getChannelTemplete();
			}
			return "front/channel";
		}

		String chan = channel(channels, channel.getCode(), page, uiModel,
				httpServletRequest, channel);
		return chan;
	}

	@RequestMapping(value = "{channels:^(?!${excludePath}).*$}/{code}")
	public String channel(@PathVariable("channels") String channels,
			@PathVariable("code") String code, @ModelAttribute Page page,
			Model uiModel, HttpServletRequest httpServletRequest,
			Channel channel) {
		String requestRri = httpServletRequest.getRequestURI();
		setPage(page, httpServletRequest);
		if (null == channel || null == channel.getId()) {
			channel = channelService.getByCode(code);
		}
		if (null == channel || null == channel.getId()) {
			return "front/channelNotExsit";
		}
		channel.setLinkAddr(requestRri);
		uiModel.addAttribute("name", channel.getName());
		uiModel.addAttribute("channel", channel);

		DocumentCriteria documentCriteria = new DocumentCriteria();
		DocumentCriteria.Criteria criteria = documentCriteria.createCriteria();
		criteria.andChannelIdEqualTo(channel.getId());
		documentCriteria.setPage(page);
		documentCriteria.setOrderByClause("id desc");

		page = documentService.select(documentCriteria);

		uiModel.addAttribute("page", page);
		if(null!=channel.getChannelTemplete() && !"".equals(channel.getChannelTemplete())){
			return channel.getChannelTemplete();
		}
		return "front/channelDetail";
	}

	@RequestMapping(value = "{channels:^(?!${excludePath}).*$}/{code}/{id}")
	public String doc(@PathVariable("channels") String channels,
			@PathVariable("code") String code, @PathVariable("id") String id,
			@ModelAttribute Page page, Model uiModel,
			HttpServletRequest httpServletRequest) {
		Document document = documentService.selectByPrimaryKey(id);
		if (null == document) {
			return "front/channelNotExsit";
		}
		uiModel.addAttribute("document", document);
		uiModel.addAttribute("page", page);
		if(null!=document.getDocumentTemplete() && !"".equals(document.getDocumentTemplete())){
			return document.getDocumentTemplete();
		}
		
		return "front/document";
	}

	/**
	 * 设置page。
	 * 
	 * @param page
	 * @param httpServletRequest
	 */
	private void setPage(Page page, HttpServletRequest httpServletRequest) {
		// String requestRri = httpServletRequest.getRequestURI();

		// 当前页
		String startStr = httpServletRequest.getParameter("start");
		// 当前页
		String pageStr = httpServletRequest.getParameter("page");
		Integer intPage = null;
		if (null != pageStr) {
			intPage = Integer.parseInt(pageStr);
		} else if (null != startStr) {
			intPage = Integer.parseInt(startStr);
		} else {
			intPage = 0;
		}

		// 每页显示条数
		String limit = httpServletRequest.getParameter("limit");
		// 每页显示条数
		String rows = httpServletRequest.getParameter("rows");
		Integer number = null;
		if (null != rows) {
			number = Integer.parseInt(rows);
		} else if (null != limit) {
			number = Integer.parseInt(limit);
		} else {
			number = 10;
		}

		int start = 0;
		// 每页的开始记录 第一页为1 第二页为number +1
		if (page != null && rows != null) {
			start = (intPage - 1) * number;
		} else if (startStr != null) {
			start = Integer.parseInt(startStr);
		}

		page.setStart(start);
		page.setPageSize(number);
	}
}
