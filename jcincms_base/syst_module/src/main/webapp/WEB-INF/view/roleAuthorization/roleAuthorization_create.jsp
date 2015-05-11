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
<link rel="stylesheet" href="<%=basePath%>images/style.css"
	type="text/css" />
<script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
<title>roleAuthorization添加</title>
</head>
<body>
	<div class="container">
		<div class="main" style="margin-top:0px;">
			<form id="validForm" action="createForm" method="post">
				<input type="hidden" name="step" value="1">
				<div class="desc">
					<b>roleAuthorization信息添加</b>
				</div>
				<table class="tb2">
					<tr>
						<th class="tbopt">&nbsp;id:</th>
						<td><input type="text" name="id"  value="${roleAuthorization.id}"
							size="35" class="txt"/></td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<th class="tbopt">&nbsp;roleId:</th>
						<td><input type="text" name="roleId"  value="${roleAuthorization.roleId}"
							size="35" class="txt"/></td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<th class="tbopt">&nbsp;authorizationId:</th>
						<td><input type="text" name="authorizationId"  value="${roleAuthorization.authorizationId}"
							size="35" class="txt"/></td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<th class="tbopt">&nbsp;</th>
						<td><input type="submit" value="保存" /><input type="button" value="返回" onclick="javascript:window.location.href='<%=basePath%>user'" /></td>
						<td>&nbsp;</td>
					</tr>
				</table>
		</div>
	</div>
</body>
</html>