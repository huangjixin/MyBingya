/**
 * 
 */
package com.jcin.cms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jcin.cms.domain.OperationlogCriteria;
import com.jcin.cms.utils.Page;

/**
 * @author 黄记新
 *
 */
@Controller
@RequestMapping("/testController")
public class TestController {

	@RequestMapping(value = "/select")
	@ResponseBody
	public String select(
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		String result = "wo shi testcontroller";
		return result;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
