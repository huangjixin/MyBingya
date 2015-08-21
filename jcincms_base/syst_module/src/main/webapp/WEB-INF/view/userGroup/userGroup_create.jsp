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
<style type="text/css">
th {
	font-weight: normal;
	font-size: 12px;
}
</style>
<script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/jquery-easyui/jquery.easyui.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>js/jquery-easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>js/jquery-easyui/demo/demo.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>js/jquery-easyui/themes/icon.css">
<script type="text/javascript">
$().ready(function() {
	$('#roleIdInput').combobox({
		url:'<%=basePath%>role/getRole',
		valueField:'id',
		textField:'name',
		editable: false, //不允许手动输入
		onSelect:function(node){
			$('#roleId').val(node.id);
			alert($('#roleId').val());
		},
		onLoadSuccess: function () { //数据加载完毕事件
             var data = $('#userGroupIdInput').combobox('getData');
             if (data.length > 0) {
                 $("#roleIdInput").combobox('select', data[0].name);
             }
        }
		});
	});
	
	function clearUserGroupIdInput(){
		$('#roleId').val('');
		$('#roleIdInput').combobox('clear');
	}
</script>
<title>用户组添加</title>
</head>
<body>
	<form:form id="validForm" action="createForm" method="post"
		commandName="userGroup">
		<div class="desc">
			<b>用户组信息添加</b>
		</div>
		<table width="100%" border="0" cellpadding="2" cellspacing="0">
			<tr>
				<td width="100%">
					<table border="0" cellpadding="3" cellspacing="1" width="100%"
						align="center" style="background-color: #b9d8f3;">
						<tr
							style="text-align: right; BACKGROUND-COLOR: #F4FAFF; font-weight: bold">
							<th>&nbsp;组名：</th>
							<td nowrap="nowrap" align="left"><form:input
									path="groupname" value="${userGroup.groupname}" />&nbsp;<form:errors
									path="groupname" cssStyle="color:red;"></form:errors></td>
							<th>&nbsp;描述：</th>
							<td nowrap="nowrap" align="left"><form:input
									path="description" value="${userGroup.description}" />&nbsp;<form:errors
									path="description" cssStyle="color:red;"></form:errors></td>
							<th>&nbsp;角色：</th>
							<td nowrap="nowrap" align="left"><input
								id="roleIdInput" /> <input type="hidden" id="roleId"/>&nbsp; <input
								type="button" value="清除"
								onclick="javascript:clearUserGroupIdInput();" /></td>
						</tr>
						<tr
							style="text-align: right; BACKGROUND-COLOR: #F4FAFF; font-weight: bold">
							<th style="width: 150px;">&nbsp;</th>
							<td style="text-align: left;" colspan="6"><input
								type="submit" value="保存" />&nbsp;&nbsp;<input type="button"
								value="返回"
								onclick="javascript:window.location.href='<%=basePath%>userGroup'" /></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>