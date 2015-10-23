/**
 * 一句话描述该类：前端控制器，提供页面跳转，访问方法返回JSON<br/>
 * @author 黄记新 <br/>
 * @date 2015-4-29,10:52 <br/>
 *
 */
package com.jcin.cms.modules.channel.web;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

import com.jcin.cms.common.Global;
import com.jcin.cms.modules.channel.domain.Channel;
import com.jcin.cms.modules.channel.domain.ChannelCriteria;
import com.jcin.cms.modules.channel.service.IChannelService;
import com.jcin.cms.utils.ExcelUtil;
import com.jcin.cms.utils.Page;
import com.jcin.cms.web.BaseController;

@Controller
@RequestMapping(value = "${adminPath}/channel")
public class ChannelController extends BaseController<Channel>{
	@Resource
	private IChannelService channelService;

//	@RequiresPermissions("channel:create")
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(Channel channel, Model uiModel) {
		uiModel.addAttribute("channel", channel);
		return "admin/modules/channel/channel_create";
	}

//	@RequiresPermissions("channel:create")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(Channel channel, RedirectAttributes redirectAttributes,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		channelService.insert(channel);
		
		redirectAttributes.addFlashAttribute("channel", channel);
		redirectAttributes.addFlashAttribute("msg", "新增成功");
		return "redirect:/"+Global.getAdminPath()+"/channel/create";
	}
	
//	@RequiresPermissions("channel:update")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String update(@PathVariable("id") String id, Model uiModel) {
		Channel channel = channelService.selectByPrimaryKey(id);
		uiModel.addAttribute("channel", channel);
		return "admin/modules/channel/channel_update";
	}

//	@RequiresPermissions("channel:update")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String update(Channel channel,RedirectAttributes redirectAttributes,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		if (channel.getId().equals(channel.getParentId())) {
			redirectAttributes.addFlashAttribute("channel", channel);
			redirectAttributes.addFlashAttribute("msg", "父亲节点不应该为本身");
			return "redirect:/" + Global.getAdminPath() + "/channel/update/"
					+ channel.getId();
		}
		channelService.update(channel);
		
		redirectAttributes.addFlashAttribute("msg", "修改成功");
		redirectAttributes.addFlashAttribute("channel", channel);
		return "redirect:/"+Global.getAdminPath()+"/channel/update/"+channel.getId();
	}

//	@RequiresPermissions("channel:show")
	@RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
	public String show(@PathVariable("id") String id, Model uiModel) {
		Channel channel = channelService.selectByPrimaryKey(id);
		
		uiModel.addAttribute("channel", channel);
		return "admin/modules/channel/channel_show";
	}

//	@RequiresPermissions("channel:view")
	@RequestMapping(value = { "", "list" })
	public String list(HttpServletRequest httpServletRequest) {
		return "admin/modules/channel/channel_list";
	}

//	@RequiresPermissions("channel:delete")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
	public String delete(@PathVariable("id") String id, Model uiModel) {
		channelService.deleteByPrimaryKey(id);
		uiModel.asMap().clear();
		return "redirect:/channel";
	}

	void populateEditForm(Model uiModel, Channel channel) {
		uiModel.addAttribute("channel", channel);
	}

	String encodeUrlPathSegment(String pathSegment,
			HttpServletRequest httpServletRequest) {
		String enc = httpServletRequest.getCharacterEncoding();
		if (enc == null) {
			enc = WebUtils.DEFAULT_CHARACTER_ENCODING;
		}
		try {
			pathSegment = UriUtils.encodePathSegment(pathSegment, enc);
		} catch (UnsupportedEncodingException uee) {
		}
		return pathSegment;
	}

