/**
 * 中兴软创<br/>
 * 一句话描述该类：<br/>
 * @author 黄记新
 * @date 2014-12-18,下午7:01:46
 *
 */
/**
 * 
 */
package com.jcin.cms.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jcin.cms.domain.User;

/**
 * @author 黄记新
 * @date 2014-12-18,下午7:01:46
 * 
 */
@Controller
@RequestMapping("/user")
public class UserController {
	@RequestMapping("/list")
	public String list() {
		return "list";
	}

	@RequestMapping(value = "/create")
	@ResponseBody
	public String create(@Valid User user, BindingResult bindingResult,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
//		userService.insert(user);
		return null;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
