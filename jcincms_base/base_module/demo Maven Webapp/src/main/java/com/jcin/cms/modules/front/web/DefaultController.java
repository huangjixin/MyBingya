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

import com.jcin.cms.common.UserUtils;
import com.jcin.cms.modules.channel.domain.Channel;
import com.jcin.cms.modules.channel.domain.Document;
import com.jcin.cms.modules.channel.domain.DocumentCriteria;
import com.jcin.cms.modules.channel.service.IChannelService;
import com.jcin.cms.modules.channel.service.IDocumentService;
import com.jcin.cms.utils.Page;
import com.jcin.cms.web.BaseController;

/**
 * @author 黄记新
 * 
 */
@Controller
@RequestMapping(value = "/channel")
public class DefaultController extends BaseController {

	@Autowired
	private IChannelService channelService;

	@Autowired
	private IDocumentService documentService;

	@RequestMapping
	public String index(Model uiModel, HttpServletRequest httpServletRequest) {
		// List<Channel> list = channelService.getChannelTree();
		List<Channel> list = UserUtils.getChannels();
		uiModel.addAttribute("list", list);
		return "defaultApp/index.jsp";
	}

	@RequestMapping(value = "{channels}")
	public String channels(@PathVariable("channels") String channels,
			@ModelAttribute Page page, Model uiModel,
			HttpServletRequest httpServletRequest) {
		setPage(page, httpServletRequest);
		// String requestRri = httpServletRequest.getRequestURI(); :^(?!${excludePath}).*$
		// 检查栏目是否存在；
		Channel channel = channelService.getByCode(channels);
		if (null == channel) {
			return root + "defaultApp/channelNotExsit.jsp";
		}

		// channel.setLinkAddr(requestRri);
		uiModel.addAttribute("name", channel.getName());
		uiModel.addAttribute("channel", channel);

		// 菜单
		List<Channel> list = UserUtils.getChannels();
		uiModel.addAttribute("list", list);

		// 检查栏目是否为文档。；
		if (channel.getAsdocument()) {
			if (channel.getDocumentId() == null
					|| "".equals(channel.getDocumentId())) {
				uiModel.addAttribute("msg", "栏目所对应的");
				return root + "defaultApp/channelNotExsit.jsp";
			}
			Document document = documentService.selectByPrimaryKey(channel
					.getDocumentId());
			if (null != document)
				uiModel.addAttribute("document", document);

			if (null != document.getDocumentTemplete()
					&& !"".equals(document.getDocumentTemplete())) {
				return document.getDocumentTemplete();
			}

			return root + "defaultApp/document.jsp";
		}

		// 栏目模板不为空返回模板。
		if (null != channel.getChannelTemplete()
				&& !"".equals(channel.getChannelTemplete())) {
			/*DocumentCriteria documentCriteria = new DocumentCriteria();
			DocumentCriteria.Criteria criteria = documentCriteria.createCriteria();
			criteria.andChannelIdEqualTo(channel.getId());
			documentCriteria.setPage(page);
			documentCriteria.setOrderByClause("id desc");

			page = documentService.select(documentCriteria);*/
			documentService.getDocByChannelCode(channels, page);
			
			uiModel.addAttribute("page", page);
			
			return channel.getChannelTemplete();
		}
		/*
		 * if (channel.hasChildren()) { // 此处应该返回栏目一级级模板目录。 if (null !=
		 * channel.getChannelTemplete() &&
		 * !"".equals(channel.getChannelTemplete())) { return
		 * channel.getChannelTemplete(); } return root+"defaultApp/channels"; }
		 */

		// 返回默认。
		return root + "defaultApp/channels";
	}

