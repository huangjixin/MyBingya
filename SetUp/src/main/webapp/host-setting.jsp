<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>数据库设置</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css"
	href="<%=basePath%>images/setup.css" />
<script type="text/javascript"
	src="<%=basePath%>js/common/jquery.min.js"></script>
<script type="text/javascript">
		$(function() {
			 $('#testJdbcConnectionBtn').click(function() {
				testConnection()   
       		});
       		
       		$('#previousButton').click(function() {
				previousButtonClickHandler();   
       		});
       		
       		$('#nextButton').click(function() {
				nextButtonClickHandler();   
       		});
		});
		
		//测试数据库是否连接得上。
		function testConnection(){
			$.ajax({
  				url: "servlet/SetUpServlet?method=testDataBaseConnection",
  				data:{//发送给数据库的数据
   					host:$("#host").val(),
   					port:$("#port").val(),
   					databasename:$("#databasename").val(),
   					user:$("#user").val(),
   					password:$("#password").val()
   				},
  				success:function(data,textStatus){
  					alert(data);
  				}
			});
		}
		
		//上一步。
		function previousButtonClickHandler(){
			window.location.href="license.jsp"; 
		}
		
		//下一步。
		function nextButtonClickHandler(){
			$.ajax({
  				url: "servlet/SetUpServlet?method=setup",
  				data:{//发送给数据库的数据
   					host:$("#host").val(),
   					port:$("#port").val(),
   					databasename:$("#databasename").val(),
   					user:$("#user").val(),
   					password:$("#password").val()
   				},
  				success:function(data,textStatus){
  					if(data == "success"){
  					window.location.href="admin-setting.jsp";
  					}
  					
  				}
			});
			
			$('#tip').html("正在安装……");
		}
	</script>
</head>

<body>
	<div class="container">
		<div class="header">
			<h1>安装向导</h1>
		</div>
		<div class="main" style="margin-top:-123px;">
			<form id="validForm" action="<%=basePath%>/" method="post">
				<input type="hidden" name="step" value="1">
				<div class="desc">
					<b>填写数据库信息</b>
				</div>
				<table class="tb2">
					<tr>
						<th class="tbopt">&nbsp;数据库服务器:</th>
						<td><input type="text" name="host" id="host"
							value="localhost" size="35" class="txt"></td>
						<td>&nbsp;一般为 localhost</td>
					</tr>

					<tr>
						<th class="tbopt">&nbsp;数据库端口:</th>
						<td><input type="text" name="port" value="3306" size="35"
							class="txt" id="port"></td>
						<td>&nbsp;默认端口请留空</td>
					</tr>

					<tr>
						<th class="tbopt">&nbsp;数据库名:</th>
						<td><input type="text" name="databasename" id="databasename"
							value="test" size="35" class="txt"></td>
						<td>&nbsp;</td>
					</tr>

					<tr>
						<th class="tbopt">&nbsp;数据库用户名:</th>
						<td><input type="text" name="user" value="root" size="35"
							class="txt" id="user" value="root"></td>
						<td>&nbsp;</td>
					</tr>

					<tr>
						<th class="tbopt">&nbsp;数据库密码:</th>
						<td><input type="password" name="password" value="root"
							size="35" class="txt" id="password"></td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<th class="tbopt"></th>
						<td><input type="button" value="测试连接"
							id="testJdbcConnectionBtn"></input>
						<p id="tip"></p></td>
						<td></td>
					</tr>
					<tr>
						<th class="tbopt">&nbsp;</th>
						<td><input type="hidden" name="version" value="${version}" />
							<input type="button" id="previousButton" onclick="<%=basePath%>"
							value="上一步" /> &nbsp; <input type="button" id="nextButton"
							name="submitname" value="下一步" class="btn"></td>
						<td>&nbsp;</td>
					</tr>
				</table>
			</form>
			<div class="footer">
				&copy;2010 - 2015 <a href="http://www.baidu.com/">JCincms</a>
			</div>
		</div>
	</div>
</body>
</html>
