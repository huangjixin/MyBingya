/**
 * 一句话描述该类：Controller基础类<br/>
 * @author 黄记新
 * @date 2015-1-4,下午3:23:34
 *
 */
package com.jcin.cms.web;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jcin.cms.utils.Page;

@Controller
public class BaseController<T extends Serializable> {
	public String root = "WEB-INF/";

	public Page select(Page page, Model uiModel,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		// 当前页
		String startStr = httpServletRequest.getParameter("start");
		// 当前页
		String pageStr = httpServletRequest.getParameter("page");
		Integer intPage = null;
		if (null != pageStr) {
			intPage = Integer.parseInt(pageStr);
		} else if (null != startStr) {
			intPage = Integer.parseInt(startStr);
		} else {
			intPage = 0;
		}

		// 每页显示条数
		String limit = httpServletRequest.getParameter("limit");
		// 每页显示条数
		String rows = httpServletRequest.getParameter("rows");
		Integer number = null;
		if (null != rows) {
			number = Integer.parseInt(rows);
		} else if (null != limit) {
			number = Integer.parseInt(limit);
		} else {
			number = 10;
		}

		int start = 0;
		// 每页的开始记录 第一页为1 第二页为number +1
		if (page != null && rows != null) {
			start = (intPage - 1) * number;
		} else if (startStr != null) {
			start = Integer.parseInt(startStr);
		}

		page.setStart(start);
		page.setPageSize(number);

		return page;
	}

	public String create(@Valid T record, BindingResult bindingResult,
			Model uiModel, HttpServletRequest httpServletRequest) {
		@SuppressWarnings("rawtypes")
		Class clazz = record.getClass();
		try {
			@SuppressWarnings("unchecked")
			Method method = clazz.getDeclaredMethod("setId", String.class);
			method.invoke(record, new Date().getTime() + "");
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<T> selectAll(HttpServletRequest httpServletRequest) {
		return null;
	}

	public static Object getCache(String key) {
		return getCache(key, null);
	}

	public static Object getCache(String key, Object defaultValue) {
		Object obj = getCacheMap().get(key);
		return obj == null ? defaultValue : obj;
	}

	public static void putCache(String key, Object value) {
		getCacheMap().put(key, value);
	}

	public static void removeCache(String key) {
		getCacheMap().remove(key);
	}

	private static Map<String, Object> map;

	public static Map<String, Object> getCacheMap() {
		if (map == null) {
			map = new HashMap<String, Object>();
		}
		return map;
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, true));
	}
}
