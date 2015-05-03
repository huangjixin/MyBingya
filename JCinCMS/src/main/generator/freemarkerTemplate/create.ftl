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
<title>日志添加</title>
</head>
<body>
	<input type="button" value="返回"/>
	<form action="create" method="post">
		<table>
			<#list introspectedColumns as introspectedColumn>
			<tr>
				<th>名称：</th>
				<td><input id="${introspectedColumn}" type="text" name="${introspectedColumn}" value="${r'${'}${objInst}.${introspectedColumn}}"/></td>
			</tr>
			</#list>
		</table>
	</form>


</body>
</html>