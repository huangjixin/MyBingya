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
<title>account查看</title>
</head>
<body>
	<form:form id="validForm" commandName="account">
				<div class="desc">
					<b>account信息更新</b>
				</div>
				<table width="100%" border="0" cellpadding="2" cellspacing="0">
					<tr>
						<td width="100%">
							<table border="0" cellpadding="3" cellspacing="1" width="100%"
								align="center" style="background-color: #b9d8f3;">
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
									<th>&nbsp;id：</th>
									<td nowrap="nowrap" align="left"><form:input path="id" value="${account.id}"/>&nbsp;<form:errors path="id" cssStyle="color:red;"></form:errors></td>
									<th>&nbsp;total：</th>
									<td nowrap="nowrap" align="left"><form:input path="total" value="${account.total}"/>&nbsp;<form:errors path="total" cssStyle="color:red;"></form:errors></td>
									<th>&nbsp;createDate：</th>
									<td nowrap="nowrap" align="left"><form:input path="createDate" value="${account.createDate}"/>&nbsp;<form:errors path="createDate" cssStyle="color:red;"></form:errors></td>
								</tr>
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
									<th>&nbsp;updateDate：</th>
									<td nowrap="nowrap" align="left"><form:input path="updateDate" value="${account.updateDate}"/>&nbsp;<form:errors path="updateDate" cssStyle="color:red;"></form:errors></td>
									<th>&nbsp;description：</th>
									<td nowrap="nowrap" align="left"><form:input path="description" value="${account.description}"/>&nbsp;<form:errors path="description" cssStyle="color:red;"></form:errors></td>
									<th>&nbsp;createBy：</th>
									<td nowrap="nowrap" align="left"><form:input path="createBy" value="${account.createBy}"/>&nbsp;<form:errors path="createBy" cssStyle="color:red;"></form:errors></td>
								</tr>
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
									<th>&nbsp;updateBy：</th>
									<td nowrap="nowrap" align="left"><form:input path="updateBy" value="${account.updateBy}"/>&nbsp;<form:errors path="updateBy" cssStyle="color:red;"></form:errors></td>
									<th>&nbsp;username：</th>
									<td nowrap="nowrap" align="left"><form:input path="username" value="${account.username}"/>&nbsp;<form:errors path="username" cssStyle="color:red;"></form:errors></td>
								</tr>
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
									<th style="width: 150px;">&nbsp;</th>
									<td  style="text-align: left;" colspan="6"><input type="button" value="返回" onclick="javascript:window.location.href='${ctxAdmin}/account'"/></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>	
		</form:form>		
</body>
</html>