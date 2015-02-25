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
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jcin.cms.domain.Comment;
import com.jcin.cms.service.ICommentService;

/**
 * @author 黄记新
 * @date 2014-12-18,下午7:01:46
 * 
 */
@Controller
@RequestMapping("/comment")
public class CommentController extends BaseController{
	@Resource
	private ICommentService commentService;

	@RequestMapping("/list")
	public String list() {
		return "view/comment/list";
	}

	@RequestMapping(value = "/new")
	@ResponseBody
	public String create(@Valid Comment comment, BindingResult bindingResult,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		commentService.insert(comment);
		return null;
	}
	
	@RequestMapping(value = "/update")
	@ResponseBody
	public String update(@Valid Comment comment, BindingResult bindingResult,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		commentService.update(comment);
		return null;
	}

	@RequestMapping(value = "/deleteById")
	@ResponseBody
	public int deleteById(
			@RequestParam(value = "idstring", required = true) String idstring,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {

		String[] ids = idstring.split(",");
		int result = 0;
		for (String idStr : ids) {
			result = commentService.deleteByPrimaryKey(idStr);
		}

		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
