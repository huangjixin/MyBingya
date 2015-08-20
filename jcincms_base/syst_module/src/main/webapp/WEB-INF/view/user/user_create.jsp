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
	$('#userGroupIdInput').combobox({
		url:'<%=basePath%>menu/getMenu',
		valueField:'id',
		textField:'name',
		onSelect:function(node){
			var id = $('#userGroupIdInput').combobox('getValue');
			$('#userGroupId').val(id);
		}
		});
	<%-- $('#userGroupIdInput').combotree
    ({ 	url: '<%=basePath%>menu/getMenu',
			valuefield : 'id',
			textfield : 'name',
			required : false,
			editable : false,
			onClick : function(node) {
				/*  JJ.Prm.GetDepartmentUser(node.id, 'selUserFrom'); */
				$('#userGroupId').val(node.id);
			}, //全部折叠
			onLoadSuccess : function(node, data) {
				$('#userGroupIdInput').combotree('tree').tree("collapseAll");
			}
		}); --%>

	});
	
	function clearUserGroupIdInput(){
		$('#userGroupId').val('');
		$('#userGroupIdInput').combobox('clear');
	}
</script>
<title>user添加</title>
</head>
<body>
	<form:form id="validForm" action="createForm" method="post"
		commandName="user">
		<input type="hidden" name="step" value="1">
		<div class="desc">
			<b>用户信息添加</b>
		</div>
		<table width="100%" border="0" cellpadding="2" cellspacing="0">
			<tr>
				<td width="100%">
					<table border="0" cellpadding="3" cellspacing="1" width="100%"
						align="center" style="background-color: #b9d8f3;">
						<tr
							style="text-align: right; BACKGROUND-COLOR: #F4FAFF; font-weight: normal;">
							<th>&nbsp;用户名：</th>
							<td nowrap="nowrap" align="left"><form:input path="username"
									value="${user.username}" />&nbsp;<form:errors path="username"
									cssStyle="color:red;"></form:errors></td>
							<th>&nbsp;密码：</th>
							<td nowrap="nowrap" align="left"><form:password
									path="password" value="${user.password}" />&nbsp;<form:errors
									path="password" cssStyle="color:red;"></form:errors></td>
							<th>&nbsp;用户组ID：</th>
							<td nowrap="nowrap" align="left">
									<input id="userGroupIdInput"/>
									<form:hidden id="userGroupId"
									path="userGroupId" value="${user.userGroupId}" />&nbsp;
									<input type="button"
								value="清除"
								onclick="javascript:clearUserGroupIdInput();" />
							</td>
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
							<td nowrap="nowrap" align="left">
								<select name="enabled" id="enabled">       
										<option value="true">可用</option>
										<option value="false">不可用</option>       
									</select> &nbsp;
									<form:errors path="enabled" cssStyle="color:red;"></form:errors>
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
							<td nowrap="nowrap" align="left"><form:input path="locked"
									value="${user.locked}" />&nbsp;<form:errors path="locked"
									cssStyle="color:red;"></form:errors></td>
						</tr>
						<tr
							style="text-align: right; BACKGROUND-COLOR: #F4FAFF; font-weight: bold">
							<th>&nbsp;邮箱：</th>
							<td nowrap="nowrap" align="left"><form:input path="email"
									value="${user.email}" />&nbsp;<form:errors path="email"
									cssStyle="color:red;"></form:errors></td>
							<th>&nbsp;性别：</th>
							<td nowrap="nowrap" align="left"><form:input path="sex"
									value="${user.sex}" />&nbsp;<form:errors path="sex"
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