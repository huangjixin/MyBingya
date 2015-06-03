<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Cache-Control" content="no-cache, no-store, max-age=0" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<title>数据库设置</title>
<style type="text/css">
#container {
	margin: 0 auto; /*设置整个容器在浏览器中水平居中*/
	padding: 20px;
}

#header {
	margin: 0 auto; /*设置整个容器在浏览器中水平居中*/
	text-align: center;
}

#content {
	width: 100%;
	text-align: center;
	/* 	border: 1px solid #0000ff; */
}

#footer {
	margin-top: 20px;
	width: 100%;
	text-align: center;
}
</style>
</head>
<body>
	<div id="container">
		<div id="header">
			<h1>数据库设置</h1>
		</div>
		<div id="content">
			<div id="form" style="margin-top: 20px;text-align: center;">
				<form:form action="${ctx}/setup/finish" method="post"
					commandName="dbsetting">
					<table border="0" cellpadding="3" cellspacing="1" width="500px"
						align="center" style="background-color: #b9d8f3;">
						<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
							<th>数据库名：</th>
							<td nowrap="nowrap" align="left"><input id="dbname"
								name="dbname" value="jcincms"/>&nbsp;</td>
						</tr>
						<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
							<th>地址：</th>
							<td nowrap="nowrap" align="left"><input id="host"
								name="host" value="localhost" />&nbsp;本地为localhost</td>
						</tr>
						<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
							<th>端口：</th>
							<td nowrap="nowrap" align="left"><input id="port"
								name="port" value="3306" />&nbsp;</td>
						</tr>
						<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
							<th>&nbsp;用户名：</th>
							<td nowrap="nowrap" align="left"><input id="username"
								name="username" value="root" />&nbsp;</td>
						</tr>
						<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
							<th>&nbsp;密码：</th>
							<td nowrap="nowrap" align="left"><input id="password"
								name="password" type="password"  value="qwer123456"/>&nbsp;</td>
						</tr>
						<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
							<th style="width: 150px;">&nbsp;</th>
							<td style="text-align: left;" colspan="6">&nbsp;&nbsp;<input
								type="button" value="上一步"
								onclick="javascript:window.location.href='${ctx}/'" /> <input
								id="hostSetting_btn" type="submit" value="下一步"
								onclick="javascript:window.location.href='${ctx}/setup/finish'"
								disabled="disabled" /> <input type="button" value="测试"
								onclick="javascript:testSetting()" />
								<p id="info"></p>
								</td>
						</tr>
					</table>
				</form:form>
			</div>
		</div>
		<div id="footer">
			&copy;2010 - 2015 <a href="http://www.baidu.com/">JCinCMS</a>
		</div>
	</div>
	<script type="text/javascript">
		function testSetting() {
			var dbname = document.getElementById('dbname').value;
			var host = document.getElementById('host').value;
			var port = document.getElementById('port').value;
			var username = document.getElementById('username').value;
			var password = document.getElementById('password').value;
			var object = {};
			object.dbname = dbname;
			object.host = host;
			object.port = port;
			object.username = username;
			object.password = password;
			var base ='<%=basePath%>';
			var url = base + "setup/testSetting?dbname=" + dbname + "&host="
					+ host + "&port=" + port + "&username=" + username
					+ "&password=" + password;
			sendAjaxRequest(url, null);
		}

		var XMLHttpReq;
		function createXMLHttpRequest() {
			try {
				XMLHttpReq = new ActiveXObject("Msxml2.XMLHTTP");//IE高版本创建XMLHTTP  
			} catch (E) {
				try {
					XMLHttpReq = new ActiveXObject("Microsoft.XMLHTTP");//IE低版本创建XMLHTTP  
				} catch (E) {
					XMLHttpReq = new XMLHttpRequest();//兼容非IE浏览器，直接创建XMLHTTP对象  
				}
			}
		}

		function sendAjaxRequest(url, object) {
			createXMLHttpRequest(); //创建XMLHttpRequest对象  
			XMLHttpReq.open("post", url, true);
			XMLHttpReq.onreadystatechange = processResponse; //指定响应函数  
			XMLHttpReq.send(object);
		}

		//回调函数  
		function processResponse() {
			if (XMLHttpReq.readyState == 4) {
				if (XMLHttpReq.status == 200) {
					var text = XMLHttpReq.responseText;

					/** 
					 *实现回调 
					 */
					text = window.decodeURI(text);
					var p = document.getElementById('info');
					var hostSetting_btn = document.getElementById('hostSetting_btn');
					if(text == "success"){
						hostSetting_btn.disabled=false; //可编辑状态
						p.innerText = "连接正常";
						
					}else{
						hostSetting_btn.disabled=true; //可编辑状态
						p.innerText = text;
					}
				}
			}

		}
	</script>
</body>
</html>
