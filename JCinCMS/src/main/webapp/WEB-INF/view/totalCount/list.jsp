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
<title>结余查询</title>
</head>
<body>
	<table>
		<tr>
			<th>应付明细：</th>
			<td><input type="text" id="material" name="material"
				value="${totalNotPayed}" /></td>
		</tr>
		<tr>
			<th>已付合计：</th>
			<td><input type="text" id="size" name="size"
				value="${totalPayed}" /></td>
		</tr>
		<tr>
			<th>结余：</th>
			<td><input type="text" id="weight" name="weight"
				value="${reduce}" /></td>
		</tr>
	</table>
</body>
</html>