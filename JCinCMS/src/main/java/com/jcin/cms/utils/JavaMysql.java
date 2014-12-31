package com.jcin.cms.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.springframework.format.datetime.DateFormatter;

public class JavaMysql {

	/**
	 * 
	 * mysql数据备份 接收脚本名，并返回此路径
	 * 
	 * sql为备份的脚本名比如xxx.sql
	 * 
	 */

	public static void backup(String sql) {

		Properties pros = getPprVue("spring/db.properties");

		// 这里是读取的属性文件，也可以直接使用

		String username = pros.getProperty("database.username");

		String password = pros.getProperty("database.password");

		// 得到MYSQL的用户名密码后调用 mysql 的 cmd:

		String mysqlpaths = pros.getProperty("database.mysqlpath");
		String databaseName = pros.getProperty("database.dbname");
		String address = pros.getProperty("database.host");
		String sqlpath = pros.getProperty("database.export");
		File backupath = new File(sqlpath);
		if (!backupath.exists()) {
			backupath.mkdir();
		}

		StringBuffer sb = new StringBuffer();
		// 注意需要在windows环境变量里面加入mysql的bin路径；
		sb.append(mysqlpaths);
		sb.append("mysqldump ");
		sb.append("--opt ");
		sb.append("-h ");
		sb.append(address);
		sb.append(" ");
		sb.append("--user=");
		sb.append(username);
		sb.append(" ");
		sb.append("--password=");
		sb.append(password);
		sb.append(" ");
		sb.append("--lock-all-tables=true ");
		sb.append("--result-file=");
		sb.append(sqlpath);
		sb.append(sql);
		sb.append(" ");
		sb.append("--default-character-set=utf8 ");
		sb.append(databaseName);
		Runtime cmd = Runtime.getRuntime();
		try {
			String str = "C://Program Files//MySQL//MySQL Server 5.6//bin//mysqldump --opt -h localhost --user=root --password=qwer123456 --lock-all-tables=true --result-file=D://MySQl//2014_12_31_01_59_10.sql --default-character-set=utf8 jcincms";
			cmd.exec(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// 读取属性值

	public static Properties getPprVue(String properName) {

		InputStream inputStream = JavaMysql.class.getClassLoader()
				.getResourceAsStream(properName);

		Properties p = new Properties();

		try {
			p.load(inputStream);
			inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return p;

	}

	public static void load(String filename) {
		Properties pros = getPprVue("spring/db.properties");

		// 这里是读取的属性文件，也可以直接使用

		String root = pros.getProperty("database.username");

		String pass = pros.getProperty("database.password");

		// 得到MYSQL的用户名密码后调用 mysql 的 cmd:

		String mysqlpaths = "C:" + File.separator + "Program Files"
				+ File.separator + "MySQL" + File.separator
				+ "MySQL Server 5.6" + File.separator + "bin";
		// pros.getProperty("database.mysqlpath");
		String sqlpath = pros.getProperty("database.export");
		String filepath = sqlpath + filename; // 备份的路径地址

		// 新建数据库finacing
		String stmt1 = "mysqladmin -u " + root + " -p" + pass
				+ " create finacing";
		// -p后面加的是你的密码
		String stmt2 = "mysql -u " + root + " -p" + pass + " finacing < "
				+ filepath;
		String[] cmd = { "cmd", "/c", stmt2 };

		try {
			Runtime.getRuntime().exec(stmt1);
			Runtime.getRuntime().exec(cmd);
			System.out.println("数据已从 " + filepath + " 导入到数据库中");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) throws IOException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				"yyyy_MM_dd_hh_mm_ss");
		backup(simpleDateFormat.format(new Date()) + ".sql");

		// load("xx.sql");
	}
}