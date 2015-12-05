/**
 * 一句话描述该类：前端HTML页面生成器。
 * @author 黄记新 <br/>
 * @date 2015-12-3,16:39 <br/>
 *
 */
package com.jcin.cms.modules.channel.web;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jcin.cms.common.FreeMarkerUtil;
import com.jcin.cms.common.UserUtils;
import com.jcin.cms.modules.channel.domain.Channel;
import com.jcin.cms.modules.channel.domain.Document;
import com.jcin.cms.modules.channel.service.IDocumentService;
import com.jcin.cms.utils.Page;
import com.jcin.cms.web.BaseController;

@Controller
@RequestMapping(value = "admin/htmlgenerate")
public class HtmlGeneraterController extends BaseController {

	@Autowired
	private IDocumentService documentService;
	
	@RequiresPermissions("htmlgenerate:view")
	@RequestMapping(value = { "", "htmlgenerate" })
	public String htmlgenerate(HttpServletRequest httpServletRequest) {
		return root + "admin/modules/htmlgenerate/htmlgenerate.jsp";
	}

	@RequestMapping(value = "/generateAll")
	@ResponseBody
	public String generateAll(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {

		return "生成所有成功";
	}

	@RequestMapping(value = "/generateIndex")
	@ResponseBody
	public String generateIndex(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		@SuppressWarnings("deprecation")
		String webroot = httpServletRequest.getRealPath("/");
		String conPath = httpServletRequest.getContextPath();
		Map<String,Object> root=new HashMap<String, Object>();
		Page page = new Page();
		page.setPageSize(8);
		List<Document> recommendDocs = documentService.getRecommendDoc(page);
		
		// 菜单
		List<Channel> menus = UserUtils.getChannels();
		
		page.setPageSize(10);
		
		Map<String,Object> menusMap=new HashMap<String, Object>();
		for (Channel channel : menus) {
			List<Document> documents = documentService.getDocByChannelCode(channel.getCode(), page);
			menusMap.put(channel.getCode(), documents);
			root.put(channel.getCode(), menusMap);
		}
		
		root.put("menusMap", menusMap);
		root.put("path", webroot);
		root.put("ctx", conPath);
		root.put("menus", menus);
		root.put("recommendDocs", recommendDocs);//推荐文章。
		
		String templatesPath=webroot;
		String templateFile= "template"+File.separator+"index.ftl";
		String htmlFile=webroot+"index.html";
		
		FreeMarkerUtil.analysisTemplate(templatesPath, templateFile, htmlFile, root);
		return "生成首页成功";
	}

	@RequestMapping(value = "/deleteIndex")
	@ResponseBody
	public String deleteIndex(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		@SuppressWarnings("deprecation")
		String webroot = httpServletRequest.getRealPath("/") + "index.html";
		File file = new File(webroot);
		if (file.exists()) {
			file.delete();
		}
		return "删除首页成功";
	}

	@RequestMapping(value = "/generateChannel")
	@ResponseBody
	public String generateChannel(@RequestParam(value = "id") String id,
			@RequestParam(value = "generateSubchannel",required=false) boolean generateSubchannel,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		
		return "";
	}

	@RequestMapping(value = "/generateDocs")
	@ResponseBody
	public String generateDocs(
			@RequestParam(value = "idstring") String idstring,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {

		return "";
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
