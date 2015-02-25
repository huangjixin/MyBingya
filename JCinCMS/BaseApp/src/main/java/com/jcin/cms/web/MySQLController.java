/**
 * 中兴软创<br/>
 * 一句话描述该类：<br/>
 * @author 黄记新
 * @date 2014-12-18,下午7:01:46
 *
 */
/**
 * 
 */
package com.jcin.cms.web;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jcin.cms.domain.Mysqlbackup;
import com.jcin.cms.domain.MysqlbackupCriteria;
import com.jcin.cms.service.IMySQLService;
import com.jcin.cms.utils.JavaMysql;
import com.jcin.cms.utils.Page;
import com.jcin.cms.web.vo.LoginResponse;

/**
 * @author 黄记新
 * @date 2014-12-18,下午7:01:46
 * 
 */
@Controller
@RequestMapping("/mysql")
public class MySQLController extends BaseController {

	@Resource
	private IMySQLService mysqlService;

	@RequestMapping("/list")
	public String list() {
		return "view/mysql/list";
	}

	/**
	 * MySql备份。
	 * 
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/backup")
	@ResponseBody
	public String backup(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {

		Properties pros = getPprVue("spring/db.properties");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				"yyyy-MM-dd_hh_mm_ss");
		String sql = simpleDateFormat.format(new Date()) + ".sql";
		// 这里是读取的属性文件，也可以直接使用

		String username = pros.getProperty("database.username");

		String password = pros.getProperty("database.password");

		// 得到MYSQL的用户名密码后调用 mysql 的 cmd:

		String mysqlpaths = pros.getProperty("database.mysqlpath");
		String databaseName = pros.getProperty("database.dbname");
		String address = pros.getProperty("database.host");
		// String sqlpath = pros.getProperty("database.export");

		String sqlpath = System.getProperty("jcincms.root") + "databaseBackup"
				+ File.separator;
		File backupath = new File(sqlpath);
		if (!backupath.exists()) {
			backupath.mkdir();
		}

		StringBuffer sb = new StringBuffer();

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
			cmd.exec(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}

		Mysqlbackup mysqlbackup = new Mysqlbackup();
		mysqlbackup.setCreatedate(new Date());
		mysqlbackup.setId(new Date().getTime() + "");
		mysqlbackup.setPath(sqlpath + File.separator + sql);
		mysqlbackup.setSqlname(sql);
		if (LoginResponse.user != null) {
			mysqlbackup.setOperator(LoginResponse.user.getUsername());
		}

		mysqlService.insert(mysqlbackup);

		return null;
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

	}

	/**
	 * MySql数据库还原。
	 * 
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @throws IOException
	 */
	@RequestMapping(value = "/restore")
	@ResponseBody
	public void restore(
			@RequestParam(value = "path", required = true) String path,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		Properties pros = getPprVue("spring/db.properties");

		// 这里是读取的属性文件，也可以直接使用

		String root = pros.getProperty("database.username");

		String pass = pros.getProperty("database.password");

		// 得到MYSQL的用户名密码后调用 mysql 的 cmd:

		String mysqlpaths = pros.getProperty("database.mysqlpath");
		String sqlpath = pros.getProperty("database.export");
		String filepath = path; // 备份的路径地址

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

	@RequestMapping(value = "/select")
	@ResponseBody
	public Page select(
			@Valid Page page,
			@RequestParam(value = "operator", required = false) String operator,
			BindingResult bindingResult, Model uiModel,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		super.select(page, bindingResult, uiModel, httpServletRequest,
				httpServletResponse);

		MysqlbackupCriteria mysqlCriteria = new MysqlbackupCriteria();
		MysqlbackupCriteria.Criteria criteria = mysqlCriteria.createCriteria();
		mysqlCriteria.setPage(page);
		mysqlCriteria.setOrderByClause("id desc");
		if (null != operator) {
			criteria.andOperatorLike("%" + operator + "%");
		}

		page = mysqlService.select(mysqlCriteria);
		return page;
	}

	@RequestMapping(value = "/deleteById")
	@ResponseBody
	public int deleteById(@RequestParam(value = "idstring") String idstring,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {

		String[] ids = idstring.split(",");
		int result = 0;
		for (String idStr : ids) {
			Mysqlbackup mysqlbackup = mysqlService.selectByPrimaryKey(idStr);
			if(mysqlbackup != null){
				File file = new File(mysqlbackup.getPath());
				if(file.exists()){
					file.delete();
				}
			}
			result = mysqlService.deleteByPrimaryKey(idStr);
		}

		return result;
	}

	@RequestMapping(value = "/update")
	@ResponseBody
	public String update(@Valid Mysqlbackup mysqlbackup,
			BindingResult bindingResult, Model uiModel,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		String result = mysqlService.update(mysqlbackup);
		return result;
	}
}
