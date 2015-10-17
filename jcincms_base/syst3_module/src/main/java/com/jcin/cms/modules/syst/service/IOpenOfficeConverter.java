/**
 * 一句话描述该类：文档转换PDF<br/>
 * @author 黄记新
 * @date 2015-6-13,下午3:08:57
 *
 */
package com.jcin.cms.modules.syst.service;

import java.io.File;

public interface IOpenOfficeConverter {
	/**
	 * ppt转换PDF
	 * @param inputFile
	 * @param outputFile
	 */
	void ppt2PDF(File inputFile, File outputFile);
}
