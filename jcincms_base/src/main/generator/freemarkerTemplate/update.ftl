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
<title>${objInst}更新</title>
</head>
<body>
	<form id="validForm" action="<%=basePath%>${objInst}/updateForm" method="post">
				<input type="hidden" name="step" value="1">
				<div class="desc">
					<b>${objInst}信息更新</b>
				</div>
				<table width="100%" border="0" cellpadding="2" cellspacing="0">
					<tr>
						<td width="100%">
							<table border="0" cellpadding="3" cellspacing="1" width="100%"
								align="center" style="background-color: #b9d8f3;">
								<#assign iSum=0>
								<#list introspectedColumns as introspectedColumn>
								<#if (iSum%3==0)>
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
								</#if>
									<th>&nbsp;${introspectedColumn}：</th>
									<td nowrap="nowrap" align="left"><input type="text" name="${introspectedColumn}" value="${r'${'}${objInst}.${introspectedColumn}}" size="35" style="paddingLeft:3px;paddingTop:3px;paddingBottom:3px;"/></td>
								<#if (iSum%3!=0 && iSum%3==2)>
								</tr>
								</#if>
								<#assign iSum=iSum+1>
								</#list>
								<#if (iSum%3!=0)>
								</tr>
								</#if>
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
									<th style="width: 150px;">&nbsp;</th>
									<td  style="text-align: left;" colspan="6"><input type="submit" value="保存" />&nbsp;&nbsp;<input type="button" value="返回" onclick="javascript:window.location.href='<%=basePath%>${objInst}'"/></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>	
		</form>		
</body>
</html>