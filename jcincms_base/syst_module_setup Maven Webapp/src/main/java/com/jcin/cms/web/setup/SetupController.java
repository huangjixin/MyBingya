/**
 * 一句话描述该类：安装向导控制器<br/>
 * @author 黄记新
 * @date 2015-6-2,上午10:25:58
 *
 */
package com.jcin.cms.web.setup;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.ibatis.jdbc.ScriptRunner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jcin.cms.web.domain.Hostsetting;

@Controller
@RequestMapping("/setup")
public class SetupController {

	/**
	 * 1.首页。
	 * 
	 * @return
	 */
	@RequestMapping(value = "/license")
	public String license() {
		return "index";
	}

	/**
	 * 2.数据库设置。
	 * 
	 * @return
	 */
	@RequestMapping(value = "/database")
	public String database() {
		return "database";
	}

	/**
	 * 3.结束。
	 * 
	 * @return
	 */
	@RequestMapping(value = "/finish")
	public String finish(@Valid Hostsetting hostsetting, BindingResult result,
			Model uiModel, HttpServletRequest httpServletRequest,
			HttpServletResponse response) {
		if (result.hasErrors()) {
			populateEditForm(uiModel, hostsetting);
			return "database";
		}

		URL url = SetupController.class.getClassLoader().getResource("");
		String filePath = url.getPath();
		filePath += "database" + File.separator + "db.sql";
		File file = new File(filePath);

		String dbdriver = "com.mysql.jdbc.Driver";
		String dburl = "jdbc:mysql://" + hostsetting.getHost() + ":"
				+ hostsetting.getPort() + "/" + hostsetting.getDbname();
		Connection con = null; // 表示数据库的连接对象
//		PrintWriter out = null;
		String object = "";
		try {
//			out = response.getWriter();
			Class.forName(dbdriver).newInstance();
			con = DriverManager.getConnection(dburl, hostsetting.getUsername(),
					hostsetting.getPassword()); // 2、连接数据库

			ScriptRunner runner = new ScriptRunner(con);
			InputStreamReader isr=new InputStreamReader(new FileInputStream(file),"UTF-8");
			runner.runScript(isr);

			if (con != null)
				object = "success";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (!object.equals("success"))
				object = "连接数据库失败，请检查url,端口，数据库是否存在，用户名和密码正确与否";
//			out.write(object);
//			out.flush();
//			out.close();
		}
		return "redirect:/setup/success";
	}

	@RequestMapping(value = "/success")
	public String success(HttpServletRequest httpServletRequest,
			HttpServletResponse response) {
		return "success";
	}
	/**
	 * 測試。
	 * 
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = "/testSetting")
	public void testSetting(@Valid Hostsetting hostsetting,
			BindingResult result, Model uiModel,
			HttpServletRequest httpServletRequest, HttpServletResponse response)
			throws UnsupportedEncodingException {
		// 处理中文问题
		httpServletRequest.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = null;
		String object = "";

		String dbdriver = "com.mysql.jdbc.Driver";
		String dburl = "jdbc:mysql://" + hostsetting.getHost() + ":"
				+ hostsetting.getPort() + "/" + hostsetting.getDbname();
		Connection con = null; // 表示数据库的连接对象
		try {
			out = response.getWriter();
			Class.forName(dbdriver).newInstance();
			con = DriverManager.getConnection(dburl, hostsetting.getUsername(),
					hostsetting.getPassword()); // 2、连接数据库
			if (con != null)
				object = "success";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (!object.equals("success"))
				object = "连接数据库失败，请检查url,端口，数据库是否存在，用户名和密码正确与否";
			out.write(object);
			out.flush();
			out.close();
		}
	}

	void populateEditForm(Model uiModel, Hostsetting hostsetting) {
		uiModel.addAttribute("hostsetting", hostsetting);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
