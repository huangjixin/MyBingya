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
<title>user更新</title>
</head>
<body>
	<div class="container">
		<div class="main" style="margin-top:0px;">
			<form id="validForm" action="updateForm" method="post">
				<input type="hidden" name="step" value="1">
				<div class="desc">
					<b>user信息添加</b>
				</div>
				<table class="tb2">
					<tr>
						<th class="tbopt">&nbsp;id:</th>
						<td><input type="text" name="id"  value="${user.id}"
							size="35" class="txt"/></td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<th class="tbopt">&nbsp;username:</th>
						<td><input type="text" name="username"  value="${user.username}"
							size="35" class="txt"/></td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<th class="tbopt">&nbsp;password:</th>
						<td><input type="text" name="password"  value="${user.password}"
							size="35" class="txt"/></td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<th class="tbopt">&nbsp;status:</th>
						<td><input type="text" name="status"  value="${user.status}"
							size="35" class="txt"/></td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<th class="tbopt">&nbsp;description:</th>
						<td><input type="text" name="description"  value="${user.description}"
							size="35" class="txt"/></td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<th class="tbopt">&nbsp;enabled:</th>
						<td><input type="text" name="enabled"  value="${user.enabled}"
							size="35" class="txt"/></td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<th class="tbopt">&nbsp;createDate:</th>
						<td><input type="text" name="createDate"  value="${user.createDate}"
							size="35" class="txt"/></td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<th class="tbopt">&nbsp;updateDate:</th>
						<td><input type="text" name="updateDate"  value="${user.updateDate}"
							size="35" class="txt"/></td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<th class="tbopt">&nbsp;ip:</th>
						<td><input type="text" name="ip"  value="${user.ip}"
							size="35" class="txt"/></td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<th class="tbopt">&nbsp;telephone:</th>
						<td><input type="text" name="telephone"  value="${user.telephone}"
							size="35" class="txt"/></td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<th class="tbopt">&nbsp;salt:</th>
						<td><input type="text" name="salt"  value="${user.salt}"
							size="35" class="txt"/></td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<th class="tbopt">&nbsp;locked:</th>
						<td><input type="text" name="locked"  value="${user.locked}"
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