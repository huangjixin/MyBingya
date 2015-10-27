/**
 * 一句话描述该类：<br/>
 * @author 黄记新
 * @date 2015-10-21,下午4:00:41
 *
 */
package com.jcin.cms.modules.front.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jcin.cms.common.UserUtils;
import com.jcin.cms.modules.channel.domain.Channel;

/**
 * @author 黄记新
 * 
 */
@Controller
@RequestMapping(value = "/")
public class DefaultIndexController {

	@RequestMapping
	public String index(Model uiModel, HttpServletRequest httpServletRequest) {
		// List<Channel> list = channelService.getChannelTree();
		List<Channel> list = UserUtils.getChannels();
		uiModel.addAttribute("list", list);
		return "default/index";
	}

}
