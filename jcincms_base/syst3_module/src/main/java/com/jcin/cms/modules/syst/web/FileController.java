/**
 * 一句话描述该类：前端控制器，提供页面跳转，访问方法返回JSON<br/>
 * @author 黄记新 <br/>
 * @date 2015-4-29,10:52 <br/>
 *
 */
package com.jcin.cms.modules.syst.web;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.jcin.cms.common.FileUtils;
import com.jcin.cms.common.UserUtils;
import com.jcin.cms.modules.syst.domain.DbBackup;
import com.jcin.cms.modules.syst.service.IDbBackupService;
import com.jcin.cms.web.BaseController;

@Controller
@RequestMapping(value = "admin/file")
public class FileController extends BaseController<DbBackup>{
	@Resource
	private IDbBackupService dbBackupService;

	@RequiresPermissions("file:view")
	@RequestMapping(value = { "", "list" })
	public String list(HttpServletRequest httpServletRequest) {
		return root+"admin/modules/file/file_list.jsp";
	}
	
	@RequestMapping(value = "/uploadFile")
	@ResponseBody
	public Map<String, Object> uploadFile(
			@RequestParam(value = "file", required = false) MultipartFile file,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		String uploadWeb = "";
		// 组合零时图片名
		String imageName = file.getOriginalFilename();
		String file_ext = imageName.substring(imageName.lastIndexOf(".") + 1);
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd_hhmmss");
		String imgeName = df.format(new Date());
		String tempImageName = imgeName + "." + file_ext;
		@SuppressWarnings("deprecation") 
		String uploadPath = httpServletRequest.getRealPath("/") + "upload" + File.separator + UserUtils.getUserId() + File.separator + tempImageName;
		 
		uploadWeb = "/upload/" + UserUtils.getUserId() + "/" + tempImageName;
		File targetFile = new File(uploadPath);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}

		if (file.getSize() > 0) {
			try {
				file.transferTo(targetFile);
			} catch (IllegalStateException e1) {

				e1.printStackTrace();
			} catch (IOException e1) {

				e1.printStackTrace();
			}
		}
		FileUtils.createFile(uploadPath);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("msg", "上传成功");
		map.put("fileName", tempImageName);
		map.put("fileAddr", uploadWeb);
		map.put("size", file.getSize());
		return map;
	}

}
