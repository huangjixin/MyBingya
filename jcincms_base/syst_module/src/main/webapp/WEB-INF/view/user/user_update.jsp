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
<title>user更新</title>
</head>
<body>
	<form:form id="validForm" action="<%=basePath%>user/updateForm" method="post" commandName="user">
				<input type="hidden" name="step" value="1">
				<div class="desc">
					<b>user信息更新</b>
				</div>
				<table width="100%" border="0" cellpadding="2" cellspacing="0">
					<tr>
						<td width="100%">
							<table border="0" cellpadding="3" cellspacing="1" width="100%"
								align="center" style="background-color: #b9d8f3;">
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
									<th>&nbsp;id：</th>
									<td nowrap="nowrap" align="left"><form:input path="id" value="${user.id}"/>&nbsp;<form:errors path="id" cssStyle="color:red;"></form:errors></td>
									<th>&nbsp;username：</th>
									<td nowrap="nowrap" align="left"><form:input path="username" value="${user.username}"/>&nbsp;<form:errors path="username" cssStyle="color:red;"></form:errors></td>
									<th>&nbsp;password：</th>
									<td nowrap="nowrap" align="left"><form:input path="password" value="${user.password}"/>&nbsp;<form:errors path="password" cssStyle="color:red;"></form:errors></td>
								</tr>
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
									<th>&nbsp;status：</th>
									<td nowrap="nowrap" align="left"><form:input path="status" value="${user.status}"/>&nbsp;<form:errors path="status" cssStyle="color:red;"></form:errors></td>
									<th>&nbsp;description：</th>
									<td nowrap="nowrap" align="left"><form:input path="description" value="${user.description}"/>&nbsp;<form:errors path="description" cssStyle="color:red;"></form:errors></td>
									<th>&nbsp;enabled：</th>
									<td nowrap="nowrap" align="left"><form:input path="enabled" value="${user.enabled}"/>&nbsp;<form:errors path="enabled" cssStyle="color:red;"></form:errors></td>
								</tr>
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
									<th>&nbsp;createDate：</th>
									<td nowrap="nowrap" align="left"><form:input path="createDate" value="${user.createDate}"/>&nbsp;<form:errors path="createDate" cssStyle="color:red;"></form:errors></td>
									<th>&nbsp;updateDate：</th>
									<td nowrap="nowrap" align="left"><form:input path="updateDate" value="${user.updateDate}"/>&nbsp;<form:errors path="updateDate" cssStyle="color:red;"></form:errors></td>
									<th>&nbsp;ip：</th>
									<td nowrap="nowrap" align="left"><form:input path="ip" value="${user.ip}"/>&nbsp;<form:errors path="ip" cssStyle="color:red;"></form:errors></td>
								</tr>
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
									<th>&nbsp;telephone：</th>
									<td nowrap="nowrap" align="left"><form:input path="telephone" value="${user.telephone}"/>&nbsp;<form:errors path="telephone" cssStyle="color:red;"></form:errors></td>
									<th>&nbsp;salt：</th>
									<td nowrap="nowrap" align="left"><form:input path="salt" value="${user.salt}"/>&nbsp;<form:errors path="salt" cssStyle="color:red;"></form:errors></td>
									<th>&nbsp;locked：</th>
									<td nowrap="nowrap" align="left"><form:input path="locked" value="${user.locked}"/>&nbsp;<form:errors path="locked" cssStyle="color:red;"></form:errors></td>
								</tr>
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
									<th>&nbsp;email：</th>
									<td nowrap="nowrap" align="left"><form:input path="email" value="${user.email}"/>&nbsp;<form:errors path="email" cssStyle="color:red;"></form:errors></td>
									<th>&nbsp;sex：</th>
									<td nowrap="nowrap" align="left"><form:input path="sex" value="${user.sex}"/>&nbsp;<form:errors path="sex" cssStyle="color:red;"></form:errors></td>
									<th>&nbsp;address：</th>
									<td nowrap="nowrap" align="left"><form:input path="address" value="${user.address}"/>&nbsp;<form:errors path="address" cssStyle="color:red;"></form:errors></td>
								</tr>
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
									<th>&nbsp;userGroup_id：</th>
									<td nowrap="nowrap" align="left"><form:input path="userGroup_id" value="${user.userGroup_id}"/>&nbsp;<form:errors path="userGroup_id" cssStyle="color:red;"></form:errors></td>
								</tr>
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
									<th style="width: 150px;">&nbsp;</th>
									<td  style="text-align: left;" colspan="6"><input type="submit" value="保存" />&nbsp;&nbsp;<input type="button" value="返回" onclick="javascript:window.location.href='<%=basePath%>user'"/></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>	
		</form:form>		
</body>
</html>