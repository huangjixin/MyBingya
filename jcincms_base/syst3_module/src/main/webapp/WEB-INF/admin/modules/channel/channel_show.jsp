<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
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
<script type="text/javascript" src="${ctx}/js/jquery-easyui/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery-easyui/jquery.easyui.min.js"></script>
<link rel="stylesheet" type="text/css" href="${ctx}/js/jquery-easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${ctx}/js/jquery-easyui/demo/demo.css">
<link rel="stylesheet" type="text/css" href="${ctx}/js/jquery-easyui/themes/icon.css">
<title>channel更新</title>
</head>
<body>
	<form:form id="validForm" commandName="channel">
				<div class="desc">
					<b>channel信息更新</b>
				</div>
				<table width="100%" border="0" cellpadding="2" cellspacing="0">
					<tr>
						<td width="100%">
							<table border="0" cellpadding="3" cellspacing="1" width="100%"
								align="center" style="background-color: #b9d8f3;">
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
									<th>&nbsp;id：</th>
									<td nowrap="nowrap" align="left"><form:input path="id" value="${channel.id}"/>&nbsp;<form:errors path="id" cssStyle="color:red;"></form:errors></td>
									<th>&nbsp;name：</th>
									<td nowrap="nowrap" align="left"><form:input path="name" value="${channel.name}"/>&nbsp;<form:errors path="name" cssStyle="color:red;"></form:errors></td>
									<th>&nbsp;code：</th>
									<td nowrap="nowrap" align="left"><form:input path="code" value="${channel.code}"/>&nbsp;<form:errors path="code" cssStyle="color:red;"></form:errors></td>
								</tr>
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
									<th>&nbsp;keyword：</th>
									<td nowrap="nowrap" align="left"><form:input path="keyword" value="${channel.keyword}"/>&nbsp;<form:errors path="keyword" cssStyle="color:red;"></form:errors></td>
									<th>&nbsp;linkAddr：</th>
									<td nowrap="nowrap" align="left"><form:input path="linkAddr" value="${channel.linkAddr}"/>&nbsp;<form:errors path="linkAddr" cssStyle="color:red;"></form:errors></td>
									<th>&nbsp;openMode：</th>
									<td nowrap="nowrap" align="left"><form:input path="openMode" value="${channel.openMode}"/>&nbsp;<form:errors path="openMode" cssStyle="color:red;"></form:errors></td>
								</tr>
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
									<th>&nbsp;desc：</th>
									<td nowrap="nowrap" align="left"><form:input path="desc" value="${channel.desc}"/>&nbsp;<form:errors path="desc" cssStyle="color:red;"></form:errors></td>
									<th>&nbsp;parentId：</th>
									<td nowrap="nowrap" align="left"><form:input path="parentId" value="${channel.parentId}"/>&nbsp;<form:errors path="parentId" cssStyle="color:red;"></form:errors></td>
								</tr>
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
									<th style="width: 150px;">&nbsp;</th>
									<td  style="text-align: left;" colspan="6"><input type="button" value="返回" onclick="javascript:window.location.href='${ctxAdmin}/channel'"/></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>	
		</form:form>		
</body>
</html>