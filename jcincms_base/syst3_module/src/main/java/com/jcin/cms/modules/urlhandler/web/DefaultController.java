/**
 * 一句话描述该类：<br/>
 * @author 黄记新
 * @date 2015-10-21,下午4:00:41
 *
 */
/**
 * 
 */
package com.jcin.cms.modules.urlhandler.web;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.site.SitePreference;
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
	public String index(SitePreference sitePreference,Model uiModel, HttpServletRequest httpServletRequest) {
		// List<Channel> list = channelService.getChannelTree();
		List<Channel> list = UserUtils.getChannels();
		uiModel.addAttribute("list", list);
		if (sitePreference == SitePreference.MOBILE) {
			return "m-index.jsp";
        } else {
        	return "index.jsp";
        }
	}

	@RequestMapping(value = "{channels:^[a-z]+$}")
	public String channels(SitePreference sitePreference,@PathVariable("channels") String channels,
			@ModelAttribute Page page, Model uiModel,
			HttpServletRequest httpServletRequest) {
		String result = getChannelFile(sitePreference,httpServletRequest,channels);
		if(result!=null){
			return result;
		}
		
		// 检查栏目是否存在；
		Channel channel = channelService.getByCode(channels);
		if (null == channel) {
			return "channelNotExsit.jsp";
		}

		// channel.setLinkAddr(requestRri);
		uiModel.addAttribute("name", channel.getName());
		uiModel.addAttribute("channel", channel);

		// 菜单
		List<Channel> list = UserUtils.getChannels();
		uiModel.addAttribute("list", list);
		List<Channel> navChan = getParentChannels(list,channel);
		uiModel.addAttribute("navChan", navChan);
		// 检查栏目是否为文档。；
		if (channel.getAsdocument()) {
			if (channel.getDocumentId() == null
					|| "".equals(channel.getDocumentId())) {
				uiModel.addAttribute("msg", "栏目所对应的");
				return "channelNotExsit.jsp";
			}
			Document document = documentService.selectByPrimaryKey(channel
					.getDocumentId());
			if (null != document)
				uiModel.addAttribute("document", document);

			if (null != document.getDocumentTemplete()
					&& !"".equals(document.getDocumentTemplete())) {
				return document.getDocumentTemplete();
			}

			if (sitePreference == SitePreference.MOBILE) {
				return "m-doc.jsp";
	        } else {
	        	return "doc.jsp";
	        }
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
		if (sitePreference == SitePreference.MOBILE) {
			return "m-channels.jsp";
        } else {
        	return "channels.jsp";
        }
	}

	@RequestMapping(value = "{channels}/{code:^[a-z]+$}")
	public String channel(SitePreference sitePreference,@PathVariable("channels") String channels,
			@PathVariable("code") String code, @ModelAttribute Page page,
			Model uiModel, HttpServletRequest httpServletRequest,
			Channel channel) {
		String result = getChannelFile(sitePreference,httpServletRequest,code);
		if(result!=null){
			return result;
		}
		
		setPage(page, httpServletRequest);
		if (null == channel || null == channel.getId()) {
			channel = channelService.getByCode(code);
		}
		if (null == channel || null == channel.getId()) {
			return "channelNotExsit.jsp";
		}

		uiModel.addAttribute("name", channel.getName());
		uiModel.addAttribute("channel", channel);

		// 菜单
		List<Channel> list = UserUtils.getChannels();
		uiModel.addAttribute("list", list);
		List<Channel> navChan = getParentChannels(list,channel);
		uiModel.addAttribute("navChan", navChan);
		// 检查栏目是否为文档。；
		if (channel.getAsdocument()) {
			if (channel.getDocumentId() == null
					|| "".equals(channel.getDocumentId())) {
				return "channelNotExsit.jsp";
			}
			Document document = documentService.selectByPrimaryKey(channel
					.getDocumentId());
			if (null != document)
				uiModel.addAttribute("document", document);

			if (null != document.getDocumentTemplete()
					&& !"".equals(document.getDocumentTemplete())) {
				return document.getDocumentTemplete();
			}

			if (sitePreference == SitePreference.MOBILE) {
				return "m-doc.jsp";
	        } else {
	        	return "doc.jsp";
	        }
		}

//		channel.setLinkAddr(requestRri);

		/*DocumentCriteria documentCriteria = new DocumentCriteria();
		DocumentCriteria.Criteria criteria = documentCriteria.createCriteria();
		criteria.andChannelIdEqualTo(channel.getId());
		documentCriteria.setPage(page);*/
		// documentCriteria.setOrderByClause("id desc");

		//page = documentService.select(documentCriteria);

		if (null != channel.getChannelTemplete()
				&& !"".equals(channel.getChannelTemplete())) {
			return channel.getChannelTemplete();
		}
		
		if (null == channel.getChildren()||channel.getChildren().size()==0) {
			documentService.getDocByChannelCode(code, page);
			uiModel.addAttribute("page", page);
			if (sitePreference == SitePreference.MOBILE) {
				return "m-channel.jsp";
	        } else {
	        	return "channel.jsp";
	        }
		}
		
		return "channels.jsp";
	}
	
	@RequestMapping(value = "{channels}/{channel}/**/{code:^[a-z]+$}")
	public String channels(SitePreference sitePreference,@PathVariable("channels") String channels,
			@PathVariable("code") String code, @ModelAttribute Page page,
			Model uiModel, HttpServletRequest httpServletRequest,
			Channel channel) {
		String result = getChannelFile(sitePreference,httpServletRequest,code);
		if(result!=null){
			return result;
		}
		setPage(page, httpServletRequest);
		if (null == channel || null == channel.getId()) {
			channel = channelService.getByCode(code);
		}
		if (null == channel || null == channel.getId()) {
			return "channelNotExsit.jsp";
		}
		
		uiModel.addAttribute("name", channel.getName());
		uiModel.addAttribute("channel", channel);
		
		// 菜单
		List<Channel> list = UserUtils.getChannels();
		uiModel.addAttribute("list", list);
		
		List<Channel> navChan = getParentChannels(list,channel);
		uiModel.addAttribute("navChan", navChan);
		// 检查栏目是否为文档。；
		if (channel.getAsdocument()) {
			if (channel.getDocumentId() == null
					|| "".equals(channel.getDocumentId())) {
				return "channelNotExsit.jsp";
			}
			Document document = documentService.selectByPrimaryKey(channel
					.getDocumentId());
			if (null != document)
				uiModel.addAttribute("document", document);
			
			if (null != document.getDocumentTemplete()
					&& !"".equals(document.getDocumentTemplete())) {
				return document.getDocumentTemplete();
			}
			if (sitePreference == SitePreference.MOBILE) {
				return "m-doc.jsp";
	        } else {
	        	return "doc.jsp";
	        }
		}
		
//		channel.setLinkAddr(requestRri);
		
//		DocumentCriteria documentCriteria = new DocumentCriteria();
//		DocumentCriteria.Criteria criteria = documentCriteria.createCriteria();
//		criteria.andChannelIdEqualTo(channel.getId());
//		documentCriteria.setPage(page);
		// documentCriteria.setOrderByClause("id desc");
		
//		page = documentService.select(documentCriteria);
		
		if (null != channel.getChannelTemplete()
				&& !"".equals(channel.getChannelTemplete())) {
			return channel.getChannelTemplete();
		}
		if (null == channel.getChildren()||channel.getChildren().size()==0) {
			documentService.getDocByChannelCode(code, page);
			uiModel.addAttribute("page", page);
			if (sitePreference == SitePreference.MOBILE) {
				return "m-channel.jsp";
	        } else {
	        	return "channel.jsp";
	        }
		}
		return "channels.jsp";
	}

//	@RequestMapping(value = "{channels}/**/docs/{channel}")
//	public String channeldoc(@PathVariable("channels") String channels,@PathVariable("channel") String channel,
//			@ModelAttribute Page page, Model uiModel,
//			HttpServletRequest httpServletRequest) {
//		
//	}
	
	@RequestMapping(value = "{channels}/**/doc/{id:^[0-9]+$}")
	public String doc(SitePreference sitePreference,@PathVariable("channels") String channels,@PathVariable("id") String id,
			@ModelAttribute Page page, Model uiModel,
			HttpServletRequest httpServletRequest) {
		String result = getDocFile(sitePreference,httpServletRequest,id);
		if(result!=null){
			return result;
		}
		
		List<Channel> list = UserUtils.getChannels();
		uiModel.addAttribute("list", list);
		
		Document document = documentService.selectByPrimaryKey(id);
		if (null == document) {
			return "channelNotExsit.jsp";
		}
		Channel channel = channelService.selectByPrimaryKey(document.getChannelId());
		List<Channel> navChan = getParentChannels(list,channel);
		uiModel.addAttribute("navChan", navChan);
		uiModel.addAttribute("channel", channel);
		uiModel.addAttribute("document", document);
		uiModel.addAttribute("page", page);
		Document lastdoc = documentService.selectLastRecord(document);
		Document nextdoc = documentService.selectNextRecord(document);
		uiModel.addAttribute("lastdoc", lastdoc);
		uiModel.addAttribute("nextdoc", nextdoc);
		if (null != document.getDocumentTemplete()
				&& !"".equals(document.getDocumentTemplete())) {
			return document.getDocumentTemplete();
		}

		if (sitePreference == SitePreference.MOBILE) {
			return "m-doc.jsp";
        } else {
        	return "doc.jsp";
        }
	}
	
	private static String webrootPath;
	private static String contextPath;
	
	
	@SuppressWarnings("deprecation")
	private String getChannelFile(SitePreference sitePreference,HttpServletRequest httpServletRequest,String channelOrCode){
		if(webrootPath==null){
			webrootPath = httpServletRequest.getRealPath("/");
		}
		if(contextPath==null){
			contextPath = httpServletRequest.getContextPath();
		}
		String webroot = webrootPath;
		String conPath = contextPath;
		// 当前页
		String page = httpServletRequest.getParameter("page");
		
		String requestRri = httpServletRequest.getRequestURI();
		int index = -1;
		if("".equals(conPath)){
			 index = 0;
		}else{
			index = requestRri.lastIndexOf(conPath);
		}
		if(index!=-1){
			requestRri = requestRri.substring(index+conPath.length()+1);
			requestRri = requestRri.replaceAll("//", File.separator);
			webroot+=requestRri; 
			File file = null;
			if (sitePreference == SitePreference.MOBILE) {
				if(page!=null){
					file = new File(webroot+"docs"+File.separator+channelOrCode+page+"m.html");
					if(file.exists()){
						return requestRri+"docs"+File.separator+channelOrCode+page+"m.html";
					}
				}else{
					file = new File(webroot+"docs"+File.separator+channelOrCode+"1m.html");
					if(file.exists()){
						return requestRri+"docs"+File.separator+channelOrCode+"1m.html";
					}
				}
	        } else {
	        	if(page!=null){
					file = new File(webroot+"docs"+File.separator+channelOrCode+page+".html");
					if(file.exists()){
						return requestRri+"docs"+File.separator+channelOrCode+page+".html";
					}
				}else{
					file = new File(webroot+"docs"+File.separator+channelOrCode+"1.html");
					if(file.exists()){
						return requestRri+"docs"+File.separator+channelOrCode+"1.html";
					}
				}
	        }
		}
		return null;
	}
	
	@SuppressWarnings("deprecation")
	private String getDocFile(SitePreference sitePreference,HttpServletRequest httpServletRequest,String id){
		if(webrootPath==null){
			webrootPath = httpServletRequest.getRealPath("/");
		}
		if(contextPath==null){
			contextPath = httpServletRequest.getContextPath();
		}
		String webroot = webrootPath;
		String conPath = contextPath;
		
		String requestRri = httpServletRequest.getRequestURI();
		int index = -1;
		if("".equals(conPath)){
			 index = 0;
		}else{
			index = requestRri.lastIndexOf(conPath);
		}
		
		if(index!=-1){
			requestRri = requestRri.substring(index+conPath.length()+1);
			requestRri = requestRri.replaceAll("//", File.separator);
			requestRri = requestRri.replaceAll("doc", "docs");
			if (sitePreference == SitePreference.MOBILE) {
				webroot+=requestRri+"m.html";
				File file = new File(webroot);
				if(file.exists()){
					return requestRri+"m.html";
				}
	        } else {
	        	webroot+=requestRri+".html";
	        	File file = new File(webroot);
				if(file.exists()){
					return requestRri+".html";
				}
	        }
		}
		return null;
	}
	
	private List<Channel> getParentChannels(List<Channel> list,Channel currentChannel){
		List<Channel> result = new ArrayList<Channel>();
		while (currentChannel!=null && !"".equals(currentChannel.getParentId()) && null !=currentChannel.getParentId()) {
			result.add(currentChannel);
			List<Channel> res = new ArrayList<Channel>();
			searchChannel( list,currentChannel,res);
			if(res.size()>0){
				currentChannel = res.get(0);
			}
		} 
		result.add(currentChannel);
		List<Channel> temp = new ArrayList<Channel>();
		for (int i = result.size()-1; i >=0; i--) {
			temp.add(result.get(i));
		}
		result = temp;
		return result;
	}

	private Channel searchChannel(List<Channel> list,Channel currentChannel,List<Channel> result){
		Channel chan = null;
		for (Channel channel : list) {
			if(channel.getId().equals(currentChannel.getParentId())){
				result.add(chan = channel);
				break;
			}
			if(channel.getChildren()!=null && channel.getChildren().size()>0){
				chan = searchChannel(channel.getChildren(), currentChannel,result);
			}
		}
		return null;
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
