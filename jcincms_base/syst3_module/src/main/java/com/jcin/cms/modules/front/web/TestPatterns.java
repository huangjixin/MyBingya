/**
 * 一句话描述该类：<br/>
 * @author 黄记新
 * @date 2015-10-27,上午11:44:01
 *
 */
package com.jcin.cms.modules.front.web;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.jcin.cms.common.HttpUtil;

public class TestPatterns {
	
	private static Set<String> set = new HashSet<String>();
	static int i=0;
	/**
	 * 功能：Java读取txt文件的内容 步骤：1：先获得文件句柄 2：获得文件句柄当做是输入一个字节码流，需要对这个输入流进行读取
	 * 3：读取到输入流后，需要读取生成字节流 4：一行一行的输出。readline()。 备注：需要考虑的是异常情况
	 * 
	 * @param filePath
	 */
	public static void readTxtFile(String filePath) {
		try {
			String encoding = "GBK";
			File file = new File(filePath);
			if (file.isFile() && file.exists()) { // 判断文件是否存在
				InputStreamReader read = new InputStreamReader(
						new FileInputStream(file), encoding);// 考虑到编码格式
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				while ((lineTxt = bufferedReader.readLine()) != null) {
					// System.out.println(lineTxt);
					set.add(lineTxt);
				}
				read.close();
			} else {
				System.out.println("找不到指定的文件");
			}
		} catch (Exception e) {
			System.out.println("读取文件内容出错");
			e.printStackTrace();
		}

	}

	private static Set<String>imgSet = new HashSet<String>();
	private static void getStrings(String str) {
		// str =
		// ".nav li a.hover{color:#005ca1;background-image:url(../images/cornel_bg.png);background-repeat:no-repeat;background-position";
		Pattern p = Pattern.compile("../images/(.*?).png");
		Matcher m = p.matcher(str);
		ArrayList<String> strs = new ArrayList<String>();
		while (m.find()) {
			imgSet.add(m.group(1));
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// getStrings(); // 用正则表达式获取指定字符串内容中的指定内容
		// D:\workspace\jcincms_base\syst3_module\src\main\webapp\default\css
		// System.out.println(TestPatterns.class.getResource("/"));
		readTxtFile("D:/newcapec.css");
		for (String string : set) {
			getStrings(string);
		}
		
		String findStr = "";
		String path = "";
		for (String s : imgSet) {
			findStr = "http://www.newcapec.com.cn/images/" + s + ".png";
			path = "D:/images/"+s+".png";
			if(!set.contains(findStr)){
				set.add(findStr);
			}
			try {
				HttpUtil.downloadFile(path, findStr);
			} catch (IOException e) {
				e.printStackTrace();
			}
			// System.out.println();
		}
		Iterator<String> iterator = set.iterator();
		
		while (iterator.hasNext()) {
			i+=1;
			if(i>=100){
				i=0;
				System.out.println("/////////////////////////////////////////////////////////////////////");
			}
			String type = (String) iterator.next();
			System.out.println(type);
		}
	}

}
