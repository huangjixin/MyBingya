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

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 黄记新
 * @date 2014-12-18,下午7:01:46
 * 
 */
@Controller
@RequestMapping("/mysql")
public class MySQLController {

	@RequestMapping("/list")
	public String list() {
		return "view/user/list";
	}

	/**
	 * MySql备份。
	 * 
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/backup")
	@ResponseBody
	public String backup(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		return null;
	}

	/**
	 * MySql数据库还原。
	 * 
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @throws IOException
	 */
	@RequestMapping(value = "/restore")
	@ResponseBody
	public void restore(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
	}
}
