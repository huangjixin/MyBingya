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

<title>管理员设置</title>

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
       		$('#previousButton').click(function() {
				previousButtonClickHandler();   
       		});
       		
       		$('#nextButton').click(function() {
				nextButtonClickHandler();   
       		});
		});
		
		//上一步。
		function previousButtonClickHandler(){
			window.location.href="host-setting.jsp"; 
		}
		
		//下一步。
		function nextButtonClickHandler(){
			alert('ee');
			$.ajax({
  				url: "servlet/SetUpServlet?method=adminSetting",
  				data:{//发送给数据库的数据
   					adminUsername:$("#adminUsername").val(),
   					adminPassword:$("#adminPassword").val()
   				}
//    				,
//   				success:function(data,textStatus){
//   					alert(data);
//   				}
			});
		}
	</script>
</head>

<body>
	<div class="container">
		<div class="header">
			<h1>安装向导</h1>
		</div>
		<div class="main" style="margin-top:-123px;">
			<form id="validForm">
				<input type="hidden" name="step" value="1">
				<div class="desc">
					<b>填写管理员信息</b>
				</div>
				<table class="tb2">
					<tr>
						<th class="tbopt">&nbsp;管理员账号:</th>
						<td><input type="text" name="adminUsername" value="admin"
							size="35" class="txt"></td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<th class="tbopt">&nbsp;管理员密码:</th>
						<td><input type="text" id="adminPassword"
							name="adminPassword" value="" size="35" class="txt"></td>
						<td>&nbsp;</td>
					</tr>

					<tr>
						<th class="tbopt">&nbsp;</th>
						<td><input type="hidden" name="version" value="" />
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
