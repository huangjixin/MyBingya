/**
 * 一句话描述该类：前端登录控制器，提供页面跳转，访问方法返回JSON<br/>
 * @author 黄记新 <br/>
 * @date 2015-4-29,10:52 <br/>
 *
 */
package com.jcin.cms.modules.syst.web;

import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jcin.cms.modules.syst.domain.User;
import com.jcin.cms.web.BaseController;

@Controller
@RequestMapping(value = "admin")
public class LoginController extends BaseController<User> {

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login(Model uiModel, HttpServletRequest request) {

		return root+"admin/modules/login";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(@ModelAttribute User user, Model uiModel,
			HttpServletRequest request) {
		String exceptionClassName = (String) request
				.getAttribute("shiroLoginFailure");
		String error = null;
		if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
			error = "用户名/密码错误";
		} else if (IncorrectCredentialsException.class.getName().equals(
				exceptionClassName)) {
			error = "用户名/密码错误";
		} else if (exceptionClassName != null) {
			error = "其他错误：" + exceptionClassName;
		}
		uiModel.addAttribute("error", error);
		return root+"admin/modules/login";
	}

	@RequestMapping(value = {"","/"})
	public String index(Model uiModel) {
		return root+"admin/modules/index";
	}
	
	@RequestMapping(value = {"system"})
	public String system(Model uiModel,HttpServletRequest request) {
		Properties props=System.getProperties(); //获得系统属性集    
		String osName = props.getProperty("os.name"); //操作系统名称    
		String osArch = props.getProperty("os.arch"); //操作系统构架    
		String osVersion = props.getProperty("os.version"); //操作系统版本 
		String version = props.getProperty("java.version"); //    Java 运行时环境版本  
		String vendor = props.getProperty("java.vendor"); //    Java 运行时环境供应商  
		uiModel.addAttribute("osName", osName);
		uiModel.addAttribute("osArch", osArch);
		uiModel.addAttribute("osVersion", osVersion);
		uiModel.addAttribute("version", version);
		uiModel.addAttribute("vendor", vendor);
		return root+"admin/modules/system";
	}

}