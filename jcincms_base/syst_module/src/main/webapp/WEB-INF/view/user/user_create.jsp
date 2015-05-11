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
<!--<link rel="stylesheet" href="<%=basePath%>images/style.css"
	type="text/css" />-->
<script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
<title>user添加</title>
</head>
<body>
	<form id="validForm" action="createForm" method="post">
				<input type="hidden" name="step" value="1">
				<div class="desc">
					<b>user信息添加</b>
				</div>
				<table width="100%" border="0" cellpadding="2" cellspacing="0">
					<tr>
						<td width="100%">
							<table border="0" cellpadding="3" cellspacing="1" width="100%"
								align="center" style="background-color: #b9d8f3;">
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; font-weight: bold">
									<th style="width: 150px;">&nbsp;id：</th>
									<td nowrap="nowrap" align="left"><input type="text" name="id" value="${user.id}" size="35" style="padding: 3px;"/></td>
									<th style="width: 150px;">&nbsp;username：</th>
									<td nowrap="nowrap" align="left"><input type="text" name="username" value="${user.username}" size="35" style="padding: 3px;"/></td>
									<th style="width: 150px;">&nbsp;password：</th>
									<td nowrap="nowrap" align="left"><input type="text" name="password" value="${user.password}" size="35" style="padding: 3px;"/></td>
								</tr>
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; font-weight: bold">
									<th style="width: 150px;">&nbsp;status：</th>
									<td nowrap="nowrap" align="left"><input type="text" name="status" value="${user.status}" size="35" style="padding: 3px;"/></td>
									<th style="width: 150px;">&nbsp;description：</th>
									<td nowrap="nowrap" align="left"><input type="text" name="description" value="${user.description}" size="35" style="padding: 3px;"/></td>
									<th style="width: 150px;">&nbsp;enabled：</th>
									<td nowrap="nowrap" align="left"><input type="text" name="enabled" value="${user.enabled}" size="35" style="padding: 3px;"/></td>
								</tr>
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; font-weight: bold">
									<th style="width: 150px;">&nbsp;telephone：</th>
									<td nowrap="nowrap" align="left"><input type="text" name="telephone" value="${user.telephone}" size="35" style="padding: 3px;"/></td>
									<th style="width: 150px;">&nbsp;salt：</th>
									<td nowrap="nowrap" align="left"><input type="text" name="salt" value="${user.salt}" size="35" style="padding: 3px;"/></td>
									<th style="width: 150px;">&nbsp;locked：</th>
									<td nowrap="nowrap" align="left"><input type="text" name="locked" value="${user.locked}" size="35" style="padding: 3px;"/></td>
								</tr>
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; font-weight: bold">
									<th style="width: 150px;">&nbsp;</th>
									<td  style="text-align: left;" colspan="6"><input type="submit" value="保存" />&nbsp;&nbsp;<input type="button" value="返回" onclick="javascript:window.location.href='<%=basePath%>user'"/></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>	
		</form>		
</body>
</html>