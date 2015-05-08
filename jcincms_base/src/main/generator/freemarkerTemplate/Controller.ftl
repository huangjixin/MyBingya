/**
 * 一句话描述该类：前端控制器，提供页面跳转，访问方法返回JSON<br/>
 * @author 黄记新 <br/>
 * @date 2015-4-29,10:52 <br/>
 *
 */
package ${packageName};

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

import com.jcin.cms.domain.${moduleName}.${domainObjectName};
import com.jcin.cms.domain.${moduleName}.${domainObjectName}Criteria;
import com.jcin.cms.service.${moduleName}.I${domainObjectName}Service;
import com.jcin.cms.utils.Page;
import com.jcin.cms.web.BaseController;

@Controller
@RequestMapping(value = "/${objInst}")
public class ${domainObjectName}Controller extends BaseController<${domainObjectName}>{
	@Resource
	private I${domainObjectName}Service ${objInst}Service;

	@RequestMapping(value="createForm",method = RequestMethod.POST)
	public String create(@ModelAttribute ${domainObjectName} ${objInst},
			HttpServletRequest httpServletRequest) {
			${objInst}Service.insert(${objInst});
		return "redirect:/${objInst}/new";
		//return "redirect:/${objInst}/"
		//		+ encodeUrlPathSegment(${objInst}.getId().toString(),
		//				httpServletRequest);
	}

	@RequestMapping(value="new", produces = "text/html")
	public String createForm(Model uiModel) {
		populateEditForm(uiModel, new ${domainObjectName}());
		return "view/${objInst}/${objInst}_create";
	}

	@RequestMapping(value = "/{id}", produces = "text/html")
	public String show(@PathVariable("id") String id, Model uiModel) {
		${domainObjectName} ${objInst} = ${objInst}Service.selectByPrimaryKey(id);
		uiModel.addAttribute("${objInst}", ${objInst});
		uiModel.addAttribute("itemId", id);
		return "view/${objInst}/${objInst}_show";
	}

	@RequestMapping(produces = "text/html")
	public String list(HttpServletRequest httpServletRequest) {
		return "view/${objInst}/${objInst}_list";
	}

	@RequestMapping(value="updateForm")
	public String update(@ModelAttribute ${domainObjectName} ${objInst}, Model uiModel,
			HttpServletRequest httpServletRequest) {
		uiModel.asMap().clear();
		${objInst}Service.update(${objInst});
		return "redirect:/${objInst}/"
				+ encodeUrlPathSegment(${objInst}.getId().toString(),
						httpServletRequest);
	}

	@RequestMapping(value = "/edit")
	public String updateForm(@PathVariable("id") String id, Model uiModel) {
		${domainObjectName} ${objInst} = ${objInst}Service.selectByPrimaryKey(id);
		populateEditForm(uiModel, ${objInst});
		return "${objInst}/${objInst}_update";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
	public String delete(@PathVariable("id") String id, Model uiModel) {
		${objInst}Service.deleteByPrimaryKey(id);
		uiModel.asMap().clear();
		return "redirect:/${objInst}";
	}

	void populateEditForm(Model uiModel, ${domainObjectName} ${objInst}) {
		uiModel.addAttribute("${objInst}", ${objInst});
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
	public Page select(@ModelAttribute Page page, @ModelAttribute ${domainObjectName} ${objInst},BindingResult bindingResult,Model uiModel,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		super.select(page, bindingResult, uiModel, httpServletRequest,
				httpServletResponse);
		${domainObjectName}Criteria ${objInst}Criteria = new ${domainObjectName}Criteria();
		${domainObjectName}Criteria.Criteria criteria = ${objInst}Criteria.createCriteria();
		${objInst}Criteria.setPage(page);
		${objInst}Criteria.setOrderByClause("id desc");
		<#list introspectedColumns as introspectedColumn>
		if (null != ${objInst}.get${introspectedColumn}()  && !"".equals(${objInst}.get${introspectedColumn}())) {
		  	criteria.and${introspectedColumn}Like("%" + ${objInst}.get${introspectedColumn}() + "%");
		}
		</#list>
		page = ${objInst}Service.select(${objInst}Criteria);
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
		int result = ${objInst}Service.deleteBatch(list);

		return result;
	}
	
	@RequestMapping(value = "/create")
	@ResponseBody
	public String create(@ModelAttribute ${domainObjectName} ${objInst},
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		${objInst}Service.insert(${objInst});
		String id = ${objInst}.getId();
		return id;
	}
	
	@RequestMapping(value = "/update")
	@ResponseBody
	public String update(@ModelAttribute ${domainObjectName} ${objInst},
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		${objInst}Service.update(${objInst});
		String id = ${objInst}.getId();
		return id;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
