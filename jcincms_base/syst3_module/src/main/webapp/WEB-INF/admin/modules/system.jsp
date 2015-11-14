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
<script type="text/javascript"
	src="${ctx}/js/jquery-easyui/jquery.min.js"></script>
<script type="text/javascript"
	src="${ctx}/js/jquery-easyui/jquery.easyui.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="${ctx}/js/jquery-easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${ctx}/js/jquery-easyui/demo/demo.css">
<link rel="stylesheet" type="text/css"
	href="${ctx}/js/jquery-easyui/themes/icon.css">
<script type="text/javascript">
	$().ready(function() {
	});
</script>
<title>系统信息</title>
</head>
<body>
	<table width="100%" border="0" cellpadding="2" cellspacing="0">
		<tr>
			<td width="100%">
				<table border="0" cellpadding="3" cellspacing="1" width="50%"
					align="left" style="background-color: #b9d8f3;">
					<tr
						style="text-align: right; BACKGROUND-COLOR: #F4FAFF; font-weight: bold">
						<th style="width: 150px;">操作系统名称  &nbsp;</th>
						<td style="text-align: left;" colspan="6">&nbsp;&nbsp;<input
							type="text" value="${osName}" />&nbsp;&nbsp;</td>
					</tr>
					<tr
						style="text-align: right; BACKGROUND-COLOR: #F4FAFF; font-weight: bold">
						<th style="width: 150px;">操作系统构架  &nbsp;</th>
						<td style="text-align: left;" colspan="6">&nbsp;&nbsp;<input
							type="text" value="${osArch}" />&nbsp;&nbsp;</td>
					</tr>
					<tr
						style="text-align: right; BACKGROUND-COLOR: #F4FAFF; font-weight: bold">
						<th style="width: 150px;">操作系统版本  &nbsp;</th>
						<td style="text-align: left;" colspan="6">&nbsp;&nbsp;<input
							type="text" value="${osVersion}" />&nbsp;&nbsp;</td>
					</tr>
					<tr
						style="text-align: right; BACKGROUND-COLOR: #F4FAFF; font-weight: bold">
						<th style="width: 150px;">Java 运行时环境版本  &nbsp;</th>
						<td style="text-align: left;" colspan="6">&nbsp;&nbsp;<input
							type="text" value="${version}" />&nbsp;&nbsp;</td>
					</tr>
					<tr
						style="text-align: right; BACKGROUND-COLOR: #F4FAFF; font-weight: bold">
						<th style="width: 150px;">Java 运行时环境供应商  &nbsp;</th>
						<td style="text-align: left;" colspan="6">&nbsp;&nbsp;<input
							type="text" value="${vendor}" />&nbsp;&nbsp;</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>