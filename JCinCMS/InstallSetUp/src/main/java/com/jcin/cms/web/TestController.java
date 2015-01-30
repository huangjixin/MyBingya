/**
 * 
 */
package com.jcin.cms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 测试控制器。
 * 
 * @author 黄记新
 * 
 */
@Controller
@RequestMapping("/test")
public class TestController extends BaseController {
	@RequestMapping(value = "/select")
	public Model select(BindingResult bindingResult, Model uiModel,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		return uiModel;
	}
}
