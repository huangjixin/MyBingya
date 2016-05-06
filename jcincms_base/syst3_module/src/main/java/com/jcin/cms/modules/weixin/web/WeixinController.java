/**
 * 一句话描述该类：<br/>
 * @author 黄记新
 * @date 2015-10-21,下午4:00:41
 *
 */
package com.jcin.cms.modules.weixin.web;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.site.SitePreference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jcin.cms.common.UserUtils;
import com.jcin.cms.modules.channel.domain.Channel;
import com.jcin.cms.modules.channel.domain.Document;
import com.jcin.cms.modules.channel.service.DocCache;
import com.jcin.cms.modules.channel.service.IChannelService;
import com.jcin.cms.modules.channel.service.IDocumentService;
import com.jcin.cms.modules.urlhandler.domain.BasicConfig;
import com.jcin.cms.utils.Page;
import com.jcin.cms.web.BaseController;

/**
 * @author 黄记新
 * 
 */
@Controller
@RequestMapping(value = "/weixin")
// @Scope(value="prototype")
public class WeixinController extends BaseController {

	@RequestMapping(value = "getCode")
	public String getWeicinCode(Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws UnsupportedEncodingException{
		
		String url ="https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect";
		url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx1b2a56b664de808c&redirect_uri=http%3A%2F%2Fzwoinfo.gotoip1.com&response_type=code&scope=snsapi_base&state=123#wechat_redirect";
		url = url.replace("APPID",  "wx1b2a56b664de808c");
		url = url.replace("SCOPE", "snsapi_base");
		url = url.replace("STATE", "123");
		url = url.replace("REDIRECT_URI", URLEncoder.encode("http://zwoinfo.gotoip1.com/weixin", "utf-8"));
		return "redirect:"+url;
	}
	
	@RequestMapping(value = "getOpenId")
	public String getWeicinCode(@RequestParam(value="code",required=false) String code,Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		uiModel.addAttribute("code", code);
		return "/openId.jsp";
	}
}
