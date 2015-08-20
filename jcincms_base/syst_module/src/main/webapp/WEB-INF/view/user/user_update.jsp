<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:set var="groupId" value="${user.userGroupId}" />
<c:set var="enabled" value="${user.enabled}" />
<c:set var="locked" value="${user.locked}" />
<c:set var="sex" value="${user.sex}" />
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
	$("#enabled").val('${enabled}');
	$("#locked").val('${locked}');
	$("#sex").val('${sex}');
	$('#userGroupIdInput').combobox({
		url:'<%=basePath%>userGroup/getUserGroup',
		valueField:'id',
		textField:'groupname',
		editable: false, //不允许手动输入
		required : true,
		onSelect:function(node){
			$('#userGroupId').val(node.id);
		},
		onLoadSuccess: function () { //数据加载完毕事件
             var data = $('#userGroupIdInput').combobox('getData');
             if (data.length > 0) {
            	 $("#userGroupIdInput").combobox('select', data[0].groupname);
            	 var groupId = ${groupId};
            	 for(var i=0;i<data.length;i++){
            		 if(groupId == data[i].id){
            			 $("#userGroupIdInput").combobox('select', data[i].groupname);
            			 break;
            		 }
            	 }
            	 
             }
        }
		});
	});
	
	function clearUserGroupIdInput(){
		$('#userGroupId').val('');
		$('#userGroupIdInput').combobox('clear');
	}
</script>
<title>用户更新</title>
</head>
<body>
	<form:form id="validForm" action="${ctx}/user/updateForm" method="post"
		commandName="user">
		<input type="hidden" name="step" value="1">
		<div class="desc">
			<b>用户信息更新</b>
		</div>
		<table width="100%" border="0" cellpadding="2" cellspacing="0">
			<tr>
				<td width="100%">
					<table border="0" cellpadding="3" cellspacing="1" width="100%"
						align="center" style="background-color: #b9d8f3;">
						<tr
							style="text-align: right; BACKGROUND-COLOR: #F4FAFF; font-weight: normal;">
							<input type="hidden" id="id" name="id" value="${user.id}"/>
							<th>&nbsp;用户名：</th>
							<td nowrap="nowrap" align="left"><form:input path="username"
									value="${user.username}" />&nbsp;<form:errors path="username"
									cssStyle="color:red;"></form:errors></td>
							<th>&nbsp;密码：</th>
							<td nowrap="nowrap" align="left"><form:password
									path="password" value="${user.password}" />&nbsp;<form:errors
									path="password" cssStyle="color:red;"></form:errors></td>
							<th>&nbsp;用户组：</th>
							<td nowrap="nowrap" align="left"><input
								id="userGroupIdInput" /> <form:hidden id="userGroupId"
									path="userGroupId" value="${user.userGroupId}" />&nbsp; <input
								type="button" value="清除"
								onclick="javascript:clearUserGroupIdInput();" /></td>
						</tr>
						<tr
							style="text-align: right; BACKGROUND-COLOR: #F4FAFF; font-weight: bold">
							<th>&nbsp;状态：</th>
							<td nowrap="nowrap" align="left"><form:input path="status"
									value="${user.status}" />&nbsp;<form:errors path="status"
									cssStyle="color:red;"></form:errors></td>
							<th>&nbsp;描述：</th>
							<td nowrap="nowrap" align="left"><form:input
									path="description" value="${user.description}" />&nbsp;<form:errors
									path="description" cssStyle="color:red;"></form:errors></td>
							<th>&nbsp;是否可用：</th>
							<td nowrap="nowrap" align="left"><select name="enabled"
								id="enabled"  style="width: 100px;">      
									<option value="true">可用</option>
									<option value="false">不可用</option>       
							</select> &nbsp; <form:errors path="enabled" cssStyle="color:red;"></form:errors>
							</td>
						</tr>
						<tr
							style="text-align: right; BACKGROUND-COLOR: #F4FAFF; font-weight: bold">
							<th>&nbsp;电话：</th>
							<td nowrap="nowrap" align="left"><form:input
									path="telephone" value="${user.telephone}" />&nbsp;<form:errors
									path="telephone" cssStyle="color:red;"></form:errors></td>
							<th>&nbsp;ip地址：</th>
							<td nowrap="nowrap" align="left"><form:input path="ip"
									value="${user.ip}" />&nbsp;<form:errors path="ip"
									cssStyle="color:red;"></form:errors></td>
							<th>&nbsp;是否锁定：</th>
							<td nowrap="nowrap" align="left"><select name="locked"
								id="locked" style="width: 100px;">      
									<option value="true">是</option>
									<option value="false">否</option>       
							</select>&nbsp;<form:errors path="locked"
									cssStyle="color:red;"></form:errors></td>
						</tr>
						<tr
							style="text-align: right; BACKGROUND-COLOR: #F4FAFF; font-weight: bold">
							<th>&nbsp;邮箱：</th>
							<td nowrap="nowrap" align="left"><form:input path="email"
									value="${user.email}" />&nbsp;<form:errors path="email"
									cssStyle="color:red;"></form:errors></td>
							<th>&nbsp;性别：</th>
							<td nowrap="nowrap" align="left"><select name="sex"
								id="sex" style="width: 100px;">      
									<option value="true">男</option>
									<option value="false">女</option>       
							</select>&nbsp;<form:errors path="sex"
									cssStyle="color:red;"></form:errors></td>
							<th>&nbsp;地址：</th>
							<td nowrap="nowrap" align="left"><form:input path="address"
									value="${user.address}" />&nbsp;<form:errors path="address"
									cssStyle="color:red;"></form:errors></td>
						</tr>
						<tr
							style="text-align: right; BACKGROUND-COLOR: #F4FAFF; font-weight: bold">
							<th style="width: 150px;">&nbsp;</th>
							<td style="text-align: left;" colspan="6"><input
								type="submit" value="保存" />&nbsp;&nbsp;<input type="button"
								value="返回"
								onclick="javascript:window.location.href='<%=basePath%>user'" /></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>