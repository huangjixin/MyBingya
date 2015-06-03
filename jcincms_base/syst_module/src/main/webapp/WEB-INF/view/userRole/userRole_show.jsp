<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
<title>userRole添加</title>
</head>
<body>
	<form:form id="validForm" action="createForm" method="post" commandName="userRole">
				<input type="hidden" name="step" value="1">
				<div class="desc">
					<b>userRole信息添加</b>
				</div>
				<table width="100%" border="0" cellpadding="2" cellspacing="0">
					<tr>
						<td width="100%">
							<table border="0" cellpadding="3" cellspacing="1" width="100%"
								align="center" style="background-color: #b9d8f3;">
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; font-weight: bold">
									<th>&nbsp;id：</th>
									<td nowrap="nowrap" align="left"><form:input path="id" value="${userRole.id}"/>&nbsp;<form:errors path="id" cssStyle="color:red;"></form:errors></td>
									<th>&nbsp;userId：</th>
									<td nowrap="nowrap" align="left"><form:input path="userId" value="${userRole.userId}"/>&nbsp;<form:errors path="userId" cssStyle="color:red;"></form:errors></td>
									<th>&nbsp;roleId：</th>
									<td nowrap="nowrap" align="left"><form:input path="roleId" value="${userRole.roleId}"/>&nbsp;<form:errors path="roleId" cssStyle="color:red;"></form:errors></td>
								</tr>
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; font-weight: bold">
									<th style="width: 150px;">&nbsp;</th>
									<td  style="text-align: left;" colspan="6">&nbsp;&nbsp;<input type="button" value="返回" onclick="javascript:window.location.href='<%=basePath%>userRole'"/></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>	
		</form:form>		
</body>
</html>