//	@RequiresPermissions("channel:view")
	@RequestMapping(value = "/select")
	@ResponseBody
	public Page select(@ModelAttribute Page page, @ModelAttribute Channel channel,Model uiModel,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		super.select(page, uiModel, httpServletRequest,
				httpServletResponse);
		ChannelCriteria channelCriteria = new ChannelCriteria();
		ChannelCriteria.Criteria criteria = channelCriteria.createCriteria();
		channelCriteria.setPage(page);
		channelCriteria.setOrderByClause("id desc");
		if (null != channel.getId()  && !"".equals(channel.getId())) {
		  	criteria.andIdLike("%" + channel.getId() + "%");
		}
		if (null != channel.getName()  && !"".equals(channel.getName())) {
		  	criteria.andNameLike("%" + channel.getName() + "%");
		}
		if (null != channel.getCode()  && !"".equals(channel.getCode())) {
		  	criteria.andCodeLike("%" + channel.getCode() + "%");
		}
		if (null != channel.getKeyword()  && !"".equals(channel.getKeyword())) {
		  	criteria.andKeywordLike("%" + channel.getKeyword() + "%");
		}
		if (null != channel.getLinkAddr()  && !"".equals(channel.getLinkAddr())) {
		  	criteria.andLinkAddrLike("%" + channel.getLinkAddr() + "%");
		}
		if (null != channel.getOpenMode()  && !"".equals(channel.getOpenMode())) {
		  	criteria.andOpenModeLike("%" + channel.getOpenMode() + "%");
		}
		if (null != channel.getParentId()  && !"".equals(channel.getParentId())) {
		  	criteria.andParentIdLike("%" + channel.getParentId() + "%");
		}
		page = channelService.select(channelCriteria);
		return page;
	}
	
//	@RequiresPermissions("channel:delete")
	@RequestMapping(value = "/deleteById")
	@ResponseBody
	public int deleteById(@RequestParam(value = "idstring") String idstring,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {

		String[] ids = idstring.split(",");
		List<String> list = new ArrayList<String>();
		for (String idstr : ids) {
			list.add(idstr);
		}
		int result = channelService.deleteBatch(list);

		return result;
	}
	

	@RequestMapping(value = "/getChannelTree")
	@ResponseBody
	public List<Channel> getChannelTree(
			@RequestParam(value = "channelId", required = false) String channelId,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		List<Channel> list = channelService.getChannelTree(null);
		return list;
	}
	
	/**
	 * 全部导出Excel.
	 * @param channel
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @throws IOException
	 */
//	@RequiresPermissions("channel:view")
	@RequestMapping(value = "/exportExcel")
	public void exportExcel(@ModelAttribute Channel channel,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		httpServletResponse.setCharacterEncoding("UTF-8");
		String filename = new String("用户信息".getBytes("GBK"), "iso8859-1");

		List<Channel>list = channelService.selectAll();

		List<Map<String, Object>> maps = createExcelRecord(list);

		String columnNames[] = { 
			"Id",
			"Name",
			"Code",
			"Keyword",
			"LinkAddr",
			"OpenMode",
			"Desc",
			"ParentId"
		};// 列名
		String keys[] = { 
			"Id",
			"Name",
			"Code",
			"Keyword",
			"LinkAddr",
			"OpenMode",
			"Desc",
			"ParentId"
		};// map中的key
		Workbook hwb = ExcelUtil.createWorkBook(maps, keys, columnNames);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");// 等价于now.toLocaleString()
		filename += "_" + sdf.format(new Date()) + ".xls";
		httpServletResponse.setContentType("APPLICATION/OCTET-STREAM");
		httpServletResponse.setHeader("Content-Disposition",
				"attachment; filename=\"" + filename + "\"");
		OutputStream os = httpServletResponse.getOutputStream();
		hwb.write(os);
		os.flush();
		os.close();
	}

	private List<Map<String, Object>> createExcelRecord(List<Channel> list) {
		List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sheetName", "sheet1");
		listmap.add(map);
		Channel channel = null;
		for (int j = 0; j < list.size(); j++) {
			channel = list.get(j);
			Map<String, Object> mapValue = new HashMap<String, Object>();
				mapValue.put("Id",channel.getId());
				mapValue.put("Name",channel.getName());
				mapValue.put("Code",channel.getCode());
				mapValue.put("Keyword",channel.getKeyword());
				mapValue.put("LinkAddr",channel.getLinkAddr());
				mapValue.put("OpenMode",channel.getOpenMode());
				mapValue.put("Desc",channel.getDescrition());
				mapValue.put("ParentId",channel.getParentId());
			listmap.add(mapValue);
		}
		return listmap;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
