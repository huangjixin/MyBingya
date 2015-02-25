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

<title>菜单更新</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="菜单更新">
<meta http-equiv="description" content="菜单更新">
<script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<form id="form_return" action="menu/list"></form>
	<form action="menu/update" method="post">
		<table>
			<tr>
				<th></th>
				<td><input type="button" value="返回"
					onclick="$('#form_return').submit();" /></td>
			</tr>
			<tr>
				<th>ID：</th>
				<td><input type="hidden" id="IdInput" name="id"
					value="${menu.id}" /></td>
			</tr>
			<tr>
				<th>名称：</th>
				<td><input type="text" id="name" name="name"
					value="${menu.name}" /></td>
			</tr>
			<tr>
				<th>描述：</th>
				<td><input type="text" id="description" name="description"
					value="${menu.description}" /></td>
			</tr>
			<tr>
				<th>URL：</th>
				<td><input type="text" id="url" name="url"
					value="${menu.url}" /></td>
			</tr>
			<tr>
				<th></th>
				<td><input type="submit" value="保存" /></td>
			</tr>
		</table>
	</form>
</body>
</html>
