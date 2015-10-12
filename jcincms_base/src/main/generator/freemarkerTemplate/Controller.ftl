/**
 * 一句话描述该类：前端控制器，提供页面跳转，访问方法返回JSON<br/>
 * @author 黄记新 <br/>
 * @date 2015-4-29,10:52 <br/>
 *
 */
package ${packageName};

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

import com.jcin.cms.common.Global;
import com.jcin.cms.modules.${moduleName}.domain.${domainObjectName};
import com.jcin.cms.modules.${moduleName}.domain.${domainObjectName}Criteria;
import com.jcin.cms.modules.${moduleName}.service.I${domainObjectName}Service;
import com.jcin.cms.utils.Page;
import com.jcin.cms.utils.ExcelUtil;
import com.jcin.cms.web.BaseController;

@Controller
@RequestMapping(value = "${r'${adminPath}'}/${objInst}")
public class ${domainObjectName}Controller extends BaseController<${domainObjectName}>{
	@Resource
	private I${domainObjectName}Service ${objInst}Service;

//	@RequiresPermissions("${objInst}:create")
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(${domainObjectName} ${objInst}, Model uiModel) {
		uiModel.addAttribute("${objInst}", ${objInst});
		return "admin/modules/${objInst}/${objInst}_create";
	}

//	@RequiresPermissions("${objInst}:create")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(${domainObjectName} ${objInst}, RedirectAttributes redirectAttributes,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		${objInst}Service.insert(${objInst});
		
		redirectAttributes.addFlashAttribute("${objInst}", ${objInst});
		redirectAttributes.addFlashAttribute("msg", "新增成功");
		return "redirect:/"+Global.getAdminPath()+"/${objInst}/create";
	}
	
//	@RequiresPermissions("${objInst}:update")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String update(@PathVariable("id") String id, Model uiModel) {
		${domainObjectName} ${objInst} = ${objInst}Service.selectByPrimaryKey(id);
		uiModel.addAttribute("${objInst}", ${objInst});
		return "admin/modules/${objInst}/${objInst}_update";
	}

//	@RequiresPermissions("${objInst}:update")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String update(${domainObjectName} ${objInst},RedirectAttributes redirectAttributes,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		${objInst}Service.update(${objInst});
		
		redirectAttributes.addFlashAttribute("msg", "修改成功");
		redirectAttributes.addFlashAttribute("${objInst}", ${objInst});
		return "redirect:/"+Global.getAdminPath()+"/${objInst}/update/"+${objInst}.getId();
	}

//	@RequiresPermissions("${objInst}:show")
	@RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
	public String show(@PathVariable("id") String id, Model uiModel) {
		${domainObjectName} ${objInst} = ${objInst}Service.selectByPrimaryKey(id);
		
		uiModel.addAttribute("${objInst}", ${objInst});
		return "admin/modules/${objInst}/${objInst}_show";
	}

//	@RequiresPermissions("${objInst}:view")
	@RequestMapping(value = { "", "list" })
	public String list(HttpServletRequest httpServletRequest) {
		return "admin/modules/${objInst}/${objInst}_list";
	}

//	@RequiresPermissions("${objInst}:delete")
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

//	@RequiresPermissions("${objInst}:view")
	@RequestMapping(value = "/select")
	@ResponseBody
	public Page select(@ModelAttribute Page page, @ModelAttribute ${domainObjectName} ${objInst},Model uiModel,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		super.select(page, uiModel, httpServletRequest,
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
	
//	@RequiresPermissions("${objInst}:delete")
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
	
	/**
	 * 全部导出Excel.
	 * @param ${objInst}
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @throws IOException
	 */
//	@RequiresPermissions("${objInst}:view")
	@RequestMapping(value = "/exportExcel")
	public void exportExcel(@ModelAttribute ${domainObjectName} ${objInst},
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		httpServletResponse.setCharacterEncoding("UTF-8");
		String filename = new String("用户信息".getBytes("GBK"), "iso8859-1");

		List<${domainObjectName}>list = ${objInst}Service.selectAll();

		List<Map<String, Object>> maps = createExcelRecord(list);

		String columnNames[] = { 
		<#assign iSum=0>
		<#list introspectedColumns as introspectedColumn>
			<#if (iSum+1< (introspectedColumns?size))>
			"${introspectedColumn}",
			</#if>
			<#if (iSum+1== (introspectedColumns?size))>
			"${introspectedColumn}"
			</#if>
			<#assign iSum=iSum+1>
		</#list>
		};// 列名
		String keys[] = { 
		<#assign iSum=0>
		<#list introspectedColumns as introspectedColumn>
			<#if (iSum+1< (introspectedColumns?size))>
			"${introspectedColumn}",
			</#if>
			<#if (iSum+1== (introspectedColumns?size))>
			"${introspectedColumn}"
			</#if>
			<#assign iSum=iSum+1>
		</#list>
		};// map中的key
		Workbook hwb = ExcelUtil.createWorkBook(maps, keys, columnNames);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");// 等价于now.toLocaleString()
		filename += "_" + sdf.format(new Date()) + ".xls";
		httpServletResponse.setContentType("APPLICATION/OCTET-STREAM");
		httpServletResponse.setHeader("Content-Disposition",
				"attachment; filename=\"" + filename + "\"");
		OutputStream os = httpServletResponse.getOutputStream();
		hwb.write(os);
		os.flush();
		os.close();
	}

	private List<Map<String, Object>> createExcelRecord(List<${domainObjectName}> list) {
		List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sheetName", "sheet1");
		listmap.add(map);
		${domainObjectName} ${objInst} = null;
		for (int j = 0; j < list.size(); j++) {
			${objInst} = list.get(j);
			Map<String, Object> mapValue = new HashMap<String, Object>();
			<#list introspectedColumns as introspectedColumn>
				mapValue.put("${introspectedColumn}",${objInst}.get${introspectedColumn}());
			</#list>
			listmap.add(mapValue);
		}
		return listmap;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
