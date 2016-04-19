package com.jcin.cms.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import org.apache.log4j.Logger;

/**
 * 数据库工具类
 * 
 * @author Administrator
 * 
 */
public class MysqlUtil {
	private static Logger logger = Logger.getLogger(MysqlUtil.class);

	/**
	 * 备份数据库
	 */
	public static String backup(String name) {
		String mysqlPath = PropertiesUtil.readProperty("database.mysqlpath");
//		String filePath = System.getProperty("zwtech.root");
		String filePath = PropertiesUtil.readProperty("database.export");
		File f = new File(filePath);
		if(!f.exists()){
			FileUtils.createDirectory(filePath);
		}
		filePath = f.getParent();
		filePath += File.separator + name;
		try {
			Runtime rt = Runtime.getRuntime();

			// 调用 调用mysql的安装目录的命令
			Process child = rt.exec(mysqlPath + File.separator
					+ "mysqldump -h "
					+ PropertiesUtil.readProperty("database.host") + " -u"
					+ PropertiesUtil.readProperty("database.username") + " -p"
					+ PropertiesUtil.readProperty("database.password") + "  "
					+ PropertiesUtil.readProperty("database.dbname"));
			// 设置导出编码为utf-8。这里必须是utf-8
			// 把进程执行中的控制台输出信息写入.sql文件，即生成了备份文件。注：如果不对控制台信息进行读出，则会导致进程堵塞无法运行
			InputStream in = child.getInputStream();// 控制台的输出信息作为输入流

			InputStreamReader xx = new InputStreamReader(in, "utf-8");
			// 设置输出流编码为utf-8。这里必须是utf-8，否则从流中读入的是乱码

			String inStr;
			StringBuffer sb = new StringBuffer("");
			String outStr;
			// 组合控制台输出信息字符串
			BufferedReader br = new BufferedReader(xx);
			while ((inStr = br.readLine()) != null) {
				sb.append(inStr + "\r\n");
			}
			outStr = sb.toString();

			// 要用来做导入用的sql目标文件：
			FileOutputStream fout = new FileOutputStream(filePath);
			OutputStreamWriter writer = new OutputStreamWriter(fout, "utf-8");
			writer.write(outStr);
			writer.flush();
			in.close();
			xx.close();
			br.close();
			writer.close();
			fout.close();

			logger.info("数据库备份成功");
			logger.info("success");

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("数据库备份出错：" + e.getMessage());
		}

		return filePath;
	}

	/**
	 * 
	 */
	public static void load(String name) {
		try {
			String mysqlPath = PropertiesUtil
					.readProperty("database.mysqlpath");
			String fPath = PropertiesUtil.readProperty("database.export")
					+ File.separator + name;
			Runtime rt = Runtime.getRuntime();

			// 调用 mysql 安装目录的命令
			Process child = rt.exec(mysqlPath + File.separator + "mysql.exe -u"
					+ PropertiesUtil.readProperty("database.username") + " -p"
					+ PropertiesUtil.readProperty("database.password") + " "
					+ PropertiesUtil.readProperty("database.dbname"));

			OutputStream out = child.getOutputStream();// 控制台的输入信息作为输出流
			String inStr;
			StringBuffer sb = new StringBuffer("");
			String outStr;
			BufferedReader br = new BufferedReader(new InputStreamReader(
					new FileInputStream(fPath), "utf-8"));
			while ((inStr = br.readLine()) != null) {
				sb.append(inStr + "\r\n");
			}
			outStr = sb.toString();
			System.out.println(outStr);
			OutputStreamWriter writer = new OutputStreamWriter(out, "utf-8");
			writer.write(outStr);
			writer.flush();
			out.close();
			br.close();
			writer.close();

			logger.info("数据库还原成功");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("数据库还原出错：" + e.getMessage());
		}

	}

	public static void main(String[] args) {
		MysqlUtil.load("test1.sql");
	}
}