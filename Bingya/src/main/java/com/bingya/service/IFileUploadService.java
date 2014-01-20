/**
 * 
 */
package com.bingya.service;

import java.io.FileNotFoundException;

/**
 * @author Administrator
 *
 */
public interface IFileUploadService {
	long checkFile(String fileName);
	
	String writeFile(String FileName, byte[] filestrem) throws FileNotFoundException, Exception;
	
	Boolean copyFile(String FileName);
	
	void stopUpload(Boolean stopUpload);
}
