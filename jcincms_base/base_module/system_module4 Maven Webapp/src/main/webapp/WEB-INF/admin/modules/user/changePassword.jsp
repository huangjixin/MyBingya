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
<script type="text/javascript">
	$().ready(function() {
	});
</script>
<title>密码修改</title>
</head>
<body>
	<form:form id="validForm" action="${ctxAdmin}/user/changePassword"
		method="post" commandName="user">
		<input name="id" value="${user.id}" type="hidden" />
		<div class="desc">
			<b>密码修改需重新登录</b>
		</div>
		<table width="100%" border="0" cellpadding="2" cellspacing="0">
			<tr>
				<td width="100%">
					<table border="0" cellpadding="3" cellspacing="1" width="100%"
						align="center" style="background-color: #b9d8f3;">
						<tr
							style="text-align: right; BACKGROUND-COLOR: #F4FAFF; font-weight: normal;">
							<th>&nbsp;用户名：</th>
							<td nowrap="nowrap" align="left"><form:input path="username" value="${user.username}" />&nbsp;
								<form:errors path="username" cssStyle="color:red;"></form:errors></td>
							<th>&nbsp;旧密码：</th>
							<td nowrap="nowrap" align="left"><form:password
									path="password" value="" />&nbsp;<form:errors
									path="password" cssStyle="color:red;"></form:errors></td>
							<th>&nbsp;新密码：</th>
							<td nowrap="nowrap" align="left"><input type="password" name="newPassword"/></td>
						</tr>
						<tr
							style="text-align: right; BACKGROUND-COLOR: #F4FAFF; font-weight: bold">
							<th style="width: 150px;">&nbsp;</th>
							<td style="text-align: left;" colspan="6"><input
								type="submit" value="保存" />&nbsp;&nbsp;<input type="button"
								value="返回"
								onclick="javascript:window.location.href='${ctxAdmin}/user'" /></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>