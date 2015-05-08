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
<title>test添加</title>
</head>
<body>
	<input type="button" value="返回" onclick="javascript:window.location.href='<%=basePath%>test'"/>
	<form action="createForm" method="post">
		<table>
			<tr>
				<th>id：</th>
				<td><input id="id" type="text" name="id" value="${test.id}"/></td>
			</tr>
			<tr>
				<th>description：</th>
				<td><input id="description" type="text" name="description" value="${test.description}"/></td>
			</tr>
			<tr>
				<th></th>
				<td><input type="submit" value="保存" /></td>
			</tr>
		</table>
	</form>


</body>
</html>