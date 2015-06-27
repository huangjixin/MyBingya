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
<style type="text/css">
	th {
		font-weight: normal;
		font-size: 12px;
	}
</style>
<script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
<title>menu添加</title>
</head>
<body>
	<form:form id="validForm" action="createForm" method="post" commandName="menu">
				<input type="hidden" name="step" value="1">
				<div class="desc">
					<b>menu信息添加</b>
				</div>
				<table width="100%" border="0" cellpadding="2" cellspacing="0">
					<tr>
						<td width="100%">
							<table border="0" cellpadding="3" cellspacing="1" width="100%"
								align="center" style="background-color: #b9d8f3;">
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; font-weight: bold">
									<th>&nbsp;id：</th>
									<td nowrap="nowrap" align="left"><form:input path="id" value="${menu.id}"/>&nbsp;<form:errors path="id" cssStyle="color:red;"></form:errors></td>
									<th>&nbsp;name：</th>
									<td nowrap="nowrap" align="left"><form:input path="name" value="${menu.name}"/>&nbsp;<form:errors path="name" cssStyle="color:red;"></form:errors></td>
									<th>&nbsp;description：</th>
									<td nowrap="nowrap" align="left"><form:input path="description" value="${menu.description}"/>&nbsp;<form:errors path="description" cssStyle="color:red;"></form:errors></td>
								</tr>
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; font-weight: bold">
									<th>&nbsp;path：</th>
									<td nowrap="nowrap" align="left"><form:input path="path" value="${menu.path}"/>&nbsp;<form:errors path="path" cssStyle="color:red;"></form:errors></td>
									<th>&nbsp;parentId：</th>
									<td nowrap="nowrap" align="left"><form:input path="parentId" value="${menu.parentId}"/>&nbsp;<form:errors path="parentId" cssStyle="color:red;"></form:errors></td>
									<th>&nbsp;createDate：</th>
									<td nowrap="nowrap" align="left"><form:input path="createDate" value="${menu.createDate}"/>&nbsp;<form:errors path="createDate" cssStyle="color:red;"></form:errors></td>
								</tr>
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; font-weight: bold">
									<th>&nbsp;icon：</th>
									<td nowrap="nowrap" align="left"><form:input path="icon" value="${menu.icon}"/>&nbsp;<form:errors path="icon" cssStyle="color:red;"></form:errors></td>
									<th>&nbsp;updateDate：</th>
									<td nowrap="nowrap" align="left"><form:input path="updateDate" value="${menu.updateDate}"/>&nbsp;<form:errors path="updateDate" cssStyle="color:red;"></form:errors></td>
									<th>&nbsp;url：</th>
									<td nowrap="nowrap" align="left"><form:input path="url" value="${menu.url}"/>&nbsp;<form:errors path="url" cssStyle="color:red;"></form:errors></td>
								</tr>
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; font-weight: bold">
									<th style="width: 150px;">&nbsp;</th>
									<td  style="text-align: left;" colspan="6">&nbsp;&nbsp;<input type="button" value="返回" onclick="javascript:window.location.href='<%=basePath%>menu'"/></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>	
		</form:form>		
</body>
</html>