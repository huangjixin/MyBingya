<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<%
	String createName = request.getParameter("createName");
	if(createName==null) createName = "";
	String callbs = request.getParameter("callbs");
	if(callbs==null) callbs = "";
	String countb = request.getParameter("countb");
	if(countb==null) countb = "";
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

<link rel="stylesheet" type="text/css" href="${ctx}/js/jquery-easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${ctx}/js/jquery-easyui/demo/demo.css">
<link rel="stylesheet" type="text/css" href="${ctx}/js/jquery-easyui/themes/icon.css">
<script type="text/javascript" src="${ctx}/js/jquery-easyui/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery-easyui/jquery.easyui.min.js"></script>

<script type="text/javascript">
	$().ready(function() {
		
	});
	
	function onsubm(){
// 		alert('sdf');
		$('#toolTip').html('后台正在上传并且解析文件内容，请稍等…………');
// 		return true;
	}
</script>
<title>上传</title>
</head>
<body>
	<form id="validForm" action="${ctx}/tqunhuInfo/create"
		method="post" enctype="multipart/form-data">
		<div class="desc">
			<b>信息添加</b>&nbsp;&nbsp;&nbsp;&nbsp;<b id="msgB" style="color: red;">${msg}</b>
		</div>
		<table width="100%" border="0" cellpadding="2" cellspacing="0">
			<tr>
				<td width="100%">
					<table border="0" cellpadding="4" cellspacing="1" width="100%"
						align="center" style="background-color: #b9d8f3;">
						<tr
							style="text-align: right; BACKGROUND-COLOR: #F4FAFF; font-weight: normal;">
							<th>&nbsp;用户编号：</th>
							<td nowrap="nowrap" align="left"><input name="createName"
									value="<%=createName %>" />&nbsp;</td>
							<th>&nbsp;分机号：</th>
							<td nowrap="nowrap" align="left"><input name="callbs"
									value="<%=callbs %>" />&nbsp;</td>
							<th>&nbsp;数量：</th>
							<td nowrap="nowrap" align="left"><input path="countb"
									value="<%=countb %>" />&nbsp;</td>
							<th>&nbsp;上传文件：</th>
							<td nowrap="nowrap" align="left"><input type="file" name="file" />&nbsp;</td>
						</tr>
						<tr
							style="text-align: right; BACKGROUND-COLOR: #F4FAFF; font-weight: bold">
							<th style="width: 150px;">&nbsp;</th>
							<td style="text-align: left;" colspan="8"><input
								type="submit" value="保存" onclick="onsubm();" />&nbsp;&nbsp;</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<p id="toolTip"></p>
	</form>
</body>
</html>