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
<title>菜单添加</title>
<script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery-easyui/dwrloader.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery-easyui/easyloader.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/jquery-easyui/jquery.easyui.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>js/jquery-easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>js/jquery-easyui/demo/demo.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>js/jquery-easyui/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>css/common.css">
<style type="text/css">
.table {
	border-collapse: collapse;
}

.tr1 {
	width: 100px;
	text-align: right;
	background-color: #F7F7F7;
}

.th1 {
	width: 50px;
	background-color: #F7F7F7;
	text-align: right;
	padding-right: 2px;
	background-color: #F7F7F7;
	font-weight: normal;
}

.td1 {
	width: 250px;
	background-color: #ffffff;
	text-align: left;
	width: 200px;
	padding-left: 2px;
	padding: 4px;
}
</style>
</head>
<body>
	<form id="form_return" action="list"></form>
	<form action="create" method="post">
		<table width="100%" id="ListArea" border="1px;" bordercolor="#C5C5C5"
			align="center" cellpadding="0" cellspacing="0"
			style="border-collapse: collapse;">
			<tbody>
				<tr class="tr1">
					<th class="th1">名称:</th>
					<td class="td1"><input type="text" name="name" id="name"
						value="localhost" size="35"></td>
				</tr>
				<tr class="tr1">
					<th class="th1">父菜单:</th>
					<td class="td1"><input type="hidden" name="parentId"
						id="parentId"><input class="easyui-combotree"
						data-options="url:'getMenu',method:'get'"
						style="width:200px;"></td>
				</tr>
				<tr class="tr1">
					<th class="th1">连接URL:</th>
					<td class="td1" colSpan="3"><input type="text" name="url"
						id="url" value="" size="35"></td>
				</tr>
				<tr class="tr1">
					<th class="th1">描述:</th>
					<td class="td1" colSpan="3" style="padding: 4px;"><textarea
							id="description" style="width: 520px;height: 100px;"></textarea>
					</td>
				</tr>
				<tr class="tr1">
					<th></th>
					<td class="td1"><input type="submit" value="保存" /><input
						type="button" value="清除表单" onclick="clearForm();" /><input
						type="button" value="返回" onclick="$('#form_return').submit();" /></td>

				</tr>
			</tbody>
		</table>
	</form>

</body>
</html>