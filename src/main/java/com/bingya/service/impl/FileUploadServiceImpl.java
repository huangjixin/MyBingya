/**
 * 
 */
package com.bingya.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.stereotype.Service;

import com.bingya.service.IFileUploadService;

/**
 * @author Administrator
 * 
 */
@Service
@RemotingDestination(value = "fileUploadServiceImpl", channels = { "my-amf" })
public class FileUploadServiceImpl implements IFileUploadService {
	private Boolean stopUpload = false;
	private String uploadPath = "";

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bingya.service.IFileUploadService#checkFile(java.lang.long)
	 */
	@Override
	public long checkFile(String fileName) {
		uploadPath = System.getProperty("web.root") + "upload" + File.separator;
		String filePath = uploadPath + fileName + ".temp";
		File file = new File(filePath);
		if (!file.exists()) {
			return 0;
		} else {
			return file.length();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bingya.service.IFileUploadService#writeFile(java.lang.String,
	 * byte[])
	 */
	@Override
	public String writeFile(String fileName, byte[] bytes) throws Exception {
		// 获取系统的上传路径；
		uploadPath = System.getProperty("web.root") + "upload";
		File upLoadFileDir = new File(uploadPath);
		if (!upLoadFileDir.exists()) { // 判断文件目录存在不，不在则创建。
			upLoadFileDir.mkdirs();
		}
		String filePath = uploadPath + File.separator + fileName + ".temp";
		File file = new File(filePath);
		FileOutputStream fos = new FileOutputStream(file);;
		if(!stopUpload){
			if (!file.exists()) {
					fos.write(bytes);
					fos.flush();
					fos.close();
			} else { // 追加文件。
				fos = new FileOutputStream(file);

				FileInputStream fis = new FileInputStream(file);
				byte fileContent[] = new byte[(int) file.length()];
				fis.read(fileContent);

				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				outputStream.write(fileContent);
				outputStream.write(bytes);

				byte c[] = outputStream.toByteArray();
				fos.write(c);
				fos.flush();
				fos.close();
			}
			
			//返回已经上传的文件长度。
			return ""+file.length();
		}else{
			fos.close();
			
			stopUpload = false;
			//返回已经上传的文件长度。
			return "上传中止";
		}
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bingya.service.IFileUploadService#copyFile(java.lang.String)
	 */
	@Override
	public Boolean copyFile(String fileName) {
		// 获取系统的上传路径；
		uploadPath = System.getProperty("web.root") + "upload";
		File upLoadFileDir = new File(uploadPath);
		if (!upLoadFileDir.exists()) { // 判断文件目录存在不，不在则创建。
			upLoadFileDir.mkdirs();
		}
		String filePath = uploadPath + File.separator + fileName + ".temp";
		
		File srcFile = new File(filePath);
		File destFile = new File(uploadPath + File.separator + fileName);
		
		try {
			if(!srcFile.exists()){
				return false;
			}
			FileUtils.copyFile(srcFile, destFile);
			if(srcFile.exists()){
				srcFile.delete(); 
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bingya.service.IFileUploadService#stopUpload(java.lang.Boolean)
	 */
	@Override
	public void stopUpload(Boolean stopUpload) {
		this.stopUpload = stopUpload;
	}

}
