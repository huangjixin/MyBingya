/**
 * 一句话描述该类：留言板<br/>
 * @author 黄记新
 * @date 2015-10-21,下午4:00:41
 *
 */
package com.jcin.cms.modules.urlhandler.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jcin.cms.common.UserUtils;
import com.jcin.cms.modules.channel.domain.Channel;
import com.jcin.cms.modules.syst.domain.Guestbook;
import com.jcin.cms.modules.syst.service.IGuestbookService;
import com.jcin.cms.web.BaseController;

/**
 * @author 黄记新
 * 
 */
@SuppressWarnings("rawtypes")
@Controller
@RequestMapping(value = { "guestbook"})
public class GuestBookFormController extends BaseController {
	private static Logger logger = LoggerFactory.getLogger(GuestBookFormController.class.getName());

	@Autowired
	private IGuestbookService guestbookService; // 注入基础配置。

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(Guestbook guestbook, Model uiModel) {
		List<Channel> list = UserUtils.getChannels(); // 利用缓存。
		uiModel.addAttribute("list", list);
		uiModel.addAttribute("guestbook", guestbook);
		return "/guestbook.jsp";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(Guestbook guestbook, RedirectAttributes redirectAttributes,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		guestbookService.insert(guestbook);
		
		redirectAttributes.addFlashAttribute("guestbook", guestbook);
		redirectAttributes.addFlashAttribute("msg", "新增成功");
		return "redirect:/guestbook/create";
	}
	
	@RequestMapping(value = "/m_create", method = RequestMethod.GET)
	public String m_create(Guestbook guestbook, Model uiModel) {
		List<Channel> list = UserUtils.getChannels(); // 利用缓存。
		uiModel.addAttribute("list", list);
		uiModel.addAttribute("guestbook", guestbook);
		return "/m-guestbook.jsp";
	}
	
	@RequestMapping(value = "/m_create", method = RequestMethod.POST)
	public String m_create(Guestbook guestbook, RedirectAttributes redirectAttributes,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		guestbookService.insert(guestbook);
		
		redirectAttributes.addFlashAttribute("guestbook", guestbook);
		redirectAttributes.addFlashAttribute("msg", "新增成功");
		return "redirect:/guestbook/m_create";
	}
}
