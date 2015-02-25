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

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jcin.cms.service.INotPayedService;
import com.jcin.cms.service.IPayedService;

/**
 * @author 黄记新
 * @date 2014-12-18,下午7:01:46
 * 
 */
@Controller
@RequestMapping("/totalCount")
public class TotalCountController extends BaseController {
	@Resource
	private IPayedService payedService;
	@Resource
	private INotPayedService notPayedService;

	@RequestMapping("/list")
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("view/totalCount/list");
		Map<String, Double> map = new HashMap<String, Double>();
		double totalPayed = payedService.getTotalGoodsMoney(null);
		double totalNotPayed = notPayedService.getTotalGoodsMoney(null);
		map.put("totalPayed", totalPayed);
		map.put("totalNotPayed", totalNotPayed);
		map.put("reduce", totalNotPayed - totalPayed);
		modelAndView.addAllObjects(map);
		return modelAndView;
	}
}
