<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
<title>更新</title>
</head>
<body>
	<form id="form_return" action="list"></form>
	<form action="update" method="post">
		<table>
			<tr>
				<th></th>
				<td><input type="button" value="返回"
					onclick="$('#form_return').submit();" /></td>
			</tr>
			<tr>
				<th>ID：</th>
				<td><input type="text" name="id"
					value="${operationlog.id}" /></td>
			</tr>
			<tr>
				<th>名称：</th>
				<td><input id="name" type="text" name="name"
					value="${operationlog.name}" /></td>
			</tr>
			<tr>
				<th></th>
				<td><input type="submit" value="保存" /></td>
			</tr>
		</table>
	</form>
</body>
</html>