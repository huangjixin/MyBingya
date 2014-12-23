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
<meta http-equiv="description" content="login">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link href="<%=basePath%>bootstrap/css/bootstrap.css" rel="stylesheet">
<script src="<%=basePath%>js/jquery.min.js"></script>
<script src="<%=basePath%>bootstrap/js/bootstrap.js"></script>
<style type="text/css">
.modal-footer {
	border-top: 0px;
}
</style>
</head>

<body>
	<div class="container"
		style="text-align: center;">
		<div class="modal-body" style="text-align: center;">
			<form class="form col-md-12 center-block"
				action="<%=basePath%>/login/validatelogin">
				<div class="form-group">
					<input type="text" class="form-control input-lg" id="username"
						name="username" placeholder="用户名">
				</div>
				<div class="form-group">
					<input type="password" class="form-control input-lg" id="password"
						name="password" placeholder="密码">
				</div>
				<div class="form-group">
					<button class="btn btn-primary btn-lg btn-block">登录</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>