	@RequestMapping(value = "{channels}/{code}")
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
			return root + "defaultApp/channelNotExsit.jsp";
		}

		uiModel.addAttribute("name", channel.getName());
		uiModel.addAttribute("channel", channel);

		// 菜单
		List<Channel> list = UserUtils.getChannels();
		uiModel.addAttribute("list", list);

		// 检查栏目是否为文档。；
		if (channel.getAsdocument()) {
			if (channel.getDocumentId() == null
					|| "".equals(channel.getDocumentId())) {
				return root + "defaultApp/channelNotExsit.jsp";
			}
			Document document = documentService.selectByPrimaryKey(channel
					.getDocumentId());
			if (null != document)
				uiModel.addAttribute("document", document);

			if (null != document.getDocumentTemplete()
					&& !"".equals(document.getDocumentTemplete())) {
				return document.getDocumentTemplete();
			}

			return root + "defaultApp/document.jsp";
		}

		channel.setLinkAddr(requestRri);

		documentService.getDocByChannelCode(code, page);
		/*DocumentCriteria documentCriteria = new DocumentCriteria();
		DocumentCriteria.Criteria criteria = documentCriteria.createCriteria();
		criteria.andChannelIdEqualTo(channel.getId());
		documentCriteria.setPage(page);*/
		// documentCriteria.setOrderByClause("id desc");

		//page = documentService.select(documentCriteria);

		uiModel.addAttribute("page", page);
		if (null != channel.getChannelTemplete()
				&& !"".equals(channel.getChannelTemplete())) {
			return channel.getChannelTemplete();
		}
		return root + "defaultApp/channelDetail.jsp";
	}
	
	@RequestMapping(value = "{channels}/{channel}/**/{code}")
	public String channels(@PathVariable("channels") String channels,
			@PathVariable("code") String code, @ModelAttribute Page page,
			Model uiModel, HttpServletRequest httpServletRequest,
			Channel channel) {
		String requestRri = httpServletRequest.getRequestURI();
		setPage(page, httpServletRequest);
		if (null == channel || null == channel.getId()) {
			channel = channelService.getByCode(code);
		}
		if (null == channel || null == channel.getId()) {
			return root + "defaultApp/channelNotExsit.jsp";
		}
		
		uiModel.addAttribute("name", channel.getName());
		uiModel.addAttribute("channel", channel);
		
		// 菜单
		List<Channel> list = UserUtils.getChannels();
		uiModel.addAttribute("list", list);
		
		// 检查栏目是否为文档。；
		if (channel.getAsdocument()) {
			if (channel.getDocumentId() == null
					|| "".equals(channel.getDocumentId())) {
				return root + "defaultApp/channelNotExsit.jsp";
			}
			Document document = documentService.selectByPrimaryKey(channel
					.getDocumentId());
			if (null != document)
				uiModel.addAttribute("document", document);
			
			if (null != document.getDocumentTemplete()
					&& !"".equals(document.getDocumentTemplete())) {
				return document.getDocumentTemplete();
			}
			
			return root + "defaultApp/document.jsp";
		}
		
		channel.setLinkAddr(requestRri);
		
		DocumentCriteria documentCriteria = new DocumentCriteria();
		DocumentCriteria.Criteria criteria = documentCriteria.createCriteria();
		criteria.andChannelIdEqualTo(channel.getId());
		documentCriteria.setPage(page);
		// documentCriteria.setOrderByClause("id desc");
		
		page = documentService.select(documentCriteria);
		
		uiModel.addAttribute("page", page);
		if (null != channel.getChannelTemplete()
				&& !"".equals(channel.getChannelTemplete())) {
			return channel.getChannelTemplete();
		}
		return root + "defaultApp/channelDetail.jsp";
	}

	@RequestMapping(value = "{channels}/**/doc/{id}")
	public String doc(@PathVariable("channels") String channels,@PathVariable("id") String id,
			@ModelAttribute Page page, Model uiModel,
			HttpServletRequest httpServletRequest) {
		List<Channel> list = UserUtils.getChannels();//:^(?!${excludePath}).*$
		uiModel.addAttribute("list", list);
		Document document = documentService.selectByPrimaryKey(id);
		if (null == document) {
			return root + "defaultApp/channelNotExsit.jsp";
		}
		uiModel.addAttribute("document", document);
		uiModel.addAttribute("page", page);
		if (null != document.getDocumentTemplete()
				&& !"".equals(document.getDocumentTemplete())) {
			return document.getDocumentTemplete();
		}

		return root + "defaultApp/document.jsp";
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
		}else if (pageStr != null) {
			start = (intPage - 1) * number;
		}

		page.setStart(start);
		page.setPageSize(number);
	}
}
