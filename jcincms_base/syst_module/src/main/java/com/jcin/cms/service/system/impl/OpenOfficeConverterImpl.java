/**
 * 一句话描述该类：<br/>
 * @author 黄记新
 * @date 2015-6-13,下午3:31:28
 *
 */
package com.jcin.cms.service.system.impl;

import java.io.File;
import java.net.URI;
import java.net.URL;
import java.util.regex.Pattern;

import org.artofsolving.jodconverter.OfficeDocumentConverter;
import org.artofsolving.jodconverter.office.DefaultOfficeManagerConfiguration;
import org.artofsolving.jodconverter.office.OfficeManager;

import com.jcin.cms.service.system.IOpenOfficeConverter;
import com.jcin.cms.utils.PDF2SwfHelper;

public class OpenOfficeConverterImpl implements IOpenOfficeConverter {

	/**
	 * 将Office文档转换为PDF. 运行该函数需要用到OpenOffice, OpenOffice
	 * 
	 * @param sourceFile
	 *            源文件,绝对路径. 可以是Office2003-2007全部格式的文档, Office2010的没测试. 包括.doc,
	 *            .docx, .xls, .xlsx, .ppt, .pptx等.
	 * 
	 * @param destFile
	 *            目标文件.绝对路径.
	 */
	public static void word2pdf(String inputFilePath) {
		DefaultOfficeManagerConfiguration config = new DefaultOfficeManagerConfiguration();

		String officeHome = getOfficeHome();
		config.setOfficeHome(officeHome);

		OfficeManager officeManager = config.buildOfficeManager();
		officeManager.start();

		OfficeDocumentConverter converter = new OfficeDocumentConverter(
				officeManager);
		String outputFilePath = getOutputFilePath(inputFilePath);
		File inputFile = new File(inputFilePath);
		if (inputFile.exists()) {// 找不到源文件, 则返回
			File outputFile = new File(outputFilePath);
			if (!outputFile.getParentFile().exists()) { // 假如目标路径不存在, 则新建该路径
				outputFile.getParentFile().mkdirs();
			}
			converter.convert(inputFile, outputFile);
		}

		officeManager.stop();
	}

	public static String getOutputFilePath(String inputFilePath) {
		String outputFilePath = inputFilePath.replaceAll(".ppt", ".pdf");
		return outputFilePath;
	}

	public static String getOfficeHome() {
		String osName = System.getProperty("os.name");
		if (Pattern.matches("Linux.*", osName)) {
			return "/opt/openoffice.org3";
		} else if (Pattern.matches("Windows.*", osName)) {
			return "D:/Program Files (x86)/OpenOffice.org 3";
		} else if (Pattern.matches("Mac.*", osName)) {
			return "/Application/OpenOffice.org.app/Contents";
		}
		return null;
	}

	@Override
	public void ppt2PDF(File inputFile, File outputFile) {
		// TODO Auto-generated method stub

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		URL url = OpenOfficeConverterImpl.class.getClassLoader().getResource("test.pdf");
		String inputPath = url.getFile();
		/*OpenOfficeConverterImpl.word2pdf(inputPath);
		System.out.println();*/
		inputPath = inputPath.substring(1);
		PDF2SwfHelper.execPdfToSwf(inputPath);

	}

}
