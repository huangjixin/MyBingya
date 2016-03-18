/**
 * 一句话描述该类：前端登录控制器，提供页面跳转，访问方法返回JSON<br/>
 * @author 黄记新 <br/>
 * @date 2015-4-29,10:52 <br/>
 *
 */
package com.jcin.cms.modules.syst.web;

import java.util.List;
import java.util.Properties;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jcin.cms.common.PasswordHelper;
import com.jcin.cms.modules.syst.domain.Resource;
import com.jcin.cms.modules.syst.domain.User;
import com.jcin.cms.modules.syst.service.IResourceService;
import com.jcin.cms.modules.syst.service.IUserService;
import com.jcin.cms.web.BaseController;

@Controller
@RequestMapping(value = "admin")
public class LoginController extends BaseController<User> {

	@Autowired
	private CaptchaFormAuthenticationFilter formAuthenticationFilter;
	@Autowired
	private IResourceService resourceService;
	@Autowired
	private IUserService userService;

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login(Model uiModel, HttpServletRequest request) {
		uiModel.addAttribute("captchaEnabled",
				formAuthenticationFilter.isCaptchaEnabled());
		return root + "admin/modules/login.jsp";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(@ModelAttribute User user, Model uiModel,
			HttpServletRequest request) {
		/*
		 * Object exceptionClassName = (Object) request
		 * .getAttribute("shiroLoginFailure");
		 */
		String error = "用户名/密码错误";

		/*
		 * if
		 * (UnknownAccountException.class.getName().equals(exceptionClassName.
		 * getClass().getName())) { error = "没有该账号"; } else if
		 * (IncorrectCredentialsException.class.getName().equals(
		 * exceptionClassName.getClass().getName())) { error = "用户名/密码错误"; }
		 * else if (IncorrectCaptchaException.class.getName().equals(
		 * exceptionClassName.getClass().getName())) { error = "验证码错误"; } else
		 * if (exceptionClassName != null) { error = "其他错误：" +
		 * exceptionClassName; }
		 */
		uiModel.addAttribute("error", error);
		Subject currentUser = SecurityUtils.getSubject();

		String passw = PasswordHelper.encryptPassword(user.getPassword());
		UsernamePasswordToken token = new UsernamePasswordToken(
				user.getUsername(), passw);
		token.setRememberMe(false);
		try {
			currentUser.login(token);
		} catch (Exception uae) {
			return root + "admin/modules/login.jsp";
		}
		Object object = currentUser.getPrincipal();
		Set<String> set = null;
		if (object != null) {
			set = userService.findPermissions(object.toString());
		}
		List<Resource> list = resourceService.getResourceTree(set, true);
		uiModel.addAttribute("menu", list);
		return "/admin/index";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)  
    public String logout() {  
        Subject currentUser = SecurityUtils.getSubject();  
        currentUser.logout();  
        return "admin/login";  
    }  
  
    @RequestMapping(value = "/chklogin", method = RequestMethod.POST)  
    @ResponseBody  
    public String chkLogin() {  
        Subject currentUser = SecurityUtils.getSubject();  
        if (!currentUser.isAuthenticated()) {  
            return "false";  
        }  
        return "true";  
    }
    
	@RequestMapping(value = { "", "/", "index" })
	public String index(Model uiModel) {
		Subject currentUser = SecurityUtils.getSubject();
		Object object = currentUser.getPrincipal();
		Set<String> set = null;
		if (object != null) {
			set = userService.findPermissions(object.toString());
		}
		List<Resource> list = resourceService.getResourceTree(set, true);
		uiModel.addAttribute("menu", list);
		return root + "admin/modules/index.jsp";
	}

	@RequestMapping(value = { "system" })
	public String system(Model uiModel, HttpServletRequest request) {
		Properties props = System.getProperties(); // 获得系统属性集
		String osName = props.getProperty("os.name"); // 操作系统名称
		String osArch = props.getProperty("os.arch"); // 操作系统构架
		String osVersion = props.getProperty("os.version"); // 操作系统版本
		String version = props.getProperty("java.version"); // Java 运行时环境版本
		String vendor = props.getProperty("java.vendor"); // Java 运行时环境供应商
		uiModel.addAttribute("osName", osName);
		uiModel.addAttribute("osArch", osArch);
		uiModel.addAttribute("osVersion", osVersion);
		uiModel.addAttribute("version", version);
		uiModel.addAttribute("vendor", vendor);
		return root + "admin/modules/system.jsp";
	}

}