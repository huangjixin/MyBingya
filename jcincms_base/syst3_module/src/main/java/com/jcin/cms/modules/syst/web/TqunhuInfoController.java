/**
 * 一句话描述该类：用户管理前端控制器，提供页面跳转，访问方法返回JSON<br/>
 * @author 黄记新 <br/>
 * @date 2015-4-29,10:52 <br/>
 *
 */
package com.jcin.cms.modules.syst.web;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jcin.cms.modules.syst.domain.CreatedTb;
import com.jcin.cms.modules.syst.domain.TqunhuInfo;
import com.jcin.cms.modules.syst.service.ITqunhuInfoService;
import com.jcin.cms.web.BaseController;

@Controller
@RequestMapping(value = "/tqunhuInfo")
public class TqunhuInfoController extends BaseController<TqunhuInfo> {
	private static long maxSize  = 5*1024*1024;
	private static final long eTime  = Long.parseLong("1444268981917");
	@Autowired
	private ITqunhuInfoService tqunhuInfoService;

	@RequestMapping(value = { "", "create" }, method = RequestMethod.GET)
	public String list(Model uiModel,TqunhuInfo tqunhuInfo,HttpServletRequest httpServletRequest) {
		uiModel.addAttribute("tqunhuInfo", tqunhuInfo);
		return root+"admin/modules/tqunhuInfo/tqunhuInfo_create.jsp";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(@RequestParam(value = "file", required = false) MultipartFile file,TqunhuInfo tqunhuInfo,
			RedirectAttributes redirectAttributes, Model uiModel,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		long start = new Date().getTime();
		/*if(start > eTime){
			redirectAttributes.addFlashAttribute("tqunhuInfo", tqunhuInfo);
			redirectAttributes.addFlashAttribute("msg", "已过期，不可用");
			return "redirect:/tqunhuInfo/create";
		}*/
		if(file.getSize()==0){
			redirectAttributes.addFlashAttribute("tqunhuInfo", tqunhuInfo);
			redirectAttributes.addFlashAttribute("msg", "请上传文件");
			
			return "redirect:/tqunhuInfo/create";
		}
		if(file.getSize() > maxSize){
			redirectAttributes.addFlashAttribute("tqunhuInfo", tqunhuInfo);
			redirectAttributes.addFlashAttribute("msg", "文件体积最多为5M");
			
			return "tqunhuInfo/create";
		}
		
		long count = tqunhuInfoService.count(null);
		count+=1;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy_MM_dd HH时mm分ss秒");
		String tableName = "qunhu"+sdf.format(new Date())+"_"+count;
		if(file != null){
			tqunhuInfo.setFilename(file.getOriginalFilename());
		}
		
		tqunhuInfo.setIp(httpServletRequest.getRemoteAddr());
		tqunhuInfo.setTimes(sdf1.format(new Date()));
		tqunhuInfo.setTableName(tableName);
		tqunhuInfo.setLeixing(0);
		tqunhuInfoService.insert(tqunhuInfo);
		
		/*String uploadPath = Global.getUploadpath();
		uploadPath+= File.separator+file.getOriginalFilename();
		File targetFile = new File(uploadPath);  
        if(!targetFile.exists()){  
            targetFile.mkdirs();  
        }
        
        if(file.getSize()>0){
        	 try {
     			file.transferTo(targetFile);
     		} catch (IllegalStateException e1) {
     			// TODO Auto-generated catch block
     			e1.printStackTrace();
     		} catch (IOException e1) {
     			// TODO Auto-generated catch block
     			e1.printStackTrace();
     		}
        }*/
       
        
		tqunhuInfoService.createTableSql(tableName);
		
		try {
			/*File filename = new File(uploadPath); // 要读取以上路径的input。txt文件
			InputStreamReader reader = new InputStreamReader(
			new FileInputStream(filename)); */
			InputStreamReader reader = new InputStreamReader(file.getInputStream()); 
			
			BufferedReader bf= new BufferedReader(reader);
			String lineTxt = null;
			List<String> strings = new ArrayList<String>();
			while((lineTxt = bf.readLine()) != null){
				strings.add(lineTxt);
            }
			bf.close();
			
			int length = strings.size();
			CreatedTb createdTb = new CreatedTb();
			createdTb.setTable_name(tableName);
			
			Map<Integer, List> map = new HashMap<Integer, List>();
			int devide = length/10000;
			devide+=1;
			for (int i = 0; i < devide; i++) {
				List list = new ArrayList(10000);
				for (int j = i*10000; j < i*10000+10000; j++) {
					if(j<length){
						list.add(new CreatedTb(tableName,strings.get(j), new Timestamp(System.currentTimeMillis()), null, j));						
					}
				}
				map.put(i, list);
			}
			for (int i = 0; i < devide; i++) {
				List temp = map.get(i);
				createdTb.setList(temp);
				tqunhuInfoService.insertCreatedTb(createdTb);
			}
			
			/*List list = new ArrayList(length);
			for (int i = 0; i < length; i++) {
				list.add(new CreatedTb(tableName,strings.get(i), null, null, i));
//				tqunhuInfoService.insertCreatedTable(new CreatedTb(tableName,strings.get(i), null, null, i));
			}
			
			createdTb.setList(list);
			tqunhuInfoService.insertCreatedTb(createdTb);*/
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		long end = new Date().getTime();
		System.out.println((end-start)/1000+"秒");
		/**/
		redirectAttributes.addFlashAttribute("tqunhuInfo", tqunhuInfo);
		redirectAttributes.addFlashAttribute("msg", "上传成功");
		return root+"admin/modules/tqunhuInfo/tqunhuInfo_success.jsp";
	}
}