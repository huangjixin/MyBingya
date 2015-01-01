<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<title>登录</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="登录">
<meta http-equiv="description" content="login">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link href="<%=basePath%>bootstrap/css/bootstrap.css" rel="stylesheet">
<script src="<%=basePath%>js/jquery.min.js"></script>
<script src="<%=basePath%>bootstrap/js/bootstrap.js"></script>

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/login/css/reset.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/login/css/login.css" />
<script type="text/javascript">
	$(document).ready(function() {
		initUsernameInput();
	});

	//初始化用户名输入文本
	function initUsernameInput() {
		$('#username').focusin(function() {
			var username = $('#username').val();
			if (username == "请输入用户名") {
				this.value = '';
			}

		}).focusout(function() {
			var username = $('#username').val();
			if (username == "") {
				this.value = '请输入用户名';
			}
		});
	}
	
	function submitData() {
		var loginRequest = {};

		loginRequest.username = $("#username").val();
		loginRequest.password = $("#passwd").val();
		
		$.ajax({
				cache : false,
				type : "get",
				url : 'login/validatelogin',
				data : loginRequest,
				async : false,
				error : function(request) {
					$("#hintMsg").html("连接失败");
				},
				success : function(data) {
					alert(data.loginResult);
					if(data.loginResult == "success"){
						window.location.href="index.jsp";
					}else{
						$("#hintMsg").html(data.loginInfo);
					}
					
				}
			});
	}
</script>
</head>

<body style="text-align: center; margin: 0 auto;">
	<div class="logintop">
		<div class="logoname"></div>
	</div>
	<div class="loginCont">
		<div class="loginBox">
			<div class="box">
				<form id="frmLogin" onsubmit="return false;" submit="btn_login">
					<table width="100%" border="0" cellspacing="0" cellpadding="0"
						class="logintab">
						<tr>
							<th>用户名</th>
							<td>
								<div class="loginipt">
									<span class="useric"></span> <input type="text"
										name="textfield" id="username" value="请输入用户名" />
								</div></td>
						</tr>
						<tr>
							<th>密&nbsp;&nbsp;码</th>
							<td>
								<div class="loginipt focus">
									<span class="lockic"></span> <input type="password"
										name="textfield" id="passwd" value="" />
								</div>
								<p id="hintMsg" class="remind">&emsp;</p></td>
						</tr>
					</table>
					<div class="btns">
						<a id="btn_login" class="greBtn" onclick="submitData();">登录</a>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
