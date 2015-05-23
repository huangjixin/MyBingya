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
<title>authorization添加</title>
</head>
<body>
	<form id="validForm" action="createForm" method="post">
				<input type="hidden" name="step" value="1">
				<div class="desc">
					<b>authorization信息添加</b>
				</div>
				<table width="100%" border="0" cellpadding="2" cellspacing="0">
					<tr>
						<td width="100%">
							<table border="0" cellpadding="3" cellspacing="1" width="100%"
								align="center" style="background-color: #b9d8f3;">
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; font-weight: bold">
									<th>&nbsp;id：</th>
									<td nowrap="nowrap" align="left"><input type="text" name="id" value="${authorization.id}" size="35" style="paddingLeft:3px;paddingTop:3px;paddingBottom:3px;"/></td>
									<th>&nbsp;name：</th>
									<td nowrap="nowrap" align="left"><input type="text" name="name" value="${authorization.name}" size="35" style="paddingLeft:3px;paddingTop:3px;paddingBottom:3px;"/></td>
									<th>&nbsp;description：</th>
									<td nowrap="nowrap" align="left"><input type="text" name="description" value="${authorization.description}" size="35" style="paddingLeft:3px;paddingTop:3px;paddingBottom:3px;"/></td>
								</tr>
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; font-weight: bold">
									<th>&nbsp;createDate：</th>
									<td nowrap="nowrap" align="left"><input type="text" name="createDate" value="${authorization.createDate}" size="35" style="paddingLeft:3px;paddingTop:3px;paddingBottom:3px;"/></td>
									<th>&nbsp;updateDate：</th>
									<td nowrap="nowrap" align="left"><input type="text" name="updateDate" value="${authorization.updateDate}" size="35" style="paddingLeft:3px;paddingTop:3px;paddingBottom:3px;"/></td>
									<th>&nbsp;parentId：</th>
									<td nowrap="nowrap" align="left"><input type="text" name="parentId" value="${authorization.parentId}" size="35" style="paddingLeft:3px;paddingTop:3px;paddingBottom:3px;"/></td>
								</tr>
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; font-weight: bold">
									<th>&nbsp;url：</th>
									<td nowrap="nowrap" align="left"><input type="text" name="url" value="${authorization.url}" size="35" style="paddingLeft:3px;paddingTop:3px;paddingBottom:3px;"/></td>
									<th>&nbsp;parentIds：</th>
									<td nowrap="nowrap" align="left"><input type="text" name="parentIds" value="${authorization.parentIds}" size="35" style="paddingLeft:3px;paddingTop:3px;paddingBottom:3px;"/></td>
								</tr>
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; font-weight: bold">
									<th style="width: 150px;">&nbsp;</th>
									<td  style="text-align: left;" colspan="6">&nbsp;&nbsp;<input type="button" value="返回" onclick="javascript:window.location.href='<%=basePath%>authorization'"/></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>	
		</form>		
</body>
</html>