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

<title>登录</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="登录">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css"
	rel="stylesheet">
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
<script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
</head>

<body>
	<div class="container-fluid">
		<form class="form-horizontal" method="post">
			<fieldset>
				<legend>用户登陆</legend>
				<div class="control-group">
					<label class="control-label" for="username">用户名</label>
					<div class="controls">
						<input type="text" class="input-xlarge" id="username"
							name="username">
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="password">密码</label>
					<div class="controls">
						<input type="password" class="input-xlarge" id="password"
							name="password">
					</div>
				</div>
				<div class="form-actions">
					<button type="submit" class="btn btn-primary">登陆</button>
				</div>
			</fieldset>
		</form>
	</div>
</body>
</html>
