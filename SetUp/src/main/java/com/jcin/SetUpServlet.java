package com.jcin;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.jdbc.ScriptRunner;

public class SetUpServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public SetUpServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 处理中文问题
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String method = request.getParameter("method");
		if ("agreeSetup".equals(method)) {
			response.setContentType("text/html; charset=gb2312");
			// ServletContext sc = getServletContext();
			// RequestDispatcher rd = null;
			// rd = sc.getRequestDispatcher("/host-setting.jsp"); //�����ҳ��
			// rd.forward(request, response);
			response.sendRedirect(request.getContextPath()
					+ "/host-setting.jsp");
		} else if ("testDataBaseConnection".equals(method)) {
			testDataBaseConnection(request, response);
		} else if ("setup".equals(method)) {
			setup(request, response);
		} else if ("adminSetting".equals(method)) {
			adminSetting(request, response);
		}

		super.service(request, response);
	}

	/**
	 * jdbc数据库连接测试。
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void testDataBaseConnection(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String result = "fail";
		// 处理中文问题
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String host = request.getParameter("host");
		if (host == null || "".equals(host)) {
			host = "localhost";
		}

		String port = request.getParameter("port");
		if (port == null || "".equals(port)) {
			port = "3306";
		}

		String databasename = request.getParameter("databasename");
		if (databasename == null || "".equals(databasename)) {
			databasename = "test";
		}

		String user = request.getParameter("user");
		if (user == null || "".equals(user)) {
			user = "root";
		}

		String password = request.getParameter("password");
		if (password == null || "".equals(password)) {
			password = "qwer123456";
		}

		String dbdriver = "com.mysql.jdbc.Driver";
		String dburl = "jdbc:mysql://" + host + ":" + port + "/" + databasename;
		Connection con = null; // 表示数据库的连接对象

		PrintWriter out = response.getWriter();

		try {
			Class.forName(dbdriver).newInstance();
			con = DriverManager.getConnection(dburl, user, password); // 2、连接数据库
			System.out.println(con);
			result = "数据库连接正常";
		} catch (ClassNotFoundException e) {
			result = "Could not found Class";
			e.printStackTrace();
		} // 1、使用CLASS 类加载驱动程序
		catch (SQLException e) {
			result = "连接数据库失败，请检查url,端口，数据库是否存在，用户名和密码正确与否";
			e.printStackTrace();
		} catch (InstantiationException e) {
			result = "实例化失败";
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			result = "非法访问数据库";
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				result = "数据库异常";
				e.printStackTrace();
			}
			out.write(result);
			out.flush();
			out.close();
		}
	}

	/**
	 * 数据库创建。
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void setup(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String filePath = this.getServletConfig().getServletContext()
				.getRealPath("/");
		filePath += "database" + File.separator + "createDatabase.sql";
		File file = new File(filePath);
		System.out.println(filePath);

		String host = request.getParameter("host");
		if (host == null || "".equals(host)) {
			host = "localhost";
		}

		String port = request.getParameter("port");
		if (port == null || "".equals(port)) {
			port = "3306";
		}

		String databasename = request.getParameter("databasename");
		if (databasename == null || "".equals(databasename)) {
			databasename = "test";
		}

		String user = request.getParameter("user");
		if (user == null || "".equals(user)) {
			user = "root";
		}

		String password = request.getParameter("password");
		if (password == null || "".equals(password)) {
			password = "qwer123456";
		}

		String dbdriver = "com.mysql.jdbc.Driver";
		String dburl = "jdbc:mysql://" + host + ":" + port + "/" + databasename;
		Connection con = null; // 表示数据库的连接对象

		PrintWriter out = response.getWriter();

		String result = "fail";
		try {
			Class.forName(dbdriver).newInstance();
			con = DriverManager.getConnection(dburl, user, password); // 2、连接数据库
			ScriptRunner runner = new ScriptRunner(con);
			Reader reader = new FileReader(file);
			runner.runScript(reader);

			result = "安装成功";
		} catch (ClassNotFoundException e) {
			if (out == null) {
				out = response.getWriter();
			}
			result = "Could not found Class";
			e.printStackTrace();
		} // 1、使用CLASS 类加载驱动程序
		catch (SQLException e) {
			if (out == null) {
				out = response.getWriter();
			}
			result = "连接数据库失败，请检查url,端口，数据库是否存在，用户名和密码正确与否";
			e.printStackTrace();
		} catch (InstantiationException e) {
			if (out == null) {
				out = response.getWriter();
			}
			result = "实例化失败";
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			if (out == null) {
				out = response.getWriter();
			}
			result = "非法访问数据库";
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				result = "数据库异常";
				e.printStackTrace();
			}
		}
		
		if (out != null) {
			out.write("success");
			out.flush();
			out.close();
		}
//		response.sendRedirect(request.getContextPath()
//				+ "/license.jsp");
	}

	public void adminSetting(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String adminUsername = request.getParameter("adminUsername");
		if (adminUsername == null || "".equals(adminUsername)) {
			adminUsername = "admin";
		}

		String adminPassword = request.getParameter("adminPassword");
		if (adminPassword == null || "".equals(adminPassword)) {
			adminPassword = "3306";
		}

//		response.sendRedirect(request.getContextPath()
//				+ "/finish.jsp");
	}

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
