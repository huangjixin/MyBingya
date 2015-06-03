/**
 * 一句话描述该类：前端控制器，提供页面跳转，访问方法返回JSON<br/>
 * @author 黄记新 <br/>
 * @date 2015-4-29,10:52 <br/>
 *
 */
package com.jcin.cms.web.system;

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
import javax.validation.Valid;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

import com.jcin.cms.domain.system.User;
import com.jcin.cms.domain.system.UserCriteria;
import com.jcin.cms.service.system.IUserService;
import com.jcin.cms.utils.Page;
import com.jcin.cms.utils.ExcelUtil;
import com.jcin.cms.web.BaseController;

@Controller
@RequestMapping(value = "/user")
public class UserController extends BaseController<User>{
	@Resource
	private IUserService userService;

	@RequestMapping(value="createForm",method = RequestMethod.POST)
	public String create(@Valid User user,BindingResult result,Model uiModel,
			HttpServletRequest httpServletRequest) {
		if (result.hasErrors()) {
            populateEditForm(uiModel, user);
            return "view/user/user_create";
        }
			userService.insert(user);
		populateEditForm(uiModel, user);
		return "redirect:/user/new";
		//return "redirect:/user/"
		//		+ encodeUrlPathSegment(user.getId().toString(),
		//				httpServletRequest);
	}

	@RequestMapping(value="new", produces = "text/html")
	public String createForm(Model uiModel) {
		populateEditForm(uiModel, new User());
		return "view/user/user_create";
	}

	@RequestMapping(value = "/{id}", produces = "text/html")
	public String show(@PathVariable("id") String id, Model uiModel) {
		User user = userService.selectByPrimaryKey(id);
		uiModel.addAttribute("user", user);
		uiModel.addAttribute("itemId", id);
		return "view/user/user_show";
	}

	@RequestMapping(produces = "text/html")
	public String list(HttpServletRequest httpServletRequest) {
		return "view/user/user_list";
	}

	@RequestMapping(value="updateForm")
	public String update(@Valid User user,BindingResult result, Model uiModel,
			HttpServletRequest httpServletRequest) {
		uiModel.asMap().clear();
		userService.update(user);
		populateEditForm(uiModel, user);
		return "redirect:edit/"
				+ encodeUrlPathSegment(user.getId().toString(),
						httpServletRequest);
	}

	@RequestMapping(value = "/edit/{id}")
	public String updateForm(@PathVariable("id") String id, Model uiModel) {
		User user = userService.selectByPrimaryKey(id);
		populateEditForm(uiModel, user);
		return "view/user/user_update";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
	public String delete(@PathVariable("id") String id, Model uiModel) {
		userService.deleteByPrimaryKey(id);
		uiModel.asMap().clear();
		return "redirect:/user";
	}

	void populateEditForm(Model uiModel, User user) {
		uiModel.addAttribute("user", user);
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

	// _/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
	// _/_/_/_/_/_/ 下面将产生JSON格式的返回值
	// _/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
	@RequestMapping(value = "/select")
	@ResponseBody
	public Page select(@ModelAttribute Page page, @ModelAttribute User user,Model uiModel,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		super.select(page, uiModel, httpServletRequest,
				httpServletResponse);
		UserCriteria userCriteria = new UserCriteria();
		UserCriteria.Criteria criteria = userCriteria.createCriteria();
		userCriteria.setPage(page);
		userCriteria.setOrderByClause("id desc");
		if (null != user.getId()  && !"".equals(user.getId())) {
		  	criteria.andIdLike("%" + user.getId() + "%");
		}
		if (null != user.getUsername()  && !"".equals(user.getUsername())) {
		  	criteria.andUsernameLike("%" + user.getUsername() + "%");
		}
		if (null != user.getPassword()  && !"".equals(user.getPassword())) {
		  	criteria.andPasswordLike("%" + user.getPassword() + "%");
		}
		if (null != user.getDescription()  && !"".equals(user.getDescription())) {
		  	criteria.andDescriptionLike("%" + user.getDescription() + "%");
		}
		if (null != user.getIp()  && !"".equals(user.getIp())) {
		  	criteria.andIpLike("%" + user.getIp() + "%");
		}
		if (null != user.getTelephone()  && !"".equals(user.getTelephone())) {
		  	criteria.andTelephoneLike("%" + user.getTelephone() + "%");
		}
		if (null != user.getSalt()  && !"".equals(user.getSalt())) {
		  	criteria.andSaltLike("%" + user.getSalt() + "%");
		}
		if (null != user.getEmail()  && !"".equals(user.getEmail())) {
		  	criteria.andEmailLike("%" + user.getEmail() + "%");
		}
		if (null != user.getAddress()  && !"".equals(user.getAddress())) {
		  	criteria.andAddressLike("%" + user.getAddress() + "%");
		}
		page = userService.select(userCriteria);
		return page;
	}
	
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
		int result = userService.deleteBatch(list);

		return result;
	}
	
	@RequestMapping(value = "/create")
	@ResponseBody
	public String create(@ModelAttribute User user,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		userService.insert(user);
		String id = user.getId();
		return id;
	}
	
	@RequestMapping(value = "/update")
	@ResponseBody
	public String update(@ModelAttribute User user,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		userService.update(user);
		String id = user.getId();
		return id;
	}
	
	/**
	 * 全部导出Excel.
	 * @param user
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @throws IOException
	 */
	@RequestMapping(value = "/exportExcel")
	public void exportExcel(@ModelAttribute User user,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		httpServletResponse.setCharacterEncoding("UTF-8");
		String filename = new String("用户信息".getBytes("GBK"), "iso8859-1");

		List<User>list = userService.selectAll();

		List<Map<String, Object>> maps = createExcelRecord(list);

		String columnNames[] = { 
			"Id",
			"Username",
			"Password",
			"Status",
			"Description",
			"Enabled",
			"CreateDate",
			"UpdateDate",
			"Ip",
			"Telephone",
			"Salt",
			"Locked",
			"Email",
			"Sex",
			"Address"
		};// 列名
		String keys[] = { 
			"Id",
			"Username",
			"Password",
			"Status",
			"Description",
			"Enabled",
			"CreateDate",
			"UpdateDate",
			"Ip",
			"Telephone",
			"Salt",
			"Locked",
			"Email",
			"Sex",
			"Address"
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

	private List<Map<String, Object>> createExcelRecord(List<User> list) {
		List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sheetName", "sheet1");
		listmap.add(map);
		User user = null;
		for (int j = 0; j < list.size(); j++) {
			user = list.get(j);
			Map<String, Object> mapValue = new HashMap<String, Object>();
				mapValue.put("Id",user.getId());
				mapValue.put("Username",user.getUsername());
				mapValue.put("Password",user.getPassword());
				mapValue.put("Status",user.getStatus());
				mapValue.put("Description",user.getDescription());
				mapValue.put("Enabled",user.getEnabled());
				mapValue.put("CreateDate",user.getCreateDate());
				mapValue.put("UpdateDate",user.getUpdateDate());
				mapValue.put("Ip",user.getIp());
				mapValue.put("Telephone",user.getTelephone());
				mapValue.put("Salt",user.getSalt());
				mapValue.put("Locked",user.getLocked());
				mapValue.put("Email",user.getEmail());
				mapValue.put("Sex",user.getSex());
				mapValue.put("Address",user.getAddress());
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
